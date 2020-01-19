package com.everon.carcharging.service;

import com.everon.carcharging.dao.CarChargingSessionDao;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;
import com.everon.carcharging.session.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation class for CarChargingSessionService
 */

@Service
public class CarChargingSessionServiceImpl implements CarChargingSessionService {

    @Autowired
    private CarChargingSessionDao carChargingSessionDao;

    @Override
    public Optional<CarChargingSession> submitChargingsession(String stationId) {
        if (stationId != null && !stationId.isEmpty()) {
            return carChargingSessionDao.createCarChargingSession(stationId).stream().
                    filter(matchingStationId -> matchingStationId.getStationId().equals(stationId)).findAny();
        } else return Optional.empty();
    }

    @Override
    public CarChargingSession stopChargingsessionById(UUID uuid) {
        if (uuid != null) {
            Optional<CarChargingSession> sessionTobeUpdated = carChargingSessionDao.stopCarChargingSession(uuid);
            sessionTobeUpdated.ifPresent(session -> session.setStatus(StatusEnum.FINISHED));
            return sessionTobeUpdated.get();
        } else return null;
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
