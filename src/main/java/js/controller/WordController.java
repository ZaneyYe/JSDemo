package js.controller;

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

	@RequestMapping("/toWorld.do")
	public String toWord(HttpServletRequest request){
		return "world";
	}


	@RequestMapping(value = "isAlive.do",method = RequestMethod.GET)
	@ResponseBody
	public String isAlive(HttpServletRequest request){
		return "ok";
	}


}
