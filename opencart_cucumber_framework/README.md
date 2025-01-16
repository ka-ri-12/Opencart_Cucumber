# OpenCart Automation Project - Cucumber

## Project Description
This project demonstrates the implementation of automation testing for the OpenCart web application using the **Cucumber framework** with **TestNG** and **Selenium WebDriver**. It includes a set of test scenarios designed to validate various functionalities of OpenCart. The tests are structured to ensure code reusability, scalability, and maintainability using Behavior-Driven Development (BDD).

## Features
- Framework: Cucumber with TestNG
- Programming Language: Java
- Number of Test Scenarios: More than 10
- Key Features:
  - Cucumber-based BDD test scenarios
  - TestNG for test execution and reporting
  - Selenium WebDriver for browser automation
  - Well-organized step definitions and feature files
  - Reusable page object model

## Requirements
1. **Java Development Kit (JDK)**: Version 8 or above
2. **TestNG**: Installed via Maven or IDE
3. **Maven**: To manage project dependencies
4. **IDE**: IntelliJ IDEA, Eclipse, or any Java-supported IDE
5. **Selenium WebDriver**: For automating browser actions
6. **Cucumber**: For writing BDD-style test cases
7. **Browser**: Chrome (or any other browser supported by the tests)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ka-ri-12/opencart_cucumber.git
2. Navigate to the project directory:
    ```bash
     cd opencart_cucumber
    ```
3. Open the project in your preferred IDE.
4. Ensure Maven dependencies are downloaded by refreshing the project.

## How to Run Tests
1. Open the `testRunner` file in the project.
2. Execute the test suite by:
   - Right-clicking the `testRunner` file and selecting **Run** (in IDEs like IntelliJ or Eclipse), or
   - Running the following Maven command in the terminal:
     ```bash
     mvn test
     ```
## Project Structure
- **src/main/java**: Contains the main application code (if applicable)
- **src/test/java**: Contains step definition classes for automation testing
-**src/test/resources**: Contains feature files with Cucumber scenarios
- **testRunner**: Configuration file for running test suites
- **pom.xml**: Maven Project Object Model file containing dependencies and build configuration

## Test Scenarios
The project includes automated test cases for the following scenarios:
1. Validating user registration with valid and invalid inputs
2. Validating user login functionality
3. Checking login functionality with data-driven tests using Excel
4. Testing contact us form submission with valid and invalid details
5. Verifying adding products to the shopping cart
6. Testing product search functionality and results
7. Verifying shopping cart functionality, including product removal and price calculation
8. Viewing order history and filtering past orders
9. Adding products to the wishlist and comparing them
10. Removing products from the wishlist 
11. Ensuring successful logout and session clearing

## Dependencies
1. **Selenium WebDriver**: For browser automation
2. **TestNG**: Testing framework
3. **Maven**: For managing dependencies and build lifecycle
4. **Cucumber**: For BDD-style testing

## Contribution
If you'd like to contribute to this project:
1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push to your forked repository.
4. Open a pull request explaining your changes.

## Author
**SK Karishma**

Feel free to reach out for any questions or suggestions!
