package com.ubishops.library.entity;

import java.util.Objects;

/**
 * This class created on 11/22/2021
 *
 * @author Elon.Zhang
 */
public class User {

    private String name;
    
    private String gender;
    
    private String id;
    
    private String phone;
    
    private String email;
    
    private String password;
    
    // 0 for student; 1 for manager/teacher;
    private int type;
    
    public User() {
    
    }
    
    public User(String name, String gender, String id, String phone, String email, String password, int type) {
        
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getGender() {
        
        return gender;
    }
    
    public void setGender(String gender) {
        
        this.gender = gender;
    }
    
    public String getId() {
        
        return id;
    }
    
    public void setId(String id) {
        
        this.id = id;
    }
    
    public String getPhone() {
        
        return phone;
    }
    
    public void setPhone(String phone) {
        
        this.phone = phone;
    }
    
    public String getEmail() {
        
        return email;
    }
    
    public void setEmail(String email) {
        
        this.email = email;
    }
    
    public String getPassword() {
        
        return password;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    public int getType() {
        
        return type;
    }
    
    public void setType(int type) {
        
        this.type = type;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return gender == user.gender && type == user.type && Objects.equals(name, user.name) && Objects.equals(id, user.id) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(name, gender, id, phone, email, password, type);
    }
}
