Apache Beam
Apache Beam is a unified programming model to build batch and streaming data pipelines.
You write the pipeline once and run it on different runners like Google Dataflow, Spark, or Flink.
**We use Apache Beam because:**
- One API for both batch and streaming
- Handles out-of-order data
- Supports windowing and triggers
- Pipeline is portable across runners
- Easy to scale using managed runners like Dataflow

Apache Beam has four core concepts:
1. Pipeline
2. PCollection
3. PTransform
4. Runner

1. Pipeline
   A Pipeline represents the entire data processing workflow. It defines:
   - Data source
   - Transformations
   - Data sink
   ```json Read → Transform → Write```

2. PCollection

A PCollection is a distributed dataset in Apache Beam.
Key points:
- PCollection<T> is A logical multiset , Potentially infinite, With temporal semantics, 
- Can be bounded (batch) or unbounded (streaming)
- Immutable
- Data is processed in parallel
Example:
- Batch file → bounded PCollection
- Pub/Sub stream → unbounded PCollection

3. PTransform
   A PTransform is an operation applied on a PCollection to produce another PCollection.
   Examples:
   - ParDo
   - MapElements
   - GroupByKey
   - Combine

4. Runner
A Runner is responsible for executing the pipeline.
Examples:
- Google Dataflow
- Apache Spark
- Apache Flink
- DirectRunner (local testing)4. Runner

A Runner is responsible for executing the pipeline.

Examples:
- Google Dataflow
- Apache Spark
- Apache Flink
- DirectRunner (local testing)

Difference between Batch and Streaming in Beam?

Answer:

Batch	Streaming
Bounded data	Unbounded data
Finite dataset	Infinite data
No late data	Late data possible
Simple processing	Needs windowing

Beam supports both using the same API.

**ParDo**:
ParDo is the most common transformation in Beam.
It applies a user-defined function to each element.

Similar to:

map or flatMap

**GroupByKey**
GroupByKey groups values by key.

Used for:
Aggregations
Counting
Summarization

⚠️ Not recommended directly in streaming without windowing.
**Combine**
Combine is used for aggregation (sum, max, min, count).

Examples:

Combine.perKey

Combine.globally

More efficient than GroupByKey

How does Beam ensure fault tolerance?

Answer:

Checkpointing

Replay of data

Exactly-once semantics (with supported runners)

Idempotent writes
Each record is processed only once, even during retries or failures.

Important for:

Financial data

Aggregations

Beam vs Spark – Interview Answer

Answer:

Beam is a programming model

Spark is an execution engine

Beam pipelines can run on Spark

Beam vs Dataflow

Answer:

Beam → API & model

Dataflow → Managed execution service 

Shuffle, Fusion & Execution Graph
   Fusion

Beam fuses transforms to reduce overhead.

Over-Fusion Risks

Hot keys

Memory pressure

Reduced parallelism

Breaking Fusion

Reshuffle

Side inputs

External IO
GroupByKey vs Combine (Internal Cost)

GroupByKey:

Full shuffle

Materializes all values

Combine:

Tree aggregation

Partial combines

Less shuffle

Rule

GroupByKey is a correctness primitive
Combine is a performance primitive

Memory, Backpressure & Throughput

Backpressure comes from:

Slow sinks

Large state

Shuffle congestion

Dataflow mitigates via:

Dynamic work rebalancing

Autoscaling

Streaming Engine buffering

Metrics – What Actually Matters

Ignore:

Element count only

Track:

Watermark lag

State size

System lag

Backlog per key

Trigger firing frequency
Serialization & Coders (Often Ignored)

Coders affect:

Performance

Correctness

Compatibility

Rules:

Use deterministic coders

Avoid Java default serialization

Explicit coders for state