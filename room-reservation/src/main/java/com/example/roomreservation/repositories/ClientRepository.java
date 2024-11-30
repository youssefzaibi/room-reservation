package com.example.roomreservation.repositories;

import com.example.roomreservation.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    void deleteClientById(Long id);
    Client findClientById(Long id);
}
