package cn.it.cast.utils;

import java.util.List;

public class PageModel {
	private int currentPageNum;//当前页，每次从客户端浏览器发送到服务端
	private int pageSize;//每页条数，约定好的
	private int totalRecord;//总共记录数，必须从仓库中查询
	
	private int totalPageNum;//总页数
	private int startIndex;//起始索引值，本质上就是分页语句中limit后的第一个参数值
	private int prevPageNum;//上一页
	private int nextPageNum;//下一页
	
	private int startPage;//起始页码 
	private int endPage;  //终止页码
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
			//总共不到九页，所有的页数都要显示
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
