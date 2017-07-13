package andrew.dto;

import andrew.model.Chapter;

public class ChapterDTO {

    public static class FormDTO {
        public int chapterNumber;
        public String name;
        public int pageNumber;
        public BookDTO.MinimalItem book;

    }

    public static class MinimalItem {
        public long id;

        public MinimalItem(Chapter chapter) {
            this.id = chapter.getId();
        }
    }

    public static class ListItem extends MinimalItem {
        public int chapterNumber;
        public String name;
        public int pageNumber;

        public ListItem(Chapter chapter) {
            super(chapter);
            this.chapterNumber = chapter.getChapterNumber();
            this.name = chapter.getName();
            this.pageNumber = chapter.getPageNumber();
        }

    }

    public static class FullItem extends ListItem {
        public BookDTO.MinimalItem book;

        public FullItem(Chapter chapter) {
            super(chapter);
            this.book = new BookDTO.MinimalItem(chapter.getBook());
        }
    }

}
