package andrew.dto;

import andrew.model.Book;

public class BookDTO {

    public static class FormDTO {
        public String title;
        public AuthorDTO.MinimalItem author;

    }

    public static class MinimalItem {
        public Long id;

        public MinimalItem() {
        }

        public MinimalItem(Book book){
            this.id = book.getId();
        }
    }

    public static class ListItem extends MinimalItem {
        public String title;

        public ListItem(Book book) {
            super(book);
            this.title = book.getTitle();
        }
    }

    public static class FullItem extends ListItem {
        public AuthorDTO.MinimalItem author;

        public FullItem(Book book) {
            super(book);
            this.author = new AuthorDTO.MinimalItem(book.getAuthor());
        }
    }
}
