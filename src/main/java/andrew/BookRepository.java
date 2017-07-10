package andrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByTitleLike(@Param("title") String title);

    Iterable<Book> findByAuthor(Author author);

    Optional<Book> findOneByTitle(@Param("title") String title);


}
