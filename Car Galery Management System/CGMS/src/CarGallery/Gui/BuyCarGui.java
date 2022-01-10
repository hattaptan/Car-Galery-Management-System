package CarGallery.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Domain.CustomerDomain;
import CarGallery.db.BuyCarDB;
import CarGallery.db.CustomerDB;

public class BuyCarGui extends JFrame implements interfacecar {

	public BuyCarGui() {
		// TODO Auto-generated constructor stub
		initJFrame();
	}

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		JPanel anaJPanel = initJPanel();
		add(anaJPanel);
		setTitle("BUY CAR"); // Generate a Panel and give it same necessary adjustments
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(740, 600);

	}

	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = new JPanel(new BorderLayout()); // for texfield and button and JList divide the panel

		JPanel bolJPanel = new JPanel(new GridLayout(1, 2));
		JPanel LeftJPanel = new JPanel(new GridLayout(11, 2, 5, 5));
		JPanel RightJPanel = new JPanel(new GridLayout(1, 1));
		JPanel DownJPanel = new JPanel(new GridLayout(1, 5, 5, 5));

		 
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder("BUY CAR");
		LeftJPanel.setBorder(titledBorder);	 
		titledBorder.setTitleColor(Color.red);		
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder("CAR LIST");
		RightJPanel.setBorder(titledBorder1);		 
		titledBorder1.setTitleColor(Color.red);
		
		
		
		

		JLabel plaqueJLabel = new JLabel("PLAQUE"); // necessary Label and TextField
		LeftJPanel.add(plaqueJLabel);

		final JTextField plaqueField = new JTextField();
		LeftJPanel.add(plaqueField);

		JLabel colorJLabel = new JLabel("COLOR");
		LeftJPanel.add(colorJLabel);

		final JTextField colorField = new JTextField();
		LeftJPanel.add(colorField);

		JLabel brandJLabel = new JLabel("BRAND");
		LeftJPanel.add(brandJLabel);

		final JComboBox brandBox = new JComboBox(); // Jcomboboks for brand of cars
		LeftJPanel.add(brandBox);

		brandBox.addItem("BMW");
		brandBox.addItem("Renault");
		brandBox.addItem("Mercedes-Benz");// Brandbox item
		brandBox.addItem("Opel");
		brandBox.addItem("Ford");
		brandBox.addItem("Fiat");
		brandBox.addItem("VolksWagen");

		JLabel modelJLabel = new JLabel("MODEL");
		LeftJPanel.add(modelJLabel);

		final JTextField modelField = new JTextField();
		LeftJPanel.add(modelField);

		JLabel vitesJLabel = new JLabel("GEAR");
		LeftJPanel.add(vitesJLabel);

		final JComboBox gearBox = new JComboBox();
		LeftJPanel.add(gearBox);

		gearBox.addItem("Manuel");
		gearBox.addItem("Automatic");
		gearBox.addItem("semiautomatic");

		JLabel fuelJLabel = new JLabel("FUEL");
		LeftJPanel.add(fuelJLabel);

		final JTextField fuelField = new JTextField();
		LeftJPanel.add(fuelField);

		JLabel tipiJLabel = new JLabel("TYPE");
		LeftJPanel.add(tipiJLabel);

		final JComboBox typeBox = new JComboBox();
		LeftJPanel.add(typeBox);

		typeBox.addItem("Sedan");
		typeBox.addItem("HB");
		typeBox.addItem("Jeep");

		JLabel engineJLabel = new JLabel("ENGINE");
		LeftJPanel.add(engineJLabel);

		final JTextField engineField = new JTextField();
		LeftJPanel.add(engineField);

		JLabel doorJLabel = new JLabel("DOOR");
		LeftJPanel.add(doorJLabel);

		final JTextField doorField = new JTextField();
		LeftJPanel.add(doorField);

		JLabel pricelabel = new JLabel("PRICE");
		LeftJPanel.add(pricelabel);

		final JTextField priceField = new JTextField();
		LeftJPanel.add(priceField);

		final JList BuyCarJList = new JList(BuyCarDB.toListCar().toArray());

		JScrollPane BuyCarJScrollPane = new JScrollPane(BuyCarJList); // JList for to list the cars bought

		BuyCarJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		RightJPanel.add(BuyCarJScrollPane);

		JButton buyCarAddButton = new JButton("BUY CAR");
		buyCarAddButton.setBackground(Color.orange);
		DownJPanel.add(buyCarAddButton);

		JButton deleteCarButton = new JButton("DELETE CAR");
		deleteCarButton.setBackground(Color.orange);

		DownJPanel.add(deleteCarButton);

		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.orange);
		DownJPanel.add(exitButton);

		exitButton.addActionListener(new ActionListener() {// exit button

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();

			}
		});

		buyCarAddButton.addActionListener(new ActionListener() {// save button

			@Override
			public void actionPerformed(ActionEvent arg0) {

				BuyCarDomain CarInfo = new BuyCarDomain();

				CarInfo.setPlaque(plaqueField.getText()); // in here we take input from user and save it for car
				CarInfo.setColor(colorField.getText());
				CarInfo.setBrand(brandBox.getSelectedItem().toString());
				CarInfo.setModel(modelField.getText());
				CarInfo.setGear(gearBox.getSelectedItem().toString());
				CarInfo.setFuel(fuelField.getText());
				CarInfo.setType(typeBox.getSelectedItem().toString());
				CarInfo.setEngine(engineField.getText());
				CarInfo.setDoor(Integer.parseInt(doorField.getText()));
				CarInfo.setPrice(Integer.parseInt(priceField.getText()));

				new BuyCarDB().Insert(CarInfo); // sent database for save

				BuyCarJList.setListData(BuyCarDB.toListCar().toArray());// to list what we saved

				plaqueField.setText("");
				colorField.setText("");
				modelField.setText("");
				fuelField.setText("");
				engineField.setText("");
				modelField.setText("");
				doorField.setText("");
				priceField.setText("");

			}
		});

		deleteCarButton.addActionListener(new ActionListener() {// here delete a car which is selected by mouse

			@Override
			public void actionPerformed(ActionEvent arg0) {

				BuyCarDomain selectedCarInfo = (BuyCarDomain) BuyCarJList.getSelectedValue();

				if (selectedCarInfo != null) {

					int cvp = JOptionPane.showConfirmDialog(null, "Are Sure To Delete Record?", "WARNING",
							JOptionPane.YES_NO_OPTION);

					if (cvp == 0) {

						JOptionPane.showMessageDialog(null, "Deregistration Successful");

						new BuyCarDB().Delete(selectedCarInfo); // delete selected car from DB

						BuyCarJList.setListData(BuyCarDB.toListCar().toArray()); // again list

					} else {
						JOptionPane.showMessageDialog(null, "Deregistration canceled!");
					}

				}

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
