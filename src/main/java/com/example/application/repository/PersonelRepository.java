package com.example.application.repository;


import com.example.application.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel, String> {
    // Custom query methods can be defined here
}
