package a12;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel content;
	//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMIR\\workspace\\a12\\pic\\12.png")); // icon Game
	private ImageIcon img = new ImageIcon("C:\\Users\\AMIR\\workspace\\a12\\pic\\12.png");

	Main app;
	
	JProgressBar pd;
	

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});



	}

	public Main(){
		content = new Start(this);
		add(content);
		setSize(500,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);      
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		this.setIconImage(img.getImage());
	}
	public void changeSize(int x ,int y){
		setSize(x,y);
	}
	public void changePanel (JPanel p)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		invalidate();
		getContentPane().removeAll(); 		
		getContentPane().add(p);
		setResizable(false);
		revalidate(); 
		p.requestFocusInWindow();
	}
	/**
	 * Create the frame.
	 */

}