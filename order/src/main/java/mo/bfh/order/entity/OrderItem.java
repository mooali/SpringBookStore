package mo.bfh.order.entity;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Valid
    @Embedded
    private BookInfo book;
    @NotNull
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(BookInfo book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public BookInfo getBook() {
        return book;
    }

    public void setBook(BookInfo book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
