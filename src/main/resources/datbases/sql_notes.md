# SQL and Database Concepts - Interview Notes

## 1. ORM (Object-Relational Mapping)

### What is ORM?
- **ORM** stands for Object-Relational Mapping.
- It is a programming technique for converting data between the object-oriented model used in an application (like Java objects) and the relational model used in a database (tables and rows).
- **Purpose:** It automates the persistence of objects, allowing developers to work with high-level objects instead of writing low-level JDBC and SQL code.

### What are the main components of an ORM solution?
An ORM solution typically consists of:
1.  An API for performing basic CRUD (Create, Read, Update, Delete) operations on objects.
2.  An API or language (like HQL or JPQL) to express queries in an object-oriented way.
3.  A facility to specify metadata that maps objects and their properties to database tables and columns (either via annotations or XML).
4.  Optimization features like caching, lazy loading, and dirty checking to improve performance.

### What are the different levels of ORM?
ORM can be viewed in different levels of abstraction:
1.  **Pure Relational:** Manually writing SQL, often using stored procedures. No real ORM.
2.  **Light Object Mapping:** Using a thin layer over JDBC that maps result sets to objects, but still requires manual SQL (e.g., Spring's `JdbcTemplate`).
3.  **Medium Object Mapping:** Maps objects to tables but may not support complex relationships like inheritance or composition.
4.  **Full Object Mapping:** A complete ORM solution (like Hibernate) that handles complex object models, including inheritance, composition, polymorphism, and persistence by reachability.

### What is the advantage of Hibernate over plain JDBC?
| Hibernate (ORM) | JDBC (Java Database Connectivity) |
| :--- | :--- |
| **Abstraction:** High-level, object-oriented API. | **Abstraction:** Low-level API that is closely tied to SQL. |
| **Code:** Less code to write; boilerplate is handled by the framework. | **Code:** Requires a lot of boilerplate code for connection management, statement creation, and `ResultSet` handling. |
| **Query Language:** Provides HQL/JPQL, an object-oriented query language. | **Query Language:** Requires manual, database-specific SQL. |
| **Portability:** Database independent. Can switch databases with minimal configuration changes. | **Portability:** SQL queries may need to be rewritten for different databases. |
| **Performance:** Includes built-in caching (first and second level) and other performance optimizations. | **Performance:** No built-in caching. Performance is entirely dependent on manually written queries. |
| **Error Handling:** Wraps JDBC exceptions into a hierarchy of unchecked `RuntimeException`s. | **Error Handling:** Deals with checked `SQLException`s, which can be cumbersome. |
