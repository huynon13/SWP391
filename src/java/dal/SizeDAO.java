/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Size;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class SizeDAO extends MyDAO {

    public List<Size> getSizeAll() {
        List<Size> list = new ArrayList<>();
        String sql = "select * from Size order by size_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size size = new Size(rs.getInt("size_id"), rs.getString("size_option"));
                list.add(size);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("err");
            System.err.println("loi get all size");
        }
        return list;
    }

    public Size getSizeById(int id) {
        String sql = "select * from Size\n"
                + "where size_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Size(rs.getInt("size_id"), rs.getString("size_option"));
            }
        } catch (SQLException e) {
            System.err.println("loi get cart by id: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        SizeDAO sd = new SizeDAO();
        System.out.println(sd.getSizeById(1));
    }

    public Size getSizeByName(String name) {
        String sql = "select * from Size\n"
                + "where size_option = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Size(rs.getInt("size_id"), rs.getString("size_option"));
            }
        } catch (SQLException e) {
            System.out.println("loi get size by name: " + e);
        }
        return null;
    }
}
