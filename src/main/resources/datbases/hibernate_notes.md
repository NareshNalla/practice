# Hibernate: Expert Interview Notes

This document provides a structured and deep-dive guide to key Hibernate concepts, organized for a technical interview.

===================================================================================
## 1. Core Concepts & Architecture
===================================================================================

### What is Hibernate?
Hibernate is a high-performance, open-source **Object-Relational Mapping (ORM)** framework for Java. Its primary purpose is to map Java objects to relational database tables, allowing developers to interact with the database using object-oriented paradigms instead of writing manual, low-level JDBC and SQL code.

### Why use an ORM tool like Hibernate over plain JDBC?
- **Productivity:** It drastically reduces boilerplate code for CRUD operations and connection management.
- **Database Independence:** By using **Hibernate Dialects**, it can generate database-specific SQL, allowing you to switch underlying databases (e.g., from MySQL to PostgreSQL) with minimal configuration changes.
- **Object-Oriented Querying:** Provides HQL (Hibernate Query Language), which allows you to write queries against your Java objects and properties instead of database tables and columns.
- **Performance Optimizations:** Includes a sophisticated, multi-level **caching** mechanism, and supports performance patterns like **lazy loading**.
- **Maintainability:** Centralizes data access logic and promotes a cleaner separation of concerns.

### What are the core interfaces of the Hibernate framework?
1.  **`Configuration`:** (Legacy) Used to configure and bootstrap Hibernate by loading mapping files and properties. In modern applications, this is largely handled by JPA's `persistence.xml` or Spring Boot's auto-configuration.
2.  **`SessionFactory`:** A heavyweight, thread-safe, and immutable object that is created once per application. It acts as a factory for `Session` objects and holds second-level cache data and pre-compiled mapping metadata.
3.  **`Session`:** A lightweight, single-threaded, short-lived object that represents a single unit of work with the database. It is the primary interface for all persistence operations and holds the mandatory **first-level cache**.
4.  **`Transaction`:** An API for managing database transactions (begin, commit, rollback) for a `Session`.
5.  **`Query` and `Criteria`:** Interfaces used to execute HQL, Native SQL, or build programmatic, type-safe queries.

===================================================================================
## 2. Session, Objects, and State Management
===================================================================================

### What are the different Hibernate instance states?
An entity instance in Hibernate exists in one of three states:
1.  **Transient:** The object has just been instantiated (`new User()`) and is not associated with any Hibernate `Session`. It has no database identity.
2.  **Persistent:** The object is associated with an active `Session`. Any changes made to it will be automatically detected and synchronized with the database upon transaction commit (this is called **automatic dirty checking**).
3.  **Detached:** The object was previously persistent, but the `Session` it was associated with has been closed. It still has a database identity, but it is no longer tracked by Hibernate.

### What’s the difference between `load()` and `get()`?

| `load()` | `get()` |
| :--- | :--- |
| **Lazy Loading:** Returns a lightweight **proxy** object without hitting the database. | **Eager Loading:** Hits the database immediately and returns the **real object**. |
| **Exception on Not Found:** Throws an `ObjectNotFoundException` if the ID is not found, but only when the proxy is first accessed. | **Returns Null:** Returns `null` if the ID is not found in the database. |
| **Use Case:** Use when you are certain the object exists and just need a reference to it (e.g., to set a foreign key on another object). | **Use Case:** Use when you need to check for an object's existence and retrieve its data in one step. |

### What is the difference between `update()`, `merge()`, and `saveOrUpdate()`?
- **`update()`:** Takes a detached object and makes it persistent. It will throw an exception if another object with the same identifier is already in the session cache. Use it when you are sure the session does not contain a persistent instance.
- **`merge()`:** The most flexible option. It takes a detached object and merges its state into the corresponding persistent object within the session. If no persistent object exists, it will load it from the database first. Use `merge()` when you are unsure about the session's state.
- **`saveOrUpdate()`:** If the object is transient, it calls `save()`. If the object is detached, it calls `update()`.

### What is automatic dirty checking?
A key Hibernate feature where it automatically detects changes made to the state of a persistent object within a transaction. When the transaction is committed, Hibernate generates the necessary `UPDATE` SQL statements to synchronize the state with the database, without requiring the developer to explicitly call `update()`.

===================================================================================
## 3. Mapping & Relationships
===================================================================================

### What are the main ways to map entities?
- **Annotation-Based (Modern):** Using JPA annotations like `@Entity`, `@Table`, `@Id`, `@Column`, and relationship annotations (`@OneToMany`, etc.) directly on your POJO class. This is the standard approach.
- **XML-Based (Legacy):** Using an `.hbm.xml` mapping file to define the mapping between a Java class and a database table.

