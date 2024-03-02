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
import java.util.Date;

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

    public boolean getUserByUserName(String username) {
        String sql = "select * from Users\n"
                + "where user_name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("loi get user by username: " + e);
        }
        return false;
    }

    public User login(String username, String password) {
        RoleDAO rd = new RoleDAO();
        String sql = "select * from Users\n"
                + "where user_name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("pass_word").equals(password)) {
                    int id = rs.getInt("user_id");
                    Role role = rd.getRoleById(rs.getInt("role_id"));
                    String image = rs.getString("image");
                    Date createdAt = rs.getDate("created_at");
                    int deleted = rs.getInt("deleted");
                    User user = new User(id, role, username, password, createdAt, deleted);
                    user.setImage(image);
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("loi login, ham login trong userDAO: " + e);
        }
        return null;
    }

    public boolean registerUser(String username, String password, String roleName) {
        RoleDAO rd = new RoleDAO();
        boolean checkUser = getUserByUserName(username);
        if (!checkUser) {
            String sql = "insert into Users(role_id, user_name, pass_word, created_at, deleted) values (?, ?, ?, GETDATE(), 0)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                int roleId = rd.getRoleIdByRoleName(roleName);
                ps.setInt(1, roleId);
                ps.setString(2, username);
                ps.setString(3, password);
                int checkInsert = ps.executeUpdate();
                if (checkInsert != 0) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        System.out.println(ud.login("Nghiemxuanloc", "123457"));
    }
}
