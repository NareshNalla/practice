# AWS

## 1. Foundational Concepts & IAM (Identity and Access Management)

### Q: "How does AWS handle permissions compared to GCP? Explain IAM Roles vs. Users."


"In AWS, **IAM (Identity and Access Management)** is the central service for controlling access. An **IAM User** represents a person or service with long-term credentials. An **IAM Role** is an identity with specific permissions that can be *assumed* by a user, a service (like an EC2 instance or Lambda function), or an external identity. Roles are the preferred way to grant permissions to applications because they use temporary security credentials."

**The Deeper, Interview-Level Explanation:**
*   **The Principle of Least Privilege:** Always grant only the permissions necessary to perform a task.
*   **Policies:** Permissions are defined in JSON documents called **Policies**. These policies are attached to Users, Groups, or Roles.
*   **Instance Profiles:** When an EC2 instance needs to access S3, you don't hardcode keys. You attach an IAM Role to the instance (via an Instance Profile). The AWS SDK automatically retrieves temporary credentials from the instance metadata service.
*   **GCP Comparison:** This is similar to GCP Service Accounts. Just as you assign a Service Account to a GCE instance or Cloud Function, you assign an IAM Role to an EC2 instance or Lambda function.

---

## 2. Networking (VPC)

### Q: "Explain the core components of a VPC (Virtual Private Cloud)."


"A **VPC** is a logically isolated section of the AWS cloud where you launch resources in a virtual network you define. It spans an entire **Region**. Within a VPC, you create **Subnets**, which are ranges of IP addresses that reside in a single **Availability Zone (AZ)**. You use **Route Tables** to control traffic leaving the subnets."

**The Deeper, Interview-Level Explanation:**
*   **Public vs. Private Subnets:**
    *   **Public Subnet:** Has a route to an **Internet Gateway (IGW)**. Resources here (like a Load Balancer) can send and receive traffic from the internet.
    *   **Private Subnet:** Does *not* have a direct route to the internet. Resources here (like backend servers or databases) cannot be reached directly from the outside.
*   **NAT Gateway:** To allow instances in a Private Subnet to access the internet (e.g., for software updates) without exposing them to inbound traffic, you place a **NAT Gateway** in a Public Subnet and route traffic from the Private Subnet through it.
*   **Security Groups vs. NACLs (Network ACLs):**
    *   **Security Groups:** Stateful firewalls at the **instance level**. If you allow an inbound request, the response is automatically allowed. (This is what you use 99% of the time).
    *   **NACLs:** Stateless firewalls at the **subnet level**. You must explicitly allow both inbound and outbound traffic. Used for broad, high-level blocking.

---

## 3. Compute Services

### Q: "Compare EC2, ECS, and Lambda. When would you choose one over the others?"


"**EC2** provides raw virtual machines (IaaS) giving you full control over the OS and networking. **ECS (Elastic Container Service)** is a container orchestration service for running Docker containers at scale. **Lambda** is a serverless compute service (FaaS) where you run code without provisioning servers."

**The Deeper, Interview-Level Explanation:**
*   **EC2 (Elastic Compute Cloud):**
    *   **Use Case:** Legacy applications, databases requiring specific OS tuning, or long-running stateful processes.
    *   **Scaling:** Handled by **Auto Scaling Groups (ASG)** based on metrics like CPU usage.
*   **ECS / EKS (Elastic Kubernetes Service):**
    *   **Use Case:** Microservices architectures. ECS is AWS-native and simpler; EKS is managed Kubernetes (standard K8s).
    *   **Fargate:** A "serverless" compute engine for containers. You just define the container requirements (CPU/RAM), and AWS runs it without you managing the underlying EC2 instances. This is very similar to **GCP Cloud Run**.
*   **Lambda:**
    *   **Use Case:** Event-driven tasks (file processing, stream processing), APIs with variable traffic, and glue code.
    *   **Limitations:** Execution time limit (15 mins), cold starts, and statelessness.

---

## 4. Storage Services

### Q: "What is the difference between S3 and EBS?"


"**S3 (Simple Storage Service)** is object storage, designed for storing vast amounts of unstructured data (files, images, backups) accessible via HTTP. **EBS (Elastic Block Store)** is block storage, which acts like a physical hard drive attached to a specific EC2 instance."

**The Deeper, Interview-Level Explanation:**
*   **S3:**
    *   **Durability:** 99.999999999% (11 9s). Data is replicated across multiple AZs.
    *   **Classes:** Standard (hot data), Intelligent-Tiering (auto-moves data), Glacier (archival/cold data).
    *   **GCP Equivalent:** Google Cloud Storage (GCS).
*   **EBS:**
    *   **Persistence:** It persists independently of the instance's life (unlike Instance Store/ephemeral storage).
    *   **Availability:** Replicated within a *single* AZ. To move data to another AZ, you must take a snapshot and restore it.
    *   **GCP Equivalent:** Persistent Disk.

