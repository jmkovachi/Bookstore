package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.VendorMapper;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class VendorDao extends UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createVendor(final Vendor vendor) {
        this.createUser(vendor);
        final String sql = "insert into vendor(v_username, company, address) values(?,?,?,?);";
        this.jdbcTemplate.update(sql, vendor.getUsername(), vendor.getCompany(), vendor.getAddress());
    }

    public void updateVendor(final Vendor vendor) {
        this.updateUser(vendor);
        final String sql = "set vendor company=?, address=? where v_username=?;";
        this.jdbcTemplate.update(sql, vendor.getCompany(), vendor.getAddress(), vendor.getUsername());
    }

    public Optional<Vendor> getVendor(final String username) {
        final List<Vendor> vendor = this.jdbcTemplate.query("select * from vendor where vendor.v_username = ?", new Object[] {username}, new VendorMapper());
        return vendor.stream().findAny();
    }

    public List<Vendor> getVendors() {
        return this.jdbcTemplate.query("select * from vendor", new VendorMapper());
    }
}
