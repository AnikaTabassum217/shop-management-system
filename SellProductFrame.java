import ENTITY.*;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SellProductFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, quantityLabel,priceLabel,CustomerLabel;
	JTextField nameTF,quantityTF,priceTF,CustomerTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	public  SellProductFrame ()
	{
		super("Show Product List Frame");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Sell product");
		title.setBounds(40,0, 120, 30);
		panel.add(title);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 70, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 70, 100, 30);
		panel.add(nameTF);
		
		quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(20, 130, 100, 30);
		panel.add(quantityLabel);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(120, 130, 100, 30);
		panel.add(quantityTF);
		
		priceLabel = new JLabel("Price");
		priceLabel.setBounds(20, 190, 100, 30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(120, 190, 100, 30);
		panel.add(priceTF);
		
		
		CustomerLabel = new JLabel("Customer Name");
	     CustomerLabel.setBounds(20, 250, 100, 30);
		panel.add(CustomerLabel);
		
		CustomerTF = new JTextField();
		CustomerTF.setBounds(120, 250, 100, 30);
		panel.add(CustomerTF);
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 430, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 430, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 490, 100, 30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);		
			
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			SellRepo sr = new SellRepo();
			
			Sell s = new Sell();
			
			s.setProductName(nameTF.getText());
			s.setQuantity(Integer.parseInt(quantityTF.getText()));
			s.setTotalPrice(Integer.parseInt(priceTF.getText()));
			s.setCustomerName(CustomerTF.getText());
			
			System.out.println("Quantity : " + s.getQuantity());
			
			try{
				sr.insertSellData(s);				
				
				JOptionPane.showMessageDialog(this, "Product SOLD");

				nameTF.setText("");
				quantityTF.setText("");
				priceTF.setText("");	
				CustomerTF.setText("");	

				ProductRepo pr = new ProductRepo();
				pr.updateQuantity(s.getProductName(), s.getQuantity());									
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Product SOLD failed");
			}			
		}
		else if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}
		else if(command.equals(Backbtn.getText()))
		{
			SalesmanFrame sf = new SalesmanFrame();
			sf.setVisible(true);
			this.setVisible(false);			
		}				
		else{System.exit(0);}
	}
	
	
}