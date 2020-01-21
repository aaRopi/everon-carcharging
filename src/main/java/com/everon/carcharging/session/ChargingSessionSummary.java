package com.everon.carcharging.session;

import lombok.*;

/**
 * Object to hold the stopcount, startcound
 * & totalCount of all the CarChargingSessions
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingSessionSummary {

    Integer totalCount;
    Integer startedCount;
    Integer stoppedCount;
}
