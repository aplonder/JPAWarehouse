package andrew.service;

import andrew.model.Author;
import andrew.model.Book;
import andrew.repository.AuthorRepository;
import andrew.repository.BookRepository;
import andrew.dto.BookDTO;
import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
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

    public Book create(BookDTO.FormDTO formDTO) {
        Book book = new Book();
        book.setTitle(formDTO.title);
        book.setAuthor(authorRepository.findById(formDTO.author.id));
        return bookRepository.save(book);
    }

    public Book update(Long id, BookDTO.FormDTO formDTO) {
        Book savedBook = Optional.ofNullable(bookRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        savedBook.setTitle(formDTO.title);
        savedBook.setAuthor(authorRepository.findById(formDTO.author.id));
        return bookRepository.save(savedBook);
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }

}
