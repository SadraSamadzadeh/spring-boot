package com.example.PoliceApp.Modal;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Officer")
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Username;

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
        this.Username = username;
    }

    @OneToMany(mappedBy = "officer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reports> reports;
}
