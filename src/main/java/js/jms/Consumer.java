package js.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yzy on 2017/08/25 下午 2:46.
 * email: mia5121@163.com
 */
public class Consumer {


	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;

	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

	private static final String BLOCKURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args){
		ConnectionFactory factory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageConsumer consumer;

		factory = new ActiveMQConnectionFactory(USER_NAME,PASSWORD,BLOCKURL);

		try {
//			通过连接工厂获取连接
			connection = factory.createConnection();
			//启动连接
			connection.start();
			//创建session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//创建一个连接HelloWorld的消息队列
			destination = session.createQueue("HelloWorld");
			//创建消息消费者
			consumer = session.createConsumer(destination);

			while (true) {
				TextMessage textMessage = (TextMessage) consumer.receive(100000);
				if(textMessage != null){
					System.out.println("收到的消息:" + textMessage.getText());
				}else {
					break;
				}
			}

//			//通过连接工厂获取连接
//			connection = factory.createConnection();
//			//启动连接
//			connection.start();
//			//创建session
//			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			//创建一个连接HelloWorld的消息队列
//			destination = session.createQueue("HelloWorld");
//			//创建消息消费者
//			consumer = session.createConsumer(destination);
//
//			while (true) {
//				TextMessage textMessage = (TextMessage) consumer.receive(100000);
//				if(textMessage != null){
//					System.out.println("收到的消息:" + textMessage.getText());
//				}else {
//					break;
//				}
//			}

		} catch (JMSException e) {
			e.printStackTrace();

		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
