package com.example.kafka.mysqllite.service.services;

import com.example.kafka.mysqllite.service.entities.Gps;
import com.example.kafka.mysqllite.service.repository.GpsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class GpsServiceImp implements GpsService {

    private final GpsRepository gpsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public GpsServiceImp(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    @Transactional
    @Override
    public void saveData(Gps gps) {
        entityManager.persist(gps);
    }
}
