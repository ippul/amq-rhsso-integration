package org.apache.activemq.artemis;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import javax.jms.*;

public class AMQConsumer {

    private static final String BROKER_URL = "tcp://ex-aao-hdls-svc:61616";
    public static void main(String[] args) throws Exception {
        consumeMessageAs("queue1", "ippul", "Pa$$w0rd");
    }

    public static void consumeMessageAs(final String destinationName, final String username, final String password) throws JMSException, InterruptedException {
        try(final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL, username, password);
            final Connection connection = connectionFactory.createConnection();){      
            connection.start();
            try(final Session session  = connection.createSession();
                final MessageConsumer consumer = session.createConsumer(session.createQueue("queue1"));){
                for(int count = 0; count < 10_000_000; count ++) {
                    final Message message = consumer.receive(10000);
                    String messageBody = message.getBody(String.class);
                    System.out.println("Message body: " + messageBody);
                    message.acknowledge();
                    Thread.sleep(1000l);
                }
            }
        }
    }
}
