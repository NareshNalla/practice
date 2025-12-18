# Database, ORM, and Hibernate - Interview Notes

## 1. ORM & Hibernate Concepts

### What is ORM?
- **ORM** stands for Object-Relational Mapping.
- It's a programming technique for converting data between the object-oriented model in Java and the relational model in databases.
- It automates the mapping of Java objects to database tables, allowing developers to work with Java objects directly instead of writing boilerplate SQL. Hibernate is a popular ORM framework.

### How do you integrate Spring and Hibernate?
- Spring provides excellent integration support for Hibernate through its ORM module, most commonly via **Spring Data JPA**.
- **Configuration:** You define a `DataSource`, an `EntityManagerFactory`, and a `TransactionManager` in your Spring application context. Spring Boot simplifies this significantly with auto-configuration.
- **Usage:** You define a `Repository` interface (e.g., `UserRepository extends JpaRepository<User, Long>`), and Spring automatically provides the implementation for standard CRUD (Create, Read, Update, Delete) operations.

### What is a SessionFactory?
- A `SessionFactory` is a central, thread-safe, and immutable object responsible for creating `Session` instances in Hibernate.
- It is heavyweight and typically created only once per application during startup.
- It holds configuration details, connection pool information, and second-level cache data.

### What is Lazy Fetching?
- **Lazy Fetching** is a performance optimization strategy that delays the loading of associated data until you explicitly access it.
- By default in JPA/Hibernate:
    - **`@OneToMany` & `@ManyToMany`** associations are **LAZY**.
    - **`@ManyToOne` & `@OneToOne`** associations are **EAGER**.
- **Benefit:** When you load a `User` object, its list of `Orders` is not loaded from the database immediately. This avoids unnecessary, potentially large queries if you only need the user's primary data. The `Orders` are only fetched when you call `user.getOrders()`.

### Hibernate Annotations
- **`@Entity`:** Marks a Java class as a persistent entity that can be mapped to a database table.
- **`@Table(name="...")`:** Specifies the name of the database table the entity maps to.
- **`@Id`:** Declares the primary key field for the entity.
- **`@Column(name="...")`:** Specifies the mapping for a specific column.
- **`@Autowired` (Spring):** Used for dependency injection, not a Hibernate annotation, but often used in the same context to inject repositories.

### HBM (Hibernate Mapping) Files
- This is the older, XML-based way of defining object-relational mappings before annotations became standard.
- An `.hbm.xml` file explicitly links a Java class to a database table and defines how the class's fields map to the table's columns using tags like `<class>`, `<id>`, and `<property>`.

---

## 2. SQL & PL/SQL

### What is the structure of PL/SQL?
- PL/SQL uses a **block structure**. A typical block consists of:
    1.  **`DECLARE`:** (Optional) Where variables, cursors, and types are declared.
    2.  **`BEGIN`:** (Mandatory) Where the executable logic resides.
    3.  **`EXCEPTION`:** (Optional) Where errors that occur in the `BEGIN` block are handled.
    4.  **`END;`**: (Mandatory) Marks the end of the block.

### How are exceptions handled in Oracle (PL/SQL)?
- Exceptions are handled in the `EXCEPTION` section of a PL/SQL block.
- You can catch specific, named exceptions (e.g., `NO_DATA_FOUND`, `TOO_MANY_ROWS`) or use a general `WHEN OTHERS THEN` clause to catch all other errors.
