package BookStoreOnlineSystem.businesslogic.customerDAO;

import BookStoreOnlineSystem.model.cart.*;
import BookStoreOnlineSystem.model.customer.Account;
import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {
    
    private Connection connection;
    
    public CustomerDAOImpl() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/btlpttk";
        String dbUser = "root";
        String dbPassword = "root";

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    @Override
    public Account checkLogin(String username, String password) throws SQLException{
        String sql = "SELECT * FROM btlpttk.account\n"
                + "WHERE Username=? AND Password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        Account account = null;

        if (result.next()) {
            account = new Account();
            account.setId(result.getInt("ID"));
            account.setUsername(result.getString("Username"));
            account.setPassword(result.getString("Password"));
            account.setCard(result.getInt("Card"));
            account.setPoint(result.getInt("Point"));
            account.setStatus(result.getString("Status"));
        }

        connection.close();

        return account;
    }

    /**
     *
     * @param cart
     */
    public void createCart(Cart cart) {
        // TODO - implement CustomerDAOImpl.createCart
        throw new UnsupportedOperationException();
    }

    public void deleteCustomer() {
        // TODO - implement CustomerDAOImpl.deleteCustomer
        throw new UnsupportedOperationException();
    }

    public void updateCustomer() {
        // TODO - implement CustomerDAOImpl.updateCustomer
        throw new UnsupportedOperationException();
    }

}
