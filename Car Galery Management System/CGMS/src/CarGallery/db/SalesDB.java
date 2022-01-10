package CarGallery.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import CarGallery.Domain.BuyCarDomain;
import CarGallery.Domain.SalesDomain;
import CarGallery.Gui.interfacecar;

public class SalesDB implements interfacecar<SalesDomain> {
	// in this class we get sales info and send DB, and implement interface methods
	@Override
	public void Insert(SalesDomain salesInfo) {
		// TODO Auto-generated method stub
		try {
			// insert sales info into db
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			// we make a query to add sales info in db
			stmt.executeUpdate("INSERT INTO sale(customername,salestime,moneydelay,salesprice,Plaque) VALUES('"
					+ salesInfo.getCustomername() + "','" + salesInfo.getSaletime() + "','" + salesInfo.getMoneydelay()
					+ "','" + salesInfo.getSaleprice() +"','" + salesInfo.getPlaque()+ "')");// get all sales features from sales domain class

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void Delete(SalesDomain saleWillDeleted) { // in here delete a selected sale
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			  // if selected sale is in db we delete it
			stmt.executeUpdate("DELETE FROM sale WHERE id = " + saleWillDeleted.getId());

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 
 

	public static List<SalesDomain> toListSales() {// and from db we take all sales to list in class
		List<SalesDomain> salesList = new ArrayList<SalesDomain>();

		try {
			Connection conn = ConnectionToDB.getConnection();
			Statement stmt = conn.createStatement();
			// we select all sales and withh loop we get all cars
			ResultSet rs = stmt.executeQuery("SELECT * FROM sale ORDER BY id DESC");

			while (rs.next()) {
				SalesDomain salesInfoAll = new SalesDomain();

				salesInfoAll.setId(rs.getInt("id"));

				salesInfoAll.setCustomername(rs.getString("customername"));
				salesInfoAll.setSaletime(rs.getDate("salestime"));
				salesInfoAll.setMoneydelay(rs.getString("moneydelay"));
				salesInfoAll.setSaleprice(rs.getInt("salesprice"));
				salesInfoAll.setPlaque(rs.getInt("Plaque"));
	
                
				salesList.add(salesInfoAll);// in the end we put all sales and than send where we call this method
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesList;

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
