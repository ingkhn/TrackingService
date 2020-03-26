package de.telran.controller;

import de.telran.dto.CustomerDTO;
import de.telran.model.entity.Customer;
import de.telran.service.impl.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CustomerController {
    private CustomerServiceImpl service;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerServiceImpl service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDto) {
        return ResponseEntity.ok()
                .body(convertCustomerToCustomerDto(service
                        .createCustomer(convertCustomerDtoToCustomer(customerDto))));
    }

    private Customer convertCustomerDtoToCustomer(CustomerDTO customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    private CustomerDTO convertCustomerToCustomerDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
