import ENTITY.*;

import java.lang.*;
import java.util.*;


public class SellRepo 
{
	DatabaseConnection dbc = null;
	
	public SellRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	
	public void insertSellData(Sell s)
	{					
		String query = "INSERT INTO `sales`(`id`, `product_name`, `sell_quantity`, `total_price`, `customer_name`) VALUES (NULL,'"
						+ s.getProductName()+"',"+s.getQuantity()+","+s.getTotalPrice()+",'"+s.getCustomerName()+"');";
						
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public String[][] getAll()
	{
		List<Sell> salesList = new ArrayList();
		String query = "SELECT * FROM `sales`;";  

		System.out.println(query);		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);	
		
			while(dbc.result.next())
			{
				Sell sell = new Sell();				
				sell.setId(dbc.result.getInt("id"));
				sell.setQuantity(dbc.result.getInt("sell_quantity"));	
				sell.setTotalPrice(dbc.result.getInt("total_price"));				
				sell.setProductName(dbc.result.getString("product_name"));	
				sell.setCustomerName(dbc.result.getString("customer_name"));				

				salesList.add(sell);		
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		
		Object obj[] = salesList.toArray();
		String data[][] = new String [salesList.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Sell)obj[i]).getId()+"";			
			data[i][1] = ((Sell)obj[i]).getProductName();
			data[i][2] = (((Sell)obj[i]).getQuantity())+"";
			data[i][3] = (((Sell)obj[i]).getTotalPrice())+"";
			data[i][4] = (((Sell)obj[i]).getCustomerName());
		}
		return data;		
	}
	
}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		