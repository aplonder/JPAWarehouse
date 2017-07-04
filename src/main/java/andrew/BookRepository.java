package andrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByTitle(String title);

    Iterable<Book> findByAuthor(Author author);

}
