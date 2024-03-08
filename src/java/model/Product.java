/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class Product {
//        [product_id] [int] IDENTITY(1,1) NOT NULL,
//	[category_id] [int] NOT NULL,
//	[supperlier_id] [int] NOT NULL,
//	[product_name] [nvarchar](100) NOT NULL,
//	[quantity_per_unit] [int] NOT NULL,
//	[quantity_stock] [int] NULL,
//	[quantity_sold] [int] NULL,
//	[price] [decimal](10, 2) NOT NULL,
//	[discount] [int] NULL,
//	[desciption] [nvarchar](max) NULL,
//	[created_at] [date] NOT NULL,
//	[updated_at] [date] NULL,
//	[deleted] [bit] NOT NULL,

    private int productId;
    private Category category;
    private Supperlier supperlier;
    private String productName;
    private int quantityPerUnit;
    private int quantityStock;
    private int quantitySold;
    private double price;
    private int discount;
    private String desciption;
    private Date createdAt;
    private Date updatedAt;
    private int deleted;
    private List<String> thumbnails;
    private float rating;

    public Product() {
    }

    public Product(int productId, Category category, Supperlier supperlier, String productName, int quantityPerUnit, int quantityStock, int quantitySold, double price, int discount, String desciption, Date createdAt, Date updatedAt, int deleted) {
        this.productId = productId;
        this.category = category;
        this.supperlier = supperlier;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.quantityStock = quantityStock;
        this.quantitySold = quantitySold;
        this.price = price;
        this.discount = discount;
        this.desciption = desciption;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
    }

    public Product(int productId, Category category, Supperlier supperlier, String productName, int quantityPerUnit, double price, Date createdAt, int deleted) {
        this.productId = productId;
        this.category = category;
        this.supperlier = supperlier;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.price = price;
        this.createdAt = createdAt;
        this.deleted = deleted;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supperlier getSupperlier() {
        return supperlier;
    }

    public void setSupperlier(Supperlier supperlier) {
        this.supperlier = supperlier;
    }

    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public List<String> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + " Price: " + price + " , supperlierId=" + supperlier + ", productName=" + productName + ", quantityPerUnit=" + quantityPerUnit + ", discount=" + discount + ", createdAt=" + createdAt + ", deleted=" + deleted + '}';
    }

    

}
