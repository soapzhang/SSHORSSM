package com.soap.ssh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 点对点模式的消费者
 */
public class MessageReceive {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = null;
        Session session = null;
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(queue);
            while(true){
                TextMessage message = (TextMessage) consumer.receive();
                if(message!=null){
                    message.acknowledge();
                    System.out.println(Thread.currentThread().getName()+": Consumer:我是消费者，我正在消费Msg"+message.getText()+"--->");
                }else{
                    break;
                }
            }
            session.commit();
            session.close();
            connection.close();

        }catch (JMSException e){

        }
    }
}
