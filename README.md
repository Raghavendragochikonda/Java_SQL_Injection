# Java_SQL_Injection
# SQL Injection Test with Selenium WebDriver

## Objective
This Java program is designed to interact with the OWASP Juice Shop login form and attempt a controlled SQL injection attack. The goal is to evaluate how the application responds to the attack by submitting a malicious username.

## Prerequisites
- Java Development Kit (JDK)
- Selenium WebDriver (Java bindings)
- ChromeDriver (ensure the correct version for your Chrome browser)
- A Java IDE or text editor
- Internet connection

## Setup Instructions

1. *Install Java and Selenium WebDriver:*
   - Ensure that JDK is installed and configured on your system.
   - Download Selenium WebDriver Java bindings from the official Selenium website.

2. *Download ChromeDriver:*
   - Download ChromeDriver that matches your Chrome browser version from the official ChromeDriver site.
   - Add the path to ChromeDriver in your system's PATH environment variable or specify it directly in the code.

3. *Run the Program:*
   - Compile and run the provided Java code in your IDE or from the command line.
   - Observe the output in the console to determine the result of the SQL injection attempt.

## Code Overview

- *Launching the Browser:* The program initializes a new Chrome browser instance using Selenium WebDriver.
- *Navigating to the URL:* It navigates to the OWASP Juice Shop login page.
- *Locating Elements:* The username and password fields are located using their respective id attributes.
- *SQL Injection Attempt:* A crafted malicious SQL injection string is entered into the username field, while a valid password is entered into the password field.
- *Form Submission:* The form is submitted by clicking the login button.
- *Error Detection:* The program waits for the page to load and then checks for any visible error messages indicating a failed SQL injection attempt.
- *Cleanup:* The browser is closed after the test is completed.

## Assumptions

- The OWASP Juice Shop is assumed to be configured in such a way that it provides feedback on SQL injection attempts (e.g., error messages).
- The program assumes a valid password is known for the test environment.
- This code should be executed in a safe, controlled environment.

## Exception Handling
The program includes basic exception handling to manage potential issues such as element identification failures, network issues, or unexpected page behavior. Any caught exceptions will be printed to the console.
