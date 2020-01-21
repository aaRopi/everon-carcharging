package com.everon.carcharging;

import com.everon.carcharging.dao.CarChargingSessionDao;
import com.everon.carcharging.service.CarChargingSessionServiceImpl;
import com.everon.carcharging.session.CarChargingSession;
import com.everon.carcharging.session.StatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarChargingServiceImplTest {

    @Mock
    CarChargingSessionDao mockCarChargingSessionDao;

    @InjectMocks
    CarChargingSessionServiceImpl carChargingService;

    @Test
    public void testGetAllCarChargingSessions(){
        LinkedHashSet<CarChargingSession> actualCarChargingSessionSet = new LinkedHashSet<>();
        CarChargingSession carChargingSession1 = new CarChargingSession(UUID.randomUUID(), "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
        actualCarChargingSessionSet.add(carChargingSession1);
        CarChargingSession carChargingSession2 = new CarChargingSession(UUID.randomUUID(), "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
        actualCarChargingSessionSet.add(carChargingSession2);
        when(mockCarChargingSessionDao.getAllChargingSessions()).thenReturn(actualCarChargingSessionSet);
        Assert.assertEquals(actualCarChargingSessionSet.size(), carChargingService.getAllChargingSessions().getChargingSessions().size());
    }
}
