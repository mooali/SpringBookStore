package mo.bfh.order.entity;

import mo.bfh.customer.entity.Address;
import mo.bfh.customer.entity.CreditCard;
import mo.bfh.customer.entity.Customer;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salesorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private BigDecimal amount;
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(optional = false)
    private Customer customer;

    @Valid
    @Embedded
    private Address address;
    @Valid
    @Embedded
    private CreditCard creditCard;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime date, BigDecimal amount, OrderStatus status, Customer customer, List<OrderItem> items) {
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.customer = customer;
        this.address = customer.getAddress();
        this.creditCard = customer.getCreditCard();
        this.items = items;
    }

    public Long getId() {
        return id;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
