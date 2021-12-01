package com.ubishops.library.dao;

import com.ubishops.library.entity.User;
import com.ubishops.library.interfase.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImp implements UserDAO<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> selectAllUsers() {
//        jdbcTemplate.query();
        return null;
    }

    @Override
    public List<User> selectAllUsersByType(int type) {
        return null;
    }
}
