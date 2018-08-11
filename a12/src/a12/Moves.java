package a12;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Moves extends JPanel implements Runnable,KeyListener  {
	private Thread thread;
	private boolean running;
	private long Time;
	public void addNotify(){
		super.addNotify();
		thread=new Thread(this);
		thread.start();
		
	}
	public void run() {
		if(running) return;
			init();
		
		
	}
	public void setFPS(int fps){
		Time=1000/fps;
	}
	
	
	private void init() {
		
		setFPS(10);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
