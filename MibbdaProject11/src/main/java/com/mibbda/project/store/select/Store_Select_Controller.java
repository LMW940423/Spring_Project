package com.mibbda.project.store.select;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Store_Select_Controller {
	
	@Autowired
	private SqlSession sqlSession;

	// Command
	Store_Select_Command Show_prdList_Command = null;
	Store_Select_Command Show_store1List_Command = null;
	Store_Select_Command Show_store2List_Command = null;
	Store_Select_Command Show_store3List_Command = null;
	Store_Select_Command Show_store4List_Command = null;
	
	@Autowired
	public void auto(Store_Select_Command Show_prdList
					, Store_Select_Command Show_store1List
					, Store_Select_Command Show_store2List
					, Store_Select_Command Show_store3List
					, Store_Select_Command Show_store4List) {
		this.Show_prdList_Command = Show_prdList;
		this.Show_store1List_Command = Show_store1List;
		this.Show_store2List_Command = Show_store2List;
		this.Show_store3List_Command = Show_store3List;
		this.Show_store4List_Command = Show_store4List;

	}
	
	
	@RequestMapping("storeMain.five") // header의 스토어
	public String storeMain(HttpServletRequest request, Model model) {
		System.out.println("storeMain()");

		model.addAttribute("request", request);		
		Show_prdList_Command.execute(model);
		return "store/storeMain";
	}
	
	@RequestMapping("store1.five") // 스토어탭의 생활/주방
	public String store1(HttpServletRequest request, Model model) {
		System.out.println("store1()");
		
		model.addAttribute("request", request);		
		Show_store1List_Command.execute(model);
		
		return "store/store1";
	}
	
	@RequestMapping("store2.five") // 스토어탭의 화장품
	public String store2(HttpServletRequest request, Model model) {
		System.out.println("store2()");
		
		model.addAttribute("request", request);		
		Show_store2List_Command.execute(model);
		
		return "store/store2";
	}
	
	@RequestMapping("store3.five") // 스토어탭의 유아/완구
	public String store3(HttpServletRequest request, Model model) {	
		System.out.println("store3()");
		
		model.addAttribute("request", request);		
		Show_store3List_Command.execute(model);
		
		return "store/store3";
	}
	
	@RequestMapping("store4.five") // 스토어탭의 스마트폰/태블릿
	public String store4(HttpServletRequest request, Model model) {
		System.out.println("store4()");
		
		model.addAttribute("request", request);		
		Show_store4List_Command.execute(model);
		
		return "store/store4";
	}

}
