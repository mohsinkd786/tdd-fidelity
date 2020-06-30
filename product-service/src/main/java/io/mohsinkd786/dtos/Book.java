package io.mohsinkd786.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String title;
    private String author;

    public Book(String s, String s1) {
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }

    public Object getAuthor() {
        return author;
    }

    public Object getTitle() {
        return title;
    }
}
