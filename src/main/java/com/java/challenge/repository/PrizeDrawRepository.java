package com.java.challenge.repository;

import com.java.challenge.model.PrizeDraw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrizeDrawRepository extends JpaRepository<PrizeDraw, Long> {

    Optional<PrizeDraw> findByPackName(String packName);

}
