package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.ClientDao;
import org.csci4050.bookstore.Bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientService(final ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client registerClient(final Client client) throws Exception {
        clientDao.createClient(client);
        final Optional<Client> retrieveClient = clientDao.getClient(client.getUsername());
        if (retrieveClient.isPresent() && retrieveClient.get().equals(client)) {
            return retrieveClient.get();
        } else {
            throw new Exception();
        }
    }

    public Optional<Client> getClient(final String cUsername) {
        return clientDao.getClient(cUsername);
    }
}
