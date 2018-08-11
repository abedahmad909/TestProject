package a12;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class myusername extends JPanel{
	private JButton DeleteButton,BackButton,PlayButton;

	private JLabel UserNameLabel,PasswordLabel,label_1,label;
	private JPasswordField PasswordTextField = new JPasswordField(10);
	private JTextField UserNameTextField;
	Main app;
	public myusername(Main app){
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
	
	
	DeleteButton = new JButton("Delete");
	DeleteButton.setBounds(280, 405, 78, 45);
	DeleteButton.setBackground (Color.RED);
	DeleteButton.setForeground(Color.WHITE);
	add(DeleteButton);
	DeleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				Statement stmt=con.createStatement();
				String sql ="delete from `users` where username='"+UserNameTextField.getText()+"'";
				int a=stmt.executeUpdate(sql);
		         if(a!=0) {
			       JOptionPane.showMessageDialog(null,"Deleted sucessfully..");
			         }
		         else
			       JOptionPane.showMessageDialog(null,"incorrect username");
			        con.close();
		        	 }catch(Exception e) {System.out.print(e);}
		}
	});
	BackButton = new JButton("Back");
	BackButton.setBounds(105, 405, 78, 45);
	BackButton.setBackground (Color.RED);
	BackButton.setForeground(Color.WHITE);
	add(BackButton);
	BackButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			app.changePanel(new Start(app));

		}
			});
	
	PlayButton = new JButton("PLAY");
	PlayButton.setBounds(190, 405, 78, 45);
	PlayButton.setBackground (Color.RED);
	PlayButton.setForeground(Color.WHITE);
	PlayButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			app.changePanel(new Play(app));}});
 
	add(PlayButton);
	add(BackButton);
	add(UserNameLabel);
	add(UserNameTextField);
	add(PasswordLabel);
	add(PasswordTextField); 
}
}