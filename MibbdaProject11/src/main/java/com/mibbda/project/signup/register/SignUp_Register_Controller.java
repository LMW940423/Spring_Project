package com.mibbda.project.signup.register;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mibbda.project.signup.select.SignUp_Select_MainCommand;


@Controller
public class SignUp_Register_Controller {
	
	@Autowired
	private SqlSession sqlSession;

	// Command
	SignUp_Register_MainCommand JoinUS_Complete_Command = null;

	@Autowired
	public void auto(SignUp_Register_MainCommand JoinUS_Complete) {
		this.JoinUS_Complete_Command = JoinUS_Complete;
	}
	
	@RequestMapping("JoinAgree") // 회원가입 동의
	public String JoinAgree() {
		return "joinus/JoinAgree";
	}
	
	@RequestMapping("agreeOK") // 동의 OK
	public String agreeOK(){
		return "joinus/joinUsView";
	}
	
	@RequestMapping("joinUsOk") // 회원가입 완료
	public String joinUsOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		JoinUS_Complete_Command.execute(model);
		return "joinus/JoinResult";
	}

}
