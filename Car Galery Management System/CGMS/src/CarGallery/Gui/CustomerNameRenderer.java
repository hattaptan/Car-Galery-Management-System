package CarGallery.Gui; 
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Domain.CustomerDomain;

 




public class CustomerNameRenderer extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR  = new Color (0,0,128);
	  // set color to under combobox

	public CustomerNameRenderer() {
		
		setOpaque(true);
		setIconTextGap(12);
		
	}


public Component getListCellRendererComponent (JList list, Object value,int index, boolean isSelected, boolean cellHasFocus){
	
	CustomerDomain entry = (CustomerDomain) value;
	setText( entry.getName()+" "+entry.getSurname());
	// send customer name and surname to combobox
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
