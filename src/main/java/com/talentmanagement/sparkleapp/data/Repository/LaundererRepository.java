package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.Launderer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundererRepository extends JpaRepository<Launderer, Long> {
    Launderer findByEmailAndPassword(String email, String password);
    Launderer findByEmailAndPhoneNumber(String email, String phoneNumber);
    Launderer findByEmail(String email);
    Launderer findByPhoneNumber(String phoneNumber);

}
