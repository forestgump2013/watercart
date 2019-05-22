package tyt.beep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import tyt.beep.model.Address;
import tyt.beep.model.Order;
import tyt.beep.model.User;

@Repository
public class UserDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	public void getJdbcTemplate(){
		ApplicationContext factory=new ClassPathXmlApplicationContext("spring-mvc.xml");
		jdbcTemplate=(JdbcTemplate)factory.getBean("jdbcTemplate");
		System.out.println("jdbctemplate:"+jdbcTemplate.getFetchSize());
		
	}

	public int addUser(User user){
		try{
			String sql="insert into user(open_id) values(?)";
			int result=jdbcTemplate.update(sql, new Object[]{user.getOpenid()});
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public User selectUser(String openId){
		String sql="select * from user where open_id=?";
		
		final User user=new User();
		
		jdbcTemplate.query(sql, new Object[]{openId},new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		return user;
	}
	
	
	public int addOrder(Order order){
		try{
			
			String sql="insert into order_tb(address_id,order_time,order_content,status) values(?,?,?,?) ";
			int result=jdbcTemplate.update(sql, new Object[]{order.getAddressId(),order.getOrderTime(),order.getOrderContent(),order.getStatus()});
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateOrder(Integer id,Integer status){
                try{
			
			String sql="update order set status=? where id=? ";
			int result=jdbcTemplate.update(sql, new Object[]{status,id});
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Order> selectOrders(final String openid){
		String sql="select * from order a ,user b where a.contact_id=b.id and b.open_id=?";
		
		final List<Order> orders=new ArrayList<Order>();
		
		jdbcTemplate.query(sql, new Object[]{openid}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Order order=new Order();
				order.setAddressId(rs.getInt("address_id"));
                order.setOrderTime(rs.getString("order_time"));
                order.setOrderContent(rs.getString("order_content"));
                order.setStaus(rs.getInt("status"));
				orders.add(order);
			}
			
		});
		
		return orders;
	}
	
	public List<Address> selectAddresses(final String openid ){
		String sql="select * from address_tb a, user_tb b where a.user_id=b.id and b.open_id=?";
		final List<Address> addresses=new ArrayList<Address>();
		
		jdbcTemplate.query(sql, new Object[]{openid}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Address address=new Address();
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setMobile(rs.getString("mobile"));
				address.setAddress(rs.getString("address"));
				addresses.add(address);
				
			}
			
		});
		
		return addresses;
		
	}
	
	public void method1(){
		System.out.println("method1 ...");
		
	}
}
