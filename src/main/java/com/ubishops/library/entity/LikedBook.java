package com.ubishops.library.entity;

import java.util.Objects;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public class LikedBook {
    
    // student number;
    private String s_number;
    
    private String isbn;

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LikedBook() {
    }

    public LikedBook(String s_number, String isbn) {
        
        this.s_number = s_number;
        this.isbn = isbn;
    }
    
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikedBook likedBook = (LikedBook) o;
        return Objects.equals(s_number, likedBook.s_number) && Objects.equals(isbn, likedBook.isbn);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(s_number, isbn);
    }
}
