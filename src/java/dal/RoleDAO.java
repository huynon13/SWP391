/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class RoleDAO extends MyDAO {

    public Role getRoleById(int id) {
        String sql = "select * from Roles\n"
                + "where role_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Role(rs.getInt("role_id"), rs.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Loi get role ");
        }
        return null;
    }

    public Role getRoleByName(String name) {
        String sql = "select * from Roles\n"
                + "where name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int rid =  rs.getInt("role_id");
                String rname = rs.getString("name");
                return new Role(rid, name);
            }
        } catch (SQLException e) {
            System.out.println("loi get role by name: " + e);
        }
        return null;
    }

    public int getRoleIdByRoleName(String name) {
        String sql = "select * from Roles\n"
                + "where name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("role_id");
            }
        } catch (SQLException e) {
            System.out.println("loi get role id by name: " + e);
        }
        return -1;
    }

    public static void main(String[] args) {
        RoleDAO rd = new RoleDAO();
        System.out.println(rd.getRoleById(1));
    }

}
