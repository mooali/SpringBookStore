package mo.bfh.catalog.repository;

import mo.bfh.catalog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    Optional<Book> findByIsbn(String isbn);
}
