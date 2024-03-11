/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import model.OrderDetail;
import model.User;

/**
 *
 * @author PC
 */
public class OrderDAO extends MyDAO {

    public int getYear() {
        String sql = "select YEAR(GETDATE()) as year";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("year");
            }
        } catch (SQLException e) {
            System.out.println("loi get year: " + e);
        }
        return 0;
    }

    public float getRevennueByMonth(int month, int year) {
        String sql = "select sum(total_money) as revennueByMonth  from Orders\n"
                + "where (MONTH(order_date) = ?) and (YEAR(order_date) = ?) and status = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("revennueByMonth");
            }
        } catch (SQLException e) {
            System.out.println("loi get revennue by month: " + e);
        }
        return 0;
    }

    public int getTotalOrderByStatus(int status) {
        String sql = "select COUNT(Order_id) as total_order from Orders\n"
                + "where status = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total_order");
            }
        } catch (SQLException e) {
            System.out.println("loi get total order by status: " + e);
        }
        return 0;
    }

    public void deleteOrderByUserId(int userId) {
        List<Order> listOrder = getOrderByUser(userId);
        OrderDetailDAO odd = new OrderDetailDAO();
        for (Order o : listOrder) {
            odd.deleteOrderDetailByOrderId(o.getOrderId());
        }

        String sql = "delete from Orders\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete order by user: " + e);
        }
    }

    public void updateOrder(int status, int orderId) {
        String sql = "update Orders \n"
                + "set\n"
                + "status = ?\n"
                + "where Order_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update order: " + e);
        }
    }

    public List<Order> getOrderAll() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Order order = getOrderById(orderId);
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get order all: " + e);
        }

        return list;
    }

    public Order getOrderById(int id) {
        UserDAO ud = new UserDAO();
        PaymentDAO payDao = new PaymentDAO();
        String sql = "select * from Orders\n"
                + "where Order_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("order_id");
                User user = ud.getUserById(rs.getInt("user_id"));
                Date orderDate = rs.getDate("order_date");
                String note = rs.getString("note");
                int status = rs.getInt("status");
                float totalMoney = rs.getFloat("total_money");

                Order order = new Order(orderId, user, orderDate, note, status, totalMoney);
                order.setFullName(rs.getString("full_name"));
                order.setPhoneNumber(rs.getString("phone_number"));
                order.setEmail(rs.getString("email"));
                order.setAddress(rs.getString("address"));
                order.setPayment(payDao.getPaymentById(rs.getInt("payment_id")));
                return order;
            }
        } catch (SQLException e) {
            System.out.println("loi get order by id(OrderDA0): " + e);
        }
        return null;
    }

    public Map<Order, Integer> getTop5OrderByRecent() {
        Map<Order, Integer> map = new LinkedHashMap<>();

        String sql = "select top 5 o.order_id, SUM(od.quantity) as total_product from Orders as o\n"
                + "inner join Order_Details as od on o.Order_id = od.order_id\n"
                + "group by o.order_id, o.order_date\n"
                + "order by o.order_date desc, o.Order_id desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Order order = getOrderById(orderId);
                int totalProduct = rs.getInt("total_product");
                map.put(order, totalProduct);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("loi get top 5 order recent by id(OrderDA0): " + e);
        }
        return map;
    }

    public float getRevennue() {
        String sql = "select SUM(total_money) as revenue from Orders\n"
                + "where status = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat("revenue");
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("loi get revenue: " + e);
        }
        return 0;
    }

    public List<Order> getOrderByUser(int userId) {

        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Order order = getOrderById(orderId);
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get order by user: " + e);
        }
        return list;
    }

    public void insertOrder(int userId, String fullName, String phoneNumber, String email, String address, int paymentId, String note, int status) {
        String sql = "insert into Orders(user_id, order_date, full_name, phone_number, email, address, payment_id, note, status)\n"
                + "values (?, GETDATE(), ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, fullName);
            ps.setString(3, phoneNumber);
            if (email.equals("")) {
                ps.setString(4, null);
            } else {
                ps.setString(4, email);
            }
            ps.setString(5, address);
            ps.setInt(6, paymentId);
            if (note.equals("")) {
                ps.setString(7, null);
            } else {
                ps.setString(7, note);
            }
            ps.setInt(8, status);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi insert order: " + e);
        }
    }

    public int getOrderIdLastInsert() {
        String sql = "select top 1  order_id from Orders\n"
                + "order by Order_id desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("order_id");
            }
        } catch (SQLException e) {
            System.out.println("loi get order by insert last: " + e);
        }
        return -1;
    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
        System.out.println(od.getOrderIdLastInsert());

    }
}
