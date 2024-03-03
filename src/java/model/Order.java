/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Order {
//        [Order_id] [int] IDENTITY(1,1) NOT NULL,
//	[user_id] [int] NOT NULL,
//	[order_date] [date] NOT NULL,
//	[note] [nvarchar](100) NULL,
//	[status] [int] NOT NULL,
//	[total_money] [decimal](10, 2) NULL,
    
    private int orderId;
    private User user;
    private Date orderDate;
    private String note;
    private int status;
    private float totalMoney;

    public Order() {
    }

    public Order(int orderId, User user, Date orderDate, String note, int status, float totalMoney) {
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.note = note;
        this.status = status;
        this.totalMoney = totalMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", note=" + note + ", status=" + status + ", totalMoney=" + totalMoney + '}';
    }
    
}
