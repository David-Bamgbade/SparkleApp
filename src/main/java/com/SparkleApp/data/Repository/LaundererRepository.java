package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.Launderer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundererRepository extends JpaRepository<Launderer, Long> {
    Launderer findByEmailAndPassword(String email, String password);
    Launderer findByEmailAndPhoneNumber(String email, String phoneNumber);
    Launderer findByEmail(String email);
    Launderer findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
//    boolean existsLaundererByEmailAndPhoneNumber(String email, String phoneNumber);
    Launderer findByPassword(String password);
//    boolean existsLaundererByEmail(String email);
//    Launderer existsLaundererByEmailAndPassword(String email, String password);
}
