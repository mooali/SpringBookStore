package mo.bfh.catalog.repository;

import mo.bfh.catalog.entity.Book;
import mo.bfh.catalog.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    private Book book;

    @BeforeEach
    public void init() {
        book = new Book();
        book.setTitle("Spring in Action");
        book.setIsbn("1617294942");
        book.setAuthors("Craig Walls");
        book.setPrice(new BigDecimal("66.95"));

        book = repository.saveAndFlush(book);
    }

    @Test
    public void findBookById() {
        book = repository.saveAndFlush(book);

        Optional<Book> optionalBook = repository.findById(book.getId());
        assertTrue(optionalBook.isPresent());
    }

    @Test
    public void saveBookWithSameIsbn() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            Book anotherBook = new Book();
            anotherBook.setTitle("Spring in Action");
            anotherBook.setIsbn("1617294942");
            anotherBook.setAuthors("Craig Walls");
            anotherBook.setPrice(new BigDecimal("66.95"));
            repository.saveAndFlush(anotherBook);
        });
    }

    @Test
    public void saveBookWithoutIsbn() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            book.setIsbn(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutTitle() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            book.setTitle(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutAuthors() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            book.setAuthors(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutPrice() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            book.setPrice(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithLongDescription() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            book.setDescription("Spring Framework has been making Java developers more productive and successful for over a dozen years, and it shows no signs of slowing down! Spring in Action, 5th Edition is the fully-updated revision of Manning's bestselling Spring in Action. This new edition includes all Spring 5.0 updates, along with new examples on reactive programming, Spring WebFlux, and microservices. Readers will also find the latest Spring best practices, including Spring Boot for application setup and configuration. Purchase of the print book includes a free eBook in PDF, Kindle, and ePub formats from Manning Publications.");
            repository.saveAndFlush(book);
        });
    }
}