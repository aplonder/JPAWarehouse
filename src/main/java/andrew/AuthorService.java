package andrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

//    public Iterable<Author> findByFirstNameOrLastName(String firstName, String lastName) {
//        return authorRepository.findByFirstNameOrLastName(firstName, lastName);
//    }

    public boolean isAuthorExist(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName).isPresent();
    }

    public Iterable<Author> search(String query) {
        return authorRepository.findByFirstNameOrLastName(query, query);
    }

    public void create(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.delete(id);
    }

}
