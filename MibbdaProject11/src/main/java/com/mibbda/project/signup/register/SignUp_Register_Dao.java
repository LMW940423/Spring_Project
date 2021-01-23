package com.mibbda.project.signup.register;

import java.util.ArrayList;

import com.mibbda.project.signup.select.Dto_Select;



public interface SignUp_Register_Dao {
	
	public void insertUserInfo(String userId, String userPw, String userName, String userBrith, String userAddress, String userTel, String userEmail);	
	public void insertCartInfo(String userId);	
	
//	public ArrayList<Dto_Select> listDao();
//	public void deleteDao(String seqno);
//	public Dto_Select viewDao(String seqno);
//	public void modifyDao(String name, String telno, String address, String email, String relation, String seqno);	
//	public ArrayList<Dto_Select> listQuery(String query, String content);
}
