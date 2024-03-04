/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.RoleDAO;
import java.util.Date;

/**
 *
 * @author PC
 */
public class User {
//        [user_id] [int] IDENTITY(1,1) NOT NULL,
//	[role_id] [int] NOT NULL,
//	[user_name] [nvarchar](50) NOT NULL,
//	[pass_word] [nvarchar](50) NOT NULL,
//	[full_name] [nvarchar](50) NULL,
//	[birth_day] [date] NULL,
//	[image] [nvarchar](150) NULL,
//	[phone_number] [nvarchar](11) NULL,
//	[address] [nvarchar](200) NULL,
//	[email] [nvarchar](50) NULL,
//	[created_at] [date] NOT NULL,
//	[updated_at] [date] NULL,
//	[deleted] [bit] NOT NULL,

    private int userId;
    private Role role;
    private String userName;
    private String passWord;
    private String fullName;
    private Date birthDay;
    private String image;
    private String phoneNumber;
    private String address;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private int deleted;

    public User() {
    }

    public User(int userId, Role role, String userName, String passWord, String fullName, Date birthDay, String image, String phoneNumber, String address, Date createdAt, Date updatedAt, int deleted) {
        this.userId = userId;
        this.role = role;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
    }

    public User(int userId, Role role, String userName, String passWord, String fullName, Date birthDay, String image, String phoneNumber, String address, String email, Date createdAt, Date updatedAt, int deleted) {
        this.userId = userId;
        this.role = role;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
    }

    public User(int userId, Role role, String userName, String passWord, Date createdAt, int deleted) {
        this.userId = userId;
        this.role = role;
        this.userName = userName;
        this.passWord = passWord;
        this.createdAt = createdAt;
        this.deleted = deleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", role=" + role + ", userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName + ", birthDay=" + birthDay + ", image=" + image + ", phoneNumber=" + phoneNumber + ", address=" + address + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deleted=" + deleted + '}';
    }
    
    public static void main(String[] args) {
    }

}
