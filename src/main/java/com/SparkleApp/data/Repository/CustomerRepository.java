package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    List<Customer> findCustomerByFirstName(String firstName);

    List<Customer> findCustomerByLastName(String lastName);


    boolean existsByPassword(String password);

    Customer findCustomerOrderByEmail(String email);

}

