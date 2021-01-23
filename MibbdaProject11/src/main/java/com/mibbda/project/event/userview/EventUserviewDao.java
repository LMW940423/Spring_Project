package com.mibbda.project.event.userview;

import java.util.ArrayList;

public interface EventUserviewDao {
	public ArrayList<EventUserviewDto> listDao(int page, int pageSize);
	public int getBoardCount();
	
}

