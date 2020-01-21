package com.everon.carcharging.dao;

import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.StatusEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation class for CarChargingSessionDao
 */
@Repository
public class CarChargingSessionDaoImpl implements CarChargingSessionDao {

    LinkedHashSet<CarChargingSession> carChargingSessionSet = new LinkedHashSet<>();

    @Override
    public synchronized LinkedHashSet<CarChargingSession> createCarChargingSession(String stationId) {
        carChargingSessionSet.add(new CarChargingSession(UUID.randomUUID(),
                stationId, LocalDateTime.now(), null,
                StatusEnum.IN_PROGRESS));
        return carChargingSessionSet;
    }

    @Override
    public synchronized Optional<CarChargingSession> stopCarChargingSession(UUID uuid) {
        Optional<CarChargingSession> sessionToBeUpdated = carChargingSessionSet.stream().
                filter(matchingSession -> matchingSession.getId().compareTo(uuid) == 0).findAny();
        return sessionToBeUpdated;
    }

    @Override
    public LinkedHashSet<CarChargingSession> getAllChargingSessions() {
        return carChargingSessionSet;
    }

    @Override
    public LinkedHashSet<CarChargingSession> getChargingSessionSummary() {
        return getAllChargingSessions();
    }


}
