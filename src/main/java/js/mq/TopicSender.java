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
 * Created by yzy on 2017/08/25 下午 4:47.
 * email: mia5121@163.com
 */
@Component(value = "topicSender")
public class TopicSender {

	@Autowired
	@Qualifier(value = "jmsTopicTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * 发消息到指定主题
	 * @param topicName
	 * @param msg
	 */
	public void send(final String topicName,final String msg){
		jmsTemplate.send(topicName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}



}
