Organized Notes on Computer Science, Algorithms, and System Design

===================================================================================
 1. ALGORITHMS & DATA STRUCTURES
===================================================================================

-----------------------------------------------------------------------------------
 1.1. Graph Algorithms
-----------------------------------------------------------------------------------

### Johnson's Algorithm
- **Use Case:** Finds all-pairs shortest paths in a sparse, weighted, directed graph.
- **Advantage:** Can handle negative edge weights, unlike running Dijkstra from every node.
- **Method:**
  1. Re-weighting: Use Bellman-Ford to find a transformation of the graph that removes all negative weights.
  2. Run Dijkstra from each vertex on the transformed graph.
- **Complexity:** O(V^2 log V + VE)

### All Simple Cycles in a Graph (Johnson's Algorithm for Cycles)
- **Goal:** Find all elementary circuits (simple cycles) in a directed graph.
- **Method:** A backtracking, depth-first search approach. It uses a `stack` to keep track of the current path, a `blocked` set to mark visited nodes, and a `blocked map` to handle cycles that are found but need to be revisited from different paths.
- **Key Idea:** To find simple cycles, a node must not be visited more than once in the current path, except for the start/end node of the cycle.
- **Reference:** https://www.youtube.com/watch?v=johyrWospv0

### Dijkstra's Algorithm
- **Use Case:** Finds the shortest path from a single source to all other vertices in a graph with **non-negative** edge weights.
- **Why it fails with negative edges:** Dijkstra's is a greedy algorithm. It assumes that once it finds the shortest path to a vertex, it's final. A negative edge could later provide a "shortcut" to a vertex that has already been finalized, which Dijkstra's algorithm doesn't revisit.

### Bellman-Ford Algorithm
- **Use Case:** Finds the shortest path from a single source to all other vertices, and it **can handle negative edge weights**.
- **Method:** It relaxes all edges V-1 times. A Vth iteration can be performed to detect negative weight cycles.
- **Complexity:** O(VE)

### Prim's Algorithm (Minimum Spanning Tree - MST)
- **Goal:** Find a subset of edges that connects all vertices together with the minimum possible total edge weight.
- **Method:** A greedy algorithm that grows the MST from a single starting vertex. At each step, it adds the cheapest edge that connects a vertex in the MST to a vertex outside the MST.
- **Constraint:** The graph must be connected.
- **Complexity:** O(E log V) with a priority queue.

### Kruskal's Algorithm (Minimum Spanning Tree - MST)
- **Goal:** Same as Prim's.
- **Method:** Also greedy. It sorts all edges by weight and adds them to the MST as long as they don't form a cycle. Uses a Union-Find data structure to detect cycles efficiently.
- **Advantage:** Can work with disconnected graphs (finds a minimum spanning forest).
- **Complexity:** O(E log E) due to sorting the edges.

### Kosaraju's Algorithm (Strongly Connected Components - SCCs)
- **Goal:** Find all strongly connected components in a directed graph. An SCC is a subgraph where every vertex is reachable from every other vertex.
- **Method:**
  1. Perform a DFS on the graph to compute finishing times for each vertex.
  2. Compute the transpose (reverse all edges) of the graph.
  3. Perform a DFS on the transpose graph, visiting vertices in decreasing order of their finishing times from step 1. Each tree in the resulting DFS forest is an SCC.
- **Complexity:** O(V+E)

### Tarjan's Algorithm
- Another algorithm for finding SCCs and can also be used for topological sorting. Often considered slightly more efficient in practice than Kosaraju's.

### Topological Sort
- **Use Case:** For a Directed Acyclic Graph (DAG), it's a linear ordering of vertices such that for every directed edge from vertex `u` to vertex `v`, `u` comes before `v` in the ordering.
- **Application:** Task scheduling, dependency resolution (e.g., course prerequisites, build systems).

### Cycle Detection in a Graph
- **Undirected Graph:** Use a Union-Find data structure. If you try to union two vertices that are already in the same set, you've found a cycle.
- **Directed Graph:** Use DFS with a color-coding system (white for unvisited, gray for visiting, black for visited). If you encounter a gray node during DFS, you've found a cycle.

-----------------------------------------------------------------------------------
 1.2. Dynamic Programming (DP)
-----------------------------------------------------------------------------------

