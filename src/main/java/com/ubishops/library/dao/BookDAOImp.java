package com.ubishops.library.dao;

import com.ubishops.library.constant.SQLConstant;
import com.ubishops.library.entity.Book;
import com.ubishops.library.interfase.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAOImp implements BookDAO<Book> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> selectAllBooks() {

        List<Book> books = jdbcTemplate.query(SQLConstant.QUERRY_ALL_BOOKS, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setDate(rs.getString("date"));
                book.setCategory(rs.getString("category"));
                book.setAmount(rs.getInt("amount"));
                book.setCamount(rs.getInt("c_amount"));
                return book;
            }
        });
        return books;
    }

    @Override
    public Book selectBookByISBN(String isbn) {

        List<Book> searchRst = selectAllBooks();
        for (Book book : searchRst) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<String> selectAllCategory() {

        List<String> categories = jdbcTemplate.query(SQLConstant.QUERRY_BOOK_CATEGORY, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("category");
            }
        });

        return categories;
    }

    @Override
    public void updateBookInfo(Book book) {

        jdbcTemplate.update(SQLConstant.MODIFY_BOOK_INFO, book.getName(), book.getAuthor(), book.getDate(), book.getCategory(), book.getAmount(), book.getCamount(), book.getIsbn());
    }

    @Override
    public void deleteBook(String isbn) {

        jdbcTemplate.update(SQLConstant.REMOVE_BOOK, isbn);
    }

    @Override
    public void insertBookInfo(Book book) {

        jdbcTemplate.update(SQLConstant.INSERT_BOOK_INFO, book.getName(), book.getIsbn(), book.getAuthor(), book.getDate(), book.getCategory(), book.getAmount(), book.getCamount());
    }
}
