package com.example.demo.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "field")
public class field {

    @Id
    @Column
    private long id;

    @NotNull @Column(length = 20)
    private String field_name;
    @Column(length = 100)
    private String field_addr;

    @NotNull @Column
    private double field_lat;
    private double field_lon;

}