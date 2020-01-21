package com.everon.carcharging;

import com.everon.carcharging.session.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarChargingSessionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
    }


    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testSubmitChargingSession() {
        Station station = new Station();
        station.setStationId("ABC-12345");
        CarChargingSession carChargingSessionResponse = restTemplate.postForObject(getRootUrl() + "/chargingSessions",
                station, CarChargingSession.class);
        Assert.assertNotNull(carChargingSessionResponse);
    }

    @Test
    public void testStopChargingSession() {
        UUID uuid = UUID.randomUUID();
        List<CarChargingSession> carChargingSessions = new ArrayList<>();
        carChargingSessions.add(new CarChargingSession(UUID.randomUUID(), "ABC-12345", LocalDateTime.now(),
                LocalDateTime.now(), StatusEnum.FINISHED));
        CarChargingSessionList carChargingSession = restTemplate.getForObject(getRootUrl() + "/chargingSessions/" + uuid, CarChargingSessionList.class);
        carChargingSession.setChargingSession(carChargingSessions);


        restTemplate.put(getRootUrl() + "/chargingSessions/" + UUID.randomUUID(), carChargingSession);

        CarChargingSessionList updatedSession = restTemplate.getForObject(getRootUrl() + "/chargingSessions/" + uuid, CarChargingSessionList.class);
        Assert.assertNotNull(updatedSession);
    }

    @Test
    public void testGetAllChargingSessions() {
        Assert.assertNotNull(restTemplate.getForObject(getRootUrl() + "/chargingSessions",
                CarChargingSessionList.class).getChargingSessions());
    }

    @Test
    public void testGetSummary() {
        ChargingSessionSummary chargingSessionSummary = restTemplate.getForObject(getRootUrl() + "chargingSessions/summary", ChargingSessionSummary.class);
        Assert.assertNotNull(chargingSessionSummary);
    }



}
