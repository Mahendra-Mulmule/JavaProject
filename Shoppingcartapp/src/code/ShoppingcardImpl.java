package code;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShoppingcardImpl  implements Shoppingcart{

	
	String url="jdbc:mysql://localhost:3306/shoppingcartdb";
	String username="root";
	String password="root";
	
	Connection connection;
	
	ShoppingcardImpl() throws SQLException{
		//constructor
		  
		connection  = DriverManager.getConnection(url, username, password);

		System.out.println("connection Enstablishhed successfully!!!");
		
		
	}
	
	
	
	@Override
	public void addProduct(Product product) throws SQLException {
		
		String query ="insert into Product (id, name,price) values(?,?,?)";
		PreparedStatement stmt=null;
		
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.executeUpdate();
			System.out.println("product added successfully");
		}catch(Exception e) {
			
		}
		stmt.close();	
	}


	@Override
	public List<Product> getProduct() throws SQLException {
		//fetch product
		
		String query="select *from Product";
		Statement   stmt=null;
		ResultSet rs=null;
		List<Product> product=new ArrayList<Product>();
		
		try {
			stmt=connection.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double price=rs.getDouble("price");
				
				product.add(new Product(id, name, price));
				
			}
		}catch (Exception e) {
			
		}
		stmt.close();
		
		
		return product;
	}
	public void closeConenction() throws SQLException {
		if(connection!=null) {
			connection.close();
			System.out.println("connection closed success");
			
		}
	}
	

	@Override
	public double calculateTotal() {
		// TODO Auto-generated method stub
		
		
		return 0;
	}
	@Override
	public boolean removeProdcut(int productId) {
		// TODO Auto-generated method stub
		return false;
	}


}
