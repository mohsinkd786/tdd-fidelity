package io.mohsinkd786.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookCatalog {

    private List<Book> books;

    @Override
    public String toString() {
        return "BookCatalog [books=" + books + "]";
    }
}
