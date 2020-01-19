package com.everon.carcharging.service;

import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Interface for CarCahrging session service
 */
@Service
public interface CarChargingSessionService {

    CarChargingSession submitChargingsession(String stationId);

    CarChargingSession stopChargingsessionById(UUID uuid);

    ChargingSessionSummary getChargingSessionSummary();

    List<CarChargingSession> getAllChargingSessions();

}
