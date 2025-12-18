### **Tell me about yourself and your work.**

**Situation:**

I am a hands-on software engineer with strong experience in building and stabilizing large-scale data ingestion and processing systems. At Equifax, I have been working on the Data Ingestion System and "purposing services," which are critical for continuous data ingestion and downstream analytics.

**Task:**

My primary responsibility was to ensure these services were robust, scalable, and met strict SLAs, especially under heavy production loads. I also contributed to documentation, DevOps, and QA automation to support the team's delivery.

Specifically, I led efforts to identify and eliminate recurring out-of-memory failures in production. This involved refactoring memory management and implementing graceful shutdown mechanisms. I also updated routing logic to support new environment configurations, improved error logging, and enabled better test coverage. Alongside these tasks, I supported the team with SRE responsibilities, dependency management, and technical documentation.

**Result:**

As a result of these efforts, our services became much more stable, with significantly reduced downtime and improved latency. The team could scale the platform confidently, and we successfully met our performance and reliability targets. My work also enabled faster onboarding for new team members and smoother production releases.

---
### **Difficult Task & Production Issue**

**Situation:**

Recently, our Data Ingestion and Purposing services began facing frequent Out-of-Memory (OOM) errors in production, leading to severe latency and unpredictable outages. This became a major blocker for business unit operations and feature rollouts.

**Task:**

I was tasked with stabilizing these services, eliminating the OOM failures, and ensuring the system could handle peak loads without performance degradation.

**Action:**

First, I analyzed JVM heap dumps and application logs to pinpoint memory leaks, which were primarily related to Bigtable client connections. I then refactored the code to reduce unnecessary in-memory data copies, fixed the connection leaks, and transitioned internal calls to more efficient gRPC protocols. I also implemented a self-destruct mechanism for pods to ensure graceful recovery and further optimized the code for better memory usage.

**Result:**

After these changes, OOM errors were completely eliminated in both performance tests and production. Unplanned pod restarts dropped significantly, and latency remained stable even during peak loads. This allowed the business to rely on the platform for critical data ingestion, which not only improved system health but also reduced operational overhead for the team.

---
### **Project: Chaining Feature for Purposed Views**

**Situation:**

Commercial clients needed the ability to chain multiple data processing workflows together automatically. The existing system required manual intervention for each step, which was inefficient and error-prone.

**Action:**

I designed and led the implementation of a new "chaining" capability. This involved creating a robust system that could define, execute, and monitor a sequence of dependent processing jobs. I authored an Architecture Decision Record (ADR) to document the design, outlining the trade-offs and ensuring alignment across technical and business teams.

**Result:**

The new Purposed View chaining capability was successfully rolled out, enabling clients to automate complex data workflows with confidence. This enhancement improved system flexibility, reduced manual intervention, and opened up new commercial opportunities for the business. The ADR became a key reference point for future architectural enhancements, and the approach was praised by stakeholders for its clarity and robustness.

---
My Daily BAU, I as a teammember
### **Project: Job Management V2**

**Situation:**

Our data platform was handling increasingly complex data processing pipelines, especially for business unit workflows. However, we lacked a unified orchestration and monitoring solution, which led to operational blind spots, delayed incident response, and made it difficult to guarantee SLAs for our commercial clients.

**Action:**

I took the lead in designing and implementing a new orchestration and monitoring framework. The solution provided real-time visibility into pipeline job statuses and enabled automated management of job lifecycles, from triggering to completion and error handling.

**Result:**

The new framework was successfully implemented and significantly reduced the need for manual intervention. It improved our SLA adherence and empowered the operations team to respond to issues proactively rather than reactively. The solution was well-received by both engineering and business stakeholders and set a new standard for operational excellence on our data platform.
