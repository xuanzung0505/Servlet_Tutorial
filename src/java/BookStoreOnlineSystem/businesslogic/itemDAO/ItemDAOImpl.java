package BookStoreOnlineSystem.businesslogic.itemDAO;

import BookStoreOnlineSystem.model.item.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    private Connection connection;

    public ItemDAOImpl() throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/btlpttk";
        String dbUser = "root";
        String dbPassword = "root";

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    public void searchItem() {
        // TODO - implement ItemDAOImpl.searchItem
        throw new UnsupportedOperationException();
    }

    @Override
    public ArrayList<Item> listAllItem() throws SQLException {
        ArrayList<Item> itemList = new ArrayList<Item>();
        Item item = null;

        String sql = "SELECT * FROM btlpttk.item;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            item = new Item();
            item.setId(rs.getInt("ID"));
            item.setBarcode(rs.getString("Barcode"));
            item.setName(rs.getString("Name"));
            item.setTag(rs.getString("Tag"));
            item.setUnitPrice(rs.getFloat("UnitPrice"));
            item.setDiscount(rs.getFloat("Discount"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setImgpath(rs.getString("imgpath"));
            itemList.add(item);
        }

        return itemList;
    }

    @Override
    public Item selectItem(int id)  throws SQLException {
        Item item = null;
        String sql = "SELECT * FROM btlpttk.item WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            item = new Item();
            item.setId(rs.getInt("ID"));
            item.setBarcode(rs.getString("Barcode"));
            item.setName(rs.getString("Name"));
            item.setTag(rs.getString("Tag"));
            item.setUnitPrice(rs.getFloat("UnitPrice"));
            item.setDiscount(rs.getFloat("Discount"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setImgpath(rs.getString("imgpath"));
        }
        return item;
    }

}
