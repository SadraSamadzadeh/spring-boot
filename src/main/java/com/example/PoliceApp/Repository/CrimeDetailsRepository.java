package com.example.PoliceApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PoliceApp.Modal.CrimeDetails;
public interface CrimeDetailsRepository extends JpaRepository<CrimeDetails, Integer> {

}
