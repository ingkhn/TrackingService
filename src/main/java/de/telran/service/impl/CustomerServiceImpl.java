package de.telran.service.impl;

import de.telran.model.entity.Customer;
import de.telran.repository.CustomerRepository;
import de.telran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = repository.save(customer);
        return savedCustomer;
    }
}
