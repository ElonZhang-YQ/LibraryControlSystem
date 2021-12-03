package com.ubishops.library.dao;

import com.ubishops.library.constant.SQLConstant;
import com.ubishops.library.entity.User;
import com.ubishops.library.interfase.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImp implements UserDAO<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> selectAllUsers() {

        List<User> users = jdbcTemplate.query(SQLConstant.QUERRY_ALL_USERS, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getInt("gender"));
                user.setId(rs.getString("id"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setPicture(rs.getString("picture"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getInt("type"));
                return user;
            }
        });
        return users;
    }

    @Override
    public List<User> selectAllUsersByType(int type) {

        List<User> rst = new ArrayList<User>();
        List<User> searchRst = selectAllUsers();
        for (User user : searchRst) {
            if (user.getType() == type) {
                rst.add(user);
            }
        }
        return rst;
    }
}
