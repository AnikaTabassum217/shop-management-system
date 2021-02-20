import ENTITY.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ShowSalesReport extends JFrame implements ActionListener{
	
	private JButton Backbtn,exitBtn,getAllBtn;
	private JTable procudtTable;
	private JScrollPane procudtTableSP;
	private JPanel panel;
	
	public ShowSalesReport()
	{
		super("Show Sales Report Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		panel = new JPanel();
		panel.setLayout(null);		
		
		String data[][] = {{"", "", "", "", "", ""}};
		
		String head[] = {"Id", "Product", "Quantity", "Price", "Customer"};
		
		procudtTable = new JTable(data,head);
		procudtTableSP = new JScrollPane(procudtTable);
		procudtTableSP.setBounds(350, 100, 400, 150);
		procudtTable.setEnabled(false);
		panel.add(procudtTableSP);		
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(600, 350, 80, 30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		System.out.println(command);	
		
		if(command.equals(getAllBtn.getText()))
		{
			
			SellRepo sr = new SellRepo();	
			
			String data[][] = sr.getAll();
			
			String head[] = {"Id", "Product", "Quantity", "Price", "Customer"};
			
			panel.remove(procudtTableSP);
			
			procudtTable = new JTable(data,head);
			procudtTable.setEnabled(false);
			procudtTableSP = new JScrollPane(procudtTable);
			procudtTableSP.setBounds(350, 100, 400, 150);
			panel.add(procudtTableSP);
			
			panel.revalidate();
			panel.repaint();			
		}
		else if(command.equals(Backbtn.getText()))
		{
			AdminFrame af = new AdminFrame();
			af.setVisible(true);
			this.setVisible(false);
		}		
	}		
}