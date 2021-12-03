package com.ubishops.library.dao;

import com.ubishops.library.constant.SQLConstant;
import com.ubishops.library.entity.LikedBook;
import com.ubishops.library.interfase.dao.LikedBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class LikedBookDAOImp implements LikedBookDAO<LikedBook> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LikedBook> selectAllLikedBooks(String userId) {

        List<LikedBook> likedBooks = jdbcTemplate.query(SQLConstant.QUERRY_ALL_LIKED_BOOK_INFO, new RowMapper<LikedBook>() {
            @Override
            public LikedBook mapRow(ResultSet rs, int rowNum) throws SQLException {
                LikedBook liked = new LikedBook();
                liked.setS_number(rs.getString("student_number"));
                liked.setIsbn(rs.getString("isbn"));
                return liked;
            }
        });
        return likedBooks;
    }

    @Override
    public void insertLikedBook(String snumber, String isbn) {

        jdbcTemplate.update(SQLConstant.INSERT_LIKED_BOOK_INFO, snumber, isbn);
    }

    @Override
    public void deleteLikedBook(String snumber, String isbn) {

        jdbcTemplate.update(SQLConstant.REMOVE_LIKED_BOOK_INFO, snumber, isbn);
    }
}
