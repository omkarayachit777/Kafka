Reference link - https://www.youtube.com/watch?v=gpx7smdUkgU&t=12s

===================================================
✅ Kafka Consumer Group Rules
===================================================
1. One partition → One consumer (within a group)
   A partition is consumed by only one consumer at a time in the same group
   Ensures no duplicate processing

2. One consumer → Multiple partitions
   A single consumer can read multiple partitions
   👉 Example:
   1 consumer, 3 partitions → consumer reads all 3

3. Consumers ≤ Partitions (for full utilization)
   If consumers > partitions → extra consumers stay idle
   👉 Example:
   3 partitions, 5 consumers → 2 consumers idle

4. Consumers join → Rebalancing happens
   When a new consumer joins/leaves:
   Kafka redistributes partitions
   Called rebalancing

5. Different consumer groups are independent
   Multiple groups can read the same topic/partition
   👉 Example:
   Group A reads P1
   Group B can also read P1 (no conflict)

6. Order is guaranteed only within a partition
   Kafka guarantees ordering:
   ✅ Within a partition
   ❌ Not across partitions

7. Offset is maintained per consumer group
   Each group tracks its own offset
   👉 Meaning:
   Group A at offset 100
   Group B can still be at offset 20

8. Partitions define parallelism
   More partitions = more parallel consumers possible

9. At-least-once by default
   Kafka may re-deliver messages if failure happens
   Exactly-once requires extra configuration

Important Tip : In case of issues -- restart laptop & delete tmp folder under kafka directory (eg. if kafka is on D directory then D:\tmp to be removed)
===================================================
			Important commands
===================================================
👉 Firstly start zookeeper and then kafka server

zookeeper-server-start.bat zookeeper.properties

kafka-server-start.bat server.properties


👉 Create a topic with named mytopoic1 with 4 partitions ==>

kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --partitions 4 --replication-factor 2

NOTE - if two servers are running then and then only you can give replication-factor as 2


👉 To Describe partitions ===>

kafka-topics.bat --describe --topic my-topic --bootstrap-server localhost:9092


👉 To list down all the topics ===>

kafka-topics.bat --list --bootstrap-server localhost:9092


👉 To delete topic ==>

kafka-topics.bat --delete --topic mytopic1 --bootstrap-server localhost:9092
