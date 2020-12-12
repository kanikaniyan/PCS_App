package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.SkillController;
import model.Skill;

public class AllSkillFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTable table;
	SkillController sklController=null;
	DefaultTableModel tableModel=null;
	
	public AllSkillFrame() 
	{
		try {
			
			sklController=new SkillController();
			
			List<Skill> skillList= sklController.getAllSkills();
			List<Skill> skillListSorted=new ArrayList<Skill>();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("Skill ID");
			tableModel.addColumn("Skill Name");
			tableModel.addColumn("Skill Description");
			tableModel.addColumn("Active");
			
			for (int i = skillList.size()-1; i >= 0; i--) {
				skillListSorted.add(skillList.get(i));
			}
			
			for (Skill skill:skillListSorted) {
				displaySkill(skill);
			}
			
			DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
			 dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			 
			 table.getColumnModel().getColumn(0).setPreferredWidth(100);
			 table.getColumnModel().getColumn(1).setPreferredWidth(180);
			 table.getColumnModel().getColumn(2).setPreferredWidth(280);
		     table.getColumnModel().getColumn(3).setPreferredWidth(100);
		     table.setRowHeight(25);
		     
		     table.setDefaultEditor(Object.class, null);
		     
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("table");
			this.setBounds(10,10,800,250);
			this.setVisible(true);

	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}  
	
	public void displaySkill(Skill skill){
			tableModel.insertRow(0, new Object[] { skill.getSkillID(), skill.getSkillName(), skill.getSkillDescription (), skill.getActive()});	
	}
}
