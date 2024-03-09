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
public class Comment {
//      [product_id] [int] NOT NULL,
//	[user_id] [int] NOT NULL,
//	[content] [nvarchar](max) NOT NULL,
//	[comment_date] [date] NOT NULL,
//	[rating] [int] NOT NULL,

    private Product product;
    private User user;
    private String content;
    private Date commentDate;
    private int rating;

    public Comment() {
    }

    public Comment(Product product, User user, String content, Date comment_date, int rating) {
        this.product = product;
        this.user = user;
        this.content = content;
        this.commentDate = comment_date;
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date comment_date) {
        this.commentDate = comment_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment{" + "product=" + product.getProductId() + ", user=" + user.getUserName() + ", content=" + content + ", comment_date=" + commentDate + ", rating=" + rating + '}';
    }

}
