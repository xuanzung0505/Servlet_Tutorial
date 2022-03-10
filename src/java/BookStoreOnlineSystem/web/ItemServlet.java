/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreOnlineSystem.web;

import BookStoreOnlineSystem.businesslogic.cartDAO.CartDAOImpl;
import BookStoreOnlineSystem.businesslogic.itemDAO.ItemDAOImpl;
import BookStoreOnlineSystem.model.item.Item;
import BookStoreOnlineSystem.model.cart.Cart;
import BookStoreOnlineSystem.model.cart.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author typpo
 */
@WebServlet(name = "ItemServlet", urlPatterns = {"/add-form", "/cart"})
public class ItemServlet extends HttpServlet {

    private ItemDAOImpl itemDAOImpl;
    private CartDAOImpl cartDAOImpl;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ItemServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ItemServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void showShopping(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        itemDAOImpl = new ItemDAOImpl();
        ArrayList<Item> itemList = itemDAOImpl.listAllItem();
//        System.out.println(itemList.size());
        HttpSession session = request.getSession();
        session.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shopping.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        itemDAOImpl = new ItemDAOImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Item existingItem = itemDAOImpl.selectItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-item-form.jsp");
        request.setAttribute("item", existingItem);
        dispatcher.forward(request, response);
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

    private void addItemtoCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        HttpSession session = request.getSession(false);
        itemDAOImpl = new ItemDAOImpl();
        cartDAOImpl = new CartDAOImpl();
        CartItem cartItem = null;

        Item item = itemDAOImpl.selectItem(Integer.parseInt(request.getParameter("id")));
//        System.out.print(item.getId() + " " + item.getName() + " " + item.getUnitPrice());
        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        System.out.println(" " + quantity);

        if (session != null) {
            if (session.getAttribute("cart") == null) {
                Cart cart = new Cart();
                cartItem = new CartItem();
                cartItem.setItem(item);
                cartItem.setQuantity(quantity); //change the price
                cartDAOImpl.addToCart(cartItem, cart);
                session.setAttribute("cart", cart);
            } else {
                Cart cart = (Cart) session.getAttribute("cart");
                int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
                if (index == -1) {
                    cartItem = new CartItem();
                    cartItem.setItem(item);
                    cartItem.setQuantity(quantity);
                    cartDAOImpl.addToCart(cartItem, cart);
                } else {
                    int addMore = 1;
                    float totalPrice = cart.getTotalPrice();
//                    
//                    quantity = cart.getCartItems().get(index).getQuantity() + addMore;
//                    cart.getCartItems().get(index).setQuantity(quantity);
                    cart.addMore(index, addMore);
                }
                session.setAttribute("cart", cart);
            }
        }
        response.sendRedirect("cart");
    }

    private int isExisting(int id, Cart cart) {
        ArrayList<CartItem> cartItems = cart.getCartItems();
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getItem().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/add-form": {
                    try {
                        showAddForm(request, response);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                break;

                case "/cart":
                    showCart(request, response);
                    break;
                default:
                    try {
                    showShopping(request, response);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("button-add-to-cart") != null) {
                try {
                    addItemtoCart(request, response);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
