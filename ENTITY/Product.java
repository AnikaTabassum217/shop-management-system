package ENTITY;

import java.lang.*;

public class Product {
	private int ID;
	private String Name;
	private int Quantity;
	private int Price;
	private String Type;
	
	public Product(){
	System.out.println("Empty -Constructor");
	}
	
	public Product(int ID,String Name,int Quantity,String Type)
	{
		this.ID=ID;
		this.Name=Name;
		this.Quantity= Quantity;
		this.Type=Type;
	}
	
	public void setId(int ID)
	{
		this.ID=ID;
	}
	
	public void setName(String Name)
	{
		this.Name=Name;
	}
	
	public void setQuantity(int Quantity)
	{
		this.Quantity=Quantity;
	}
	
	public void setPrice(int Price)
	{
		this.Price=Price;
	}

    public void setType(String Type)
	{
		this.Type=Type;
	}

    public int getId()
	{
		return ID;
	}
	
	public String getName(){
		return Name;	
	}
	
	public int  getQuantity(){
		 return Quantity;
	 }
	 
	 public int getPrice()
	{
		return Price;
	}
	 
	
	 
	  public String getType(){
		return Type;
	}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

