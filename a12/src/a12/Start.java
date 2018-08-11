package a12;
import java.sql.*;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Start extends JPanel  {
	private JPanel contentPane;

	private JLabel UserNameLabel,PasswordLabel,label_1,label;
	private JTextField UserNameTextField;
	private JPasswordField PasswordTextField = new JPasswordField(10);
	private JButton LoginButton,SignUpButton;
	


	
	Main app;
	public Start(Main app){
	this.app=app;

	
	setSize(500, 500);


	setLayout(null);


	setBackground(Color.green);


	UserNameLabel = new JLabel("UserName");
	UserNameLabel.setBounds(222, 50, 100, 50);
	UserNameLabel.setForeground(Color.BLUE);
	
	UserNameTextField = new JTextField("",15);
	UserNameTextField.setBounds(149, 90, 200, 40);		
	UserNameTextField.setColumns(10);
	
	PasswordLabel = new JLabel("Password");
	PasswordLabel.setForeground(Color.blue);
	PasswordLabel.setBounds(222, 130, 100, 50);
	
	PasswordTextField.setBounds(149, 170, 200, 40);
	PasswordTextField.setFont(new Font("Serif", Font.PLAIN, 20));
	
 
		
	SignUpButton = new JButton("Sign up");
	SignUpButton.setBounds(396, 405, 78, 45);
	SignUpButton.setBackground (Color.RED);
	SignUpButton.setForeground(Color.WHITE);
		add(SignUpButton);
		
		 

		
	
		
	LoginButton = new JButton("Login");
	LoginButton.setBounds(20,405, 78, 45);
	LoginButton.setBackground (Color.RED);
	LoginButton.setForeground(Color.WHITE);
	add(LoginButton);
	LoginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			app.changePanel(new Start(app));
			String admin= "admin";
			String password="123";
		
			if(admin.equalsIgnoreCase(UserNameTextField.getText()) && password.equals(PasswordTextField.getText())) {
				app.changePanel(new myusername(app));


			}else {
				Connection con=null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					Statement stmt=con.createStatement();
					String sql ="Select * from `users` where password= '"+PasswordTextField.getText()+"'and username='"+UserNameTextField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
			         if(rs.next()) {
				       JOptionPane.showMessageDialog(null,"login sucessfully..");
						app.changePanel(new Play(app));
			         }
			         else
				       JOptionPane.showMessageDialog(null,"incorrect username and password");
			        	 }catch(Exception e) {System.out.print(e);try{con.close();}catch(Exception we) {}}
			}
	
		}	


	});
	SignUpButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				Statement stmt=con.createStatement();
				String sql ="insert into users values('"+UserNameTextField.getText()+"','"+PasswordTextField.getText()+"')";
		//		if(admin.equalsIgnoreCase(UserNameTextField.getText()) && password.equals(PasswordTextField.getText()))
				int a=stmt.executeUpdate(sql);
		         if(a!=0) 
			       JOptionPane.showMessageDialog(null,"SignUp sucessfully..");
		         else
			       JOptionPane.showMessageDialog(null,"Something went wrong please try again");
			        con.close();
		        	 }catch(Exception e) {System.out.print(e);}
		}
	});
 
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon("pics/images.jpg"));
	lblNewLabel_1.setBounds(37, 105, 402, 342);
  
	add(lblNewLabel_1);
	
	add(UserNameLabel);
	add(UserNameTextField);
	add(PasswordLabel);
	add(PasswordTextField);
	
}

	

}


