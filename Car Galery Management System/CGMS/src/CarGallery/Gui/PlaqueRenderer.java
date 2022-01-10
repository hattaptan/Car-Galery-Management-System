package CarGallery.Gui;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarGallery.Domain.BuyCarDomain;

 




public class PlaqueRenderer extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR  = new Color (0,0,128);
	  
	 // set color to under combobox
	public PlaqueRenderer() {
		
		setOpaque(true);
		setIconTextGap(12);
		
	}


public Component getListCellRendererComponent (JList list, Object value,int index, boolean isSelected, boolean cellHasFocus){
	
	BuyCarDomain entry = (BuyCarDomain) value;
	setText(entry.getPlaque());
	// send Car plaque to combobox
	if (isSelected){
		setBackground(HIGHLIGHT_COLOR);
		setForeground(Color.orange);
		
	}
	else{
		setBackground(Color.white);
		setForeground(Color.black);
	}

return this;
}
}
