# 1. Fitpeo Automation Testing

## 1.1 Introduction

This document discusses my experience testing the Fitpeo UI page.

## 1.2 Specifications

- **Automation tool:** Selenium
- **Programming language:** Java
- **Java version:** JDK 21
- **Selenium version:** 4.27.0

## 1.3 Set Up and Execution

1. Clone the repository.
2. Add the required JARs for Selenium (4.27.0 preferred) - [Download here](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.27.0/selenium-java-4.27.0.zip).
3. Run using an IDE or build the JAR, keeping the main class as `src/org/fitpeo/automation/FitpeoUIAutomation.java`.

As an alternative to the above steps, you can directly download the JAR tagged in the GitHub repo and execute it: [fitpeo_automation_testing.jar](https://github.com/Alhi786/fitpeo_automation_testing/releases/download/release_1.0/fitpeo_automation_testing.jar).

## 1.4 Issues Faced

- The user might face issues setting the slider to given values due to its high sensitivity. The least count of the slider was around 6 at 100% zoom of the browser, causing issues in sliding to the specific value provided in the assignment (820). This is dependent on the screen resolution and zoom level.
- In the requirement document, it was specified to set the slider value to 560 and later scroll and validate the total recurring reimbursement, which was $110,700. However, in the provided screenshots, the total individual patients count was 820. Therefore, I adjusted the slider value from 560 to 820 to get the desired output.

## 1.5 Conclusion

Overall, testing the application was a great experience and a new learning opportunity. Thanks for the opportunity.
