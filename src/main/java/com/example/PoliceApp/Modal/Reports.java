package com.example.PoliceApp.Modal;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Reports")
public class Reports {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private Date DateReported;
    private String status;
    private String details;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateReported() {
        return DateReported;
    }

    public void setDateReported(Date dateReported) {
        DateReported = dateReported;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @ManyToOne
    @JoinColumn(name="officer_id")
    private Officer officer;

    @ManyToOne
    @JoinColumn(name="reporter_id")
    private Reporter reporter;
}
