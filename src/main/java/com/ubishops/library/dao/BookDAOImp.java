package com.ubishops.library.dao;

import com.ubishops.library.entity.Book;
import com.ubishops.library.interfase.dao.BookDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAOImp implements BookDAO<Book> {

    @Override
    public List<Book> selectAllBooks() {
        return null;
    }

    @Override
    public Book selectBookByISBN(String isbn) {
        return null;
    }

    @Override
    public void updateBookInfo(Book book) {

    }

    @Override
    public void deleteBook(String isbn) {

    }

    @Override
    public void insertBookInfo(Book book) {

    }
}