### Core Idea of Dynamic Programming
- Break down a problem into smaller, overlapping subproblems.
- Solve each subproblem only once and store its result (memoization or tabulation).
- Use the stored results to solve larger subproblems.

### Longest Increasing Subsequence (LIS)
- **Goal:** Find the length of the longest subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest.
- **O(n^2) Approach:** `dp[i]` stores the length of the LIS ending at index `i`. To compute `dp[i]`, iterate from `j=0` to `i-1` and find `dp[i] = 1 + max(dp[j])` where `arr[j] < arr[i]`.
- **O(n log n) Approach:** A more optimized approach that maintains an auxiliary array (e.g., `tails`) where `tails[i]` is the smallest tail of all increasing subsequences of length `i+1`.

### Longest Common Subsequence (LCS)
- **Goal:** Find the length of the longest subsequence common to two sequences.
- **Method:** `dp[i][j]` stores the length of the LCS of `X[0..i-1]` and `Y[0..j-1]`.
  - If `X[i-1] == Y[j-1]`, then `dp[i][j] = 1 + dp[i-1][j-1]`.
  - Else, `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.
- **LCS of 3 arrays:** Extends the 2D DP table to a 3D table. Complexity becomes O(n^3).

### Longest Common Palindromic Subsequence
- **Trick:** This is simply the LCS of the given string and its reverse.

### Knapsack Problem (0/1)
- **Goal:** Given items with weights and values, find the maximum total value you can carry in a knapsack of capacity W. You can either take an item or leave it.
- **Method:** `dp[i][w]` is the maximum value that can be attained with a weight limit of `w` using items up to `i`.
  - `dp[i][w] = max(val[i-1] + dp[i-1][w-wt[i-1]], dp[i-1][w])`.

### Maximum Sum Rectangle in a 2D Matrix
- **Method:** Fix the left and right columns and calculate the sum of elements in each row for the chosen columns. This reduces the problem to finding the maximum sum subarray in a 1D array (Kadane's Algorithm). Iterate this for all possible left and right column pairs.
- **Complexity:** O(cols^2 * rows)

### Regex & Wildcard Pattern Matching
- These are classic DP problems where the state `dp[i][j]` typically represents whether the first `i` characters of the text match the first `j` characters of the pattern.

-----------------------------------------------------------------------------------
 1.3. String Algorithms
-----------------------------------------------------------------------------------

### KMP (Knuth-Morris-Pratt) Algorithm
- **Use Case:** Efficiently finds occurrences of a pattern within a text.
- **Key Idea:** Avoids re-comparing characters by using a precomputed "prefix function" or LPS (Longest Proper Prefix which is also Suffix) array. When a mismatch occurs, the LPS array tells you how many characters to shift the pattern forward without losing a potential match.
- **Complexity:** O(m+n) where m is pattern length and n is text length.

### Rabin-Karp Algorithm
- **Use Case:** Pattern searching using a rolling hash.
- **Method:**
  1. Calculate the hash of the pattern.
  2. "Roll" through the text, calculating the hash of each substring of the pattern's length in O(1) time.
  3. If the hashes match, perform a character-by-character comparison to confirm (to handle hash collisions).
- **Complexity:** Average case O(m+n), worst case (many collisions) O(mn).

### Boggle (Word Search in a Grid)
- **Method:** A classic backtracking problem. Use a Trie to store the dictionary of valid words. Perform a DFS from each character in the grid, building up a prefix. Check if the prefix exists in the Trie. If it does, continue the search. If it's a full word, add it to the results.

-----------------------------------------------------------------------------------
 1.4. Array & Matrix Problems
-----------------------------------------------------------------------------------

### Trapping Rain Water
- **Goal:** Given an elevation map (an array of non-negative integers), compute how much water it can trap after raining.
- **O(n) space approach:** Precompute two arrays: `left_max[i]` (max height to the left of `i`) and `right_max[i]` (max height to the right of `i`). The water trapped at `i` is `min(left_max[i], right_max[i]) - height[i]`.
- **O(1) space approach (Two Pointers):**
  - Use two pointers, `lo` at the start and `hi` at the end.
  - Maintain `left_max` and `right_max` as you go.
  - If `arr[lo] < arr[hi]`, the water level is limited by the left side. If `arr[lo]` is greater than `left_max`, update `left_max`. Otherwise, add `left_max - arr[lo]` to the result. Move `lo` pointer.
  - Do the symmetric operation for the `hi` pointer.

### Majority Element (Moore's Voting Algorithm)
- **Goal:** Find the element that appears more than n/2 times in an array.
- **Method:**
  1. Initialize a `candidate` and a `count`.
  2. Iterate through the array. If `count` is 0, set the current element as the `candidate` and `count` to 1.
  3. If the current element is the same as the `candidate`, increment `count`. Otherwise, decrement `count`.
  4. The `candidate` at the end is a potential majority element. A second pass is needed to verify if its frequency is > n/2.
- **Complexity:** O(n) time, O(1) space.

### Find Repeating Numbers in O(n) time and O(1) space
- **Problem:** Given an array of n elements from 0 to n-1, find repeating numbers.
- **Method (using array as a hash map):**
  - Iterate through the array. For each element `arr[i]`, go to the index `abs(arr[i])`.
  - If the value at that index `arr[abs(arr[i])]` is positive, make it negative.
  - If it's already negative, it means you've seen this number before, so it's a duplicate.

### Minimum Jumps to Reach End
- A classic greedy or DP problem.
- **Greedy O(n) approach:**
  - `maxReach`: The farthest we can get from the current position.
  - `steps`: The number of steps we can still take.
  - `jumps`: The number of jumps we've made.
  - Iterate through the array, updating `maxReach`. When `steps` runs out, you must make a jump, so increment `jumps` and set `steps` to the new `maxReach` from your previous position.

-----------------------------------------------------------------------------------
 1.5. Linked Lists
-----------------------------------------------------------------------------------

### Clone a Linked List with Random Pointers
- **O(n) space:** Use a HashMap to map original nodes to their copies. First pass creates copies and populates the map. Second pass sets the `next` and `random` pointers using the map.
- **O(1) space:**
  1. **Weave:** Create a copy of each node and insert it immediately after the original node. (e.g., A -> B becomes A -> A' -> B -> B').
  2. **Set Random Pointers:** Iterate through the woven list. For each original node `curr`, its copy's random pointer is `curr.copy.random = curr.random.next`.
  3. **Unweave:** Separate the original and copied lists back into two distinct lists.

### XOR Linked List
- A memory-efficient doubly linked list. Instead of storing two pointers (`prev` and `next`), it stores a single `npx` field which is the XOR of the previous and next node's addresses.
- `node.npx = addr(prev) ^ addr(next)`
- Traversal requires knowing the address of the previous node to figure out the next one: `addr(next) = addr(prev) ^ node.npx`.

### Detect a Loop (Floyd's Cycle-Finding Algorithm)
- **Method:** Use two pointers, a `slow` pointer that moves one step at a time, and a `fast` pointer that moves two steps at a time.
- If they meet, there is a loop.
- **Finding the start of the loop:** After they meet, move the `slow` pointer back to the head. Keep the `fast` pointer where it is. Now move both pointers one step at a time. The point where they meet again is the start of the loop.

-----------------------------------------------------------------------------------
 1.6. Trees
-----------------------------------------------------------------------------------

### AVL Trees
- A self-balancing Binary Search Tree (BST).
- **Property:** The heights of the two child subtrees of any node differ by at most one.
- **Balancing:** Achieved through rotations (LL, LR, RR, RL rotations) after insertions or deletions that violate the height property.

### B-Trees
- A self-balancing tree data structure that maintains sorted data and allows searches, sequential access, insertions, and deletions in logarithmic time.
- Optimized for systems that read and write large blocks of data (like disks). Databases and filesystems often use B-Trees or variants.

### Construct a BST from Preorder Traversal
- **Method:**
  1. The first element of the preorder traversal is the root.
  2. All elements smaller than the root belong to the left subtree, and all elements larger belong to the right subtree.
  3. Recursively build the left and right subtrees from the partitioned preorder array.
  - **Optimization:** Instead of re-scanning, pass min/max bounds to the recursive function to know which part of the array belongs to the current subtree.

### Skyline Problem
- A classic divide and conquer problem.
- **Method:**
  1. Divide the set of buildings into two halves.
  2. Recursively find the skyline for each half.
  3. Merge the two skylines. The merge step is the crucial part, where you iterate through both skylines with two pointers, a`djusting the height and creating new key points for the merged skyline.

