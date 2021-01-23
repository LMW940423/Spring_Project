package com.mibbda.project.notice.delete;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// 지은 21.01.22 추가
@Controller
public class Notice_Delete_Controller {
	
	@Autowired
	private SqlSession sqlSession; 
	

	@RequestMapping("/NoticDelete")
	public String delete(HttpServletRequest request, Model model) {

		// Notice_Delete_Dao.xml과 연결.
		Notice_Delete_Dao dao = sqlSession.getMapper(Notice_Delete_Dao.class);
		
		//
		dao.NoticeDeleteDao(request.getParameter("nSeqno"));		
		
		//
		return "redirect:manageNoticeList";
	}
	
	
}
