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
            while(rs.next()){
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
    public static void main(String[] args) {
        SizeDAO sd = new SizeDAO();
        for(Size x : sd.getSizeAll()){
            System.out.println(x);
        }
    }
}
