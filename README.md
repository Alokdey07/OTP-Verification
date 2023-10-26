
```markdown
# OTP Verification with Twilio and Spring Boot

This Spring Boot application provides OTP (One-Time Password) verification using Twilio for sending SMS messages. It includes endpoints for sending OTPs, verifying OTPs, and using both query parameters and DTO objects.

## Features

- Send and verify OTPs using Twilio.
- Use query parameters or DTO objects to send and verify OTPs.
- Easy to configure and use.

## Prerequisites

Before getting started, make sure you have the following prerequisites:

- Java Development Kit (JDK) 8 or higher.
- Apache Maven.
- A Twilio account with the following credentials:
    - `account_sid`
    - `auth_token`
    - Twilio phone number.
- [Postman](https://www.postman.com/) for testing the endpoints.

## Configuration

To configure your Twilio account details, open the `application.properties` file and replace the placeholders with your actual Twilio information:

```properties
twilio.account_sid=YOUR_TWILIO_ACCOUNT_SID
twilio.auth_token=YOUR_TWILIO_AUTH_TOKEN
twilio.phone_number=YOUR_TWILIO_PHONE_NUMBER
```

## Usage

### Sending OTP

#### Query Parameter

To send an OTP using a query parameter, make a POST request to:

```
http://localhost:8080/send-otp?phoneNumber=YOUR_PHONE_NUMBER
```

Example using curl:

```bash
curl -X POST http://localhost:8080/send-otp?phoneNumber=+15555555555
```

#### JSON Object

To send an OTP using a JSON object, make a POST request to:

```
http://localhost:8080/send_otp
```

Example using curl:

```bash
curl -X POST http://localhost:8080/send_otp -H "Content-Type: application/json" -d '{
  "phoneNumber": "+15555555555"
}'
```

### Verifying OTP

#### Query Parameter

To verify an OTP using query parameters, make a POST request to:

```
http://localhost:8080/verify-otp?phoneNumber=YOUR_PHONE_NUMBER&otp=OTP_TO_VERIFY
```

Example using curl:

```bash
curl -X POST http://localhost:8080/verify-otp?phoneNumber=+15555555555&otp=123456
```

#### JSON Object

To verify an OTP using a JSON object, make a POST request to:

```
http://localhost:8080/verify_otp
```

Example using curl:

```bash
curl -X POST http://localhost:8080/verify_otp -H "Content-Type: application/json" -d '{
  "phoneNumber": "+15555555555",
  "otp": "123456"
}'
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

Please replace placeholders with your actual Twilio account details and customize any other information to suit your project.
