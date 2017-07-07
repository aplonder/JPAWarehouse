package andrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return authorService.findById(id);
    }

//    @RequestMapping(value = "/findByFirstNameOrLastName/", method = RequestMethod.GET)
//    public Iterable<Author> findByFirstNameOrLastName(@RequestParam(value = "firstName") String firstName,
//                                                      @RequestParam(value = "lastName") String lastName) {
//        return authorService.findByFirstNameOrLastName(firstName, lastName);
//    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public Iterable<Author> search(@RequestParam(value = "query") String query) {
        return authorService.search(query);
    }

    @RequestMapping(value = "/{id}/book/", method = RequestMethod.GET)
    public Iterable<Book> findByAuthor(@PathVariable(value = "id") Long id) {
        Author author = authorService.findById(id);
        return bookService.findByAuthor(author);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") Long id, @RequestBody Author author) {
        authorService.update(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        authorService.delete(id);
    }

}
