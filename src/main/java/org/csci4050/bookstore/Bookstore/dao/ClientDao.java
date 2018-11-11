package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.mappers.ClientMapper;
import org.csci4050.bookstore.Bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class ClientDao extends UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDao(final JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createClient(final Client client) throws ValidationException {
        this.createUser(client);
        final String sql = "insert into client(client_username,address,company,name) values(?,?,?,?);";
        this.jdbcTemplate.update(sql, client.getUsername(), client.getAddress(), client.getCompany(), client.getName());
    }

    public void updateClient(final Client client) throws ValidationException {
        this.updateUser(client);
        final String sql = "update client set address=?, company=?, name=? where client_username=?;";
        jdbcTemplate.update(sql, client.getAddress(), client.getCompany(), client.getName(), client.getUsername());
    }

    public Optional<Client> getClient(final String username) {
        final List<Client> client = this.jdbcTemplate.query("select * from client,user where client_username=? and username=client_username;", new Object[] {username}, new ClientMapper());
        return client.stream().findAny();
    }

    public List<Client> getClients() {
        return this.jdbcTemplate.query("select * from client,user where client_username=username;", new ClientMapper());
    }
}
