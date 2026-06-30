package com.customer.service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public Optional<Customer> findById(Long id) {
        return repo.findById(id);
    }

    public List<Customer> findAll() {
        return repo.findAll();
    }

    public Customer update(Long id, Customer updated) {
        return repo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
