package andrew;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Book findById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.findById(bookId);
    }

    @RequestMapping(value = "/{bookTitle}", method = RequestMethod.GET)
    public Iterable<Book> findByBookTitle(@PathVariable(value = "bookTitle") String bookTitle) {
        return bookService.findByBookTitle(bookTitle);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "bookId") Long bookId, @RequestBody Book book) {
        bookService.update(book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "bookId") Long bookId) {
        bookService.delete(bookId);
    }

}
