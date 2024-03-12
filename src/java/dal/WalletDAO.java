/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Wallet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author PC
 */
public class WalletDAO extends MyDAO {

    public void deleteWalletByUser(int userId) {
        String sql = "delete from Wallets\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete wallet by user: " + e);
        }
    }

    public List<Wallet> getWalletAll() {
        UserDAO ud = new UserDAO();
        List<Wallet> list = new ArrayList();
        String sql = "select * from Wallets";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int walletId = rs.getInt("wallet_id");
                User user = ud.getUserById(rs.getInt("user_id"));
                float balance = rs.getFloat("balance");
                Wallet w = new Wallet(walletId, user, balance);
                list.add(w);
            }
        } catch (SQLException e) {
            System.out.println("loi get wallet all: " + e);
        }
        return list;
    }

    public void updateWallet(int walletId, float balance) {
        String sql = "update Wallets\n"
                + "set\n"
                + "balance += ?\n"
                + "where wallet_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, balance);
            ps.setInt(2, walletId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update wallet");
        }
    }

    public void insertWallet(int userId) {
        String sql = "insert into Wallets(user_id, balance) values (?, 0)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi insert wallet");
        }
    }

    public Wallet getWalletByUserId(int userId) {
        UserDAO ud = new UserDAO();
        String sql = "select * from Wallets\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int walletId = rs.getInt("wallet_id");
                User user = ud.getUserById(userId);
                float balance = rs.getFloat("balance");
                return new Wallet(walletId, user, balance);
            }
        } catch (SQLException e) {
            System.out.println("loi get wallet by user: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        WalletDAO wd = new WalletDAO();
        System.out.println(wd.getWalletByUserId(12));
    }

}
