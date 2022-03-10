package BookStoreOnlineSystem.model.cart;

import java.util.ArrayList;

public class Cart {

    private float totalPrice;
    private ArrayList<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
        totalPrice = 0;
    }

    public void addMore(int index, int addMore) {
        CartItem cartItem = cartItems.get(index);
        int quantity = cartItem.getQuantity();
        cartItem.setQuantity(quantity + addMore);
        
        totalPrice = 0;
        for (CartItem cartitem : cartItems) {
            totalPrice += cartitem.getPrice();
        }
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

}
