package a12;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bonos {
	public BufferedImage pointsblue;
	public BufferedImage pointsblue1;
	public BufferedImage pointsblue2;
	public BufferedImage pointsblue3;
	public BufferedImage pointsblue4;
	public BufferedImage pointsred1;
	public BufferedImage pointsred2;
	public int x;
	private int y;
	
	public Bonos(int x,int y){
		String point="pics\\10.png";
		String point1="pics\\10.png";
		String point2="pics\\10.png";
		String point3="pics\\10.png";
		String point4="pics\\10.png";
		String pointred1="pics\\11.png";
		String pointred2="pics\\11.png";
		try {
			pointsblue = ImageIO.read(new File(point));
			pointsblue1 = ImageIO.read(new File(point1));
			pointsblue2 = ImageIO.read(new File(point2));
			pointsblue3 = ImageIO.read(new File(point3));
			pointsblue4 = ImageIO.read(new File(point4));
			pointsred1 = ImageIO.read(new File(pointred1));
			pointsred2 = ImageIO.read(new File(pointred2));


			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
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

}

