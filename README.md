# Bookstore backend (API)

# About projeto ⁉️ 
This project is part of the course "Spring Boot e Angular 10", organized by [Valdir Cezar](https://www.udemy.com/course/curso-de-angular-10-com-spring-boot-2/?referralCode=003BA46D1109483E9274#instructor-1).

FUNCTIONAL VISION: In this project a library system was created with CRUD (CREATE, READ, UPDATE and DELETE) managing its books and categories via web requests.

## Technologies
- Java 11
- Spring Boot 2.7.5
- JPA / Hibernate
- Maven
- H2 Database 
- Postman 

### Endpoints for tests
#### Query (GET)
- Categories (http://localhost:8080/categories)
- Book (http://localhost:8080/books?category={id})
- Categorie by id  (http://localhost:8080/categories/{id})
- Book by id (http://localhost:8080/books/{id})

#### Update (PUT)
- Book (http://localhost:8080/books/{id}) put the ID and in the body of the request, put the field and the value you want to change.
- Category (http://localhost:8080/categories/{id}) put the ID and in the body of the request, put the field and the value you want to change.

#### Delete(DELETE)
- http://localhost:8080/categories/{id}
- http://localhost:8080/books/{id}

#### Insert(POST)
- Book (http://localhost:8080/books?category={id-category}) In the body of the request, put the field and passes through the endpoint the id of the category corresponding to the book.
- Categories (http://localhost:8080/categories) In the body of the request, put the field.


In this system each book is part of a category and each category has several books.If you want to visualize the data through a more intuitive layout, the fornt end part of this project can be found at
[Front end](https://github.com/Adeniltonarcanjo/bookstore-front).
