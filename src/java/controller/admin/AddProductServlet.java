/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.ColorDAO;
import dal.GaleryDAO;
import dal.ProductDAO;
import dal.ProductDetailDAO;
import dal.SizeDAO;
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
import model.Color;
import model.Galary;
import model.Product;
import model.Size;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/addproduct"})
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO pd = new ProductDAO();
        ColorDAO cd = new ColorDAO();
        SizeDAO sd = new SizeDAO();
        GaleryDAO gd = new GaleryDAO();
        ProductDetailDAO pdd = new ProductDetailDAO();

        String[] images_raw = request.getParameterValues("image");
        List<String> images = new ArrayList<>();
        for (String x : images_raw) {
            if (!x.equals("")) {
                images.add(x);
            }
        }

        if (images.size() == 0) {
            String addressPreview = "product-preview.jpg";
            images.add(addressPreview);
        }

        String categoryId_raw = request.getParameter("category");
        String supperlierId_raw = request.getParameter("supperlier");
        String productName = request.getParameter("productName");
        String description = request.getParameter("sortDescription");
        String price_raw = request.getParameter("price");
        String discount_raw = request.getParameter("discount");
        String optionLuaChon_raw = request.getParameter("optionLuaChon");

        int categoryId = Integer.parseInt(categoryId_raw);
        int supperlierId = Integer.parseInt(supperlierId_raw);
        Float price = Float.parseFloat(price_raw);
        int discount = Integer.parseInt(discount_raw);

        String[] optionLuaChon = optionLuaChon_raw.split("\\r?\\n");

        List<Integer> listColor = new ArrayList<>();
        List<Integer> listSize = new ArrayList<>();
        List<Integer> listQuantity = new ArrayList<>();

        for (String option : optionLuaChon) {
            if (option.length() != 0) {
                String[] detailOption = option.split("-");
                String colorName = detailOption[0];
                String sizeName = detailOption[1];
                String quantity_raw = detailOption[2];

                Color color = cd.getColorByName(colorName);
                Size size = sd.getSizeByName(sizeName);
                int quantity = Integer.parseInt(quantity_raw);

                // xu li truong hop ma nguoi dung chon 2 option giong nhau ve size va mau sac, chi khac
                // nhau ve so luong
                int index = -1;
                for (int i = 0; i < listColor.size(); i++) {
                    if (listColor.get(i) == color.getColorId() && listSize.get(i) == size.getSizeId()) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    listColor.add(color.getColorId());
                    listSize.add(size.getSizeId());
                    listQuantity.add(quantity);
                } else {
                    int soLuongCu = listQuantity.get(index);
                    listQuantity.set(index, soLuongCu + quantity);
                }
            }
        }

        // xu li description moi thong tin tren 1 dong
        if (!description.equals("")) {
            String[] line = description.split("\\r?\\n");
            String result = "";
            for (int i = 0; i < line.length; i++) {
                if (i != line.length - 1) {
                    result += line[i];
                    result += "*";
                } else {
                    result += line[i];
                }
            }
            description = result;
        }

        int totalQuantity = 0;
        for (int x : listQuantity) {
            totalQuantity += x;
        }

        pd.insertProduct(categoryId, supperlierId, productName, totalQuantity, totalQuantity, 0, price, discount, description);
        int productIdInsert = pd.getProductIdInsertLast();
        pdd.insertProductDetail(productIdInsert, listColor, listSize, listQuantity);
        gd.insertImage(productIdInsert, images);
        List<Product> getProductAll = pd.getProductAll();
        session.setAttribute("productAll", getProductAll);
        request.setAttribute("addProductSucc", "Added new products successfully");
        request.getRequestDispatcher("views/admin/item-page/addproduct.jsp").forward(request, response);
    }
}
