package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.util.MapperUtil;
import org.csci4050.bookstore.Bookstore.model.Customer;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        final Customer customer = Customer.builder()
                .address(rs.getString("address"))
                .birthDate(rs.getDate("birth_date"))
                .firstName(rs.getString("first_name"))
                .minit(rs.getString("minit"))
                .lastName(rs.getString("last_name"))
                .newsletter(MapperUtil.convertBitToBool(rs.getByte("newsletter")))
                .verified(MapperUtil.convertBitToBool(rs.getByte("verified")))
                .build();
        return (Customer) UserMapper.setUserFromResultSet(customer, rs);
    }

}
