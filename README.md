# 🚀 API Automation Programs

### Author: AuTelipi

Welcome to the **API Automation Programs** repository!  
This project is your complete guide and hands-on workspace for mastering **REST API test automation using Java**. It leverages tools like **Rest Assured**, **TestNG**, **Allure**, and **Apache POI** for real-world, data-driven testing.

---

## 📘 What You'll Learn

- ✅ Fundamentals of REST API testing
- 🔄 CRUD operations: `GET`, `POST`, `PUT`, `PATCH`, `DELETE`
- 🧪 Writing and organizing test cases using **TestNG**
- 📊 Generating elegant and insightful reports with **Allure**
- 📈 Performing data-driven testing using **Apache POI (Excel)**

---

## ⚙️ Technologies & Tools Used

| Category               | Tools / Frameworks                               |
|------------------------|--------------------------------------------------|
| Programming Language   | Java                                             |
| API Testing            | Rest Assured                                     |
| Test Framework         | TestNG                                           |
| Reporting              | Allure                                           |
| Data Handling          | Apache POI (Excel)                               |
| Build Tool             | Maven                                            |
| IDE                    | IntelliJ IDEA                                    |
| Version Control        | Git                                              |

---

## 📁 Project Structure
```
APIAutomationPrograms/
├── src/
│ └── main/java/com/LipiAutomation/ # (If any core logic)
│
├── test/java/com/LipiAutomation/
│ ├── Ex_01_RA_Basics # Basic Rest Assured examples
│ ├── Ex_02_RA_Concepts # Advanced Rest Assured examples
│ ├── Ex_03_TestNG_AllureReport # Allure integrated tests
│ └── Homework_5th_Aug # Assignments / exercises
│
├── testng_temp.xml # Temporary TestNG suite
├── pom.xml # Maven dependencies
├── .gitignore # Git ignore rules
└── README.md # You're here!
```

---

## 🚀 Getting Started

### 🛠️ Prerequisites
- JDK 8 or higher
- Maven
- IntelliJ IDEA (recommended)

### 🔧 Installation

```bash
git clone https://github.com/AuTelipi/APIAutomationPrograms.git
cd APIAutomationPrograms
mvn clean install
```

---

### 🧪 Running Tests
You can run tests in two ways:

✅ From IntelliJ:
Open any test file or use testng_temp.xml to run the suite directly.

✅ Using Maven:
```bash
mvn test
```

---

### 📊 Reporting with Allure
After test execution, generate and open Allure reports:
```bash
allure serve
```
Make sure Allure CLI is installed and configured in your system.

---

###📎 Additional Notes
- ✅ Test cases are organized into folders for progressive learning (basics, advanced, Allure, assignments).
- 📊 Excel files are used for data-driven automation (check resources folder if added).
- 📝 Homework and assignment folders are included to reinforce learning.

---
