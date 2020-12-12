package pmPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel2 extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel lActDe, lMessage;
	public JTextField tID;
	
	public Panel2(String str) {
		
		lActDe=new JLabel(str);
		
		tID=new JTextField(8);
		
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