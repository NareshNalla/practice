# Hibernate Framework - Interview Notes

## 1. Hibernate Core Concepts

### What is Hibernate?
Hibernate is a pure Java object-relational mapping (ORM) and persistence framework. It simplifies database interaction by allowing you to map Plain Old Java Objects (POJOs) to relational database tables. Its main purpose is to free the developer from writing manual SQL and JDBC boilerplate code.

### Why use ORM tools like Hibernate?
- **Improved Productivity:** Shields developers from writing complex and repetitive SQL.
- **High-Level API:** Provides an object-oriented way to interact with the database.
- **Improved Performance:** Offers sophisticated caching (First and Second Level Caches), lazy loading, and eager loading strategies.
- **Database Independence:** Hibernate generates database-specific SQL using dialects, making it easy to switch between different relational databases (e.g., from MySQL to PostgreSQL) with minimal code changes.
- **Maintainability:** Reduces the amount of code to write and centralizes data access logic.

### What are the core interfaces of the Hibernate framework?
The five core interfaces used in most Hibernate applications are:
1.  **`SessionFactory`:** A thread-safe, heavyweight object created once per application. It's a factory for `Session` objects and holds second-level cache data.
2.  **`Session`:** A single-threaded, short-lived object that represents a conversation between the application and the database. It's the primary interface for persisting, retrieving, and querying objects. It holds the mandatory first-level cache.
3.  **`Transaction`:** A single-threaded, short-lived object used to define atomic units of work.
4.  **`Configuration`:** Used to configure and bootstrap Hibernate, including loading mapping files (`.hbm.xml`) or annotated classes. (Largely replaced by JPA's `persistence.xml` or Spring Boot's auto-configuration).
5.  **`Query` and `Criteria`:** Interfaces used to query the database using HQL or a programmatic, object-oriented API.

