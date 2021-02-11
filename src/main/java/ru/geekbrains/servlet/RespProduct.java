package ru.geekbrains.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RespProduct", urlPatterns = "/product")
public class RespProduct extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Apple", 10));
        products.add(new Product(2,"Orange", 15));
        products.add(new Product(3,"Banana", 17));
        products.add(new Product(4,"Lemon", 22));
        products.add(new Product(5,"Tomato", 45));
        products.add(new Product(6,"Look:))", 95));
        products.add(new Product(7,"Pringles", 75));
        products.add(new Product(8,"Potato", 44));
        products.add(new Product(9,"Milk", 53));
        products.add(new Product(10,"Beer", 12));


        for (  Product p: products  ) {
            resp.getWriter().println("<h1>" + String.format("%d,  %s,  %d", p.getId(), p.getTitle(), p.getCost()) + "</h1>");
        }


    }
}
