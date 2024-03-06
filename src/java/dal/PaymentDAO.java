/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class PaymentDAO extends MyDAO{

    public Payment getPaymentById(int id) {
        String sql = "select * from Payment\n"
                + "where payment_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String paymentName = rs.getString("payment_name");
                return new Payment(id, paymentName);
            }
        } catch (SQLException e) {
            System.out.println("loi get payment by id: " + e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        PaymentDAO paymet = new PaymentDAO();
        System.out.println(paymet.getPaymentById(1));
    }
}
