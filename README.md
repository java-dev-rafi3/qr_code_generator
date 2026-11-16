# QR Code Generator

A simple backend-only QR Code Generator built with Java and Spring Boot.

The application accepts text input through a REST API and generates a QR Code in PNG format. The generated image is returned directly in the HTTP response.

## Features

- Generate QR Codes from text input
- Support URLs, numbers, special characters, and emojis
- Return the generated QR Code as a PNG image
- REST API based
- Backend-only project
- No database required
- No frontend required

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Maven
- ZXing
- Postman

## Project Structure

```text
src/main/java/com/rafijohndev/qrgenerator
├── controller
│   └── QRController.java
├── dto
│   └── QrRequest.java
└── qrservice
    └── QrService.java
```

## How It Works

```text
Client
   ↓
POST request with text
   ↓
QR Controller
   ↓
QR Service
   ↓
ZXing
   ↓
QR Code
   ↓
PNG Image
   ↓
HTTP Response
```

## API

### Generate QR Code

**Method:** `POST`

**Endpoint:**

`/api/generateQR`

**Local URL:**

`http://localhost:8080/api/generateQR`

### Request

**Content-Type:** `application/json`

```json
{
  "input": "Hello World"
}
```

### Response

**Status:** `200 OK`

**Content-Type:** `image/png`

The generated QR Code is returned directly as the response body.

## Example Inputs

The API can be used with different types of text:

- Normal text
- URLs
- Numbers
- Special characters
- Emojis

Example:

```json
{
  "input": "Hello 👋😊"
}
```

## Running the Project

1. Clone the repository.
2. Open the project in Spring Tool Suite, Eclipse, IntelliJ IDEA, or another Java IDE.
3. Make sure Java and Maven are configured.
4. Run the Spring Boot application.
5. Open Postman.
6. Send a `POST` request to:

`http://localhost:8080/api/generateQR`

7. Set the request body to JSON and provide the input text.

## Dependencies

The project uses ZXing for QR Code generation.

- ZXing Core
- ZXing Java SE

## Current Limitations

- No input validation
- No custom exception handling
- Generated images are not permanently stored
- No database
- No frontend
- No authentication
- QR Code capacity limits are not handled explicitly yet

## Future Improvements

- Add input validation
- Handle invalid or empty input
- Handle QR Code capacity limits
- Improve exception handling
- Add download support
- Add unit tests
- Add integration tests
- Deploy the application

## Status

The basic QR Code generation functionality is complete and tested successfully using Postman.

## Author

Rafi John
