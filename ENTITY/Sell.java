package ENTITY;

import java.lang.*;

public class Sell{
	private int ID;
	private String ProductName;
	private int SellQuantity;
	private int TotalPrice;
	private String CustomerName;
	
	public Sell(){
		System.out.println("Empty-constructor");
	}
	
	public Sell(int ID,String ProductName,int SellQuantity,int TotalPrice,String CustomerName ){
		
		this.ID=ID;
		this.ProductName=ProductName;
		this.SellQuantity=SellQuantity;
		this.TotalPrice=TotalPrice;
		this.CustomerName=CustomerName;
	}
	
	public void setId(int ID)
	{
		this.ID=ID;
	}
	
	public void setProductName(String ProductName)
	{
		this.ProductName=ProductName;
	}
	
	public void setQuantity(int SellQuantity)
	{
		this.SellQuantity=SellQuantity;
	}
	
	public void setTotalPrice(int TotalPrice)
	{
		this.TotalPrice=TotalPrice;
	}
	
	public void setCustomerName(String CustomerName)
	{
		this.CustomerName=CustomerName;
	}
	
	public int getId()
	{
		return ID;
	}
	
	public String getProductName()
	{
		 return ProductName;
	}
	
	public int getQuantity()
	{
		return SellQuantity;
	}
	
	public int getTotalPrice()
	{
		return TotalPrice;
	}
	
	public String getCustomerName()
	{
		return CustomerName;
	}
}
	
	
	
	
	
	
	
	