-----------------------------------------------------------------------------------
 1.7. Heaps & Priority Queues
-----------------------------------------------------------------------------------

### Building a Heap
- **From scratch (inserting one by one):** O(n log n). Each insertion can take O(log n).
- **Heapify (from an existing array):** O(n). This is more efficient. It works bottom-up. Starting from the last non-leaf node, it calls `heapify` (or `siftDown`) on each node. The work done at each level is less than the work done at the levels below, and the sum of the work is linear.

### Heapsort
1. Build a max-heap from the input data: O(n).
2. Repeatedly extract the maximum element from the heap (which is the root) and place it at the end of the array. Then, repair the heap. This takes n-1 extractions.
3. Each extraction involves swapping the root with the last element and calling `heapify` on the new root. This takes O(log n).
- **Total Complexity:** O(n + n log n) = O(n log n).

-----------------------------------------------------------------------------------
 1.8. Bit Manipulation
-----------------------------------------------------------------------------------

### Find if a String has Duplicate Characters
- **Problem:** Check for duplicates using only an array (or integer).
- **Method:** Use a bitmask. An `int` has 32 bits. If you're dealing with only lowercase English letters (26 characters), you can use a single integer as a bitmask.
  - For each character `c`, calculate its offset from 'a' (`val = c - 'a'`).
  - Check if the `val`-th bit is set in your integer mask (`if (mask & (1 << val)) > 0`). If it is, you've seen this character before.
  - If not, set the bit (`mask |= (1 << val)`).

