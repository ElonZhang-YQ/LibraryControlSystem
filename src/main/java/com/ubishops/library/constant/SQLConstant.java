package com.ubishops.library.constant;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public class SQLConstant {

    /*
        USER SQL
     */
    public static String QUERRY_ALL_USERS = "select * from user";

    public static String QUERRY_USER_IN_TYP = "select * from user where type = ?";

    /*
        BOOK SQL
     */
    public static String QUERRY_ALL_BOOKS = "select * from book";

    public static String QUERRY_BOOKS_IN_ISBN = "select * from book where isbn = ?";

    public static String MODIFY_BOOK_INFO = "update book set name=?, author=?, date=?, category=?, amount=?, c_amount=? where isbn=?";

    public static String REMOVE_BOOK = "delete from book where isbn=?";

    public static String INSERT_BOOK_INFO = "insert into book(name, isbn, author, date, category, amount, c_amount) values(?,?,?,?,?,?,?)";

    public static String QUERRY_BOOK_CATEGORY = "select distinct category from book";

    /*
        BORROW BOOK SQL
     */

    public static String QUERRY_ALL_BORROW_INFO = "select * from borrowinfo";

    public static String MODIFY_BORROW_INFO = "update borrowinfo set isbn=?, book_name=?, borrow_date=?, return_date=?, status=?, student_number=? where id = ?";

    public static String INSERT_BORROW_INFO = "insert into borrowinfo(id, isbn, book_name, borrow_date, return_date, status, student_number) values(?,?,?,?,?,?,?)";

    /*
        LIKED BOOK SQL
     */

    public static String QUERRY_ALL_LIKED_BOOK_INFO = "select * from liked where student_number = ?";

    public static String INSERT_LIKED_BOOK_INFO = "insert into liked(student_number, isbn) values(?,?)";

    public static String REMOVE_LIKED_BOOK_INFO = "delete from liked where student_number=? and isbn=?";


}
