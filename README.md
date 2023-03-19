# gumtree-be-test
Test for Gumtree as Senior BE

## Background
This is the home task developed according to requirements given together with this task, it could be referenced below


## The task

Your task is to develop a small java application. We need you to build your application in your own GitHub repository.  Please do not fork our repository to create your project.  Once you are done, send us a link to your repository.

Please allow yourself at least 1 hour of uninterrupted time for this task, but feel free to spend as much time on the task as you like and make the solution and the code as perfect as you like.

## The application

Your application needs to read the attached AddressBook file and answer the following questions:

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

Some insights into what we'll be looking for (and what we will not):

- Feel free to use any dependency management and build tools eg maven or gradle
- Please do not use database, we are more interested in your Java skills than your SQL skills
- Feel free to commit as often as you'd like. The more commits the better! Please commit at least once within the first hour
- It's better to complete 1 task than to start 3
- Feel free to use any java libraries you feel appropriate
- We will be looking at how you approach the task (e.g. how you break it into sub-tasks) and how you structure your code to answer the questions


## Development Setup
**This task was build using the following**

* JDK 17
* Git
* Maven v.3.6.3
* IntelliJ

## Running the application
**The manual how to run this application without IDE**

1. git clone git@github.com:pkonopacki/gumtree-be-test.git (SSH)
2. cd gumtree-be-test
2. mvn clean test (8 test should be passing)
3. mvn clean install
4. java -jar target/gumtree-test-1.0-SNAPSHOT.jar
5. The outcome should be printed to the console


## Decision / Trade-offs made during development

- The number of tests was limited to minimum due to time restrictions
- There is no layer of mock tests which should be present especially testing the AddressBookService
- All tests are sort of integration tests as they read from the file
- I would introduce more tests on various levels especially negative scenarios (there is one for malformed file)
- The application was developed as required - simple java application
- There is no extensive exception handling
- The functionality works asa expected, all three requirements were implemented

## I hope you will like the code and understand limitations mentioned above

## Thank you very much, I am very curious about the feedback. Please provide constructive criticism and maybe the good parts as well.






