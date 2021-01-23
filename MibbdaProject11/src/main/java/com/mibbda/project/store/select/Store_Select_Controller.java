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
	Store_Select_manageProductCommand Show_prdList_Command = null;
	
	@Autowired
	public void auto(Store_Select_manageProductCommand Show_prdList) {
		this.Show_prdList_Command = Show_prdList;

	}
	
	
	@RequestMapping("storeMain.five")
	public String storeMain(HttpServletRequest request, Model model) {
		System.out.println("storeMain()");

		model.addAttribute("request", request);		
		Show_prdList_Command.execute(model);
		return "store/storeMain";
	}

}
