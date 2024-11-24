package com.example.a2006913app;

public class Node {

    private int NodeID;
    private int yesID;
    private int noID;

    private String description;
    private String question;



    public Node(int nodeID, int yesID, int noID, String description, String question) {
        NodeID = nodeID;
        this.yesID = yesID;
        this.noID = noID;
        this.description = description;
        this.question = question;
    }



    public int getNodeID() {
        return NodeID;
    }

    public void setNodeID(int nodeID) {
        NodeID = nodeID;
    }

    public int getYesID() {
        return yesID;
    }

    public void setYesID(int yesID) {
        this.yesID = yesID;
    }

    public int getNoID() {
        return noID;
    }

    public void setNoID(int noID) {
        this.noID = noID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    }

