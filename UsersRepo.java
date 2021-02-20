import ENTITY.*;

import java.lang.*;
import java.util.*;


public class UsersRepo 
{
	DatabaseConnection dbc = null;
	
	public UsersRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public Users getUser(String name, String pass)
	{
		Users user = null;
		String query = "Select * from users where name = '"+name+"' and password = '"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
			System.out.println("Query complete");
			while(dbc.result.next())
			{
				user = new Users();
				System.out.println("inside while");
				
				user.setID(dbc.result.getInt("id"));
				user.setPassward(dbc.result.getString("password"));
				user.setName(dbc.result.getString("name"));				
				user.setType(dbc.result.getString("type"));				
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	
	
	public void insertUser(Users user)
	{
		String query = "INSERT INTO `users` (`id`, `name`,`Password`, `type`) VALUES (NULL,'"
						+user.getName()+"','"+user.getPassward()+"','"+user.getType()+"');";
						
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateUser(Users user)
	{
			
		String query = "UPDATE `users` SET `name` = '" +user.getName()
						+"',`password` = '"+user.getPassward()
						+"',`type` = '"+user.getType()+"'  WHERE `id` = " +user.getId()+";";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	public void deleteUser(String userId)
	{
		String query = "DELETE from users  WHERE id='"+userId+"';";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	
	public Users searchUser(String userId)
	{
		Users user = null;
		String query = "SELECT * FROM `users` WHERE `id`='"+userId+"';";  

		System.out.println(query);		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				user = new Users();				
				user.setID(dbc.result.getInt("id"));
				user.setPassward(dbc.result.getString("password"));				
				user.setName(dbc.result.getString("name"));		
                user.setType(dbc.result.getString("type"));					
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	
	
	/*public String[][] getAllUserByType(String type)
	{
		List<Users> userList = new ArrayList();
		String query = "SELECT * FROM `Users` WHERE `Type`='"+type+"';";  

		System.out.println(query);		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				Users user = new Users();				
				user.setID(dbc.result.getInt("ID"));
						
				user.setName(dbc.result.getString("Name"));		

				userList.add(user);		
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		
		Object obj[] = userList.toArray();
		String data[][] = new String [userList.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Users)obj[i]).getID()+"";			
			data[i][1] = ((Users)obj[i]).getName();
			//data[i][2] = (((Users)obj[i]).getAge())+"";
		}
		return data;		
	}*/
}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		