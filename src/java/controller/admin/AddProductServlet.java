/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.ColorDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Color;
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
        ProductDAO pd = new ProductDAO();
        ColorDAO cd = new ColorDAO();
        SizeDAO sd = new SizeDAO();

        String[] image = request.getParameterValues("image");

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

        optionLuaChon_raw = optionLuaChon_raw.substring(0, optionLuaChon_raw.length() - 1);
        String[] optionLuaChon = optionLuaChon_raw.split("&");

        List<Integer> listColor = new ArrayList<>();
        List<Integer> listSize = new ArrayList<>();
        List<Integer> listQuantity = new ArrayList<>();

        for (String option : optionLuaChon) {
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

        int totalQuantity = 0;
        for (int x : listQuantity) {
            totalQuantity += x;
        }
        System.out.println("image:");
        for (String x : image) {
            if (!x.equals("")) {
                System.out.println(x);
            }
        }

        System.out.println("categoryId: " + categoryId);
        System.out.println("supperlierId: " + supperlierId);
        System.out.println("product name: " + productName);
        System.out.println("description: " + description);
        System.out.println("price: " + price);
        System.out.println("discount: " + discount);
        
        System.out.println("color");
        for (int i = 0; i < listColor.size(); i++) {
            System.out.print(listColor.get(i) + " ");
        }
        System.out.println("size");
        for (int i = 0; i < listColor.size(); i++) {
            System.out.print(listSize.get(i) + " ");
        }

        System.out.println("quantity");
        for (int i = 0; i < listColor.size(); i++) {
            System.out.print(listQuantity.get(i) + " ");
        }
        System.out.println("total quantity: " + totalQuantity);
    }
}
