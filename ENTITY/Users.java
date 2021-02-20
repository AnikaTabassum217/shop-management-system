package ENTITY;

import java.lang.*;


public class Users{
	private int ID;
	private String Name;
	private String Passward;
	private String Type;
	
	public Users(){
		System.out.println("Empty-constructor");
	}
	
	public Users(int ID,String Name,String Passward,String Type){
		
		this.ID=ID;
		this.Name=Name;
		this.Passward=Passward;
		this.Type=Type;
	}
	
	public void setID(int ID)
	{
		this.ID=ID;
	}
	
	public void setName(String Name)
	{
		this.Name=Name;
	}
	
	public void setPassward(String Passward)
	{
		this.Passward=Passward;
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
	
	public String getPassward(){
		 return Passward;
	 }
	 public String getType(){
		return Type;
	}
	}