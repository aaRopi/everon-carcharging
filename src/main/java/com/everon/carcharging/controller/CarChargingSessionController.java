package com.everon.carcharging.controller;

import com.everon.carcharging.service.CarChargingSessionService;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.ChargingSessionSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public CarChargingSession submitChargingSession(@RequestBody String carChargingSession) {
        return carChargingSessionService.submitChargingsession(carChargingSession);
    }

    @RequestMapping(value = "/chargingSessions/{id}",
            method = RequestMethod.PUT)
    public CarChargingSession stopChargingSession(@PathVariable UUID uuid) {
        return carChargingSessionService.stopChargingsessionById(uuid);
    }

    @RequestMapping(value = "/chargingSessions",
            method = RequestMethod.GET)
    public List<CarChargingSession> getAllChargingSessions() {
        return carChargingSessionService.getAllChargingSessions();
    }

    @RequestMapping(value = "/charginSessions/summary",
                    method = RequestMethod.GET)
    public ChargingSessionSummary getSummary() {
        return carChargingSessionService.getChargingSessionSummary();
    }

}
