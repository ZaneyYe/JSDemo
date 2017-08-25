package js.controller;

import js.mq.QueueSender;
import js.mq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/08/16 上午 9:34.
 * email: mia5121@163.com
 * 支持下载
 */
@Controller
@RequestMapping("/")
public class WordController {

	@Autowired
	private QueueSender queueSender;

	@Autowired
	private TopicSender topicSender;

	@RequestMapping("/toWorld.do")
	public String toWord(HttpServletRequest request){
		return "world";
	}


	@RequestMapping(value = "isAlive.do",method = RequestMethod.GET)
	@ResponseBody
	public String isAlive(HttpServletRequest request){
		return "ok";
	}


	@RequestMapping("/toSendMsg.do")
	public String sendMs(HttpServletRequest request){
		return "send";
	}

	@RequestMapping(value = "/sendPoint.do",method = RequestMethod.POST)
	public String sendPointMsg(HttpServletRequest request,String queueMsg){
		queueSender.send("test.queue",queueMsg);
		return "success";
	}

	@RequestMapping(value = "/sendTopic.do",method = RequestMethod.POST)
	public String sendTopicMsg(HttpServletRequest request,String topicMsg){
		topicSender.send("test.topic",topicMsg);
		return "success";
	}





}
