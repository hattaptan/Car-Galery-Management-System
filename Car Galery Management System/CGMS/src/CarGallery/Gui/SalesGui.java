package CarGallery.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Domain.CustomerDomain;
import CarGallery.Domain.SalesDomain;
import CarGallery.db.BuyCarDB;
import CarGallery.db.CustomerDB;
import CarGallery.db.SalesDB;
 


public class SalesGui extends JFrame implements interfacecar{

	
	
	public SalesGui() {
		// TODO Auto-generated constructor stub
		initJFrame();
	}

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = initJPanel();    // Generate a Panel and give it same necessary adjustments
		add(MainJPanel);
		setTitle("S E L L");
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(660, 500);
		
		
	}

	@Override
	public JPanel initJPanel() {
	 
		// TODO Auto-generated method stub
		JPanel MainJPanel = new JPanel(new BorderLayout());
		JPanel upJPanel = new JPanel(new GridLayout(5,2,5,5));
		JPanel middleJPanel = new JPanel(new GridLayout(1,2));// for texfield and button and JList divide the panel
		JPanel downJPanel = new JPanel(new GridLayout(2,5,5,5));
		
 
		
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder("SELL CAR");
		upJPanel.setBorder(titledBorder);	 
		titledBorder.setTitleColor(Color.red);		
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder("LIST OF CAR SOLD");
		middleJPanel.setBorder(titledBorder1);		 
		titledBorder1.setTitleColor(Color.red);
		
		JLabel customerJLabel = new JLabel("Customer"); // Customer Label
		upJPanel.add(customerJLabel);
		
		// here we list Customer which we have.
		final JComboBox customerBox = new JComboBox(CustomerDB.toListCustomer().toArray());
		customerBox.setRenderer(new CustomerNameRenderer());// this to list only customer name and surname
		upJPanel.add(customerBox);
		
		JLabel salesDateJLabel = new JLabel("Sale Date");// date label
		upJPanel.add(salesDateJLabel);
		
		final JDateChooser salesDateChooser = new JDateChooser();
		upJPanel.add(salesDateChooser);
		
		

		JLabel plaqueJLabel = new JLabel("Plaque ");//plaque label
		upJPanel.add(plaqueJLabel);
		
		final JComboBox plaqueBox = new JComboBox(BuyCarDB.toListCar().toArray());// we list car which we have
		plaqueBox.setRenderer(new PlaqueRenderer());// this to list only plaque of car
		upJPanel.add(plaqueBox);
		
		JLabel moneyDelayJLabel = new JLabel("Money Delay");
		upJPanel.add(moneyDelayJLabel);
		
		final JComboBox moneydalayBox = new JComboBox();
		upJPanel.add(moneydalayBox);
		
		
		moneydalayBox.addItem("0");
		moneydalayBox.addItem("3");
		moneydalayBox.addItem("6");
		moneydalayBox.addItem("9");
	
		
		JLabel salesPriceJLabel = new JLabel("Price ");
		upJPanel.add(salesPriceJLabel);
	
		final JTextField salesPriceField = new JTextField();
		upJPanel.add(salesPriceField);
		

		
		// we have  Jlist to list sales which we make.
		final JList SaleslistJList = new JList(SalesDB.toListSales().toArray());
		JScrollPane SaleslistJScrollPane = new JScrollPane(SaleslistJList);
		SaleslistJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		middleJPanel.add(SaleslistJScrollPane);
		
		 
		// the sale button
		JButton salesAddButton = new JButton("SALE");
		salesAddButton.setBackground(Color.orange);
		downJPanel.add(salesAddButton);
		
		
		// the sale delete button
		JButton deleteSaleButton = new JButton("DELETE SALE");
		 deleteSaleButton.setBackground(Color.orange);
		 downJPanel.add(deleteSaleButton);
		
		//exit button
		JButton exitButton = new JButton("EXIT");
	    exitButton.setBackground(Color.orange);
	    downJPanel.add(exitButton);
		
		salesAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				java.util.Date salesDate = salesDateChooser.getDate();
				Date salesDateSQLDate = new Date(salesDate.getTime());


				
				SalesDomain salesInfo = new SalesDomain();
				
				//in customerBox, here we get the selected value to make sale on him
				CustomerDomain selectedCustomer = (CustomerDomain) customerBox.getSelectedItem();
				
				//in Car, here we get the selected value of plaque to make sale on that car
				BuyCarDomain selectedCar = (BuyCarDomain)plaqueBox.getSelectedItem();
				
				// sent selected customer and car(plaque) for database
				salesInfo.setCustomername(selectedCustomer.getName());			 
				salesInfo.setSaletime(salesDateSQLDate);
				salesInfo.setMoneydelay(moneydalayBox.getSelectedItem().toString());
				String price=salesPriceField.getText();
				int PriceInt=Integer.parseInt(price);
				
				salesInfo.setSaleprice(PriceInt);
			 
				salesInfo.setPlaque(selectedCar.getId());
				
				int i=moneydalayBox.getSelectedIndex();
			
				//in here we have money delay operations
				String strdelaytime=salesPriceField.getText();
				int delaytime=Integer.parseInt(strdelaytime);
				int lastprice=0;
				
				if (i==0) {
					lastprice=delaytime;
				}else if (i==1) {
					lastprice = delaytime+ delaytime/10;
				}else if (i==2) {
					lastprice = delaytime+ delaytime/20;
				}
				else if (i==3) {
					lastprice = delaytime+ delaytime/30;
				}else {
					lastprice=delaytime;
				}
			
				
				
				salesInfo.setSaleprice(lastprice);
		
				// to sent database selected data
				new SalesDB().Insert(salesInfo);
				 
				
			
				// and after refresh jlist to we see what we make
				SaleslistJList.setListData(SalesDB.toListSales().toArray());
				
				
			}
		});
		
		

		deleteSaleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                   // select a sales to send database for delete
				SalesDomain delete_Sales = (SalesDomain) SaleslistJList.getSelectedValue();
				
				if (delete_Sales != null){

					int cvp = JOptionPane.showConfirmDialog(null,
							"Are Sure To Delete Record??", "UYARI",
							JOptionPane.YES_NO_OPTION);

					if (cvp == 0) {

					    JOptionPane.showMessageDialog(null, "Deregistration Successful.");
					    // here send selected value for DB
					    new SalesDB().Delete(delete_Sales);
					  
					    
					    SaleslistJList.setListData(SalesDB.toListSales().toArray());
					    
					}
					else{
						JOptionPane.showMessageDialog(null, "Deregistration canceled!");
						}
	        
	         }
				
			}
		});
		
		// exit operations
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				dispose();
				new Mainpage();
			}
		});
		
		
		


		
		MainJPanel.add(upJPanel,BorderLayout.NORTH);
		MainJPanel.add(middleJPanel,BorderLayout.CENTER);
		MainJPanel.add(downJPanel,BorderLayout.SOUTH);
		
		

		
		
		
		
		
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

