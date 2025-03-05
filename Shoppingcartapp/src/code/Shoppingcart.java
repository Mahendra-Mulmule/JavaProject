package code;

import java.sql.SQLException;

import java.util.List;

public interface Shoppingcart {

	void addProduct(Product product) throws SQLException;
	boolean removeProdcut(int productId);
	List<Product> getProduct() throws SQLException;
	double calculateTotal();
	void closeConenction() throws SQLException;
}
