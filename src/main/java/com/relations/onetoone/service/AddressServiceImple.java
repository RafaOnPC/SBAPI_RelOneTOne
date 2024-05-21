package com.relations.onetoone.service;

import com.relations.onetoone.model.Address;
import com.relations.onetoone.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImple implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(Long idAddress) {
        return addressRepository.findById(idAddress).get();
    }

    @Override
    public List<Address> getAddress() {
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }

    @Override
    public Address updateAddress(Long idAddress, Address address) {
        Address addressSearch = addressRepository.findById(idAddress).get();
        addressSearch.setIdAddress(address.getIdAddress());
        addressSearch.setCity(address.getCity());
        addressSearch.setStreet(address.getStreet());
        return addressRepository.save(addressSearch);
    }

    @Override
    public Address deleteAddress(Long idAddress) {
        Address addressSearch = addressRepository.findById(idAddress).get();
        addressRepository.deleteById(idAddress);
        return addressSearch;
    }
}
