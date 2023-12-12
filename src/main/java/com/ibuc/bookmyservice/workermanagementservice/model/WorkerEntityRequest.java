package com.ibuc.bookmyservice.workermanagementservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WorkerEntityRequest {
    private Long categoryId;
    private List<Long> h3Indexes;
}
