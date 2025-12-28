# Java Design Patterns – Expert Interview & Architecture Guide

## Why Design Patterns Matter (Even Today)
Design patterns are still highly relevant in modern systems (Spring, Microservices, Cloud).
They help achieve:
- Loose coupling
- Testability
- Maintainability
- Extensibility

This guide provides a deep dive into the most important design patterns, structured for technical interviews. It focuses on the "what," "why," and "how," with real-world examples and code.


⚠️ **Warning**: Patterns should solve real problems. Overusing patterns leads to over‑engineering.

---

Design Patterns are proven solutions to common software design problems. They aren't code you copy-paste; they are templates for how to structure your classes and their interactions. The primary benefit is to create code that is **flexible, maintainable, and easy to change**.

### Core OOP Principles

**Encapsulation:** Grouping data and the methods that use that data into a single unit(class). **private** fields to prevent direct access.

**Abstraction :** reduce complexity by hiding unnecessary details( internal complexity ).Your class should expose what is necessary .
A MailService should have a public **send()** method, but The **connect()** and **authenticate()** methods should be in **private**.

**Inheritance:** Inheritance is a mechanism of resuing the code. Reusing the code by allowing a child class to take on the traits of a parent class ( e.g **TextBox** inheritance from **UIControl**)

**Polymorphism:** many forms. The ability of an object to take many forms . ex. A method like **draw()** can behave differently depending on whether its called on a **Circle** or a **Square**.

### **UML: Unified Modeling Language**
A quick reference for class diagrams:
- A class is a box with 3 partitions: Name, Variables, Methods.
- **Variables:** `- positionX: int` (`-` means private, `+` means public, `:` separates name from type).
- **Methods:** `+ draw(): void` (`()` denotes a method, `: void` means it returns nothing).

---
## Design Pattern Categories

### **Creational Patterns**
*Focus: How objects are created.*
1.  Singleton Pattern
2.  Factory Method Pattern
3.  Abstract Factory Pattern
4.  Builder Design Pattern
5.  Prototype Design Pattern

### **Structural Patterns**
*Focus: How classes and objects are composed to form larger structures.*
1.  Adapter Design Pattern
2.  Composite Pattern
3.  Decorator Pattern
4.  Facade Design Pattern
5.  Bridge Design Pattern
6.  Flyweight Design Pattern
7.  Proxy Design Pattern

### **Behavioral Patterns**
*Focus: How objects communicate and assign responsibilities.*
1.  Memento Pattern
2.  State Pattern
3.  Observer Design Pattern
4.  Command Pattern
5.  Iterator Pattern
6.  Template Method Pattern
7.  Chain of Responsibility Pattern
8.  Mediator Pattern
9.  Interpreter Design Pattern
10. Visitor Design Pattern

---

## How I Choose a Design Pattern (Expert Thinking)
- Complex object creation → **Builder**
- Need one shared instance → **Singleton (or avoid via DI)**
- Object creation varies by type → **Factory / Abstract Factory**
- Replace large if‑else on behavior → **Strategy / State**
- External API mismatch → **Adapter**
- Add behavior dynamically → **Decorator**
- Control access / cross‑cutting concerns → **Proxy**
- Sequential handlers → **Chain of Responsibility**

---
---
## Creational Design Patterns

### 1. Singleton Pattern
- **Definition:** Ensures a class has only one instance and provides a global point of access to it.
- **Analogy:** The president of a country. There can only be one at a time.
- **Problem:** You need exactly one instance of a class to coordinate actions across the system (e.g., a logger, configuration manager).
- **Solution:** Make the constructor `private`, create a `private static` instance, and provide a `public static getInstance()` method.
- **JDK Example:** `java.lang.Runtime.getRuntime()`
- **Code Snippet (Thread-Safe Lazy Initialization):**
  ```java
  public class ConfigurationManager {
      private ConfigurationManager() {}
      private static class InstanceHolder {
          private static final ConfigurationManager INSTANCE = new ConfigurationManager();
      }
      public static ConfigurationManager getInstance() {
          return InstanceHolder.INSTANCE;
      }
  }
  ```
  **Use when**: Exactly one instance required  
  **Avoid when**: Testing, global mutable state

