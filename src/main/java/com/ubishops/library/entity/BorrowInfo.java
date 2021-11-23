package com.ubishops.library.entity;

import java.util.Objects;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public class BorrowInfo {
    
    private String id;
    
    private String isbn;
    
    // borrow date
    private String b_date;
    
    // return date
    private String r_date;
    
    // 0 for returned, 1 for not yet
    private int status;
    
    // student number;
    private int s_number;
    
    public BorrowInfo(String id, String isbn, String b_date, String r_date, int status, int s_number) {
        
        this.id = id;
        this.isbn = isbn;
        this.b_date = b_date;
        this.r_date = r_date;
        this.status = status;
        this.s_number = s_number;
    }
    
    public String getId() {
        
        return id;
    }
    
    public void setId(String id) {
        
        this.id = id;
    }
    
    public String getIsbn() {
        
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        
        this.isbn = isbn;
    }
    
    public String getB_date() {
        
        return b_date;
    }
    
    public void setB_date(String b_date) {
        
        this.b_date = b_date;
    }
    
    public String getR_date() {
        
        return r_date;
    }
    
    public void setR_date(String r_date) {
        
        this.r_date = r_date;
    }
    
    public int getStatus() {
        
        return status;
    }
    
    public void setStatus(int status) {
        
        this.status = status;
    }
    
    public int getS_number() {
        
        return s_number;
    }
    
    public void setS_number(int s_number) {
        
        this.s_number = s_number;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowInfo that = (BorrowInfo) o;
        return status == that.status && s_number == that.s_number && Objects.equals(id, that.id) && Objects.equals(isbn, that.isbn) && Objects.equals(b_date, that.b_date) && Objects.equals(r_date, that.r_date);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, isbn, b_date, r_date, status, s_number);
    }
}
