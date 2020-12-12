package HRPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel lActDe, lMessage;
	public JTextField tID;
	
	public Panel1(String pan) {
		int column=8;
		lActDe=new JLabel(pan);
		
		tID=new JTextField(column);
		
		this.add(lActDe);
		this.add(tID);
		
		setLocationAndSize();
		this.setVisible(true);
		
	}
	public void setLocationAndSize() {
		this.setBounds(20, 150, 340, 50);
		this.setAlignmentX(LEFT_ALIGNMENT);
	}
		
}
