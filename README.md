## -- WORK IN PROGRESS --

### Project description

The goal of the project: creating a library for calls to PetClinic API. It can be used in other projects as external
dependency. The library is created as jar file.

### Technical description

- Used technologies: Groovy 3, Java 8, Gradle
- Used frameworks/libraries: RestAssured

### How to create jar file from project

- `gradlew clean jar`
- jar file is generated in a directory `/build/libs`

### Useful:

- [Building java libraries](https://docs.gradle.org/current/samples/sample_building_java_libraries.html)
- [Adding jar in gradle project](https://stackoverflow.com/questions/20700053/how-to-add-local-jar-file-dependency-to-build-gradle-file)
- [Factory method](https://refactoring.guru/design-patterns/factory-method)