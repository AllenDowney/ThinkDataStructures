package com.allendowney.thinkdast;

import java.util.ArrayList;
import java.util.List;

public class ListClientExample {
	@SuppressWarnings("rawtypes")
	private List list;

	@SuppressWarnings("rawtypes")
	public ListClientExample() {
		list = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public static void main(String[] args) {
		ListClientExample lce = new ListClientExample();
		@SuppressWarnings("rawtypes")
		List list = lce.getList();
		System.out.println(list);
	}
}
