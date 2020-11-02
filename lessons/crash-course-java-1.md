# Welcome to Java
{: reading}

**Java** is a high level programming language designed in the 1990s by Sun Microsystems, and is currently owned by Oracle.

Java is **platform independent**, which means that in many cases you only need to write the program once to be able to run it on a number of different platforms.
Java is **portable**, **robust**, and **dynamic**, with the ability to fit the needs of virtually any type of application.

> Write Once, Run Anywhere

Java is used to develop apps for various Desktop Applications, such as media players, antivirus programs, Web Applications and Enterprise Applications (i.e. banking).

It has also be adopted as the language of choice for Google's **Android** OS, which we will be focus on in this course.

# Hello World!
{: reading}

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

## The *main* method

To run our program, the ``main`` method must be identical to this signature:

````java
public static void main(String[] args)
````

Let's dissect this line word by word:
- ``public``: anyone can access it
- ``static``: method only exists once for each class and can be accessed without create an [instance](https://en.wikipedia.org/wiki/Instance_(computer_science) "an object is called an instance of a class)") of that class
- ``void`` method does not return any value
- ``main`` name of the method
- ``String[]`` type of the method's parameter
- ``args`` name of the method's parameter

For example, the following code declares a method called ``test``, which does not return anything and has no parameters:

````java
void test()
````

## System.out.println()

Next is the [body](# "the collection of statements belonging to a block of code is called it's 'body'") of the main method, enclosed in curly braces ``{ }``:

````java
{
   System.out.println("Hello World!");
}
````
- The ``println`` method prints a line of text to the screen.
The ``System`` class and its ``out`` stream are used to access the ``println`` method.

> In classes, methods, and other flow-control structures, code is always enclosed in curly braces ``{ }``.

**Note:** In Java, each code statement must end with a semicolon ``;``.