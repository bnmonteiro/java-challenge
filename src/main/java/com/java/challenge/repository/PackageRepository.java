package com.java.challenge.repository;

import com.java.challenge.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<Package, Long> {
    public Optional<Package> findByName(String name);
}
