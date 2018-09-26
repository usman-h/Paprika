Paprika
========

This project is a dummy project that allows all users to download and use the demo files to help them either:
1. Train or practice new concepts,
2. Use it as an education hub, so you can try out what you learn,
3. To use an existing project to run a small POC on,
4. To view general test automation code to see how to set up a project.

Paprika is based on the framework **Habanero** which is a centralised framework, constantly being updated to enhance its capability as well as ensuring it is in line with the latest technology stack and ways of working. 
**Habanero** can be found here: **https://github.com/usman-h/Habanero.git**

You are more than free to clone the repository to try out and use on your own. Please be aware that you will be able to try out new concepts on your local machine. IF you wish to incorporate them or share them with others then please do create a pull request.

# Getting Started:

* First clone this project to a location you are comfortable with, we will call it '*home*'
* Once you have the project locally, open command prompt (cmd)
* Run: **mvn clean compile** (if required) 
* Then run: **mvn clean install -DskipTests**
* After that is successful, to execute the demo test run **mvn test -Dcucumber.options="--tags @test1" -DdriverType=chrome**
* When the test finishes you can check the reports found in the following folder: **/target/cucumber-html-reports/**
* Then open up the following file in a browser (Chrome if possible): **overview-features.html**

Now you can run and change the tests and have FUN!

**NOTE:** If you feel like you want to contribute or have any changes to the **Habanero** test framework, please Fork the project and send your changes in via a pull request. Alternatively if you just wish to utilise it you may either download it or clone it for referance.

The **Habanero** framework can be found here on GitHub: 
**https://github.com/usman-h/Habanero**

You may also use it directly in your own project by calling it from maven repository where further details can be found here:
**https://search.maven.org/#search%7Cga%7C1%7Ccom.usmanhussain.habanero**

OR

**https://mvnrepository.com/artifact/com.usmanhussain.habanero/Habanero**

Here you will be able to see what the latest version is, and how to call it as a dependency from your pom.xml
For any further questions please do not hesitate to contact me.

Kind regards,

Usman H Hussain


# **Happy Testing**
