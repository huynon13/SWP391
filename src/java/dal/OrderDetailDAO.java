/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Order;
import model.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Color;
import model.Product;
import model.Size;

/**
 *
 * @author PC
 */
public class OrderDetailDAO extends MyDAO {

    public Map<Order, List<OrderDetail>> getAllOrderAndOrderDetail() {
        Map<Order, List<OrderDetail>> map = new LinkedHashMap<>();
        OrderDAO od = new OrderDAO();
        ProductDAO pd = new ProductDAO();
        ColorDAO cd = new ColorDAO();
        SizeDAO sd = new SizeDAO();

        List<Order> listOrder = od.getOrderAll();
        for (int i = 0; i < listOrder.size(); i++) {
            String sql = "select * from Order_Details\n"
                    + "where order_id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, listOrder.get(i).getOrderId());
                ResultSet rs = ps.executeQuery();
                List<OrderDetail> listOrderDetail = new ArrayList<>();
                while (rs.next()) {
                    Order order = od.getOrderById(rs.getInt("order_id"));
                    Product product = pd.getProductById(rs.getInt("product_id"));
                    Color color = cd.getColorById(rs.getInt("color_id"));
                    Size size = sd.getSizeById(rs.getInt("size_id"));
                    float price = rs.getFloat("price");
                    int discount = rs.getInt("discount");
                    int quantity = rs.getInt("quantity");
                    OrderDetail orderDetail = new OrderDetail(order, product, color, size, price, discount, quantity);
                    listOrderDetail.add(orderDetail);
                }
                map.put(listOrder.get(i), listOrderDetail);
            } catch (SQLException e) {
                System.out.println("loi get order and order detail by user: " + e);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        OrderDetailDAO odd = new OrderDetailDAO();
        for (Map.Entry<Order, List<OrderDetail>> x : odd.getAllOrderAndOrderDetail().entrySet()) {
            System.out.println(x.getKey());
            System.out.println("---------");
            for (OrderDetail y : x.getValue()) {
                System.out.println(y);
            }
            System.out.println("-----------");
            System.out.println("");
        }

//        System.out.println(odd.getAllOrderAndOrderDetail().size());
    }
}
