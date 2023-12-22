package com.ibuc.bookmyservice.workermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
public class TimeSlot {

    @JsonProperty
    private Long slotId;
    @JsonProperty
    private Instant startTime;
    @JsonProperty
    private Instant endTime;
    @JsonProperty
    private boolean isBooked;
    @JsonProperty
    private Worker worker;
}
