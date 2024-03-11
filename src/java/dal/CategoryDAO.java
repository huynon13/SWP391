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

    public Map<List<Category>, List<Integer>> getHangTonKhoMoiCategory() {
        CategoryDAO cd = new CategoryDAO();

        Map<List<Category>, List<Integer>> map = new LinkedHashMap<>();
        List<Integer> listSoHangTonKho = new ArrayList<>();
        List<Category> listCategory = new ArrayList<>();
        
        String sql = "select c.category_id, c.category_name, count(pd.product_id) as total_ton_kho from Category as c\n"
                + "inner join Product as p on c.category_id = p.category_id\n"
                + "inner join Product_detail as pd on p.product_id = pd.product_id\n"
                + "group by c.category_id, c.category_name order by c.category_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = cd.getCategoryById(rs.getInt("category_id"));
                int soHangTonKho = rs.getInt("total_ton_kho");
                listCategory.add(category);
                listSoHangTonKho.add(soHangTonKho);
            }
        } catch (SQLException e) {
            System.out.println("loi get so luong hang ton kho: " + e);
        }
        map.put(listCategory, listSoHangTonKho);
        return map;
    }

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
        SupperlierDAO sd = new SupperlierDAO();
        for (Category x : listCategory) {
            sql = "select top 3 * from Product\n"
                    + "where category_id = ?\n"
                    + "order by quantity_sold desc, product_name";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, x.getCategoryId());
                rs = ps.executeQuery();
                List<Product> listProduct = new ArrayList<>();
                while (rs.next()) {
                    Product product = (new Product(rs.getInt("product_id"),
                            getCategoryById(rs.getInt("category_id")),
                            sd.getSupperlierById(rs.getInt("supperlier_id")),
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

    public Map<Category, List<Integer>> getNumberOfProductAndNumberOfProductSoldByCategory() {
        Map<Category, List<Integer>> map = new LinkedHashMap<>();
        String sql = "with tbl1 as\n"
                + "(\n"
                + "select c.category_id, c.category_name, COUNT(distinct p.product_id) as total_product from Category as c\n"
                + "left join Product as p on c.category_id = p.category_id\n"
                + "group by c.category_id, c.category_name\n"
                + "), tbl2 as\n"
                + "(\n"
                + "select c.category_id, c.category_name, COUNT(p.product_id) as total_product_sold from Orders as o\n"
                + "inner join Order_Details as od on o.Order_id = od.order_id\n"
                + "inner join Product as p on od.product_id = p.product_id\n"
                + "inner join Category as c on p.category_id = c.category_id\n"
                + "where o.status = 1\n"
                + "group by c.category_id, c.category_name\n"
                + ")\n"
                + "\n"
                + "select t1.category_id, t1.total_product,\n"
                + "case when t2.total_product_sold is null then 0\n"
                + "else t2.total_product_sold\n"
                + "end\n"
                + "as total_product_sold\n"
                + "from tbl1 as t1\n"
                + "left join tbl2 as t2 on t1.category_id = t2.category_id";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt("category_id");
                Category cate = getCategoryById(categoryId);
                int numberOfProduct = rs.getInt("total_product");
                int numberOfProductSold = rs.getInt("total_product_sold");
                List<Integer> list = new ArrayList<>();
                list.add(numberOfProduct);
                list.add(numberOfProductSold);
                map.put(cate, list);
            }
        } catch (SQLException e) {
            System.out.println("loi get total product and product sold by category");
        }
        return map;
    }

    public Category checkCategoryNameInsert(String name) {
        String sql = "select * from Category\n"
                + "where category_name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"), rs.getString("desciption"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("loi check category name: " + e);
        }
        return null;
    }

    public Category checkCategoryNameUpdate(String name, int id) {
        String sql = "select * from Category\n"
                + "where category_name = ? and category_id != ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("category_name"), rs.getString("desciption"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("loi check category name: " + e);
        }
        return null;
    }

    public List<Product> getProductByCategory(int categoryId) {
        ProductDAO pd = new ProductDAO();
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                + "where category_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = pd.getProductById(rs.getInt("product_id"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("loi get product by categoryId: " + e);
        }
        return list;
    }

    public void deleteCategory(int categoryId) {
        ProductDAO pd = new ProductDAO();
        List<Product> listProduct = getProductByCategory(categoryId);
        for (Product p : listProduct) {
            pd.deleteProductByProductId(p.getProductId());
        }

        String sql = "delete from Category\n"
                + "where category_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi delete category: " + e);
        }
    }

    public void insertCategory(String name, String description) {
        String sql = "insert Category(category_name, Desciption) values(?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("loi insert category: " + e);
        }
    }

    public void updateCategory(int categoryId, String categoryName, String description) {
        String sql = "update Category\n"
                + "set\n"
                + "category_name = ?,\n"
                + "Desciption = ?\n"
                + "where category_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryName);
            ps.setString(2, description);
            ps.setInt(3, categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi update category: " + e);
        }
    }

    public static void main(String[] args) {
        CategoryDAO cd = new CategoryDAO();
        for (Map.Entry<Category, List<Integer>> x : cd.getNumberOfProductAndNumberOfProductSoldByCategory().entrySet()) {
            System.out.println(x.getKey());
            for (int y : x.getValue()) {
                System.out.println(y);
            }
        }
    }
}
