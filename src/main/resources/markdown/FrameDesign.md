# CS560 LibraryControlSystem Frame Design

## 1. Introduction of the system

Students(Users) have different choices in the system, such as searching the books, like or dislike the books, borrowing and returnning. 
The library managers(managers) could upload the new books, search the books and check the status of the books.

## 2. Different part of the system

### 2.1 System shown

a. UserIndex page shows 10 boos the lastest input to the system books, and have a search bar to help users to find the book, and navicat bar shows the category of the subjects. When user clicks the subjects, page shows the books in the subject.</br></br>
The search bar takes key words search and full words search.

b. SearchingResultsPage shows the searching results. Single book includes the name, ISBN, status(out of stock or remaining quantity), publish date, author, category of subject, and picture，</br>

c. UserInformation page shows the user`s profile, includes name, photos, phone number, email address and student number. In addition, it shows the likes books and borrowed bookes. </br>

d. ManagerIndex page shows the all books information, upload button and a search bar. Upload buttom forward to Upload Page or an embed form(details in e). The search bar filtes the books and shows in current page.</br>

Inaddition, manager page shows the borrow history for all books.</br>

e. Upload embed form includes books all information(name, isbn, author, publish date, category, amount)

## 3. Class Declear

### 3.1 User

| Name | Gender | Student Number | Phone Number | Email Address | Picture | Password
| :----: | :----: | :----: | :----: | :----: | :----: | :----: |
| String | int(0 for male, 1 for female) | String | String | String | String(file path) | String |

Student Number will be the login username;

``` java
public class User{

    private string name;
    
    private int gender;
    
    private string s_number;
    
    private string phone;
    
    private string email;
    
    private string picture;
    
    private string password;
    
    // get/set
    
    // toString
    
    // hashCode

}
```

### 3.2 Manager

| Name | Gender | Teacher Number | Phone Number | Email Address | Picture | Password |
| :----: | :----: | :----: | :----: | :----: | :----: | :----: |
| String | int(0 for male, 1 for female) | String | String | String | String(file path) | String |

``` java
public class User{

    private string name;
    
    private int gender;
    
    private string t_number;
    
    private string phone;
    
    private string email;
    
    private string picture;
    
    private string password;
    
    // get/set
    
    // toString
    
    // hashCode

}
```

### 3.3 Book

| Name | ISBN | Author | Publish Date | Category | Amount | Current Amount | Picture |
| :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: |
| String | String | String | String | String | Int | Int | String |

ISBN is a signature number, it could be the id to identify the different books.

```java
public class Book{
    
    private string name;
    
    private string isbn;
    
    private string author;
    
    private string date;
    
    private string category;
    
    private int amount;
    
    private int c_amount;
    
    private string picture;
    
    // get/set
    
    // toString
    
    // hashcode
    
}
```

### 3.4 BorrowInfo 

| Id | ISBN | Borrow Date | Return Date | Status | Student Number |
| :----: | :----: | :----: | :----: | :----: | :----: |
| String | String | String | String | Int (0: returned, 1: not yet) | String |

BorrowPage should generate a signature number as the id to identify different borrow informations.

```java
public class BorrowInfo{
    
    private string id;
    
    private string isbn;
    
    private string b_date;
    
    private string r_date;
    
    private int status;
    
    private int s_number;
    
    // get/set
    
    // toString
    
    // hashcode
}
```

### 3.5 LikedBook

(Student Number) 1 : N (ISBN)

| Student Number | ISBN |
| :----: | :----: |
| String | String |

```java
public class LikedBook{
    
    private string s_number;
    
    private string isbn;
    
    // get/set
    
    // toString
    
    // hasCode
}
```

## 4. Different Frame

### 4.1 Data Access Object(DAO)
a. connecting to database, search, modify the data informations
b. maintaining different containers to reduce the JDBC operations and server pressure.

### 4.2 Service
a.dealing with the data and suit for any operation.

### 4.3 Controller(Action)
a. request and respond the web server.



