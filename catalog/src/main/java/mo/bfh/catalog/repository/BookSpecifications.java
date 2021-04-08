package mo.bfh.catalog.repository;

import mo.bfh.catalog.entity.Book;
import mo.bfh.catalog.entity.Book_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.stream.IntStream;

public class BookSpecifications {

    public static Specification<Book> contains(String keywords) {
        return (root, query, cb) -> {
            String[] words = keywords.toLowerCase().split("\\s+");
            Predicate[] predicates = new Predicate[words.length];
            IntStream.range(0, words.length).forEach(i -> predicates[i] = contains(root, cb, words[i]));
            return cb.and(predicates);
        };
    }

    private static Predicate contains(Root<Book> root, CriteriaBuilder cb, String keyword) {
        return cb.or(contains(root, cb, Book_.authors, keyword),
                contains(root, cb, Book_.title, keyword),
                contains(root, cb, Book_.publisher, keyword));
    }

    private static Predicate contains(Root<Book> root, CriteriaBuilder cb,
                                      SingularAttribute<Book, String> field, String keyword) {
        return cb.like(cb.lower(root.get(field)), "%" + keyword + "%");
    }
}
