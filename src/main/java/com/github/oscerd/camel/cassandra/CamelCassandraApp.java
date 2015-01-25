package com.github.oscerd.camel.cassandra;

import org.apache.camel.main.Main;

public class CamelCassandraApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new CamelCassandraRouteBuilder());
        main.run(args);
    }

}

