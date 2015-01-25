# Camel Cassandra Component Example

# Setting up the environment and running

This is a simple example of a Camel route based on the Camel-cassandra component (https://github.com/oscerd/camel-cassandra) I've developed.

To run this example you need to:

- Clone the project: https://github.com/oscerd/camel-cassandra

```shell

git clone https://github.com/oscerd/camel-cassandra.git

```

- Enter in the project directory and install to local repository: 

```shell

mvn install

```

- Install Apache Cassandra from http://cassandra.apache.org/download/ . In my configuration I've used Apache Cassandra version 2.1.2.

- Run Apache Cassandra by executing 

```shell

$CASSANDRA_HOME/bin/cassandra

```

- Run CQL console by executing 

```shell

$CASSANDRA_HOME/bin/cqlsh

```

- In CQL console run the following command (populate.cql is a cql file stored in `src/main/resources/cql/`)

```shell

SOURCE 'populate.cql'

```

- Clone the project this documentation refers to: https://github.com/oscerd/camel-cassandra-example

```shell

git clone https://github.com/oscerd/camel-cassandra-example.git

```

- Enter in the project directory and execute the following command:

```shell

mvn clean compile exec:java

```

- At this point you should see the camel route starting and logging information:

```shell

[andra.CamelCassandraApp.main()] MainSupport                    INFO  Apache Camel 2.14.1 starting
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Apache Camel 2.14.1 (CamelContext: camel-1) is starting
[andra.CamelCassandraApp.main()] ManagedManagementStrategy      INFO  JMX is enabled
[andra.CamelCassandraApp.main()] DefaultTypeConverter           INFO  Loaded 178 type converters
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  AllowUseOriginalMessage is enabled. If access to the original message is not needed, then its recommended to turn this option off as it may improve performance.
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Route: route1 started and consuming from: Endpoint[timer://timer?fixedRate=true&period=10000&repeatCount=1]
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Total 1 routes, of which 1 is started.
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Apache Camel 2.14.1 (CamelContext: camel-1) started in 0.325 seconds
[l-1) thread #0 - timer://timer] FrameCompressor                WARN  Cannot find Snappy class, you should make sure the Snappy library is in the classpath if you intend to use it. Snappy compression will not be available for the protocol.
[l-1) thread #0 - timer://timer] FrameCompressor                WARN  Cannot find LZ4 class, you should make sure the LZ4 library is in the classpath if you intend to use it. LZ4 compression will not be available for the protocol.
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[Cassandra Java Driver worker-0] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
Id: 9b732050-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Intolerance
Id: 9b7458d0-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Sober
Id: 9b73bc90-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Prison Sex
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[Cassandra Java Driver worker-0] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[Cassandra Java Driver worker-0] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
Id: 9b732050-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Intolerance
Id: 9b7458d0-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Sober
Id: f619ba7f-668f-4cb5-9f6e-613a274f176f - Album: Undertow - Title: Bottom
Id: 9b73bc90-a4a5-11e4-b41f-e15e042f3dd3 - Album: Undertow - Title: Prison Sex

```

- Press CTRL + C to stop the route

# The route

This route executes a select all on songs table in the simplex keyspace (only 3 songs are store in Cassandra instance at this point), then it executes an insert of one new song and it executes another select all on the same table of same keyspace logging the result.
