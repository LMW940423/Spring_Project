package com.mibbda.project.mypage.select;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPage_Select_Controller {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("myOrderList.five") // 내 주문내역 (로그인 연동되어야 알 수 있음)
	public String myOrderList(HttpSession session, Model model, HttpServletRequest request) {
		String userId = (String) session.getAttribute("Log_userId");
		MyPage_Select_Dao dao = sqlSession.getMapper(MyPage_Select_Dao.class);
		model.addAttribute("myOrderList", dao.orderInfoDao(userId));
		
		return "mypage/myOrderList";
	}
	
//	@RequestMapping("cartList.five") // 내 장바구니 (대환형 거에 있는 듯?)
//	public String cartList(HttpSession session, Model model, HttpServletRequest request) {
//		String userId = (String) session.getAttribute("Log_userId");
//		
//		
//		return "mypage/cartList";
//	}

}
