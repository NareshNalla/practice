# Web Services - Interview Notes

## 1. SOAP vs. REST

### What is the difference between SOAP and REST?

| Feature | SOAP (Simple Object Access Protocol) | REST (REpresentational State Transfer) |
| :--- | :--- | :--- |
| **Type** | A standardized **protocol**. | An **architectural style**, not a protocol. |
| **Data Format** | Strictly permits **XML** only. | Flexible. Permits various formats like **JSON**, XML, HTML, plain text, etc. JSON is the most popular. |
| **Transport** | Can use any transport protocol (HTTP, SMTP, etc.). | Almost always uses **HTTP/HTTPS**. |
| **Standards** | Very strict standards (e.g., WSDL for service definition, built-in error handling). | No strict standards, relies on HTTP standards. It's more of a set of guiding principles. |
| **Security** | Has its own comprehensive security standard: **WS-Security**, which supports advanced enterprise features. | Inherits security from the underlying transport (HTTPS). Authentication is typically handled via tokens (e.g., JWT, OAuth). |
| **Performance** | Requires more bandwidth and resources due to the verbose XML structure and protocol overhead. | More performant and requires less bandwidth, especially when using lightweight formats like JSON. |
| **API** | The Java API is **JAX-WS**. | The Java API is **JAX-RS**. |
| **Paradigm** | Exposes **operations** or functions (like an RPC call). | Exposes **resources** (like data entities) that are acted upon by HTTP methods. |

### When to use SOAP vs. REST?
- **Use REST when:**
    - You are exposing a public API over the internet.
    - You need to support a wide range of clients, including browsers (which work well with JSON).
    - Performance and scalability are critical (REST reads can be cached).
    - Simplicity and ease of development are important.
- **Use SOAP when:**
    - You need enterprise-grade security features provided by **WS-Security**.
    - You require guaranteed reliability and messaging through **WS-ReliableMessaging**.
    - You need support for **ACID transactions** over a service (e.g., for banking or financial operations).

---

## 2. REST Concepts

### What does REST stand for?
- **RE**presentational **S**tate **T**ransfer.
    - **Representational:** How data is formatted (e.g., JSON, XML).
    - **State:** The data of a resource.
    - **Transfer:** How that data is communicated (using the HTTP protocol).

### Why are REST APIs stateless?
- **Statelessness** is a core constraint of REST.
- It means that each request from a client to the server must contain **all the information necessary** for the server to understand and process the request.
- The server does not store any session state or context about the client between requests. All session state is kept entirely on the client side.
- **Benefit:** This simplifies the server design, improves scalability (any server can handle any request), and enhances reliability.

### What are the standard HTTP Methods used in REST?
REST maps CRUD (Create, Read, Update, Delete) operations to HTTP methods:

- **`GET` (Read):** Retrieves a resource. It should be safe (no side effects) and idempotent (calling it multiple times has the same effect as calling it once).
- **`POST` (Create):** Creates a new resource on the server. It is not idempotent.
- **`PUT` (Update/Replace):** Updates an existing resource or creates it if it doesn't exist. It should be idempotent.
- **`DELETE` (Delete):** Removes a resource. It should be idempotent.
- **`OPTIONS`:** Used to get the supported operations on a resource.

### What is the difference between GET and POST?

| Feature | GET | POST |
| :--- | :--- | :--- |
| **Purpose** | To retrieve data. | To submit data to be processed (e.g., create or update a resource). |
| **Data Location** | Data is sent in the URL's query string. | Data is sent in the request body. |
| **Security** | Less secure; data is visible in the URL, browser history, and server logs. | More secure; data is not exposed in the URL. |
| **Data Size** | Limited by the maximum URL length. | Can send large amounts of data. |
| **Caching** | Can be cached by browsers and proxies. | Cannot be cached. |
| **Idempotent** | Yes (multiple identical requests have the same effect). | No (multiple identical requests may create multiple resources). |
| **Bookmarking** | Can be bookmarked. | Cannot be bookmarked. |

### What is HATEOAS?
- **HATEOAS** stands for **Hypermedia as the Engine of Application State**.
- It's a principle that a REST client should be able to navigate an entire application just by following hyperlinks provided in the API's responses.
- The server's response for a resource should contain links to other related actions or resources. For example, a response for a user's account might include links to "deposit-money", "withdraw-money", and "close-account".
- **Benefit:** This decouples the client from the server. The client doesn't need to hardcode all the API URIs; it can discover them dynamically from the server's responses.

---

## 3. Web & Network Concepts

### What is the difference between HTTP and HTTPS?
- **HTTP (Hypertext Transfer Protocol):** The standard protocol for exchanging data over the internet. It is unencrypted, meaning any data sent can be intercepted and read.
- **HTTPS (Hypertext Transfer Protocol Secure):** This is HTTP with an added layer of security. It uses **SSL/TLS** to encrypt the communication between the client (browser) and the server.
- **Key Benefits of HTTPS:**
    - **Encryption:** Protects data from being read by attackers.
    - **Integrity:** Ensures data has not been tampered with during transit.
    - **Authentication:** Verifies that you are communicating with the correct server.
    - **SEO:** Google and other search engines rank HTTPS sites higher.

### What is a Proxy Server?
- A proxy server acts as an intermediary between a client and another server.
- It receives requests from the client, forwards them to the destination server on the client's behalf, and then returns the response to the client.
- **Common Uses:**
    - **Caching:** To store frequently accessed content and reduce latency.
    - **Filtering:** To block access to certain websites (e.g., in a corporate network).
    - **Anonymity:** To hide the client's original IP address.

### Explain Client-Server Architecture
- A distributed application structure that partitions tasks between **servers** (providers of a resource or service) and **clients** (requesters of a service).
- The client initiates a request, and the server processes the request and returns a response.
- This model is the foundation of the web, where your browser is the client and the web server hosting a site is the server.

---

## 4. XML Parsing

### What is a SAX parser?
- **SAX** stands for **Simple API for XML**.
- It is an **event-based** parser for XML documents.
- **How it works:**
    1.  It reads the XML document sequentially from top to bottom.
    2.  It does **not** load the entire document into memory or create a parse tree (like a DOM parser does).
    3.  As it encounters different parts of the document (e.g., the start of an element, the end of an element, character data), it triggers "events."
    4.  The application provides "event handlers" (callback methods) that listen for these events and process the data as it streams in.
- **When to use it:** SAX is very memory-efficient and fast, making it ideal for parsing very **large XML files** that would not fit into memory.
