package js.mq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by yzy on 2017/08/25 下午 5:01.
 * email: mia5121@163.com
 */
@Component
public class QueueConsumer implements MessageListener {
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("接收到了消息。。。"+ ((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