### Number of Trailing Zeroes in a Factorial
- **Key Idea:** Trailing zeroes are formed by factors of 10, which is 2 * 5. The number of 5s will always be the limiting factor.
- **Method:** The count is the number of times 5 is a factor in all numbers from 1 to n.
  - `count = floor(n/5) + floor(n/25) + floor(n/125) + ...`

-----------------------------------------------------------------------------------
 1.9. Puzzles & Brain Teasers
-----------------------------------------------------------------------------------

### Egg Dropping Puzzle
- **Problem:** Find the minimum number of drops in the worst case to determine the critical floor from which an egg will break, given N eggs and K floors.
- **This is a DP problem.** `dp[n][k]` = minimum number of trials in worst case with `n` eggs and `k` floors.
- `dp[n][k] = 1 + min(max(dp[n-1][x-1], dp[n][k-x]))` for `x` from 1 to `k`.

### Two Ropes Puzzle
- **Problem:** Measure exactly 15 minutes using two ropes that each burn for 1 hour but at an uneven rate.
- **Solution:**
  1. Light rope #1 from both ends and rope #2 from one end simultaneously.
  2. Rope #1 will finish burning in exactly 30 minutes.
  3. At that moment, light the other end of rope #2. Since half of rope #2 has burned in 30 minutes, the remaining half will burn in 15 minutes when lit from both ends.

### Chessboard and Dominos
- **Problem:** Can you cover an 8x8 chessboard with two diagonally opposite corners removed using 31 dominos?
- **Solution:** Impossible. A standard chessboard has 32 white and 32 black squares. Removing two diagonally opposite corners removes two squares of the *same color*. This leaves 32 squares of one color and 30 of the other. Each domino must cover one white and one black square. Therefore, 31 dominos can only cover 31 white and 31 black squares, which doesn't match the board.

### Five and Three Quart Jugs
- **Problem:** Get exactly four quarts of water with a 5-quart and a 3-quart jug.
- **Solution:**
  1. Fill the 5-quart jug.
  2. Pour from the 5-quart jug to fill the 3-quart jug. (5-quart now has 2 quarts).
  3. Empty the 3-quart jug.
  4. Pour the 2 quarts from the 5-quart jug into the 3-quart jug. (3-quart now has 2 quarts).
  5. Fill the 5-quart jug again.
  6. Pour from the 5-quart jug to fill the remaining 1-quart space in the 3-quart jug.
  7. The 5-quart jug now has exactly 4 quarts.

===================================================================================
 2. SYSTEM DESIGN & NETWORKING
===================================================================================

-----------------------------------------------------------------------------------
 2.1. Core Networking
-----------------------------------------------------------------------------------

