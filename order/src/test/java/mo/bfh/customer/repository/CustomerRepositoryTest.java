package mo.bfh.customer.repository;


import mo.bfh.customer.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findByEmail(){
        Optional<Customer> customerOptional = customerRepository.findByEmail("john.doe@gmail.com");
        assertTrue(customerOptional.isPresent());
    }



}
