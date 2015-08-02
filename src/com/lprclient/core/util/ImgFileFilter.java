package com.lprclient.core.util;

import java.io.File;
import java.io.FilenameFilter;

import com.lprclient.core.LPRConstant;

/**     
* @Description:
* @author: kuku713@qq.com    
* @date: 2015年8月2日 下午10:03:00  
* @version V1.0    
*/
public class ImgFileFilter implements FilenameFilter {
	
	private String searchStr = null;
	
	public ImgFileFilter() {
		super();
	}
	
	public ImgFileFilter(String searchStr) {
		this.searchStr = searchStr;
	}
	
	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	@Override
	public boolean accept(File paramFile, String paramString) {
		if (paramString.lastIndexOf('.') > 0) {
			int lastIndex = paramString.lastIndexOf(".");
			String fileType = paramString.substring(lastIndex + 1);
			// 图片类型过滤
			if (StringUtil.contains(LPRConstant.FILE_FILTER_IMAGE_TYPE, fileType)) {
				// 关键字过滤
				if (StringUtil.isNotBlank(searchStr)) {
					if (paramString.indexOf(searchStr) >= 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}

}
