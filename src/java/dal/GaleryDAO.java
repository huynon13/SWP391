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
import java.util.Map;

/**
 *
 * @author PC
 */
public class GaleryDAO extends MyDAO {

    public void deleteGaleryByProductId(int productId) {
        String sql = "delete from Galery\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete galery by productId: " + e);
        }
    }

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
                System.out.println("loi insert anh: " + e);
            }
        }
    }

    public void updateImage(int productId, Map<String, String> listEditAnh) {
        for (Map.Entry<String, String> edit : listEditAnh.entrySet()) {
            String sql = "update Galery\n"
                    + "set\n"
                    + "thumbnail = ?\n"
                    + "where thumbnail = ? and product_id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                String addessNewImage = "images/products/updateproduct/" + edit.getValue();
                ps.setString(1, addessNewImage);
                ps.setString(2, edit.getKey());
                ps.setInt(3, productId);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi update image: " + e);
            }
        }
    }

    public void insertImageByUpdateProduct(int productId, List<String> images) {
        for (String image : images) {
            String sql = "insert into Galery(product_id, thumbnail) values(?, ?)";
            String addessImage = "images/products/updateproduct/" + image;
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, productId);
                ps.setString(2, addessImage);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("loi insert anh by update product: " + e);
            }
        }
    }

}
