# TestZendeskSell

## Getting Started
Current test framework allow user to run end-to-end scenario 
(described at testScenario.txt file) on Zendesk Sell Web application;

### Prerequisites
- Java 8;
- Maven;
- TestNG;
- Selenium; 
- Selenium-chrome-driver (placed at drivers project folder);
- Suitable Command line (CMD or GIT Bash);

### Installing
- Download project from GIT repo using next link https://github.com/stepantzov/TestZendesk.git
- Check that all the necessary prerequisites from above Prerequisites are met. 

### Running the framework 
- Open any command line: CMD or GIT Bash;
- Navigate to the project catalog classpath using command line (for example "C:\Maven\TestZendesk")
- Use standard maven commands to run different maven lifecycle if needed;
- To build the project and run tests:
    **mvn package**
- To run tests separately please use: 
    **mvn test**
- To run tests inside IntelliJ use the  **testng.xml** configuration placed at project classpath;


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors
Ivan Stepantsov