### TCP (Transmission Control Protocol)
- **Connection-Oriented:** Establishes a connection via a three-way handshake.
  1. **SYN:** Client sends a synchronization packet to the server.
  2. **SYN-ACK:** Server acknowledges the request and sends its own SYN packet.
  3. **ACK:** Client acknowledges the server's packet, and the connection is established.
- **Reliable:** Guarantees that data is delivered in order and without errors. If a packet is lost, it is re-transmitted.

### UDP (User Datagram Protocol)
- **Connectionless:** Sends packets (datagrams) without establishing a connection.
- **Unreliable:** No guarantee of delivery, order, or error checking. It's "fire and forget."
- **Use Cases:** Fast-paced applications where speed is more critical than reliability, like video streaming, online gaming, and DNS.

### HTTP (Hypertext Transfer Protocol)
- An application-layer protocol for transmitting hypermedia documents, such as HTML.
- **Stateless:** Each request from a client to a server is treated as an independent transaction. The server does not keep any state information about the client between requests.
- **Stateful Sessions:** To create a stateful experience (like a login session), HTTP uses mechanisms like:
  - **Cookies:** Small pieces of data stored on the client's browser. The server sends a cookie, and the browser sends it back with every subsequent request to that server.
  - **Sessions:** Server-side storage of user data, identified by a session ID which is often stored in a client-side cookie.

### DNS (Domain Name System)
- The phonebook of the Internet. It translates human-readable domain names (e.g., `www.google.com`) into machine-readable IP addresses.
- **Process:**
  1. Request goes to a Root Server.
  2. Root server directs to a Top-Level Domain (TLD) server (e.g., for `.com`).
  3. TLD server directs to the authoritative domain's name server (e.g., `quora.com`'s server).
  4. The authoritative server returns the final IP address.
  -it calls actually when we type. . (dot at end .com.) - root  (ROOT NS)
  check internal os cache  - next ip address name serevers TLD nameservers - topleveldomain. resolving NS( Authorative NS). domain register helps to find this route.
     resolving NS -> Root NS -> TLD NS -> Authorative NS
### Subnetting
- **Purpose:** Divides a large network into smaller, more manageable logical networks (subnets).
- **Subnet Mask:** A 32-bit number that defines the range of IP addresses available within a network. `255` corresponds to `11111111`.
- **CIDR Notation:** e.g., `172.16.250.0/24`. The `/24` means the first 24 bits are fixed for the network address, leaving the remaining 8 bits (32-24) for host addresses.
- **Communication:**
  - Devices on the same subnet can communicate directly.
  - Devices on different subnets need a **Router** to communicate.

### Network Devices
- **Hub:** A basic device that receives a packet and broadcasts it to *every* other device connected to it. (Layer 1)
- **Switch:** A smarter hub. It learns the MAC addresses of the devices connected to its ports. When it receives a packet, it forwards it only to the intended destination port, reducing network traffic. (Layer 2)
- **Router:** Connects different networks (subnets) together. It makes decisions on where to forward packets based on IP addresses and routing tables. (Layer 3)

### NAT (Network Address Translation)
- **Purpose:** Allows multiple devices in a private network (using private IP ranges like `10.x.x.x`, `172.16.x.x`, `192.168.x.x`) to share a single public IP address.
- **How it works:** The router maintains a NAT table that maps internal `IP:port` combinations to the public `IP:port`. When a packet returns, the router looks up the mapping and forwards it to the correct internal device.

-----------------------------------------------------------------------------------
 2.2. Web Architecture & Scalability
-----------------------------------------------------------------------------------

### Load Balancer
- **Purpose:** Distributes incoming network traffic across multiple backend servers to ensure no single server becomes a bottleneck.
- **Benefits:** Increases reliability, availability, and scalability.
- **Health Checks:** Load balancers frequently perform health checks on servers. If a server fails a health check, it's removed from the pool of available servers.
- **Sticky Sessions (Session Affinity):** A mechanism to ensure that all requests from a specific user during a session are sent to the same server. This is important for applications that store session data in the server's memory.
  - **Cookie-based:** The load balancer inserts a cookie to identify the server, and subsequent requests with that cookie are routed back to it.
  - **Drawback:** If that specific server goes down, the session data is lost.

### Proxy Server
- An intermediary server that sits between a client and the internet.
- **Functions:**
  - **Caching:** Caches frequently accessed content to speed up requests.
  - **Filtering:** Can block access to certain websites.
  - **Anonymity:** Hides the client's public IP address.

