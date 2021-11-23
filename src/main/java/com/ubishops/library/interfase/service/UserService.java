package com.ubishops.library.interfase.service;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public interface UserService<T> {

    List<T> selectAllUsers();
    
    List<T> selectUsersByType(int type);
    
    /*
        id: for student is snumber, for teacher is tnumber;
        if id and password belongs to student, but type is not 1, return null.
        teachers as well
     */
    T selectSingleUsers(String id, String password, int type);
    
}
