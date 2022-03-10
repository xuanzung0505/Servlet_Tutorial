package BookStoreOnlineSystem.businesslogic.customerDAO;

import BookStoreOnlineSystem.model.cart.*;
import BookStoreOnlineSystem.model.customer.Account;
import java.sql.SQLException;

public interface CustomerDAO {

	Account checkLogin(String username, String password) throws SQLException;

	/**
	 * 
	 * @param cart
	 */
	void createCart(Cart cart);

	void deleteCustomer();

	void updateCustomer();

}