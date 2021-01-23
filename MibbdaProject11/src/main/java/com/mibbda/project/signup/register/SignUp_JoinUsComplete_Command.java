package com.mibbda.project.signup.register;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.mibbda.project.signup.select.Dto_Select;

public class SignUp_JoinUsComplete_Command implements SignUp_Register_MainCommand {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		Dto_Select dto = new Dto_Select();
		
		String userId = dto.getUserId();
		String userPw = dto.getUserPw2();
		String userName = dto.getUserName();
		String userBrith = dto.getUserBirth();
		String userAddress = dto.getUserAddress();
		String userTel = dto.getUserTel();
		String userEmail = dto.getUserEmail();
		
		Dto_Select dtos = new Dto_Select(userId, userPw, userName, userBrith, userAddress, userTel, userEmail);
		
		request.setAttribute("userDto", dtos);
		
		SignUp_Register_Dao dao = sqlSession.getMapper(SignUp_Register_Dao.class);
		
		dao.insertUserInfo(userId, userPw, userName, userBrith, userAddress, userTel, userEmail);
		dao.insertCartInfo(userId);
		
	}

}
