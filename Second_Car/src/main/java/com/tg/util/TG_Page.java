package com.tg.util;

import java.util.List;

public class TG_Page<T> {
	//����
	//��ǰҳ
	private int currentPage;
	//�������
	private int totalSize;
	//��ҳ��
	private int totalPage;
	//ÿҳ�����
	private int pageSize=10;
	//�Ƿ���ǰҳ
	private boolean hasPre;
	//�Ƿ��к�ҳ
	private boolean hasNext;
	//�ǲ�����ҳ
	private boolean hasFirst;
	//�ǲ���βҳ
	private boolean hasLast;
	
	
	//��ȡ��ǰҳ
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	//�õ��������
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}


	//�õ���ҳ��
	public int getTotalPage() {
		totalPage=this.getTotalSize()/this.getPageSize();
		if(this.getTotalSize()%this.getPageSize()!=0){
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	//�õ���ǰҳ��
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	//�Ƿ���ǰҳ
	public boolean isHasPre() {
		if(this.isHasFirst()){
			return true;
		}
		return false;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}



	public boolean isHasNext() {
		if(this.isHasLast()){
			return true;
		}
		return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}



	public boolean isHasFirst() {
		if(this.currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}


	public boolean isHasLast() {
		if(currentPage==this.getTotalPage()){
			return false;
		}
		return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}



	public TG_Page(int currentPage,int totalSize){
		this.setCurrentPage(currentPage);
		this.setTotalSize(totalSize);
	}
	public TG_Page(int cirrentPage,int totalSize,int pageSize){
		this.setCurrentPage(cirrentPage);
		this.setTotalSize(totalSize);
		this.pageSize=pageSize;
	}
}
