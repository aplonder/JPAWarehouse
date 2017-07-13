package andrew.controller;

import andrew.dto.ChapterDTO;
import andrew.model.Chapter;
import andrew.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/chapter")
public class ChapterController {

    @Autowired
    public ChapterService chapterService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ChapterDTO.FullItem> create(@RequestBody ChapterDTO.FormDTO chapterDTO) {
        Chapter chapter = chapterService.create(chapterDTO);
        return new ResponseEntity<>(new ChapterDTO.FullItem(chapter), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ChapterDTO.FullItem> update(@PathVariable(value = "id") Long id, @RequestBody ChapterDTO.FormDTO chapterDTO) {
        Chapter savedChapter = chapterService.update(id, chapterDTO);
        return new ResponseEntity<>(new ChapterDTO.FullItem(savedChapter), HttpStatus.OK);
    }

    @RequestMapping(value = "/id", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        chapterService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Chapter> findAll() {
        return chapterService.findAll();
    }

}