### What are the inheritance models in Hibernate?
1.  **Table per Class Hierarchy (Single Table):** All classes in the hierarchy are mapped to a single table, which includes a "discriminator" column to identify the specific subclass.
2.  **Table per Subclass (Joined):** The base class has its own table, and each subclass has its own table containing only its specific fields, linked by a foreign key to the base table.
3.  **Table per Concrete Class:** Each class in the hierarchy has its own complete table, including all fields from its superclasses.

### Explain `cascade` and `inverse` in associations.
These attributes are crucial for managing relationships between entities.
- **`cascade`:** Determines how state changes (like save, update, delete) are propagated from a parent entity to its associated child entities.
    - `cascade=CascadeType.ALL`: Propagates all operations.
    - `cascade=CascadeType.PERSIST`: When you save the parent, the children are saved too.
    - `orphanRemoval=true`: A JPA feature (similar to Hibernate's `all-delete-orphan`) that deletes a child from the database when it is removed from the parent's collection.
- **`inverse="true"` (Hibernate-specific) / `mappedBy` (JPA):** In a **bidirectional** relationship, this attribute designates one side as the "inverse" or "passive" side. It tells Hibernate which side **does not** manage the relationship. This is a critical optimization to prevent redundant SQL updates and to define a clear "owner" of the foreign key column.

===================================================================================
## 4. Fetching & Querying
===================================================================================

### What is a fetching strategy?
A fetching strategy is the strategy Hibernate will use for retrieving associated objects when an application navigates an association.
- **Lazy Fetching:** Delays the loading of associated data until it is explicitly accessed. This is the default for collections (`@OneToMany`, `@ManyToMany`) and is generally preferred for performance.
- **Eager Fetching:** Loads associated data immediately along with the parent object. This is the default for single-point associations (`@ManyToOne`, `@OneToOne`) and can lead to performance issues (N+1 problems) if not used carefully.

### What is a Hibernate proxy?
A Hibernate proxy is a lightweight placeholder object used to implement lazy loading. When you call `session.load()`, Hibernate returns a dynamically generated proxy object instead of hitting the database. The actual database query is only executed when you invoke a method on the proxy for the first time (other than the ID getter).

### What is the difference between sorted and ordered collections?
- **Sorted Collection (`@SortComparator`):** The sorting is done **in-memory** by Java after the data is loaded from the database, using a specified `Comparator`.
- **Ordered Collection (`@OrderBy`):** The sorting is done **in the database** by adding an `ORDER BY` clause to the SQL query. This is generally more efficient.

### What are the main ways to query in Hibernate?
1.  **HQL (Hibernate Query Language):** An object-oriented query language that works with entity names and properties instead of tables and columns.
2.  **Criteria API:** A programmatic, type-safe API for building dynamic queries by composing `Criterion` objects.
3.  **Native SQL:** Allows you to execute raw SQL queries directly, which is useful for database-specific features or complex queries that are hard to express in HQL. **Named Queries** can be used to centralize these native queries in mapping files or annotations.

===================================================================================
## 5. Performance & Integration
===================================================================================

### What is the N+1 Selects Problem?
A common performance issue where Hibernate executes one initial query to fetch a list of parent entities, and then executes **N** additional queries to fetch the lazy-loaded collections for each of the **N** parent entities. This can be solved by using a `JOIN FETCH` in your HQL query or by using batch fetching.

### What is the difference between the first- and second-level caches?
- **First-Level Cache (Session Cache):**
    - Scoped to a single `Session`. It is mandatory and always enabled.
    - When you retrieve an entity multiple times within the same session, Hibernate will return the same cached instance without hitting the database again.
- **Second-Level Cache:**
    - Scoped to the entire `SessionFactory`, meaning it is shared across all sessions.
    - It is optional and must be explicitly configured with a cache provider (like Ehcache or Hazelcast).
    - It is used to cache frequently read, rarely updated data to reduce database traffic across the entire application.

### How does `HibernateTemplate` simplify Hibernate usage?
- `HibernateTemplate` is a helper class from the **Spring Framework**.
- **Benefits:** It simplifies common Hibernate operations into single method calls, automatically manages `Session` lifecycle, and converts checked `HibernateException`s into Spring's unchecked `DataAccessException` hierarchy.
- **Note:** In modern Spring applications using JPA and `@Transactional` with dependency injection, `HibernateTemplate` is rarely needed.
