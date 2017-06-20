package andrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }
}
