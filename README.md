
# FundingSocieties Automation

This Project is to automate various scenarios for the website "https://fundingsocieties.com/"


## 🛠 Tech-stack
Selenium, Cucumber, Java, TestNG, Maven...


## Framework features

- Cross Browser Testing using Selenium Grid
- Cross Platform Testing
- Run from CommandLine
- Rerun failed tests
- Parallel Execution
- Extent Reports 
- Screenshots in 
- Page Object Model Design pattern for object repository



## Running Tests

To run tests, run the following command

```bash
  mvn test -PCucumberTests -Dbrowser=chrome -DPlatform=windows
```


## Path to Screenshots and Extent Reports

- test-output/Extent Report <DD-MM-YY HH-MM-SS>/SparkReport/spark.html

- test-output/Extent Report <DD-MM-YY HH-MM-SS>/screenshots


## Properties

You can edit the following Properties in your config/global.properties file

`browser` 

`platform` 

`host`

