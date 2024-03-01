/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class GaleryDAO extends MyDAO{
    
        public List<String> getImagesById(int id) {
        List<String> list = new ArrayList<>();
        String sql = "select g.thumbnail from Product as p\n"
                + "inner join Galery as g on p.product_id = g.product_id\n"
                + "where p.product_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
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
}