### Nginx
- A high-performance web server, reverse proxy, and load balancer.
- **Static vs. Dynamic Content:** Nginx is extremely efficient at serving static content (HTML, CSS, images). For dynamic content (requiring application logic), it typically acts as a reverse proxy, forwarding the request to an application server (like one running uWSGI or Gunicorn).
- **Worker Processes:** The number of workers should be tuned based on the workload.
  - **CPU-bound:** Number of workers ≈ Number of CPU cores.
  - **I/O-bound:** Number of workers ≈ 1.5x to 2x the number of CPU cores.

### uWSGI
- An application server that can run Python web applications.
- **uwsgi protocol:** A binary protocol used for communication between a web server (like Nginx) and a uWSGI server. It's generally faster than communicating over HTTP.
- **Typical Setup:** `Client -> Nginx (HTTP) -> uWSGI Server (uwsgi protocol) -> Python App`

### Sockets (Socket Programming)
- **Purpose:** Enables real-time, two-way communication between a client and a server.
- **Mechanism:** A persistent connection is established and remains open, allowing the server to "push" data to the client without the client having to poll for it.
- **vs. REST API:** REST is stateless and client-driven (pull). Sockets are stateful and server-driven (push).
- **Use Cases:** Chat applications, live notifications, real-time GPS tracking, streaming video.

### CDN (Content Delivery Network) - e.g., AWS CloudFront
- A geographically distributed network of proxy servers.
- **Purpose:** Caches static content (images, CSS, JS, videos) at "edge locations" closer to users around the world.
- **Benefit:** Drastically reduces latency for users, as they fetch content from a nearby edge server instead of the origin server.

-----------------------------------------------------------------------------------
 2.3. Security
-----------------------------------------------------------------------------------

### HTTPS (HTTP Secure)
- HTTP combined with SSL/TLS encryption. It ensures that communication between your browser and the website is encrypted, confidential, and integral.
- **Port:** 443

### SSL/TLS (Secure Sockets Layer / Transport Layer Security)
- The cryptographic protocols that provide security for HTTPS.
- **Handshake Process (Simplified):**
  1. **Client Hello:** Browser sends a request to connect.
  2. **Server Hello:** Server responds with its SSL certificate.
  3. **Certificate Verification:** The browser checks if the certificate is valid and issued by a trusted Certificate Authority (CA). It also checks if the certificate is for the correct domain.
  4. **Key Exchange:** The browser and server use the public key from the certificate to securely negotiate a symmetric "session key". This is an example of **asymmetric cryptography** (public/private key pair).
  5. **Encrypted Session:** All further communication is encrypted using the shared symmetric session key. This is **symmetric cryptography**, which is much faster than asymmetric.
- **SSL Termination:** The process of decrypting an incoming HTTPS request at the load balancer. The load balancer then communicates with the backend servers over unencrypted HTTP. This offloads the computationally expensive decryption work from the application servers.

### SSH (Secure Shell)
- A cryptographic network protocol for operating network services securely over an unsecured network.
- Also uses a public-private key pair system for authentication.

### CORS (Cross-Origin Resource Sharing)
- A browser security feature that restricts web pages from making requests to a different domain than the one that served the page.
- To allow cross-origin requests, the server at the requested domain must include specific CORS headers (like `Access-Control-Allow-Origin`) in its response.

### VPN (Virtual Private Network)
- Encrypts your internet traffic and routes it through a server in a location of your choice, hiding your IP address and online activity from your ISP.

===================================================================================
 3. DATABASES
===================================================================================

-----------------------------------------------------------------------------------
 3.1. Database Concepts
-----------------------------------------------------------------------------------

### SQL vs. NoSQL
- **SQL (Relational Databases):**
  - **Structure:** Structured data, predefined schema (tables, columns, types).
  - **Scaling:** Traditionally scales vertically (increase power of a single server).
  - **Use Cases:** Applications requiring strong consistency, complex queries, and transactions (e.g., financial systems, e-commerce backends).
- **NoSQL (Non-relational Databases):**
  - **Structure:** Dynamic schema (JSON-like documents, key-value pairs, wide-column stores).
  - **Scaling:** Scales horizontally (distribute load across many servers).
  - **Use Cases:** Big data, real-time applications, content management, applications with unstructured or rapidly changing data. Good for fields that contain arrays.

