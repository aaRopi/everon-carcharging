package com.everon.carcharging.service;

import com.everon.carcharging.dao.CarChargingSessionDao;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation class for CarChargingSessionService
 */

@Service
public class CarChargingSessionServiceImpl implements CarChargingSessionService {

    @Autowired
    private CarChargingSessionDao carChargingSessionDao;

    @Override
    public CarChargingSession submitChargingsession(String stationId) {
        return carChargingSessionDao.createCarChargingSession(stationId);
    }

    @Override
    public CarChargingSession stopChargingsessionById(UUID uuid) {
        return carChargingSessionDao.stopCarChargingSession(uuid);
    }

    @Override
    public ChargingSessionSummary getChargingSessionSummary() {
        return carChargingSessionDao.getChargingSessionSummary();
    }

    @Override
    public List<CarChargingSession> getAllChargingSessions() {
        return carChargingSessionDao.getAllChargingSessions();
    }
}
