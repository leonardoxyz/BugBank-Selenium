# BugBank Test Automation

This project contains automated tests for the BugBank web application (https://bugbank.netlify.app). The tests are implemented using Selenium WebDriver, JUnit 5, and follow the Page Object Model pattern.

## Project Structure

```
src/test/java/
├── BugBankTest/
│   └── BugBankTest.java         # Main test class
├── com/bugbank/
│   ├── base/
│   │   ├── BaseTest.java        # Base test configuration
│   │   └── DriverFactory.java   # WebDriver management
│   ├── pages/
│   │   ├── HomePage.java        # Home page interactions
│   │   ├── LoginPage.java       # Login page interactions
│   │   └── RegisterPage.java    # Registration page interactions
│   ├── pages/locators/
│   │   ├── HomePageLocators.java
│   │   ├── LoginPageLocators.java
│   │   └── RegisterLocators.java
│   └── utils/
│       └── VisualAssert.java    # Visual testing utilities
```

## Features

- Automated UI testing using Selenium WebDriver
- Visual regression testing using AShot
- Page Object Model implementation
- Automatic WebDriver management with WebDriverManager
- Screenshot comparison with tolerance for minor differences
- Automatic test user registration and login

## Test Cases

The project includes the following test scenarios:

1. **Extract Screen Validation**
   - Validates the visual appearance of the extract screen
   - Compares screenshots with expected baseline images

2. **Transfer Screen Validation**
   - Validates the visual appearance of the transfer screen
   - Compares screenshots with expected baseline images

3. **Exit Button Functionality**
   - Validates the visual appearance after clicking the exit button
   - Compares screenshots with expected baseline images

## Prerequisites

- Java 8 or higher
- Maven
- Chrome browser installed

## Dependencies

- Selenium WebDriver 4.10.0
- JUnit Jupiter 5.10.0
- WebDriverManager 5.8.0
- AShot 1.5.4 (for visual testing)

## Setup and Running Tests

1. Clone the repository
2. Navigate to the project directory
3. Run the tests using Maven:
   ```bash
   mvn test
   ```

## Visual Testing

The project uses AShot for visual regression testing. Screenshots are compared with baseline images stored in:
- `src/test/resources/extract-screenshots/`
- `src/test/resources/transference-screenshots/`
- `src/test/resources/exit-screenshots/`

When a test fails, a difference image is generated with the prefix "diff_" in the same directory as the baseline image.

## Best Practices Implemented

1. **Page Object Model**
   - Separation of page objects and test logic
   - Locators stored in separate classes
   - Reusable page methods

2. **Base Test Configuration**
   - Common setup and teardown in BaseTest class
   - Automatic WebDriver management
   - Automatic test user registration

3. **Visual Testing**
   - Screenshot comparison with tolerance
   - Automatic baseline image creation
   - Difference image generation for failed tests

4. **Wait Strategies**
   - Explicit waits for better reliability
   - Configurable timeout values

5. **Clean Code**
   - Descriptive test names using @DisplayName
   - Organized project structure
   - Reusable utility methods

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License. 