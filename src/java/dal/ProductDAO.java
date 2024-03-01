/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Category;

/**
 *
 * @author PC
 */
public class ProductDAO extends MyDAO {

    public List<Product> getQueryProductPagination(String query, String orderBySearch, String page) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product as p\n"
                + "where product_name like N'%" + query + "%' or p.desciption like N'%" + query + "%'";
        String sql2 = sql + "\n";
        try {
            int orderBy = Integer.parseInt(orderBySearch);

            sql2 += "order by ";

            if (orderBy != 0) {
                if (orderBy == 1) {
                    sql2 += " p.quantity_sold desc ";
                } else if (orderBy == 2) {
                    sql2 += " p.created_at desc ";
                } else if (orderBy == 3) {
                    sql2 += " p.price ";
                } else if (orderBy == 4) {
                    sql2 += " p.price desc ";
                } else if (orderBy == 5) {
                    sql2 += " p.discount desc ";
                }
                sql2 += ", p.product_id\n";
            } else {
                sql2 += "  p.product_id\n";
            }
            sql2 += "OFFSET (" + page + " - 1) * 9 rows\n"
                    + "FETCH next 9 rows ONLY";

            PreparedStatement ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                Product p = getProductById(productId);
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get query product: " + e);
        }
        return list;
    }

    public int getTotalProductByQuery(String query) {
        List<Product> list = new ArrayList<>();
        int totalProduct = 0;
        String sql = "select COUNT(distinct p.product_id) as total_query from Product as p\n"
                + "where product_name like N'%" + query + "%' or p.desciption like N'%" + query + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalProduct = rs.getInt("total_query");
                return totalProduct;
            }
        } catch (SQLException e) {
            System.err.println("loi get query product: " + e);
        }
        return 0;
    }

    public List<Product> getFilterProductPagination(String[] category, String[] size, String[] color, double minPrice, double maxPrice, int orderBy, String page) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();

        String sqlPagination = "select p.product_id from Product as p\n";

        String sql = "inner join Product_detail as pd on p.product_id = pd.product_id\n"
                + "where 1 = 1";
        if (category != null && category[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < category.length; i++) {
                if (i == 0) {
                    sql += " category_id = " + category[i];
                } else {
                    sql += " or category_id = " + category[i];
                }
            }
            sql += " )";
        }
        if (size != null && size[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < size.length; i++) {
                if (i == 0) {
                    sql += " size_id = " + size[i];
                } else {
                    sql += " or size_id = " + size[i];
                }
            }
            sql += " )";
        }
        if (color != null && color[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < color.length; i++) {
                if (i == 0) {
                    sql += " color_id = " + color[i];
                } else {
                    sql += " or color_id = " + color[i];
                }
            }
            sql += " )";
        }
        sql += " and price between " + minPrice + " and " + maxPrice;

        sql += "\ngroup by p.product_id\n";

        sqlPagination += sql;


        String sql2 = "with tbl1 as\n"
                + "("
                + "\n" + sqlPagination
                + ")";

        sql2 += "\nselect * from Product as p\n"
                + "inner join tbl1 on p.product_id = tbl1.product_id\n";

        sql2 += " order by ";

        // order by = 0 sort default theo product id tang dan
        if (orderBy != 0) {
            if (orderBy == 1) {
                sql2 += " p.quantity_sold desc ";
            } else if (orderBy == 2) {
                sql2 += " p.created_at desc ";
            } else if (orderBy == 3) {
                sql2 += " p.price ";
            } else if (orderBy == 4) {
                sql2 += " p.price desc ";
            } else if (orderBy == 5) {
                sql2 += " p.discount desc ";
            }
            sql2 += ", p.product_id\n";
        } else {
            sql2 += " p.product_id\n";
        }

        sql2 += "OFFSET (" + page + " - 1) * 9 rows\n"
                + "FETCH next 9 rows ONLY";

        try {
            PreparedStatement ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = getProductById(rs.getInt("product_id"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            System.err.println("loi get filter 1 product" + e);
        }
        return list;
    }

    public int getTotalProductByFilter(String[] category, String[] size, String[] color, double minPrice, double maxPrice) {
        CategoryDAO cd = new CategoryDAO();
        int totalFilter = 0;

        String sqlTotalFilter = "select COUNT(distinct p.product_id) as total_filter from Product as p\n";

        String sql = "inner join Product_detail as pd on p.product_id = pd.product_id\n"
                + "where 1 = 1";
        if (category != null && category[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < category.length; i++) {
                if (i == 0) {
                    sql += " category_id = " + category[i];
                } else {
                    sql += " or category_id = " + category[i];
                }
            }
            sql += " )";
        }
        if (size != null && size[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < size.length; i++) {
                if (i == 0) {
                    sql += " size_id = " + size[i];
                } else {
                    sql += " or size_id = " + size[i];
                }
            }
            sql += " )";
        }
        if (color != null && color[0].compareTo("0") != 0) {
            sql += " and ( ";
            for (int i = 0; i < color.length; i++) {
                if (i == 0) {
                    sql += " color_id = " + color[i];
                } else {
                    sql += " or color_id = " + color[i];
                }
            }
            sql += " )";
        }
        sql += " and price between " + minPrice + " and " + maxPrice;

        sqlTotalFilter += sql;

        try {

            ps = con.prepareStatement(sqlTotalFilter);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalFilter = rs.getInt("total_filter");
            }
            return totalFilter;
        } catch (SQLException e) {
            System.err.println("loi get filter 2 product" + e);
        }
        return totalFilter;
    }

    public int getQuantitySoldProductByColorAndSize(int pid, int cid, int sid) {
        String sql = "select case when SUM(od.quantity) is null then 0\n"
                + "else SUM(od.quantity)\n"
                + "end\n"
                + "as [total_quantity]\n"
                + "from Orders as o\n"
                + "inner join Order_Details as od on o.Order_id = od.order_id\n"
                + "where od.product_id = ? and od.color_id = ? and od.size_id = ? and o.status = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, cid);
            ps.setInt(3, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total_quantity");
            }
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("loi get quantity sold product");
        }
        return 0;
    }

    public int getQuantityStockProductByColorAndSize(int cid, int sid, int pid) {
        String sql = "select * from Product_detail as p\n"
                + "where color_id = ? and size_id = ? and p.product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, sid);
            ps.setInt(3, pid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("Loi get quantity by product");
        }

        return -1;
    }

    public Product getProductById(int id) {
        CategoryDAO cd = new CategoryDAO();
        String sql = "select * from Product\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product product = (new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

                float rating = getRatingByProduct(product.getProductId());

                GaleryDAO gd = new GaleryDAO();
                List<String> thumbnails = gd.getImagesById(product.getProductId());

                product.setThumbnails(thumbnails);
                product.setRating(rating);
                return product;
            }
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Loi get product by id(DAO)");
        }
        return null;
    }

    public List<Product> getRelatedProductByCategory(int pid, int cid) {
        CategoryDAO cd = new CategoryDAO();
        GaleryDAO gd = new GaleryDAO();
        List<Product> list = new ArrayList<>();
        String sql = "select Top 6 * from Product\n"
                + "where category_id = ? and product_id != ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = (new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

                float rating = getRatingByProduct(product.getProductId());
                List<String> thumbnails = gd.getImagesById(product.getProductId());

                product.setThumbnails(thumbnails);
                product.setRating(rating);
                list.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("loi get related product");
        }
        return list;
    }

    public List<Product> getTop5Product() {
        CategoryDAO cd = new CategoryDAO();
        List<Product> list = new ArrayList<>();

        sql = "select top 5 * from Product";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println("Loi get top 5 product");
        }
        return list;
    }

    public List<Product> top10Bestseller() {
        CategoryDAO cd = new CategoryDAO();
        List<Product> list = new ArrayList<>();

        // lay ve top 10 san pham ban chay nhat, sap xep giam dan theo so luong ban ra, danh gia, va tang dan theo id
        sql = "select top 10 * from Product as p\n"
                + "order by p.quantity_sold desc, p.price - (p.price*p.discount/100) desc, p.product_id";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = (new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

                float rating = getRatingByProduct(product.getProductId());

                GaleryDAO gd = new GaleryDAO();
                List<String> thumbnails = gd.getImagesById(product.getProductId());

                product.setThumbnails(thumbnails);
                product.setRating(rating);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("Loi get top 10 best selling All");
        }
        return list;
    }

    public List<Product> getProductAll() {
        List<Product> list = new ArrayList<>();
        GaleryDAO gd = new GaleryDAO();
        CategoryDAO cd = new CategoryDAO();
        String sql = "select * from Product";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = (new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

                float rating = getRatingByProduct(product.getProductId());
                List<String> thumbnails = gd.getImagesById(product.getProductId());

                product.setThumbnails(thumbnails);
                product.setRating(rating);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("Loi get product All");
        }
        return list;
    }

    public float getRatingByProduct(int id) {
        sql = "select p.product_id,\n"
                + "case when AVG(c.rating) is null then 0\n"
                + "else AVG(c.rating)\n"
                + "end as Rating\n"
                + "from Product as p\n"
                + "left join Comment as c on p.product_id = c.product_id\n"
                + "where p.product_id = ?\n"
                + "group by p.product_id, p.product_name";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat("rating");
            }
            ps.close();
            rs.close();
            return 5;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("loi get rating");
        }
        return 5;
    }

    public Map<Category, List<Product>> getTop6NewProduct() {
        Map<Category, List<Product>> map = new LinkedHashMap<>();
        CategoryDAO cd = new CategoryDAO();
        GaleryDAO gd = new GaleryDAO();
        List<Category> listCategory = cd.getCategoryAll();
        for (Category category : listCategory) {
            List<Product> list = new ArrayList<>();
            String sql = "select top 6 * from Product\n"
                    + "where 1 = 1";
            sql += " and category_id = " + category.getCategoryId() + " order by created_at desc";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = (new Product(rs.getInt("product_id"),
                            cd.getCategoryById(rs.getInt("category_id")),
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

                    float rating = getRatingByProduct(product.getProductId());
                    List<String> thumbnails = gd.getImagesById(product.getProductId());

                    product.setThumbnails(thumbnails);
                    product.setRating(rating);
                    list.add(product);
                }
                map.put(category, list);
            } catch (SQLException e) {
                System.err.println(e);
                System.err.println("loi get top 6 new product");
            }
        }

        return map;
    }

    public List<Product> getTop6NewProductAll() {
        List<Product> list = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();

        // lay ve top 10 san pham ban chay nhat, sap xep giam dan theo so luong ban ra, danh gia, va tang dan theo id
        sql = "select top 6 * from Product as p\n"
                + " order by created_at desc";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = (new Product(rs.getInt("product_id"),
                        cd.getCategoryById(rs.getInt("category_id")),
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

                float rating = getRatingByProduct(product.getProductId());

                GaleryDAO gd = new GaleryDAO();
                List<String> thumbnails = gd.getImagesById(product.getProductId());

                product.setThumbnails(thumbnails);
                product.setRating(rating);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.err.println(e);
            System.err.println("Loi get top 10 best selling All");
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        for (Product p : pd.getQueryProductPagination("áo", "4", "1")) {
            System.out.println(p);
        }
    }
}
