package com.everon.carcharging;


import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.StatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;


@RunWith(MockitoJUnitRunner.class)
public class CarChargingSessionDaoImplTest {

    private final static int NUM_THREADS = 10;
    private final static int NUM_ITERATIONS = 1000;

    @Mock
    LinkedHashSet<CarChargingSession> carChargingSessionSet;

    @Test
    public void testcreateCarChargingSession(){

        LinkedHashSet<CarChargingSession> actualCarChargingSessionSet = new LinkedHashSet<>();
        CarChargingSession carChargingSession = new CarChargingSession(UUID.randomUUID(), "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
         actualCarChargingSessionSet.add(carChargingSession);
        Assert.assertEquals(1, actualCarChargingSessionSet.size());

    }


}

