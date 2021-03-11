package mo.bfh.catalog.repository;

import mo.bfh.catalog.entity.Book;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookRepositoryIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepositoryIT.class);

    @Autowired
    private BookRepository repository;

    @Test
    @Transactional
    public void save() {
        Book book = new Book();
        book.setTitle("Spring in Action");
        book.setIsbn("1617294942");
        book.setAuthors("Craig Walls");
        book.setPrice(new BigDecimal("66.95"));

        book = repository.saveAndFlush(book);
        assertNotNull(book.getId());

        book = repository.findById(book.getId()).get();
        assertNotNull(book);
    }
}