package CarGallery.Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

 


public class Login extends JFrame {

	private JPanel contentPane1; 
	private JTextField username;
	private JTextField password;
 
  
    
    // define user name and password
    String usernme="a";
    String pasword="a";
    
    
    
	public String [] pword= {usernme,pasword};
	public Login() {
		   
	       
		// create a user interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 447, 290);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		 
		
		contentPane1.setLayout(null);
		contentPane1.setBackground(new Color(255, 140, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 60, 414, 180);
		contentPane1.add(tabbedPane);
	
		JPanel login = new JPanel();
		
		login.setBackground(Color.cyan.brighter());
		tabbedPane.addTab("LOGIN", null, login, null);
		login.setLayout(null);
		
		
		username  = new JTextField();
		username.setBounds(101, 16, 144, 30);
		login.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		
		password.setBounds(101, 60, 144, 30);
		login.add(password);
		password.setColumns(10);
		
		JLabel hidepasslabel = new JLabel("HIDE");
		hidepasslabel.setForeground(new Color(0, 0, 205));
		hidepasslabel.setBounds(45, 100, 46, 14);
		login.add(hidepasslabel);
		
		JLabel Showpasswordlabel = new JLabel("SHOW");
		Showpasswordlabel.setForeground(new Color(0, 0, 255));
		Showpasswordlabel.setBounds(43, 111, 42, 14);
		login.add(Showpasswordlabel);
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(0, 191, 255));
		chckbxNewCheckBox.setForeground(new Color(255, 140, 0));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// show or hide password
				if (chckbxNewCheckBox.isSelected()) {
					((JPasswordField) password).setEchoChar((char)0);
				}else {
					((JPasswordField) password).setEchoChar('*');
				}
			}
		});
		
				chckbxNewCheckBox.setBounds(20, 101, 21, 24);
				login.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(275, 11, 124, 114);
		login.add(lblNewLabel);
		
		
		
	
		ImageIcon iconopen = new ImageIcon("img/openeyes.png");
		lblNewLabel.setIcon(iconopen);
	      password.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
				lblNewLabel.setIcon(iconopen);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ImageIcon iconclose = new ImageIcon("img/kapat.png");

		       
		        lblNewLabel.setIcon(iconclose);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(30, 68, 72, 14);
		login.add(lblPassword);
		
		JLabel lblUser = new JLabel("USER NAME");
		lblUser.setBounds(30, 24, 72, 14);
		login.add(lblUser);
		
		
		JButton loginbutton = new JButton("New button");
		loginbutton.setBounds(103, 101, 142, 24);
		login.add(loginbutton);
		ImageIcon iconlogin = new ImageIcon("img/logBUT1.png");		
		loginbutton.setIcon(iconlogin);
		
		JLabel lgnlabelphoto = new JLabel("");
		lgnlabelphoto.setBounds(0, 0, 409, 148);
		login.add(lgnlabelphoto);
		ImageIcon iconlgnlbl = new ImageIcon("img/beyazdortgen.png");		
		lgnlabelphoto.setIcon(iconlgnlbl);
		


		
		JLabel bgphoto = new JLabel("");
		bgphoto.setBounds(0, 0, 433, 259);
		contentPane1.add(bgphoto);
		ImageIcon iconbg = new ImageIcon("img/yeni.png");		
		bgphoto.setIcon(iconbg);
		
		
		// here we check if user enter wrong password for entering
		loginbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (username.getText().equals(pword[0]) && password.getText().equals(pword[1])) {
					
				Mainpage car=	new Mainpage();
			   car.initJFrame();
			   setVisible(false);
						
				}else if((username.getText().equals("")) ) {
					
					JOptionPane.showMessageDialog(null, "User name can not be empty! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else if((password.getText().equals(""))) {
					
					JOptionPane.showMessageDialog(null, "Password can not be empty! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else if((username.getText().equals("")) && (password.getText().equals(""))) {
					
					JOptionPane.showMessageDialog(null, "It can not be empty! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else if(!(username.getText().equals(""))) {
					
					JOptionPane.showMessageDialog(null, "Wrong User Name! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else if((username.getText().equals(pword[0])) && !(password.getText().equals(pword[1]))  ) {
					
					JOptionPane.showMessageDialog(null, "Wrong Password! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else if( !(password.getText().equals(""))) {
					
					JOptionPane.showMessageDialog(null, "Wrong Password! Try again.","",  JOptionPane.OK_OPTION);
		          		               			
				}else {
					JOptionPane.showMessageDialog(null, "Wrong password! Try again.", "", JOptionPane.OK_OPTION);
				}
			}
		});
	}
}

