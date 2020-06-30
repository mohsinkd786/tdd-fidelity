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

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }
}
