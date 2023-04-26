package com.example.pagination.api;

import com.example.pagination.dto.CarResponse;
import com.example.pagination.entity.Car;
import com.example.pagination.repository.CarRepository;
import com.example.pagination.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarController {

  private CarService carService;
  private final CarRepository carRepository;

  public CarController(CarService carService,
                       CarRepository carRepository) {
    this.carService = carService;

    this.carRepository = carRepository;
  }


  @GetMapping()
  public List<Car> getAllCars(Pageable pageable) {
    Page<Car> carPage = carRepository.findAll(pageable);
    return carPage.getContent();
    //return carService.getAllCars(pageable);
  }

  @GetMapping("/brand/{brand}")
  public List<Car> getCarsByBrand(@PathVariable String brand, Pageable pageable) {
    Page<Car> carPage = carRepository.findAllByBrand(brand, pageable);
    return carPage.getContent();
    //return carService.getAllCars(pageable);
  }

  @GetMapping("/count")
  public long getTotalNumber() {
    return carRepository.count();
  }

  @GetMapping("/color/{color}")
  public List<Car> getCarsByColor(@PathVariable String color, Pageable pageable) {
    Page<Car> carPage = carRepository.findCarsByColor(color, pageable);
    return carPage.getContent();
  }
}
