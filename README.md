🛡️ Spring Boot Security Basic Setup
This project is a basic implementation of authentication using Spring Boot. It includes:

User registration

Login with JWT

Token refreshing using HTTP-only cookies

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

201 Created with registered user data

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

200 OK with access and refresh tokens

refreshToken is stored as an HTTP-only cookie

🔹 Refresh Token
POST /auth/refresh

Behavior:

Reads the refreshToken from HTTP-only cookie

Returns new access and refresh tokens

Response:

200 OK with updated tokens