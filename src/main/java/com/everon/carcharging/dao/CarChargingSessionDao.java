package com.everon.carcharging.dao;

import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;

import java.util.List;
import java.util.UUID;

public interface CarChargingSessionDao {

     CarChargingSession createCarChargingSession(String stationId);

     CarChargingSession stopCarChargingSession(UUID uuid);

     List<CarChargingSession> getAllChargingSessions();

     ChargingSessionSummary getChargingSessionSummary();



}