**Pitfalls**
- Breaks SRP
- Hard to mock
- Reflection & serialization issues

**Best Practice**
```java
enum ConfigManager {
    INSTANCE;
}
```

**Spring Mapping**: Default Spring beans are singletons.

### 2. Factory Method Pattern
- **Definition:** Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
- **Analogy:** A pizza restaurant (`PizzaStore`). The `orderPizza()` method is the factory method. A `NYPizzaStore` subclass creates a `NYStylePizza`.
- **Problem:** A class cannot anticipate the class of objects it must create; it wants to delegate this to its subclasses.
- **Solution:** A superclass provides an abstract "factory method." Subclasses override this method to return a specific product.
- **JDK Example:** `java.util.Calendar.getInstance() LoggerFactory.getLogger()`
- **Spring Mapping**: `BeanFactory`, `ApplicationContext`
- **Code Snippet:**
  ```java
  interface Shape { void draw(); }
  class Circle implements Shape { /* ... */ }
  abstract class ShapeFactory {
      public abstract Shape createShape(); // The Factory Method
  }
  class CircleFactory extends ShapeFactory {
      public Shape createShape() { return new Circle(); }
  }
  ```
  **When to use**
- I use Factory Method when object creation varies by type and I want to avoid modifying existing code when new types are added.”
  - You want to follow Open–Closed Principle (add new types without modifying existing code)
  - You are replacing large if-else or switch blocks for object creation
  - **Typical examples**
  - Creating payment methods (CardPayment, UpiPayment)
  - Notification types (Email, SMS, Push)
  - Parser selection (JsonParser, XmlParser)
 **Avoid when**
  - void Factory Method when:
  -  There are only one or two object types and they are unlikely to grow
  - Object creation is simple and stable
  - You don’t need polymorphism
  Pitfalls:
  - CLass Explosion: Every new product requires a new factory subclass , leads to many subclasses
  - Not Suitable for product Families : Factory Method creates one product, For related products, Abstract factory is better
    - A Simple Constructor or Builder is sufficient

### 3. Abstract Factory Pattern
- **Definition:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Analogy:** An IKEA furniture factory. You get a *family* of matching furniture (chair, sofa) in a specific style ("Modern" or "Victorian").
- **Problem:** Your system needs to be independent of how its products are created, and you need to create families of related products.
- **Solution:** Define a factory interface (`GUIFactory`) for creating a set of products (`Button`, `Checkbox`). Create concrete factories (`WindowsFactory`, `MacFactory`) that produce products for a specific look-and-feel.
- **JDK Example:** `javax.xml.parsers.DocumentBuilderFactory.newInstance()` 'PlatformTransactionManager PersistenceProvider JDBC driver families (MySQL, Oracle)'
- **Code Snippet:**
  ```java
  interface Button { void paint(); }
  interface GUIFactory { Button createButton(); }
  class WinFactory implements GUIFactory { public Button createButton() { return new WinButton(); } }
  class MacFactory implements GUIFactory { public Button createButton() { return new MacButton(); } }
  ```
  **Avoid Abstract Factory when:**

- You only need to create one object type
- Product families are unlikely to grow
- Object relationships are not important
  **Pitfalls**
- Hard to Add New Product Types
- Adding a new product requires changing all factory interfaces , Violates Open–Closed Principle in this dimension
- Factories enforce fixed product families, Flexibility is reduced if combinations change frequently
  “I use Abstract Factory when I need to create multiple related objects together and ensure they work consistently across different environments.”
  | Factory Method            | Abstract Factory               |
  | ------------------------- | ------------------------------ |
  | Creates one product       | Creates product families       |
  | Uses inheritance          | Uses composition               |
  | Easier to extend          | Harder to extend product types |
  | Flexible for new products | Flexible for new families    |
- | extensibility by subclassing | consistency across object families | 


