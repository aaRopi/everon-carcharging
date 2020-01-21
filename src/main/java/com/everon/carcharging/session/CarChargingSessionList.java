package com.everon.carcharging.session;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper Class that contains the List
 * of CarChargingSession.
 * This is created to avoid problems while Deserializing
 * a list of CarChargingSession
 */
public class CarChargingSessionList {

    private List<CarChargingSession> carChargingSessionList;

    public CarChargingSessionList() {
        carChargingSessionList = new ArrayList<>();
    }

    public CarChargingSessionList(List<CarChargingSession> carChargingSessions) {
        this.carChargingSessionList = carChargingSessions;
    }

    public List<CarChargingSession> getChargingSessions() {
        return carChargingSessionList;
    }

    public void setChargingSession(List<CarChargingSession> carChargingSessions) {
        this.carChargingSessionList = carChargingSessions;
    }
}
