package com.blogs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;

    private String name;

    @Column(name = "specialty", length = 100)
    private String spclity;

    public Doctors() {
        // Default constructor
    }

    public Doctors(String name, String spclity) {
        this.name = name;
        this.spclity = spclity;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpclity() {
        return spclity;
    }

    public void setSpclity(String spclity) {
        this.spclity = spclity;
    }

    @Override
    public String toString() {
        return "Doctors [did=" + did + ", name=" + name + ", spclity=" + spclity + "]";
    }
}
