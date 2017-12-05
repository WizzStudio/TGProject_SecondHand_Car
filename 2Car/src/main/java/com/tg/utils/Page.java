package com.tg.utils;

import java.util.List;

/**
 * 分页
 * @author 7lenovo
   @version
		1.0,2017年11月29日 下午10:51:42
 * @param <T>
 *
 */
public class Page<T> {
	private int everyPage;	//每页的数目
	private int totalCount;	//总的记录数
	private int totalPage;	//总页数
	private int currentPage;	//当前页
	
	private List<T> lists;	//记录

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
}
