package com.mibbda.project.event.select;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.mibbda.project.store.select.Store_Select_Command;


public class Event_Select_EventDetailCommand implements Store_Select_Command {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = (HttpSession) map.get("session");

		Event_Select_Dao dao = sqlSession.getMapper(Event_Select_Dao.class);
		
		String eSeqno = request.getParameter("eSeqno");
//		String userId = (String) session.getAttribute("Log_userId");

		Dto_Event dto = dao.eventView(eSeqno);
		
		session.setAttribute("eventfilenameD", dto.geteFilename());
		request.setAttribute("eventView", dto);
		request.setAttribute("participant", dao.participant(eSeqno, "testtest"));
		ArrayList<Dto_Participate> lists = new ArrayList<Dto_Participate>();
	
		lists = dao.WinnerList(eSeqno);
		request.setAttribute("eventResultView", lists);
	}

}
