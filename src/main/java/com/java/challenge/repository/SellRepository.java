package com.java.challenge.repository;

import com.java.challenge.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Long> {

    public List<Sell> findByBoothIdAndDateBetween(Long boothId, LocalDate dateStart, LocalDate dateEnd);

}
