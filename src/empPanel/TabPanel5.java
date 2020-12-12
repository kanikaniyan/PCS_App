package empPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import view.RoundedBorder;

public class TabPanel5 extends JPanel{
	private static final long serialVersionUID = 1L;

	public static JButton bLogout;
	public TabPanel5(Employee emp) {
		
		bLogout = new JButton("Logout");
		
		bLogout.setPreferredSize(new Dimension(100,25));
		bLogout.setBackground(new Color(246, 71, 71));
		bLogout.setForeground(new Color(240, 240, 240));
		bLogout.setBorder(new RoundedBorder(12));
	    
		this.setBorder(new EmptyBorder(new Insets(50, 200, 143, 200)));
		
		
		this.add(bLogout);
		
	}
}
