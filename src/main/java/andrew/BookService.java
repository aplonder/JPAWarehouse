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

    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    public Iterable<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }

}
