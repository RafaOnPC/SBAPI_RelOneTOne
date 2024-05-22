package com.relations.onetoone.service;

import com.relations.onetoone.model.Address;
import com.relations.onetoone.model.Persona;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public Address saveAddress(Address address);

    public Address getAddress(Long idAddress);

    public List<Address> getAddress();

    public Address updateAddress(Long idAddress, Address address);

    public Address deleteAddress(Long idAddress);

}
