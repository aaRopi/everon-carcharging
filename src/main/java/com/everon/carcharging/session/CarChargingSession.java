package com.everon.carcharging.session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity class that stored a car chargind ession
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarChargingSession {
   private UUID id;
   private String stationId;
   private LocalDateTime startedAt;
   private LocalDateTime stoppedAt;
   StatusEnum status;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof CarChargingSession)) {
            return false;
        }
        CarChargingSession carChargingSession = (CarChargingSession) o;
        return Objects.equals(getId(), carChargingSession.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
