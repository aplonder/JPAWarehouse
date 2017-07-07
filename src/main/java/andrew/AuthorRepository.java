package andrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends CrudRepository <Author, Long> {

    Iterable<Author> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                               @Param("lastName") String lastName);

}
