# 🚀 Automation Framework (UI + API + DB)

## 📌 Overview

This project demonstrates a hybrid automation framework built using Selenium WebDriver, TestNG, and RestAssured.
It covers end-to-end validation across UI, API, and database layers.

---

## 🛠 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* RestAssured
* Maven
* Log4j2 (Logging)
* Extent Reports (Reporting)
* JDBC (Database layer concept)

---

## 🏗 Framework Design

* Page Object Model (POM)
* ThreadLocal WebDriver for parallel execution
* Config-driven setup using properties file
* Utility classes (WaitUtils, TestDataUtil)
* Listener-based reporting (TestNG Listeners)

---

## ✅ Features

* UI Automation (ParaBank application)
* Positive and Negative test scenarios
* Parallel execution using TestNG
* Cross-browser testing (Chrome, Edge)
* API validation using RestAssured
* Database validation layer (conceptual implementation)
* Screenshot capture on failure
* Logging using Log4j2

---

## 🔄 Test Flow

UI → API → DB (conceptual validation)

---

## ▶️ How to Run

1. Clone the repository
2. Import as Maven project
3. Run using `testng.xml`

---

## 📊 Reports

* Extent Reports generated after execution
* Screenshots captured for failed tests

---

## ⚠️ Note

* API and DB validations are demonstrated conceptually since ParaBank is a public application without direct DB access

---

## 💡 Key Learning

This project focuses on building a scalable, maintainable automation framework with real-world design practices.

---
