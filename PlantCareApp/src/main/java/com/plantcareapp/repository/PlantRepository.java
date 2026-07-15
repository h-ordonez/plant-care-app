package com.plantcareapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantcareapp.model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

    List<Plant> findByCommonNameContainingIgnoreCase(String commonName);

    List<Plant> findAllByOrderByCommonNameAsc();
}
