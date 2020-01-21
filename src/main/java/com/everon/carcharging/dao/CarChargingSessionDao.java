package com.everon.carcharging.dao;

import com.everon.carcharging.session.CarChargingSession;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface for the DAO Layer;
 * Creating a DAO layer is optional for this
 * specific use case but in order to make the implementation
 * extensible for Actual DB related implementation, is a good practice
 */
public interface CarChargingSessionDao {

    /**
     * @param stationId
     * @return
     */
    LinkedHashSet<CarChargingSession> createCarChargingSession(String stationId);

    /**
     * @param uuid
     * @return
     */
    Optional<CarChargingSession> stopCarChargingSession(UUID uuid);

    /**
     * @return
     */
    LinkedHashSet<CarChargingSession> getAllChargingSessions();

    /**
     * @return
     */
    LinkedHashSet<CarChargingSession> getChargingSessionSummary();


}