### 4. Builder Pattern
- **Definition:** Separates the construction of a complex object from its representation, so that the same construction process can create different representations.
- “I use Builder to avoid telescoping constructors and to create immutable objects safely.”
- **Analogy:** Ordering a sandwich at Subway. You tell the "builder" step-by-step what you want, and at the end, you get the final `Sandwich` object.
- **Problem:** An object has many optional constructor parameters (the "telescoping constructor" anti-pattern).
- **Solution:** Create a static nested `Builder` class. The builder has methods for setting each parameter and a final `build()` method that returns the main object.
- **JDK Example:** `java.lang.StringBuilder` `UriComponentsBuilder Lambok @Builder`
- **Code Snippet:**
  ```java
  public class User {
      private final String name;
      private final int age; // optional
      private User(UserBuilder builder) {
          this.name = builder.name;
          this.age = builder.age;
      }
      public static class UserBuilder {
          private final String name;
          private int age = 0;
          public UserBuilder(String name) { this.name = name; }
          public UserBuilder age(int age) { this.age = age; return this; }
          public User build() { return new User(this); }
      }
  }
  // Usage: new User.UserBuilder("Naresh").age(30).build();
  ```
  **When to USe**
- Object has many optional parameters  , You want readable object creation , You want immutable objects
- Constructor overloading becomes messy . ex:  DTOs Configuration objects HTTP requests.
- ** Avoid When**
- Object has few fields , All parameters are mandatory

### 5. Prototype Pattern
- **Definition:** Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying this prototype.
- **Analogy:** Mitosis in biology. A cell splits to create a copy of itself.
- **Problem:** Creating an object is expensive (if e.g., requires a database call), and you need many similar objects.
- **Solution:** Create a "prototype" object. When you need a new object, you ask the prototype to clone itself. Requires implementing the `Cloneable` interface.
- **JDK Example:** `java.lang.Object.clone()` 'ArrayList.clone'
- **Code Snippet:**
  ```java
  public abstract class Shape implements Cloneable {
      public Object clone() throws CloneNotSupportedException {
          return super.clone();
      }
  }
  ```
  **When use**
- Object creation is expensive, Many similar objects are required, Configuration is complex and repetitive
- You want to avoid subclass explosion
- Ex: Cache object templates  , Configuration snapshots

**avoid when**
Object graph is deep and complex , cloning logic is hard to maintain, object holds external resources ( DB, sockets)
**Pitfalls** ⚠

- Shallow vs Deep Copy  ,Most bugs come from shallow cloning , Cloneable Is Broken  ,Poorly designed Java API

- Hidden Coupling  , Changes in prototype affect clones unintentionally

Better Alternatives ⭐
- Copy constructors , Serialization-based cloning  ,Builder + copy method
---


## Structural Design Patterns

### 1. Adapter Pattern
- **Definition:** Converts the interface of a class into another interface clients expect.
-  Match interfaces of difference classes : An Adapter allowes two incompatible interfaces to work together
- **Analogy:** A travel power adapter that makes a US plug fit a European socket.
- **Problem:** You want to use an existing class, but its interface doesn't match the one you need.
- **Solution:** Create an `Adapter` class that "wraps" the original class (the "Adaptee") and translates calls from the client into calls on the adaptee.
- **JDK Example:** `java.util.Arrays.asList()` adapts an array into a `List`.
- **Code Snippet:**
  ```java
  interface MediaPlayer { void play(String fileName); }
  class AdvancedMediaPlayer { void playVlc(String fileName) { /* ... */ } }
  class MediaAdapter implements MediaPlayer {
      AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();
      public void play(String fileName) { advancedPlayer.playVlc(fileName); }
  }
  ```

