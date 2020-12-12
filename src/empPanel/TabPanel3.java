package empPanel;

import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SkillController;
import model.Employee;
import model.Skill;
import view.RoundedBorder;

public class TabPanel3 extends JPanel{

	private static final long serialVersionUID = 1L;
	JPanel PanelLoop, PanelPool;
	JLabel lSkillID, lSkillName, lText, lActive;
	JTextField tText;
	JButton b1;
	JFrame jpane;
	JComboBox<String> cSkill;
	SkillController sklController=null;
	
	public TabPanel3(Employee emp) throws ClassNotFoundException, SQLException {
		
		jpane=new JFrame();
		
		lSkillName=new JLabel("Skill ID and Skill Name:");
		lText=new JLabel("Year of experience on this skill: ");
		
		tText=new JTextField(8);
		String validatePh="[1-9]{1}";
		
		b1=new JButton("Update");
		
		cSkill=new JComboBox<String>();
		
		sklController=new SkillController();
		List<Skill> skillList=sklController.getAllSkills();
		
		PanelLoop=new JPanel();
		PanelPool=new JPanel();
		
		//panel loop
		PanelLoop.setLayout(new BoxLayout(PanelLoop, BoxLayout.LINE_AXIS));
		PanelLoop.setBackground(Color.LIGHT_GRAY);
		PanelLoop.setBorder(new EmptyBorder(new Insets(15, 200, 15, 200)));
		
		cSkill.setPreferredSize(new Dimension(120,25));
		PanelLoop.add(lSkillName);
		PanelLoop.add(Box.createRigidArea(new Dimension(10, 0)));
		PanelLoop.add(cSkill);
		
		this.add(PanelLoop);
		
		//panel pool
		PanelPool.setLayout(new BoxLayout(PanelPool, BoxLayout.LINE_AXIS));
		PanelPool.setBackground(Color.LIGHT_GRAY);
		PanelPool.setBorder(new EmptyBorder(new Insets(15, 200, 15, 200)));
		PanelPool.add(lText);
		PanelPool.add(Box.createRigidArea(new Dimension(20, 0)));
		PanelPool.add(tText);
		PanelPool.add(Box.createRigidArea(new Dimension(20, 0)));
		PanelPool.add(b1);
		
		b1.setPreferredSize(new Dimension(100,25));
		b1.setBackground(new Color(35, 203, 167));
		b1.setForeground(new Color(240, 240, 240));
		b1.setBorder(new RoundedBorder(12));
		
		this.add(PanelPool);
		
		for (Skill skill:skillList) {
			cSkill.addItem(skill.getSkillID()+" "+skill.getSkillName());
		}
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tText.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jpane, "Fill the Field to update!");
				}
				else {
					if (tText.getText().matches(validatePh)) {
						int opt=JOptionPane.showConfirmDialog(jpane, "Do you want to update your Skill!", "Confirmation Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						
						if(opt==JOptionPane.YES_OPTION) {
							int skillId, empId, year;
							String demo;
							
							demo= (String) cSkill.getSelectedItem();
							String[] arrdemo=demo.split(" ");
							
						    skillId=Integer.parseInt(arrdemo[0]);
							empId=emp.getEmployeeID();
							year=Integer.parseInt(tText.getText());
							
							sklController.empSkill(skillId, empId, year);
						}
					}
					else {
						JOptionPane.showMessageDialog(jpane, "Invalid Year!");
					}
				}
			}
			
		});
		
	}
}
