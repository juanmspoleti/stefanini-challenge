# Stefanini project

## Installation
You need to have:

* [JDK 1.8](https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html) (to run Kotlin)
* [Maven](https://maven.apache.org/download.cgi) (if we want to run in console, instead of Intellij IDEA or Eclipse)
* Set JAVA_HOME and MAVEN_HOME environment variables.

## How it works
We have a BDD structure, so I recommend that see first the features file, then go step after step understand his behaviour.

## Run
### All testcases:
mvn clean test -Pdev

### Only Smoke suite for example:
mvn clean test -Pprod "-Dcucumber.filter=-t @Smoke"

#### Functionalities available:
@Nombre
@Error
@Email
@Password
@Registro
@Exitoso

### For debug:
We need to add -DforkCount=0 like this: <b>mvn clean test -DforkCount=0</b>

## Multi browsers
By default, the framework runs with Chrome, to run with Firefox add to the mvn command line: -Dbrowser=firefox For example: <b>mvn clean test -Dbrowser=firefox</b>

### Include report:
We need execute with "verify" instead of "test" like this: <b>mvn clean verify -Pdev</b>
I included the reports folder in the repository, so you can see how it looks.
Open overview.features.html file in a browser.

#### Browsers available:
* chrome 
* firefox

## Technologies used:
* [Kotlin](https://kotlinlang.org/)
* Maven
* Selenium
* TestNG (runner)
* Cucumber (BDD)
* Log4j (logger)
* [Bonigarcia](https://github.com/bonigarcia/webdrivermanager) (setup drivers automatically)
* This was made in [Intellij IDEA](https://www.jetbrains.com/idea/)