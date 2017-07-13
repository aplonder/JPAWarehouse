package andrew.controller;


import andrew.model.Book;
import andrew.service.BookService;
import andrew.dto.BookDTO;
import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<BookDTO.ListItem> findAll(Pageable pageable) {
        Page<Book> bookPage = bookService.findAll(pageable);
        return new PageImpl<>(
                bookPage.getContent().stream().map(BookDTO.ListItem::new).collect(Collectors.toList()),
                bookPage.nextPageable(),
                bookPage.getTotalPages()
        );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BookDTO.FullItem findById(@PathVariable(value = "id") Long id) {
        Book book =  Optional.ofNullable(bookService.findById(id))
                .orElseThrow(EntityNotFoundException::new);
        return new BookDTO.FullItem(book);
    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public Iterable<Book> search(@RequestParam(value = "query") String query) {
        return bookService.search(query);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BookDTO.FullItem> create(@RequestBody BookDTO.FormDTO bookDTO) {
        Book savedBook = bookService.create(bookDTO);
        return new ResponseEntity<>(new BookDTO.FullItem(savedBook), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable(value = "id") Long id, @RequestBody BookDTO.FormDTO bookDTO) {
        return new ResponseEntity<>(bookService.update(id, bookDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        bookService.delete(id);
    }

}
