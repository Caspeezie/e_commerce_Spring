package com.ecommerce.service.customer;

import com.ecommerce.data.model.Customer;
import com.ecommerce.data.model.Order;
import com.ecommerce.data.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService = new CustomerServiceImpl();

    Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
    }

    @Test
    void testThatWeCanCallTheSaveCustomerRepository () {
        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.saveCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testThatWecanCallTheFindCustomerByIdRespository () {
        when(customerRepository.findById(2)).thenReturn(Optional.of(customer));
        customerService.findByCustomerId(2);
        verify(customerRepository, times(1)).findById(2);
    }

    @Test
    void testThatWeCanCallTheFindAllCustomerRepository () {
        List<Customer> customerList = new ArrayList<>();

        when(customerRepository.findAll()).thenReturn(customerList);
        customerService.findAllCustomer();
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testThatWeCanCallTheDeleteCustomerById () {
        doNothing().when(customerRepository).deleteById(2);
        customerService.deleteCustomerById(2);
        verify(customerRepository, times(1)).deleteById(2);
    }

    @Test
    void testThatWeCanCallTheUpdateCustomer () {
        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.updateCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }


}