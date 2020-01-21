package com.everon.carcharging;

import com.everon.carcharging.dao.CarChargingSessionDao;
import com.everon.carcharging.exception.ResourceNotFoundException;
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
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarChargingServiceImplTest {

    @Mock
    CarChargingSessionDao mockCarChargingSessionDao;

    @InjectMocks
    CarChargingSessionServiceImpl carChargingService;

    @Test
    public void testGetAllCarChargingSessions() {
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

    @Test
    public void testGetAllCarChargingSessionSummary() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        LinkedHashSet<CarChargingSession> actualCarChargingSessionSet = new LinkedHashSet<>();
        CarChargingSession carChargingSession1 = new CarChargingSession(uuid1, "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
        actualCarChargingSessionSet.add(carChargingSession1);
        CarChargingSession carChargingSession2 = new CarChargingSession(uuid2, "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.FINISHED);
        actualCarChargingSessionSet.add(carChargingSession2);
        CarChargingSession carChargingSession3 = new CarChargingSession(uuid3, "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.FINISHED);
        actualCarChargingSessionSet.add(carChargingSession3);
        when(mockCarChargingSessionDao.getChargingSessionSummary()).thenReturn(actualCarChargingSessionSet);
        Assert.assertEquals(1, (int)carChargingService.getChargingSessionSummary().getStartedCount());
        Assert.assertEquals(2, (int)carChargingService.getChargingSessionSummary().getStoppedCount());
        Assert.assertEquals(3, (int)carChargingService.getChargingSessionSummary().getTotalCount());

    }

    @Test
    public void testStopChargingSessionByIdWhenIdFound() throws ResourceNotFoundException {
        UUID uuid = UUID.randomUUID();
        CarChargingSession carChargingSession = new CarChargingSession(uuid, "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
        when(mockCarChargingSessionDao.stopCarChargingSession(uuid)).thenReturn(Optional.of(carChargingSession));
        Assert.assertEquals("ABC-12345", carChargingService.stopChargingSessionById(uuid).getStationId());

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testStopChargingSessionByIdWhenIdNotFound() throws ResourceNotFoundException {
        UUID uuid = UUID.randomUUID();
        CarChargingSession carChargingSession = new CarChargingSession(uuid, "ABC-12345", LocalDateTime.now(),
                null, StatusEnum.IN_PROGRESS);
        when(mockCarChargingSessionDao.stopCarChargingSession(UUID.randomUUID())).thenThrow(ResourceNotFoundException.class);
        carChargingService.stopChargingSessionById(uuid);
    }
}
