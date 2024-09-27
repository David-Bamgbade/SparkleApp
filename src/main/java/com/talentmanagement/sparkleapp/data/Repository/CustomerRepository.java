package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> existByEmail(String email);

    List<Customer> findCustomerByFirstName(String firstName);

    List<Customer> findCustomerByLastName(String lastName);
}