### 2. Bridge Design Pattern
- **Definition:** Decouples an abstraction from its implementation so that the two can vary independently. ( separates an objects interface from its implementation)
- The Bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities.
- **Analogy:** A light switch on a wall. The switch (Abstraction) can be a toggle or a dimmer. The light fixture it controls (Implementation) can be an incandescent bulb or an LED.
- **Problem:** You have a class hierarchy that is growing in two dimensions (e.g., `Shape` and `Color`).
- **Solution:** Split the hierarchy into two: one for the abstraction (`Shape`) and one for the implementation (`Color`). The `Shape` abstraction holds a reference to a `Color` implementor.
- **JDK Example:** The JDBC API. `DriverManager` (Abstraction) connects to different database drivers (Implementations).
- **Code Snippet:**
  ```java
  // Implementor
  interface DrawingAPI { void drawCircle(double x, double y, double radius); }
  class DrawingAPI1 implements DrawingAPI { /* ... */ }
  // Abstraction
  abstract class Shape {
      protected DrawingAPI drawingAPI;
      protected Shape(DrawingAPI api) { this.drawingAPI = api; }
      public abstract void draw();
  }
  // Refined Abstraction
  class CircleShape extends Shape {
      public CircleShape(DrawingAPI api) { super(api); }
      public void draw() { drawingAPI.drawCircle(...); }
  }
  ```

### 3. Composite Pattern
- **Definition:** Composes objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. ( A tree structure of simple and composite objects)
- **Analogy:** A company's organizational chart. A manager (a composite) can have other managers or individual employees (leaves) under them.
- **Problem:** You need to treat a group of objects in the same way as a single object.
- **Solution:** Define a common `Component` interface for both simple ("Leaf") and complex ("Composite") objects. The `Composite` object holds a collection of `Component`s and delegates operations to them.
- **JDK Example:** `java.awt.Container` and `java.awt.Component`.
- **Code Snippet:**
  ```java
  // Component
  interface Graphic { void draw(); }
  // Leaf
  class Circle implements Graphic { public void draw() { /* ... */ } }
  // Composite
  class Picture implements Graphic {
      private List<Graphic> children = new ArrayList<>();
      public void add(Graphic g) { children.add(g); }
      public void draw() {
          for (Graphic g : children) { g.draw(); }
      }
  }
  ```

### 4. Decorator Pattern
- **Definition:** Attaches additional responsibilities to an object dynamically. ( to prevent a flexible alternative to changing object functionality at runtime)
- **Analogy:** Putting toppings on a pizza. You start with a plain base (component) and "decorate" it with cheese, then pepperoni.
- **Problem:** You want to add behavior to an object at runtime without affecting other objects of the same class.
- **Solution:** Create a `Decorator` abstract class that implements the same interface as the object you want to decorate. The decorator holds a reference to the component and delegates calls to it, adding its own behavior before or after.
- **JDK Example:** `java.io` classes like `new BufferedReader(new FileReader("file.txt"))`.
- **Code Snippet:**
  ```java
  interface Coffee { double getCost(); }
  class SimpleCoffee implements Coffee { /* ... */ }
  abstract class CoffeeDecorator implements Coffee {
      protected final Coffee decoratedCoffee;
      public CoffeeDecorator(Coffee c) { this.decoratedCoffee = c; }
      public double getCost() { return decoratedCoffee.getCost(); }
  }
  class MilkDecorator extends CoffeeDecorator {
      public MilkDecorator(Coffee c) { super(c); }
      public double getCost() { return super.getCost() + 0.5; }
  }
  ```

### 5. Facade Design Pattern ( P: fasad)
- **Definition:** Provides a unified, simplified interface to a set of interfaces in a subsystem. ( or class)
- reduces coupling between subsystems
- **Analogy:** The ignition key of a car. You just turn one key to start a complex system.
- **Problem:** A system is very complex, and you want to provide a simple way for clients to use it.
- **Solution:** Create a `Facade` class that encapsulates the complex subsystem and provides a few simple methods that delegate calls to the appropriate internal objects.
- **JDK Example:** `javax.faces.context.FacesContext`.
- **Code Snippet:**
  ```java
  class CPU { /* ... */ }
  class Memory { /* ... */ }
  class ComputerFacade {
      private CPU processor = new CPU();
      private Memory ram = new Memory();
      public void start() { /* complex steps using processor and ram */ }
  }
  ```


