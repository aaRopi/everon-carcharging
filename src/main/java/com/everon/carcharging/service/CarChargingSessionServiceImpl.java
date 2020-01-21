package com.everon.carcharging.service;

import com.everon.carcharging.dao.CarChargingSessionDao;
import com.everon.carcharging.exception.ResourceNotFoundException;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.CarChargingSessionList;
import com.everon.carcharging.session.ChargingSessionSummary;
import com.everon.carcharging.session.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation class for CarChargingSessionService
 */

@Service
public class CarChargingSessionServiceImpl implements CarChargingSessionService {

    /**
    * Logger for CarChargingServiceImpl Class
    */
    private static final Logger LOG = LoggerFactory.getLogger(CarChargingSessionServiceImpl.class);


    /**
     * Adding CarChargingSessionDao dependency
     */
    @Autowired
    private CarChargingSessionDao carChargingSessionDao;

    @Override
    public Optional<CarChargingSession> submitChargingSession(String stationId) throws RuntimeException {
        if (stationId != null && !stationId.isEmpty()) {
            LOG.info("Creating Session with StationId : " + stationId);
            return carChargingSessionDao.createCarChargingSession(stationId).stream().
                    filter(matchingStationId ->
                            matchingStationId.getStationId().equals(stationId)).findAny();
        } else throw new RuntimeException("Invalid Request Body");
    }

    @Override
    public synchronized CarChargingSession stopChargingSessionById(UUID uuid) throws ResourceNotFoundException {
        Optional<CarChargingSession> sessionTobeUpdated = carChargingSessionDao.stopCarChargingSession(uuid);
        if (sessionTobeUpdated.isPresent()) {
            sessionTobeUpdated.get().setStoppedAt(LocalDateTime.now());
            sessionTobeUpdated.get().setStatus(StatusEnum.FINISHED);
        } else {
            throw new ResourceNotFoundException("Could not find Session with Id" + uuid);
        }
        return sessionTobeUpdated.get();
    }

    @Override
    public ChargingSessionSummary getChargingSessionSummary() {
        LinkedHashSet<CarChargingSession> carChargingSessionSet = carChargingSessionDao.getChargingSessionSummary();
        long startedCount = carChargingSessionSet.stream().
                filter(startedSessions ->
                        startedSessions.getStatus().equals(StatusEnum.IN_PROGRESS)).count();
        LOG.info("Start Count" + (int) startedCount);

        long stoppedCount = carChargingSessionSet.stream().
                filter(stoppedSessions ->
                        stoppedSessions.getStatus().equals(StatusEnum.FINISHED)).count();
        LOG.info("Stop count" + (int) stoppedCount);
        int totalCount = (int) startedCount + (int) stoppedCount;

        return new ChargingSessionSummary(totalCount, (int) startedCount, (int) stoppedCount);
    }

    @Override
    public CarChargingSessionList getAllChargingSessions() {
        List<CarChargingSession> carChargingSessions = carChargingSessionDao.getAllChargingSessions()
                .stream()
                .collect(Collectors.toList());
        return new CarChargingSessionList(carChargingSessions);
    }
}
