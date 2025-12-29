Kafka:
Messaging
SpringBoot offers powerful support for message-driven architecture using brokers like RabbitMQ, Apache Kafka, JMS ( JAVA MESSAGE SERVICE). Messaging enables asynchronous communication, event-driven processing, and microservice decoupling.

1. RabbitMQ 
2. Kafka 
3. JMS Integration
4. Pubsub

KAFKA:
Kafka is a distributed streaming platform ,and is a publish-subscribe open-source messaging system
Kafka organizes data into categories called "topics" . Producers ( apps that send data) put messages into this topics, and Consumers ( apps that read data) receive them. Kafka
ensures that system is reliable and can keep working even if some parts fail.
Key components:
Producer: published messages to kafka topics
Consumer: Subscribes to topics and processes the published messages.
Consumer Group: consumers aare organized into consumer groups, each group processes a subset of partitions, allowing for parallel processing and load distribution.
Broker: ( brokers 3): A kafka server that stores and manages topics.(Leader broker) it receive messages from publishers and assign offsets to them,commits the messages to store on disk. it also services consumers for responding with messages. participate in the replication and distribution of data.
Zookeeper: Manages and coordinates Kafka brokers. centralized service maintaining configuration information, naming, providing distributes synchronization, and providing group services.  also it keep track of the status cluster nodes, Kafka topics and partitions. one consumer group can read from one partition( order ). zookeeper going to remove. 
Topics: A category or feed name to which records are published.  logical channels. topics can be divided into partitions for scalability and parallelism,
Partitions: Topics are divided into partitions for scalability. which are the basic unit for parallelism. Partitions allow kafka to distribute and parallelize the processing of messages.
Offsets: A offset is a unique identifier of a record with the partition. Kafka maintains this offset per partition per consumer group, each cg allowing each consumer group to read from a different position iun the partition this ensures Kafka to provide both Queue and pub-sub messaging models.
Offset management: Offset represent the position of the consumer within a partition. CConsumers commits offsets to Kafka, tracking their progress. This ensures that they can resume processing from the last commited offset in case of failures or restarts. ( order , replica)
Log compaction: Kafka supports log compaction, retaining only the latest message for each key in a partition. this is useful for scenarios where maintaining the latest state for a set of keys is critical.
Kafka Connect: (TO & FROM) framework for integrating kafka with external systems. It simplifies the development of connectors for ingesting data from or delivering data to various sources and sinks.
Kafka Streams:Stream processing library that allows developers to build real-time applications and microservices using kafka as the underlying data infrastructure.

offset commit done by consumers. partitions or disk spaces.
cluster: 
Topic Partitions replication: multiple replicas. One replica is designated as the leader, and others are followers

Kafka supports 3 message delivery semantics:
At most once: messages mau be lost but are never delivery
At least once:  Messages are never lost but they redeliver.
Exactly once: Each message is delivered exactly once and only one.this can be configure through producer and consumer settings

Architecture flow:
Producer writes to Leader:
Replica Synchronization:
ISR ( In-Sync Replicas): represents replicas that are up-to-date with the leader.
Consumer Reads from Leader:
Leader taks: Fault Tolerance, scalability
ZooKeeper Coordination:
Cluster coordination: Leader Election, Broker Registration and managment.
Topic and Partition Information.Consumer Group Management
Broker and Topic Health Monitoring.
starting 2.8.0 -> without zookeeper.

These methods are used to commit offsets in Kafka consumers:
commitSync(): Synchronously commits the latest offset returned by poll(). It will retry until it succeeds or encounters a non-retriable error.
commitAsync(): Asynchronously commits offsets. It doesn't retry on failures, making it faster but less reliable than commitSync(). The choice between these methods depends on the balance between performance and reliability required by the application.
