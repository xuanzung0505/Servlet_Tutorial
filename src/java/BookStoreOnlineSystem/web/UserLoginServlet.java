/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreOnlineSystem.web;

import BookStoreOnlineSystem.businesslogic.customerDAO.CustomerDAOImpl;
import BookStoreOnlineSystem.businesslogic.itemDAO.ItemDAOImpl;
import BookStoreOnlineSystem.model.customer.Account;
import BookStoreOnlineSystem.model.item.Item;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/login", "/shopping"})
public class UserLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void showShopping(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
        ArrayList<Item> itemList = itemDAOImpl.listAllItem();
//        System.out.println(itemList.size());
        HttpSession session = request.getSession();
        session.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shopping.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
//                case "/home":
//                    showHomePage(request, response);
//                    break;
                case "/shopping":
                    try {
                    showShopping(request, response);
                } catch (Exception Exception) {
                }
                break;
                case "/login":
                    showLogin(request, response);
                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
//                default:
//                    listUser(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerDAOImpl customerDAOImpl = null;

        try {
            customerDAOImpl = new CustomerDAOImpl();
            Account account = customerDAOImpl.checkLogin(username, password);

            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                showShopping(request, response);
            } else {
                HttpSession session = request.getSession();
                String message = "Invalid email/password";
                session.setAttribute("message", message);
                response.sendRedirect("login");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
