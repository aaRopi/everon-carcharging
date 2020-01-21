package com.everon.carcharging.session;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.naming.Name;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity class that stored a car charging ession
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarChargingSession  {

   private UUID id;
   private String stationId;
   private LocalDateTime startedAt;
   private LocalDateTime stoppedAt;
   private StatusEnum status;

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
