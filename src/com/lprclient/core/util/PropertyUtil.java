package com.lprclient.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**     
* @Description:
* @author: kuku713@qq.com    
* @date: 2015年7月15日 下午11:51:41  
* @version V1.0    
*/
public class PropertyUtil {
	
	private static final Logger log = LoggerFactory.getLogger(PropertyUtil.class);
	private Properties properties;
	private FileInputStream inputFile; 
    private FileOutputStream outputFile;
    
    /**
     * 初始化PropertyUtil
     */
    public PropertyUtil() {
    		properties = new Properties(); 
    }
	
    /**
     * 初始化PropertyUtil
     * @param filePath 配置文件的路径+名称
     */
	public PropertyUtil(String filePath, boolean newCreate) {
		properties = new Properties();
		this.load(filePath, newCreate);
	}
	
	/**
	 * 加载Property
	 * @param filePath
	 */
	private void load(String filePath, boolean newCreate) {
		try {
			if (newCreate) {
				File file = new File(filePath);
				if (!file.exists()) {
					saveFile(filePath, "New Create");
				}
			}
			inputFile = new FileInputStream(filePath); 
			properties.load(inputFile);
		} catch (FileNotFoundException ex) { 
	        log.error("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在\n" + "文件路径:" + filePath);
	        ex.printStackTrace(); 
		} catch (IOException ex) { 
	        log.error("装载文件--->失败!");
	        ex.printStackTrace(); 
		} finally {
			if (null != inputFile) {
				try {
					inputFile.close();
				} catch (IOException e) {
					System.out.println("关闭文件流--->失败!\n" + "文件路径:" + filePath);
					log.error("关闭文件流--->失败!\n" + "文件路径:" + filePath);
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 得到key对应的value
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		if(properties.containsKey(key))	{ 
            return properties.getProperty(key);
        } else { 
            return null; 
        }
	}
	
	/**
	 * 插入key-value
	 * @param key
	 * @param value
	 */
	public void setValue(String key, Object value) {
		if (StringUtil.isNotBlank(key)) {
			properties.setProperty(key, String.valueOf(value));
		}
	}
	
	/**
	 * 得到key对应的value
	 * @param filePath
	 * @param key
	 * @return
	 */
	public String getValue(String filePath, String key) {
		this.load(filePath, false);
		return getValue(key);
	}
	
	/**
	 * 保存数据
	 * @param fileName
	 * @param desc
	 */
	public void saveFile(String fileName, String desc) {
		try {
			outputFile = new FileOutputStream(fileName);
			properties.store(outputFile, desc);
		} catch (FileNotFoundException e) {
			log.error("写入属性文件失败！- 原因：文件路径错误或者文件不存在\n" + "文件路径:" + fileName);
			e.printStackTrace(); 
		} catch (IOException ioe) {
			log.error("写入属性文件失败!");
			ioe.printStackTrace(); 
		} finally {
			if (null != outputFile) {
				try {
					outputFile.close();
				} catch (IOException e) {
					log.error("关闭文件流失败\n" + "文件路径:" + fileName);
					e.printStackTrace();
				}
			}
		}
	}

}
