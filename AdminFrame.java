import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame implements ActionListener{
	JPanel panel;
	JButton  ISbtn,USbtn,DSbtn,SSbtn,IPbtn,UPbtn,DPbtn,SPbtn,SRbtn,Backbtn,exitBtn;
	
	public AdminFrame()
	{
		super("ADMIN");
		this.setSize(550,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		ISbtn=new JButton("Insert Salesman");
		ISbtn.setBounds(20,30,150,30);
		ISbtn.addActionListener(this);
		panel.add(ISbtn);
		
		USbtn=new JButton("Update Salesman");
		USbtn.setBounds(20,70,150,30);
		USbtn.addActionListener(this);
		panel.add(USbtn);
		
		SSbtn=new JButton("Select Salesman");
		SSbtn.setBounds(20,110,150,30);
		SSbtn.addActionListener(this);
		panel.add(SSbtn);
		
		
		DSbtn=new JButton("Delete Salesman");
		DSbtn.setBounds(20,150,150,30);
		DSbtn.addActionListener(this);
		panel.add(DSbtn);
		
		IPbtn=new JButton("Insert Product");
		IPbtn.setBounds(210,30,150,30);
		IPbtn.addActionListener(this);
		panel.add(IPbtn);
		
		
		UPbtn=new JButton("Update Product");
		UPbtn.setBounds(210,70,150,30);
		UPbtn.addActionListener(this);
		panel.add(UPbtn);
		
		
		SPbtn=new JButton("Select Product");
		SPbtn.setBounds(210,110,150,30);
		SPbtn.addActionListener(this);
		panel.add(SPbtn);
		
		DPbtn=new JButton("Delete Product");
		DPbtn.setBounds(210,150,150,30);
		DPbtn.addActionListener(this);
		panel.add(DPbtn);
		
		Backbtn=new JButton("Back");
		Backbtn.setBounds(250,200,100,30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		
		SRbtn=new JButton("Show Sales Report");
		SRbtn.setBounds(20,200,200,30);
		SRbtn.addActionListener(this);
		panel.add(SRbtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(ISbtn.getText()))
		{
			InsertSalesmanFrame isf = new InsertSalesmanFrame();
			isf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(USbtn.getText()))
		{
			UpdateSalesmanFrame usf = new UpdateSalesmanFrame();
			usf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(DSbtn.getText()))
		{
			DeleteSalesmanFrame dsf = new DeleteSalesmanFrame();
			dsf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(IPbtn.getText()))
		{
			InsertProductFrame ipf = new InsertProductFrame();
			ipf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(SSbtn.getText()))
		{
			SearchSalesmanFrame ssf = new SearchSalesmanFrame();
			ssf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(UPbtn.getText()))
		{
			UpdateProductFrame upf = new UpdateProductFrame();
			upf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(DPbtn.getText()))
		{
			DeleteProductFrame dpf = new DeleteProductFrame();
			dpf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(SPbtn.getText()))
		{
			SearchProductFrame spf = new SearchProductFrame();
			spf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(SRbtn.getText()))
		{
			ShowSalesReport ssp = new ShowSalesReport();
			ssp.setVisible(true);
			this.setVisible(false);			
		}
	
		else if(command.equals(Backbtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}		
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}		
		else{}
}
}