package andrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository <Author, Long> {

    Author findById(Long id);


    Iterable<Author> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                               @Param("lastName") String lastName);


    Optional<Author> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);


}
