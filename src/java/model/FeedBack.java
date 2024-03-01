/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class FeedBack {
//      [feedback_id] [int] IDENTITY(1,1) NOT NULL,
//	[user_id] [int] NOT NULL,
//	[subject_name] [nvarchar](50) NOT NULL,
//	[note] [nvarchar](max) NULL,
    private int feedbackId;
    private User user;
    private String subjectName;
    private String note;

    public FeedBack() {
    }

    public FeedBack(int feedbackId, User user, String subjectName, String note) {
        this.feedbackId = feedbackId;
        this.user = user;
        this.subjectName = subjectName;
        this.note = note;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "feedbackId=" + feedbackId + ", user=" + user + ", subjectName=" + subjectName + ", note=" + note + '}';
    }
    
    
}
