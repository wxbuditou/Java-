package cn.it.cast.utils;

import java.util.List;

public class PageModel {
	private int currentPageNum;//��ǰҳ��ÿ�δӿͻ�����������͵������
	private int pageSize;//ÿҳ������Լ���õ�
	private int totalRecord;//�ܹ���¼��������Ӳֿ��в�ѯ
	
	private int totalPageNum;//��ҳ��
	private int startIndex;//��ʼ����ֵ�������Ͼ��Ƿ�ҳ�����limit��ĵ�һ������ֵ
	private int prevPageNum;//��һҳ
	private int nextPageNum;//��һҳ
	
	private int startPage;//��ʼҳ�� 
	private int endPage;  //��ֹҳ��
	private String url;
	private List list;
	
	public PageModel(int currentPagenum , int pageSize , int totalRecord) {
		this.currentPageNum =currentPagenum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		totalPageNum = (totalRecord%pageSize==0)?(totalRecord/pageSize):(totalRecord/pageSize+1);
		startIndex = (currentPageNum - 1) * pageSize;
		
		prevPageNum = currentPageNum-1;
		if (prevPageNum<=1) {
			prevPageNum=1;
		}
		
		
		nextPageNum = currentPageNum+1;
		if (currentPageNum==totalPageNum) {
			nextPageNum = totalPageNum;
		}
		
		startPage = currentPageNum - 4;
		endPage = currentPageNum + 4;
		
		if (totalPageNum<=9) {
			//�ܹ�������ҳ�����е�ҳ����Ҫ��ʾ
			startPage=1;
			endPage = totalPageNum;
		}else {
			if (startPage<1) {
				startPage=1;
				endPage=startPage+8;
			}
			if (endPage>totalPageNum) {
				endPage=totalPageNum;
				startPage=totalPageNum-8;
			}
			
		}
		
	}


	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPrevPageNum() {
		return prevPageNum;
	}
	public void setPrevPageNum(int prevPageNum) {
		this.prevPageNum = prevPageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
