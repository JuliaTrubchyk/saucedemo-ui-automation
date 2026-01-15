# SauceDemo UI Automation (Selenium + TestNG)

UI test automation framework for SauceDemo (Swag Labs): https://www.saucedemo.com/

## Tech Stack
- Oracle OpenJDK 21.0.3
- Selenium 4.39.0
- Maven
- TestNG 7.11.0
- Page Object Model (POM)
- IntelliJ IDEA

## Test Coverage (examples)
- Login
    - Valid login
    - Invalid password
    - Empty username / empty password validation
- Cart
    - Add item to cart and verify it is present
    - Remove item and verify cart updates
- Inventory
    - Sort products by Price (low to high) and verify order
- Checkout
    - Happy path checkout (complete order)
    - Required fields validation (first name / last name / postal code)
- Logout

## How to Run

### Option 1: Run from IntelliJ
1. Open `src/test/resources/test-suites/`
2. Run:
    - `smoke.xml`
    - `regression.xml`

### Option 2: Run from Terminal (Maven)
From the project root:

Smoke:
```bash
mvn test -DsuiteXmlFile=src/test/resources/test-suites/smoke.xml
```
Regression:
```bash
mvn test -DsuiteXmlFile=src/test/resources/test-suites/regression.xml
```

### Configuration

Test data is stored in:

`src/test/resources/config.properties`

Example keys:

- baseUrl
- username
- password

### Screenshots on Failure

When a test fails, a screenshot is saved to:

`target/screenshots/`

### Project Structure (high level)

src/main/java/com/yuliia/qa/pages – Page Objects

src/main/java/com/yuliia/qa/core – Base test setup

src/main/java/com/yuliia/qa/utils – Wait helpers

src/main/java/com/yuliia/qa/listeners – TestNG listeners

src/test/java/com/yuliia/qa/tests – Test classes

src/test/resources/test-suites – TestNG suite XML files



