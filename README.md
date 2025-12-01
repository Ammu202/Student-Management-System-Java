# Student-Management-System-Java
# Student Management System (Java + JDBC + MySQL)

A simple console-based Student Management System built using Java, JDBC, and MySQL.  
The project performs full CRUD operations and demonstrates real-world backend fundamentals.

## 🔧 Technologies Used
- Java
- JDBC (MySQL Connector/J)
- MySQL Database
- VS Code

## 📌 Features
- Add a new student
- View all students
- Update student details
- Delete a student
- Error handling and input validation

## 📂 Project Structure
- `Main.java` – Menu + user interaction  
- `Student.java` – Model class  
- `StudentDAO.java` – Database operations  
- `DBConnection.java` – JDBC MySQL connection  

## 🗄️ Database Setup
Run the following SQL commands:

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10)
);
