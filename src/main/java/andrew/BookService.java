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

    public Iterable<Book> search(String query) {
        return bookRepository.findByTitleLike("%" + query + "%");
    }

    public Iterable<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    public boolean isBookExist(String title) {
        return bookRepository.findOneByTitle(title).isPresent();
    }

    public void save(Book book) {
        bookRepository.save(book);
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
