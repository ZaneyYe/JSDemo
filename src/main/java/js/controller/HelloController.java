package js.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/08/14 下午 3:07.
 * email: mia5121@163.com
 */
@Controller
@RequestMapping("/")
public class HelloController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/hello.do")
	public String toHello(){
		return "hello";
	}

	/**
	 * 同步上传跳转
	 * @param request
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/uploadFile1.do",method = RequestMethod.POST)
	public String upLoadFileOne(HttpServletRequest request,
							  @RequestParam("name") String name,
							  @RequestParam("upFile") MultipartFile file){
		LOGGER.info("开始上传1...{}", name);
		System.out.println(file.getOriginalFilename());
		return "success";
	}


	/**
	 * iframe 无刷新上传文件
	 * @param request
	 * @param name
	 * @param file
	 */
	@RequestMapping(value = "/uploadFile2.do",method = RequestMethod.POST)
	public void upLoadFileTwo(HttpServletRequest request,
								@RequestParam("name2") String name,
								@RequestParam("upFile2") MultipartFile file){
		LOGGER.info("开始上传2...{}", name);
		System.out.println(file.getOriginalFilename());
		return;
	}

	/**
	 * h5 异步上传文件 ,返回需要是json才能进入success
	 * @param request
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "uploadFile3.do",method = RequestMethod.POST)
	@ResponseBody
	public Boolean upLoadFileThree(HttpServletRequest request,
								@RequestParam("name3") String name,
								@RequestParam("upFile3") MultipartFile file){
		LOGGER.info("开始上传3...{}", name);
		System.out.println(file.getOriginalFilename());
		return new Boolean(true);
	}


	@RequestMapping(value = "subStuInfo.do",method = RequestMethod.POST)
	@ResponseBody
	public void subStuInfo(HttpServletRequest request,
						   @RequestParam("stuName")String name,
						   @RequestParam("stuNo")String no){
		System.out.println(name);
		System.out.println(no);
		return ;
	}



}
