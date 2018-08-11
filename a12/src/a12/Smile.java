package a12;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Smile {
	
	public BufferedImage smiley;
	public BufferedImage smiley1;
	public BufferedImage smiley2;
	public BufferedImage smiley3;
	public int x;
	private int y;
	private int life;
	
	
	public Smile(int x, int y) {
		
		String str1 = "pics\\12345.png";
		String str2 = "pics\\123456.png";
		String str3 = "pics\\141.png";
		String str4 = "pics\\142.png";

		try {
			smiley = ImageIO.read(new File(str1));
			smiley1 = ImageIO.read(new File(str2));
			smiley2 = ImageIO.read(new File(str3));
			smiley3 = ImageIO.read(new File(str4));

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.life = 3;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}



	
	
	
	
	
	

}
