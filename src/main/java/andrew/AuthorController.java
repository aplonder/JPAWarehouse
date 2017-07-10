package andrew;

import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Author> findAll() {
        return authorService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author findById(@PathVariable(value = "id") Long id) {
        return Optional.ofNullable(authorService.findById(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public Iterable<Author> search(@RequestParam(value = "query") String query) {
        return authorService.search(query);
    }

    @RequestMapping(value = "/{id}/book/", method = RequestMethod.GET)
    public Iterable<Book> findByAuthor(@PathVariable(value = "id") Long id) {
        Author author = findById(id);
        return bookService.findByAuthor(author);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Author> create(@RequestBody Author author) {
        if (authorService.isAuthorExist(author.getFirstName(), author.getLastName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> update(@PathVariable(value = "id") Long id, @RequestBody Author author) {
        Author savedAuthor = authorService.findByFirstNameAndLastName(author.getFirstName(),author.getLastName()).orElse(null);
        if (savedAuthor != null && !Objects.equals(savedAuthor.getId(), id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        authorService.delete(id);
    }

}
