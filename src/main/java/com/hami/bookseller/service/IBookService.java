package com.hami.bookseller.service;

import com.hami.bookseller.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBook();
}
