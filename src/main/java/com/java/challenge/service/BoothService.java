package com.java.challenge.service;

import com.java.challenge.model.Booth;
import com.java.challenge.repository.BoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoothService {
    private final BoothRepository BoothRepository;

    @Autowired
    public BoothService(BoothRepository BoothRepository) {
        this.BoothRepository = BoothRepository;
    }

    public List<Booth> getAllBooths() {
        return BoothRepository.findAll();
    }

    public Booth saveBooth(Booth Booth) {
        return BoothRepository.save(Booth);
    }

  }
