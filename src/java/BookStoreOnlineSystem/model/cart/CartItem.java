package BookStoreOnlineSystem.model.cart;

import BookStoreOnlineSystem.model.item.*;

public class CartItem {

    private int quantity;
    private Item item; //unit price
    private float price; //unit price * quantity
    
    public CartItem() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price = item.getUnitPrice() * quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
