package models;

import java.sql.Timestamp;
import java.util.List;

public class ReimbList {
    public Integer reimb_Id;
    public String firstname;
    public String lastname;
    public Double amount;
    public String description;
    public String submitted;
    public Integer status_Id;
    public String status;
    public Integer type_Id;
    public String type;

    public ReimbList(){

    }

    public ReimbList(Integer reimb_Id, String firstname, String lastname, Double amount, String description, String submitted, Integer status_Id, String status, Integer type_Id, String type) {
        this.reimb_Id = reimb_Id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.amount = amount;
        this.description = description;
        this.submitted = submitted;
        this.status_Id = status_Id;
        this.status = status;
        this.type_Id = type_Id;
        this.type = type;
    }


    @Override
    public String toString() {
        return "ReimbList{" +
                "reimb_Id=" + reimb_Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", submitted=" + submitted +
                ", status_Id=" + status_Id +
                ", status='" + status + '\'' +
                ", type_Id=" + type_Id +
                ", type='" + type + '\'' +
                '}';
    }
}