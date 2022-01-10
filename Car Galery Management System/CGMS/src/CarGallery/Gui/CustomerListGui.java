package CarGallery.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import CarGallery.db.BuyCarDB;
import CarGallery.db.CustomerDB;

public class CustomerListGui extends JFrame implements interfacecar {
	public CustomerListGui() {
		// TODO Auto-generated constructor stub
		initJFrame();
	}

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = initJPanel();
		add(MainJPanel);
		setTitle("CUSTOMER LIST");
		setVisible(true); // we make a Panel here
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pack();
 
	}

	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = new JPanel(new BorderLayout());  // divide the panel for needed place
		JPanel TopJPanel = new JPanel(new GridLayout(1,3,5,5));
		JPanel BottomJPanel = new JPanel(new GridLayout(1,1,5,5));
		JPanel MiddleJPanel = new JPanel(new GridLayout(1,1));
		

		TitledBorder titledBorder = BorderFactory.createTitledBorder("CUSTOMER   LIST");
		TopJPanel.setBorder(titledBorder);	 
		titledBorder.setTitleColor(Color.red);

		
		
		 // needed TextFields and Labels
		JLabel nameFinderJLabel = new JLabel("Customer Name ");
		TopJPanel.add(nameFinderJLabel);
		 
		
		final JTextField Customernamefinder = new JTextField();
		TopJPanel.add(Customernamefinder);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setBackground(Color.orange);
		TopJPanel.add(SearchButton);
		
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.orange);
		BottomJPanel.add(exitButton);
		
		
		
		
		
		
		// here we have JList to list the Customers that we have  
		final JList CustomerJList = new JList(CustomerDB.toListCustomer().toArray());
		JScrollPane CustomerJListJScrollPane = new JScrollPane(CustomerJList);
		CustomerJListJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		MiddleJPanel.add(CustomerJListJScrollPane);
		
		CustomerJList.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorAdded(AncestorEvent arg0) {

				CustomerJList.setListData(CustomerDB.toListCustomer().toArray());
				
			}
		});
		// to find a car with name
		Customernamefinder.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {

				String WantedCustomer = Customernamefinder.getText();
				if (WantedCustomer.isEmpty()) {
					CustomerJList.setListData(CustomerDB.toListCustomer().toArray());
				} else {
					CustomerJList.setListData(CustomerDB.find(WantedCustomer).toArray());
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		// exit Button
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
 
				dispose();

			}
		});
		
		MainJPanel.add(TopJPanel,BorderLayout.NORTH);
		MainJPanel.add(MiddleJPanel,BorderLayout.CENTER);
		MainJPanel.add(BottomJPanel,BorderLayout.SOUTH);
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
