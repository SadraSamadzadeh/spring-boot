package com.example.PoliceApp.Repository;

import com.example.PoliceApp.Modal.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
}
