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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Order;

/**
 *
 * @author PC
 */
public class UserDAO extends MyDAO {

    public void deleteUser(int userId) {
        OrderDAO od = new OrderDAO();
        FeedBackDAO fd = new FeedBackDAO();
        CommentDAO cmd = new CommentDAO();
        WalletDAO wd = new WalletDAO();

        od.deleteOrderByUserId(userId);
        fd.deleteFeedBackByUser(userId);
        cmd.deleteCommentByUser(userId);
        wd.deleteWalletByUser(userId);

        String sql = "delete from Users\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("loi delete user: " + e);
        }
    }

    public void insertUser(int roleId, String userName, String password, String fullName, String birthDay, String image, String phoneNumber, String address, String email, String createAt, int deleted) {
        String sql = "insert into Users(role_id, user_name, pass_word, full_name, birth_day, image, phone_number, address, email, created_at, deleted)\n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), 0)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roleId);

            ps.setString(2, userName);

            ps.setString(3, password);

            if (fullName.equals("")) {
                ps.setString(4, null);
            } else {
                ps.setString(4, fullName);
            }

            if (birthDay.equals("")) {
                ps.setDate(5, null);
            } else {
                java.sql.Date date = java.sql.Date.valueOf(birthDay);
                ps.setDate(5, date);
            }
            if (image.equals("")) {
                ps.setString(6, null);
            } else {
                image = "images/users/" + image;
                ps.setString(6, image);
            }

            if (phoneNumber.equals("")) {
                ps.setString(7, null);
            } else {
                ps.setString(7, phoneNumber);
            }

            if (address.equals("")) {
                ps.setString(8, null);
            } else {
                ps.setString(8, address);
            }

            if (email.equals("")) {
                ps.setString(9, null);
            } else {
                ps.setString(9, email);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi insert user: " + e);
        }
    }

    public void updateUser(String password, String fullName, String birthDay, String image, String phoneNumber, String address, String email, int userId) {
        String sql = "update Users\n"
                + "set\n"
                + "pass_word = ?,\n"
                + "full_name = ?,\n"
                + "birth_day = ?,\n"
                + "image = ?,\n"
                + "phone_number = ?,\n"
                + "address = ?,\n"
                + "email = ?,\n"
                + "updated_at = GETDATE()\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);

            if (fullName.equals("")) {
                ps.setString(2, null);
            } else {
                ps.setString(2, fullName);
            }

            if (birthDay.equals("")) {
                ps.setDate(3, null);
            } else {
                java.sql.Date date = java.sql.Date.valueOf(birthDay);
                ps.setDate(3, date);
            }

            if (image.equals("")) {
                ps.setString(4, null);
            } else {
                ps.setString(4, image);
            }

            if (phoneNumber.equals("")) {
                ps.setString(5, null);
            } else {
                ps.setString(5, phoneNumber);
            }

            if (address.equals("")) {
                ps.setString(6, null);
            } else {
                ps.setString(6, address);
            }

            if (email.equals("")) {
                ps.setString(7, null);
            } else {
                ps.setString(7, email);
            }

            ps.setInt(8, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update user: " + e);
        }
    }

    public List<User> getUserAll() {
        List<User> list = new ArrayList<>();
        String sql = "select * from Users as u\n"
                + "inner join Roles as r on u.role_id = r.role_id\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                User user = getUserById(userId);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get all user: " + e);
        }

        return list;
    }

    public Map<User, Integer> getUserAllAndTotalBuy() {
        Map<User, Integer> map = new LinkedHashMap<>();
        String sql = "select u.user_id, COUNT(od.product_id) as total_buy from Users as u\n"
                + "left join Orders as o on u.user_id = o.user_id\n"
                + "left join Order_Details as od on o.Order_id = od.order_id\n"
                + "group by u.user_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                int totalBuy = rs.getInt("total_buy");
                User user = getUserById(userId);
                map.put(user, totalBuy);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("loi get user all and total buy: " + e);
        }

        return map;
    }

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
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setBirthDay(rs.getDate("birth_day"));
                user.setAddress(rs.getString("address"));
                user.setUpdatedAt(rs.getDate("updated_at"));
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

    public int getUserIdByUserName(String username) {
        String sql = "select * from Users\n"
                + "where user_name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            System.out.println("loi get user by username: " + e);
        }
        return -1;
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

    public boolean registerUser(String username, String password, String roleName, String email, String phone, String name) {
        RoleDAO rd = new RoleDAO();
        boolean checkUser = getUserByUserName(username);
        if (!checkUser) {
            String sql = "INSERT INTO [dbo].[Users]\n"
                    + "           ([role_id]\n"
                    + "           ,[user_name]\n"
                    + "           ,[pass_word]\n"
                    + "           ,[full_name]\n"
                    + "           ,[phone_number]\n"
                    + "           ,[email]\n"
                    + "           ,[created_at]\n"
                    + "           ,[deleted])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,GETDATE(),0)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                int roleId = rd.getRoleIdByRoleName(roleName);
                ps.setInt(1, roleId);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, phone);
                ps.setString(5, name);
                ps.setString(6, email);
                int checkInsert = ps.executeUpdate();
                if (checkInsert != 0) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public Map<User, Float> getTopUserByTotalMoney() {
        Map<User, Float> map = new LinkedHashMap<>();
        List<User> list = new ArrayList<>();
        OrderDAO od = new OrderDAO();
        String sql = "select top 6 o.user_id, SUM(o.total_money) as total_money from Orders as o\n"
                + "group by o.user_id\n"
                + "order by SUM(o.total_money) desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                User user = getUserById(userId);
                float total_money = rs.getFloat("total_money");
                map.put(user, total_money);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("loi get top user by total money: " + e);
        }
        return map;
    }
     public User getUserByEmail(String email) {
        String query = "  select * from Users where Users.email = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                RoleDAO rd = new RoleDAO();
                User user = new User(rs.getInt("user_id"),
                        rd.getRoleById(rs.getInt("role_id")),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getDate("created_at"),
                        rs.getInt("deleted"));
                user.setImage(rs.getString("image"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setBirthDay(rs.getDate("birth_day"));
                user.setAddress(rs.getString("address"));
                user.setUpdatedAt(rs.getDate("updated_at"));
                return user;
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }
         public void UpdatePassAccount(User acc, String newPass) {
        int userID = acc.getUserId();

        String query = "UPDATE [dbo].[Users]\n"
                + "SET [pass_word] = ?\n"
                + "where Users.user_id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, userID);
            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
//        for(Map.Entry<User, Integer> x : ud.getUserAllAndTotalBuy().entrySet()){
//            System.out.println(x.getKey());
//            System.out.println(x.getValue());
//            System.out.println("----------");
//        }

        System.out.println(ud.getUserById(12));
    }
}
