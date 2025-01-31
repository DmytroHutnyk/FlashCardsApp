
# Flashcards Application

## Description
A Spring Boot console application for learning and testing translations in multiple languages (English, German, and Polish) with the ability for future extension. Data is read from a file. Note v1 and v2 branches are extension of an application. v1 is implemented based on Entity Manager, v2 based on Spring Data JPA.

## Features
- **Dictionary Management**: Add and display words in multiple languages.
- **Quiz Mode**: Generate random quizzes to test your language skills.
- **Profiles Support**: Allows displaying words in different formats (`Original`, `UpperCase`, and `LowerCase`).

You can specify these formats by activating the corresponding Spring profile when starting the application.

## Technologies Used
- **Java 23**: Core programming language.
- **Spring Boot**: Framework for dependency injection and application setup.
- **Spring Profiles**: To manage environment-specific configurations.
- **Gradle**: For build and dependency management.

## Prerequisites
- **Java Development Kit (JDK)** 23.
- **Gradle** for building and running the application.
- A terminal or IDE (e.g., IntelliJ IDEA).

## Steps to Start the Application

### 1. Navigate to the Project Directory
Open a terminal and navigate to the root directory of your project (where the `build.gradle` file is located):

```bash
cd /path/to/your/project
```

### 2. Build the Project
Use the Gradle wrapper to build the application:

- **On Linux/Mac**:
  ```bash
  ./gradlew build
  ```
- **On Windows**:
  ```bash
  gradlew build
  ```

This command will:
- Compile the source code.
- Resolve dependencies.
- Package the application into an executable JAR file located in the `build/libs` directory.

Verify that the JAR file is created:

- **On Linux/Mac**:
  ```bash
  ls build/libs
  ```
- **On Windows**:
  ```bash
  dir build\libs
  ```

You should see a file like this:

```
TPO_02-0.0.1-SNAPSHOT.jar
```

### 3. Run the Application
Start the application using the `java -jar` command:

```bash
java -jar build/libs/TPO_02-0.0.1-SNAPSHOT.jar
```

### 4. Optional: Run with a Specific Profile
To run the application with a specific Spring Profile and display translations in a particular format, use:

- **Original (default)**:
  ```bash
  java -Dspring.profiles.active=Original -jar build/libs/TPO_02-0.0.1-SNAPSHOT.jar
  ```

- **UpperCase**:
  ```bash
  java -Dspring.profiles.active=UpperCase -jar build/libs/TPO_02-0.0.1-SNAPSHOT.jar
  ```

- **LowerCase**:
  ```bash
  java -Dspring.profiles.active=LowerCase -jar build/libs/TPO_02-0.0.1-SNAPSHOT.jar
  ```

## License
This project is licensed under the MIT License.
