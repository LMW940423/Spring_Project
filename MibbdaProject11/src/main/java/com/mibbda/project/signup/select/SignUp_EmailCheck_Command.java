package com.mibbda.project.signup.select;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class SignUp_EmailCheck_Command implements SignUp_Select_MainCommand {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = (HttpSession) map.get("session");
		
		Dto_Select dto = new Dto_Select();
		boolean checkValue = true;
		int TCE = 1;
		String userId = dto.getUserId();
		String userPw1 = dto.getUserPw1();
		String userPw2 = dto.getUserPw2();
		String userName = dto.getUserName();
		String userBrith = dto.getUserBirth();
		String userAddr1 = dto.getBeforeUserAddress1();
		String userAddr2 = dto.getBeforeUserAddress2();
		String userAddr3 = dto.getBeforeUserAddress3();
		String userTel1 = dto.getBeforeUserTel1();
		String userTel2 = dto.getBeforeUserTel2();
		String userTel3 = dto.getBeforeUserTel3();
		String userEmail1 = dto.getBeforeUserEmail1();
		String userEmail2 = dto.getBeforeUserEmail2();
		
		Dto_Select dtos = new Dto_Select(userId, userPw1, userPw2, userName, userAddr1, userAddr2, userAddr3, userTel1, userTel2, userTel3, userEmail1, userEmail2, userBrith);
		
		request.setAttribute("userDto", dtos);
		
		
		System.out.println("체크벨류1 : " + session.getAttribute("checkValue"));
		
		
		SignUp_Select_Dao dao = sqlSession.getMapper(SignUp_Select_Dao.class);
		
		
		
		String afterUserEmail = (String)session.getAttribute("userEmail");
		String beforeUserEmail = (String)session.getAttribute("beforeUserEmail");
		
		int emailCheckResult = dao.check_DuplicatedEmail_Result(afterUserEmail); // 이메일 중복확인 결과값
		
		System.out.println("전 이메일 : " + beforeUserEmail);
		System.out.println("후 이메일 : " + afterUserEmail);
		System.out.println("이메일 중복확인 결과 : " + emailCheckResult);
		
		if(afterUserEmail.equals(beforeUserEmail) && emailCheckResult == 1) {

		}else if(emailCheckResult == 0){
		
		}else {
			checkValue = false;
		}
		System.out.println("dto에 저장된 변경 후 이메일 : " + dto.getBeforeUserEmail1());
		System.out.println("dto에 저장된 변경 후 이메일 : " + dto.getBeforeUserEmail2());
		System.out.println("수정 전 이메일 : " + beforeUserEmail);
		System.out.println("수정 후 이메일 : " + afterUserEmail);
		session.setAttribute("beforeEmail3", beforeUserEmail);
//		session.setAttribute("afterUserEmail", afterUserEmail);
		session.setAttribute("checkValue", checkValue);
		session.setAttribute("TCI", TCE);
		System.out.println("체크벨류2 : " + session.getAttribute("checkValue"));
	}

}
