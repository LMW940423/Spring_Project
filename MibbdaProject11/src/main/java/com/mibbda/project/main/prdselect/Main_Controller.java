package com.mibbda.project.main.prdselect;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Main_Controller {
	
	@Autowired
	private SqlSession sqlSession;

	// Command
	Main_prd_Command Show_Main_Prds_Command = null;


	@Autowired
	public void auto(Main_prd_Command Show_Main_Prds) {
		this.Show_Main_Prds_Command = Show_Main_Prds;
	
	}
	
	@RequestMapping("selectPage.five") // 회원가입 완료 후 로그인 or 메인화면 선택
	public String selectPage(){
		return "main/selectPage";
	}
	
	@RequestMapping("mibbdaMain.five") // 메인화면으로 이동
	public String mibbdaMain(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		Show_Main_Prds_Command.execute(model);
		return "main/mibbdaMain";
	}
	
//	@RequestMapping("logIn.five") // 로그인 화면으로 이동
//	public String logIn() {
//		return "logIn/logInView";
//	}
	
	@RequestMapping("productShowMain.five") // 상품 상세보기
	public String productShowMain(HttpServletRequest request, Model model) {
		
		String prdNo = request.getParameter("prdNo");
		
		Main_prdselect_Dao dao = sqlSession.getMapper(Main_prdselect_Dao.class);
		model.addAttribute("storeMain",dao.prd_Detail(prdNo));
		
		return "main/productView";
	}
}
