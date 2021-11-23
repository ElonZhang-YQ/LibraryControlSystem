package com.ubishops.library.interfase.dao;

import java.util.List;

/**
 * This class created on 11/22/2021
 *
 * UserDAO includes:
 *
 * 1. Select single user for login
 * 2. Users have 2 different type, so check is student or teacher.
 *
 * @author Elon.Zhang
 */
public interface UserDAO<T> {
    
    /*
        select all users whatever teachers or students
     */
    List<T> selectAllUsers();
    
    /*
        select single type of users, students for 1, teachers for 0;
     */
    List<T> selectAllUsersByType(int type);
    
}
