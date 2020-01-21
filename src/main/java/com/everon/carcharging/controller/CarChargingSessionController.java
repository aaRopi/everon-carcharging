package com.everon.carcharging.controller;

import com.everon.carcharging.service.CarChargingSessionService;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.CarChargingSessionList;
import com.everon.carcharging.session.ChargingSessionSummary;
import com.everon.carcharging.session.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller that maps all the
 * car charging session requests
 */
@RestController
public class CarChargingSessionController {


    @Autowired
    private CarChargingSessionService carChargingSessionService;


    @RequestMapping(value = "/chargingSessions",
            method = RequestMethod.POST)
    public CarChargingSession submitChargingSession(@RequestBody Station stationId) throws Exception {
        return carChargingSessionService.submitChargingSession(stationId.getStationId()).get();
    }

    @RequestMapping(value = "/chargingSessions/{uuid}",
            method = RequestMethod.PUT)
    public CarChargingSession stopChargingSession(@PathVariable UUID uuid) throws Exception {
        return carChargingSessionService.stopChargingSessionById(uuid);
    }

    @RequestMapping(value = "/chargingSessions",
            method = RequestMethod.GET)
    public CarChargingSessionList getAllChargingSessions() {
        return carChargingSessionService.getAllChargingSessions();
    }

    @RequestMapping(value = "/chargingSessions/summary",
            method = RequestMethod.GET)
    public ChargingSessionSummary getSummary() {
        return carChargingSessionService.getChargingSessionSummary();
    }

}
