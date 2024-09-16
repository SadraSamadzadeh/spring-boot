package com.example.PoliceApp.Modal;


import jakarta.persistence.*;

@Entity
@Table(name = "CrimeDetails")
public class CrimeDetails {

    @jakarta.persistence.Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer Id;
    private String Info;


    public Integer getId() {
        return Id;
    }

    public String getInfo() {
        return Info;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setInfo(String info) {
        Info = info;
    }

}
