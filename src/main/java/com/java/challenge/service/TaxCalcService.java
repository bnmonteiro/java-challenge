package com.java.challenge.service;

import com.java.challenge.model.Sell;
import com.java.challenge.model.TaxOwedRequest;
import com.java.challenge.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Service
public class TaxCalcService {

    private final SellRepository sellRepository;

    @Autowired
    public TaxCalcService(SellRepository SellRepository) {
        this.sellRepository = SellRepository;
    }

    public BigDecimal calcTaxOwed(TaxOwedRequest requestBody){

        Long boothId = requestBody.getBoothId();
        Integer month = requestBody.getMonth();
        Integer year = requestBody.getYear();

        BigDecimal monthIncome = retrieveBoothIncomeByMonth(boothId, month, year);

        BigDecimal taxRate = new BigDecimal("0.08625");

        BigDecimal monthlyTaxOwed = monthIncome.multiply(taxRate).setScale(2, RoundingMode.HALF_EVEN);

        return monthlyTaxOwed;

    }

    private BigDecimal retrieveBoothIncomeByMonth(Long boothId, int month, int year) {

        LocalDate startDate = LocalDate.of(year, Month.of(month), 1);

        YearMonth yearMonth = YearMonth.of(year, month);
        int lastDayOfMonth = yearMonth.lengthOfMonth();

        LocalDate endDate = LocalDate.of(year, Month.of(month), lastDayOfMonth);

        List<Sell> sells = sellRepository.findByBoothIdAndDateBetween(boothId, startDate, endDate);

        double sum = sells.stream()
                .mapToDouble(Sell::getPrice)
                .sum();

        return new BigDecimal(sum);

    }

}
