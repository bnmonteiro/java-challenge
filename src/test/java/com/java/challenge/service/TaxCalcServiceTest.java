package com.java.challenge.service;

import com.java.challenge.model.Sell;
import com.java.challenge.model.TaxOwedRequest;
import com.java.challenge.repository.SellRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TaxCalcServiceTest {

    @Test
    public void calcTaxOwedTest(){

        SellRepository mockDependency = Mockito.mock(SellRepository.class);

        Sell sell1 = new Sell();
        sell1.setPrice(new Double(100));

        ArrayList<Sell> list = new ArrayList<>();
        list.add(sell1);

        TaxOwedRequest req = new TaxOwedRequest();
        req.setBoothId(1L);
        req.setYear(2023);
        req.setMonth(1);

        int year = req.getYear();
        int month = req.getMonth();
        LocalDate startDate = LocalDate.of(year, Month.of(month), 1);

        YearMonth yearMonth = YearMonth.of(year, month);
        int lastDayOfMonth = yearMonth.lengthOfMonth();
        LocalDate endDate = LocalDate.of(year, Month.of(month), lastDayOfMonth);

        Mockito.when(mockDependency.findByBoothIdAndDateBetween(1L,startDate, endDate)).thenReturn(list);

        TaxCalcService myService = new TaxCalcService(mockDependency);

        BigDecimal result = myService.calcTaxOwed(req);

        BigDecimal expectedResult = new BigDecimal(8.62).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expectedResult, result);

    }

}
