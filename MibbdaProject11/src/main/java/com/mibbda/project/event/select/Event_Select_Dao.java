package com.mibbda.project.event.select;

import java.util.ArrayList;


public interface Event_Select_Dao {
	
	// 이벤트 리스트
	public ArrayList<Dto_Event> eventList(int currentPage, int pageSize);
	public int getBoardCount();
	
	// 이벤트 상세보기
	public int participant(String eSeqno, String userId);
	public Dto_Event eventView(String streSeqno);
	public ArrayList<Dto_Participate> WinnerList(String eSeqno);

}
