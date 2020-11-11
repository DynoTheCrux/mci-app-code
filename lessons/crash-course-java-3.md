# Object-Orientation
{: .reading}

Java uses **O**bject-**O**riented **P**rogramming (OOP), a programming style that is intended to make thinking about programming closer to thinking about the real world.
In OOP, each object is an independent unit with a **unique identity**, just as objects in the real world are.

> An apple is an object; so is a mug. Each has its unique **identity**. It's possible to have two mugs that look identical, but they are still separate, unique objects

Objects also have **characteristics**, which are used to describe them.
For example, a car can be red or blue, a mug can be full or empty, and so on. These characteristics are also called **attributes**. An attribute describes the current state of an object.
In the real world, each object behaves in its own way. The car moves, the phone rings, and so on.
The same applies to objects: **behavior** is specific to the object's type.

> In summary, in object oriented programming, each object has three dimensions: **identity**, **attributes**, and **behavior**.
Attributes describe the object's current state, and what the object is capable of doing is demonstrated through the object's behavior.

# Classes

A **class** describes what the object will be, but is separate from the object itself.
In other words, classes can be described as blueprints, descriptions, or definitions for an object. You can use the same class as a blueprint for creating multiple objects. The first step is to define the class, which then becomes a blueprint for object creation.

Each class has a name, and each is used to define **attributes** and **behavior**.

Some examples of attributes and behavior:

| Attributes | Behavior |
|------------|----------|
| name       | walk     |
| height     | run      |
| weight     | jump     |
| gender     | speak    |
| age        | sleep    |

> In other words, an *object* is an **instance** of a *class*.

# Methods

Methods define **behavior**. A method is a collection of statements that are grouped together to perform an operation. ``System.out.println()`` is an example of a method.
You can define your own methods to perform your desired tasks.

Let's consider the following code:
````java
class MyClass {

  static void sayHello() {
    System.out.println("Hello World!");
  }

  public static void main(String[ ] args) {
    sayHello();
  }
}
````
````plaintext
Hello World!
````

The code above declares a [method](https://en.wikipedia.org/wiki/Method_(computer_programming) "a collection of statements that are grouped together to perform an operation (also called a function)"){:target="_blank"} called ``sayHello``, which prints a text, and then gets called in ``main``.

> To call a **method**, type its name and then follow the name with a set of parentheses.

## Calling Methods
You can call a method as many times as necessary.
When a method runs, the code jumps down to where the method is defined, executes the code inside of it, then goes back and proceeds to the next line.

````java
class MyClass {
  
  static void sayHello() {
    System.out.println("Hello World!");
  }

  public static void main(String[ ] args) {
    sayHello();
    sayHello();
    sayHello();
  }
}
````
````plaintext
Hello World!
Hello World!
Hello World!
````

> In cases like the one above, where the same thing is repeated over and over, you can achieve the same result using loops (while or for).

## Method Parameters

You can also create a method that takes some data, called **parameters**, along with it when you call it. Write parameters within the method's parentheses.
For example, we can modify our ``sayHello()`` method to take and output a ``String`` parameter.

````java
class MyClass {
  
  static void sayHello(String name) {
    System.out.println("Hello " + name + "!");
  }

  public static void main(String[ ] args) {
    sayHello("Alice");
    sayHello("Bob");
  }

}
````
````plaintext
Hello Alice!
Hello Bob!
````

The method above takes a String called ``name`` as a parameter, which is used in the method's body. Then, when calling the method, we pass the parameter's value inside the parentheses.
Methods can take multiple, comma-separated parameters.

The advantages of using methods instead of simple statements include the following:
- code reuse: You can write a method once, and use it multiple times, without having to rewrite the code each time.
- parameters: Based on the parameters passed in, methods can perform various actions.

## Method Return Type

The ``return`` keyword can be used in methods to **return** a value.
For example, we could define a method named ``sum`` that returns the sum of its two parameters.

````java
int sum(int val1, int val2) {
   return val1 + val2;
}
````

Notice that in the method definition, we defined the **return type** before we defined the method name. For our sum method, it is ``int``, as it takes two parameters of the type ``int`` and returns their sum, which is also an ``int``.

Now, we can use the method in our ``main`` (the ``static`` keyword will be discussed later):

````java
class MyClass {

static int sum(int val1, int val2) {
  return val1 + val2;
}

public static void main(String[ ] args) {
    int x = sum(24, 18);
    System.out.println(x);
  }
}
````
````plaintext
42
````

As the method returns a value, we can assign it to a variable.
> When you do not need to return any value from your method, we use the type ``void`` (nothing).
Notice the ``void`` keyword in the definition of the main method - this means that main does not return anything.

> A method can have one type of parameter (or parameters) and return another, different type. For example, it can take two ``double`` and return an ``int``.