
import ENTITY.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SearchSalesmanFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel,passwordLabel,typeLabel,searchIDLabel;
	JTextField nameTF,passwordTF,typeTF,searchIDTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	
	public SearchSalesmanFrame()
	{
		super("Search Salesman Frame");
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Search Salesman");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		searchIDLabel = new JLabel("ID");
		searchIDLabel.setBounds(20, 40, 100, 30);
		panel.add(searchIDLabel);
		
		searchIDTF = new JTextField("");
		searchIDTF.setBounds(120, 40, 100, 30);
		panel.add(searchIDTF);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 90, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 90, 100, 30);
		panel.add(nameTF);
		
		typeLabel = new JLabel("Type");
		typeLabel.setBounds(20, 140, 100, 30);
		panel.add(typeLabel);
		
		typeTF = new JTextField();
		typeTF.setBounds(120, 140, 100, 30);
		panel.add(typeTF);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 190, 100, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(120, 190, 100, 30);
		panel.add(passwordTF);
		
		
		
		
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
			UsersRepo ur = new UsersRepo();			 
			
			Users user = ur.searchUser(searchIDTF.getText());
			
			if(user!=null) {
				JOptionPane.showMessageDialog(this, "Salesman Found");

				nameTF.setText(user.getName());
				passwordTF.setText(user.getPassward());	
				typeTF.setText(user.getType());				
				searchIDTF.setText(String.valueOf(user.getId()));		
			} else {
				JOptionPane.showMessageDialog(this, "Salesman Not Found");
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