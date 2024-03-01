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
import model.FeedBack;

/**
 *
 * @author PC
 */
public class FeedBackDAO extends MyDAO {

    public List<FeedBack> getFeedBackAll() {
        List<FeedBack> list = new ArrayList<>();
        String sql = "select * from FeedBack";
        try {
            UserDAO ud = new UserDAO();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedBack(rs.getInt("feedback_id"),
                        ud.getUserById(rs.getInt("user_id")),
                        rs.getString("subject_name"),
                        rs.getString("note")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Loi get Feedback");
        }
        return list;
    }
    
    public static void main(String[] args) {
        FeedBackDAO fd = new FeedBackDAO();
        for(FeedBack x : fd.getFeedBackAll()){
            System.out.println(x);
        }
    }
}
