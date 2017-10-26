package com.zhidi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;








import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhidi.entity.User;
//控制层
@Controller
public class IndexController {
  

	//请求映射
/*	@RequestMapping("/index.do")
	public String index(){
		return "index";	
	}*/
	/*@RequestMapping(value="/index.do",params="yuansicheng",method=RequestMethod.POST)
	public String index1(String yuansicheng, HttpServletRequest req){
		req.setAttribute("yyy", yuansicheng);
		return "redirect:index";	
	}*/
	//从el表达式上可以看出 其他几个的存储都在Request里，如果不是也可以从request中提取
	@RequestMapping("/index")
	public String byRequest(HttpServletRequest req){
		 req.setAttribute("username", "张三");	
		return "index";				
	}
	
	@RequestMapping("/byModel")
	public String byModel(Model model){
		model.addAttribute("password", "降雨他");
		
		return "index";	
	}
	@RequestMapping("/byModelMap")
	public String byModelMap(ModelMap mo){
		mo.addAttribute("uuuu", "降雨555");
		
		return "index";	
	}
	@RequestMapping("/bySession")
	public String byASession(HttpSession session){
		
		session.setAttribute("sesion", "韩正");
		return "index";		
	}
	//json格式的读出
	@RequestMapping("/byjson")
	public void byJson(HttpServletResponse resp) throws IOException{
		resp.setContentType("application/json");
		
		PrintWriter wr = resp.getWriter();
		wr.print("{\"username\":\"你好\",\"usernam\":\"小嘟嘟\"}");
		wr.flush();
		wr.close();	
	}
	//普通属性转换
	@RequestMapping("/inte")
	public String inte(Integer id){
		
		System.out.println(id);
		return "index";	
	}
	//必须要指定的属性才认
	@RequestMapping("/app")
	public String app(@RequestParam(name="id", defaultValue="22" ) Integer id){
		System.out.println(id);
		return "index";	
	}
	//传递的参数和实体类中的属性匹配就直接存到实体类中 如果没有的话就单独干
	@RequestMapping("/pojo")
	public String pojo(User user){
		System.out.println(user);
		
		return "index";	
	}
	//时间类型转换，在没有实现接口的情况下可以在实体类的时间类型上添加注解@DateTimeFormat(pattern="yyyy-MM-dd")
	
	@RequestMapping("/ddate")
	public String ddate(@DateTimeFormat(pattern="yyyy-MM-dd") Date date){
		
		System.out.println(date);
		
		return "index";	
	}
	
	
	@RequestMapping("/{date}/{name}")
	public String pvariable(@PathVariable("date") Date date,
			                  @PathVariable("name") String name ){
	System.out.println(date);
	System.out.println(name);
		
		return "index";
	}
	
	
}
