package com.ibuc.bookmyservice.workermanagementservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Category {
    @JsonProperty
    private Long categoryId;
    @JsonProperty
    private String categoryName;

}
