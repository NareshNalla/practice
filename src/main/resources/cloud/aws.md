# AWS Interview Notes

## 1. IAM (Identity and Access Management)

**What is IAM?**
- IAM is AWS's service for managing access to AWS resources securely. It lets you create users, groups, and roles, and assign permissions using policies.

**Key Concepts:**
- **User:** Represents a person or service with long-term credentials.
- **Role:** An identity with specific permissions that can be assumed by users, services (like EC2/EKS), or external identities. Uses temporary credentials.
- **Policy:** A JSON document defining permissions, attached to users, groups, or roles.
- **Instance Profile:** Used to attach a role to an EC2 instance.

**Role vs Policy:**
- **Role:** Who/what can act (identity).
- **Policy:** What actions are allowed (permissions).

**Why IAM Role for EC2/EKS instead of access keys?**
- Roles provide temporary credentials, are more secure, and avoid hardcoding access keys. The AWS SDK fetches credentials automatically from the instance metadata service.

---

## 2. S3 (Simple Storage Service)

**What is S3?**
- S3 is AWS's object storage service for storing files, images, backups, and more. It is highly durable and accessible over HTTP.

**Key Features:**
- **Versioning:** Allows you to keep multiple versions of an object in a bucket, protecting against accidental deletion/overwrites.
- **Lifecycle Rules:** Automate moving data between storage classes (e.g., to Glacier) or deleting old versions/objects.
- **When to use S3 vs DB:**
    - Use S3 for unstructured data (files, images, logs, backups).
    - Use a database for structured, queryable data (relational or NoSQL).

---

## 3. EKS (Elastic Kubernetes Service)

**What is EKS?**
- EKS is AWS's managed Kubernetes service. It runs upstream Kubernetes, letting you deploy, manage, and scale containerized applications using standard K8s tools.

**Why EKS?**
- Offloads cluster management to AWS, integrates with IAM, VPC, and other AWS services, and provides high availability and scalability.

**Core Concepts:**
- **Pod:** The smallest deployable unit in Kubernetes, usually running one or more containers.
- **Service:** Exposes a set of Pods as a network service (ClusterIP, NodePort, LoadBalancer).
- **Ingress:** Manages external access (HTTP/HTTPS) to services in a cluster, often with routing and TLS termination.

**How is a Java app deployed on EKS?**
- Build a Docker image for the Java app.
- Push the image to ECR (Elastic Container Registry) or Docker Hub.
- Create Kubernetes manifests (Deployment, Service, Ingress).
- Apply manifests to the EKS cluster using `kubectl`.

---

## 4. SQS & SNS (Messaging & Integration)

**What is SQS?**
- SQS (Simple Queue Service) is a fully managed message queue for decoupling and buffering requests between microservices or distributed systems.

**What is SNS?**
- SNS (Simple Notification Service) is a pub/sub messaging service for sending notifications to multiple subscribers (Lambda, HTTP endpoints, SQS, email, etc.).

**SQS vs SNS:**
- **SQS:** Pull-based, decouples producers and consumers, used for queuing and load leveling.
- **SNS:** Push-based, used for broadcasting messages to multiple subscribers.

**FIFO vs Standard Queue (SQS):**
- **Standard Queue:** High throughput, best-effort ordering, at-least-once delivery.
- **FIFO Queue:** Preserves order, exactly-once processing, lower throughput.

**Dead Letter Queue (DLQ):**
- A secondary SQS queue for messages that can't be processed successfully after multiple attempts. Helps isolate and debug problematic messages.

---

## 5. Networking (VPC)

**What is a VPC?**
- A VPC (Virtual Private Cloud) is a logically isolated network in AWS where you launch resources. You define subnets, route tables, and gateways.

**Core Components:**
- **Subnets:** Ranges of IP addresses in a single AZ.
- **Route Tables:** Control traffic leaving subnets.
- **Internet Gateway (IGW):** Allows internet access for public subnets.
- **NAT Gateway:** Allows private subnets to access the internet securely.
- **Security Groups:** Stateful firewalls at the instance level.
- **NACLs:** Stateless firewalls at the subnet level.

---

## 6. Compute Services (EC2, ECS, Lambda)

**EC2:** Raw virtual machines (IaaS) for full OS/network control.
**ECS/EKS:** Container orchestration (ECS is AWS-native, EKS is managed Kubernetes).
**Lambda:** Serverless compute for event-driven, short-lived tasks.

---

## 7. Databases (RDS, DynamoDB)

**RDS:** Managed SQL databases (MySQL, PostgreSQL, Oracle, etc.).
**DynamoDB:** Managed NoSQL key-value/document store for high-scale, low-latency workloads.

---

## 8. Infrastructure as Code (CloudFormation, Terraform, CDK)

**CloudFormation:** AWS-native IaC service using JSON/YAML templates.
**Terraform:** Cloud-agnostic IaC tool.
**CDK:** Define infrastructure using programming languages (Java, TypeScript, etc.).

---

## 9. Scenario-Based Questions

### IAM
- How does AWS handle permissions compared to GCP? Explain IAM Roles vs. Users.
- Why IAM Role for EC2/EKS instead of access keys?
- Role vs Policy

### S3
- Versioning
- Lifecycle rules
- When to use S3 vs DB

### EKS
- Why EKS?
- Pods, Services, Ingress
- How Java app is deployed on EKS

### SQS / SNS
- SQS vs SNS
- FIFO vs Standard queue
- Dead Letter Queue (DLQ)

### VPC
- Explain the core components of a VPC (Virtual Private Cloud).
- Public vs. Private Subnets
- NAT Gateway
- Security Groups vs. NACLs

### Compute
- Compare EC2, ECS, and Lambda. When would you choose one over the others?

### Storage
- What is the difference between S3 and EBS?

### Databases
- Compare RDS and DynamoDB.

### Messaging
- What is the difference between SQS and SNS?

### IaC
- What is CloudFormation?

### Migration/Architecture
- You need to design a system to ingest high-volume clickstream data, process it, and store it for analytics. How would you do this on AWS?
- We have a monolithic Java application on-premise. We want to migrate it to AWS with minimal changes first, then modernize. What is your strategy?

---

## 10. Sample Deep-Dive Answers & Scenarios

### Clickstream Data Ingestion & Analytics
**The Architecture:**
1.  **Ingestion:** Use **Amazon Kinesis Data Streams** (equivalent to GCP Pub/Sub or Kafka) to capture the high-throughput data.
2.  **Processing:** Use **AWS Lambda** to process records from the stream in real-time (e.g., validation, enrichment). For complex, stateful processing, use **Kinesis Data Analytics** (equivalent to Dataflow/Apache Beam).
3.  **Storage:**
    *   **Hot/Recent Data:** Store in **DynamoDB** for fast, real-time access.
    *   **Archival/Analytics Data:** Use **Kinesis Data Firehose** to batch and write data directly to **S3**.
4.  **Analytics:** Use **Amazon Athena** to run ad-hoc SQL queries directly on the data in S3, or load it into **Amazon Redshift** (equivalent to BigQuery) for high-performance warehousing.

### Monolith to AWS Migration
**The Strategy (The "6 Rs" of Migration):**
1.  **Rehost ("Lift and Shift"):** Use **AWS Application Migration Service** to move the VM directly to **EC2**. This gets you into the cloud quickly.
2.  **Replatform:** Move the database to **RDS** to offload management. Use **Elastic Beanstalk** to manage the application deployment without changing the code significantly.
3.  **Refactor (Modernize):** Once stable, start breaking the monolith into microservices running on **ECS/Fargate** or **Lambda**. Replace synchronous calls with **SQS/SNS** for decoupling.