### Database Normalization
- **Purpose:** To organize columns and tables in a relational database to minimize data redundancy.
- **First Normal Form (1NF):**
  - Each cell must contain a single, atomic value (no arrays or lists).
  - Each record must be unique (usually via a primary key).
- **Second Normal Form (2NF):**
  - Must be in 1NF.
  - All non-key attributes must be fully dependent on the primary key. This means breaking out tables for data that doesn't depend on the whole key (in case of a composite key).
- **Third Normal Form (3NF):**
  - Must be in 2NF.
  - No transitive dependencies. A non-key attribute cannot depend on another non-key attribute.

### Joins
- **Nested Loop Join:** For every row in the outer table, scan every row in the inner table. Very slow. O(N*M).
- **Hash Join:** Build a hash table on the smaller table's join key. Then iterate through the larger table, probing the hash table for matches. Efficient for equi-joins.
- **Merge Join (External Mergesort):** Sort both tables on the join key. Then, merge them in a single pass. Very efficient if the tables are already sorted or can be sorted quickly.

### Indexing
- **Purpose:** To speed up the retrieval of rows from a database table. An index is a data structure (commonly a B-Tree) that stores a small portion of the table's data in a sorted order.
- **Types of Indexes:**
  - **B-Tree Index:** The default for most databases. Good for range queries (`>`, `<`, `BETWEEN`).
  - **Hash Index:** Good only for equality comparisons (`=`).
  - **Full-text Index:** For searching text within fields.
  - **Sparse Index:** Only includes entries for documents that have the indexed field. Saves space if a field is often missing.
  - **Bitmap Index:** Good for columns with low cardinality (few unique values, like gender or status). Uses a bit array to represent the presence of a value.
  - **Multikey Index (MongoDB):** Indexes array fields. Creates an index entry for each element in the array.

-----------------------------------------------------------------------------------
 3.2. Java Database Notes
-----------------------------------------------------------------------------------

### HashMap vs. Hashtable vs. ConcurrentHashMap
- **Hashtable:** Synchronized (thread-safe). All methods are locked, which can cause performance bottlenecks in highly concurrent applications. Does not allow null keys or values.
- **HashMap:** Not synchronized (not thread-safe). Allows one null key and multiple null values. Faster than Hashtable for single-threaded access.
- **ConcurrentHashMap:** The preferred choice for multi-threaded applications. It provides thread safety without locking the entire map. It locks only portions ("segments" or "bins") of the map, allowing multiple threads to access different parts concurrently.


===================================================================================
 4. DEVOPS & CLOUD
===================================================================================

-----------------------------------------------------------------------------------
 4.1. Containerization
-----------------------------------------------------------------------------------

### Docker
- **Purpose:** A platform for developing, shipping, and running applications in containers.
- **Container:** A lightweight, standalone, executable package that includes everything needed to run a piece of software: code, runtime, system tools, libraries, and settings.
- **`CMD` vs. `ENTRYPOINT`:**
  - **`CMD`:** Provides default arguments for an executing container. Can be easily overridden from the `docker run` command line. `docker run <image> ls -l` overrides the `CMD`.
  - **`ENTRYPOINT`:** Configures a container that will run as an executable. It's harder to override. Arguments from `docker run` are appended to the `ENTRYPOINT`.
  - **Best Practice:** Use `ENTRYPOINT` for the main command and `CMD` for the default arguments. `ENTRYPOINT ["ping"]`, `CMD ["localhost"]`.
- **`docker exec`:** Runs a new command inside an *already running* container.
- **`docker attach`:** Connects your terminal's standard input, output, and error to a running container.
- **Volumes:** The preferred mechanism for persisting data generated by and used by Docker containers. Volumes are managed by Docker and stored in a dedicated part of the host filesystem (`/var/lib/docker/volumes/`).
- **Docker Networking:**
  - **Bridge Network:** The default. All containers on the same host can communicate with each other.
  - **Overlay Network:** A distributed network that can span multiple Docker hosts, enabling containers on different hosts to communicate directly. Used by Docker Swarm.

