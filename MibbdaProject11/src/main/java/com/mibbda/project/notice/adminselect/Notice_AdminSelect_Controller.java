package com.mibbda.project.notice.adminselect;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// 지은 21.01.22 추가
@Controller
public class Notice_AdminSelect_Controller {
	
	@Autowired
	private SqlSession sqlSession; 
	
	//NoticeAdminList
	@RequestMapping("manageNoticeList")
	public String list(Model model) {
		
		// Notice_AdminSelect_Dao.xml과 연결.
		Notice_AdminSelect_Dao dao = sqlSession.getMapper(Notice_AdminSelect_Dao.class);
		
		//
		model.addAttribute("NoticeAdminList", dao.NoticeAdminListDao());
		
		//
		return "notice_admin/manageNoticeList";
	}

	
}
