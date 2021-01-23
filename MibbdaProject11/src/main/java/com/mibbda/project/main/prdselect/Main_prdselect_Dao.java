package com.mibbda.project.main.prdselect;

import java.util.ArrayList;


public interface Main_prdselect_Dao {
	
	// mibbdaMain 실시간, 신상품, 공지사항
	public ArrayList<Dto_product> NowPrd();
	public ArrayList<Dto_product> NewPrd();
	public ArrayList<Dto_notice> Notice();

	// mibbdaMain에서 상품 상세보기
	public Dto_product prd_Detail(String prdNo);
	
	// header의 스토어 클릭
	public ArrayList<Dto_product> productList(int currentPage, int pageSize);
	public int getBoardCount();
	
	
	
}
