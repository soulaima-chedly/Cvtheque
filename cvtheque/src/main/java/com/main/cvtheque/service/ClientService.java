package com.main.cvtheque.service;

import com.main.cvtheque.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    Page<Client> getAllClients(Pageable pageable);

    Optional<Client> findClientById(Long clientId);

    Client createClient(Client client);

    Optional<Client> updateClient(Long clientId, Client clientRequest);

    void deleteClient(Long clientId);
}
