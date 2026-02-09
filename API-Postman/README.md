# DummyJSON API Testing Project

This Postman collection is designed to test the **DummyJSON API** ([https://dummyjson.com](https://dummyjson.com)). It includes automated tests for authentication, users, products, and shopping carts to ensure the API functions correctly and handles both valid and invalid scenarios. This collection was created as part of our previous API testing project.

---

## Prerequisites

- **Postman** – Download from [postman.com](https://www.postman.com/downloads/)  
- **Newman** (optional) – For running tests via command line  

---

## Setup Instructions

1. **Import the Collection**  
   - Open Postman  
   - Click **Import** and select `DummyJson_postman_collection.json`  

2. **Configure the Environment**  
   - Import `DummyJSON_Env_postman_environment.json`  
   - Select **DummyJSON Env** from the environment dropdown  

3. **Execute Requests**  
   - Start with the **Login** request under the **Auth** folder  
   - Authentication tokens are saved automatically, allowing all subsequent requests to run correctly  

---

## Tested Features

### Authentication
- Login with valid and invalid credentials  
- Token refresh  
- Fetch current user information  

### Users
- List all users  
- Retrieve a specific user  
- Search users  

### Products
- Retrieve all products or a specific product  
- Search products  
- Add, update, and delete products  
- Validate handling of invalid product IDs  

### Shopping Carts
- View all carts  
- Manage cart items  
- Access user-specific carts  

---

## What Gets Checked

The automated tests verify:  
- Correct HTTP status codes (200, 404, 400, etc.)  
- Response times under 2 seconds  
- Required fields are present in responses  
- Data structure matches expected schema  
- Authentication and authorization functionality  
- Handling of invalid IDs or invalid input data  

---

## Running Tests

### Using Postman
1. Select a request and click **Send**  
2. Review the test results in the Postman interface  
3. To run the entire collection, open the **Collection Runner** and execute all requests  

### Using Newman (Command Line)
Run the collection:
```bash
newman run DummyJson_postman_collection.json -e DummyJSON_Env_postman_environment.json
