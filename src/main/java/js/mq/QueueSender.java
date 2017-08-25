package js.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by yzy on 2017/08/25 下午 4:43.
 * email: mia5121@163.com
 */
@Component(value = "queueSender")
public class QueueSender {

	@Autowired
	@Qualifier(value = "jmsQueueTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * 发送消息到指定队列
	 * @param queueName
	 * @param msg
	 */
	public void send(final String queueName,final String msg){
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
