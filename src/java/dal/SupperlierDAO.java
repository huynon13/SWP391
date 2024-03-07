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
import model.Supperlier;

/**
 *
 * @author PC
 */
public class SupperlierDAO extends MyDAO {

    public List<Supperlier> getSupperlierAll() {
        List<Supperlier> list = new ArrayList<>();
        String sql = "select * from Supperlier";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int supId = rs.getInt("supperlier_id");
                list.add(getSupperlierById(supId));
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get supperlier all: " + e);
        }
        return list;
    }

    public Supperlier getSupperlierById(int id) {
        String sql = "select * from Supperlier\n"
                + "where supperlier_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int supId = rs.getInt("supperlier_id");
                String name = rs.getString("company_name");
                String phone = rs.getString("phone_number");
                String county = rs.getString("county");
                return new Supperlier(supId, name, phone, county);
            }
        } catch (SQLException e) {
            System.err.println("loi get supperlier by id: " + e);
        }
        return null;
    }
    public static void main(String[] args) {
        SupperlierDAO sd = new SupperlierDAO();
        for(Supperlier x : sd.getSupperlierAll()){
            System.out.println(x);
        }
    }
}
