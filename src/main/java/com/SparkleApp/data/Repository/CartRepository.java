package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.Cart;
import com.SparkleApp.data.models.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart,Long>{
}
