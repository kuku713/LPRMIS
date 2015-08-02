package com.lprclient.core.view.label;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**     
* @Description:
* @author: kuku713@qq.com    
* @date: 2015年8月2日 下午9:38:48  
* @version V1.0
*/
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;
	private String imgPath;
    private int imgWidth;  
    private int imgHeight; 
    
    public ImagePanel(String imgPath) {
    		this.imgPath = imgPath;
    		this.setImagePath();
    }
    
    public int getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	
	public void setImagePath() {  
		try {          	
			// 该方法会将图像加载到内存，从而拿到图像的详细信息。
			image = ImageIO.read(new FileInputStream(imgPath));  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        setImgWidth(300);  
        setImgHeight(300);
    }

	@Override  
    public void paintComponent(Graphics g1) {  
        int x = 0;  
        int y = 0;  
        Graphics g = (Graphics) g1;  
        if (null == image) {
            return;  
        }  
        g.drawImage(image, x, y, getImgWidth(), getImgHeight(),  
                this);  
        g = null;  
    }  
    
}
