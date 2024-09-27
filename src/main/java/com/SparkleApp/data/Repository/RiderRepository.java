package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Rider findRiderByEmail(String email);
    Rider findRiderByPhoneNumber(String phoneNumber);

}
