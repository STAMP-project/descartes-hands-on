# Descartes hands-on

This project is a quick introduction to the use of [Descartes](https://github.com/STAMP-project/pitest-descartes) and  the type of testing issues that can be discovered with the help of this tool.

The project consists of a single class [VersionedList](src/main/java/eu/stamp_project/examples/VersionedList.java) and a single test class ([VersionedListTest](src/test/java/eu/stamp_project/examples/VersionedListTest.java)) with two test cases.


## Pre-requisites

The project requires Java, Maven and an Internet connection to import all dependencies.

## How to use it?

[PitMP](https://github.com/STAMP-project/pitmp-maven-plugin) and [Descartes](https://github.com/STAMP-project/pitest-descartes) are already configured in the [pom.xml](pom.xml#L28-L41) file as follows:

```xml
<plugin>
<groupId>eu.stamp-project</groupId>
<artifactId>pitmp-maven-plugin</artifactId>
<version>1.3.6</version>
<configuration>
    <outputFormats>
        <value>HTML</value>
        <value>JSON</value>
        <value>METHODS</value>
        <value>ISSUES</value>
    </outputFormats>
    <timestampedReports>false</timestampedReports>
</configuration>
</plugin>
```

To use Descartes then run `mvn clean test pitmp:descartes`. This command will first run the test suite and then execute Descartes to obtain a report on potential testing issues. 

The execution of this sequence of Maven goals creates a directory named `pit-reports` inside the `target` directory. This directory will contain the following files:

* `index.html`: Default PIT report. Shows the line coverage, the transformations applied to each method and which ones were detected by the test suite.
* `mutations.json`: Contains the list of transformations that were applied to the source code and for each one of them the test cases that executed the transformation and whether it was detected or not. The purpose of this file is to support automated workflows.
* `methods.json`: Contains the transformations reported in `mutations.json` but aggregated by the methods in which they were created. Each method is classified as follows:
    - *pseudo-tested*: No transformation applied to the method was detected by the test suite.
    - *tested*: All transformations applied to the method were detected by the test suite.
    - *partially-tested*: The method shows mixed results: there are detected and undetected transformations at the same time.


## Additional resources

* The [PIT official website](http://pitest.org) includes the complete list of parameters that can be configure to customize the execution of PIT.
* Code repositories for [PIT](https://github.com/hcoles/pitest), [PitMP](https://github.com/STAMP-project/pitmp-maven-plugin) and [Descartes](https://github.com/STAMP-project/pitest-descartes).
* [ptm-examples](https://github.com/STAMP-project/ptm-examples) contains simplified examples of testing issues that have been found in real-life open-source projects.
* [descartes-experiments](https://github.com/STAMP-project/descartes-experiments) contains reports of the application of Descartes to real-life projects.



