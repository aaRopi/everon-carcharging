package com.everon.carcharging;


import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.StatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarChargingSessionDaoImplTest {
    


    @Mock
    LinkedHashSet<CarChargingSession> carChargingSessionSet;

    @Test
    public void testcreateCarChargingSession(){

        LinkedHashSet<CarChargingSession> actualCarChargingSessionSet = new LinkedHashSet<>();
        CarChargingSession carChargingSession = new CarChargingSession(UUID.randomUUID(), "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
         actualCarChargingSessionSet.add(carChargingSession);
        when(carChargingSessionSet.add(carChargingSession)).thenReturn(true);
        Assert.assertEquals(1, actualCarChargingSessionSet.size());

    }

    @Test
    public void testStopChargingSession() {
        Mockito.mock(CarChargingSession.class);
        //when(carChargingSessionSet.stream().collect(Collectors.toList())).thenReturn()

    }

    @Test
    public void testAllChargingSessions() {

    }
}

