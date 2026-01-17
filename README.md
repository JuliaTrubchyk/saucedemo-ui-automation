## SauceDemo UI Automation (Selenium + TestNG)

[![Smoke UI Tests (TestNG)](https://github.com/JuliaTrubchyk/saucedemo-ui-automation/actions/workflows/smoke.yml/badge.svg?branch=main)](https://github.com/JuliaTrubchyk/saucedemo-ui-automation/actions/workflows/smoke.yml)
[![Nightly Regression UI Tests (TestNG)](https://github.com/JuliaTrubchyk/saucedemo-ui-automation/actions/workflows/nightly-regression.yml/badge.svg?branch=main)](https://github.com/JuliaTrubchyk/saucedemo-ui-automation/actions/workflows/nightly-regression.yml)

UI test automation framework for SauceDemo (Swag Labs): https://www.saucedemo.com/

This project demonstrates a real-world UI automation setup: **Page Object Model**, **smoke/regression suites**, and **CI runs in GitHub Actions** with downloadable **test reports** and **failure screenshots**.
## Tech Stack
- Java 21 (Temurin / OpenJDK)
- Selenium 4.39.0
- Maven
- TestNG 7.11.0
- Page Object Model (POM)
- IntelliJ IDEA
- GitHub Actions (CI)


## Framework Highlights
- **Page Object Model (POM)**: page classes separated from tests
- **TestNG suite execution**: `smoke.xml` and `regression.xml`
- **Groups support** for flexible test selection
- **Config-driven** base URL + credentials via `config.properties`
- **Explicit waits** (custom `Waits` helpers) for stable UI interactions
- **Screenshots on failure** saved to `target/screenshots/`
- **CI-ready** Chrome runs **headless** in GitHub Actions (Linux runners)

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

## How to Run Locally

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

## CI/CD (GitHub Actions)

- **Smoke** runs on every **push** and **pull request**
- **Regression** runs **nightly** on a schedule (and can be started manually)

Workflows:
- `.github/workflows/smoke.yml`
- `.github/workflows/nightly-regression.yml`

Reports:
- GitHub → **Actions** → open a run → **Artifacts**
- **Surefire reports**: `target/surefire-reports/` (always)
- **Screenshots**: `target/screenshots/` (only if created, usually on failures)


### Project Structure (high level)

src/main/java/com/yuliia/qa/pages – Page Objects

src/main/java/com/yuliia/qa/core – Base test setup

src/main/java/com/yuliia/qa/utils – Wait helpers

src/main/java/com/yuliia/qa/listeners – TestNG listeners

src/test/java/com/yuliia/qa/tests – Test classes

src/test/resources/test-suites – TestNG suite XML files



