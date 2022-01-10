package CarGallery.Gui;

import java.util.List;

import javax.swing.JPanel;

import CarGallery.Domain.BuyCarDomain;

public interface interfacecar<T> {


	public void initJFrame();
	public JPanel initJPanel();
	public void Insert(T Information);
	public void Delete(T Information);

}
