# Comparing Objects
{: .reading}

We already learned about the `==` operator in an earlier lesson and everything was fine back then. However, there are a few pitfalls when applying the `==` operator to objects.

## Equality operator ==
Remember that when you create objects, the variables store references to the objects.\
So, when you compare objects using the equality testing operator `==`, it actually **compares the references and not the object values**.

Example:
````java
class Animal {
    String name;
    int legs;
    
    Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

}
````
````java
class Main {

  public static void main(String[ ] args) {
    Animal a1 = new Animal("Robby", 4);
    Animal a2 = new Animal("Robby", 4);

    System.out.println(a1 == a2);
  }

}
````
````plaintext
false
````
> Despite having two objects with the same value for their properties, the equality testing returns ``false``, because we have two different objects (two different references or memory locations).

## The equals() Method

Each object has a predefined ``equals(Object)`` method that is used for semantical equality testing, i.e. per default it works exactly the same as the `==` operator.\
Therefore, to make it work for our classes, we need to **override** it and check the conditions we need.

A **naive implementation** of the ``equals`` method for the ``Animal`` class shown above could look like this:

````java
class Animal {
    String name;
    int legs;
    
    Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    // Naive implementation of equals()
    public boolean equals(Object o) {
        Animal other = (Animal) obj;

        if(this.name.equals(other.name)
            && this.legs == other.legs)
            return true;
        else
            return false;
    }
````

While this would indeed work in the above example, there are a lot of problems within this implementation.\
Notice that the parameter `o` is not necessarily of the type ``Animal``, it can be any type (``Object`` is a superclass of every class).\
Moreover, the object ``o`` to compare to could also be ``null``. The ``name`` of this or the other object could be ``null``.

Additionally, there is also a method `hashcode` which defines a **unique id** of every object, kind of a fingerprint. Whenever you implement ``equals``, you **must** also implement ``hashCode``. However, `hashcode` and `equals` are tricky to get right, because whenever ``a.equals(b) == true``, it **must** also be that ``a.hashcode() == b.hashcode()``.

Writing a suitable ``equals`` methods used to be difficult, but in recent versions of Java it got a lot easier with the addition of the helper class `Objects`. Additionally, most IDEs support the automatic generation of ``hashcode`` and ``equal``.

A correct implementation of the class ``Animal`` using the `Objects` helper class is:
````java
import java.util.Objects;

class Animal {
    String name;
    int legs;

    Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return legs == animal.legs &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, legs);
    }
}
````

We can run the test again, using the ``equals`` method:
````java
class Main {

  public static void main(String[ ] args) {
    Animal a1 = new Animal("Robby", 4);
    Animal a2 = new Animal("Robby", 4);

    System.out.println(a1.equals(a2));
  }

}
````
````plaintext
true
````