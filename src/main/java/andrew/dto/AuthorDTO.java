package andrew.dto;

import andrew.model.Author;

public class AuthorDTO {

    public static class FormDTO {
        public String firstName;
        public String lastName;
    }

    public static class MinimalItem {
        public Long id;

        public MinimalItem() {
        }

        public MinimalItem(Author author){
            this.id = author.getId();
        }
    }
}
