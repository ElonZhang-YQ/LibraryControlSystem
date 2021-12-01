package com.ubishops.library.dao;

import com.ubishops.library.interfase.dao.LikedBookDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikedBookDAOImp implements LikedBookDAO {
    @Override
    public List selectAllLiedBooks() {
        return null;
    }

    @Override
    public void insertLikedBook(String snumber, String isbn) {

    }

    @Override
    public void deleteLikedBook(String snumber, String isbn) {

    }
}
