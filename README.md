
🛡️ Spring Boot Security Basic Setup
This project is a basic implementation of authentication using Spring Boot. It includes user registration, login with JWT, and token refreshing using cookies.

🔗 GitHub Repository: SpringBootSecurityBasicSetup

✅ Features Implemented
User registration (/auth/register)

User login with JWT (/auth/login)

Refresh token endpoint (/auth/refresh)

Refresh token stored in an HTTP-only cookie

📌 Endpoints
🔹 Register a User
POST /auth/register

Request Body:

json
Copy
Edit
{
"username": "example_user",
"email": "user@example.com",
"password": "securePassword"
}
Response:

201 Created with user data.

🔹 Login
POST /auth/login

Request Body:

json
Copy
Edit
{
"username": "example_user",
"password": "securePassword"
}
Response:

200 OK with access and refresh tokens.

Refresh token is stored in an HTTP-only cookie.

🔹 Refresh Token
POST /auth/refresh

Behavior:

Reads the refreshToken from HTTP-only cookie.

Returns a new access token and refresh token.

Response:

200 OK with updated tokens.

🚀 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yadavprateek-here/SpringBootSecurityBasicSetup.git
cd SpringBootSecurityBasicSetup
Run the project:

bash
Copy
Edit
./mvnw spring-boot:run
API is available at:

arduino
Copy
Edit
http://localhost:8080
