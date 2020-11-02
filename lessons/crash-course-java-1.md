# Welcome to Java
{: .reading}

**Java** is a high level programming language designed in the 1990s by Sun Microsystems, and is currently owned by Oracle.

Java is **platform independent**, which means that in many cases you only need to write the program once to be able to run it on a number of different platforms.
Java is **portable**, **robust**, and **dynamic**, with the ability to fit the needs of virtually any type of application.

> Write Once, Run Anywhere

Java is used to develop apps for various Desktop Applications, such as media players, antivirus programs, Web Applications and Enterprise Applications (i.e. banking).

It has also be adopted as the language of choice for Google's **Android** OS, which we will be focus on in this course.

# Hello World!
{: .reading}

The infamous first example when learning a new programming language is to create a minimal programm which outputs the text `Hello World!` on the screen.

````java
class MyClass {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
````
````plaintext
Hello World!
````

In Java, every line of code that can actually run needs to be inside a `class`.
In our example, we named the class `MyClass`. We will explore the concept of classes in more detail later.

In Java, each application has an **entry point**, or a starting point, which is a [method](https://en.wikipedia.org/wiki/Method_(computer_programming) "a named collection of statements that are grouped together to perform an operation (also called function or procedure)") called `main`. Along with `main`, the keywords `public` and `static` will also be explained later.

> #### As a summary
> - Every program in Java must have a **class**.
> - Every Java program starts from the **main method**.

## The *main* Method

To run our program, the ``main`` method must be identical to this signature:

````java
public static void main(String[] args)
````

Let's dissect this line word by word:
- ``public``: anyone can access it
- ``static``: method only exists once for each class and can be accessed without create an [instance](https://en.wikipedia.org/wiki/Instance_(computer_science) "an object is called an 'instance' of a class") of that class
- ``void`` method does not return any value
- ``main`` name of the method
- ``String[]`` type of the method's parameter
- ``args`` name of the method's parameter

For example, the following code declares a method called ``test``, which does not return anything and has no parameters:

````java
void test()
````

## System.out.println()

Next is the *body* of the main method, enclosed in curly braces ``{ }``:

````java
{
   System.out.println("Hello World!");
}
````
- The ``println`` method prints a line of text to the screen.
The ``System`` class and its ``out`` stream are used to access the ``println`` method.

> In classes, methods, and other flow-control structures, code is always enclosed in curly braces ``{ }``.

**Note:** In Java, each code statement must end with a semicolon ``;``.

## Comments

The purpose of including comments in your code is to explain what the code is doing.
Java supports both single and multi-line comments. All characters that appear within a comment are ignored by the Java compiler.

A **single-line comment** starts with two forward slashes ``//`` and continues until it reaches the end of the line.

For example:
````java
// This is a single-line comment
````
````java
int ans = 42; // A single-line comment after code
````

Java also supports **multi-line comments** (also called *block comment*). You start it with ``/*``, and end it with ``*/``.

````java
/*  This is also a
    comment spanning
    multiple lines */
````

> Adding comments as you write code is a good practice, because they provide clarification and understanding when you need to refer back to it, as well as for others who might need to read it.

# Variables in Java
{: .reading}

Variables store data for processing.
A variable is given a name (or **identifier**), such as area, age, height, and the like. The name *uniquely* identifies each variable, assigning a value to the variable and retrieving the value stored.

Variables have **types**. Some examples:
- ``int``: for integers (whole numbers) such as 42 and -1337
- ``double``: for floating-point or real numbers with optional decimal points and fractional parts in fixed or scientific notations, such as 3.1416, -67.33.
- ``String``: for texts such as "Hello" or "Good Morning!". Text strings are enclosed within double quotes `"`. Note 'S' is a capital letter!
- ``char``: for single characters such as 'a' or 'A'
- ``boolean``: two possible values `true` and `false`

You can declare a variable of a type and assign it a value (**initialization**):
````java
String name = "Alice";
int answer = 42;
double pi = 3.14159;
char c = 'A';
boolean finished = false;
````

It is also possible to defer assigning a value to a later time. However, it is important to initialize a variable **before** you can access (read) the variable.

The following code will **not** work
````java
String drinks; // not initialized
int amount = 4;

System.out.println("Let's have " + amount + " " + drinks); // Illegal!
````
````plaintext
error: variable answer might not have been initialized
````

Let's fix the code by properly initializing the variable ``drinks`` before the first usage:
````java
String drinks; // not initialized
int amount = 4;

drinks = "beers"; // initialization
System.out.println("Let's have " + amount + " " + drinks);
````
````plaintext
Let's have 4 beers
````

It is important to note that a variable is associated with a type, and **is only capable of storing values of that particular type**. For example, an ``int`` variable can store integer values, such as ``123``; but it cannot store real numbers, such as ``12.34``, or texts, such as "Hello".

# Operators
{: .reading}

## Math Operators
Java provides **operators** to use in manipulating variables. A value used on either side of an operator is called an **operand**.
For example, in the expression below, the numbers ``4`` and ``5`` are operands of the `+` operator:
````java
int x = 4 + 5;
````

The arithmetic operators `+`, `-`, `*`, `/`, `%` (modulo) work as you would expect in algebraic equations. Just like in algebra, you can use multiple the operations in a single line to write an equation. For example:
````java
int val = 10 + 5 - 2;
````
The operator priority the same as in mathematics. To force a custom priority, round brackets ``( )`` can be used.
````java
int val = 4 * 2 + 5;   // = 8 + 5 = 13
int val = 4 * (2 + 5); // = 4 * 7 = 28
int val = ((1 + 2) * (5-3)) / (2 + 3);
````

## The Modulo Operator

The **modulo** (or remainder) math operation performs an integer division of one value by another, and returns the remainder of that division. The operator for the modulo operation is the percentage character `%`.

````java
int div = 23 / 6; // integer division is 3
int rem = 23 % 6; // remainder is 5

System.out.println("23 / 6 is " + div + " with " + rem + " rest.");
````
````plaintext
23 / 6 is 3 with 5 rest.
````
[>Try it yourself<](https://repl.it/@m0stlyharmless/MCIAppProgrammingExamples#Crash%20Course%20Java%20I/ExModulo.java){:target="_blank"}

## Increment Operators