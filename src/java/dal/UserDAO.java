/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import model.Role;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class UserDAO extends MyDAO {
    
    public User getUserById(int id) {
        String sql = "select * from Users\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                RoleDAO rd = new RoleDAO();
                User user = new User(id,
                        rd.getRoleById(rs.getInt("role_id")),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getDate("created_at"),
                        rs.getInt("deleted"));
                user.setImage(rs.getString("image"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Loi get User ");
        }
        return null;
    }
    
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        System.out.println(ud.getUserById(1).getImage());
    }
}
