package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.ShippingAddressDao;
import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShippingAddressService {

    private ShippingAddressDao shippingAddressDao;

    @Autowired
    public ShippingAddressService(final ShippingAddressDao shippingAddressDao) {
        this.shippingAddressDao = shippingAddressDao;
    }

    public Optional<ShippingAddress> getShippingAddress(final int addressId) {
        return shippingAddressDao.getShippingAddress(addressId);
    }
}
