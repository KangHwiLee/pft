package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "field")
@Getter
@Setter
public class Field {

    @Id
    @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull @Column(length = 20)
    private String field_name;
    @Column(length = 100)
    private String field_addr;

    @NotNull @Column
    private double field_lat;
    private double field_lon;

    @Column
    private String created_at = nowdate();
    private String updated_at = nowdate();

    private String nowdate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = format.format(date);
        return now;
    }
}