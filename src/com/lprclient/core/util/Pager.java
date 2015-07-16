package com.lprclient.core.util;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午4:21:55  
 * @version V1.0    
 */
public class Pager {
	
	private int pageNow;        // 当前页数
	private int pageSize;       // 每页显示多少条记录
	private long totalPage;     // 一共有多少页
	private long totalSize;     // 一共有多少条记录
	
	public Pager(int pageNow, long totalSize) {
		this.pageNow = pageNow;
		this.totalSize = totalSize;
		this.pageSize = LPRConstant.PAGE_SIZE;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		totalPage = totalSize/pageSize;
		if (totalSize%pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	/**
	 * 当前是否为首页
	 * @return
	 */
	public boolean isFirst() {
		if (pageNow == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 当前是否为末页
	 * @return
	 */
	public boolean isLast() {
		if (pageNow == getTotalPage()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 是否有前一页
	 * @return
	 */
	public boolean isHasPre() {
		if (isFirst()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 是否有后一页
	 * @return
	 */
	public boolean isHasNext() {
		if (isLast()) {
			return false;
		} else {
			return true;
		}
	}

}