### 6. Flyweight Design Pattern
- **Definition:** Use sharing to support large numbers of fine-grained objects efficiently.
- **Analogy:** The characters in a word processor. The letter 'a' has intrinsic state (its shape) and extrinsic state (its position). The shape is stored once (the flyweight).
- **Problem:** You need to create a huge number of objects that share common state, and storing them all would consume too much memory.
- **Solution:** Separate state into intrinsic (shared) and extrinsic (unique). Create a factory that caches and reuses flyweight objects containing the intrinsic state.
- **JDK Example:** `java.lang.Integer.valueOf(int)` caches `Integer` objects from -128 to 127.
- **Code Snippet:**
  ```java
  // Flyweight Factory
  class CharacterFactory {
      private Map<java.lang.Character, Character> characters = new HashMap<>();
      public Character getCharacter(char key) {
          return characters.computeIfAbsent(key, Character::new);
      }
  }
  ```

### 7. Proxy Design Pattern
- **Definition:** Provides a surrogate or placeholder for another object to control access to it. ( an object represent the another object)
- **Analogy:** A checkbook is a proxy for the money in your bank account.
- **Problem:** You need to control access to an object, perhaps for security, lazy initialization, or because it's remote.
- **Solution:** Create a `Proxy` object with the same interface as the real object. The client interacts with the proxy, which decides if and when to forward the request to the real object.
- **JDK Example:** `java.lang.reflect.Proxy`, Spring AOP.
- **Code Snippet:**
  ```java
  interface Image { void display(); }
  class RealImage implements Image { /* ... expensive load from disk ... */ }
  class ProxyImage implements Image {
      private RealImage realImage;
      private String fileName;
      public ProxyImage(String fileName) { this.fileName = fileName; }
      public void display() {
          if (realImage == null) {
              realImage = new RealImage(fileName); // Lazy initialization
          }
          realImage.display();
      }
  }
  ```

---
## Behavioral Design Patterns

### 1. Memento Pattern
- **Definition:** Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.
- **Analogy:** A "save game" checkpoint.
- **Problem:** You need to implement an "undo" or "rollback" feature.
- **Solution:** Use three objects: **Originator** (the object with state), **Memento** (stores the state), and **Caretaker** (holds the memento).
- **Code Snippet:**
  ```java
  class Editor { // Originator
      private String content;
      public EditorState createState() { return new EditorState(content); }
      public void restore(EditorState state) { this.content = state.getContent(); }
  }
  class EditorState { // Memento
      private final String content;
      public EditorState(String content) { this.content = content; }
      public String getContent() { return content; }
  }
  class History { // Caretaker
      private Deque<EditorState> states = new ArrayDeque<>();
      public void push(EditorState state) { states.push(state); }
      public EditorState pop() { return states.pop(); }
  }
  ```

### 2. State Pattern
- **Definition:** Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
- **Analogy:** A vending machine. Its behavior (`dispense()`) is different depending on its state (`NoCoinState`, `HasCoinState`).
- **Problem:** You have an object that behaves differently depending on its current state, leading to large `if/else` or `switch` statements.
- **Solution:** Encapsulate each state into its own class implementing a common `State` interface. The main "Context" object holds a reference to its current state object and delegates behavior to it.
- **Code Snippet:**
  ```java
  interface State { void handle(Document document); }
  class DraftState implements State { /* ... */ }
  class PublishedState implements State { /* ... */ }
  class Document { // Context
      private State state;
      public void setState(State state) { this.state = state; }
      public void request() { state.handle(this); }
  }
  ```

### 3. Observer Design Pattern
- **Definition:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **Analogy:** A magazine subscription. You (Observer) subscribe to a magazine (Subject).
- **Problem:** You have an object (Subject) whose state is interesting to other objects (Observers), and you want to decouple them.
- **Solution:** The `Subject` maintains a list of `Observer` objects. When its state changes, it loops through its observers and calls an `update()` method on each one.
- **JDK Example:** Swing's `ActionListener`.
- **Code Snippet:**
  ```java
  interface Observer { void update(String message); }
  class User implements Observer { /* ... */ }
  class NewsAgency { // Subject
      private List<Observer> channels = new ArrayList<>();
      public void addObserver(Observer c) { channels.add(c); }
      public void setNews(String news) {
          for (Observer c : this.channels) { c.update(news); }
      }
  }
  ```

