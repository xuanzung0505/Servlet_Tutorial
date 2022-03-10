package BookStoreOnlineSystem.businesslogic.cartDAO;

import BookStoreOnlineSystem.model.cart.Cart;
import BookStoreOnlineSystem.model.cart.CartItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAOImpl implements CartDAO {

    private Connection connection;

    public CartDAOImpl() throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/btlpttk";
        String dbUser = "root";
        String dbPassword = "root";

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    @Override
    public void addToCart(CartItem cartItem, Cart cart) {
        ArrayList<CartItem> cartItems = cart.getCartItems();
        cartItems.add(cartItem);
        float totalPrice = 0;
        for(CartItem cartitem : cartItems){
            totalPrice += cartitem.getPrice();
        }
        cart.setTotalPrice(totalPrice);
        cart.setCartItems(cartItems);
    }

    @Override
    public void updateItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
