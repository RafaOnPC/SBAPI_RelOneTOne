package com.relations.onetoone.service;

import com.relations.onetoone.model.Address;
import com.relations.onetoone.model.Persona;
import com.relations.onetoone.repository.AddressRepository;
import com.relations.onetoone.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImple implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Address saveAddress(Address address) {

        // Crear persona y guardar en bd
        Persona per = new Persona();
        per.setIdPersona(address.getPersona().getIdPersona());
        per.setName(address.getPersona().getName());
        per.setAddress(null);
        Persona savedPersona = personaRepository.save(per);

        // Crear la instancia de Address y establecer la relación bidireccional
        Address ad = new Address();
        ad.setCity(address.getCity());
        ad.setStreet(address.getStreet());
        ad.setPersona(savedPersona);
        Address savedAddress = addressRepository.save(ad);

        per.setAddress(savedAddress);
        personaRepository.save(per);

        // Retornar la instancia de Address guardada
        return savedAddress;
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

        Address ad = addressRepository.findById(idAddress).get();
        //System.out.println("ad = " + ad);
        //Recuperacion de id persona
        Long idPersona = ad.getPersona().getIdPersona();
        System.out.println("idPersona = " + idPersona);

        //Setear la direccion
        ad.setIdAddress(address.getIdAddress());
        ad.setStreet(address.getStreet());
        ad.setCity(address.getCity());
        ad.setPersona(null);
        //guardo la direccion
        Address addressSaved = addressRepository.save(ad);

        //Seter la persona
            //Recuperar a la persona
        Persona per = personaRepository.findById(idPersona).get();
        per.setIdPersona(idPersona);
        per.setName(address.getPersona().getName());
        per.setAddress(addressSaved);

        //guardar
        Persona p = personaRepository.save(per);

        //pasar relacion bi a direccion
        ad.setPersona(p);
        Address newAddress = addressRepository.save(ad);

        //guardar direccion
        return newAddress;

    }


    @Override
    public Address deleteAddress(Long idAddress) {
        Address addressSearch = addressRepository.findById(idAddress).get();
        addressRepository.deleteById(idAddress);
        return addressSearch;
    }
}
