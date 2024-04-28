package org.ippul.examples;

import org.ippul.examples.amq.clients.*;

public class Application {
    
    private static final String BROKER_URL = "tcp://ex-aao-hdls-svc:61616";

    public static void main(String[] args) throws Exception {
        final String worktype = System.getenv("WORK_TYPE");
        switch (worktype) {
            case "PRODUCER":
                new AMQProducer(BROKER_URL, "queue1", "ippul", "Pa$$w0rd").produce();
                System.exit(0);
                break;
            case "CONSUMER":
                new AMQConsumer(BROKER_URL, "queue1", "ippul", "Pa$$w0rd").consume();
                System.exit(0);
                break;
            default:
                System.err.println("Env variable 'WORK_TYPE' not recognised found '" + worktype + "' expected 'PRODUCER' or 'CONSUMER'");
                System.exit(1);
                break;
        }
    }
}
