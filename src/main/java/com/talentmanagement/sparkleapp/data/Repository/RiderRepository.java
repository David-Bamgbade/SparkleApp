package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    Rider findRiderByEmail(String email);
    Rider findRiderByPhoneNumber(String phoneNumber);

}
