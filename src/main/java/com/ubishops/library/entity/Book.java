package com.ubishops.library.entity;

import java.util.Objects;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public class Book {
    
    private String name;
    
    private String isbn;
    
    private String author;
    
    private String date;
    
    private String category;
    
    private int amount;
    
    // current amount
    private int c_amount;
    
    private String picture;
    
    public Book() {
    
    }
    
    public Book(String name, String isbn, String author, String date, String category, int amount, int c_amount, String picture) {
        
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.c_amount = c_amount;
        this.picture = picture;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getIsbn() {
        
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        
        this.isbn = isbn;
    }
    
    public String getAuthor() {
        
        return author;
    }
    
    public void setAuthor(String author) {
        
        this.author = author;
    }
    
    public String getDate() {
        
        return date;
    }
    
    public void setDate(String date) {
        
        this.date = date;
    }
    
    public String getCategory() {
        
        return category;
    }
    
    public void setCategory(String category) {
        
        this.category = category;
    }
    
    public int getAmount() {
        
        return amount;
    }
    
    public void setAmount(int amount) {
        
        this.amount = amount;
    }
    
    public int getCamount() {
        
        return c_amount;
    }
    
    public void setCamount(int camount) {
        
        this.c_amount = c_amount;
    }
    
    public String getPicture() {
        
        return picture;
    }
    
    public void setPicture(String picture) {
        
        this.picture = picture;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return amount == book.amount && c_amount == book.c_amount && Objects.equals(name, book.name) && Objects.equals(isbn, book.isbn) && Objects.equals(author, book.author) && Objects.equals(date, book.date) && Objects.equals(category, book.category) && Objects.equals(picture, book.picture);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(name, isbn, author, date, category, amount, c_amount, picture);
    }
}
