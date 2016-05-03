# Camel Cassandra Component Example

# Setting up the environment and running

This is a simple example of a Camel route based on the Camel-cassandra component (https://github.com/oscerd/camel-cassandra) I've developed.

To run this example you need to:

- Install Apache Cassandra from http://cassandra.apache.org/download/ . In my configuration I've used Apache Cassandra version 3.5.

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

[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Apache Camel 2.16.1 (CamelContext: camel-1) is starting
[andra.CamelCassandraApp.main()] ManagedManagementStrategy      INFO  JMX is enabled
[andra.CamelCassandraApp.main()] DefaultTypeConverter           INFO  Loaded 182 type converters
[andra.CamelCassandraApp.main()] DefaultRuntimeEndpointRegistry INFO  Runtime endpoint registry is in extended mode gathering usage statistics of all incoming and outgoing endpoints (cache limit: 1000)
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  AllowUseOriginalMessage is enabled. If access to the original message is not needed, then its recommended to turn this option off as it may improve performance.
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Route: route1 started and consuming from: Endpoint[timer://timer?fixedRate=true&period=10000&repeatCount=1]
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Total 1 routes, of which 1 is started.
[andra.CamelCassandraApp.main()] DefaultCamelContext            INFO  Apache Camel 2.16.1 (CamelContext: camel-1) started in 0.308 seconds
[l-1) thread #0 - timer://timer] NettyUtil                      INFO  Did not find Netty's native epoll transport in the classpath, defaulting to NIO.
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[l-1) thread #0 - timer://timer] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
Id: 73312620-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Prison Sex
Id: 7331c260-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Sober
Id: 73303bc0-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Intolerance
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[l-1) thread #0 - timer://timer] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
[l-1) thread #0 - timer://timer] DCAwareRoundRobinPolicy        INFO  Using data-center name 'datacenter1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[l-1) thread #0 - timer://timer] Cluster                        INFO  New Cassandra host /127.0.0.1:9042 added
Id: 73312620-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Prison Sex
Id: a4a8954b-42e2-4411-b3ea-ead93b03d56f - Album: Undertow - Title: Bottom
Id: 7331c260-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Sober
Id: 73303bc0-a8c6-11e5-b479-c98a9e63c0e2 - Album: Undertow - Title: Intolerance


```

- Press CTRL + C to stop the route

# The route

This route executes a select all on songs table in the simplex keyspace (only 3 songs are stored in the songs table at this point), then it executes an insert of one new song and then it executes another select all on the same table of same keyspace logging the result.
