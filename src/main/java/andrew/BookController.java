package andrew;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable(value = "id") Long id) {
        return bookService.findById(id);
    }

    @RequestMapping(value = "/findByTitle/{title}", method = RequestMethod.GET)
    public Iterable<Book> findByTitle(@PathVariable(value = "title") String title) {
        return bookService.findByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") Long id, @RequestBody Book book) {
        bookService.update(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        bookService.delete(id);
    }

}
