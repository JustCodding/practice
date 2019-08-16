package com.practice.message.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgProducter {
    public static void main(String[] args) throws JMSException {
        //queueSend();
        topicSend();

    }
    /*
    点对点方式 往queue中发送消息
    **/
    private static void queueSend() throws JMSException {
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
        //创建消息的发送者
        MessageProducer producer = session.createProducer(queue);
        //创建发送的内容
        TextMessage msg = session.createTextMessage("hello message5");
        //发送消息
        producer.send(msg);

        producer.close();
        session.close();
        connection.close();
    }

    /*
    发布订阅方式 往topic中发送消息
    **/
    private static void topicSend() throws JMSException {
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
        //创建消息发送的目的地，哪个主题中
        Topic topic = session.createTopic("mytopic");
        //创建消息的发送者
        MessageProducer producer = session.createProducer(topic);
        //创建发送的内容
        TextMessage msg = session.createTextMessage("hello topic3");
        //发送消息
        producer.send(msg);

        producer.close();
        session.close();
        connection.close();
    }
}
