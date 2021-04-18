package mo.bfh.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface OrderInfo {

    Long getId();

    LocalDateTime getDate();

    BigDecimal getAmount();

    OrderStatus geStatus();

}
