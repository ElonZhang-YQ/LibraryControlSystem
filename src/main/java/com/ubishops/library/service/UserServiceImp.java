package com.ubishops.library.service;

import com.ubishops.library.entity.User;
import com.ubishops.library.interfase.dao.UserDAO;
import com.ubishops.library.interfase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImp implements UserService<User> {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> selectAllUsers() {

        return userDAO.selectAllUsers();
    }

    @Override
    public List<User> selectUsersByType(int type) {

        List<User> returnRst = new ArrayList<User>();
        List<User> searchRst = selectAllUsers();
        for (User user : searchRst) {
            if (user.getType() == type) {
                returnRst.add(user);
            }
        }
        return returnRst;
    }

    @Override
    public User selectSingleUsers(String id, String password, int type) {

        List<User> searchRst = selectAllUsers();
        for (User user : searchRst) {
            if (user.getId().equals(id) && user.getPassword().equals(password) && user.getType() == type) {
                return user;
            }
        }
        return null;
    }
}
