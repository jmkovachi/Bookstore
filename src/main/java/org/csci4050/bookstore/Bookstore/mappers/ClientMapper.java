package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        final Client client = Client.builder()
                .address(rs.getString("address"))
                .company(rs.getString("company"))
                .name(rs.getString("name"))
                .build();
        return (Client) UserMapper.setUserFromResultSet(client, rs);
    }
}
