package andrew;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrew on 20.06.17.
 */
public interface AuthorRepository extends CrudRepository <Author, Long> {
}
