package com.relations.onetoone.controller;

import com.relations.onetoone.model.Address;
import com.relations.onetoone.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAddress(), HttpStatus.OK);
    }

    @GetMapping("/address/{idAddress}")
    public ResponseEntity<Object> getAAddress(@PathVariable Long idAddress){
        return new ResponseEntity<>(addressService.getAddress(idAddress), HttpStatus.OK);
    }

    @PostMapping("/address")
    public ResponseEntity<Object> storeAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("/address/{idAddress}")
    public ResponseEntity<Object> updateAnAddress(@PathVariable Long idAddress, @RequestBody Address address){
        return new ResponseEntity<>(addressService.updateAddress(idAddress, address), HttpStatus.OK);
    }

    @DeleteMapping("/address/{idAddress}")
    public ResponseEntity<Object> deleteAnAddress(@PathVariable Long idAddress){
        return new ResponseEntity<>(addressService.deleteAddress(idAddress), HttpStatus.OK);
    }


}
