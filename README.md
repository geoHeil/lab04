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

Compile the following hadoop container https://github.com/lresende/docker-yarn-cluster
and then run it using
```
docker-compose up -d
docker exec -ti namenode /bin/bash
```
Create a jar using `gradle jar`. It can be submitted as a job to the hadoop cluster as follows:
```
cd $HADOOP_PREFIX

# add input files
bin/hdfs dfs -mkdir -p /user/root
bin/hdfs dfs -put $HADOOP_PREFIX/etc/hadoop/ input

# run the mapreduce
bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar grep input output 'dfs[a-z.]+'

# check the output
bin/hdfs dfs -cat output/*
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

First, select the class `src:edu.liu.geoheil.JoinMain`, right-click and choose *Run*.
This will create a run configuration for the hadoop-part of the exercise.
 
First, select the class `src:edu.liu.geoheil.ReadXMLFile`, right-click and choose *Run*.
This will create a run configuration for the pre-processing step of the exercise.
 
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
  - the DeweyIDs could be generated using https://code.google.com/p/ufrgs-dbproject/source/browse/trunk/xml-relational-mapper/src/main/java/br/ufrgs/dbproject/idgenerator/DeweyIDGenerator.java?r=24&spec=svn24

## Improvements
  - use https://github.com/linkedin/linkedin-gradle-plugin-for-apache-hadoop/wiki/Hadoop-DSL-Language-Reference
  - fix problems in docker-deploy `gradle dockerBuildImage
