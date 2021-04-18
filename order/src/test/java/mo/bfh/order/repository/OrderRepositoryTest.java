package mo.bfh.order.repository;

import mo.bfh.order.entity.Order;
import mo.bfh.order.entity.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void findAllByCustomerIdAndDateBetween(){
        List<OrderInfo> orders = orderRepository.findAllByCustomerIdAndDateBetween(1001L,
                LocalDateTime.now().minusMonths(10), LocalDateTime.now());
        assertEquals(1, orders.size());

    }

    @Test
    void findAllByCustomerId(){
        orderRepository.findAllByCustomerId(1001L,PageRequest.of(0,10));
    }


}
