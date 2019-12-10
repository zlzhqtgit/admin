
package cn.hqtmain.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hqtmain.entity.Message;
import cn.hqtmain.service.MessageService;


/**
* @Title: MessageController.java
* @Package cn.hqtzytb.controller
* @Description:(在线聊天系统消息记录)
* @author: ZhouLingZhang
* @date 2019年11月11日
* @Copyright:好前途教育
* @version V1.0
 */
@Controller
@RequestMapping(value = "/Message")
public class MessageController {	

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/queryAll.do")
	public String queryAll(HttpServletRequest request) {		
		List<Message> mList = messageService.queryAll();
		request.setAttribute("messages", mList);
		return "NotFound";
	}

	@ResponseBody
	@RequestMapping(value = "/queryChatMessage.do", method = RequestMethod.GET)
	public List<Message> queryChatMessage(String fromUID, String toUID) {		
		List<Message> mList = messageService.queryMessage(fromUID, toUID);	
		System.out.println(mList);
		return mList;
	}

	@RequestMapping("/save.do")
	public String saveMessage() {
		System.out.println(123);
		Message message = new Message("测试controller", new Date(), "4", "1");
		 messageService.saveMessage(message);		
		return null;
	}

}
