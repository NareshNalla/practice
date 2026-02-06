# System Design Deep Dive: Database Scaling Strategies

## Caching Strategies
- **Cache-Hit:** Data is available in cache.
- **Cache-Miss:** Data is not available in cache.

## 7 Must-Know Strategies to Scale Your Database

### 1. Indexing
- **Concept:** Like a book index, database indexes allow fast data lookup without scanning every row (avoids full table scan).
- **Key Tool:** B-Tree Index (most common, sorted for fast range queries/lookups).
- **Trade-off:** Speeds up reads, but slows down writes (INSERT/UPDATE) due to index updates.

### 2. Materialized Views
- **Concept:** Pre-computed snapshots of data stored on disk for instant retrieval.
- **Use Case:** Heavy reporting/BI, aggregating millions of rows into summaries.
- **Trade-off:** Data can become stale; requires refresh strategy to stay up to date.

### 3. Denormalization
- **Concept:** Adds redundant data to avoid expensive JOINs between tables.
- **Example:** Storing author's name in the "Post" table instead of looking up in "User" table.
- **Trade-off:** Increases storage and makes consistency harder (must update in multiple places).

### 4. Vertical Scaling (Scaling Up)
- **Concept:** Increase server capacity (CPU, RAM, storage).
- **Pros:** Simple, no code changes.
- **Cons:** Hardware ceiling; single point of failure.

### 5. Caching
- **Concept:** Store frequently accessed data in high-speed memory (Redis, Memcached) to avoid database hits.
- **Use Case:** Movie metadata, user profiles, session info.
- **Trade-off:** Cache invalidation is hard; must update/clear cache on data changes to avoid stale info.

### 6. Replication
- **Concept:** Copies of primary database on multiple servers.
- **Methods:**
    - Synchronous: Primary waits for replicas to confirm write (high consistency, slower).
    - Asynchronous: Primary writes and moves on (faster, replicas may lag).
- **Benefits:** Distributes read load, high availability (failover).

### 7. Sharding
- **Concept:** Split database into horizontal pieces (shards), e.g., Users A-M in Shard 1, N-Z in Shard 2.
- **Benefit:** Enables horizontal scaling by adding servers; used by massive platforms.
- **Trade-off:** High complexity; cross-shard queries and re-sharding are challenging.
