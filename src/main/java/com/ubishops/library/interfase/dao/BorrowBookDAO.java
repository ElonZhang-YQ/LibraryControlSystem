package com.ubishops.library.interfase.dao;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * BorrowBookDao includes:
 *
 * 1. select all borrow book info
 * 2. update the borrow book info
 * 3. add a new borrow book info
 *
 * @author Elon.Zhang
 */
public interface BorrowBookDAO<T> {

    List<T> selectAllBorrowBookInfo();
    
    void updateBorrowBookInfo(T t);
    
    void insertBorrowBookInfo(T t);
}
