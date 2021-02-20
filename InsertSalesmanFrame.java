import ENTITY.*;



import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InsertSalesmanFrame extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel title, nameLabel,passwordLabel;
	JTextField nameTF,passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	
	
	
	public InsertSalesmanFrame()
	{
		super("Insert Salesman Frame");
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Insert Salesman");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 70, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 70, 100, 30);
		panel.add(nameTF);
		
		
		passwordLabel = new JLabel("Passward");
		passwordLabel.setBounds(20, 130, 100, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(120, 130, 100, 30);
		panel.add(passwordTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 180, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(150, 180, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(280, 180, 100, 30);
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
			
			Users user = new Users();
			
			user.setName(nameTF.getText());
			user.setPassward(passwordTF.getText());
			user.setType("SALESMAN");
			
			try{
				ur.insertUser(user);							
				
				user = ur.getUser(nameTF.getText(), passwordTF.getText());

		JOptionPane.showMessageDialog(this, "Salesman created");

				nameTF.setText("");
				//ageTF.setText("");
				passwordTF.setText("");	
				//timeTF.setText("");					
				//qualificationTF.setText("");	
				//feesTF.setText("");					
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Salesman creation failed");
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