package BookStoreOnlineSystem.businesslogic.orderDAO;

import BookStoreOnlineSystem.model.cart.*;

public interface OrderDAO {

	void updateOrder();

	void deleteOrder();

	/**
	 * 
	 * @param cart
	 */
	void createOrder(Cart cart);

}