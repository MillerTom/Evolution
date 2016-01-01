Temporary instructions until we are on Github...



To get the maven build to work successfully, you need to install the vistaLink libraries into your local m2 repository for now. Eventually these should be hosted on github repo

Download maven from
http://maven.apache.org/download.cgi

I am using 3.1.1 version

Unzip the file
Optionally you can update your PATH variable for windows so it can find the mvn executable (Example : C:\apache-maven-3.1.1\bin)

Execute these commands from command prompt

mvn install:install-file -Dfile=vljConnector-1.6.0.028.jar -DgroupId=gov.va.med -DartifactId=vljConnector -Dversion=1.6.0.028 -Dpackaging=jar

mvn install:install-file -Dfile=vljFoundationsLib-1.6.0.028.jar -DgroupId=gov.va.med -DartifactId=vljFoundationsLib -Dversion=1.6.0.028 -Dpackaging=jar

mvn install:install-file -Dfile=vljSecurity-1.6.0.028.jar -DgroupId=gov.va.med -DartifactId=vljSecurity -Dversion=1.6.0.028 -Dpackaging=jar

mvn install:install-file -Dfile=was_public-8.0.0.jar -DgroupId=com.ibm.websphere.appserver -DartifactId=was_public -Dversion=8.0.0 -Dpackaging=jar

this assumes it’s in the local directory where you issue the mvn command, otherwise you need to include the full path (example -Dfile={path-to-file}vljFoundationsLib-1.6.0.028.jar)

running mvn clean package from either eclipse should work…except the tests fail

to skip the tests from command line.

mvn –DskipTests clean package

To run maven in Eclipse

right click pom.xml -> select Run As...Maven Build...

In the Goals textbox, add "clean package"

to skip the tests, select the Skip Tests checkbox
