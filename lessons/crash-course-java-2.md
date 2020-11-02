# Control structures
{: .reading}

In general, commands in a program are called in **sequence**. This does not necessarily imply that a program runs line by line from top to botton, but that we can **follow the program** instruction by instruction.

**Control structures** allow us to divert the program flow according to set conditions. There are two distinct types of control structures: **loops** and **conditionals** (selections).

![Control structures](/assets/img/cc2_prog_flow.gif)

## Conditional Statements
 
**Conditional statements** are used to perform different actions based on different conditions.

### if Statement
The ``if`` statement is one of the most frequently used conditional statements.
If the condition expression evaluates to **true**, the block of code inside the ``if`` statement is executed. If the expression is found to be false, the first set of code after the end of the ``if`` statement (after the closing curly brace) is executed.

Generally, the syntax of an ``if`` statement is
````java
if (condition) {
   // Executes when the condition is true
}
````

The ``condition`` can be comprised of following **comparison operators**:
- ``<`` less than
- ``>`` greater than
- ``==`` equal to
- ``!=`` not equal to
- ``<=`` less than or equal to
- ``>=`` greater than or equal to

> Note: The equals operator is `==`, the assignment operator is `=`.

````java
int v = 35;
...
if(v < 42) {
   System.out.println("Computer says 'Hi'");
}
````
[>Try it yourself<](https://repl.it/@m0stlyharmless/MCIAppExIf#Main.java){:target="_blank"}

### if...else Statement
An ``if`` statement can be followed by an *optional* ``else`` statement, which executes when the condition evaluates to **false**.

For example:
````java
int age = 30;

if (age < 16) { // 30 < 16 -> false
   System.out.println("Too Young");
} else { 
   System.out.println("Welcome!");
}
````
````plaintext
Welcome!
````

### Nested if Statements
We can use ``if``(-``else``) statements inside another ``if`` or ``else`` statement. This is called **nesting** and we can nest as many ``if``-``else`` as we want.

````java
int age = 25;
if(age > 0) {
   if(age > 16) { // age > 0 and age > 16
      System.out.println("Welcome!");
   } else { // age > 0 and age <= 16
      System.out.println("Too Young");
   }
} else { // age <= 0
   System.out.println("Error");
}
````
````plaintext
Welcome!
````

### else-if Statements

Instead of using nested ``if``-``else`` statements, you can use the ``else if`` statement to check multiple conditions. The code will check the conditions from first to last and execute the code inside the block of the first condition to evaluate to ``true``.

````java
int age = 25;

if(age <= 0) {
   System.out.println("Error");
} else if(age <= 16) {
   System.out.println("Too Young");
} else if(age < 100) {
   System.out.println("Welcome!");
} else { // age >= 100
   System.out.println("Really?");
}
````
````plaintext
Welcome!
````
[>Try it yourself<](https://repl.it/@m0stlyharmless/MCIAppExElseIf#Main.java){:target="_blank"}

## Logical Operators

Logical operators are used to combine multiple conditions.

Let's say you wanted your program to output "Welcome!" only when the variable ``age`` is greater than 18 and the variable ``money`` is greater than 500.
One way to accomplish this is to use nesting:
````java
if (age > 18) {
   if (money > 500) {
      System.out.println("Welcome!");
   }
}
````

However, using the **AND** logical operator ``&&`` is a better way:
````java
if (age > 18 && money > 500) {
   System.out.println("Welcome!");
}
````

The available logical operators are
- ``&&`` and
- ``||`` or
- ``!`` not

> ``!(age > 18)`` reads as "if age is NOT greater than 18".