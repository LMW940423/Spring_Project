package com.mibbda.project.signup.select;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class SignUp_IDCheck_Command implements SignUp_Select_MainCommand {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		System.out.println("ID중복확인으로 들어옴");
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = (HttpSession) map.get("session");
		
		Dto_Select dto = new Dto_Select();
		
		int TCI = 1;
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

		boolean idCheckValue = true;
		
		Dto_Select dtos = new Dto_Select(userId, userPw1, userPw2, userName, userAddr1, userAddr2, userAddr3, userTel1, userTel2, userTel3, userEmail1, userEmail2, userBrith);
		
		request.setAttribute("userDto", dtos);
		//여기까진 창 돌아와서 값 보존하기 위해 쓴 
		
		String afterUserId = (String)session.getAttribute("userId");
		System.out.println("회원가입 아이디 after : " + afterUserId);
		
		SignUp_Select_Dao dao = sqlSession.getMapper(SignUp_Select_Dao.class);
		
		int idCnt = dao.check_DuplicatedID_Result(afterUserId); // ID 중복확인 결과값!
		System.out.println("idCnt : " + idCnt);
		if(idCnt == 1) { 
			idCheckValue = false;
		}else if(idCnt == 0){
		
		}
		System.out.println("dto에 저장된 변경 후 userId: " + dtos.getUserId());
		System.out.println("수정 후 아이디 : " + afterUserId);
		session.setAttribute("idCheckValue", idCheckValue);
		session.setAttribute("TCI", TCI);
		System.out.println("아이디 체크벨류2 : " + session.getAttribute("idCheckValue"));
		
	}

}
