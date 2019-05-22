package tyt.beep.service;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tyt.beep.dao.UserDao;
import tyt.beep.model.Order;
import tyt.beep.model.User;

@Service
public class OrderService {
	
	@Autowired
	UserDao userDao;
	
	public void  addOrder(Order order){
		userDao.addOrder(order);
	}

	public int addOrder(int  address_id,String content ){
		
		///User user=userDao.selectUser(open_id);
		
		Order order=new Order(address_id,content);
		int result= userDao.addOrder(order);
		System.out.println("service add Order:"+result);
		return result;
		
	}
	
	public String login(String open_id){
		
		User user=userDao.selectUser(open_id);
		if(user==null){
			user=new User();
			user.setOpenid(open_id);
		}else{
			List<Order> orders=userDao.selectOrders(open_id);
			user.setOrders(orders);
		}
		
		
		JSONObject jsonObject=JSONObject.fromObject(user);
		
		
		return jsonObject.toString();
		
	}
	
}