### What is the general flow of Hibernate's communication with a database?
1.  Load the Hibernate configuration (from `hibernate.cfg.xml`, JPA's `persistence.xml`, or Spring configuration).
2.  Create a `SessionFactory` from the configuration object.
3.  Obtain a `Session` from the `SessionFactory`.
4.  Begin a `Transaction`.
5.  Create and execute a query (HQL, Criteria, or Native SQL) or use session methods like `save()`, `update()`, `get()`.
6.  Commit the `Transaction`.
7.  Close the `Session`.

---

## 2. Hibernate Mapping & Operations

### How do you map Java Objects with Database tables?
- **Annotation-Based (Modern):** Use JPA annotations like `@Entity`, `@Table`, `@Id`, `@Column`, and relationship annotations (`@OneToMany`, etc.) directly on your POJO class.
- **XML-Based (Legacy):** Use an `.hbm.xml` mapping file to define the mapping between a Java class and a database table, and between object fields and table columns.

### What’s the difference between `load()` and `get()`?

| `load()` | `get()` |
| :--- | :--- |
| Returns a **proxy** object (a lightweight placeholder). | Hits the database immediately and returns the **real object**. |
| Throws an `ObjectNotFoundException` if the ID is not found **when the proxy is first accessed**. | Returns **`null`** if the ID is not found in the database. |
| Assumes the object exists. Use it when you are certain the ID is valid and just need a reference to it (e.g., to set a foreign key). | Does not assume the object exists. Use it when you need to check for an object's existence and retrieve it in one step. |

### What is the difference between `update()` and `merge()`?
- **`update()`:** Should be used on a detached object when you are sure that a persistent instance with the same identifier is **not** already in the session cache. If another object with the same ID is already in the session, it will throw an exception.
- **`merge()`:** Is more flexible. If an object with the same ID is already in the session, it merges the changes from the detached object into the attached one. If no object is in the session, it loads it from the database and then merges. Use `merge()` when you are unsure about the session's state.

### What are the different Hibernate instance states?
1.  **Transient:** The object has just been instantiated with `new` and is not associated with any Hibernate `Session`. It has no persistent representation in the database.
2.  **Persistent:** The object is associated with an active `Session`. Any changes made to it will be automatically detected and synchronized with the database when the transaction is committed (this is called "automatic dirty checking").
3.  **Detached:** The object was previously persistent, but the `Session` it was associated with has been closed. It still has a representation in the database, but it is no longer tracked by Hibernate.

### What is automatic dirty checking?
- A feature where Hibernate automatically detects changes made to a persistent object within a transaction.
- When the transaction is committed, Hibernate generates the necessary `UPDATE` SQL statements to synchronize the object's state with the database, without you needing to explicitly call `session.update()`.

---

## 3. Hibernate Querying

### What is Hibernate Query Language (HQL)?
- HQL is an object-oriented query language, similar to SQL, but it works with persistent objects and their properties instead of tables and columns.
- Example: `FROM User u WHERE u.name = :name`

### What are Named SQL Queries?
- A way to define a native SQL query in a central place (the mapping file or via annotations) and give it a name.
- You can then call this query by its name from your application code. This is useful for organizing complex SQL and for reusing queries.
- **Example:**
  ```xml
  <sql-query name="empdetails">
      <return alias="emp" class="com.test.Employee"/>
      SELECT emp.EMP_ID AS {emp.empid}, emp.EMP_NAME AS {emp.name}
      FROM Employee EMP WHERE emp.NAME LIKE :name
  </sql-query>
  ```

### Explain the Criteria API
- The Criteria API allows you to build queries programmatically by creating and chaining `Criterion` objects.
- It's a type-safe way to build dynamic queries where the conditions can vary at runtime (e.g., on a search screen with multiple optional filters).
- **Example:**
  ```java
  List employees = session.createCriteria(Employee.class)
      .add(Restrictions.like("name", "a%"))
      .addOrder(Order.asc("name"))
      .list();
  ```

---

## 4. Advanced Concepts

### What are the Collection types in Hibernate?
Hibernate can map most standard Java collections:
- **`Bag`:** An unordered list that allows duplicate elements. Maps to `<bag>`.
- **`Set`:** An unordered collection of unique elements. Maps to `<set>`.
- **`List`:** An ordered list that allows duplicates and is indexed. Maps to `<list>`.
- **`Array`:** A fixed-size collection of a specific type.
- **`Map`:** A collection of key-value pairs. Maps to `<map>`.

### Explain `cascade` and `inverse` in mappings.
- **`cascade`:** Determines how state changes are propagated from a parent entity to its associated child entities.
    - `cascade="save-update"`: When you save the parent, the children are saved too.
    - `cascade="delete"`: When you delete the parent, the children are deleted.
    - `cascade="all"`: Applies all cascade operations.
    - `all-delete-orphan`: When a child is removed from the parent's collection, it is also deleted from the database.
- **`inverse="true"`:** Used in a **bidirectional** relationship to designate which side is the "inverse" or "passive" side. Hibernate will **ignore** changes made to the inverse side when synchronizing the relationship with the database. This is a crucial optimization to prevent redundant SQL updates and to define a clear "owner" of the relationship.

### What is a Hibernate proxy?
- A Hibernate proxy is a lightweight placeholder object used to implement **lazy loading**.
- When you call `session.load()`, Hibernate doesn't hit the database immediately. Instead, it returns a dynamically generated proxy object that has the same interface as your entity class.
- The actual database query to load the object's data is only executed when you invoke a method on the proxy for the first time (other than the ID getter).

### What is the difference between sorted and ordered collections?
- **Sorted Collection (`sort` attribute):** The sorting is done **in-memory** by Java after the data is loaded from the database. It uses a `Comparator` or the natural ordering of the elements.
- **Ordered Collection (`order-by` attribute):** The sorting is done **in the database** by adding an `ORDER BY` clause to the SQL query. This is generally more efficient than in-memory sorting, especially for large collections.

### How does `HibernateTemplate` simplify Hibernate usage?
- `HibernateTemplate` is a helper class from the **Spring framework** (not core Hibernate).
- **Benefits:**
    - Simplifies common Hibernate operations into single method calls (e.g., `save`, `load`, `find`).
    - Automatically manages `Session` lifecycle (opening and closing).
    - Converts checked `HibernateException`s into Spring's unchecked `DataAccessException` hierarchy, which is easier to manage.
    - Note: In modern Spring applications using JPA and `@Transactional`, `HibernateTemplate` is rarely needed.
