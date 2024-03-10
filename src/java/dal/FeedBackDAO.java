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

    public void deleteFeedBackByUser(int userId) {
        String sql = "delete from FeedBack\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete feedback by user: " + e);
        }
    }

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

    public void deleteFeedbackById(int feedbackId) {
        String sql = "delete from FeedBack\n"
                + "where feedback_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, feedbackId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete feedback by id: " + e);
        }
    }

    public FeedBack getFeedBackByUserId(int userId) {
        UserDAO ud = new UserDAO();
        String sql = "select * from FeedBack\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                FeedBack fb = new FeedBack(rs.getInt("feedback_id"),
                        ud.getUserById(rs.getInt("user_id")),
                        rs.getString("subject_name"),
                        rs.getString("note"));
                fb.setFeedbackDate(rs.getDate("feedback_date"));
                return fb;
            }
        } catch (SQLException e) {
            System.out.println("loi get feedback by user: " + e);
        }
        return null;
    }

    public void updateFeedbackById(String subject, String note, int feedbackId) {
        String sql = "update FeedBack\n"
                + "set\n"
                + "subject_name = ?,\n"
                + "note = ?\n"
                + "where feedback_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subject);
            ps.setString(2, note);
            ps.setInt(3, feedbackId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update feedback by id: " + e);
        }
    }

    public static void main(String[] args) {
        FeedBackDAO fd = new FeedBackDAO();
        System.out.println(fd.getFeedBackByUserId(12));
    }
}
