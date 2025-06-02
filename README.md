# 🛡️ Spring Boot Security – Basic Authentication Setup

A simple and clean Spring Boot project demonstrating **JWT-based authentication** with **refresh tokens stored in HTTP-only cookies**.

---

## 🔗 Repository

👉 [GitHub – SpringBootSecurityBasicSetup](https://github.com/yadavprateek-here/SpringBootSecurityBasicSetup)

---

## ✅ Features Implemented

- 🔐 User **Registration**
- 🔑 User **Login with JWT**
- 🔄 **Token Refreshing** via cookies
- 🍪 Refresh token stored in **HTTP-only Cookie** for better security

---

## 📌 API Endpoints

### 🔹 `POST /auth/register` – Register a New User

Registers a new user with username, email, and password.

**📥 Request Body:**
```json
{
  "username": "example_user",
  "email": "user@example.com",
  "password": "securePassword"
}
```

**📤 Response:**
- `201 Created`
- Returns the created user details.

---

### 🔹 `POST /auth/login` – User Login

Authenticates user and returns **JWT tokens**.

**📥 Request Body:**
```json
{
  "username": "example_user",
  "password": "securePassword"
}
```

**📤 Response:**
- `200 OK`
- Returns `accessToken` and `refreshToken`.
- `refreshToken` is stored securely in an **HTTP-only cookie**.

---

### 🔹 `POST /auth/refresh` – Refresh Token

Generates a new set of tokens using the `refreshToken` stored in the cookie.

**🔁 Behavior:**
- Extracts `refreshToken` from HTTP-only cookie.
- Validates and issues new tokens.

**📤 Response:**
- `200 OK`
- Returns updated tokens.

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/yadavprateek-here/SpringBootSecurityBasicSetup.git
cd SpringBootSecurityBasicSetup
```

### 2️⃣ Run the Application
```bash
./mvnw spring-boot:run
```

### 3️⃣ Access the API
```
http://localhost:8080
```

---

## 📄 Technologies Used

- 🧩 Spring Boot
- 🔐 Spring Security
- 🪙 JWT (JSON Web Tokens)
- 🍪 HTTP Cookies
- 🌐 RESTful API

---

## 🙌 Contribution

Feel free to fork this repo and contribute with improvements or new features!  
Open to suggestions via issues or pull requests.

---

## 📬 Contact

📧 [prateekpros54@gmail.com](mailto:prateekpros54@gmail.com)

---

> Built with ❤️ by [Prateek Kumar Yadav](https://github.com/yadavprateek-here)
