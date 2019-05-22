package tyt.beep.model;

import com.sun.corba.se.impl.util.Utility;

import tyt.beep.util.MyUtility;

public class Order {
	
	private int  id;
	private int client_id;
	private int address_id;
	private String order_time;
	private String order_content;
	private int status;
	
	
	public Order(){
		
	}
	
	public Order(int addId,String content){
		this.address_id=addId;
		this.order_content=content;
		this.status=0;
		this.order_time=MyUtility.currentTime();
		
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int tt){
		this.id=tt;
	}
	
	public void setAddressId(int id){
		this.address_id=id;
	}
	
	public int getAddressId(){
		return this.address_id;
	}
	
	
	public void setOrderTime(String time){
		this.order_time=time;
	}
	
	public String getOrderTime(){
		return this.order_time;
	}
	
	public void setOrderContent(String content){
		this.order_content=content;
	}
	
	public String getOrderContent(){
		return this.order_content;
	}
	
	public void setStaus(int f){
		this.status=f;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	

}
