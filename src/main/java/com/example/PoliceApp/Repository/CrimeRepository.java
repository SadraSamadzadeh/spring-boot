package com.example.PoliceApp.Repository;

import com.example.PoliceApp.Modal.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, Integer> {
}
