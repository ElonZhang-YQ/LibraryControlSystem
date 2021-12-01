package com.ubishops.library.interfase.service;

import com.ubishops.library.entity.Book;
import com.ubishops.library.entity.BorrowInfo;
import com.ubishops.library.entity.LikedBook;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public interface BookService {
    
    // <-- Books Information -->
    
    List<Book> findAllBooks();
    
    List<Book> findAllBooksByCategory(String category);
    
    List<Book> searchBooksByKeyWords(String... keywords);
    
    void addNewBookInfo(Book bookInfo);
    
    void updateBookInfo(Book bookInfo);
    
    
    // <-- Liked Bookes Information -->
    
    /**
     *
     * @return liked books isbn
     */
    List<Book> findAllLikedBooksByUser(String userId);
    
    void addNewLikedBooks(String userId, String isbn);
    
    void removeLikedBooks(String userId, String isbn);
    
    
    // <-- Borrow Book Information -->
    
    List<BorrowInfo> findAllBorrowInfo();
    
    List<BorrowInfo> findBorrowInfoByStatus(int status);
    
    List<BorrowInfo> findBorrowInfoByBook(String isbn);
    
    void addNewBorrowInfo(BorrowInfo borrowInfo);
    
    void modifyBorrowInfo(BorrowInfo borrowInfo);

}
