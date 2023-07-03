package com.java.challenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrizeDrawResponse {

    private String orderedPackage;

    private Boolean eligibleToWin;

    private Boolean wonFreePrints;

    private String message;

}
