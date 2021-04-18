package mo.bfh.order.repository;

import mo.bfh.order.entity.Order;
import mo.bfh.order.entity.OrderInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<OrderInfo> findAllByCustomerIdAndDateBetween(Long customerId, LocalDateTime from, LocalDateTime to);

    List<OrderInfo> findAllByCustomerId(Long customerId, Pageable pageable);


}
