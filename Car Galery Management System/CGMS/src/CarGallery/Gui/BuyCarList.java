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

public class BuyCarList extends JFrame implements interfacecar {
	public BuyCarList() {
		// TODO Auto-generated constructor stub
		initJFrame();
	}

	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		JPanel anaJPanel = initJPanel();
		add(anaJPanel);
		setTitle("CAR LIST"); // we make a Panel here
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pack();

	}

	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		JPanel MainJPanel = new JPanel(new BorderLayout());// divide the panel for needed place
		JPanel upJPanel = new JPanel(new GridLayout(1, 3, 5, 5));
		JPanel DownJPanel = new JPanel(new GridLayout(1, 1, 5, 5));
		JPanel MiddleJPanel = new JPanel(new GridLayout(1, 1));

		TitledBorder titledBorder = BorderFactory.createTitledBorder("CAR   LIST");
		upJPanel.setBorder(titledBorder);	 
		titledBorder.setTitleColor(Color.red);

		JLabel plakanoJLabel = new JLabel("Plaque ");
		upJPanel.add(plakanoJLabel);

		final JTextField plaquefinder = new JTextField(); // needed TextFields and Labels
		upJPanel.add(plaquefinder);

		JButton SearchButton = new JButton("SEARCH");
		SearchButton.setBackground(Color.orange);
		upJPanel.add(SearchButton);

		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.orange);
		DownJPanel.add(exitButton);

		// here we have JList to list the cars that we bought
		final JList CarListJList = new JList(BuyCarDB.toListCar().toArray());
		JScrollPane CarListJScrollPane = new JScrollPane(CarListJList);
		CarListJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		MiddleJPanel.add(CarListJScrollPane);

		CarListJList.addAncestorListener(new AncestorListener() {

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

				CarListJList.setListData(BuyCarDB.toListCar().toArray());

			}
		});

		// to find a car with plaque
		plaquefinder.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

				String wanted = plaquefinder.getText();
				if (wanted.isEmpty()) {
					CarListJList.setListData(BuyCarDB.toListCar().toArray());
				} else {
					CarListJList.setListData(BuyCarDB.find(wanted).toArray());
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

		MainJPanel.add(upJPanel, BorderLayout.NORTH);
		MainJPanel.add(MiddleJPanel, BorderLayout.CENTER);
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
