package com.mibbda.project.store.select;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.mibbda.project.main.prdselect.Dto_product;
import com.mibbda.project.main.prdselect.Main_prdselect_Dao;



public class Store_Select_Store1Command implements Store_Select_Command {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		//한 페이지당보여줄 글 갯수
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		Main_prdselect_Dao dao = sqlSession.getMapper(Main_prdselect_Dao.class);
		
		final int pageSize=7;
		int currentPage = 1; 
		
		if(request.getParameter("page")!=null){ 
			currentPage = Integer.parseInt(request.getParameter("page")); //현재 페이지
		}
		
		ArrayList<Dto_product> dtos = new ArrayList<Dto_product>();
		dtos = dao.storeList1(currentPage, pageSize);

		request.setAttribute("store1", dtos);  			
		
		System.out.println("store1 정보 : " + dtos.get(0).getCtgType());
		System.out.println("store1 정보 : " + dtos.get(0).getPrdContent());
		System.out.println("store1 정보 : " + dtos.get(0).getPrdDate());
		System.out.println("store1 정보 : " + dtos.get(0).getPrdName());

		//전체 글 갯수 구하기
		int totalRow = dao.getBoardCount_Store1();
		//전체 페이지 갯수       (전체글 개수-1)/페이지당 글 수+1   
		int totalPage = (totalRow-1)/pageSize+1;  

		//페이지 그룹화  [1][2][3] [4][5][6] [7][8][9]  =>3페이지가 한그룹
		int pagePerGroup = 3;
		//시작페이지	((현재페이지-1)/그룹당 보여줄 페이지)*그룹당 보여줄 페이지+1   [1] [4] [7]
		int startPage = ((currentPage-1)/pagePerGroup)*pagePerGroup+1;
		//끝페이지		시작페이지+그룹당 보여줄 페이지-1  [3] [6] [9]
		int endPage = startPage+pagePerGroup-1;

		//★만약 endPage가 totalPage보다 크면 endPage에 totalPage를 넣어준다.
		if(endPage>totalPage){endPage=totalPage;}

		//request에 setAttribute를 사용하여 모든 정보를 붙여 보낸다.
		request.setAttribute("currentPage",currentPage); 
		request.setAttribute("totalRow",new Integer(totalRow));   //총 글 갯수 생략 가능성
		request.setAttribute("totalPage",new Integer(totalPage)); 
		request.setAttribute("startPage",new Integer(startPage)); 
		request.setAttribute("endPage",new Integer(endPage)); 
		request.setAttribute("store1", dtos);
	}

}
