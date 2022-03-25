package models;

import java.sql.Timestamp;

public class Reimb {
    private Integer reimb_Id;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipts;
    private Integer author;
    private Integer resolver;
    private Integer status_Id;
    private Integer type_Id;

    public Reimb(){

    }
    //update constructor
    public Reimb( Integer status_Id, Integer resolver ,Timestamp resolved) {

        this.status_Id = status_Id;
        this.resolver = resolver;
        this.resolved = resolved;

    }
/*
    public Reimb(Integer reimb_Id, double amount, Integer author, String description, Timestamp submitted, Integer type_Id, Integer status_Id) {
        this.reimb_Id = reimb_Id;
        this.amount = amount;
        this.author = author;
        this.description = description;
        this.submitted = submitted;
        this.type_Id = type_Id;
        this.status_Id = status_Id;
    }
    */
    //create constructor
    public Reimb( Double amount,  String description, Integer author,  Integer status_Id, Integer type_Id) {
        this.amount = amount;
        this.description = description;
        this.author = author;
        this.status_Id = status_Id;
        this.type_Id = type_Id;
    }



    public Integer getReimb_Id() {
        return reimb_Id;
    }

    public void setReimb_Id(Integer reimb_Id) {
        this.reimb_Id = reimb_Id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipts() {
        return receipts;
    }

    public void setReceipts(String receipts) {
        this.receipts = receipts;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getResolver() {
        return resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getStatus_Id() {
        return status_Id;
    }

    public void setStatus_Id(Integer status_Id) {
        this.status_Id = status_Id;
    }

    public Integer getType_Id() {
        return type_Id;
    }

    public void setType_Id(Integer type_Id) {
        this.type_Id = type_Id;
    }

    @Override
    public String toString() {
        return "Reimb{" +
                "reimb_Id=" + reimb_Id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipts='" + receipts + '\'' +
                ", author='" + author + '\'' +
                ", resolver='" + resolver + '\'' +
                ", status_Id='" + status_Id + '\'' +
                ", type_Id=" + type_Id +
                '}';
    }
}
