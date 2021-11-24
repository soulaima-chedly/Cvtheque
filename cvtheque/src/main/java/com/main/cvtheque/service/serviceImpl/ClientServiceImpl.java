package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.model.Client;
import com.main.cvtheque.repository.ClientRepository;
import com.main.cvtheque.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Optional<Client> findClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> updateClient(Long clientId, Client clientRequest) {
        return clientRepository.findById(clientId).map(client -> {
            client.setName(clientRequest.getName());
            client.setEmail(clientRequest.getEmail());
            client.setGender(clientRequest.getGender());
            client.setAge(clientRequest.getAge());
            return clientRepository.save(client);
        });
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
