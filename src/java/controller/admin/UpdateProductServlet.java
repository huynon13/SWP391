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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Color;
import model.Product;
import model.Size;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updateproduct"})
public class UpdateProductServlet extends HttpServlet {

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

        // xu ly xem minh da edit anh nao
        String[] sttEdit = request.getParameterValues("sttEditAnh");
        List<Integer> listSttEditAnh = new ArrayList<>();
        for (String x : sttEdit) {
            if (!x.equals("")) {
                listSttEditAnh.add(Integer.parseInt(x));
            }
        }

        // lay ve tat ca cac anh moi ma minh da chon de thay the anh cu
        String[] images_raw = request.getParameterValues("image");
        List<String> images = new ArrayList<>();
        for (String x : images_raw) {
            if (!x.equals("")) {
                images.add(x);
            }
        }

        int productId = Integer.parseInt(request.getParameter("productId"));

        List<String> listAnhCu = gd.getImagesById(productId);

        // map nay de luu cap gia tri anh cu va anh muon thay doi
        Map<String, String> listEditAnh = new LinkedHashMap<>();

        // list nay de lua anh duoc them moi
        List<String> listAnhThemMoi = new ArrayList<>();

        for (int i = 0; i < listSttEditAnh.size(); i++) {
            int sttThayAnh = listSttEditAnh.get(i);
            String imageMuonThay = images.get(i);
            if (sttThayAnh < listAnhCu.size()) {
                listEditAnh.put(listAnhCu.get(sttThayAnh), imageMuonThay);
            } else {
                listAnhThemMoi.add(imageMuonThay);
            }
        }
        
        
        for(String x : listAnhThemMoi){
            System.out.println(x);
        }
        if (listEditAnh.size() != 0) {
            gd.updateImage(productId, listEditAnh);
        }
        if (listAnhThemMoi.size() != 0) {
            gd.insertImageByUpdateProduct(productId, listAnhThemMoi);
        }
        List<Product> getProductAll = pd.getProductAll();
        session.setAttribute("productAll", getProductAll);
        request.setAttribute("updateProductSucc", "Update Product successfully !");
        request.getRequestDispatcher("views/admin/item-page/editproduct.jsp").forward(request, response);

//        String categoryId_raw = request.getParameter("category");
//        String supperlierId_raw = request.getParameter("supperlier");
//        String productName = request.getParameter("productName");
//        String description = request.getParameter("sortDescription");
//        String price_raw = request.getParameter("price");
//        String discount_raw = request.getParameter("discount");
//        String optionLuaChon_raw = request.getParameter("optionLuaChon");
//        
//        int categoryId = Integer.parseInt(categoryId_raw);
//        int supperlierId = Integer.parseInt(supperlierId_raw);
//        Float price = Float.parseFloat(price_raw);
//        int discount = Integer.parseInt(discount_raw);
//        
//        optionLuaChon_raw = optionLuaChon_raw.substring(0, optionLuaChon_raw.length() - 1);
//        String[] optionLuaChon = optionLuaChon_raw.split("\\r?\\n");
//        
//        List<Integer> listColor = new ArrayList<>();
//        List<Integer> listSize = new ArrayList<>();
//        List<Integer> listQuantity = new ArrayList<>();
//        
//        for (String option : optionLuaChon) {
//            String[] detailOption = option.split("-");
//            String colorName = detailOption[0];
//            String sizeName = detailOption[1];
//            String quantity_raw = detailOption[2];
//            
//            Color color = cd.getColorByName(colorName);
//            Size size = sd.getSizeByName(sizeName);
//            int quantity = Integer.parseInt(quantity_raw);
//
//            // xu li truong hop ma nguoi dung chon 2 option giong nhau ve size va mau sac, chi khac
//            // nhau ve so luong
//            int index = -1;
//            for (int i = 0; i < listColor.size(); i++) {
//                if (listColor.get(i) == color.getColorId() && listSize.get(i) == size.getSizeId()) {
//                    index = i;
//                    break;
//                }
//            }
//            if (index == -1) {
//                listColor.add(color.getColorId());
//                listSize.add(size.getSizeId());
//                listQuantity.add(quantity);
//            } else {
//                int soLuongCu = listQuantity.get(index);
//                listQuantity.set(index, soLuongCu + quantity);
//            }
//        }
//
//        // xu li description moi thong tin tren 1 dong
//        if (!description.equals("")) {
//            String[] line = description.split("\\r?\\n");
//            String result = "";
//            for (int i = 0; i < line.length; i++) {
//                if (i != line.length - 1) {
//                    result += line[i];
//                    result += "*";
//                } else {
//                    result += line[i];
//                }
//            }
//            description = result;
//        }
//        
//        int totalQuantity = 0;
//        for (int x : listQuantity) {
//            totalQuantity += x;
//        }
    }

}
