package com.ubishops.library.interfase.dao;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * LikedBookDao includes:
 *
 * 1. select all liked books from database.
 * 2. add a new liked book to database.
 * 3. remove a liked book from database.
 *
 * @author Elon.Zhang
 */
public interface LikedBookDAO<T> {
    
    List<T> selectAllLikedBooks(String userId);
    
    void insertLikedBook(String snumber, String isbn);
    
    void deleteLikedBook(String snumber, String isbn);
    
}
