/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Color;
import model.Product;
import model.Size;

/**
 *
 * @author PC
 */
@WebServlet(name = "FilterProductServlet", urlPatterns = {"/filterproductservlet"})
public class FilterProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] categorysId = request.getParameterValues("category");
        String[] colorsId = request.getParameterValues("color");
        String[] sizesId = request.getParameterValues("size");
        String orderby_raw = request.getParameter("orderBy");
        String page = request.getParameter("page");
        if(page == null){
            page = "1";
        }
        int orderBy = Integer.parseInt(orderby_raw);
        String[] ans = {"0"};
        if (categorysId == null) {
            categorysId = ans;
        }
        if (colorsId == null) {
            colorsId = ans;
        }
        if (sizesId == null) {
            sizesId = ans;
        }

        String minPrice_raw = request.getParameter("minPrice");
        String maxPrice_raw = request.getParameter("maxPrice");
        ProductDAO pd = new ProductDAO();
        HttpSession session = request.getSession();
        List<Color> listColor = (List<Color>) session.getAttribute("listColor");
        List<Category> listCategory = (List<Category>) session.getAttribute("listCategory");
        List<Size> listSize = (List<Size>) session.getAttribute("listSize");
        List<Integer> listCategoryChecked = new ArrayList<>();
        List<Integer> listSizeChecked = new ArrayList<>();
        List<Integer> listColorChecked = new ArrayList<>();

        // danh dau nhung thang category muon tim
        for (int i = 0; i < listCategory.size(); i++) {
            boolean check = false;
            for (String temp : categorysId) {
                if (listCategory.get(i).getCategoryId() == Integer.parseInt(temp)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                listCategoryChecked.add(1);
            } else {
                listCategoryChecked.add(0);
            }
        }

        // danh dau nhung thang size muon tim
        for (int i = 0; i < listSize.size(); i++) {
            boolean check = false;
            for (String temp : sizesId) {
                if (listSize.get(i).getSizeId() == Integer.parseInt(temp)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                listSizeChecked.add(1);
            } else {
                listSizeChecked.add(0);
            }
        }

        // danh dau nhung thang color muon tim
        for (int i = 0; i < listColor.size(); i++) {
            boolean check = false;
            for (String temp : colorsId) {
                if (listColor.get(i).getColorId() == Integer.parseInt(temp)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                listColorChecked.add(1);
            } else {
                listColorChecked.add(0);
            }
        }
        
        System.out.println("page: " + page);

        List<Product> listProduct = pd.getFilterProductPagination(categorysId, sizesId, colorsId, Double.parseDouble(minPrice_raw), Double.parseDouble(maxPrice_raw), orderBy, page);
        
        int totalFilter = pd.getTotalProductByFilter(categorysId, sizesId, colorsId, Double.parseDouble(minPrice_raw), Double.parseDouble(maxPrice_raw));
        

        session.setAttribute("listProduct", listProduct);
        request.setAttribute("listCategoryChecked", listCategoryChecked);
        request.setAttribute("listSizeChecked", listSizeChecked);
        request.setAttribute("listColorChecked", listColorChecked);
        request.setAttribute("orderBy", orderBy);
        request.setAttribute("totalProductByFilterOrQuery", totalFilter);
        request.getRequestDispatcher("views/user/item-page/shopdetail.jsp").forward(request, response);
    }

}
