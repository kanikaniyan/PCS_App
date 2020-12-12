package view;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Starter extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	JPanel pHead, pTail, pTail1;
	JLabel lHead, lTitle, lMessage, lMessage1;
	Container container=null;
	public Starter() {
		
		container =getContentPane();
		pHead=new JPanel();
		lHead=new JLabel("P    C    S");
		lTitle=new JLabel("PROFESSIONET CONSULTANCY SERVICES");
		pHead.add(lHead);
		pHead.add(lTitle);
		
		pTail=new JPanel();
		lMessage=new JLabel("The best Renowned service provider in London SINCE 1992");
		pTail.add(lMessage);
		
		pTail1=new JPanel();
		lMessage1=new JLabel("Please Wait... The Portal is Loading.......");
		pTail1.add(lMessage1);
		lMessage1.setVisible(false);
		
		this.setBounds(10, 10, 420, 180);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);
		setLocationAndSize();
		setAddToComponentsToContainer();
	}

	@Override
	public void run() {
		this.setVisible(true);
		for (int i=10; i>=0; i--) {
			try {
				Thread.sleep(800);
				if (i==4) {
					lMessage1.setVisible(true);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.dispose();
		
	}
	
	public void setLocationAndSize() {
		pHead.setBounds(0, 0, 420, 75);
		pHead.setBackground(new java.awt.Color(243, 156, 18));
		
		lHead.setFont(new java.awt.Font("Tahoma", Font.BOLD+Font.ITALIC, 32));
		lHead.setForeground(new java.awt.Color(255, 255, 255));
		
		lTitle.setFont(new java.awt.Font("courier", Font.BOLD+Font.ITALIC, 16));
		lTitle.setForeground(new java.awt.Color(0, 51, 102));
		
		pTail.setBounds(0, 100, 420, 70);
		pTail.setBackground(new java.awt.Color(128, 128, 128));
		
		lMessage.setForeground(new java.awt.Color(255, 255, 255));
		lMessage.setFont(new java.awt.Font("Tahoma", 1, 12));
		
		pTail1.setBounds(0, 150, 420, 30);
		pTail1.setBackground(new java.awt.Color(128, 128, 128));
		lMessage1.setForeground(new java.awt.Color(255, 255, 255));
		lMessage1.setFont(new java.awt.Font("Tahoma", 1, 10));
	}
	
	public void setAddToComponentsToContainer() {
		container.add(pHead);
		container.add(pTail);
		container.add(pTail1);
	}
	
}
