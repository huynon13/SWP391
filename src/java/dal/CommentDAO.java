/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Comment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Product;
import model.User;

/**
 *
 * @author PC
 */
public class CommentDAO extends MyDAO {

    public List<Comment> getCommentByProductId(int pid) {
        ProductDAO pd = new ProductDAO();
        UserDAO ud = new UserDAO();
        List<Comment> list = new ArrayList<>();
        String sql = "select * from Comment\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = pd.getProductById(pid);
                User u = ud.getUserById(rs.getInt("user_id"));
                String content = rs.getString("content");
                Date comment_date = rs.getDate("comment_date");
                int rating = rs.getInt("rating");
                Comment newComment = new Comment(p, u, content, comment_date, rating);
                list.add(newComment);

            }
            return list;
        } catch (SQLException e) {
            System.out.println("loi get comment");
        }
        return list;
    }

    public List<Comment> getCommentAll() {
        ProductDAO pd = new ProductDAO();
        UserDAO ud = new UserDAO();
        List<Comment> list = new ArrayList<>();

        String sql = "select * from Comment";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = pd.getProductById(rs.getInt("product_id"));
                User u = ud.getUserById(rs.getInt("user_id"));
                String content = rs.getString("content");
                Date comment_date = rs.getDate("comment_date");
                int rating = rs.getInt("rating");
                Comment newComment = new Comment(p, u, content, comment_date, rating);
                list.add(newComment);
            }
        } catch (SQLException e) {
            System.out.println("loi get comment all: " + e);
        }
        return list;
    }

    public static void main(String[] args) {
        CommentDAO cd = new CommentDAO();
        for (Comment x : cd.getCommentAll()) {
            System.out.println(x);
        }
    }
}
