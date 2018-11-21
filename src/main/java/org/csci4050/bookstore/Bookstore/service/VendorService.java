package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.VendorDao;
import org.csci4050.bookstore.Bookstore.exceptions.DatabaseException;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.NoSuchElementException;
import java.util.Optional;

public class VendorService {

    private VendorDao vendorDao;

    @Autowired
    public VendorService(final VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }

    public Vendor registerVendor(final Vendor vendor) throws DatabaseException {
        vendorDao.createVendor(vendor);
        try {
            return vendorDao.getVendor(vendor.getUsername()).get();
        } catch (final DataAccessException | NoSuchElementException e) {
            throw new DatabaseException("Database failed to register vendor with username <%s>", vendor.getUsername());
        }
    }

    public Optional<Vendor> getVendor(final String vUsername) {
        return vendorDao.getVendor(vUsername);
    }
}
