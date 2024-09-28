package com.SparkleApp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter
public enum ItemType {
  HOODIE,
    SHIRT,
  UNDER_WEAR
}
