# SauceDemo UI Automation Testing  
** UI Test Automation Project**

---

## 1. Introduction
This project presents an automated **User Interface (UI) testing framework** developed for the *SauceDemo* e-commerce web application. The primary objective is to validate essential functional workflows for a **standard user** through automated test execution using industry-standard tools.

The automation suite focuses on ensuring the correctness, reliability, and stability of core user operations such as authentication, product sorting, shopping cart manipulation, checkout processing, and error handling.

**System Under Test (SUT):**  
https://www.saucedemo.com/

---

## 2. Objectives
The objectives of this project are to:

- Apply automated UI testing principles using Selenium WebDriver
- Validate functional requirements of an e-commerce system
- Implement positive and negative test scenarios
- Use assertions to verify expected system behavior
- Demonstrate practical usage of TestNG for test execution and reporting

---

## 3. Technologies and Tools
The following technologies were used in this project:

| Component            | Technology |
|---------------------|------------|
| Programming Language | Java |
| Automation Tool      | Selenium WebDriver |
| Test Framework       | TestNG |
| Browser              | Safari |
| IDE                  | Eclipse |
| Build Tool           | Maven  |

---

## 4. Project Structure
The project follows a simple TestNG-based structure:

src/
└── test/
    └── java/
        └── SauceDemo/
            └── StandardUserTests.java




---

## 5. Test Environment
- Operating System: macOS  
- Browser: Safari (SafariDriver)  
- Implicit Wait: 3 seconds  

---

## 6. Test Data

### Valid Credentials
Username: standard_user
Password: secret_sauce

---

## 7. Test Scope and Coverage

### 7.1 Positive Test Scenarios
- User login with valid credentials
- Verification of inventory page display
- Product sorting by price (Low to High)
- Adding products to the shopping cart
- Removing items from the cart
- Successful checkout with valid customer information
- User logout

### 7.2 Negative Test Scenarios
- Login attempt with invalid password
- Checkout attempt with missing mandatory fields

---

## 8. Test Case Summary

| ID | Test Case Description | Type |
|----|----------------------|------|
| TC-01 | Login with valid credentials | Positive |
| TC-02 | Verify inventory page URL | Positive |
| TC-03 | Sort products by price (Low → High) | Positive |
| TC-04 | Add random items to cart | Positive |
| TC-05 | Remove item from cart | Positive |
| TC-06 | Checkout with valid information | Positive |
| TC-07 | Logout from application | Positive |
| TC-08 | Login with invalid password | Negative |
| TC-09 | Checkout with missing required information | Negative |

---

## 9. Assertion Strategy
Assertions are used to validate system behavior and expected outcomes, including:

- URL validation after login
- Product price order validation
- Cart item count verification
- Checkout confirmation message validation
- Error message validation for missing or invalid input

Assertions ensure that tests fail immediately when an expected condition is not met.

---

## 10. Test Execution
Tests are executed using **TestNG annotations** with assigned priorities to control execution order.

Execution steps:
1. Open the application
2. Execute test cases sequentially
3. Validate expected results using assertions
4. Close the browser after test completion

---



## 11. Future Enhancements
- Add data-driven testing


---

## 12. Conclusion
This project demonstrates the practical application of UI automation testing concepts using Selenium WebDriver and TestNG. The implemented test cases effectively validate both functional and negative scenarios of an e-commerce web application, reflecting real-world testing practices and academic software testing principles.

---

## 13. References

Selenium WebDriver Documentation  
https://www.selenium.dev/documentation/

TestNG Official Documentation  
https://testng.org/doc/

Oracle Java Documentation  
https://docs.oracle.com/en/java/

SauceDemo Test Website  
https://www.saucedemo.com/
