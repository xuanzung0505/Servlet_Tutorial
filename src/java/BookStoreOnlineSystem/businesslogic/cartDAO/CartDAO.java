package BookStoreOnlineSystem.businesslogic.cartDAO;

import BookStoreOnlineSystem.model.cart.Cart;
import BookStoreOnlineSystem.model.cart.CartItem;

public interface CartDAO {

	void addToCart(CartItem cartItem, Cart cart);

	void updateItem();

}