### Kubernetes (K8s)
- **Purpose:** An open-source container orchestration system for automating application deployment, scaling, and management.
- **Key Concepts:**
  - **Pod:** The smallest deployable unit in Kubernetes. It's a group of one or more containers that share storage and network resources.
  - **Node:** A worker machine in a Kubernetes cluster. Pods run on nodes.
  - **Service:** An abstraction that defines a logical set of Pods and a policy by which to access them. Provides a stable IP address and DNS name for a group of pods, enabling load balancing.
  - **Manager Node:** Controls the cluster. It has components like the API server, scheduler (assigns pods to nodes), and controller manager.

### Docker Swarm
- Docker's native container orchestration tool.
- **Manager Node:** Manages the cluster and dispatches tasks to worker nodes. Leader election occurs if a manager fails.
- **Worker Node:** Executes the tasks (containers) assigned by the manager.

-----------------------------------------------------------------------------------
 4.2. CI/CD (Continuous Integration / Continuous Deployment)
-----------------------------------------------------------------------------------

### Core Concepts
- **Continuous Integration (CI):** The practice of merging all developers' working copies to a shared mainline several times a day. Each merge triggers an automated build and test run.
- **Continuous Deployment (CD):** The practice of automatically deploying every change that passes the CI stage to production.

### Jenkins
- A popular open-source automation server used to implement CI/CD pipelines.
- **Pipeline:** A suite of plugins that supports implementing and integrating continuous delivery pipelines into Jenkins.
- **Functionality:** Can be used to automatically build, test, and deploy applications. It integrates with a vast ecosystem of tools via plugins.
- **vs. other tools (Puppet, Ansible, Terraform):** Jenkins is the *orchestrator* that triggers the process. Tools like Ansible and Terraform are used for *infrastructure as code* (IaC) to provision and configure the environments that Jenkins deploys to.

-----------------------------------------------------------------------------------
 4.3. AWS (Amazon Web Services)
-----------------------------------------------------------------------------------

### Core Infrastructure
- **Region:** A physical geographic location in the world (e.g., `us-east-1`).
- **Availability Zone (AZ):** One or more discrete data centers within a Region. Each AZ has redundant power, networking, and connectivity.
- **VPC (Virtual Private Cloud):** A logically isolated section of the AWS Cloud where you can launch AWS resources in a virtual network that you define. It's region-wide.
- **Subnet:** A range of IP addresses in your VPC. A subnet must reside in a single AZ.
  - **Public Subnet:** Has a route to an Internet Gateway.
  - **Private Subnet:** Does not have a direct route to the internet. To access the internet, it needs to go through a NAT Gateway located in a public subnet.
- **Internet Gateway (IGW):** A horizontally scaled, redundant, and highly available VPC component that allows communication between your VPC and the internet.
- **NAT Gateway:** Enables instances in a private subnet to connect to the internet or other AWS services, but prevents the internet from initiating a connection with those instances.

### Compute Services
- **EC2 (Elastic Compute Cloud):** Virtual servers in the cloud.
- **ECS (Elastic Container Service):** A highly scalable, high-performance container orchestration service that supports Docker containers.
- **Lambda:** A serverless compute service that lets you run code without provisioning or managing servers. You pay only for the compute time you consume.

### Storage Services
- **S3 (Simple Storage Service):** Object storage service. Highly scalable, durable, and available. Used for backups, data archives, and hosting static assets.
- **Glacier:** A low-cost storage service for data archiving and long-term backup.
- **EBS (Elastic Block Store):** Provides persistent block storage volumes for use with EC2 instances. Like a virtual hard drive.

### Database Services
- **RDS (Relational Database Service):** A managed service for relational databases like MySQL, PostgreSQL, Oracle, etc.
- **DynamoDB:** A fully managed, highly scalable NoSQL key-value and document database.
- **Redshift:** A fast, fully managed data warehouse.
- **ElastiCache:** A managed in-memory data store and cache service (supports Redis and Memcached).

### Networking & Content Delivery
- **Route 53:** A scalable Domain Name System (DNS) web service. Can be used for domain registration, DNS routing, and health checking.
  - **Routing Policies:** Simple, Weighted, Latency-based, Failover, Geolocation.
- **CloudFront:** AWS's Content Delivery Network (CDN).
- **Application Load Balancer (ALB):** A Layer 7 load balancer that routes traffic based on the content of the request (e.g., URL path, hostname). Fully integrated with ECS.
- **VPC Peering:** A networking connection between two VPCs that enables you to route traffic between them using private IP addresses.
