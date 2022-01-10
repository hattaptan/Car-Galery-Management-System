package CarGallery.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

import CarGallery.Domain.CustomerDomain;
import CarGallery.Gui.interfacecar;
public class CustomerDB extends ConnectionToDB implements interfacecar<CustomerDomain> {
	 // in this class we get customer info and send DB, and implement interface methods
	
	

	@Override
	public void Insert(CustomerDomain customerinfo) {
		// TODO Auto-generated method stub
		

		try {
			
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			// we make a query to add customer info in db
			stmt.executeUpdate("INSERT INTO customer(name,surname,gender,birthday,telephone,address) VALUES('"
					+customerinfo.getName()
					+ "','"      // get all customer information customer domain class
					+customerinfo.getSurname()
					+ "','"
					+customerinfo.getGender()
					+ "','"
					+customerinfo.getBirthday()
					+ "','"
					+customerinfo.getTelephone()
					+ "','"
					+customerinfo.getAddress()
					+ "')");
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


	@Override
	public void Delete(CustomerDomain DeletedCustomerInfo) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			   // if selected customer is in db we delete it
			stmt.executeUpdate("DELETE FROM customer WHERE id = "
					+ DeletedCustomerInfo.getId());

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public static ArrayList<CustomerDomain> find(String wanted) {// find a customer by name
		
		ArrayList<CustomerDomain> WantedCustomer = new ArrayList<CustomerDomain>();
	
	try {
		
		Connection conn = ConnectionToDB.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE name LIKE '"
				+ wanted + "%'");
		
		while (rs.next()) {

			
			CustomerDomain SearchCustomer = new CustomerDomain();
			
			
			SearchCustomer.setId(rs.getInt("id"));
			SearchCustomer.setName(rs.getString("name"));
			SearchCustomer.setSurname(rs.getString("surname"));
			SearchCustomer.setGender(rs.getString("gender"));
			SearchCustomer.setBirthday(rs.getDate("birthday"));
			SearchCustomer.setTelephone(rs.getString("telephone"));
			SearchCustomer.setAddress(rs.getString("address"));
			WantedCustomer.add(SearchCustomer);
			
			
			
		 
			
		}
		
		stmt.close();
		conn.close();
		
	} catch (SQLException e) {

	
	}
	return WantedCustomer;
	
	}


	
	
	
	
	
	

	public static ArrayList<CustomerDomain> toListCustomer() {// and from db we take all customer to list in class
		
		ArrayList<CustomerDomain> customerlist = new ArrayList<CustomerDomain>();
	
	try {
		
		Connection conn = ConnectionToDB.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		
		while (rs.next()) {// we select all customers and withh loop we get all customers
			
			CustomerDomain customerdomain = new CustomerDomain();
			
			
			customerdomain.setId(rs.getInt("id"));
			customerdomain.setName(rs.getString("name"));
			customerdomain.setSurname(rs.getString("surname"));
			customerdomain.setGender(rs.getString("gender"));
			customerdomain.setBirthday(rs.getDate("birthday"));
			customerdomain.setTelephone(rs.getString("telephone"));
			customerdomain.setAddress(rs.getString("address"));
			customerlist.add(customerdomain);			
		}
		
		stmt.close();
		conn.close();
		
	} catch (SQLException e) {

	
	}
	return customerlist;
	
	}


	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
