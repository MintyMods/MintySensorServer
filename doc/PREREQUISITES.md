## Installing Prerequisites 

#HWiNFO
Install HWiNFO by visiting [HWiNFO.com](http://hwinfo.com) and following the links to download and install. Once installed you will need to configure HWiNFO to run with the sensor window activated. This can be auto shown and auto minimised using the HWiNFO settings section. <br/>Any problems installing or using this software then I suggest you pop on over to [HWiNFO forums](https://www.hwinfo.com/forum/) and you will find help there.<br/>
<br/>
Testing HWiNFO is pretty obvious as it has a lovely GUI that you can see and going into the setting available via this application is beyond the scope of this document.

#JDK 1.8+
Install any compatible Java 1.8 JDK and configure a JAVA_HOME system variable to point at the installation directory of the JDK:-

```
JAVA_HOME=E:/Development/java/JDK1.8
```

Modify the local 'PATH' system environment variable to include to the bin directory of the JDK install:-


```
PATH=%JAVA_HOME%/bin;%PATH%;
```

To test your JAVA installation ensure you have configured the above JAVA_HOME system variable before opening a command prompt then type the following:-

```
echo JAVA_HOME=%JAVA_HOME%
java -version
javah -version
javac -version

```

The first command should confirm your JAVA_HOME location and <b>All</b> three of the following commands should return the same Java version of <b>at least 1.8</b> for example:-

```
E:\Development>echo JAVA_HOME=%JAVA_HOME%
JAVA_HOME=E:\Development\java\JDK1.8

E:\Development>java -version
java version "1.8.0_211"
Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)

E:\Development>javah -version
javah version "1.8.0_211"

E:\Development>javac -version
javac 1.8.0_211

```

#Installing Maven 
Install Maven by visiting [Maven@Apache](http://maven.apache.org/download.cgi) and install to a folder of your choice '<your maven installation directory>'. 
Add a MAVEN_HOME system variables, and point it to the root of the folder:-

```
MAVEN_HOME=<your maven installation directory>
```

Modify the local 'PATH' system environment variable to include the bin directory of the Maven install:-

```
PATH=%MAVEN_HOME%/bin;%PATH%;
```

To test the Maven install ensure you have configured the above MAVEN_HOME system variable before opening a command prompt then type the following:-


```
mvn --version
```

#Building Without Installing Maven
The repository includes a Maven Wrapper by [Baeldung](https://www.baeldung.com/maven-wrapper) which can be used as an alternative to installing Maven
To use the wrapper you simple type mvnw rather than mvn 

To test the Maven install ensure you have configured the above MAVEN_HOME system variable before opening a command prompt then type the following:-


```
mvnw --version
```

This should return something along the lines of the following:-

```
E:\Development\MintySS\MintySS>mvnw -version
Found "E:\Development\MintySS\MintySS\.mvn\wrapper\maven-wrapper.jar"
Apache Maven 3.6.0 (97c98ec64a1fdfee7Hi7ce5ffb20918da4f719f3; 2018-10-24T19:41:47+01:00)
Maven home: C:\Users\Minty\.m2\wrapper\dists\apache-maven-3.6.0-bin\2dakv70gp803gtm5ve1ufmvttn\apache-maven-3.6.0
Java version: 1.8.0_211, vendor: Oracle Corporation, runtime: E:\Development\java\JDK1.8\jre
Default locale: en_GB, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

Usage is the same as using the native Maven client

[Back to README.md](../README.md)