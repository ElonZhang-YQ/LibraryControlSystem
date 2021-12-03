package com.ubishops.library.dao;

import com.ubishops.library.constant.SQLConstant;
import com.ubishops.library.entity.BorrowInfo;
import com.ubishops.library.interfase.dao.BorrowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BorrowDAOImp implements BorrowDAO<BorrowInfo> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BorrowInfo> selectAllBorrowBookInfo() {

        List<BorrowInfo> infos = jdbcTemplate.query(SQLConstant.QUERRY_ALL_BORROW_INFO, new RowMapper<BorrowInfo>() {
            @Override
            public BorrowInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                BorrowInfo info = new BorrowInfo();
                info.setId(rs.getString("id"));
                info.setIsbn(rs.getString("isbn"));
                info.setBookName(rs.getString("book_name"));
                info.setB_date(rs.getString("borrow_date"));
                info.setR_date(rs.getString("return_date"));
                info.setStatus(rs.getInt("status"));
                info.setS_number(rs.getString("student_number"));
                return info;
            }
        });
        return infos;
    }

    @Override
    public void updateBorrowBookInfo(BorrowInfo borrowInfo) {

        jdbcTemplate.update(SQLConstant.MODIFY_BORROW_INFO, borrowInfo.getIsbn(), borrowInfo.getB_date(), borrowInfo.getR_date(), borrowInfo.getStatus(), borrowInfo.getS_number(), borrowInfo.getId());
    }

    @Override
    public void insertBorrowBookInfo(BorrowInfo borrowInfo) {

        jdbcTemplate.update(SQLConstant.INSERT_BORROW_INFO, borrowInfo.getId(), borrowInfo.getIsbn(), borrowInfo.getBookName(), borrowInfo.getB_date(), borrowInfo.getR_date(), borrowInfo.getStatus(), borrowInfo.getS_number());
    }
}
