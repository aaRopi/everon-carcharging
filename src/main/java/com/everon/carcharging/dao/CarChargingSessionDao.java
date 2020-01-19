package com.everon.carcharging.dao;

import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarChargingSessionDao {

     LinkedHashSet<CarChargingSession> createCarChargingSession(String stationId);

     Optional<CarChargingSession> stopCarChargingSession(UUID uuid);

     List<CarChargingSession> getAllChargingSessions();

     ChargingSessionSummary getChargingSessionSummary();



}
