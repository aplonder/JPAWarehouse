package andrew;


import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Book findById(@PathVariable(value = "id") Long id) {
//        return bookService.findById(id);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable(value = "id") Long id) {
        return Optional.ofNullable(bookService.findById(id))
                .orElseThrow(EntityNotFoundException::new);
    }


//    @RequestMapping(value = "/findByTitle/{title}", method = RequestMethod.GET)
//    public Iterable<Book> findByTitle(@PathVariable(value = "title") String title) {
//        return bookService.findByTitle(title);
//    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public Iterable<Book> search(@RequestParam(value = "query") String query) {
        return bookService.search(query);
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public void create(@RequestBody Book book) {
//        bookService.create(book);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> create(@RequestBody Book book) {
        if (bookService.isBookExist(book.getTitle())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
