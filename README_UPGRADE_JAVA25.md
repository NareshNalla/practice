echo 'export JAVA_HOME=$(/usr/libexec/java_home -v25)' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
echo 'export JAVA_HOME="/Library/Java/JavaVirtualMachines/<jdk-folder>.jdk/Contents/Home"' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
Local Java 25 setup (macOS / zsh)

Quick, local-only commands to install Java 25 (Homebrew) and make Java 25 the active JDK for your shell.

1) Pre-check current Java

```bash
java -version
javac -version
/usr/libexec/java_home -V
```

2) Install with Homebrew (local)

```bash
brew update
# install latest temurin (optional)
brew install --cask temurin
# install temurin 25 explicitly
brew install --cask temurin@25
```

3) Set Java 25 as the active JDK for zsh (persistent)

Preferred (macOS helper — picks the registered JDK 25):

```bash
# append to ~/.zshrc
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v25)' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

If you prefer an explicit path (replace folder name if different):

```bash
export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home"
echo 'export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home"' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

4) Verify active Java

```bash
java -version
javac -version
/usr/libexec/java_home -V
```

5) Switch to a different installed JDK (if needed)

```bash
# set to Java 26
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v26)' >> ~/.zshrc
source ~/.zshrc
```

Notes
- The above is local-only: Homebrew install + shell environment changes.
- You installed `temurin` and `temurin@25` earlier. The system default may be a different installed JDK (e.g., Java 26). Use the `JAVA_HOME` export above to force Java 25 in your shell.
- If you want me to update your project's `pom.xml` or CI to target Java 25, tell me and I will patch those files.
