Cayenne
========

This module will allow a user or project to create a whole fully functioning automated test framework in under 2 minutes... 
By the end of this, the project will have access to the centralised framework and some sample tests all ready for the team to begin testing.

This module uses the centralised framework where all configuration is carried out. Therefore providing the project with a location where tests can be written and wiping out all the time needed to get a framework installed. 

The centralised framework is found here: **https://github.com/usman-h/Habanero.git**
It can be cloned and can be worked on by forking the project. This combined with Habanero provide a new project/programme an extremely setup with all the tools instantly available to them. 
This will also proved management consistency in how test is carried out, as well simplifying maintenance of the framework, and dependencies.

# Project creation:

* First clone this project to a location you are comfortable with, we will call it '*home*'
* Open command prompt (cmd) and cd to *home*. You should see the POM.xml here
* Run: **mvn clean compile** (if required) 
* Then run: **mvn clean archetype:create-from-project**
* After that is successful, cd to **target\generated-sources\archetype**
* Run: **mvn clean install**; This will place the archetype jar in your very own *.m2\repository\org\apache\maven\archetypes* folder
* Create a brand new folder and name it after your project
* Within cmd, cd to the folder

**Now you are able to generate a project one of two ways.**


**OPTION 1**
* Within cmd run: **mvn archetype:generate**
* When this command runs it will ask you to "**Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1057:**"

 Then on the left hand side you will see some numbers followed by some text. Enter in the last number you see.
 It should appear as something like this: 
 "***1963**: local -> com.usmanhussain.cayenne:Cayenne-archetype (com.usmanhussain.cayenne - Cayenne is a set up project for any  programme or project for getting started
        with test automation using Habanero.
        It allows you to have a fully working and ready to use Test Automation framework in a matter of minutes. The
        framework creates a project for the user using the Habanero project.
        The folder definition and set up utilise the framework, 'Habanero' which can be found here:
        https://github.com/usman-h/Habanero)*"
        
 In the example above you should enter in **1963**
* As you run this command it will prompt you to fill out your *GroupID, ArtifactID, Name etc...*


**OPTION 2**
* Alternatively you can run a single command containing these details e.g.
  **mvn archetype:generate -DgroupId=[yourGroupID] -DartifactId=[yourArtifactId] -DarchetypeArtifactId=archetypeProj-archetype -DinteractiveMode=false**
 
  
* Once this is done and built successfully take a look at your fully functioning project, ready to write automated tests against the UI, API's and Devices...
* Then just to make sure everything is fine, within cmd go to your new project folder and run the following command **mvn clean install**
* IF there are any issues please open up the pom.xml and replace the following lines with your **groupId** value (this is the same value you entered in before to create the project):

  Line 121: Replace the following within the *packages* tag *com.usmanhussain.cayenne.step_definitions* with your **groupId** (Please keep the *step_definitions* part, only replace the text/package name before it)
  
  Line 122: Replace the following within the *packages* tag *com.usmanhussain.cayenne.hooks* with your **groupId** (Please keep the *hooks* part, only replace the text/package name before it)
  
  Line 175: Replace the following within the *mainClass* tag *com.usmanhussain.cayenne.JSONReportMerger* with your **groupId** (Please keep the *JSONReporterMerger* part, only replace the text/package name before it)
  

**NOTE:** If you feel like you want to contribute or have any changes to the Habanero test framework, please Fork the project and send your changes in via a pull request. Alternatively if you just wish to utilise it you may either download it or clone it for referance.

The **Habanero** framework can be found here on GitHub: 
**https://github.com/usman-h/Habanero**

You may also use it directly in your own project by calling it from maven repository where further details can be found here:
**https://search.maven.org/#search%7Cga%7C1%7Ccom.usmanhussain.habanero**

OR

**https://mvnrepository.com/artifact/com.usmanhussain.habanero/Habanero**

Here you will be able to see what the latest version is, and how to call it as a dependency from your pom.xml
For any further questions please do not hesitate to contact me.

# How to run the tests

Once the project is set up, please do the following:
1. _mvn clean install -DskipTests_
2. _mvn clean test -DrunTags=@test1 -DdriverType=chrome_

This will allow the dummy tests to run, and you will be able to see the newly formed reports in the following folder:
\target\cucumber-html-reports\overview-features.html (Open this file in a browser)

You will also see the new reports with the detail inside them with shown, aiming to eliminate the analysis time it takes for atester to debug a failed test. 
These changes can be seen on project **Ghost**'s page: **https://github.com/usman-h/Ghost**

Kind regards,

Usman H Hussain


# **Happy Testing**
