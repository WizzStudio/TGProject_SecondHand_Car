package com.tg.javabean;

import java.util.List;

/**
 * 	分页查询的实体类
 * @author 7lenovo
   @version
		1.0,2017年11月29日 下午10:51:42
 * @param <T>
 *
 */
public class Page<T> {
	
	private int everyPage;	//每页的数目
	private int totalCount;	//总的记录数
	private int currentPage;	//当前页
	
	private int totalPage;	//总页数，可以通过每页的数目和总的记录数计算出来
	private int beginIndex;		//起始页，可以通过当前页，还有每页的数目计算出来
	private boolean hasPrePage;	//是否有上一页
	private boolean hasNextPage;	//是否有下一页

	
	private List<T> lists;	//记录
	
	
	
	

	public Page(int everyPage, int totalCount, int currentPage, int totalPage,
			int beginIndex, boolean hasPrePage, boolean hasNextPage,
			List<T> lists) {
		super();
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
		this.lists = lists;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

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

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
}
