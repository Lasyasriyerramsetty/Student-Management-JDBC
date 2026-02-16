# JDBC CRUD Application

A Java Standalone Application developed using JDBC to perform CRUD 
(Create, Read, Update, Delete) operations on a MySQL database.

---

## 📌 Project Description

This project demonstrates how a Java application connects to a MySQL database 
using JDBC and performs database operations through a console-based menu.

The application allows users to:
- Insert new student records
- View all student records
- Update existing records
- Delete student records

---

## 🛠 Technologies Used

- Java (OpenJDK 17)
- JDBC API
- MySQL Database
- Ubuntu Linux
- Git & GitHub

---

## 🗄 Database Details

**Database Name:** studentdb  
**Table Name:** students  

### Table Structure

| Column | Data Type | Description |
|--------|----------|------------|
| id     | INT (PK) | Student ID |
| name   | VARCHAR  | Student Name |
| email  | VARCHAR  | Student Email |
| course | VARCHAR  | Student Course |

---

## ⚙️ How to Run the Project

### 1️⃣ Install Requirements
- Install Java
- Install MySQL
- Download MySQL Connector/J

### 2️⃣ Create Database

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    course VARCHAR(50)
);
