package andrew.repository;

import andrew.model.Book;
import andrew.model.Chapter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends PagingAndSortingRepository<Chapter, Long> {

//    Iterable<Chapter> findByBook(Book book);
//
//    Iterable<Chapter> findAll(Chapter chapter);
}
