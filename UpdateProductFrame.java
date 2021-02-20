import ENTITY.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateProductFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, quantityLabel,priceLabel,typeLabel,updateIDLabel;
	JTextField nameTF,quantityTF,priceTF,typeTF,updateIDTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	public UpdateProductFrame()
	{
		super("Update Product Frame");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Update   Product");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		updateIDLabel = new JLabel("Update ID");
		updateIDLabel.setBounds(20, 40, 100, 30);
		panel.add(updateIDLabel);
		
		updateIDTF = new JTextField("");
		updateIDTF.setBounds(120, 40, 100, 30);
		panel.add(updateIDTF);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 90, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 90, 100, 30);
		panel.add(nameTF);
		
		quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(20, 140, 100, 30);
		panel.add(quantityLabel);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(120, 140, 100, 30);
		panel.add(quantityTF);
		
		priceLabel = new JLabel("Price");
		priceLabel.setBounds(20, 190, 100, 30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(120, 190, 100, 30);
		panel.add(priceTF);
		
		typeLabel = new JLabel("Type");
		typeLabel.setBounds(20, 250, 100, 30);
		panel.add(typeLabel);
		
		typeTF = new JTextField();
		typeTF.setBounds(120, 250, 100, 30);
		panel.add(typeTF);
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 330, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 390, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 450, 100, 30);
		Backbtn.addActionListener(this);
		panel.add(Backbtn);		
			
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			ProductRepo pr = new ProductRepo();
			
			Product p = new Product();
			
			
			p.setId(Integer.parseInt(updateIDTF.getText()));
			p.setName(nameTF.getText());
			p.setQuantity(Integer.parseInt(quantityTF.getText()));
			p.setPrice(Integer.parseInt(priceTF.getText()));
			p.setType(typeTF.getText());
			
			try{
				pr.updateProduct(p);							
			
				JOptionPane.showMessageDialog(this, "Product Updateded");

				nameTF.setText("");
				quantityTF.setText("");
				priceTF.setText("");	
				typeTF.setText("");					
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Product Updated failed");
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
			AdminFrame af = new AdminFrame();
			af.setVisible(true);
			this.setVisible(false);			
		}				
		else{System.exit(0);}
	}
}