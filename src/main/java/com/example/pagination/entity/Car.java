package com.example.pagination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Car {

  @Id
  int id;
  String brand;
  String model;
  String color;
  int kilometers;

  @CreationTimestamp
  LocalDateTime created;

  @UpdateTimestamp
  LocalDateTime updated;
}
