# Value and Reference Types
{: .reading}
When variables are passed as parameters to a function, there is a very important difference depending on the variable type.

## Value Types
**Value types** are the basic types, and include ``int``, ``long``, ``float``, ``double``, ``boolean``, and ``char``.
These data types store the values assigned to them in the corresponding memory locations.\
So, when you pass them to a method, you basically operate on the variable's **value**, rather than on the variable itself. 

Example:
````java
public class Main {

  public static void main(String[ ] args) {
    int x = 5;

    addOneTo(x); // x's VALUE is given as parameter

    System.out.println(String.format("In main, x=%d", x));
  }

  static void addOneTo(int num) {
    num = num + 1;
    System.out.println(String.format("Inside function, num=%d", num));
  }
}
````
````plaintext
Inside function, num=6
In main, x=5
````
>The method from the example above takes the **value** of its parameter, which is why the original variable is not affected and 5 remains as its value.

[>Try it yourself<](https://repl.it/@m0stlyharmless/MCIAppExCallByValue#Main.java){:target="_blank"}

## Reference Types

A **reference type** stores a reference (or address) to the memory location where the corresponding data is stored.
>When you create an object using the constructor, you create a reference variable.

For example, consider having a ``Person`` class defined:

````java
public class Main {

  public static void main(String[ ] args) {

    Person j;
    j = new Person("John");
    j.setAge(20);

    celebrateBirthday(j); // call by reference
    System.out.println(j.getAge());
  }

  static void celebrateBirthday(Person p) {
    p.setAge(p.getAge() + 1);
  }
}
````
````plaintext
21
````

The method ``celebrateBirthday`` takes a ``Person`` object as its parameter, and increments its attribute.\
Because ``j`` is a reference type, the method affects the object itself, and is able to change the actual value of its attribute.

> ``String`` and ``List`` are also reference data types.

[>Try it yourself<](https://repl.it/@m0stlyharmless/MCIAppExCallByReference#Main.java){:target="_blank"}