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

    public int getNumberStartByMonth(int month, int year, int start) {
        String sql = "select count(product_id) as total_start from Comment\n"
                + "where MONTH(comment_date) = ? and YEAR(comment_date) = ? and rating = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            ps.setInt(3, start);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total_start");
            }
        } catch (SQLException e) {
            System.out.println("loi get number start by month: " + e);
        }
        return 0;
    }

    public void deleteCommentByUser(int userId) {
        String sql = "delete from Comment\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete comment by User: " + e);
        }
    }

    public void deleteCommentByProductId(int productId) {
        String sql = "delete from Comment\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete comment by productId: " + e);
        }
    }

    public void deleteCommentByUserAndProduct(int userId, int productId) {
        String sql = "delete from Comment\n"
                + "where user_id = ? and product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi xoa comment by user and product");
        }
    }

    public void updateCommentByUserAndProduct(int userId, int productId, int rating, String content) {
        String sql = "update Comment\n"
                + "set\n"
                + "luot_edit = 0,\n"
                + "rating = ?,\n"
                + "content = ?,\n"
                + "comment_date_update = GETDATE()\n"
                + "where product_id = ? and user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rating);
            ps.setString(2, content);
            ps.setInt(3, productId);
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update comment: " + e);
        }
    }

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
                newComment.setLuotEdit(rs.getInt("luot_edit"));
                newComment.setCommentDateUpdate(rs.getDate("comment_date_update"));
                list.add(newComment);

            }
            return list;
        } catch (SQLException e) {
            System.out.println("loi get comment");
        }
        return list;
    }

    public Comment getCommentByProductIdAndUserId(int userId, int productId) {
        ProductDAO pd = new ProductDAO();
        UserDAO ud = new UserDAO();
        String sql = "select * from Comment\n"
                + "where product_id = ? and user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = pd.getProductById(productId);
                User u = ud.getUserById(userId);
                String content = rs.getString("content");
                Date comment_date = rs.getDate("comment_date");
                int rating = rs.getInt("rating");
                Comment comment = new Comment(p, u, content, comment_date, rating);
                comment.setLuotEdit(rs.getInt("luot_edit"));
                comment.setCommentDateUpdate(rs.getDate("comment_date_update"));
                return comment;
            }
        } catch (SQLException e) {
            System.out.println("loi get comment by product and user");
        }
        return null;
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
                newComment.setLuotEdit(rs.getInt("luot_edit"));
                newComment.setCommentDateUpdate(rs.getDate("comment_date_update"));
                list.add(newComment);
            }
        } catch (SQLException e) {
            System.out.println("loi get comment all: " + e);
        }
        return list;
    }

    public void insertCommentByUserAndProduct(int userId, int productId, String content, int rating) {
        String sql = "insert into Comment(product_id, user_id, content, luot_edit, comment_date, comment_date_update, rating) \n"
                + "values(?, ?, ?, 1, GETDATE(), null, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.setString(3, content);
            ps.setInt(4, rating);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi insert comment: " + e);
        }
    }

    public static void main(String[] args) {
        CommentDAO cd = new CommentDAO();
        System.out.println(cd.getNumberStartByMonth(3, 2024, 4));
    }
}
