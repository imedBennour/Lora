package com.example.kafka.mysqllite.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "gps_data")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Gps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_time",nullable = false)
    private String dateTime;
    @Column(name = "lat",nullable = false)
    private Double lat;
    @Column(name = "log",nullable = false)
    private Double log;


    public Gps(String dateTime, Double lat, Double log) {
        this.dateTime = dateTime;
        this.lat = lat;
        this.log = log;
    }
}
