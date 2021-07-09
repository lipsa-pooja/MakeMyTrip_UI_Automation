# MakeMyTrip_UI_Automation
BDD Cucumber Framework with Selenium and Java

Project Description:
  - Project have implemented to Automate the scenarios of MakeMyTrip.com application.
  - Here we have automated the Ticket Booking End-to-End flow.
  - This project illustrate design of Hybrid Framework with Page Object Model (POM) with Cucumber BDD & Selenium.
  
Project Component:
  - Driver Factory Library - Initalize required ThreadLocal WebDriver depends on browser.
  - Component Library      - Provide all required element wrapper methods.
  - Element Utility        - Provide all required element action wrapper utility.
  - ConfigReader           - Library that read properties from property file.
  
  
    feature Files              : Cucumber Feature file holds all required Cucumber feature file.
                                 /src/test/resources/featureFiles
                 
    Step Defination           : Holds respective step definations class.
                                /src/test/java/stepDefination
                                
    Page Library              : Page Classes for POM
                                /src/main/java/com/org/pages
                                
    Constant Library           : All input data  to be tried out by various test methods woulbe be going into this directory
                                 /src/main/java/com/org/util/Constants.java
                                
    Application Hooks         : Cucumber Hooks with before and after
                                /src/test/java/appHooks/ApplicationHook.java
                                
    Config                    : Holds input data that needs to be pass to Test Method.
                                /src/test/resources/config/config.properties
                                
    Test Runner               : Test Runners in JUnit
                                /src/test/java/testRunner/TestRunner.java
                                
    Reporting Property        : All required input to generate HTML Extent Spark and PDF Report with Test Method results.
                                /src/test/resources/extent.properties
                                /src/test/resources/extent-config.xml
                                /src/test/resources/cucumber.properties
                                
 Technologies Used:

     1. Selenium WebDriver with Java Language binding
     2. Cucumber 6.x JVM library
     3. WebDriverManager
     4. JDK 1.8
     5. Maven (Build tool)
     6. Maven Plugins
     7. Cucumber extent report 6 adapter
     8. JUnit 4.x library
     9. Eclipse (IDE)
     
     
Execution:

  - To Execute All the Feature file navigate to /src/test/java/testRunner/TestRunner.java class and execute with help of JUnit 4.
  - To execute specific Feature file, mention the required feature file in MyTestRunner.java class and run with JUnit 4.
  - To Execute on Maven 
      ```mvn clean test```
