package com.myJax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myJax.persistence.connection.EntityManagerSingleton;

import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DBpublishData extends HttpServlet {
    ServletConfig myConfig;
    // @Override
    // public void destroy() {
    //     // TODO Auto-generated method stub
        
    // }

    // @Override
    // public ServletConfig getServletConfig() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public String getServletInfo() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        myConfig=arg0;
        System.out.println("Init!!!!!");
        
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("DO---------GET!!!");
        System.out.println("START!!!");

        EntityManager entityManager = EntityManagerSingleton.getInstance().createEntityManager();

        
        //Create Data
        // User userBuyer = new User("aa@aa.com", "99 street88", new Date(1678606523) , "Abdo Buyer", "1234");
        // User userSeller = new User("aab@aa.com", "99b street88", new Date(1678606523) , "Abdo Seller", "1234");
        // entityManager.getTransaction().begin();
        // entityManager.persist(userBuyer);
        // entityManager.persist(userSeller);
        // entityManager.getTransaction().commit();

        // Buyer buyer = new Buyer(userBuyer, "hello");
        // Seller seller = new Seller(userSeller, "this is a Seller");
        // entityManager.getTransaction().begin();
        // entityManager.persist(buyer);
        // entityManager.persist(seller);
        // entityManager.getTransaction().commit();

        // Category category1 = new Category("cat 1");
        // Category category2 = new Category("cat 2");
        // entityManager.getTransaction().begin();
        // entityManager.persist(category1);
        // entityManager.persist(category2);
        // entityManager.getTransaction().commit();
        // Set catSet = new HashSet<Category>(0);
        // catSet.add(category1);
        // catSet.add(category2);

        // Product product = new Product("MyProduct", "MyManuName", new Date(1678606523), 5, new Date(1678006523), new Date(1679906523));
        // product.setCategories(catSet);        
        // product.setSeller(seller);
        // entityManager.getTransaction().begin();
        // entityManager.persist(product);
        // entityManager.getTransaction().commit();

        // BuyerBidProductId buyerBidProductId = new BuyerBidProductId(buyer.getId(), product.getId());
        // BuyerBidProduct buyerBidProduct = new BuyerBidProduct(buyerBidProductId, buyer, product, new Date(1678006023), 300, 2);
        // BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId(buyer.getId(), product.getId());
        // BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct(buyerBuyProductId, buyer, product, new Date(1678006523), 500, 3);
        // entityManager.getTransaction().begin();
        // entityManager.persist(buyerBidProduct);
        // entityManager.persist(buyerBuyProduct);
        // entityManager.getTransaction().commit();


        // //Delete Data
        // entityManager.getTransaction().begin();
        // Buyer buyer = entityManager.find(Buyer.class,3);
        // Seller seller = entityManager.find(Seller.class,6);
        // Product product1 = entityManager.find(Product.class,3);

        // BuyerBidProductId buyerBidProductId = new BuyerBidProductId(buyer.getId(), product1.getId());
        // BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId(buyer.getId(), product1.getId());
        
        // BuyerBidProduct buyerBidProduct = entityManager.find(BuyerBidProduct.class,buyerBidProductId);
        // entityManager.remove(buyerBidProduct);

        // BuyerBuyProduct buyerBuyProduct = entityManager.find(BuyerBuyProduct.class,buyerBuyProductId);
        // entityManager.remove(buyerBuyProduct);
        // entityManager.getTransaction().commit();


        // entityManager.getTransaction().begin();
        // Product product = entityManager.find(Product.class,3);
        // entityManager.remove(product);
        // entityManager.getTransaction().commit();

        // entityManager.getTransaction().begin();
        // Category cat1 = entityManager.find(Category.class,5);
        // Category cat2 = entityManager.find(Category.class,6);
        // entityManager.remove(cat1);
        // entityManager.remove(cat2);
        // entityManager.getTransaction().commit();

        // entityManager.getTransaction().begin();
        // Buyer buyer2 = entityManager.find(Buyer.class,3);
        // Seller seller2 = entityManager.find(Seller.class,6);
        // entityManager.remove(buyer2);
        // entityManager.remove(seller2);
        // entityManager.getTransaction().commit();

        // entityManager.getTransaction().begin();
        // User userBuyer = entityManager.find(User.class,5);
        // User userSeller = entityManager.find(User.class,6);
        // entityManager.remove(userBuyer);
        // entityManager.remove(userSeller);
        // entityManager.getTransaction().commit();

        

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }
}
