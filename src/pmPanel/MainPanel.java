package pmPanel;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public JRadioButton lAddJob, lAllJob, lSkillwJob, lAppliedEmp, lDeaJob, lDeleteJob;
	public ButtonGroup buttonGroup=null;
	
	public MainPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		buttonGroup=new ButtonGroup();
		lAddJob=new JRadioButton("Add Job");
		lAllJob=new JRadioButton("View All Jobs");
		lSkillwJob=new JRadioButton("View Skill wise Jobs");
		lAppliedEmp=new JRadioButton("View Employees who applied for jobs");
		lDeaJob=new JRadioButton("Activate or Deactivate Job");
		lDeleteJob=new JRadioButton("Delete Job");
		
		buttonGroup.add(lAddJob);
		buttonGroup.add(lAllJob);
		buttonGroup.add(lSkillwJob);
		buttonGroup.add(lAppliedEmp);
		buttonGroup.add(lDeaJob);
		buttonGroup.add(lDeleteJob);
		
		this.add(lAddJob);
		this.add(lAllJob);
		this.add(lSkillwJob);
		this.add(lAppliedEmp);
		this.add(lDeaJob);
		this.add(lDeleteJob);
		
		setLocationAndSize();
	}
	
	public void setLocationAndSize() {
		setAlignmentX(LEFT_ALIGNMENT);
		this.setBounds(30,170, 300, 200);
	}
}
