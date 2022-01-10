package CarGallery.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Gui.interfacecar;


public class BuyCarDB extends ConnectionToDB implements interfacecar<BuyCarDomain> {
                        // in this class we get car info and send DB, and implement interface methods
	@Override
	public void initJFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel initJPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(BuyCarDomain carInfo) {// insert car info into db
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			// we make a query to add car info in db
			stmt.executeUpdate("INSERT INTO buycar(plaque,color,brand,model,gear,fuel,type,engine,door,price) VALUES('"
					+carInfo.getPlaque()
					+"','"
					+carInfo.getColor()// get all car features from buy car domain class
					+"','"
					+carInfo.getBrand()
					+"','"
					+carInfo.getModel()
					+"','"
					+carInfo.getGear()
					+"','"
					+carInfo.getFuel()
					+"','"
					+carInfo.getType()
					+"','"
					+carInfo.getEngine()
					+"','"
					+carInfo.getDoor()
					+"','"
					+carInfo.getPrice() + "')");
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void Delete(BuyCarDomain deleteCarInfo) { // in here delete a selected car
		// TODO Auto-generated method stub
try {
			
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			   // if selected car is in db we delete it
			stmt.executeUpdate("DELETE FROM `buycar` WHERE `buycar`.`id`=" + deleteCarInfo.getId());
			System.out.println("getid : "+deleteCarInfo.getId());
			System.out.println(" statemente girdi");
			 
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("hatalý");
		}
		
	}
	
	
	
	public static ArrayList<BuyCarDomain> toListCar() { // and from db we take all car to list in class
		ArrayList<BuyCarDomain> aracbilgi = new ArrayList<BuyCarDomain>();

		try {

			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM buycar");

			while (rs.next()) { // we select all cars and withh loop we get all cars

				BuyCarDomain carToAdd = new BuyCarDomain();// 

				carToAdd.setId(rs.getInt("id"));
				carToAdd.setPlaque(rs.getString("plaque"));
				carToAdd.setColor(rs.getString("color"));
				carToAdd.setBrand(rs.getString("brand"));
				carToAdd.setModel(rs.getString("model"));
				carToAdd.setGear(rs.getString("Gear"));
				carToAdd.setFuel(rs.getString("fuel"));
				carToAdd.setType(rs.getString("type"));
				carToAdd.setEngine(rs.getString("engine"));
				carToAdd.setDoor(rs.getInt("door"));
				carToAdd.setPrice(rs.getInt("price"));

				aracbilgi.add(carToAdd); // in the end we put all car and send where we call this method

			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return aracbilgi;

	}

	public static BuyCarDomain find(int id) {// find a car by id
		BuyCarDomain findplaqueDomain = new BuyCarDomain();

		try {

			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM buycar WHERE id = " + id);

			while (rs.next()) {

				findplaqueDomain.setId(rs.getInt("id"));
				findplaqueDomain.setPlaque(rs.getString("plaque"));
				findplaqueDomain.setColor(rs.getString("color"));
				findplaqueDomain.setBrand(rs.getString("brand"));
				findplaqueDomain.setModel(rs.getString("model"));
				findplaqueDomain.setGear(rs.getString("Gear"));
				findplaqueDomain.setFuel(rs.getString("fuel"));
				findplaqueDomain.setType(rs.getString("type"));
				findplaqueDomain.setEngine(rs.getString("engine"));
				findplaqueDomain.setDoor(rs.getInt("door"));
				findplaqueDomain.setPrice(rs.getInt("price"));

			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return findplaqueDomain;

	}  

	public static ArrayList<BuyCarDomain> find(String wanted) { //find a car

		ArrayList<BuyCarDomain> wantedlist = new ArrayList<BuyCarDomain>();

		try {

			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM buycar WHERE plaque LIKE  '" + wanted + "%'");

			while (rs.next()) {

				BuyCarDomain findplaqueAranan = new BuyCarDomain();

				findplaqueAranan.setId(rs.getInt("id"));
				findplaqueAranan.setPlaque(rs.getString("plaque"));
				findplaqueAranan.setColor(rs.getString("color"));
				findplaqueAranan.setBrand(rs.getString("brand"));
				findplaqueAranan.setModel(rs.getString("model"));
				findplaqueAranan.setGear(rs.getString("Gear"));
				findplaqueAranan.setFuel(rs.getString("fuel"));
				findplaqueAranan.setType(rs.getString("type"));
				findplaqueAranan.setEngine(rs.getString("engine"));
				findplaqueAranan.setDoor(rs.getInt("door"));
				findplaqueAranan.setPrice(rs.getInt("price"));

				wantedlist.add(findplaqueAranan);

			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return wantedlist;

	}






}
