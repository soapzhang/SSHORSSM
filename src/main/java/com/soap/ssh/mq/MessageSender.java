package com.soap.ssh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 新建一个生产者
 */
public class MessageSender {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = null;
        Session session =null;
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("myQueue");//创建队列
            MessageProducer producer = session.createProducer(queue);
            for (int i = 0; i < 9; i++) {
                TextMessage textMessage = session.createTextMessage("Hello:" + i);
                producer.send(textMessage);
                System.out.println(textMessage.getText());
            }
            session.commit();
            session.close();
            connection.close();
        }catch (JMSException e){

        }finally {

        }
    }
}
