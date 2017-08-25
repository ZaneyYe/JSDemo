package js.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yzy on 2017/08/25 下午 2:19.
 * email: mia5121@163.com
 * 消息产生方
 */
public class Producer {

	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;

	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

	private static final String BLOCKURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		//连接工厂
		ConnectionFactory connectionFactory = null;
		//连接
		Connection connection = null;
		//会话线程
		Session session = null;
		//消息目的地
		Destination destination = null;
		//消息生产者
		MessageProducer messageProducer;

		connectionFactory = new ActiveMQConnectionFactory(USER_NAME,PASSWORD,BLOCKURL);

		try {
			connection = connectionFactory.createConnection();
			//启动连接
			connection.start();
			//创建session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			//创建消息目的queue
			destination = session.createQueue("HelloWorld");
			//创建生产者
			messageProducer = session.createProducer(destination);

			//创建消息
			for(int i = 0;i < 10;i++){

				TextMessage message = session.createTextMessage("this is china" + i);

				messageProducer.send(message);
			}

			session.commit();

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
