# Manual Testing

This folder contains all manual testing artifacts created to validate the
functional behavior of the SauceDemo web application from an end-user perspective.

Manual testing was the primary testing activity used to explore the system,
validate core user flows, and identify critical functional defects.

---

## Scope of Manual Testing

Manual testing focused on validating the following functional areas:

- User login and authentication
- Product inventory display
- Product sorting functionality
- Shopping cart operations (add and remove)
- Checkout workflow and input validation
- Logout and basic session handling

Both positive (happy path) and negative scenarios were executed to verify
system behavior under valid and invalid conditions.

---

## Test Design Techniques

The following test design techniques were applied during manual testing:

- End-to-end testing to validate complete user journeys
- Path-based testing to cover primary and alternative flows
- Positive testing for valid input scenarios
- Negative testing for invalid and missing input scenarios
- Exploratory testing to identify unexpected behavior
- Validation testing for form input and error handling

These techniques ensured coverage of core functionality and high-risk areas.

---

## Manual Test Cases Documentation

All manual test cases were documented and executed using an Excel-based test
case sheet:

Final-Testcases-excelsheet-Htu.xlsx


This Excel file includes the following columns:
- Test Case ID
- Test Scenario and Description
- Preconditions
- Test Steps
- Test Data
- Expected Result
- Actual Result
- Execution Status (Pass / Fail)
- Evidence Reference

The Excel sheet serves as the primary execution and tracking document for
manual testing activities.

---

## Folder Structure

manual-testing/
├── test-cases/ → Excel test case sheet and execution records
├── defects/ → Documented defects with descriptions and severity

---

## Defects and Evidence

Defects identified during manual testing were documented with:
- Clear reproduction steps
- Expected versus actual behavior
- Severity classification (Critical, High, Medium, Low)
- Supporting Evidence

Critical defect documentation is available under:
manual-testing/defects


These defects are also referenced and analyzed in the final QA technical report.

---