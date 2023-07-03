package com.java.challenge.model;

import lombok.Data;

@Data
public class TaxOwedRequest {

    private Long boothId;

    private Integer month;

    private Integer year;

}
