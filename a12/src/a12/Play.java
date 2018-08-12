package a12;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
public class Play extends  JPanel implements KeyListener , Runnable{
	 Main app;
	 JLabel lblNewLabel_1;
	 Smile sm;
	 Smile sm1;
	 Smile sm2;
	 Smile sm3;
	 Bonos pont;
	 Bonos pont1;
	 Bonos pont2;
	 Bonos pont3;
	 Bonos pont4;
	 Bonos pontred1;
	 Bonos pontred2;
	 private Image img = new ImageIcon("pics/60.png").getImage();
	 private Image img1 = new ImageIcon("pics/80.png").getImage();
	 private Image img2 = new ImageIcon("pics/90.png").getImage();
	 private Image img3 = new ImageIcon("pics/100.png").getImage();
	 
	 boolean isStop=false,play_b=false,end=false;
	 int pX[][],pY[][],temp=50,temp1=50,ok[][];
	 int b=0;
	 float p=32,o=30,velx=0,vely=0,x1=35,y1=30,x1_old=35,y1_old=30,length=50,width=50,p1=100,o1=50,x_red=850,y_red=400,velx_ghost=0,vely_ghost=0;
	 int count=0;
	 int flag=1,flag3,flag4,flag5,flag6,flag7,flag8=0 ;
	 int k=100;
	 int j,i;
	  private int Score=0,bonus=20,bonus2=20 , bonus3=20,bonus4=20,bonus5=20,points;
	 public BufferedImage points1;
	//int a,b,length,width;
 	ScrollPane scrollLeft = new ScrollPane();
	ScrollPane scrollRight = new ScrollPane();
	ScrollPane scrollDown = new ScrollPane();
	ScrollPane scrollUp = new ScrollPane();
	ScrollPane scrollDownLeft = new ScrollPane();
	ScrollPane scrollDownRight = new ScrollPane();
	ScrollPane scrollUpLeft = new ScrollPane();
	ScrollPane scrollUpRight = new ScrollPane();
	ScrollPane scrollDown_1 = new ScrollPane();
	ScrollPane scrollUp_1 = new ScrollPane();
	ScrollPane scrollLeft_1 = new ScrollPane();
	ScrollPane scrollLeft_2 = new ScrollPane();
	ScrollPane scrollRight_1 = new ScrollPane();
	ScrollPane scrollRight_2 = new ScrollPane();
	ScrollPane scrollDown_2 = new ScrollPane();
	ScrollPane scrollUp_2 = new ScrollPane();
	ScrollPane scrollUp_3 = new ScrollPane();
	ScrollPane scrollUp_4 = new ScrollPane();
	ScrollPane scrollUp_5 = new ScrollPane();
	ScrollPane scrollUp_6 = new ScrollPane();
	ScrollPane scrollUp_7 = new ScrollPane();
	ScrollPane scrollUp_8 = new ScrollPane();
	ScrollPane scrollUp_9 = new ScrollPane();
	ScrollPane scrollUp_10 = new ScrollPane();
	ScrollPane scrollUp_11 = new ScrollPane();
	ScrollPane scrollUp_12 = new ScrollPane();
	ScrollPane scrollUp_13 = new ScrollPane();
	private Graphics g;
	private Graphics h;
	private ImageObserver observer;
	Ghost ghost[] = new Ghost[5];

	 
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
    	

			if(flag==1){
				
				g2.drawImage(sm.smiley,(int)p , (int)o,(int)length,(int) width, this);
				
			}
			if(flag==2){
				g2.drawImage(sm3.smiley3,(int)p , (int)o,(int)length,(int) width, this);
				
			}
			if(flag==3){
				g2.drawImage(sm2.smiley2,(int)p , (int)o,(int)length,(int) width, this);
				
			}
			if(flag==4){
				g2.drawImage(sm1.smiley1,(int)p , (int)o,(int)length,(int) width, this);
				
			}
	
