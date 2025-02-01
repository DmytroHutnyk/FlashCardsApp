
# Flashcards Command Line Interface Application

## Description
A Spring Boot console application for learning and testing translations in multiple languages (English, German, and Polish) with the ability for future extension. Data is read from a file. 

Note: `v1` and `v2` branches are extensions of the application. Possibility to Update and Delete a word is added.
- `v1` is implemented based on Entity Manager.
- `v2` is based on Spring Data JPA.


## Features
- **Dictionary Management**: Add and display words in multiple languages.
- **Quiz Mode**: Generate random quizzes to test your language skills.
- **Profiles Support**: Allows displaying words in different formats (`Original`, `UpperCase`, and `LowerCase`).

You can specify these formats by activating the corresponding Spring profile when starting the application.

## Technologies Used
- **Java 23**
- **Spring Boot**
- **Gradle**

## Prerequisites
- **Java Development Kit (JDK)** 23.
- **Gradle** for building and running the application.
- **GIT** for cloning the repository.
- A terminal or IDE (e.g., IntelliJ IDEA).

## Steps to Start the Application

### 1. Clone the Repository
Open a terminal and run:

```bash
git clone https://github.com/yourusername/your-repository.git
```
Replace yourusername and your-repository with your actual GitHub username and repository name.

### 2. Navigate to the Project Directory
Open a terminal and navigate to the root directory of your project (where the `build.gradle` file is located):

```bash
cd /path/to/your/project
```

### 3. Switch to the v1 or v2 Branch (Optionally)

```bash
git checkout v1
```

```bash
git checkout v2
```

### 4. Build the Project
Use the Gradle wrapper to build the application:

- **macOS/Linux & PowerShell:**:
  ```bash
  ./gradlew build
  ```
- **Windows (CMD only):**:
  ```bash
  gradlew build
  ```

This command will:
- Compile the source code.
- Resolve dependencies.
- Package the application into an executable JAR file located in the `build/libs` directory.

Verify that the JAR file is created:

- **macOS/Linux & PowerShell:**
  ```bash
  ls build/libs
  ```
- **Windows (CMD only):**
  ```bash
  dir build\libs
  ```

You should see a file like this:

```
FlashCards-0.0.1-SNAPSHOT.jar
```
### 5. Run the Application
Start the application using the `java -jar` command:

  ```bash
  java -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```


### 6. Optional: Run with a Specific Profile
To run the application with a specific Spring Profile and display translations in a particular format, use:

### **Original**:

- **macOS/Linux & PowerShell:**
  ```bash
  java "-Dspring.profiles.active=Original" -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```
- **Windows (CMD only):**
  ```bash
  java -Dspring.profiles.active=Original -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```

### **UpperCase  (default)**:
- **macOS/Linux & PowerShell:**
  ```bash
  java "-Dspring.profiles.active=UpperCase" -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```
- **Windows (CMD only):**
  ```bash
  java -Dspring.profiles.active=UpperCase -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```
###  **LowerCase**:
- **macOS/Linux & PowerShell:**
  ```bash
  java "-Dspring.profiles.active=LowerCase" -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```
- **Windows (CMD only):**
  ```bash
  java -Dspring.profiles.active=LowerCase -jar build/libs/FlashCards-0.0.1-SNAPSHOT.jar
  ```