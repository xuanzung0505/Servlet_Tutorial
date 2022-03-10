package BookStoreOnlineSystem.businesslogic.itemDAO;

import BookStoreOnlineSystem.model.item.Item;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

    void searchItem();

    ArrayList<Item> listAllItem() throws SQLException;
    
    Item selectItem(int id) throws SQLException ;
}
