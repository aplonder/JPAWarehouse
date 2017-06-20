package andrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long bookId) {
        return bookRepository.findOne(bookId);
    }

    public Iterable<Book> findByBookTitle(String bookTitle) {
        return bookRepository.findByBookTitle(bookTitle);
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void delete(Long bookId) {
        bookRepository.delete(bookId);
    }

}
