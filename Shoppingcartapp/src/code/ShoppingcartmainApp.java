package code;

import java.sql.SQLException;
import java.util.List;

public class ShoppingcartmainApp {
	
	public static void main(String[] args) throws SQLException{
		
		Shoppingcart cart=new ShoppingcardImpl();
		
		
		//add product
		
		cart.addProduct(new Product(1, "cable", 700000));
		
		cart.addProduct(new Product(2, "laptop", 60000));
		
		cart.addProduct(new Product(3, "mobile", 50000));
		
		cart.addProduct(new Product(4, "speaker", 10000));
		
		//display products
		
		List<Product> products=cart.getProduct();
		System.out.println("Display products");
		
		for(Product product:products) {
			System.out.println(product);
			
		}
		
		
		cart.closeConenction();
		
	}

}
