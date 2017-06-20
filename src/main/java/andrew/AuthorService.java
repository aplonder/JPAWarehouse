package andrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void create(Author author) {
        authorRepository.save(author);
    }

}
