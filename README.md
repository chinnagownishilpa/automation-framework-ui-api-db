# Automation Framework - UI API DB

Enterprise-level automation framework developed using Selenium, Java, TestNG, RestAssured, Maven, and Extent Reports.

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- RestAssured
- Maven
- Extent Reports
- Apache POI
- JDBC
- GitHub
- Jenkins Ready

---

## Framework Features

### UI Automation
- Page Object Model (POM)
- Data-Driven Testing using Excel
- Retry Analyzer
- Screenshot Capture
- Wait Utilities
- Parallel Execution Support

### API Automation
- CRUD API Testing
- API Chaining
- Auth Token Generation
- JSON Schema Validation
- POJO Request Models
- Request/Response Reusable Utilities

### Reporting
- Extent Reports
- Console Logging
- Failure Screenshots

### Framework Utilities
- DriverFactory
- ConfigReader
- Listener Architecture
- Maven Surefire Execution
- Parallel TestNG Suites

---

## Project Structure

src/main/java
- api
- builders
- config
- database
- factory
- listeners
- reporting
- utils

src/test/java
- tests.ui
- tests.api
- dataproviders

---

## Execution

### Run API Suite

```bash
mvn test -DsuiteXmlFile=apitestng.xml

### Run UI Suite
mvn test -DsuiteXmlFile=testng.xml

## Reports

Extent reports are generated under:
reports/

### CI/CD

Framework is Jenkins-ready with Maven execution support.

Author

Shilpa
QA Automation Engineer