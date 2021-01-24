package com.mibbda.project.event.select;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventSelect_Controller {
	
	@Autowired
	private SqlSession sqlSession;
	
	Event_Select_Command Show_EventList_Command;
	Event_Select_Command Event_Select_EventDetailCommand;
	
	@Autowired
	public void auto(Event_Select_Command Show_EventList
					,Event_Select_Command Show_EventDetail) {
		this.Show_EventList_Command = Show_EventList;
		this.Event_Select_EventDetailCommand = Show_EventDetail;
	}
	
	@RequestMapping("eventList.five") //header의 이벤트 탭
	public String eventList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		Show_EventList_Command.execute(model);
		
		return "event/eventList";
	}
	
	@RequestMapping("eventViewUser.five") //이벤트 상세보기
	public String eventViewUser(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		Event_Select_EventDetailCommand.execute(model);
		
		return "event/eventViewUser";
	}

}
