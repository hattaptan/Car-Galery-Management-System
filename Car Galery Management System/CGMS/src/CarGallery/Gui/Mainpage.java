package CarGallery.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

 
import CarGallery.db.BuyCarDB;



public class Mainpage extends JFrame implements interfacecar{

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
			JPanel anaJPanel = initJPanel();// Generate a Panel and give it same necessary adjustments
		add(anaJPanel);
		setTitle("                                                             CAR GALLERY MANAGEMENT SYSTEM");
		setSize(745,470);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}

	@Override
	public JPanel initJPanel() {// for JLabels and ptohos divide the panel
		JPanel MainJPanel = new JPanel(new BorderLayout());
		JPanel MiddleJPanel = new  JPanel(new GridLayout(1,5,5,5));
	     JPanel UpJPanel = new JPanel(new GridLayout(10,5,5,5));
		JPanel DownJPanel = new JPanel(new GridLayout(10,5,5,5));
		JPanel LeftJPanel = new JPanel(new GridLayout(8,2,2,2));
		LeftJPanel.setBackground(Color.white);
		
		
		
	
		
		ImageIcon aplan = new ImageIcon("img/anap.png");
		 JLabel anaJLabel = new JLabel(aplan);
		 
		 MainJPanel.add(anaJLabel);
		 
		
		 
		 // CAR LIST ICON AND LABEL
		 ImageIcon car1 = new ImageIcon("img/car1.png");
		 ImageIcon car2 = new ImageIcon("img/car2.png");
		 
	 
	     JLabel buycarclick = new JLabel(car2);
	     LeftJPanel.add(buycarclick);
	     buycarclick.addMouseListener(new MouseListener() {// Buycar    JLabels as a button
			
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
			
				buycarclick.setIcon(car2);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				buycarclick.setIcon(car1);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new BuyCarGui();
			}
		});
		 
		 ImageIcon iconCarlist1 = new ImageIcon("img/carlist1.png");
		 ImageIcon iconCarlist2 = new ImageIcon("img/carlist2.png");
		 JLabel carlistclick = new JLabel(iconCarlist1);
		 LeftJPanel.add(carlistclick);
		 
		 carlistclick.addMouseListener(new MouseListener() {//  Car List   JLabels as a button
			
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
				carlistclick.setIcon(iconCarlist1);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				carlistclick.setIcon(iconCarlist2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				new BuyCarList();
			}
		});
		 
		 
		 
		 ImageIcon iconCustomer1 = new ImageIcon("img/customer1.png");
		 ImageIcon iconCustomer2 = new ImageIcon("img/customer2.png");
		 JLabel customerclick = new JLabel(iconCustomer1);
		 LeftJPanel.add(customerclick);
		 
		  customerclick.addMouseListener(new MouseListener() {//  Add Customer   JLabels as a button
			
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
				customerclick.setIcon(iconCustomer1);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				customerclick.setIcon(iconCustomer2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				new CustomerGui();
			}
		});
		 
		     ImageIcon iconCustomerlist1 = new ImageIcon("img/customerlist1.png");
			 ImageIcon iconCustomerlist2 = new ImageIcon("img/customerlist2.png");
			 JLabel customerListclick = new JLabel(iconCustomerlist1);
			 LeftJPanel.add(customerListclick);
			 customerListclick.addMouseListener(new MouseListener() {//List Customer JLabels as a button
				
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
					customerListclick.setIcon(iconCustomerlist1);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					customerListclick.setIcon(iconCustomerlist2);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					new CustomerListGui();
				}
			});
		 
			     ImageIcon sales1 = new ImageIcon("img/sales1.png");
				 ImageIcon sales2 = new ImageIcon("img/sales2.png");
				 JLabel salesclick = new JLabel(sales1);
				 LeftJPanel.add(salesclick);
		 salesclick.addMouseListener(new MouseListener() {//   Sales  JLabels as a button
			
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
				salesclick.setIcon(sales1);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				salesclick.setIcon(sales2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				new SalesGui();
				 
			}
		});
		 
	
		 
		 ImageIcon exitk = new ImageIcon("img/exitk.png");
		 
		 ImageIcon exit1 = new ImageIcon("img/exit1.png");
		 ImageIcon exit2 = new ImageIcon("img/exit2.png");
		 JLabel exitclick = new JLabel(exit1);
		 LeftJPanel.add(exitclick);
		 exitclick.addMouseListener(new MouseListener() {//   Exit  JLabels as a button
			
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
				exitclick.setIcon(exit1);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitclick.setIcon(exitk);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { // if click Exit Button, ask a question to exit or no
				// TODO Auto-generated method stub
				
				int answer = JOptionPane.showConfirmDialog(null,
						"Are Sure To Exit?", "WARNING",
						JOptionPane.YES_NO_OPTION);

				if (answer == 0) {

				    JOptionPane.showMessageDialog(null, "SYSTEM WILL SHUT DOWN.");
				    

				    System.exit(0);
				    
				}
				else{
					JOptionPane.showMessageDialog(null, "SHUTDOWN CANCELED");
					}
					
			}
		});
		 
 
		
		 MainJPanel.add(LeftJPanel,BorderLayout.WEST);
		 MainJPanel.add(MiddleJPanel,BorderLayout.EAST);
		return MainJPanel;
	}

	@Override
	public void Insert(Object Information) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object Information) {
		// TODO Auto-generated method stub
		
	}

	

}
