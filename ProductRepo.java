import ENTITY.*;

import java.lang.*;
import java.util.*;


public class ProductRepo 
{
	DatabaseConnection dbc = null;
	
	public ProductRepo()
	{
		dbc = new DatabaseConnection();
	}	
	
	
	public void insertProduct(Product p)
	{						
		String query = "INSERT INTO `product`(`id`, `name`, `quantity`, `price`, `type`) VALUES (NULL,'"
						+ p.getName() +"', "+ p.getQuantity() 
						+","+ p.getPrice() +",'"+  p.getType() +"');";
						
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateProduct(Product p)
	{
			
		String query = "UPDATE `product` SET `name` = '" +p.getName()
						+"',`quantity` = "+p.getQuantity()
						+",`type` = '"+p.getType()
						+"',`price` = "+p.getPrice()
						+"  WHERE `id` = " +p.getId()+";";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteProduct(String id)
	{
		String query = "DELETE from product  WHERE id='"+id+"';";
		
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void updateQuantity(String productName, int quantity)
	{
		String query = "SELECT * FROM `product` WHERE name='"+productName+"';";
		
		System.out.println(query);
		try
		{
	
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				Product product = new Product();				
				product.setId(dbc.result.getInt("id"));
				product.setQuantity(dbc.result.getInt("quantity")-quantity);	
				product.setPrice(dbc.result.getInt("price"));				
				product.setName(dbc.result.getString("name"));	
				product.setType(dbc.result.getString("type"));				

				updateProduct(product);		
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
	}
	
	public String[][] getAll()
	{
		List<Product> productList = new ArrayList();
		String query = "SELECT * FROM `product`;";  

		System.out.println(query);		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				Product product = new Product();				
				product.setId(dbc.result.getInt("id"));
				product.setQuantity(dbc.result.getInt("quantity"));	
				product.setPrice(dbc.result.getInt("price"));				
				product.setName(dbc.result.getString("name"));	
				product.setType(dbc.result.getString("type"));				

				productList.add(product);		
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		
		Object obj[] = productList.toArray();
		String data[][] = new String [productList.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getId()+"";			
			data[i][1] = ((Product)obj[i]).getName();
			data[i][2] = (((Product)obj[i]).getQuantity())+"";
			data[i][3] = (((Product)obj[i]).getPrice())+"";
			data[i][4] = (((Product)obj[i]).getType());
		}
		return data;		
	}
	
	
}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		