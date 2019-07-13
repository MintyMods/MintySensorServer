# MSS Minty's Sensor Server
MSS - Minty Sensor Server is an attempt to create a RESTful web service exposing the various hardware sensor information provided by 3rd party software components:-
   * [HWiNFO](https://www.hwinfo.com) 
   * [GPU-Z](https://www.techpowerup.com/gpuz/) 
   * [Open Hardware Monitor](https://openhardwaremonitor.org/) 

## Features
   * Create Views showing selected sensor information
   * REST end point serving JSON responses
   * Authentication Support 
   * SSL/HTTPS support for secure connections
   * Backed by a database for optional history of sensor information
   * Runs as a Windows Service (via Apache ProcRun)
   * Configurable Alerts in the form of Push Notifications
   * Remote sensor monitoring


## For more information see the following projects:-
* MSS : [Minty Sensor Server](https://github.com/MintyMods/MintySensorServer)
* MSM : [Minty Sensor Monitor](https://github.com/MintyMods/MintySensorMonitor)
* MSM2MSS : [Minty Sensor Monitor 2 Minty Sensor Server JNI Wrapper](https://github.com/MintyMods/MintySm2MintySsJniWrapper)
   
## Current Stack
SENSORS <-?-> HWiNFO <-SHM-> MSM[C#] <-JSON-> MSM2MSS[C++] <-JSON-> MSS[JNI] <-JSON-> API[JAVA:REST/JSON/HTML]

 - **Full Project Stack:-**
	- Raw Sensor Information 
	- <--?:Sensor Information Providers:?-->
	- <--*SHM::DLL*--> 
	- **MsmServiceInterface** 
	- <--*MSMRequest::MSMResponse*--> 
	- **MSM**[C#] 
	- <--*MSMRequest::MSMResponse*--> 
	- **MSM2MSS**[C++] 
	- <--*MSMRequest::MSMResponse*--> 
	- **MSS**[JNI] 
	- <--*MSMRequest::MSMResponse*--> 
	- **API**[JAVA:REST/JSON]
	- <--HTTP::HTML-->
   
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. The following prerequisites are required for building the project from source on a Windows OS. If your OS of choice is not Windows then you probably don't need my help anyway :) 

For runtime installation and requirements see [MintySS.md](doc/MintySS.md) 

### Pre-requisites

  * <b>HWiNFO64</b> is required to be installed and running with the sensor window minimised or open.
  * <b>JAVA 1.8+ JDK</b> is required to be installed. Only a JRE is required for running MintySS but a JDK is required for building from source code.<br/>
  * <b>Optional : </b>An Java IDE of choice for source code modification/GIT/Maven integration.<br/>

See [Prerequisites.md](doc/PREREQUISITES.md) for more information on installing and testing these pre-requisites.

## Clone the repository to obtain the source code

Create a root directory location to store the repository within and navigate to the directory via a command prompt. Issue the following command to have GIT clone the MintySS repository for you:-

```
git clone https://github.com/MintyMods/MintySS.git
```

This should connect to GitHub and download the repository for you:-

```
C:\GitRepository\test>git clone https://github.com/MintyMods/MintySS.git
Cloning into 'MintySS'...
remote: Enumerating objects: 151, done.
remote: Counting objects: 100% (151/151), done.
remote: Compressing objects: 100% (111/111), done.
Receiremote: Total 151 (delta 36), reused 82 (delta 0), pack-reused 0
Receiving objects: 100% (151/151), 33.55 KiB | 648.00 KiB/s, done.
Resolving deltas: 100% (36/36), done.

C:\GitRepository\test>dir
 Volume in drive C is Windows
 Volume Serial Number is 84BD-9284

 Directory of C:\GitRepository\test

30/05/2019  10:11    <DIR>          .
30/05/2019  10:11    <DIR>          ..
30/05/2019  10:11    <DIR>          MintySS
```

## Setup the Dependencies

Now we have quite a few dependencies and those dependent libraries have there own specific dependencies. My current preferred choice to manage these and how this project has been configured is obviously with Maven.

Navigate to the directory where you down-loaded the clone of this projects repository and ensure you can see a file called pom.xml then type the following command for Maven to start you off:-

```
mvn -Dmaven.test.skip=true package

```

Or if you don't have Maven installed and are using the supplied wrapper:-

```
mvnw -Dmaven.test.skip=true package

```


This should download all the required dependencies before hopefully compiling the code. Example output will be something like:-

```
E:\Development\MintySS\MintySS>mvn -Dmaven.test.skip=true compile
[INFO] Scanning for projects...
[INFO]
[INFO] -------------------------< com.mintymods:mss >--------------------------
[INFO] Building mss 1.0
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mss ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory E:\Development\MintySS\MintySS\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mss ---
[INFO] Nothing to compile - all classes are up to date
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.654 s
[INFO] Finished at: 2019-05-29T21:52:46+01:00
[INFO] ------------------------------------------------------------------------
```

## Running the tests

Running the provided tests can be done via the test command to Maven as follows:-

```
mvn clean test compile 

```

Or if you don't have Maven installed and are using the supplied wrapper:-

```
mvnw clean test compile 

```



This will run all the currently provided unit test cases and should report something along the lines of (hopefully all tests passing):-

```
[INFO] Scanning for projects...
[INFO]
[INFO] -------------------------< com.mintymods:mss >--------------------------
[INFO] Building mss 1.0
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mss ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory E:\Development\MintySS\MintySS\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mss ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ mss ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ mss ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ mss ---
[INFO] Surefire report directory: E:\Development\MintySS\MintySS\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mintymods.mss.swagger.TestSwagger
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.031 sec
Running com.mintymods.mss.utils.TestConfig
ERROR StatusLogger No Log4j 2 configuration file found. Using default configuration (logging only errors to the console), or user programmatically provided configurations. Set system property 'log4j2.debug' to show Log4j 2 internal initialization logging. See https://logging.apache.org/log4j/2.x/manual/configuration.html for instructions on how to configure Log4j 2
21:54:45.234 [main] ERROR com.mintymods.mss.Config - Unable to find property key @config.swagger.basepath #Values:application.name:MSS
21:54:45.238 [main] ERROR com.mintymods.mss.Config - Unable to find property key @should.not.exist #Values:config.swagger.basepath:/application.name:MSSconfig.swagger.schemes:http,https,wsconfig.swagger.host:localhost
21:54:45.238 [main] ERROR com.mintymods.mss.Config - Unable to find property key @config.swagger.basepath #Values:application.name:MSS
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.167 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.237 s
[INFO] Finished at: 2019-05-29T21:54:45+01:00
[INFO] ------------------------------------------------------------------------
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* [HandleBars](https://handlebarsjs.com/) - Template Engine
* [Spring Boot](https://start.spring.io/) The right stack for the right job
* [Chart.js](https://www.chartjs.org/) Simple yet flexible JavaScript charting

## Contributing

Please read [CONTRIBUTING.md](doc/CONTRIBUTING.md) for details on the code of conduct, and the process for submitting pull requests.


## Authors

* ** Rob Gregory (Minty) ** - *Initial work* - [MintySS](https://github.com/MintyMods/MintySS)

See also the list of [contributors](doc/CONTRIBUTORS.md) who participated in this project.

## Acknowledgments

  * HWiNFO - Martin Malik for his help with the sensor integration [HWiNFO](http://hwinfo.com)
  * PurpleBooth - Billie Thompson for the GitHub documentation templates (the thing you are reading now) [PurpleBooth](https://gist.github.com/PurpleBooth)
  
### License
MSS is licensed under The [GNU General Public License version 3](https://www.gnu.org/licenses/gpl-3.0.en.html).
  
  
  
