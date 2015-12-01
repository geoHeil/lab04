# LIU-TDDD43 Advanced Data Models and Databases lab4: NOSQL
This is my lab-exercise developed in a more reproducible + testable way: dependency management + docker-integration.
The "basic" exercise resides here: https://www.ida.liu.se/~TDDD43/themes/themeNOSQLlabs/LabNOSQL.pdf

## Installation

**Requirements**

  - Java JDK (8 or newer)
  - docker (kitematic on osx is recommended 1.9 or newer)
    - docker-machine
    - docker-compose
    
**Docker**
Make sure the local hadoop cluster is running using: 
```
docker-compose up -d
```

**IntelliJ Project**

 - Go to *File > Open* and choose the project's root directory. IntelliJ will automatically detect the Gradle project and set sensible defaults
 - Make sure the correct Java SDK is selected
 - If preferred, also tick the *Use auto-import* box
 - Confirm; the initial import may take a couple of minutes
 - Add the unregistered VCS root if applicable
 - Index all remote maven repositories if applicable
 - Confirm that the project language level is at least *Java 8 - Lambdas, type annotations etc.*
 
**Run Configurations**

**NOTE:**The (local) hadoop cluster is up and running before proceeding.

First, select the class `all:edu.liu.geoheil.Main`, right-click and choose *Run*.
This will create a run configuration. 
 
## CMD- usage
```
bin/hadoop dfs -cat /usr/joe/wordcount/input/file01 
```
## DEV hints
gradle.properties must contain credentials for docker-hub to work properly

## Useful commands

**stop all docker containers (local)**
```
docker-compose stop
```


## spoiler
  - Hive http://stackoverflow.com/questions/15276208/using-xpath-in-hive implements similar functionality.
  - Pig https://pig.apache.org/docs/r0.14.0/perf.html#nulls

## Improvements
  - use https://github.com/linkedin/linkedin-gradle-plugin-for-apache-hadoop/wiki/Hadoop-DSL-Language-Reference
