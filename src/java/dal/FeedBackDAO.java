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
        String sql = "select * from FeedBack\n"
                + "order by feedback_date desc";
        try {
            UserDAO ud = new UserDAO();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedBack fb = new FeedBack(rs.getInt("feedback_id"),
                        ud.getUserById(rs.getInt("user_id")),
                        rs.getString("subject_name"),
                        rs.getString("note"));
                fb.setFeedbackDate(rs.getDate("feedback_date"));
                list.add(fb);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Loi get Feedback");
        }
        return list;
    }

    public void insertFeedBack(int userId, String subject, String note) {
        String sql = "insert into FeedBack(user_id, subject_name, feedback_date, note) values(?, ?, GETDATE(), ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, subject);
            ps.setString(3, note);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi insert feecback");
        }
    }

    public static void main(String[] args) {
        FeedBackDAO fd = new FeedBackDAO();
        for (FeedBack x : fd.getFeedBackAll()) {
            System.out.println(x);
        }
    }
}
