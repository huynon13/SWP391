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
    private int luotEdit;
    private Date commentDate;
    private Date commentDateUpdate;
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

    public Comment(Product product, User user, String content, int luotEdit, Date commentDate, int rating) {
        this.product = product;
        this.user = user;
        this.content = content;
        this.luotEdit = luotEdit;
        this.commentDate = commentDate;
        this.rating = rating;
    }

    public int getLuotEdit() {
        return luotEdit;
    }

    public void setLuotEdit(int luotEdit) {
        this.luotEdit = luotEdit;
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

    public Date getCommentDateUpdate() {
        return commentDateUpdate;
    }

    public void setCommentDateUpdate(Date commentDateUpdate) {
        this.commentDateUpdate = commentDateUpdate;
    }

    @Override
    public String toString() {
        return "Comment{" + "product=" + product + ", user=" + user + ", content=" + content + ", luotEdit=" + luotEdit + ", commentDate=" + commentDate + ", commentDateUpdate=" + commentDateUpdate + ", rating=" + rating + '}';
    }
}
