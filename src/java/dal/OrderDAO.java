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
                + "order by o.order_date desc, o.Order_id";
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
//
//    public Map<Order, List<OrderDetail>> getOrderByUser(int userId) {
//        Map<Order, List<OrderDetail>> map = new LinkedHashMap<>();
//        
//        List<Order> list = new ArrayList<>();
//        String sql = "select * from Orders\n"
//                + "where user_id = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, userId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int orderId = rs.getInt("order_id");
//                Order order = getOrderById(orderId);
//                list.add(order);
//            }
//            return list;
//        } catch (SQLException e) {
//            System.err.println("loi get order by user: " + e);
//        }
//        return list;
//    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
//        for(Order x : od.getOrderByUser(7)){
//            System.out.println(x);
//        }

        System.out.println(od.getOrderById(1));
    }
}
