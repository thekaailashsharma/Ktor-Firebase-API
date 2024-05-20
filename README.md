
<h1 align="center">  🔐 Ktor Firebase API 🔥 </h1> <br>
<p align="center">
  <a href="https://github.com/thekaailashsharma/Ktor-Firebase-API/assets/61358755/99938963-5617-42e2-a4ca-2be3a19fd14a">
    <img src="https://github.com/thekaailashsharma/Ktor-Firebase-API/assets/61358755/99938963-5617-42e2-a4ca-2be3a19fd14a" alt="HiewAF9.md.png" border="0">
  </a
</p>


![Static Badge](https://img.shields.io/badge/Kotlin-black?style=for-the-badge&logo=kotlin&logoColor=%237F52FF&labelColor=black)
![Static Badge](https://img.shields.io/badge/Ktor-black?style=for-the-badge&logo=ktor&logoColor=%23535863&labelColor=black)
![Static Badge](https://img.shields.io/badge/Firebase-black?style=for-the-badge&logo=firebase&logoColor=%23FFCA28&labelColor=black)

### Ktor Firebase API – Secure User Authentication and Management

Ktor Firebase API is a server-side application built using Kotlin and Ktor that integrates Firebase Authentication and Firestore for secure user registration, login, and profile management.

- 🛡️ **Secure Authentication**: Firebase Authentication for user sign-up and sign-in.
- 🗄️ **Firestore Integration**: Store and manage user data securely in Firebase Firestore.
- 🌐 **Ktor Framework**: Utilize the powerful and flexible Ktor framework for building your API.

## Features ✏️

1. 🔐 **User Registration** - Sign up new users and store their data in Firestore.
2. 🔓 **User Login** - Authenticate existing users using Firebase Authentication.
3. 📄 **User Profile** - Retrieve and update user profile information stored in Firestore.


## Future Aspects

- 🔒 **Add Password Hashing**: Enhance security by hashing user passwords before storing them.
- 🕒 **Implement Sessions**: Manage user sessions for persistent and secure authentication.
- 📈 **Add Analytics**: Integrate Firebase Analytics to track user interactions and app performance.
- 🔄 **Improve Error Handling**: Implement robust error handling and logging mechanisms.


## API Endpoints

### 1. Hello World
- **Endpoint**: `/`
- **Method**: `GET`
- **Description**: Returns a simple "Hello World!" message.

### 2. User Registration
- **Endpoint**: `/signUpFirebase`
- **Method**: `POST`
- **Description**: Registers a new user and stores their data in Firestore.
- **Request Body**:
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```
- **Responses**:
  - `200 OK`: User registered successfully.
  - `400 Bad Request`: User already exists or an error occurred.

### 3. User Login
- **Endpoint**: `/signInFirebase`
- **Method**: `GET`
- **Description**: Logs in an existing user using their email and password.
- **Parameters**:
  - `email`: User's email address.
  - `password`: User's password.
- **Responses**:
  - `200 OK`: User logged in successfully.
  - `400 Bad Request`: User does not exist or an error occurred.

### 4. Get User Profile
- **Endpoint**: `/userProfile`
- **Method**: `GET`
- **Description**: Retrieves the profile information of a logged-in user.
- **Parameters**:
  - `email`: User's email address.
  - `password`: User's password.
- **Responses**:
  - `200 OK`: User profile retrieved successfully.
  - `400 Bad Request`: User does not exist or an error occurred.

### 5. Update User
- **Endpoint**: `/updateUser`
- **Method**: `POST`
- **Description**: Updates user information in Firestore.
- **Request Body**:
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string"
  }
  ```
- **Responses**:
  - `200 OK`: User information updated successfully.
  - `400 Bad Request`: User already exists or an error occurred.

## OpenAPI Documentation

The API documentation is available at `/swagger`. Access it by navigating to `http://localhost:8080/swagger` after starting your Ktor server.

## Tech Stack

| Name                | Description                                     |
|---------------------|-------------------------------------------------|
| `Kotlin`            | Programming language used for development.      |
| `Ktor`              | Framework for building server-side applications.|
| `Firebase`          | Backend platform for authentication and storage.|
| `Swagger UI`        | API documentation and testing interface.        |

-------

# Running the Project

### Quick Start Guide

### Prerequisites
1. **Create a Firebase Project**
   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Click on "Add project" and follow the steps to create a new Firebase project.

2. **Obtain Firebase Project ID and Web API Key**
   - Navigate to Project Settings in the Firebase Console.
   - Under the General tab, locate your Project ID and Web API Key.

### Setup Environment Variables
1. Set up environment variables for your project:
   - `apiKey`: Your Firebase Web API Key
   - `projectId`: Your Firebase Project ID

   **For Windows:**
   ```sh
   set apiKey=your_firebase_api_key
   set projectId=your_firebase_project_id
   ```

   **For macOS/Linux:**
   ```sh
   export apiKey=your_firebase_api_key
   export projectId=your_firebase_project_id
   ```

### Running the Project

1. **Clone the Repository**
   ```sh
   git clone https://github.com/yourusername/ktor-firebase-api.git
   cd ktor-firebase-api
   ```

2. **Build and Run**
   ```sh
   ./gradlew run
   ```

That's it! You're now ready to test the api. 🫶🏻



