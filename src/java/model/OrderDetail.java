/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class OrderDetail {
//      [order_id] [int] NOT NULL,
//	[product_id] [int] NOT NULL,
//	[color_id] [int] NOT NULL,
//	[size_id] [int] NOT NULL,
//	[price] [decimal](10, 2) NOT NULL,
//	[discount] [int] NOT NULL,
//	[quantity] [int] NOT NULL,

    private Order order;
    private Product product;
    private Color color;
    private Size size;
    private float price;
    private int discount;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, Color color, Size size, float price, int discount, int quantity) {
        this.order = order;
        this.product = product;
        this.color = color;
        this.size = size;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order=" + order + ", product=" + product + ", color=" + color + ", size=" + size + ", price=" + price + ", discount=" + discount + ", quantity=" + quantity + '}';
    }
}
