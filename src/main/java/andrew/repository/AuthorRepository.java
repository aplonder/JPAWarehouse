package andrew.repository;

import andrew.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {

    Author findById(Long id);


    Iterable<Author> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                               @Param("lastName") String lastName);


    Optional<Author> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

}
