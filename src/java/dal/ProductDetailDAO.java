/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Color;
import model.Product;
import model.ProductDetail;
import model.Size;

/**
 *
 * @author PC
 */
public class ProductDetailDAO extends MyDAO {

    public void deleteProductDetailByProductId(int productId) {
        String sql = "delete from Product_detail\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);;
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete product detail by id: " + e);
        }
    }

    public void insertProductDetail(int productId, List<Integer> color, List<Integer> size, List<Integer> quantity) {
        for (int i = 0; i < color.size(); i++) {
            String sql = "insert into Product_detail(product_id, color_id, size_id, quantity) values (?, ?, ?, ?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, productId);
                ps.setInt(2, color.get(i));
                ps.setInt(3, size.get(i));
                ps.setInt(4, quantity.get(i));
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi insert  product detail: " + e);
            }
        }
    }

    public void updateProductDetail(int productId, List<Integer> color, List<Integer> size, List<Integer> quantity) {
        for (int i = 0; i < color.size(); i++) {
            String sql = "update Product_detail\n"
                    + "set\n"
                    + "quantity = ?\n"
                    + "where product_id = ? and color_id = ? and size_id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, quantity.get(i));
                ps.setInt(2, productId);
                ps.setInt(3, color.get(i));
                ps.setInt(4, size.get(i));
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi update product detail: " + e);
            }
        }
    }

    public void deleteProductDetail(int productId, List<Integer> color, List<Integer> size) {
        for (int i = 0; i < color.size(); i++) {
            String sql = "delete from Product_detail\n"
                    + "where product_id = ? and color_id = ? and size_id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, productId);
                ps.setInt(2, color.get(i));
                ps.setInt(3, size.get(i));
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi delete product detail: " + e);
            }
        }

    }

    public List<ProductDetail> getProductDetailById(int productId) {
        List<ProductDetail> list = new ArrayList<>();
        ProductDAO pd = new ProductDAO();
        ColorDAO cd = new ColorDAO();
        SizeDAO sd = new SizeDAO();

        String sql = "select * from Product_detail\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int colorId = rs.getInt("color_id");
                int sizeId = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");

                Product product = pd.getProductById(productId);
                Color color = cd.getColorById(colorId);
                Size size = sd.getSizeById(sizeId);
                ProductDetail productDetail = new ProductDetail(productId, color, size, quantity);
                list.add(productDetail);
            }

        } catch (SQLException e) {
            System.out.println("loi get product detail by id: " + e);

        }
        return list;
    }

    public static void main(String[] args) {
        ProductDetailDAO pdd = new ProductDetailDAO();
        for (ProductDetail p : pdd.getProductDetailById(18)) {
            System.out.println(p);
        }
    }
}
