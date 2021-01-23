package com.mibbda.project.main.prdselect;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;



public class Main_prd_Select_Command implements Main_prd_Command {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		Main_prdselect_Dao dao = sqlSession.getMapper(Main_prdselect_Dao.class);
	
		ArrayList<Dto_product> dtos = dao.NowPrd();
		request.setAttribute("real", dtos);
		
		//-------------------------신상품
		ArrayList<Dto_product> dto = dao.NewPrd();
		request.setAttribute("nw", dto);
		
		//------------------------공지사항
		ArrayList<Dto_notice> ddto = dao.Notice();
		request.setAttribute("notice", ddto);

	}

}
