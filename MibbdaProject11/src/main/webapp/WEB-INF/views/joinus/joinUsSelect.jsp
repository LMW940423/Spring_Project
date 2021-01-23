
<%@page import="com.mibbda.project.signup.select.Dto_Select"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String clickName = request.getParameter("click");
		
	String userEmail = request.getParameter("useremail1") + "@" + request.getParameter("useremail2");
		
	String userId = request.getParameter("userid");
	String userPw2 = request.getParameter("userpw2");
	String userPw1 = request.getParameter("userpw1");
	String userName = request.getParameter("username");
	String userBrith = request.getParameter("userBirth");
	String userAddr1 = request.getParameter("zipNo");
	String userAddr2 = request.getParameter("roadAddrPart1");
	String userAddr3 = request.getParameter("addrDetail");
	String userAddress = userAddr1 + ", " + userAddr2 + ", " + userAddr3;	
	String userTel1 = request.getParameter("tel1");
	String userTel2 = request.getParameter("tel2");
	String userTel3 = request.getParameter("tel3");
	String userTel = userTel1 + "-" + userTel2 + "-" + userTel3;
	String userEmail1 = request.getParameter("useremail1");
	String userEmail2 = request.getParameter("useremail2");
	
	switch(clickName){
	case("아이디 중복확인"):
		Dto_Select dtos = new Dto_Select(userId, userPw1, userPw2, userName, userAddr1, userAddr2, userAddr3, userTel1, userTel2, userTel3, userEmail1, userEmail2, userBrith);
	
		session.setAttribute("userId", userId);
		response.sendRedirect("idCheck");
		break;
		
	case("회원가입"):
		Dto_Select joinDto = new Dto_Select(userId, userPw2, userName, userAddress, userTel, userEmail, userBrith);
		
		response.sendRedirect("joinUsOk");
		break;
		
	case("이메일 중복확인"):
		Dto_Select dto = new Dto_Select(userId, userPw1, userPw2, userName, userAddr1, userAddr2, userAddr3, userTel1, userTel2, userTel3, userEmail1, userEmail2, userBrith);
	
		session.setAttribute("userEmail", userEmail);
		response.sendRedirect("joinUs_Check_Email");
		break;

	default:
		response.sendRedirect("mibbdaMain");
		break;
		
	}
%>