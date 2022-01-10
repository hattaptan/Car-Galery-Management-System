package CarGallery.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import CarGallery.Gui.Login;
import CarGallery.Gui.Mainpage;


public class Test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
				
			   // call login class
				Login lg =new Login();
				lg.setVisible(true);
				
		

}
}
