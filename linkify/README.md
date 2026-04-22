# 🔗 Linkify – URL Shortener (Spring Boot)

A full-stack URL shortener application built using **Spring Boot** that converts long URLs into short, shareable links with a modern responsive UI.

---

## 🚀 Key Highlights

* ⚡ Built RESTful APIs using **Spring Boot** for fast URL shortening
* 🔗 Implemented redirection logic for short URLs
* 📱 Designed responsive UI with **HTML, CSS, Bootstrap**
* 🌙 Integrated dark mode for better UX
* 📋 Added one-click copy functionality
* 🔄 Used Fetch API for seamless frontend-backend communication

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring Web, REST API
* **Frontend:** HTML, CSS, JavaScript, Bootstrap
* **Tools:** Git, GitHub

---

## 📂 Project Structure

```id="7k2lpx"
src/
 └── main/
     ├── java/com/linkify/
     │    ├── controller/
     │    ├── service/
     │    ├── repository/
     │    └── model/
     └── resources/
          ├── static/
          └── application.properties
```

---

## ⚙️ Run Locally

```bash id="q8l2cz"
git clone https://github.com/your-username/linkify.git
cd linkify
mvn spring-boot:run
```

Open:

```id="nq3l7y"
http://localhost:8080
```

---

## 🔌 API

* `POST /api/shorten` → Generate short URL
* `GET /{shortCode}` → Redirect to original URL

---

## 👨‍💻 Author

**Shivam Sharma**


 
