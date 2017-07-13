package andrew.repository;

import andrew.model.Author;
import andrew.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Iterable<Book> findByTitleLike(@Param("title") String title);

    Iterable<Book> findByAuthor(Author author);

    Optional<Book> findOneByTitle(@Param("title") String title);


}
