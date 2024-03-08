/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class GaleryDAO extends MyDAO {

    public List<String> getImagesById(int id) {
        List<String> list = new ArrayList<>();
        String sql = "select g.thumbnail from Product as p\n"
                + "inner join Galery as g on p.product_id = g.product_id\n"
                + "where p.product_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("thumbnail"));
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println("Loi get linh anh sql");
        }

        return list;
    }

    public void insertImage(int productId, List<String> images) {
        for (String image : images) {
            String sql = "insert into Galery(product_id, thumbnail) values(?, ?)";
            String addessImage = "images/products/newproduct/" + image;
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, productId);
                ps.setString(2, addessImage);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi insert anh");
            }
        }
    }
}
