APIAutomationPrograms 🚀
Author: AuTeLipi

Welcome to the APIAutomationPrograms repository! This project serves as your comprehensive guide and codebase for mastering REST API automation using Java, with hands-on examples leveraging Rest Assured, TestNG, Allure Reports, and Apache POI for real-world data-driven testing.

📚 What You Will Learn
Rest Assured fundamentals for robust API testing

CRUD operations:
GET | POST | PUT | PATCH | DELETE

Integrating and organizing tests with TestNG

Generating beautiful reports using Allure

Data-driven automation with Apache POI and Excel

🛠️ Technologies Used
Technology	Purpose
Java	Programming Language
Rest Assured	API Testing Framework
TestNG	Test Orchestration & Assertions
Allure	Reporting
Apache POI	Excel-based Data Manipulation
Maven	Build & Dependency Management
IntelliJ IDEA	Integrated Development Environment
📂 Project Structure
text
APIAutomationPrograms/
│
├── src/
│   ├── main/java/com/LipiAutomation/
│   │    └── ...               # Core business logic (if any)
│   └── test/java/com/LipiAutomation/
│         ├── Ex_01_RA_Basics        # Basic Rest Assured examples
│         ├── Ex_02_RA_Concepts      # Advanced Rest Assured concepts
│         ├── Ex_03_TestNG_AllureReport
│         └── Homework_5th_Aug       # Assignments & Learning
│
├── testng_temp.xml                  # TestNG suite file (temp/demo)
├── pom.xml                          # Maven dependencies
├── .gitignore                       # Git ignore rules
└── README.md                        # Project documentation (you’re here!)
💡 Getting Started
Clone this repo
git clone https://github.com/AuTeLipi/APIAutomationPrograms.git

Install dependencies
mvn clean install

Explore sample test cases

Find them under src/test/java/com/LipiAutomation/

Run tests via TestNG

Use any testng.xml or run directly from IntelliJ

Check out Allure reports

After running tests, generate reports using Allure CLI