### 4. Command Pattern
- **Definition:** Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
- **Analogy:** Ordering food at a restaurant. You give an order (Command) to the waiter (Invoker). The chef (Receiver) executes it.
- **Problem:** You want to decouple the object that invokes an operation from the object that performs it.
- **Solution:** Create a `Command` interface with an `execute()` method. Concrete commands encapsulate a "Receiver" object and the action. The "Invoker" holds a command and calls `execute()`.
- **JDK Example:** `java.lang.Runnable`.
- **Code Snippet:**
  ```java
  interface Command { void execute(); }
  class Light { public void turnOn() { /* ... */ } } // Receiver
  class TurnOnLightCommand implements Command {
      private Light theLight;
      public TurnOnLightCommand(Light light) { this.theLight = light; }
      public void execute() { theLight.turnOn(); }
  }
  class RemoteControl { // Invoker
      private Command command;
      public void setCommand(Command c) { this.command = c; }
      public void pressButton() { command.execute(); }
  }
  ```

### 5. Iterator Pattern
- **Definition:** Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- **Analogy:** A TV remote's channel up/down buttons.
- **Problem:** You need a uniform way to traverse different data structures.
- **Solution:** The collection provides an `iterator()` method that returns an `Iterator`. The client uses `hasNext()` and `next()` to traverse.
- **JDK Example:** `java.util.Iterator`. The for-each loop is syntactic sugar for this pattern.
- **Code Snippet:**
  ```java
  List<String> names = Arrays.asList("Naresh", "Suresh", "Ramesh");
  for (String name : names) { // This uses the Iterator pattern internally
      System.out.println(name);
  }
  ```

### 6. Template Method Pattern
- **Definition:** Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
- **Analogy:** Making a sandwich. The "template method" is the overall process (get bread, add fillings, serve). The specific fillings are implemented by subclasses.
- **Problem:** You have several classes that follow the same algorithm but with minor variations.
- **Solution:** Create an abstract base class with a `final` "template method" that calls a series of abstract or hook methods. Subclasses implement the abstract methods.
- **JDK Example:** `java.io.InputStream`'s `read()` method.
- **Code Snippet:**
  ```java
  abstract class Game {
      abstract void initialize();
      abstract void startPlay();
      abstract void endPlay();
      public final void play() { // The template method
          initialize();
          startPlay();
          endPlay();
      }
  }
  class Cricket extends Game { /* ... implement abstract methods ... */ }
  ```

### 7. Chain of Responsibility Pattern
- **Definition:** Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.
- **Analogy:** A customer service phone system. Your call goes from a general operator to a specialist to a manager.
- **Problem:** A request could be handled by one of several different objects, and you don't know which one in advance.
- **Solution:** Create a chain of "Handler" objects. Each handler has a reference to the next. When a handler receives a request, it either processes it or passes it on.
- **JDK Example:** The `javax.servlet.Filter` chain in web applications.
- **Code Snippet:**
  ```java
  abstract class Logger {
      protected Logger nextLogger;
      public void setNextLogger(Logger logger) { this.nextLogger = logger; }
      public void logMessage(int level, String message) {
          if (this.level <= level) { write(message); }
          if (nextLogger != null) { nextLogger.logMessage(level, message); }
      }
      abstract protected void write(String message);
  }
  ```

### 8. Mediator Pattern
- **Definition:** Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly.
- **Analogy:** An air traffic control tower. Airplanes don't talk to each other; they all talk to the tower (Mediator).
- **Problem:** You have many objects communicating directly with each other, creating a "spaghetti code" mess.
- **Solution:** Create a central `Mediator` object. All "Colleague" objects communicate only through the mediator.
- **JDK Example:** `java.util.Timer` schedules tasks without the tasks needing to know about each other.
- **Code Snippet:**
  ```java
  // Mediator
  class ChatRoom {
      public static void showMessage(User user, String message) { /* ... */ }
  }
  // Colleague
  class User {
      private String name;
      public User(String name) { this.name = name; }
      public void sendMessage(String message) {
          ChatRoom.showMessage(this, message);
      }
  }
  ```

