package com.example.pagination.repository;

import com.example.pagination.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

  Page<Car> findAllByBrand(String brand, Pageable pageable);

  Page<Car> findAllByModel(String model, Pageable pageable);

  long count();
  Page<Car> findCarsByColor(String color, Pageable pageable);


}
