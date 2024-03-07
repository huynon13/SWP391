/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import model.Category;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddCategoryServlet", urlPatterns = {"/addcategory"})
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO cd = new CategoryDAO();

        HttpSession session = request.getSession();

        String nameCategory = request.getParameter("nameCategory");
        String sortDescription = request.getParameter("sortDescription");

        Category checkTonTai = cd.checkCategoryNameInsert(nameCategory);
        if (nameCategory.equals("")) {
            request.setAttribute("errorAddCategory", "Category name cannot be left blank, please re-enter");
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        } else if (checkTonTai != null) {
            request.setAttribute("errorAddCategory", "Category name already exists, please enter another name");
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        } else {
            cd.insertCategory(nameCategory, sortDescription);
            Map<Category, List<Integer>> getNumbeOfProductAndNumberOfProductSoldByCategory = cd.getNumberOfProductAndNumberOfProductSoldByCategory();
            List<Category> getCategoryAll = cd.getCategoryAll();
            session.setAttribute("categoryAll", getCategoryAll);
            request.setAttribute("addCategorySucess", "Category name added successfully");
            session.setAttribute("mainCategory", getNumbeOfProductAndNumberOfProductSoldByCategory);

            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        }
    }
}
