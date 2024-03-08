/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ProductDetailDAO extends MyDAO {

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
}
