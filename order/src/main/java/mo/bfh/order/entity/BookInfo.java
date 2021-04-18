package mo.bfh.order.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Embeddable
public class BookInfo {

    @NotBlank
    private String isbn;
    @NotBlank
    private String title;
    private String authors;
    @NotNull
    private BigDecimal price;


    public BookInfo() {
    }

    public BookInfo(@NotBlank String isbn, @NotBlank String title, String authors, @NotNull BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
