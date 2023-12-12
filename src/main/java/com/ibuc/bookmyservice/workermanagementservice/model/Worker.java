package com.ibuc.bookmyservice.workermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Worker {
    @JsonProperty
    private Long workerId;
    @JsonProperty
    private String workerName;
    @JsonProperty
    private int age;
    @JsonProperty
    private Long phoneNumber;
    @JsonProperty
    private boolean availability_status;
    @JsonProperty
    private WorkerLocation workerLocation;
    @JsonProperty
    private Long categoryId;
    @JsonProperty
    private Long h3Index;
}