### 9. Interpreter Design Pattern
- **Definition:** Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
- **Analogy:** A SQL query engine.
- **Problem:** You need to process a simple language or expression.
- **Solution:** Represent each grammar rule as a class. Build a tree of these objects to represent a sentence.
- **JDK Example:** `java.util.regex.Pattern`.
- **Use Case:** Rare in business applications but common in compilers.

### 10. Visitor Design Pattern
- **Definition:** Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.
- **Analogy:** A tax accountant (Visitor) visiting different types of businesses (restaurant, retail store).
- **Problem:** You have a stable object structure, but you need to perform many different, unrelated operations on these objects.
- **Solution:** Create a `Visitor` interface with a `visit()` method for each concrete class in your structure. Each element class gets a single `accept(Visitor v)` method. This allows you to add new operations by creating new visitors without touching the element classes.
- **JDK Example:** `javax.lang.model.element.ElementVisitor`.

---
## Key Pattern Comparisons

### Factory Method vs. Abstract Factory
- **Factory Method** creates **one** product. It uses inheritance.
- **Abstract Factory** creates a **family** of related products. It uses composition.

### Adapter vs. Decorator vs. Proxy
- **Adapter:** Changes an interface to make it compatible with another.
- **Decorator:** Adds new responsibilities to an object without changing its interface.
- **Proxy:** Controls access to an object and has the same interface as the real object.

### State vs. Strategy
- Both are similar structurally, but their **intent** is different.
- **Strategy:** The client is aware of and chooses the algorithm (e.g., choosing a payment method).
- **State:** The state changes are internal and happen automatically based on the object's behavior (e.g., a `VendingMachine` object changing its state from `NoCoin` to `HasCoin`).

## Structural Patterns

### Adapter
**Use**: API mismatch  
**Spring**: `HandlerAdapter`

---

### Composite
Treat object and group uniformly.

---

### Decorator
Add behavior dynamically.

**Decorator vs AOP**
- Decorator → explicit
- AOP → cross‑cutting (logging, security)

---

### Facade
Simplifies complex subsystems.

---

### Bridge
Decouple abstraction & implementation.

**Microservices Example**
API abstraction vs vendor-specific implementation

---

### Flyweight
Reduce memory usage.

**JDK Example**
`Integer.valueOf()` cache

---

### Proxy
Controls access.

**Types**
- Virtual
- Protection
- Remote
- Smart

**Spring**
- AOP Proxies
- Hibernate Lazy Loading

---

## Behavioral Patterns

### Memento
Undo / rollback functionality.

---

### State
Object changes behavior internally.

**State vs Strategy**
- State → internal transition
- Strategy → client chooses

---

### Observer
One‑to‑many dependency.

**Modern Examples**
- Kafka
- Pub/Sub
- Reactive Streams

---

### Command
Encapsulates requests.

**Advanced**
- Undo/Redo
- Event sourcing

---

### Iterator
Traverse collection without exposing internals.

---

### Template Method
Algorithm skeleton.

**Spring**
- `JdbcTemplate`
- `RestTemplate`

---

### Chain of Responsibility
Pass request along chain.

**Spring**
- Servlet Filters
- Spring Security Filter Chain

---

### Mediator
Centralized communication.

⚠️ Can become God Object.

---

### Interpreter
Language grammar interpretation.

Rare in business apps.

---

### Visitor
Add new operations without modifying object structure.

**Drawback**
Hard to add new element types.

---

## Key Interview Comparisons

### Factory vs Abstract Factory
- Factory → one product
- Abstract Factory → product family

### Adapter vs Decorator vs Proxy
- Adapter → interface mismatch
- Decorator → add behavior
- Proxy → control access

### State vs Strategy
- State → behavior changes automatically
- Strategy → behavior chosen explicitly

### Facade vs Mediator
- Facade → simplify subsystem
- Mediator → coordinate interactions

---