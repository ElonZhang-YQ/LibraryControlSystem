package com.ubishops.library.controller;


import com.ubishops.library.dao.BookDAOImp;
import com.ubishops.library.entity.Book;
import com.ubishops.library.entity.BorrowInfo;
import com.ubishops.library.entity.Page;
import com.ubishops.library.entity.User;
import com.ubishops.library.service.BookServiceImp;
import com.ubishops.library.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller

public class Homepage {


        @Autowired
        private UserServiceImp userServiceImp;

        @Autowired
        private BookServiceImp bookServiceImp;

        @Autowired
        private BookDAOImp bookDAOImp;

        @RequestMapping("/Nav2")
        public String Nav2(HttpServletRequest request, Model model) {

            HttpSession session = request.getSession();
            String username;
            username = "Guest";
            if (session != null) {
                username = (String) session.getAttribute("userId");
            }
            model.addAttribute("username", username);
            return "/common/Nav2";
        }
    @RequestMapping("")
    public String home(HttpServletRequest request, Model model,Page page) {

        HttpSession session = request.getSession();
        String username;
        username = "Guest";

        List<Book> list = bookServiceImp.findAllBooks();
        changePage(model, page, list);

        if (session != null) {
            username = (String) session.getAttribute("userId");
        }
        model.addAttribute("username", username);
        if (page ==null){
            page.setRows(0);
        }
        model.addAttribute(page);
        return "index";
    }
        @RequestMapping("index")
        public String index(HttpServletRequest request, Model model,Page page) {

            HttpSession session = request.getSession();
            String username;
            username = "Guest";

            List<Book> list = bookServiceImp.findAllBooks();
            changePage(model, page, list);

            if (session != null) {
                username = (String) session.getAttribute("userId");
            }
            model.addAttribute("username", username);
            if (page ==null){
                page.setRows(0);
            }
            model.addAttribute(page);
            return "index";
        }
        @RequestMapping("/add")
        public String add(Model model, HttpServletRequest request) {
            HttpSession session = request.getSession();
            Integer usertype = (Integer) session.getAttribute("usertype");
            if (usertype != null && usertype == 0) {
                String name = request.getParameter("bookname");
                String isbn = request.getParameter("isbn");
                String author = request.getParameter("author");
                String date = request.getParameter("date");
                String category = request.getParameter("category");
                int amount = Integer.valueOf(request.getParameter("amount"));
                int camount = amount;
                Book book = new Book();
                book.setName(name);
                book.setIsbn(isbn);
                book.setAuthor(author);
                book.setDate(date);
                book.setCategory(category);
                book.setAmount(amount);
                book.setCamount(camount);
                bookServiceImp.addNewBookInfo(book);
                return "forward:index";
            } else {
                model.addAttribute("msg", "Failed, You are not a manager");
                return "forward:index";
            }

        }



        @RequestMapping("/Alt")
        public String alt(Model model,HttpServletRequest request) {
            HttpSession session = request.getSession();
            String userId = (String)session.getAttribute("userId");
            Integer usertype = (Integer)session.getAttribute("usertype");
            if (userId!=null&& usertype==0){

                String name = request.getParameter("modifyname");
                String isbn = request.getParameter("modifyisbn");
                String author = request.getParameter("modifyauthor");
                String date = request.getParameter("modifydate");
                String category = request.getParameter("modifycategory");
                int amount = Integer.valueOf(request.getParameter("modifyamount"));
                int camount  = Integer.valueOf(request.getParameter("modifycamount"));
                List<Book> list = bookServiceImp.findAllBooks();
                for (Book book :list){
                    if (book.getIsbn()==isbn) {
                        book.setName(name);
                        book.setAuthor(author);
                        book.setIsbn(isbn);
                        book.setDate(date);
                        book.setCategory(category);
                        book.setAmount(amount);
                        book.setCamount(camount);
                    }
                }

                return "redirect:index";
            }
            else {
                model.addAttribute("msg", "Failed, You are not manager");
                return "forward:index";
            }

        }

    @RequestMapping("/del/{isbn}")
    public String del(Model model, HttpServletRequest request, @PathVariable String isbn) {

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        Integer usertype = (Integer)session.getAttribute("usertype");
        if (userId!=null&& usertype==0){
            bookDAOImp.deleteBook(isbn);
            return "redirect:index";
        } else {
            model.addAttribute("msg", "Failed, You are not LOGIN");
            return "forward:index";
        }

    }
    @RequestMapping("/like/{isbn}")
    public String like(Model model, HttpServletRequest request, @PathVariable String isbn) {

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        if (userId!=null){
            bookServiceImp.addNewLikedBooks(userId,isbn);;
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "Failed, You are not LOGIN");
            return "forward:/index";
        }

    }
    @RequestMapping("/dislike/{isbn}")
    public String dislike(Model model, HttpServletRequest request, @PathVariable String isbn) {

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        if (userId!=null){
            bookServiceImp.removeLikedBooks(userId,isbn);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "Failed, You are not LOGIN");
            return "forwards:/index";
        }

    }
    @RequestMapping("/borrow")
    public String borrow(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        String password = (String)session.getAttribute("password");
        if (userId!=null){
            int usertype = (Integer)session.getAttribute("usertype");
            User user = userServiceImp.selectSingleUsers(userId,password,usertype);
            String name = user.getName();
            String isbn = request.getParameter("bisbn");
            String book_name = request.getParameter("book_name");
            String b_date = request.getParameter("borrow_date");
            String r_date = request.getParameter("return_date");
            int bamount = Integer.valueOf(request.getParameter("status"));
            String s_number = request.getParameter("student_number");
            BorrowInfo borrowInfo = new BorrowInfo(name,isbn,book_name,b_date,r_date,bamount,s_number);
            bookServiceImp.addNewBorrowInfo(borrowInfo);
            Book book = bookDAOImp.selectBookByISBN(isbn);
            int amount = book.getAmount();
            int camount = amount-bamount;
            book.setCamount(camount);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "Failed, You are not LOGIN");
            return "forward:index";
        }

    }
        @RequestMapping("/info")
        public String info(Model model, HttpServletRequest request) {

            HttpSession session = request.getSession();
            String userId = (String)session.getAttribute("userId");
            Integer usertype = (Integer)session.getAttribute("usertype");
            if (userId!=null&& usertype==0){

                List<BorrowInfo> Borrowinfo = bookServiceImp.findAllBorrowInfo();
                model.addAttribute("list", Borrowinfo);
                return "info";
            } else {
                model.addAttribute("msg", "Failed, You are not manager");
                return "forward:index";
            }

        }

        @RequestMapping("/search")
        public String search(Model model, HttpServletRequest request, Page page) {
            String search = request.getParameter("search");
            List<Book> list = bookServiceImp.searchBooksByKeyWords(search);
            changePage(model, page, list);
            return "index";
        }

        private String changePage(Model model, Page page, List<Book> list) {
            Integer limit = 10;
            page.setLimit(limit);
            page.setRows(list.size());
            List<Book> showList = new ArrayList<Book>();
            if (!list.isEmpty()) {
                showList = list.subList(page.getOffset(), page.getLimit());
            }
            model.getAttribute("list");
            model.addAttribute(page);
            model.addAttribute("list", showList);
            return "Index";
        }
}
