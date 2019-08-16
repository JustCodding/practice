package com.practice.message.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class MsgConsumer {
    public static void main(String[] args) throws JMSException {
        //queueConsumer();
    }
    /*
    点对点方式的消费消息
    */
    private static void queueConsumer() throws JMSException {
        //连接到activemq  activemq严格遵循jms规范的
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.43.157:61616");
        //从factory中获取连接
        Connection connection = factory.createConnection();
        //连接到mq
        connection.start();
        /*
        第一个参数表示是否使用事务，如果使用事务(在分布式中使用事务)则第二个参数无效
        第二个参数表示应答方式，应答方式:自动应答和手动应答
        * */
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建消息发送的目的地，哪个队列中
        Queue queue = session.createQueue("myqueue");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //消费者设置监听器监听消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage text = (TextMessage) message;
                try {
                    System.out.println("接收到消息:"+text.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //阻塞
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        consumer.close();
        session.close();
        connection.close();


        //循环去获取消息
        /*Boolean flag = true;
        while(flag){
            TextMessage message = (TextMessage) consumer.receive(2000);
            if(message!=null){
                System.out.println("接收到消息:"+message.getText());
            }
        }
        consumer.close();
        session.close();
        connection.close();*/
    }

    /*
    发布订阅方式的消费消息
    */
    @Test
    public void topicConsumer() throws JMSException {
        //连接到activemq  activemq严格遵循jms规范的
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.43.157:61616");
        //从factory中获取连接
        Connection connection = factory.createConnection();
        //连接到mq
        connection.start();
        /*
        第一个参数表示是否使用事务，如果使用事务(在分布式中使用事务)则第二个参数无效
        第二个参数表示应答方式，应答方式:自动应答和手动应答
        * */
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建消息接收的目的地，哪个队列中
        Topic topic = session.createTopic("mytopic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //消费者设置监听器监听消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage text = (TextMessage) message;
                try {
                    System.out.println("接收到消息:"+text.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //阻塞
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        consumer.close();
        session.close();
        connection.close();


        //循环去获取消息
        /*Boolean flag = true;
        while(flag){
            TextMessage message = (TextMessage) consumer.receive(2000);
            if(message!=null){
                System.out.println("接收到消息:"+message.getText());
            }
        }
        consumer.close();
        session.close();
        connection.close();*/
    }

}
