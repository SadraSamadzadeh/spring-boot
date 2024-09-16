package com.example.PoliceApp.Modal;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Reporter")
public class Reporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Username;
    private String Info;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reports> reports;
}