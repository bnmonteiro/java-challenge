package com.java.challenge.controller;

import com.java.challenge.model.TaxOwedRequest;
import com.java.challenge.service.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;

@RestController
@RequestMapping("/tax-owed")
public class TaxController {
    private final TaxCalcService taxService;

    @Autowired
    public TaxController(TaxCalcService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public String retrieveTaxOwed(@RequestBody TaxOwedRequest request) {

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        return currency.format(taxService.calcTaxOwed(request));

    }

}
