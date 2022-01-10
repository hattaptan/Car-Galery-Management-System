package CarGallery.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Domain.CustomerDomain;
import CarGallery.db.*;
import java.sql.Date;

public class CustomerGui extends JFrame implements interfacecar {

	public CustomerGui() {
		// TODO Auto-generated constructor stub
		initJFrame();
	}

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		JPanel anaJPanel = initJPanel();
		add(anaJPanel);
		setTitle("Add Customer"); // Generate a Panel and give it same necessary adjustments
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		// pack();
		setSize(820, 500);
	}

	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = new JPanel(new BorderLayout());// for texfield and button and JList divide the panel
		JPanel bolJPanel = new JPanel(new GridLayout(1, 2));
		JPanel LeftJPanel = new JPanel(new GridLayout(12, 2, 5, 5));
		JPanel RightJPanel = new JPanel(new BorderLayout());
		JPanel DownJPanel = new JPanel(new GridLayout(1, 4, 5, 5));
 
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder("ADD   CUSTOMER");
		LeftJPanel.setBorder(titledBorder);	 
		titledBorder.setTitleColor(Color.red);		
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder("CUSTOMER   LIST");
		RightJPanel.setBorder(titledBorder1);		 
		titledBorder1.setTitleColor(Color.red);

		// Needed TextFields and Jlabels and Buttons
		JLabel nameJLabel = new JLabel("Name");
		LeftJPanel.add(nameJLabel);

		final JTextField nameField = new JTextField();
		LeftJPanel.add(nameField);

		JLabel surnameJLabel = new JLabel("Surname");
		LeftJPanel.add(surnameJLabel);

		final JTextField surnameJField = new JTextField();
		LeftJPanel.add(surnameJField);

		JLabel genderJLabel = new JLabel("Gender");
		LeftJPanel.add(genderJLabel);

		final JComboBox genderBox = new JComboBox();
		LeftJPanel.add(genderBox);

		genderBox.addItem("Male");
		genderBox.addItem("Female");

		JLabel birthdayJLabel = new JLabel("Birth Day");
		LeftJPanel.add(birthdayJLabel);

		final JDateChooser birthdayChooser = new JDateChooser();
		LeftJPanel.add(birthdayChooser);

		JLabel telefonnoJLabel = new JLabel("Telephone");
		LeftJPanel.add(telefonnoJLabel);

		final JTextField telefonnoField = new JTextField();
		LeftJPanel.add(telefonnoField);

		JLabel addressJLabel = new JLabel("Address ");
		LeftJPanel.add(addressJLabel);

		final JTextField addressfField = new JTextField();
		LeftJPanel.add(addressfField);

		// for list all customer that we have
		final JList addcustomerJList = new JList(CustomerDB.toListCustomer().toArray());
		JScrollPane addcustomerJScrollPane = new JScrollPane(addcustomerJList);
		addcustomerJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		RightJPanel.add(addcustomerJScrollPane);

		// Add button

		JButton addCustomerBTN = new JButton("ADD CUSTOMER");
		addCustomerBTN.setBackground(Color.orange);
		DownJPanel.add(addCustomerBTN);

		// Delete button
		JButton deleteCustomerBTN = new JButton("DELETE CUSTOMER");
		deleteCustomerBTN.setBackground(Color.orange);
		DownJPanel.add(deleteCustomerBTN);

		// Exit button
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.orange);
		DownJPanel.add(exitButton);

		addCustomerBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				java.util.Date birthDate = birthdayChooser.getDate();
				Date birthSQLDate = new Date(birthDate.getTime());

				CustomerDomain addCustomerInfo = new CustomerDomain();
                 // here get information about customer from user and send DB
				addCustomerInfo.setName(nameField.getText());
				addCustomerInfo.setSurname(surnameJField.getText());
				addCustomerInfo.setGender(genderBox.getSelectedItem().toString());
				addCustomerInfo.setBirthday(birthSQLDate);
				addCustomerInfo.setTelephone(telefonnoField.getText());
				addCustomerInfo.setAddress(addressfField.getText());

				new CustomerDB().Insert(addCustomerInfo);// call DB clas and send customer's information
                // list customer
				addcustomerJList.setListData(CustomerDB.toListCustomer().toArray());

				nameField.setText("");
				surnameJField.setText("");
				telefonnoField.setText("");
				addressfField.setText("");

			}
		});

		deleteCustomerBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {// delete a customer that we have

				CustomerDomain deletecustomer = (CustomerDomain) addcustomerJList.getSelectedValue();

				if (deletecustomer != null) {

					int cvp = JOptionPane.showConfirmDialog(null, "Are Sure To Delete Record?", "UYARI",
							JOptionPane.YES_NO_OPTION);

					if (cvp == 0) {

						JOptionPane.showMessageDialog(null, "Deregistration Successful");

						new CustomerDB().Delete(deletecustomer);

						addcustomerJList.setListData(CustomerDB.toListCustomer().toArray());

					} else {
						JOptionPane.showMessageDialog(null, "Deregistration canceled!");
					}

				}

			}
		});

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dispose();
			}
		});

		MainJPanel.add(bolJPanel, BorderLayout.CENTER);
		bolJPanel.add(LeftJPanel, BorderLayout.EAST);
		bolJPanel.add(RightJPanel, BorderLayout.WEST);
		MainJPanel.add(DownJPanel, BorderLayout.SOUTH);
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
