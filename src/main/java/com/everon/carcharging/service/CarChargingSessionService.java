package com.everon.carcharging.service;

import com.everon.carcharging.exception.ResourceNotFoundException;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.CarChargingSessionList;
import com.everon.carcharging.session.ChargingSessionSummary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface for CarCharging session service
 */
@Service
public interface CarChargingSessionService {
    /**
     * @param stationId
     * @return
     * @throws Exception
     */
    Optional<CarChargingSession> submitChargingSession(String stationId) throws Exception;

    /**
     * @param uuid
     * @return
     * @throws ResourceNotFoundException
     */
    CarChargingSession stopChargingSessionById(UUID uuid) throws ResourceNotFoundException;

    /**
     * @return
     */
    ChargingSessionSummary getChargingSessionSummary();

    /**
     * @return
     */
    CarChargingSessionList getAllChargingSessions();

}
