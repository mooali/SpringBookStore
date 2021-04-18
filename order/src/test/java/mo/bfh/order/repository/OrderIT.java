package mo.bfh.order.repository;

import mo.bfh.customer.entity.Address;
import mo.bfh.customer.entity.CreditCard;
import mo.bfh.customer.entity.CreditCardType;
import mo.bfh.customer.entity.Customer;
import mo.bfh.customer.repository.CustomerRepository;
import mo.bfh.order.entity.BookInfo;
import mo.bfh.order.entity.Order;
import mo.bfh.order.entity.OrderItem;
import mo.bfh.order.entity.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderIT {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    void createCustomerAndSaveOrder() {
        Customer customer = new Customer("Alice", "Smith", "alice@example.org", "alice",
                new Address("123 Maple Street", "Mill Valley", "CA", "90952", "US"),
                new CreditCard(CreditCardType.MASTERCARD,"5400000000000000", 1, 2021));

        customer = customerRepository.saveAndFlush(customer);

        assertNotNull(customer.getId());

        Order order = new Order(LocalDateTime.now(), new BigDecimal("94.98"), OrderStatus.ACCEPTED, customer, createOrderItems());
        order = orderRepository.saveAndFlush(order);

        assertNotNull(order.getId());
    }

    private List<OrderItem> createOrderItems() {
        return Arrays.asList(
                new OrderItem(new BookInfo("1617294942", "Spring in Action", "Craig Walls", new BigDecimal("49.99")), 1),
                new OrderItem(new BookInfo("1617292540", "Spring Boot in Action", "Craig Walls", new BigDecimal("44.99")), 1)
        );
    }
}
