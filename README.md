# QA Testing Project - SauceDemo & DummyJSON

A comprehensive quality assurance testing project demonstrating proficiency in **API testing**, **performance testing**, **manual testing**, and **UI automation testing**. This project validates both the SauceDemo e-commerce web application and the DummyJSON API using industry-standard testing tools and methodologies.

---

##  Table of Contents

- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Technologies and Tools](#technologies-and-tools)
- [Testing Scope](#testing-scope)
- [Test Plan & Scenarios](#test-plan--scenarios)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
  - [API Testing (Postman/Newman)](#api-testing-postmannewman)
  - [Performance Testing (K6)](#performance-testing-k6)
  - [Manual Testing](#manual-testing)
  - [UI Automation Testing](#ui-automation-testing)
- [Test Results and Evidence](#test-results-and-evidence)
- [Key Findings](#key-findings)


---

## 🎯 Project Overview

This project encompasses four major testing activities:

1. **API Testing** - Automated functional testing of DummyJSON API endpoints using Postman
2. **Performance Testing** - Load and stress testing of API endpoints using k6
3. **Manual Testing** - Exploratory testing of SauceDemo web application
4. **UI Automation** - Selenium WebDriver-based automated functional testing

**Systems Under Test:**
- **SauceDemo**: https://www.saucedemo.com/
- **DummyJSON API**: https://dummyjson.com

**Documentation:**
- Detailed test plan and scenarios: `TestPlan_Scenarios.pdf`
- Individual README files for each testing type in respective folders

---

##  Project Structure

```
qa-testing-project/
│
├── api-testing/
│   ├── DummyJson_postman_collection.json
│   ├── DummyJSON_Env_postman_environment.json
│   └── API_README.md
│
├── performance-testing/
│   ├── scripts/
│   │   ├── smoke-test.js
│   │   └── load-test.js
│   ├── results/
│   └── Performance_README.md
│
├── manual-testing/
│   ├── test-cases/
│   │   └── Final-Testcases-excelsheet-Htu.xlsx
│   ├── defects/
│   ├── evidence/
│   └── MANUAL_README.md
│
├── ui-automation/
│   ├── src/
│   │   └── test/
│   │       └── java/
│   │           └── SauceDemo/
│   │               └── StandardUserTests.java
│   ├── pom.xml
│   └── AUTOMATION_README.md
│
├── TestPlan_Scenarios.pdf
└── README.md (this file)
```

---

## Technologies and Tools

| Testing Type | Tools & Technologies |
|--------------|---------------------|
| **API Testing** | Postman, Newman |
| **Performance Testing** | k6, JavaScript |
| **Manual Testing** | Excel, Browser DevTools |
| **UI Automation** | Java, Selenium WebDriver, TestNG, Maven, Safari |
| **Version Control** | GitHub |

---

##  Testing Scope

### API Testing Coverage
- **Authentication**: Login, token refresh, current user validation
- **Users**: List users, retrieve specific user, search functionality
- **Products**: CRUD operations, search, invalid ID handling
- **Shopping Carts**: View carts, manage items, user-specific carts

### Performance Testing Coverage
- **Endpoints Tested**:
  - `GET /products` (large payload)
  - `GET /products/{id}` (single product)
  - `GET /products/search?q=phone` (search query)
- **Test Types**: Smoke test, Load test

### Manual Testing Coverage
- User authentication and login
- Product inventory display
- Product sorting functionality
- Shopping cart operations (add/remove)
- Checkout workflow and validation
- Session handling and logout

### UI Automation Coverage
- Positive scenarios: Login, sorting, cart management, checkout, logout
- Negative scenarios: Invalid login, missing checkout fields

---

## Test Plan & Scenarios

A comprehensive test plan was created to guide both manual and automated testing activities for the SauceDemo application.

### Test Objectives
- Verify main functionalities work as expected
- Validate user flows based on observable behavior
- Execute positive (happy path) and negative test scenarios
- Identify functional and validation issues
- Automate selected critical scenarios

### Planned Test Scenarios

#### Feature 1: Login Functionality
| Scenario | Type | Description |
|----------|------|-------------|
| **Scenario 1** | Happy Path | Successful login with valid credentials |
| **Scenario 2** | Negative | Invalid login attempt with wrong credentials |
| **Scenario 3** | Negative | Locked user login prevention |

#### Feature 2: Product Listing & Sorting
| Scenario | Type | Description |
|----------|------|-------------|
| **Scenario 4** | Happy Path | View product inventory after login |
| **Scenario 5** | Happy Path | Sort products by price (low to high) |

#### Feature 3: Cart Management
| Scenario | Type | Description |
|----------|------|-------------|
| **Scenario 6** | Happy Path | Add and remove products from cart |

#### Feature 4: Checkout Process
| Scenario | Type | Description |
|----------|------|-------------|
| **Scenario 7** | Happy Path | Complete checkout with valid information |
| **Scenario 8** | Negative | Checkout attempt with missing required fields |

#### Feature 5: Logout & Session Handling
| Scenario | Type | Description |
|----------|------|-------------|
| **Scenario 9** | Happy Path | Successful logout and return to login page |
| **Scenario 10** | Negative | Access protection after logout |

### Test User Accounts

The following SauceDemo user accounts are used during testing:

| Username | Purpose |
|----------|---------|
| `standard_user` | Primary test user for positive scenarios |
| `locked_out_user` | Testing locked account behavior |
| `problem_user` | Testing error handling |
| `performance_glitch_user` | Manual performance observation |
| `error_user` | Error scenario validation |
| `visual_user` | Visual testing scenarios |

**Password for all users**: `secret_sauce`

### Entry and Exit Criteria

**Entry Criteria:**
- SauceDemo website is accessible
- Test environment is configured
- Test scenarios and cases are documented

**Exit Criteria:**
- All planned scenarios executed
- Test results documented with evidence
- Automation scripts verified and passing

### Risks and Mitigation
- **Risk**: Temporary website unavailability → **Mitigation**: Schedule flexible testing windows
- **Risk**: UI changes affecting automation → **Mitigation**: Use robust locator strategies

---

## Setup Instructions

### Prerequisites

Ensure you have the following installed:

- **Postman** - [Download here](https://www.postman.com/downloads/)
- **Node.js** (v14+) - For Newman and k6
- **Newman** - `npm install -g newman`
- **k6** - [Installation guide](https://k6.io/docs/getting-started/installation/)
- **Java JDK**  - For UI automation
- **Maven** - For dependency management
- **Safari Browser** (macOS) or Chrome/Firefox



##  Running Tests

### API Testing (Postman/Newman)

#### Using Postman (GUI)

1. **Import Collection and Environment**
   ```bash
   cd api-testing
   ```
   - Open Postman
   - Click **Import** → Select `DummyJson_postman_collection.json`
   - Import environment: `DummyJSON_Env_postman_environment.json`
   - Select **DummyJSON Env** from environment dropdown

2. **Run Tests**
   - Execute individual requests by clicking **Send**
   - Or use **Collection Runner** to run all tests

#### Using Newman (Command Line)

```bash
cd api-testing

# Run the entire collection
newman run DummyJson_postman_collection.json -e DummyJSON_Env_postman_environment.json

# Generate HTML report
newman run DummyJson_postman_collection.json \
  -e DummyJSON_Env_postman_environment.json \
  -r html --reporter-html-export report.html
```

**What Gets Verified:**
- HTTP status codes (200, 404, 400, etc.)
- Response times < 2 seconds
- Required fields presence
- Data structure validation
- Authentication functionality
- Invalid input handling

---

### Performance Testing (K6)

#### Running Smoke Test and Load Test

```bash
cd performance-testing/scripts

# Execute smoke test (2 VUs, 30 seconds),# Execute load test (ramp to 50 VUs, 3 minutes)
k6 run load-test.js
k6 run test.js

# Generate HTML report
k6 run test.js --out json=results.json
```


**Performance Thresholds:**
- p95 response time: < 300ms
- Error rate: < 1%

**Key Metrics Measured:**
- Average response time: 61.09ms
- Median (p50): 13.44ms
- p95: 156.19ms
- Throughput: ~27 req/sec
- Error rate: 0.00%

---

### Manual Testing

#### Accessing Test Cases

1. Navigate to `manual-testing/test-cases/`
2. Open `Final-Testcases-excelsheet-Htu.xlsx`
3. Review test scenarios, steps, and execution results

#### Test Execution Process

1. Open SauceDemo application: https://www.saucedemo.com/
2. Follow test steps documented in Excel sheet
3. Record actual results and status (Pass/Fail)
4. Capture screenshots for defects
5. Document defects in `manual-testing/defects/`

**Test Credentials:**
- Username: `standard_user`
- Password: `secret_sauce`

---

### UI Automation Testing

#### Setup

```bash
cd ui-automation

# Install Maven dependencies
mvn clean install
```

#### Run Tests

**Using IDE (Eclipse):**
1. Import project as Maven project
2. Right-click `StandardUserTests.java`
3. Select **Run As → TestNG Test**

#### Test Execution Order

Tests execute with priority-based sequencing:
1. Login with valid credentials
2. Verify inventory page
3. Sort products by price
4. Add items to cart
5. Remove items from cart
6. Complete checkout
7. Logout
8. Negative scenarios (invalid login, missing checkout info)

**Test Environment:**
- OS: macOS
- Browser: Safari
- Implicit Wait: 3 seconds

---

## Test Results and Evidence

### API Testing Results
- **Location**: `api-testing/results/`
- **Total Requests Tested**: 26
- **Pass Rate**: 100%
- **Evidence**: Postman test results, Newman HTML reports

### Performance Testing Results
- **Location**: `performance-testing/results/`
- **Total Requests**: 4,950
- **Error Rate**: 0.00%
- **All Thresholds**:  PASSED
- **Evidence**: k6 console output, JSON result files

### Manual Testing Results
- **Location**: `manual-testing/test-cases/Final-Testcases-excelsheet-Htu.xlsx`
- **Test Cases Executed**: 44
- **Defects Found**: Documented in `manual-testing/defects/`
- **Evidence**: Screenshots in `manual-testing/evidence/`

### UI Automation Results
- **Location**: `ui-automation/test-output/`
- **Test Cases**: 8 (6 positive, 2 negative)
- **Pass Rate**: As per TestNG report
- **Evidence**: TestNG HTML reports, console logs

### Defect Management

All defects identified during testing are documented in Excel-based defect logs with the following information:

- **Defect ID**: Unique identifier for tracking
- **Summary**: Brief description of the issue
- **Steps to Reproduce**: Detailed reproduction steps
- **Expected Result**: What should happen
- **Actual Result**: What actually happened
- **Severity and Priority**: Impact classification
- **Evidence**: Screenshots and logs

**Defect Location**: `manual-testing/defects/`

---



##  Key Findings

### API Testing
 All authentication flows working correctly  
 CRUD operations validated successfully  
 Error handling for invalid IDs functioning properly  
 Response times consistently under threshold  

### Performance Testing
 All endpoints perform well under expected load  
 Zero failed requests during load test  
 Response times well within acceptable limits  
 Slight performance degradation with large payloads (`GET /products`)

### Manual Testing
 Core user flows functioning as expected  
 Critical defects identified and documented  
 Input validation issues in checkout form  

### UI Automation
 Automated regression suite covers critical paths  
 Both positive and negative scenarios validated  
 Stable execution on Safari browser  



---



