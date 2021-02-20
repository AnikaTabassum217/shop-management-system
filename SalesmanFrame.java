import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalesmanFrame extends JFrame implements ActionListener{
	JPanel panel;
	JButton SPLbtn,SUbtn,SPbtn,Backbtn,exitBtn;
	
	public SalesmanFrame()
	{
		super("SALESMAN");
		this.setSize(350,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		SPLbtn=new JButton("Show Product List");
		SPLbtn.setBounds(20,30,200,30);
		SPLbtn.addActionListener(this);
		panel.add(SPLbtn);
		
		
		SUbtn=new JButton("Stock Update");
		SUbtn.setBounds(20,70,200,30);
		//SUbtn.addActionListener(this);
		panel.add(SUbtn);
		
		SPbtn=new JButton("Sell Product");
		SPbtn.setBounds(20,110,200,30);
		SPbtn.addActionListener(this);
		panel.add(SPbtn);
		
		
		Backbtn=new JButton("Back");
		Backbtn.setBounds(20,200,100,30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(200, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
			
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(SPbtn.getText()))
		{
			SellProductFrame spf = new SellProductFrame();
			spf.setVisible(true);
			this.setVisible(false);			
		}
		
		if(command.equals(SPLbtn.getText()))
		{
			ShowProductListFrame spl = new ShowProductListFrame();
			spl.setVisible(true);
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