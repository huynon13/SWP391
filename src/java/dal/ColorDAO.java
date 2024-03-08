/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Color;

/**
 *
 * @author PC
 */
public class ColorDAO extends MyDAO {

    public List<Color> getColorAll() {
        List<Color> list = new ArrayList<>();

        String sql = "select * from Colors order by color_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Color color = new Color(rs.getInt("color_id"), rs.getString("color"));
                list.add(color);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("err");
            System.err.println("loi get all Color");
        }
        return list;
    }

    public Color getColorById(int id) {
        String sql = "select * from Colors\n"
                + "where color_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Color(rs.getInt("color_id"), rs.getString("color"));
            }
        } catch (SQLException e) {
            System.err.println("loi get cart by id: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        ColorDAO cd = new ColorDAO();
        System.out.println(cd.getColorById(6));
    }

    public Color getColorByName(String name) {
        String sql = "select * from Colors \n"
                + "where color = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Color(rs.getInt("color_id"), rs.getString("color"));
            }
        } catch (SQLException e) {
            System.out.println("loi get color by name: " + e);
        }
        return null;
    }
}
