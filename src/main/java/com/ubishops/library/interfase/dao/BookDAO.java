package com.ubishops.library.interfase.dao;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * BookDAO includes:
 *
 * 1. select all books
 * 2. update books info
 * 3. remove book
 * 4. add a new book to system
 *
 * @author Elon.Zhang
 */
public interface BookDAO<T> {
    
    List<T> selectAllBooks();

    T selectBookByISBN(String isbn);
    
    void updateBookInfo(T t);
    
    void deleteBook(String isbn);
    
    void insertBookInfo(T t);

}
