package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.UUID;

public class User extends Subject implements Composite, Observer {

    private String userName;
    private String userID;
    // Following list save in each user instance to be able to save the followingList if the userView is closed and
    // reopened
    private ArrayList<String> followingList = new ArrayList<>();
    // I decided to save an instance of userListModel and messageListModel in the User class so that the information
    // stored in both would be saved when the userView window is closed and reopened
    private DefaultListModel userListModel = new DefaultListModel();
    private DefaultListModel<String> messageListModel = new DefaultListModel();
    //Messages are saved in the user to be able to access each message the user has sent when the root is visited to get
    // the message count
    private ArrayList<String> messageArrayList = new ArrayList<>();
    // JTextArea where the newsFeed will be displayed
    private JTextArea newsFeedTextField = new JTextArea();


    public JTextArea getNewsFeedTextField() {
        return newsFeedTextField;
    }


    public User(String studentName) {
        this.userName = studentName;
        this.userID = UUID.randomUUID().toString();
    }


    public ArrayList<String> getFollowingList() {
        return this.followingList;
    }
    public String getUserName() {
        return this.userName;
    }


    public DefaultListModel getUserListModel() {
        return userListModel;
    }

    public DefaultListModel getMessageListModel() {
        return messageListModel;
    }

    // Visitor pattern method to accept a visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    // Observer pattern method to update the text fields
    @Override
    public void update(Subject subject) {
        JTextArea subjectTextArea = this.getNewsFeedTextField();
        User user = (User) subject;
        subjectTextArea.removeAll();
        subjectTextArea.append(user.getNewsFeedTextField().getText());

    }

    public ArrayList<String> getMessageArrayList() {
        return messageArrayList;
    }

}
