# Java 26 Upgrade Guide - Local Setup

## Current Status
- **Installed**: OpenJDK 26 (Eclipse Temurin 26+35)
- **Platform**: macOS (Apple Silicon)

## Installation Commands

### Install Java 26 via Homebrew
```bash
# Install the latest Temurin (automatically installs Java 26)
brew install --cask temurin

# Or install specific version
brew install --cask temurin@26
```

### Verify Installation
```bash
# List all installed Java versions
/usr/libexec/java_home -V

# Check current Java version
java -version

# Check current javac version
javac -version
```

### Sample Output
```
Matching Java Virtual Machines (3):
    26 (arm64) "Eclipse Adoptium" - "OpenJDK 26" /Library/Java/JavaVirtualMachines/temurin-26.jdk/Contents/Home
    25.0.2 (arm64) "Eclipse Adoptium" - "OpenJDK 25.0.2" /Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home
    11.0.28 (arm64) "Microsoft" - "OpenJDK 11.0.28" /Users/nareshnalla/Library/Java/JavaVirtualMachines/ms-11.0.28/Contents/Home

openjdk version "26" 2026-03-17
OpenJDK Runtime Environment Temurin-26+35 (build 26+35)
OpenJDK 64-Bit Server VM Temurin-26+35 (build 26+35, mixed mode, sharing)
```

## Maven Configuration (pom.xml)

```xml
<properties>
    <maven.compiler.source>26</maven.compiler.source>
    <maven.compiler.target>26</maven.compiler.target>
    <maven.compiler.release>26</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>26</source>
                <target>26</target>
                <release>26</release>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## Java 26 Features Supported

### ✅ Stable Features (No Preview Needed)
- **Java 21+**: Pattern Matching in Switch
- **Java 16+**: Records
- **Java 17+**: Sealed Classes & Interfaces
- **Java 8+**: Streams, Lambda, Functional Interfaces

### 💡 IDE Compiler Settings

#### IntelliJ IDEA
1. File → Project Structure → Project
2. Set SDK to "OpenJDK 26"
3. Language Level: "26 - Pattern Matching in Switch"

#### VS Code / Eclipse
- Update JDK/JRE settings to point to Java 26 installation path

## Compile & Run Commands

### Compile Single File
```bash
javac --release 26 -d target/classes src/main/java/com/naresh/DailyType.java
```

### Compile with Maven
```bash
mvn clean compile
```

### Run Compiled Class
```bash
java -cp target/classes com.naresh.DailyType
```

## Java 25 vs Java 26

| Feature | Java 25 | Java 26 |
|---------|---------|---------|
| Pattern Matching in Switch | Stable (JEP 441) | Stable |
| Records | Stable (JEP 395) | Stable |
| Sealed Classes | Stable (JEP 409) | Stable |
| Virtual Threads | Stable (JEP 444) | Stable |
| Unnamed Variables | Stable (JEP 456) | Stable |

## Troubleshooting

### Issue: "invalid source release 25 with --enable-preview"
**Solution**: Use Java 26 where preview flag is not needed for pattern matching (stable since Java 21)

```bash
# ✅ Correct
javac --release 26 -d target/classes YourFile.java

# ❌ Incorrect
javac --release 25 --enable-preview -d target/classes YourFile.java
```

### Issue: "sealed or non-sealed local classes are not allowed"
**Solution**: Move sealed interface/records to class level, not inside methods

```java
// ❌ Wrong
public static void main(String[] args) {
    sealed interface Shape permits Circle, Rect {}  // Error!
}

// ✅ Correct
public class MyClass {
    sealed interface Shape permits Circle, Rect {}  // OK
    
    public static void main(String[] args) {
        // Use Shape here
    }
}
```

## Next Steps
- Update all `pom.xml` files to `<maven.compiler.target>26</maven.compiler.target>`
- Test compilation: `mvn clean compile`
- Run your application with Java 26

---

**Last Updated**: May 2, 2026  
**Java Version**: OpenJDK 26 (Eclipse Temurin)  
**Platform**: macOS Apple Silicon

