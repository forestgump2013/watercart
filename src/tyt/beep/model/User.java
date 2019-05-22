package tyt.beep.model;

import java.util.List;

public class User {
	
	private int id;
	private String open_id;
	private String mobile;
	
	private List<Order> orders;
	private List<Address> addresses;
	
	public User(){
		
	}
	
	
	public User(String openid,String mbi){
		this.open_id=openid;
		this.mobile=mbi;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setID(int dd){
		this.id=dd;
	}
	
	public String getOpenid(){
		return open_id;
	}
	
	public void setOpenid(String openid){
		this.open_id=openid;
	}
	
	public void setOrders(List<Order> orders ){
		this.orders=orders;
	}
	
	public void setAddresses(List<Address> addresses){
		this.addresses=addresses;
	}
	
	
	public String getMobile(){
		return mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
		
	}

}
