package com.example.PoliceApp.Modal;


import jakarta.persistence.*;

@Entity
@Table(name = "Crime")
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private int Severity;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getSeverity() {
        return Severity;
    }

    public void setSeverity(Integer severity) {
        Severity = severity;
    }
}
