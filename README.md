# 🚀 Automation Framework (UI + API + DB)

📌 Overview

This project demonstrates a hybrid automation framework built using Selenium WebDriver, TestNG, and Rest Assured, designed to validate applications across UI, API, and database layers.
It follows real-world automation practices with a focus on scalability, maintainability, and layered testing.

🛠 Tech Stack
Java
Selenium WebDriver
TestNG
Rest Assured
Maven
Log4j2 (Logging)
Extent Reports (Reporting)
JDBC (Database validation concept)
🏗 Framework Design
Page Object Model (POM)
ThreadLocal WebDriver for parallel execution
Config-driven setup using properties file
Reusable utility classes (WaitUtils, TestDataUtil)
TestNG Listeners for reporting and execution control
✅ Key Features
UI Automation using ParaBank application
Positive and negative test scenarios
Parallel execution using TestNG
Cross-browser testing (Chrome, Edge)
API validation using Rest Assured
Database validation layer (conceptual implementation)
Screenshot capture on failure
Logging using Log4j2
🔄 Test Flow

UI → API → Database (layered validation approach)

▶️ How to Run
Clone the repository
Import as a Maven project
Execute tests using testng.xml
📊 Reports
Extent Reports generated after execution
Screenshots captured for failed test cases
⚠️ Note

API and database validations are implemented as conceptual demonstrations, as the ParaBank application is publicly accessible without direct database connectivity.

💡 Key Learning

This project focuses on building a scalable, maintainable, and enterprise-style automation framework, incorporating layered validation across UI, API, and backend concepts.

---
