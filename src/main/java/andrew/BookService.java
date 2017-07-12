package andrew;

import andrew.dto.BookDTO;
import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void create(/*Long id,*/ BookDTO.FormDTO formDTO) {
        Book book = new Book();                                     // id ????
        book.setTitle(formDTO.title);                               // walidacja ???
        book.setAuthor(formDTO.author);
        bookRepository.save(book);
    }

    public void update(Long id, BookDTO.FormDTO formDTO) {
        Book savedBook = Optional.ofNullable(bookRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        savedBook.setTitle(formDTO.title);
        savedBook.setAuthor(formDTO.author);
        bookRepository.save(savedBook);
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }

}
