package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.VendorDao;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class VendorService {

    private VendorDao vendorDao;

    @Autowired
    public VendorService(final VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }

    public Vendor registerVendor(final Vendor vendor) throws Exception {
        vendorDao.createVendor(vendor);
        final Optional<Vendor> retrievevendor = vendorDao.getVendor(vendor.getUsername());
        if (retrievevendor.isPresent() && retrievevendor.get().equals(vendor)) {
            return retrievevendor.get();
        } else {
            throw new Exception();
        }
    }
}