			g2.setColor(Color.green);
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					if(ok[i][j]==0){
							  g2.drawImage(points1,(int)pX[i][j], (int)pY[i][j],(int)20,(int) 20, this);
							  g2.draw(points_getBounds((int)pX[i][j], (int)pY[i][j],(int)20,(int) 20));
					} 
					
				}
			}  	
		 
 				/*	red rectangle emojy */
			g2.setColor(Color.red);
	        g2.draw(player_getBounds());
				if(flag3==0){	
					g2.drawImage(pont.pointsblue,(int)920 , (int)30,(int)40,(int) 40, this);
				//	g2.draw(points_getBound1((int)920, (int)30,(int)40,(int) 40));
 				
				}
				if(flag4==0){
					g2.drawImage(pont1.pointsblue1,(int)920 , (int)680,(int)40,(int) 40, this);
				//	g2.draw( points_getBound1((int)920 , (int)680,(int)40,(int) 40));
				
				}
			
				if(flag5==0){
					g2.drawImage(pont2.pointsblue2,(int)40 , (int)680,(int)40,(int) 40, this);
					g2.draw( points_getBound1((int)40  , (int)680,(int)40,(int) 40));
			
				}
				
				if(flag6==0){
					g2.drawImage(pont3.pointsblue3,(int)530 , (int)30,(int)40,(int) 40, this);
					 	g2.draw( points_getBound1((int)530  , (int)30,(int)40,(int) 40));

				}
				
				if(flag7==0){
					g2.drawImage(pont4.pointsblue4,(int)530 , (int)680,(int)40,(int) 40, this);
 
				}			
				 
			
				g2.drawImage(pontred1.pointsred1,(int)880 , (int)350,(int)40,(int) 40, this);
				g2.drawImage(pontred2.pointsred2,(int)80 , (int)350,(int)40,(int) 40, this);

				g2.draw(ghost_red());
                // draw GHOST
				g2.drawImage(img, ghost[0].getX(), ghost[0].getY(),50,50, this);
				g2.drawImage(img1, ghost[1].getX(), ghost[1].getY(),50,50, this);
				g2.drawImage(img2, ghost[2].getX(), ghost[2].getY(),50,50, this);
				g2.drawImage(img3, ghost[3].getX(), ghost[3].getY(),50,50, this);
				g2.setFont(new Font("David",Font.BOLD,24));
				g2.drawString("Score: "+Score, 50, 780);
		p += velx;
		o += vely;
		x1_old=x1;
		y1_old=y1;
		x1 += velx;
		y1 += vely;
		x_red+=4;
		 ghost[0].setX((int)x_red);
	
		synchronized(this){
		play_b=true;
		}
		repaint();
		stopSmile();
		stopghost();
	}
	
	
	public Play(Main app){
	this.app=app;
	//yellow circles
	String str = "pics\\232.png";
	
	Thread thread = new Thread(this);
	thread.start();
	
	ghost[0] = new Ghost(850,400);
	ghost[1] = new Ghost(450,100);
	ghost[2] = new Ghost(160,200);
	ghost[3] = new Ghost(200,500);

	
	try {
		points1 = ImageIO.read(new File(str));
	
	
		
		} 
	catch (IOException e) {
		
		e.printStackTrace();
	}

	pX= new int[10][10];
	pY= new int[10][10];
	ok= new int[10][10];

	
	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++,b++){
			pX[i][j]=temp;
			pY[i][j]=temp1;
			temp+=98;
			
			points_getBounds(pX[i][j],pY[i][j],20,20);
			ok[i][j]=0;
		}
		temp=50;
		temp1+=70;
	}
	ghost_red();
	player_getBounds();
	points_getBound1(920,30,40,40);
	points_getBound2(920,680,40,40);
	points_getBound3(40,680,40,40);
	points_getBound4(530,30,40,40);
	points_getBound5(530,680,40,40);

	sm=new Smile(50,50);   
	sm1=new Smile(50,50);    
	sm2=new Smile(50,50);
	sm3=new Smile(50,50);
	pont=new Bonos(50,50);
	pont1=new Bonos(50,50);
	pont2=new Bonos(50,50);
	pont3=new Bonos(50,50);
	pont4=new Bonos(50,50);
	pontred1=new Bonos(50,50);
	pontred2=new Bonos(50,50);
	
	
	app.changeSize(1000, 850);

	setLayout(null);
	setBackground(Color.black);
	
	
	scrollLeft.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollLeft.setBounds(1, 0, 25, 750);
	scrollLeft.setForeground(Color.BLUE);        // Set left//
	scrollLeft.setBackground(Color.black);
	add(scrollLeft);
	
	scrollRight.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollRight.setBounds(970, 0, 25,750);
	scrollRight.setForeground(Color.BLUE);  //Set Right//
	scrollRight.setBackground(Color.BLACK);
	add(scrollRight);
	
	
	scrollDown.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollDown.setBounds(20, 725,950, 25);
	scrollDown.setForeground(Color.BLUE);  // set Down//
	scrollDown.setBackground(Color.BLACK);
	add(scrollDown);
	
	scrollUp.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp.setBounds(0, 1,970, 25);
	scrollUp.setForeground(Color.BLUE); //set UP// 
	scrollUp.setBackground(Color.BLACK);
	add(scrollUp);
	
	scrollDownLeft.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollDownLeft.setBounds(180, 610, 40, 120);
	scrollDownLeft.setForeground(Color.BLUE);   //set down Left//
	scrollDownLeft.setBackground(Color.BLACK);
	add(scrollDownLeft);
	
	
	scrollDownRight.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollDownRight.setBounds(780, 610, 40, 120);
	scrollDownRight.setForeground(Color.BLUE);              //set down Right//
	scrollDownRight.setBackground(Color.BLACK);
	add(scrollDownRight);
	
	
	
	scrollUpLeft.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUpLeft.setBounds(180, 25, 40, 120); 
	scrollUpLeft.setForeground(Color.BLUE);   //set Up left//
	scrollUpLeft.setBackground(Color.BLACK);
	add(scrollUpLeft);
	
	scrollUpRight.setFont(new Font("Arial", Font.PLAIN, 50));
	scrollUpRight.setBounds(780,25, 40, 120);
	scrollUpRight.setForeground(Color.BLUE);   //set up Right//
	scrollUpRight.setBackground(Color.BLACK);
	add(scrollUpRight);
	
	scrollDown_1.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollDown_1.setBounds(280, 510,440, 60);
	scrollDown_1.setForeground(Color.BLUE); //set down_1 //
	scrollDown_1.setBackground(Color.BLACK);
	add(scrollDown_1);
	
	scrollUp_1.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_1.setBounds(280, 180,440, 55);
	scrollUp_1.setForeground(Color.BLUE); //set Up_1 ****//
	scrollUp_1.setBackground(Color.BLACK);
	add(scrollUp_1);
	
	scrollLeft_1.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollLeft_1.setBounds(208, 300,110, 25);
	scrollLeft_1.setForeground(Color.BLUE); //set Left_1 ***//
	scrollLeft_1.setBackground(Color.BLACK);
	add(scrollLeft_1);
	
	scrollLeft_2.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollLeft_2.setBounds(208, 425,110, 25);
	scrollLeft_2.setForeground(Color.BLUE); //set Left_2 //
	scrollLeft_2.setBackground(Color.BLACK);
	add(scrollLeft_2);
	
	scrollRight_1.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollRight_1.setBounds(680, 300,110, 25);
	scrollRight_1.setForeground(Color.BLUE); //set Right_1 //
	scrollRight_1.setBackground(Color.BLACK);
	add(scrollRight_1);
	
	scrollRight_2.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollRight_2.setBounds(680, 425,110, 25);
	scrollRight_2.setForeground(Color.BLUE); //set Right_2 //
	scrollRight_2.setBackground(Color.BLACK);
	add(scrollRight_2);
	
	scrollDown_2.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollDown_2.setBounds(380, 420,220, 30);
	scrollDown_2.setForeground(Color.BLUE); //set down_2 //
	scrollDown_2.setBackground(Color.BLACK);
	add(scrollDown_2);
	
	scrollUp_2.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_2.setBounds(380, 300,50, 25);
	scrollUp_2.setForeground(Color.BLUE); //set Up_2 //
	scrollUp_2.setBackground(Color.BLACK);
	add(scrollUp_2);
	
	scrollUp_3.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_3.setBounds(550, 300,50, 25);
	scrollUp_3.setForeground(Color.BLUE); //set Up_3 //
	scrollUp_3.setBackground(Color.BLACK);
	add(scrollUp_3);
	
	scrollUp_6.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_6.setBounds(380, 320, 25, 100);
	scrollUp_6.setForeground(Color.BLUE); //set Up_6 //
	scrollUp_6.setBackground(Color.BLACK);
	add(scrollUp_6);
	
	scrollUp_7.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_7.setBounds(575, 320, 25, 100);
	scrollUp_7.setForeground(Color.BLUE); //set Up_7 //
	scrollUp_7.setBackground(Color.BLACK);
	add(scrollUp_7);
	
	scrollUp_8.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_8.setBounds(100, 100, 25, 120);
	scrollUp_8.setForeground(Color.BLUE); //set Up_8 מקום בהתחלה  //
	scrollUp_8.setBackground(Color.BLACK);
	add(scrollUp_8);
	
	scrollUp_9.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_9.setBounds(100, 500, 25, 120);
	scrollUp_9.setForeground(Color.BLUE); //set Up_9 מלמטעה  מקום בהתחלה  //
	scrollUp_9.setBackground(Color.BLACK);
	add(scrollUp_9);
	
	scrollUp_10.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_10.setBounds(208, 320, 25, 110);
	scrollUp_10.setForeground(Color.BLUE); //set Up_10  באמצע  מקום בהתחלה  //
	scrollUp_10.setBackground(Color.BLACK);
	add(scrollUp_10);
	
	
	scrollUp_11.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_11.setBounds(765, 320, 25, 110);
	scrollUp_11.setForeground(Color.BLUE); //set Up_11  באמצע  מקום בסוף  //
	scrollUp_11.setBackground(Color.BLACK);
	add(scrollUp_11);
	
	
	scrollUp_12.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_12.setBounds(880, 100, 25, 120);
	scrollUp_12.setForeground(Color.BLUE); //set Up_12 מקום בסוף  //
	scrollUp_12.setBackground(Color.BLACK);
	add(scrollUp_12);
	
	
	scrollUp_13.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollUp_13.setBounds(880, 500, 25, 120);
	scrollUp_13.setForeground(Color.BLUE); //set Up_13 מלמטעה  מקום בסוף  //
	scrollUp_13.setBackground(Color.BLACK);
	add(scrollUp_13);
	
	addKeyListener(this);
	
	
	}

	
	public Rectangle player_getBounds(){
		return new Rectangle((int)p,(int)o,(int)length,(int)width);
	}
	public Rectangle points_getBounds(int x,int y,int h,int w){
		return new Rectangle(x,y,h,w);
	}
	public Rectangle points_getBound1(int x1,int y1,int h1,int w1){
		return new Rectangle(x1,y1,h1,w1);
	}
	public Rectangle points_getBound2(int x1,int y1,int h1,int w1){
		return new Rectangle(x1,y1,h1,w1);
	}
	
	public Rectangle points_getBound3(int x1,int y1,int h1,int w1){
		return new Rectangle(x1,y1,h1,w1);
	}
	
	public Rectangle points_getBound4(int x1,int y1,int h1,int w1){
		return new Rectangle(x1,y1,h1,w1);
	}
	
	public Rectangle points_getBound5(int x1,int y1,int h1,int w1){
		return new Rectangle(x1,y1,h1,w1);
	}
	public Rectangle ghost_red(){
		return new Rectangle((int)ghost[0].getX(),(int)ghost[0].getY(),(int)50,(int)50);
	}
	 
	public void stop(){
for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(player_getBounds().intersects(points_getBounds((int)pX[i][j], (int)pY[i][j],(int)20,(int) 20)))
				{
				ok[i][j]=1;
			  

 				}
				 if(ok[i][j]==0)
  				{
 					 points=0;
				 Score+=points;
 				}else {
 					
 				}
 	            }
	            }
 
		 
 		//bounosfor(int t=0;t<1;t++)
		
		 if(player_getBounds().intersects(points_getBound1((int)940, (int)30,(int)20,(int) 20))){
			Score+=bonus ;
			
	          flag3=1;
	        

   		     } 
		 if (flag3==1)
          {
	         bonus=0;
	       }
 		if(player_getBounds().intersects(points_getBound2((int)940, (int)680,(int)20,(int) 20))){
			
			flag4=1;
 Score+=bonus2;
		} 
 		if(flag4==1) {
 			bonus2=0;
 		}
		if(player_getBounds().intersects(points_getBound3((int)35, (int)680,(int)20,(int) 20))){
		 
			Score+=bonus3;
			flag5=1;
			 
   		} 
		  if (flag5==1)
   		{
   			bonus3= 0;
 
		}
		  
		if(player_getBounds().intersects(points_getBound4((int)540, (int)50,(int)20,(int) 20))){
			
			flag6=1;
			Score+=bonus4;
 		}
		  if (flag6==1)
	   		{
	   			bonus4= 0;
	 
			}
		if(player_getBounds().intersects(points_getBound4((int)540, (int)680,(int)20,(int) 20))){
			
			flag7=1;
			Score+=bonus5;
		 		}
		  if (flag7==1)
	   		{
	   			bonus5= 0;
	 
			}
		  
		//with red ghost
	if(player_getBounds().intersects( ghost_red())){
			
			//System.out.println("ameer21");
		
		}
	
		
			if(x1<30)
			{
				velx=0;
				p=(float) 29;
				x1+=1;
			
			}
				if(x1>920){//הגבול בצד  שמול וימין
			
				velx=0;
				p=(float) 919;
				x1-=1;
  
			}
			if(y1>677)
			{
				o=(float) 676;
				y1-=1;
			vely=0;	
		
			}
				if(y1<30)//הגבול למטה ומעלה
			{
					o=(float) 29;
					y1+=1;
				vely=0;	
			
				
				
			
			}
		
	
			if(x1+50>=scrollUp_13.getBounds().getX() && x1<=scrollUp_13.getBounds().getX()+scrollUp_13.getBounds().getWidth()&& y1+50>=scrollUp_13.getBounds().getY() && y1<=scrollUp_13.getBounds().getY()+scrollUp_13.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
			
					
					x1-=1;
					velx=0;
					p=(float) (scrollUp_13.getBounds().getX()-50);
					
				}
				else if(x1<x1_old)
				{
				
					x1+=1;
					velx=0;
					p=(float) (scrollUp_13.getBounds().getX()+scrollUp_13.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					
					y1-=1;
					vely=0;
					o=(float) scrollUp_13.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_13.getBounds().getY()+scrollUp_13.getBounds().getHeight());
					System.out.println(o);
				}
			}		
		
			if(x1+50>=scrollUp_12.getBounds().getX() && x1<=scrollUp_12.getBounds().getX()+scrollUp_12.getBounds().getWidth()&& y1+50>=scrollUp_12.getBounds().getY() && y1<=scrollUp_12.getBounds().getY()+scrollUp_12.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
			
					
					x1-=1;
					velx=0;
					p=(float) (scrollUp_12.getBounds().getX()-50);
					
				}
				else if(x1<x1_old)
				{
				
					x1+=1;
					velx=0;
					p=(float) (scrollUp_12.getBounds().getX()+scrollUp_12.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					
					y1-=1;
					vely=0;
					o=(float) scrollUp_12.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_12.getBounds().getY()+scrollUp_12.getBounds().getHeight());
					System.out.println(o);
				}
			}
			
			if(x1+50>=scrollUp_11.getBounds().getX() && x1<=scrollUp_11.getBounds().getX()+scrollUp_11.getBounds().getWidth()&& y1+50>=scrollUp_11.getBounds().getY() && y1<=scrollUp_11.getBounds().getY()+scrollUp_11.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
			
					
					x1-=1;
					velx=0;
					p=(float) (scrollUp_11.getBounds().getX()-50);
					
				}
				else if(x1<x1_old)
				{
				
					x1+=1;
					velx=0;
					p=(float) (scrollUp_11.getBounds().getX()+scrollUp_11.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					
					y1-=1;
					vely=0;
					o=(float) scrollUp_11.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_11.getBounds().getY()+scrollUp_11.getBounds().getHeight());
					System.out.println(o);
				}
			}
			if(x1+50>=scrollUp_10.getBounds().getX() && x1<=scrollUp_10.getBounds().getX()+scrollUp_10.getBounds().getWidth()&& y1+50>=scrollUp_10.getBounds().getY() && y1<=scrollUp_10.getBounds().getY()+scrollUp_11.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
			
					
					x1-=1;
					velx=0;
					p=(float) (scrollUp_10.getBounds().getX()-50);
					
				}
				else if(x1<x1_old)
				{
				
					x1+=1;
					velx=0;
					p=(float) (scrollUp_10.getBounds().getX()+scrollUp_10.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					
					y1-=1;
					vely=0;
					o=(float) scrollUp_10.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_10.getBounds().getY()+scrollUp_10.getBounds().getHeight());
					System.out.println(o);
				}
			}
			if(x1+50>=scrollUp_9.getBounds().getX() && x1<=scrollUp_9.getBounds().getX()+scrollUp_9.getBounds().getWidth()&& y1+50>=scrollUp_9.getBounds().getY() && y1<=scrollUp_9.getBounds().getY()+scrollUp_9.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
			
					
					x1-=1;
					velx=0;
					p=(float) (scrollUp_9.getBounds().getX()-50);
					
				}
				else if(x1<x1_old)
				{
				
					x1+=1;
					velx=0;
					p=(float) (scrollUp_9.getBounds().getX()+scrollUp_9.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					
					y1-=1;
					vely=0;
					o=(float) scrollUp_9.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_9.getBounds().getY()+scrollUp_9.getBounds().getHeight());
					System.out.println(o);
				}
			}
			if(x1+50>=scrollUp_8.getBounds().getX() && x1<=scrollUp_8.getBounds().getX()+scrollUp_8.getBounds().getWidth()&& y1+50>=scrollUp_8.getBounds().getY() && y1<=scrollUp_8.getBounds().getY()+scrollUp_8.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					p=(float) (scrollUp_8.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_8.getBounds().getX()+scrollUp_8.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUp_8.getBounds().getY()-50;
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUp_8.getBounds().getY()+scrollUp_8.getBounds().getHeight());
					System.out.println(o);
				}
			}
			if(x1+50>=scrollUp_7.getBounds().getX() && x1<=scrollUp_7.getBounds().getX()+scrollUp_7.getBounds().getWidth()&& y1+50>=scrollUp_7.getBounds().getY() && y1<=scrollUp_7.getBounds().getY()+scrollUp_7.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUp_7.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_7.getBounds().getX()+scrollUp_7.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUp_7.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUp_7.getBounds().getY()+scrollUp_7.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUp_6.getBounds().getX() && x1<=scrollUp_6.getBounds().getX()+scrollUp_6.getBounds().getWidth()&& y1+50>=scrollUp_6.getBounds().getY() && y1<=scrollUp_6.getBounds().getY()+scrollUp_6.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUp_6.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_6.getBounds().getX()+scrollUp_6.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUp_6.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUp_6.getBounds().getY()+scrollUp_6.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUp_3.getBounds().getX() && x1<=scrollUp_3.getBounds().getX()+scrollUp_3.getBounds().getWidth()&& y1+50>=scrollUp_3.getBounds().getY() && y1<=scrollUp_3.getBounds().getY()+scrollUp_3.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUp_3.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_3.getBounds().getX()+scrollUp_3.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUp_3.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUp_3.getBounds().getY()+scrollUp_3.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUp_2.getBounds().getX() && x1<=scrollUp_2.getBounds().getX()+scrollUp_2.getBounds().getWidth()&& y1+50>=scrollUp_2.getBounds().getY() && y1<=scrollUp_2.getBounds().getY()+scrollUp_2.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUp_2.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_2.getBounds().getX()+scrollUp_2.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUp_2.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUp_2.getBounds().getY()+scrollUp_2.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollDown_2.getBounds().getX() && x1<=scrollDown_2.getBounds().getX()+scrollDown_2.getBounds().getWidth()&& y1+50>=scrollDown_2.getBounds().getY() && y1<=scrollDown_2.getBounds().getY()+scrollDown_2.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollDown_2.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollDown_2.getBounds().getX()+scrollDown_2.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollDown_2.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollDown_2.getBounds().getY()+scrollDown_2.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollRight_2.getBounds().getX() && x1<=scrollRight_2.getBounds().getX()+scrollRight_2.getBounds().getWidth()&& y1+50>=scrollRight_2.getBounds().getY() && y1<=scrollRight_2.getBounds().getY()+scrollRight_2.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollRight_2.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollRight_2.getBounds().getX()+scrollRight_2.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollRight_2.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollRight_2.getBounds().getY()+scrollRight_2.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollRight_1.getBounds().getX() && x1<=scrollRight_1.getBounds().getX()+scrollRight_1.getBounds().getWidth()&& y1+50>=scrollRight_1.getBounds().getY() && y1<=scrollRight_1.getBounds().getY()+scrollRight_1.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollRight_1.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollRight_1.getBounds().getX()+scrollRight_1.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollRight_1.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollRight_1.getBounds().getY()+scrollRight_1.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollLeft_2.getBounds().getX() && x1<=scrollLeft_2.getBounds().getX()+scrollLeft_2.getBounds().getWidth()&& y1+50>=scrollLeft_2.getBounds().getY() && y1<=scrollLeft_2.getBounds().getY()+scrollLeft_2.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollLeft_2.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollLeft_2.getBounds().getX()+scrollLeft_2.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollLeft_2.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollLeft_2.getBounds().getY()+scrollLeft_2.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollLeft_1.getBounds().getX() && x1<=scrollLeft_1.getBounds().getX()+scrollLeft_1.getBounds().getWidth()&& y1+50>=scrollLeft_1.getBounds().getY() && y1<=scrollLeft_1.getBounds().getY()+scrollLeft_1.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollLeft_1.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollLeft_1.getBounds().getX()+scrollLeft_1.getBounds().getWidth());
				
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollLeft_1.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollLeft_1.getBounds().getY()+scrollLeft_1.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUp_1.getBounds().getX() && x1<=scrollUp_1.getBounds().getX()+scrollUp_1.getBounds().getWidth()&& y1+50>=scrollUp_1.getBounds().getY() && y1<=scrollUp_1.getBounds().getY()+scrollUp_1.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUp_1.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUp_1.getBounds().getX()+scrollUp_1.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
				
					y1-=1;
					vely=0;
					o=(float) scrollUp_1.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
					}
				else if(y1<y1_old)
				{
					
					y1+=1;
					vely=0;
					o=(float) (scrollUp_1.getBounds().getY()+scrollUp_1.getBounds().getHeight());
					
					
				}
			}
			if(x1+50>=scrollDown_1.getBounds().getX() && x1<=scrollDown_1.getBounds().getX()+scrollDown_1.getBounds().getWidth()&& y1+50>=scrollDown_1.getBounds().getY() && y1<=scrollDown_1.getBounds().getY()+scrollDown_1.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollDown_1.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollDown_1.getBounds().getX()+scrollDown_1.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollDown_1.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollDown_1.getBounds().getY()+scrollDown_1.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUpRight.getBounds().getX() && x1<=scrollUpRight.getBounds().getX()+scrollUpRight.getBounds().getWidth()&& y1+50>=scrollUpRight.getBounds().getY() && y1<=scrollUpRight.getBounds().getY()+scrollUpRight.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUpRight.getBounds().getX()-50);
					 
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUpRight.getBounds().getX()+scrollUpRight.getBounds().getWidth());
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUpRight.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUpRight.getBounds().getY()+scrollUpRight.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollUpLeft.getBounds().getX() && x1<=scrollUpLeft.getBounds().getX()+scrollUpLeft.getBounds().getWidth()&& y1+50>=scrollUpLeft.getBounds().getY() && y1<=scrollUpLeft.getBounds().getY()+scrollUpLeft.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollUpLeft.getBounds().getX()-50); 
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollUpLeft.getBounds().getX()+scrollUpLeft.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollUpLeft.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollUpLeft.getBounds().getY()+scrollUpLeft.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollDownRight.getBounds().getX() && x1<=scrollDownRight.getBounds().getX()+scrollDownRight.getBounds().getWidth()&& y1+50>=scrollDownRight.getBounds().getY() && y1<=scrollDownRight.getBounds().getY()+scrollDownRight.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollDownRight.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollDownRight.getBounds().getX()+scrollDownRight.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollDownRight.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollDownRight.getBounds().getY()+scrollDownRight.getBounds().getHeight());
				}
			}
			if(x1+50>=scrollDownLeft.getBounds().getX() && x1<=scrollDownLeft.getBounds().getX()+scrollDownLeft.getBounds().getWidth()&& y1+50>=scrollDownLeft.getBounds().getY() && y1<=scrollDownLeft.getBounds().getY()+scrollDownLeft.getBounds().getHeight())
			{				
				if(x1>x1_old)
				{
					x1-=1;
					velx=0;
					 p= (float) ( scrollDownLeft.getBounds().getX()-50);
				}
				else if(x1<x1_old)
				{
					x1+=1;
					velx=0;
					p=(float) (scrollDownLeft.getBounds().getX()+scrollDownLeft.getBounds().getWidth());
			
				}
				else if(y1>y1_old)
				{
					y1-=1;
					vely=0;
					o=(float) scrollDownLeft.getBounds().getY()-50;
					System.out.println(y1_old);
					System.out.println(o);
				}
				else if(y1<y1_old)
				{
					y1+=1;
					vely=0;
					o=(float) (scrollDownLeft.getBounds().getY()+scrollDownLeft.getBounds().getHeight());
				}
			}   				 
 
	}
	 
	  
	@Override  
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_D)
		{
			velx=(float) 0.4;
			flag=1;
			vely=0;
			
		}
		if(e.getKeyCode()== KeyEvent.VK_W)
		{
			velx=0;
			vely=(float) -0.4;	
			flag=2;	
		}
		if(e.getKeyCode()== KeyEvent.VK_A)
		{
			vely=0;
			velx=(float) -0.4;	
		flag=3;	
		}
		if(e.getKeyCode()== KeyEvent.VK_S)
		{
			velx=0;
			vely=(float) 0.4;
		flag=4;	
		}
		if(e.getKeyCode()== KeyEvent.VK_P)
		{

			velx=0;
			vely=0;	
		}
		
	}
	public void stopghost()
	{
		if(x_red<920)
		{
			x_red=900;
		}
	}
	public void stopSmile()
	{  
		if(isStop==false)	
		{
			
		if((int)p > (50-15) && (int)p < (50+62))
		{
			System.out.println(p);
			if((int)o > (350-30) && (int)o < (350+40))
			{			
				try {
					isStop = true;
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if((int)p > (880-20) && (int)p < (880+62))
		{
			if((int)o > (350-30) && (int)o < (350+40))
			{
				try {
					isStop = true;
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		}
			if(((int)p <= (50-15) || ((int)p >= (50+54) && (int)p >= 880 ))&& ((int)o <= (350-34) || (int)o >= (350+46)))
			{			 
				isStop = false;
			}
			if( (((int)p <= (880-26) && (int)p >= 50+54) || (int)p >= (880+26)) &&  ((int)o <= (350-24) || (int)o >= (350+46)))
			{
				isStop = false;
			}
	} 
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	 public void run() {
 		 while(end == false)
		 {
			//synchronized(this)
			System.out.flush();
			{
			if(play_b==true)
			{
 				stop();	
 			}
			}
		 }
	}
	
 }



