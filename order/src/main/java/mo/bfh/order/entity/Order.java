package mo.bfh.order.entity;

import mo.bfh.customer.entity.Address;
import mo.bfh.customer.entity.CreditCard;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @NotNull
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Valid
    @Embedded
    private Address address;
    @Valid
    @Embedded
    private CreditCard creditCard;


    public Order() {
    }

    public Order(LocalDateTime date, BigDecimal amount, OrderStatus orderStatus, @Valid Address address, @Valid CreditCard creditCard) {
        this.date = date;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.address = address;
        this.creditCard = creditCard;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
