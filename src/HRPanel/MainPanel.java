package HRPanel;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public JRadioButton lActDeEmp, lDeleteEmp, lAllEmp, lAppEmp, lAddSkill, lAllSkill, lActDeSkill, lDeleteSkill;
	public ButtonGroup buttonGroup=null;
	
	public MainPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		buttonGroup=new ButtonGroup();
		lActDeEmp=new JRadioButton("Activate or Deactivate Employee");
		lDeleteEmp=new JRadioButton("Delete Employee");
		lAllEmp=new JRadioButton("View All Employees");
		lAppEmp=new JRadioButton("Recriut an Employee");
		lAddSkill=new JRadioButton("Add Skill");
		lAllSkill=new JRadioButton("View All Skills");
		lActDeSkill=new JRadioButton("Activate or Deactivate Skill");
		lDeleteSkill=new JRadioButton("Delete Skill");
		
		buttonGroup.add(lActDeEmp);
		buttonGroup.add(lDeleteEmp);
		buttonGroup.add(lAllEmp);
		buttonGroup.add(lAppEmp);
		buttonGroup.add(lAddSkill);
		buttonGroup.add(lAllSkill);
		buttonGroup.add(lActDeSkill);
		buttonGroup.add(lDeleteSkill);
		
		this.add(lActDeEmp);
		this.add(lDeleteEmp);
		this.add(lAllEmp);
		this.add(lAppEmp);
		this.add(lAddSkill);
		this.add(lAllSkill);
		this.add(lActDeSkill);
		this.add(lDeleteSkill);
		
		setLocationAndSize();
		
	}
	
	public void setLocationAndSize() {
		setAlignmentX(LEFT_ALIGNMENT);
		this.setBounds(30, 150, 330, 230);
	}
	
}
