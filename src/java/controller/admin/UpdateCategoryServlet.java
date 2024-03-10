/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CategoryDAO;
import dal.ProductDAO;
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
import model.Product;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateCategoryServlet", urlPatterns = {"/updatecategory"})
public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cd = new CategoryDAO();
        HttpSession session = request.getSession();

        request.setAttribute("afterEditCategory", "sfds");

        String categoryId_raw = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryId_raw);
        String nameUpdate = request.getParameter("updateNameCategory");
        String descriptionUpdate = request.getParameter("updateSortDescription");

        Category checkTonTai = cd.checkCategoryNameUpdate(nameUpdate, categoryId);

        if (nameUpdate.equals("")) {
            request.setAttribute("errorUpdateCategory", "Category name cannot be left blank, please re-enter");
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        } else if (checkTonTai != null) {
            request.setAttribute("errorUpdateCategory", "Category name already exists, please enter another name");
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        } else {
            cd.updateCategory(categoryId, nameUpdate, descriptionUpdate);
            Map<Category, List<Integer>> getNumbeOfProductAndNumberOfProductSoldByCategory = cd.getNumberOfProductAndNumberOfProductSoldByCategory();

            List<Category> getCategoryAll = cd.getCategoryAll();
            session.setAttribute("categoryAll", getCategoryAll);
            
            request.setAttribute("updateCategorySucess", "Category updated successfully");
            session.setAttribute("mainCategory", getNumbeOfProductAndNumberOfProductSoldByCategory);

            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cd = new CategoryDAO();
        HttpSession session = request.getSession();
        ProductDAO pd = new ProductDAO();

        String action = request.getParameter("action");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        if (action.equalsIgnoreCase("edit")) {
            Category editCategory = cd.getCategoryById(categoryId);
            request.setAttribute("beforeEditCategory", editCategory);
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);
        } else {
            Category category = cd.getCategoryById(categoryId);
            request.setAttribute("deleteCategorySucc", "Category name: \"" + category.getCategoryName() + "\" deleted successfully");
            cd.deleteCategory(categoryId);
            Map<Category, List<Integer>> getNumbeOfProductAndNumberOfProductSoldByCategory = cd.getNumberOfProductAndNumberOfProductSoldByCategory();
            
            List<Product> getProductAll = pd.getProductAll();
            session.setAttribute("productAll", getProductAll);
            
            session.setAttribute("mainCategory", getNumbeOfProductAndNumberOfProductSoldByCategory);
            request.getRequestDispatcher("views/admin/item-page/maincategory.jsp").forward(request, response);

        }
    }

}
