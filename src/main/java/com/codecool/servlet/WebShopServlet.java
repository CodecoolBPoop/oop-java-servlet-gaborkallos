package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "MyWebShop", urlPatterns = {"/webshop"}, loadOnStartup = 3)
public class WebShopServlet extends HttpServlet {

    public ItemStore cart = new ItemStore();
    public ItemStore stock = new ItemStore();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        String title = "This is my Webshop";



        stock.add(new Item("Asus Laptop", 1600));
        stock.add(new Item("Lenovo Laptop", 1620));
        stock.add(new Item("Game of Thrones Ebook", 55));
        stock.add(new Item("Harry Potter Ebook", 50));



        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                        "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n" +
                        "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>" +
                        "<body>\n" +
                        "<h2 align = \"center\">" + title + "</h2>\n" +
                        "<ul>\n" +
                        "<div class=\"container\">\n" +
                        "<table class=\"table table-striped\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th class=\"text-center\">Item</th>\n" +
                        "<th class=\"text-center\">Price</th>\n" +
                        "<th class=\"text-center\"></th>\n" +
                        "<th class=\"text-center\"></th>\n" +
                        "</tr>\n" +
                        "</thead>\n" +
                        "<tbody>\n" +
                        stock.init() +
                        "</tbody>\n" +
                        "</table>\n" +
                        "<input type=\"button\" value=\"Checkout!\" onclick=\"window.location.href='/checkout'\"/ class=\"btn btn-danger\"></input>" +
                        "</div>" +
                        cart.init() +
                        "</body></html>"
        );

        String add = request.getParameter("add");
        String remove = request.getParameter("remove");

        if (add != null){
            cart.add(stock.findItem(Integer.parseInt(add)));
        }

        if(remove != null){
            Item removable = cart.findItem(Integer.parseInt(remove));
            cart.remove(removable);
        }

        out.flush();
        out.close();
        stock.clearItems();



    }
}