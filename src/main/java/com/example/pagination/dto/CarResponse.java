package com.example.pagination.dto;

import com.example.pagination.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
  int id;
  String brand;
  String model;
  String color;
  int kilometers;

public CarResponse(Car car){
  this.id = car.getId();
  this.brand = car.getBrand();
  this.model = car.getModel();
  this.color = car.getColor();
  this.kilometers = car.getKilometers();
}

  public CarResponse copyTo(Car car){
     this.id = car.getId();
     this.brand = car.getBrand();
     this.model = car.getModel();
     this.color = car.getColor();
     this.kilometers = car.getKilometers();
    return this;
  }
}
