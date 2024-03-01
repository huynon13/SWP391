/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Category;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class CategoryDAO extends MyDAO {
    
    public Category getCategoryById(int id) {
        String sql = "select * from Category\n"
                + "where category_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(id, rs.getString("category_name"), rs.getString("desciption"));
                return category;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("Loi get category by id");
        }
        return null;
    }
    
    public List<Category> getCategoryAll() {
        List<Category> list = new ArrayList<>();
        sql = "select * from Category";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("category_id"), rs.getString("category_name"), rs.getString("desciption")));
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println("Loi get Category All");
        }
        return list;
    }
    
    public Map<Category, List<Product>> getTop5ProductByCategory() {
        Map<Category, List<Product>> map = new LinkedHashMap<>();
        List<Category> listCategory = getCategoryAll();
        for (Category x : listCategory) {
            sql = "select top 3 * from Product\n"
                    + "where category_id = ?\n"
                    + "order by quantity_sold, product_name";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, x.getCategoryId());
                rs = ps.executeQuery();
                List<Product> listProduct = new ArrayList<>();
                while (rs.next()) {
                    Product product = (new Product(rs.getInt("product_id"),
                            getCategoryById(rs.getInt("category_id")),
                            rs.getInt("supperlier_id"),
                            rs.getString("product_name"),
                            rs.getInt("quantity_per_unit"),
                            rs.getInt("quantity_stock"),
                            rs.getInt("quantity_sold"),
                            rs.getFloat("price"),
                            rs.getInt("discount"),
                            rs.getString("desciption"),
                            rs.getDate("created_at"),
                            rs.getDate("updated_at"),
                            rs.getInt("deleted")));
                    listProduct.add(product);
                }
                map.put(x, listProduct);
            } catch (SQLException e) {
                System.err.println("Loi get top 5 product by category All");
            }
        }
        
        return map;
    }
    
    public Map<Category, Integer> getNumberOfProductbyCategory() {
        Map<Category, Integer> map = new LinkedHashMap<>();
        sql = "select c.category_id, c.category_name, c.Desciption , COUNT(p.product_id) as NumberOfProduct from Category as c\n"
                + "inner join Product as p on c.category_id = p.category_id\n"
                + "group by c.category_id, c.category_name, c.Desciption";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"), rs.getString("desciption"));
                int numberOfProduct = rs.getInt("numberOfProduct");
                map.put(category, numberOfProduct);
            }
            ps.close();
            rs.close();
            return map;
        } catch (SQLException e) {
            System.err.println("Loi get number of product by category All");
        }
        return map;
    }
    
    public static void main(String[] args) {
        CategoryDAO cd = new CategoryDAO();
        Map<Category, Integer> map = cd.getNumberOfProductbyCategory();
        System.out.println(cd.getCategoryById(1));
    }
}
