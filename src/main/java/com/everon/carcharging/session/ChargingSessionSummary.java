package com.everon.carcharging.session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargingSessionSummary {

    Integer totalCount;
    Integer startedCount;
    Integer stoppedCount;
}
