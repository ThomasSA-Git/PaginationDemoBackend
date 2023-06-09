package com.example.pagination.service;

import com.example.pagination.dto.CarResponse;
import com.example.pagination.entity.Car;
import com.example.pagination.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getAllCars(Pageable pageable) {

    Page<Car> carPage = carRepository.findAll(pageable);
    List<Car> carList = carPage.getContent();
    List<CarResponse> carResponses = carList.stream().map(c -> new CarResponse(c)).toList();
    return carResponses;
  }

  public List<CarResponse> getAllCarsByBrand(String brand, Pageable pageable) {

    Page<Car> carPage = carRepository.findCarsByBrand(brand, pageable);
    List<Car> carList = carPage.getContent();
    List<CarResponse> carResponses = carList.stream().map(c -> new CarResponse(c)).toList();
    return carResponses;
  }

  public List<CarResponse> getAllCarsByModel(String model, Pageable pageable) {
    Page<Car> carPage = carRepository.findCarsByModel(model, pageable);
    List<Car> carList = carPage.getContent();
    List<CarResponse> carResponses = carList.stream().map(c -> new CarResponse(c)).toList();
    return carResponses;
  }

  public List<CarResponse> getAllCarsByColor(String color, Pageable pageable) {
    Page<Car> carPage = carRepository.findCarsByColor(color, pageable);
    List<Car> carList = carPage.getContent();
    List<CarResponse> carResponses = carList.stream().map(c -> new CarResponse(c)).toList();
    return carResponses;
  }

  public Long getCount(){
    return carRepository.count();
  }


}
