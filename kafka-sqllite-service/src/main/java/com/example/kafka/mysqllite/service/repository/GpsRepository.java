package com.example.kafka.mysqllite.service.repository;

import com.example.kafka.mysqllite.service.entities.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GpsRepository extends JpaRepository<Gps,Long> {

}
