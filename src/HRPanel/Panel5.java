package HRPanel;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel5 extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel lSkillName, lSkillDesc, lMessage;
	public JTextField tSkillName;
	public JTextArea tSkillDesc;
	JScrollPane scrollPane;
	
	public Panel5() {

		lSkillName=new JLabel("Skill Name          :   ");
		tSkillName=new JTextField(15);
		
		lSkillDesc=new JLabel("Skill Description : ");
		tSkillDesc=new JTextArea(4,15);
		
		scrollPane = new JScrollPane(tSkillDesc);
		
		this.add(lSkillName);
		this.add(tSkillName);
		this.add(lSkillDesc);
		tSkillDesc.setWrapStyleWord(true);
		tSkillDesc.setLineWrap(true);
		tSkillDesc.setEditable(true);
		tSkillDesc.setFocusable(true);
		this.add(scrollPane);
		setLocationAndSize();
		this.setVisible(true);
		
	}
	public void setLocationAndSize() {
		this.setBounds(20, 150, 320, 120);
		lSkillName.setAlignmentX(Component.LEFT_ALIGNMENT);
		tSkillName.setAlignmentX(Component.LEFT_ALIGNMENT);
		lSkillDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
		
}
