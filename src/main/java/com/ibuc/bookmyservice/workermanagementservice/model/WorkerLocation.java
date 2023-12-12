package com.ibuc.bookmyservice.workermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerLocation {
    @JsonProperty
    private Double latitude;
    @JsonProperty
    private Double longitude;
}
