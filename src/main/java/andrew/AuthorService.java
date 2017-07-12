package andrew;

import andrew.dto.AuthorDTO;
import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id);
    }

    public Optional<Author> findByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public boolean isAuthorExist(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName).isPresent();
    }


    public Iterable<Author> search(String query) {
        return authorRepository.findByFirstNameOrLastName(query, query);
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void create(AuthorDTO.FormDTO formDTO) {
        Author author = new Author();
        author.setFirstName(formDTO.firstName);
        author.setLastName(formDTO.lastName);
        authorRepository.save(author);
    }

    public void update(Long id, AuthorDTO.FormDTO formDTO) {
        Author savedAuthor = Optional.ofNullable(authorRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        savedAuthor.setFirstName(formDTO.firstName);
        savedAuthor.setLastName(formDTO.lastName);
        authorRepository.save(savedAuthor);
    }

    public void delete(Long id) {
        authorRepository.delete(id);
    }

}
