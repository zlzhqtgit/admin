package cn.hqtmain.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* @ClassName: MyExceptionResolver
* @Description:(统一处理异常类)
* @author: ZhouLingZhang
* @date 2019年9月3日
 */
public class MyExceptionResolver implements HandlerExceptionResolver
{
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex)
	{
		/*
		 * 通过resolveException接收异常，通过ModelAndView把异常相关信息显示到页面并设置显示的页面？
		 */
		ModelAndView mav= new ModelAndView();	
		if(!ex.equals("ajax")){				
			mav.addObject("ex",ex);	
			mav.addObject("path",request.getRequestURI());			
			mav.setViewName("zytberror/error"); 
		}		
		return mav;
	}

}
