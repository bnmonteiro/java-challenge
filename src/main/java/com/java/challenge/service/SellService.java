package com.java.challenge.service;

import com.java.challenge.model.Sell;
import com.java.challenge.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {
    private final SellRepository SellRepository;

    @Autowired
    public SellService(SellRepository SellRepository) {
        this.SellRepository = SellRepository;
    }

    public List<Sell> getAllSells() {
        return SellRepository.findAll();
    }

    public Sell saveSell(Sell Sell) {
        return SellRepository.save(Sell);
    }

  }
