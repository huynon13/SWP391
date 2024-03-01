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

    public static void main(String[] args) {
        ColorDAO cd = new ColorDAO();
        for (Color x : cd.getColorAll()) {
            System.out.println(x);
        }
    }
}
