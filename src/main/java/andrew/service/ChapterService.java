package andrew.service;

import andrew.dto.ChapterDTO;
import andrew.model.Chapter;
import andrew.repository.BookRepository;
import andrew.repository.ChapterRepository;
import andrew.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private BookRepository bookRepository;

    public Chapter create(ChapterDTO.FormDTO formDTO) {
        Chapter chapter = new Chapter();
        chapter.setChapterNumber(formDTO.chapterNumber);
        chapter.setName(formDTO.name);
        chapter.setPageNumber(formDTO.pageNumber);
        chapter.setBook(bookRepository.findOne(formDTO.book.id));
        return chapterRepository.save(chapter);
    }

    public Chapter update(Long id, ChapterDTO.FormDTO formDTO) {
        Chapter savedChapter = Optional.ofNullable(chapterRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        savedChapter.setChapterNumber(formDTO.chapterNumber);
        savedChapter.setName(formDTO.name);
        savedChapter.setPageNumber(formDTO.pageNumber);
        savedChapter.setBook(bookRepository.findOne(formDTO.book.id));
        return chapterRepository.save(savedChapter);
    }

    public void delete(Long id) {
        chapterRepository.delete(id);
    }

    public Iterable<Chapter> findAll() {
        return chapterRepository.findAll();
    }
}
