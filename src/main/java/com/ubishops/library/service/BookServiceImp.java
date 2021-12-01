package com.ubishops.library.service;

import com.ubishops.library.entity.Book;
import com.ubishops.library.entity.BorrowInfo;
import com.ubishops.library.interfase.dao.BookDAO;
import com.ubishops.library.interfase.dao.BorrowDAO;
import com.ubishops.library.interfase.dao.LikedBookDAO;
import com.ubishops.library.interfase.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceImp implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BorrowDAO borrowDAO;

    @Autowired
    private LikedBookDAO likedBookDAO;

    @Override
    public List<Book> findAllBooks() {

        return bookDAO.selectAllBooks();
    }

    @Override
    public List<Book> findAllBooksByCategory(String category) {

        List<Book> ret = new ArrayList<Book>();
        List<Book> searchRst = bookDAO.selectAllBooks();
        for (Book book : searchRst) {
            if (book.getCategory().equals(category)) {
                ret.add(book);
            }
        }
        return ret;
    }

    @Override
    public List<Book> searchBooksByKeyWords(String... keywords) {

        List<Book> ret = new ArrayList<Book>();
        List<Book> searchRst = bookDAO.selectAllBooks();
        for (Book book : searchRst) {
            for (String keyword : keywords) {
                if (book.getName().contains(keyword)) {
                    ret.add(book);
                }
            }
        }
        return ret;
    }

    @Override
    public void addNewBookInfo(Book bookInfo) {

        bookDAO.insertBookInfo(bookInfo);
    }

    @Override
    public void updateBookInfo(Book bookInfo) {

        bookDAO.updateBookInfo(bookInfo);
    }

    @Override
    public List<Book> findAllLikedBooksByUser(String userId) {

        List<Book> rst = new ArrayList<Book>();
        List<String> isbns = likedBookDAO.selectAllLikedBooks(userId);
        for (String isbn : isbns) {
            rst.add((Book) bookDAO.selectBookByISBN(isbn));
        }
        return rst;
    }

    @Override
    public void addNewLikedBooks(String userId, String isbn) {

        likedBookDAO.insertLikedBook(userId, isbn);
    }

    @Override
    public void removeLikedBooks(String userId, String isbn) {

        likedBookDAO.deleteLikedBook(userId, isbn);
    }

    @Override
    public List<BorrowInfo> findAllBorrowInfo() {

        return borrowDAO.selectAllBorrowBookInfo();
    }

    @Override
    public List<BorrowInfo> findBorrowInfoByStatus(int status) {

        List<BorrowInfo> rst = new ArrayList<BorrowInfo>();
        List<BorrowInfo> searchRst = borrowDAO.selectAllBorrowBookInfo();
        for (BorrowInfo info : searchRst) {
            if (info.getStatus() == status) {
                rst.add(info);
            }
        }
        return rst;
    }

    @Override
    public List<BorrowInfo> findBorrowInfoByBook(String isbn) {

        List<BorrowInfo> rst = new ArrayList<BorrowInfo>();
        List<BorrowInfo> searchRst = borrowDAO.selectAllBorrowBookInfo();
        for (BorrowInfo info : searchRst) {
            if (info.getIsbn().equals(isbn)) {
                rst.add(info);
            }
        }
        return rst;
    }

    @Override
    public void addNewBorrowInfo(BorrowInfo borrowInfo) {

        borrowDAO.insertBorrowBookInfo(borrowInfo);
    }

    @Override
    public void modifyBorrowInfo(BorrowInfo borrowInfo) {

        borrowDAO.updateBorrowBookInfo(borrowInfo);
    }
}
