package com.everon.carcharging.dao;

import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;
import com.everon.carcharging.session.StatusEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CarChargingSessionDaoImpl implements CarChargingSessionDao {

    LinkedHashSet<CarChargingSession> carChargingSessionSet = new LinkedHashSet<>();

    @Override
    public CarChargingSession createCarChargingSession(String stationId) {

        carChargingSessionSet.add(new CarChargingSession(UUID.randomUUID(),
                stationId, LocalDateTime.now(), null,
                StatusEnum.IN_PROGRESS));

        return carChargingSessionSet.stream().findFirst().get();
    }

    @Override
    public CarChargingSession stopCarChargingSession(UUID uuid) {
        // find the object matching the Id
        Optional<CarChargingSession> sessionToBeUpdated = carChargingSessionSet.stream().filter(matchingSession -> {
            if (matchingSession.getId().compareTo(uuid) == 0) {
                return true;
            } else return false;
        }).findAny();

        sessionToBeUpdated.ifPresent(session -> session.setStatus(StatusEnum.FINISHED));
        return sessionToBeUpdated.get();
    }

    @Override
    public List<CarChargingSession> getAllChargingSessions() {
        return carChargingSessionSet.stream().collect(Collectors.toList());
    }

    @Override
    public ChargingSessionSummary getChargingSessionSummary() {
        long startedCount = carChargingSessionSet.stream().
                filter(startedSessions ->
                startedSessions.getStatus().equals(StatusEnum.IN_PROGRESS)).count();

        long stoppedCount = carChargingSessionSet.stream().
                filter(startedSessions ->
                        startedSessions.getStatus().equals(StatusEnum.FINISHED)).count();
        int totalCount = (int)startedCount +(int) stoppedCount;

        return new ChargingSessionSummary(totalCount, (int)stoppedCount, (int)startedCount);
    }


}
