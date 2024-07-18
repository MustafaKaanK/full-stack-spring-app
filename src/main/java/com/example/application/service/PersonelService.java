package com.example.application.service;


import com.example.application.model.Personel;
import com.example.application.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Service
public class PersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @PostConstruct
    public void init() {
        // Initialize with 10 dummy example
        personelRepository.save(new Personel("12345678901", "Ahmet", "Yılmaz"));
        personelRepository.save(new Personel("23456789012", "Mehmet", "Kaya"));
        personelRepository.save(new Personel("34567890123", "Ayşe", "Demir"));
        personelRepository.save(new Personel("45678901234", "Fatma", "Çelik"));
        personelRepository.save(new Personel("56789012345", "Emre", "Şahin"));
        personelRepository.save(new Personel("67890123456", "Deniz", "Öztürk"));
        personelRepository.save(new Personel("78901234567", "Cem", "Arslan"));
        personelRepository.save(new Personel("89012345678", "Buse", "Yıldırım"));
        personelRepository.save(new Personel("90123456789", "Ebru", "Kara"));
        personelRepository.save(new Personel("01234567890", "Murat", "Güneş"));
        
    }

    public List<Personel> getAllPersonnel() {
        return personelRepository.findAll();
    }
}