package com.ubishops.library.dao;

import com.ubishops.library.interfase.dao.BorrowDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowDAOImp implements BorrowDAO {
    @Override
    public List selectAllBorrowBookInfo() {
        return null;
    }

    @Override
    public void updateBorrowBookInfo(Object o) {

    }

    @Override
    public void insertBorrowBookInfo(Object o) {

    }
}
