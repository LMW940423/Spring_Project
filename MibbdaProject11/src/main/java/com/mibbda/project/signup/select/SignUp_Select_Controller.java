package com.mibbda.project.signup.select;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUp_Select_Controller {
	
	@Autowired
	private SqlSession sqlSession;

	// Command
	SignUp_Select_MainCommand check_DuplicatedID_Command = null;
	SignUp_Select_MainCommand check_DuplicatedEmail_Command = null;

	@Autowired
	public void auto(SignUp_Select_MainCommand check_DuplicatedID, SignUp_Select_MainCommand check_DuplicatedEmail) {
		this.check_DuplicatedID_Command = check_DuplicatedID;
		this.check_DuplicatedEmail_Command = check_DuplicatedEmail;
	}
	
	// Controller
	@RequestMapping("joinUsSelect") // 아이디 중복확인 or 이메일 중복확인 or 회원가입 나누는 jsp!
	public String joinUsSelect() {

		return "joinus/joinUsSelect";
	}
	
	@RequestMapping("idCheck") // 아이디 중복확인
	public String idCheck(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("idCheck()");
		 
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		check_DuplicatedID_Command.execute(model);
	
		return "joinus/joinUsView";
	}
	
	@RequestMapping("joinUs_Check_Email") // 이메일 중복확인
	public String joinUs_Check_Email(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		check_DuplicatedEmail_Command.execute(model);
		
		return "joinus/joinUsView";
	}
	
	@RequestMapping("jusoPopup") // 주소 팝업 jsp
	public String jusoPopup(Model model) {
		return "joinus/jusoPopup";
	}
	
	

	

}
