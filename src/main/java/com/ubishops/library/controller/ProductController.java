package com.ubishops.library.controller;

import com.ubishops.library.entity.User;
import com.ubishops.library.interfase.service.BookService;
import com.ubishops.library.service.BookServiceImp;
import com.ubishops.library.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private BookServiceImp bookServiceImp;

    @Autowired
    private UserServiceImp userServiceImp;


    /**
     * Login Interface
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    /**
     * Determine if login is successful
     *
     * @param request
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, Model model) {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String manager = request.getParameter("checkbox");
        User user;
        if (manager != null && manager.equals("on")) {
            int type = 0;
            user = userServiceImp.selectSingleUsers(name,password,type);
            if (user == null) {
                model.addAttribute("msg", "Failed, You are not a manager or user name or password dose not match");
                return "forward:login";
            }
        } else {
            int type = 1;
            user = userServiceImp.selectSingleUsers(name, password,type);
            if (user == null) {
                model.addAttribute("msg", "Failed, username or password dose not match the record");
                return "forward:login";
            }
        }
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("userId", name);
            session.setAttribute("usertype", user.getType());
            session.setAttribute("password", user.getPassword());
            session.setMaxInactiveInterval(500);
            return "redirect:index";
        } else {
            model.addAttribute("msg", "Failed, Doesn't exit");
            return "forward:login";
        }
    }

    /**
     * Registration Interface
     *
     * @return
     */



    @RequestMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String userID = "000000000";
        Integer usertype = 1;
        String phone = "1234567890";
        String email = "user@example.com";
        String password = "password";
        String Name = "Yiqu Zhang";
        String Gender = "Male";
        if (session.getAttribute("userId") != null) {
            userID = (String) session.getAttribute("userId");
            usertype = (Integer) session.getAttribute("usertype");
            password = (String) session.getAttribute("password");
            if (usertype== null){
                usertype = 1;
            }
            User user =  userServiceImp.selectSingleUsers(userID,password,usertype);
            if (user!=null){
                userID = user.getId();
                phone = user.getPhone();
                email = user.getEmail();
                Name = user.getName();
                Gender = user.getGender();
            }
        }
        model.addAttribute("username", Name);
        model.addAttribute("userid", userID);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        model.addAttribute("Name",Name);
        model.addAttribute("Gender",Gender);
        return "profile";
    }

    @RequestMapping("/changePhone")
    public String changePhone(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user;
        String username;
        String password;
        Integer usertype;
        String phone = request.getParameter("phone");
        username = (String) session.getAttribute("userId");
        password = (String) session.getAttribute("password");

        System.out.println(phone);
        usertype = (Integer) session.getAttribute("usertype");
        if (usertype != null && username != null) {
            user =  userServiceImp.selectSingleUsers(username,password,usertype);
            user.setPhone(phone);
        }
        return "redirect:profile";
    }

    @RequestMapping("/changeEmail")
    public String changeEmail(HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user;
        String username;
        String password;
        Integer usertype;
        String email = request.getParameter("email");
        username = (String) session.getAttribute("userId");
        password = (String) session.getAttribute("password");
        System.out.println(email);

        usertype = (Integer) session.getAttribute("usertype");
        if (usertype != null && username != null) {
            user =  userServiceImp.selectSingleUsers(username,password,usertype);
            user.setEmail(email);
        }

        return "redirect:profile";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {

        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/login";
    }


}