---

## 5. Databases

### Q: "Compare RDS and DynamoDB."


"**RDS (Relational Database Service)** is a managed service for traditional SQL databases like MySQL, PostgreSQL, or Oracle. **DynamoDB** is a fully managed, serverless NoSQL key-value store designed for single-digit millisecond latency at any scale."

**The Deeper, Interview-Level Explanation:**
*   **RDS:**
    *   **Scaling:** Vertical scaling (bigger instance) is easy. Horizontal scaling (read replicas) is supported for reads. Multi-AZ deployments provide high availability and failover.
    *   **Aurora:** AWS's cloud-native relational database (MySQL/Postgres compatible) that auto-scales storage and offers much higher performance and durability than standard RDS.
    *   **GCP Equivalent:** Cloud SQL / Cloud Spanner (Aurora is closer to Spanner in terms of cloud-native design, but Spanner is globally distributed).
*   **DynamoDB:**
    *   **Scaling:** Scales horizontally automatically. You pay for throughput (Read/Write Capacity Units) or use On-Demand mode.
    *   **Data Model:** Schema-less (except for the Primary Key). Best for high-volume, simple queries.
    *   **GCP Equivalent:** Cloud Bigtable / Firestore.

---

## 6. Messaging & Integration

### Q: "What is the difference between SQS and SNS?"


"**SQS (Simple Queue Service)** is a message queue used to decouple components. It follows a **pull-based** model (consumers poll the queue). **SNS (Simple Notification Service)** is a pub/sub service. It follows a **push-based** model (messages are pushed to subscribers like Lambda, HTTP endpoints, or SQS queues)."

**The Deeper, Interview-Level Explanation:**
*   **SQS:**
    *   **Standard Queue:** Unlimited throughput, best-effort ordering, at-least-once delivery.
    *   **FIFO Queue:** Strictly preserves order and ensures exactly-once processing, but with lower throughput limits.
    *   **Use Case:** Buffering requests, load leveling, decoupling microservices.
*   **SNS:**
    *   **Fan-out Pattern:** A common pattern is to publish a message to an SNS topic, which then fans out to multiple SQS queues. This allows multiple services to process the same event asynchronously and independently.
    *   **GCP Equivalent:** Google Cloud Pub/Sub combines the features of both SNS and SQS into a single service.

---

## 7. Infrastructure as Code (IaC)

### Q: "What is CloudFormation?"


"**CloudFormation** is AWS's native Infrastructure as Code service. It allows you to define your AWS infrastructure in JSON or YAML templates. You submit the template to CloudFormation, and it provisions and configures the resources for you in a predictable, repeatable way."

**The Deeper, Interview-Level Explanation:**
*   **Stacks:** A collection of resources created by a template is called a Stack. You manage the stack as a single unit.
*   **Drift Detection:** CloudFormation can detect if resources have been modified manually outside of the template.
*   **Alternatives:** Many teams prefer **Terraform** (which you know) because it is cloud-agnostic, or **AWS CDK (Cloud Development Kit)**, which allows you to define infrastructure using actual programming languages like Java or TypeScript.

---

## 8. Scenario-Based Questions (Connecting to your Experience)

### Scenario: "You need to design a system to ingest high-volume clickstream data, process it, and store it for analytics. How would you do this on AWS?"

**The Architecture:**
1.  **Ingestion:** Use **Amazon Kinesis Data Streams** (equivalent to GCP Pub/Sub or Kafka) to capture the high-throughput data.
2.  **Processing:** Use **AWS Lambda** to process records from the stream in real-time (e.g., validation, enrichment). For complex, stateful processing, use **Kinesis Data Analytics** (equivalent to Dataflow/Apache Beam).
3.  **Storage:**
    *   **Hot/Recent Data:** Store in **DynamoDB** for fast, real-time access.
    *   **Archival/Analytics Data:** Use **Kinesis Data Firehose** to batch and write data directly to **S3**.
4.  **Analytics:** Use **Amazon Athena** to run ad-hoc SQL queries directly on the data in S3, or load it into **Amazon Redshift** (equivalent to BigQuery) for high-performance warehousing.

### Scenario: "We have a monolithic Java application on-premise. We want to migrate it to AWS with minimal changes first, then modernize. What is your strategy?"

**The Strategy (The "6 Rs" of Migration):**
1.  **Rehost ("Lift and Shift"):** Use **AWS Application Migration Service** to move the VM directly to **EC2**. This gets you into the cloud quickly.
2.  **Replatform:** Move the database to **RDS** to offload management. Use **Elastic Beanstalk** to manage the application deployment without changing the code significantly.
3.  **Refactor (Modernize):** Once stable, start breaking the monolith into microservices running on **ECS/Fargate** or **Lambda**. Replace synchronous calls with **SQS/SNS** for decoupling.
