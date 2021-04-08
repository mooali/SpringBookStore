package mo.bfh.catalog.repository;

import mo.bfh.catalog.entity.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static mo.bfh.catalog.repository.BookSpecifications.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findBookByIsbn() {
        Optional<Book> optionalBook = repository.findByIsbn("9781484228074");
        assertTrue(optionalBook.isPresent());
    }

    @Test
    public void findBookById() {
        Optional<Book> optionalBook = repository.findById(1L);
        assertTrue(optionalBook.isPresent());
    }

    @Test
    public void findBySpecification() {
        List<Book> books = repository.findAll((Sort) contains("Spring"));
        assertEquals(1, books.size());
    }

    @Test
    public void saveBookWithSameIsbn() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            Book anotherBook = new Book();
            anotherBook.setTitle("Spring in Action");
            anotherBook.setIsbn("9781484228074");
            anotherBook.setAuthors("Craig Walls");
            anotherBook.setPrice(new BigDecimal("66.95"));
            repository.saveAndFlush(anotherBook);
        });
    }

    @Test
    public void saveBookWithoutIsbn() {
        assertThrows(ConstraintViolationException.class, () -> {
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setIsbn(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    @Disabled
    public void saveBookWithShortIsbn() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setIsbn("123");
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutTitle() {
        assertThrows(ConstraintViolationException.class, () -> {
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setTitle(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutAuthors() {
        assertThrows(ConstraintViolationException.class, () -> {
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setAuthors(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithoutPrice() {
        assertThrows(ConstraintViolationException.class, () -> {
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setPrice(null);
            repository.saveAndFlush(book);
        });
    }

    @Test
    public void saveBookWithLongDescription() {
        assertThrows(ConstraintViolationException.class, () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2002; i++) {
                sb.append(i);
            }
            Optional<Book> optionalBook = repository.findById(1L);
            assertTrue(optionalBook.isPresent());

            Book book = optionalBook.get();
            book.setDescription(sb.toString());
            repository.saveAndFlush(book);
        });
    }
}
