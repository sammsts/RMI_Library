# 📚 Java RMI Library System

A simple distributed library management system developed using **Java RMI (Remote Method Invocation)**. This project simulates basic operations of a library, allowing clients to interact remotely with the server to manage book lending.

---

## 🧩 Architecture

This project uses a **Client-Server architecture**:

- **Server** hosts the library's logic and maintains the state of available and borrowed books.
- **Client** connects to the server via RMI and allows users to:
  - List available books
  - Borrow a book
  - Return a book

---

## 📂 Project Structure
```
BibliotecaRMI/
├── comum/
│   └── Biblioteca.java        ← Remote interface
├── servidor/
│   ├── BibliotecaImpl.java    ← Interface implementation
│   └── Servidor.java          ← Start the RMI server
└── cliente/
    └── Cliente.java           ← RMI Client with Menu
```
---

## 🚀 Features

- List all available books in the library.
- Borrow a book (if available).
- Return a borrowed book.
- Console-based client menu.
- Thread-safe operations on book lists.

---

## 💻 How to Run

### 1. Compile all source files
```bash
javac comum/*.java servidor/*.java cliente/*.java
```

### 2. Start the RMI registry
```bash
rmiregistry
```
- Make sure you run this command in the project root folder where .class files are located.

### 3. Run the server
```
java servidor.Servidor
```

### 4. Run the client
```
java cliente.Cliente
```

---

## 🛠 Technologies Used
- Java 8+
- Java RMI (Remote Method Invocation)

---

## 📌 Notes
- RMI is useful for learning and prototyping distributed systems in Java.
- In real-world applications, modern alternatives like REST APIs or gRPC are more commonly used.
