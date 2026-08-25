"""
===============================================================================
                         ABSTRACTION IN PYTHON
===============================================================================

Abstraction is one of the four major principles of Object-Oriented
Programming (OOP).

The four major OOP principles are:

    1. Encapsulation
    2. Abstraction
    3. Inheritance
    4. Polymorphism


===============================================================================
1. WHAT IS ABSTRACTION?
===============================================================================

Abstraction means:

    "Hiding unnecessary implementation details and exposing only the
     essential functionality."

In other words, abstraction tells us:

    WHAT an object can do

while hiding:

    HOW the object does it.


REAL-WORLD EXAMPLE
------------------

Consider a car.

When we drive a car, we use:

    steering wheel
    accelerator
    brake
    gear

We do NOT need to know every internal detail of:

    engine
    fuel injection
    transmission
    braking mechanism
    electronic control systems

We only interact with the necessary controls.

Therefore:

    What we see/use:
        steering()
        accelerate()
        brake()

    What is hidden:
        internal engine implementation
        fuel injection logic
        transmission mechanism
        etc.

This is abstraction.


===============================================================================
2. ABSTRACTION IN PROGRAMMING
===============================================================================

Suppose we have:

    Payment

A payment system may provide:

    pay()

The user only needs to know:

    payment.pay()

The user does not necessarily need to know how:

    credit card payment
    UPI payment
    bank transfer
    wallet payment

is internally implemented.

Therefore:

    pay()
        -> essential functionality

    internal payment processing
        -> implementation details


===============================================================================
3. HOW DO WE ACHIEVE ABSTRACTION IN PYTHON?
===============================================================================

Python provides the:

    abc

module

ABC stands for:

    Abstract Base Class

Important components:

    from abc import ABC, abstractmethod

    ABC
        -> used as the base class for an abstract class

    @abstractmethod
        -> used to declare an abstract method


Basic structure:

    from abc import ABC, abstractmethod

    class ClassName(ABC):

        @abstractmethod
        def method_name(self):
            pass


===============================================================================
4. ABSTRACT CLASS
===============================================================================

An abstract class is a class that is intended to act as a blueprint for
other classes.

It can contain:

    - abstract methods
    - concrete methods
    - instance attributes
    - constructors
    - class attributes

An abstract class generally represents a common concept.

Example:

    Animal

Different animals can:

    eat()
    sleep()
    make_sound()

But the exact implementation of make_sound() depends on the particular
animal.

Therefore, Animal can define the requirement:

    make_sound()

while child classes provide the actual implementation.


===============================================================================
5. ABSTRACT METHOD
===============================================================================

An abstract method is a method that is declared in an abstract class but
does not provide the required implementation for child classes.

It is created using:

    @abstractmethod

Example:

    @abstractmethod
    def make_sound(self):
        pass

The child class is expected to implement this method.


===============================================================================
6. FIRST ABSTRACTION EXAMPLE
===============================================================================
"""

from abc import ABC, abstractmethod


class Animal(ABC):

    @abstractmethod
    def make_sound(self):
        pass


class Dog(Animal):

    def make_sound(self):
        print("Dog says: Bark")


class Cat(Animal):

    def make_sound(self):
        print("Cat says: Meow")


dog = Dog()
dog.make_sound()
# Output: Dog says: Bark

cat = Cat()
cat.make_sound()
# Output: Cat says: Meow


"""
Here:

    Animal
        -> abstract class

    make_sound()
        -> abstract method

    Dog
        -> concrete child class

    Cat
        -> concrete child class

Dog and Cat must provide their own implementation of make_sound().

The parent class only specifies:

    "Every Animal must have make_sound()."

It does not specify exactly how every animal makes its sound.


===============================================================================
7. WHY USE ABSTRACT CLASSES?
===============================================================================

Without abstraction, we could simply create normal classes.

However, abstraction becomes useful when we want to enforce a common
structure.

Suppose we have:

    Car
    Bike
    Truck

All vehicles should have:

    start()

Instead of relying on programmers to remember implementing start(),
we can define it as an abstract method.

Then every concrete child class is required to implement it.


===============================================================================
8. ABSTRACT CLASS CANNOT NORMALLY BE INSTANTIATED
===============================================================================

An abstract class containing abstract methods cannot be instantiated.

Example:
"""


class Vehicle(ABC):

    @abstractmethod
    def start(self):
        pass


# vehicle = Vehicle()
# TypeError:
# Can't instantiate abstract class Vehicle with abstract method start


"""
The above statement is intentionally commented out because it would stop
program execution.

Why does Python prevent this?

Because Vehicle is incomplete.

It says:

    Every Vehicle must have start()

but Vehicle itself has not provided a concrete implementation.

Therefore:

    Vehicle()
        -> not allowed

But a concrete child class can be created.


===============================================================================
9. CONCRETE CLASS
===============================================================================

A concrete class is a class that provides implementations for all required
abstract methods.

Example:
"""


class Car(Vehicle):

    def start(self):
        print("Car starts with a button")


car = Car()

car.start()
# Output: Car starts with a button


"""
Car is a concrete class because it implemented:

    start()

Therefore:

    Vehicle()
        -> not allowed

    Car()
        -> allowed


===============================================================================
10. ABSTRACT CLASS AS A BLUEPRINT
===============================================================================

An abstract class can be thought of as a contract or blueprint.

For example:

    Vehicle
        |
        +---- Car
        |
        +---- Bike
        |
        +---- Truck

The abstract class can say:

    Every vehicle must implement:

        start()
        stop()


Each child class decides how those operations work.


===============================================================================
11. MULTIPLE ABSTRACT METHODS
===============================================================================

An abstract class can contain multiple abstract methods.

Example:
"""


class Vehicle(ABC):

    @abstractmethod
    def start(self):
        pass

    @abstractmethod
    def stop(self):
        pass


class Car(Vehicle):

    def start(self):
        print("Car starts")

    def stop(self):
        print("Car stops")


car = Car()

car.start()
# Output: Car starts

car.stop()
# Output: Car stops


"""
Car implemented both:

    start()
    stop()

Therefore Car can be instantiated.


===============================================================================
12. WHAT HAPPENS IF A CHILD CLASS DOES NOT IMPLEMENT
    ALL ABSTRACT METHODS?
===============================================================================

Suppose the parent class contains:

    start()
    stop()

but the child implements only:

    start()

Then the child class is still abstract.

Example:
"""


class Machine(ABC):

    @abstractmethod
    def start(self):
        pass

    @abstractmethod
    def stop(self):
        pass


class WashingMachine(Machine):

    def start(self):
        print("Washing machine starts")


# machine = WashingMachine()
# TypeError:
# Can't instantiate abstract class WashingMachine with abstract method stop


"""
WashingMachine implemented:

    start()

but did not implement:

    stop()

Therefore:

    WashingMachine()

is not allowed.

The child must implement every inherited abstract method before it becomes
a concrete class.


===============================================================================
13. ABSTRACT CLASS CAN CONTAIN NORMAL METHODS
===============================================================================

An important point:

An abstract class does NOT have to contain only abstract methods.

It can contain:

    abstract methods
    concrete methods


Example:
"""


class Animal(ABC):

    @abstractmethod
    def make_sound(self):
        pass

    def sleep(self):
        print("Animal is sleeping")


class Dog(Animal):

    def make_sound(self):
        print("Dog says: Bark")


dog = Dog()

dog.make_sound()
# Output: Dog says: Bark

dog.sleep()
# Output: Animal is sleeping


"""
Here:

    make_sound()
        -> abstract method

    sleep()
        -> concrete method

The child class must implement make_sound(), but it automatically inherits
sleep() from the parent.


===============================================================================
14. ABSTRACT CLASS WITH CONSTRUCTOR
===============================================================================

An abstract class can also have an __init__() constructor.

Example:
"""


class Employee(ABC):

    def __init__(self, name):
        self.name = name

    @abstractmethod
    def calculate_salary(self):
        pass


class Developer(Employee):

    def calculate_salary(self):
        print(self.name, "salary is calculated")


developer = Developer("Alice")

developer.calculate_salary()
# Output: Alice salary is calculated


"""
The constructor belongs to the abstract parent class:

    Employee.__init__()

When Developer is instantiated:

    Developer("Alice")

the inherited constructor executes and initializes:

    self.name = "Alice"


===============================================================================
15. ABSTRACT CLASS + COMMON IMPLEMENTATION
===============================================================================

A very useful design is:

    Abstract class
        -> common data
        -> common methods
        -> abstract methods

Example:
"""


class Shape(ABC):

    def __init__(self, color):
        self.color = color

    def display_color(self):
        print("Color:", self.color)

    @abstractmethod
    def area(self):
        pass


class Rectangle(Shape):

    def __init__(self, color, length, width):
        super().__init__(color)
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width


rectangle = Rectangle("Blue", 10, 5)

rectangle.display_color()
# Output: Color: Blue

print("Area:", rectangle.area())
# Output: Area: 50


"""
Here:

    Shape
        -> abstract class

    color
        -> common attribute

    display_color()
        -> common concrete method

    area()
        -> abstract method

    Rectangle
        -> provides the actual area calculation

This is a very common use of abstraction.


===============================================================================
16. super() WITH ABSTRACT CLASSES
===============================================================================

A child class can use:

    super()

to call the parent constructor or parent concrete methods.

Example:
"""


class Person(ABC):

    def __init__(self, name):
        self.name = name

    @abstractmethod
    def role(self):
        pass

    def display_name(self):
        print("Name:", self.name)


class Student(Person):

    def __init__(self, name, roll_number):
        super().__init__(name)
        self.roll_number = roll_number

    def role(self):
        print("Role: Student")


student = Student("Alice", 101)

student.display_name()
# Output: Name: Alice

student.role()
# Output: Role: Student


"""
super().__init__(name)

calls:

    Person.__init__(name)

Therefore:

    self.name

is initialized by the parent class.


===============================================================================
17. PRACTICAL EXAMPLE: PAYMENT SYSTEM
===============================================================================

Abstraction is extremely useful in systems where multiple implementations
follow the same contract.

For example:

    CreditCardPayment
    UpiPayment
    BankTransfer

All payments should provide:

    pay()


The internal implementation can be different.


class Payment(ABC):

    @abstractmethod
    def pay(self, amount):
        pass


class CreditCardPayment(Payment):

    def pay(self, amount):
        print("Processing credit card payment of", amount)


class UpiPayment(Payment):

    def pay(self, amount):
        print("Processing UPI payment of", amount)


class BankTransfer(Payment):

    def pay(self, amount):
        print("Processing bank transfer of", amount)


credit_card = CreditCardPayment()
upi = UpiPayment()
bank = BankTransfer()

credit_card.pay(500)
# Output: Processing credit card payment of 500

upi.pay(1000)
# Output: Processing UPI payment of 1000

bank.pay(2000)
# Output: Processing bank transfer of 2000



The user of these classes only needs to know:

    pay(amount)

They do not need to know the internal implementation.

This is abstraction.


===============================================================================
18. ABSTRACTION + POLYMORPHISM
===============================================================================

Abstraction and polymorphism are often used together.

All payment classes provide:

    pay()

But each class behaves differently.

Example:
"""


payments = [
    CreditCardPayment(),
    UpiPayment(),
    BankTransfer()
]

for payment in payments:
    payment.pay(1000)

# Possible Output:
# Processing credit card payment of 1000
# Processing UPI payment of 1000
# Processing bank transfer of 1000


"""
The loop does not need to know the exact type of payment object.

It simply says:

    payment.pay(1000)

Each object provides its own implementation.

This combines:

    Abstraction
        ->
        common interface: pay()

    Polymorphism
        ->
        different behavior for pay()


===============================================================================
19. ABSTRACTION + INHERITANCE
===============================================================================

Abstraction normally works closely with inheritance.

Example:

                Animal
                  |
          -----------------
          |               |
         Dog             Cat
          |               |
      make_sound()    make_sound()

Animal defines the common requirement.

Dog and Cat provide their own implementations.

Therefore:

    Abstract class
        ↓
    Inheritance
        ↓
    Concrete child classes


===============================================================================
20. ABSTRACT METHOD AS A CONTRACT
===============================================================================

An abstract method can be viewed as a contract.

Example:

    class Vehicle(ABC):

        @abstractmethod
        def start(self):
            pass

This effectively establishes the requirement:

    "Any concrete Vehicle subclass must provide start()."


The parent class defines:

    WHAT must exist.

The child class defines:

    HOW it works.


This is one of the most important ideas behind abstraction.


===============================================================================
21. ABSTRACTION VS ENCAPSULATION
===============================================================================

These concepts are related but different.


ABSTRACTION
-----------

Focus:

    Hiding implementation complexity.

Question it answers:

    "What should the user see/use?"


Example:

    car.start()

The user does not need to know the internal starting mechanism.


ENCAPSULATION
-------------

Focus:

    Bundling data and methods together and controlling access to internal
    state.

Question it answers:

    "How should the object's internal data be protected or controlled?"


Simple memory trick:

    Abstraction
        -> Hides complexity.

    Encapsulation
        -> Controls access to data/implementation.


===============================================================================
22. ABSTRACTION VS INHERITANCE
===============================================================================

Inheritance is a mechanism for creating a new class from an existing class.

Example:

    class Dog(Animal):
        ...


Abstraction is a design principle used to expose essential behavior while
hiding implementation details.

They are different concepts but are often used together.


===============================================================================
23. ABSTRACTION VS POLYMORPHISM
===============================================================================

Abstraction:

    Defines a common interface/contract.

Polymorphism:

    Allows different objects to respond differently to the same operation.


Example:

    payment.pay()

Abstraction:

    Every payment must provide pay().


Polymorphism:

    CreditCardPayment.pay()
    UpiPayment.pay()
    BankTransfer.pay()

can behave differently.


===============================================================================
24. CAN AN ABSTRACT CLASS HAVE NO ABSTRACT METHODS?
===============================================================================

Technically, yes.

A class can inherit from ABC without defining an abstract method.

Example:
"""


class Utility(ABC):

    def display(self):
        print("Utility method")


utility = Utility()

utility.display()
# Output: Utility method


"""
However, such a class does not enforce abstraction because it has no
abstract methods.

For meaningful abstract-class design, abstract methods are normally used
when we want to enforce a contract.


===============================================================================
25. ABSTRACT METHOD CAN HAVE AN IMPLEMENTATION
===============================================================================

An abstract method can technically contain code.

Example:
"""


class Base(ABC):

    @abstractmethod
    def display(self):
        print("Base implementation")


class Child(Base):

    def display(self):
        super().display()
        print("Child implementation")


child = Child()

child.display()
# Output:
# Base implementation
# Child implementation


"""
Even though display() has an implementation in Base, it is still marked
abstract.

Therefore, a concrete subclass is still required to provide its own
implementation.

The child can optionally call the parent implementation using:

    super().display()


===============================================================================
26. ABSTRACT PROPERTY
===============================================================================

Python also allows properties to be abstract.

This is useful when every child class must provide a particular attribute-like
interface.

Example:
"""


class Employee(ABC):

    @property
    @abstractmethod
    def salary(self):
        pass


class Developer(Employee):

    @property
    def salary(self):
        return 80000


developer = Developer()

print(developer.salary)
# Output: 80000


"""
The order is important:

    @property
    @abstractmethod
    def salary(self):

This requires concrete subclasses to provide a salary property.


===============================================================================
27. ABSTRACT CLASS WITH MULTIPLE CHILD CLASSES
===============================================================================

A larger example:

    Shape
       |
       +---- Circle
       |
       +---- Rectangle
       |
       +---- Triangle


Each shape must provide:

    area()

But each shape calculates area differently.


import math


class Shape(ABC):

    @abstractmethod
    def area(self):
        pass


class Circle(Shape):

    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return math.pi * self.radius * self.radius


class Rectangle(Shape):

    def __init__(self, length, width):
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width


circle = Circle(5)
rectangle = Rectangle(10, 4)

print("Circle area:", circle.area())
# Output: Circle area: 78.53981633974483

print("Rectangle area:", rectangle.area())
# Output: Rectangle area: 40

The Shape class does not need to know the exact formula for every shape.

It only defines:

    area()

Each child provides its own implementation.


===============================================================================
28. ABSTRACT CLASS CANNOT BE USED AS A COMPLETE IMPLEMENTATION
===============================================================================

Consider:

    class Shape(ABC):

        @abstractmethod
        def area(self):
            pass


Shape knows that every shape should have area(), but it cannot know the
specific dimensions/formula for every possible shape.

Therefore, the implementation belongs to the concrete subclass.


===============================================================================
29. ABSTRACT CLASS AS AN INTERFACE-LIKE STRUCTURE
===============================================================================

Python does not have an interface keyword in the same way some other
languages do.

However, abstract base classes can be used to create an interface-like
contract.

Example:

    class Payment(ABC):

        @abstractmethod
        def pay(self, amount):
            pass


This establishes a common API:

    pay(amount)

Different implementations can then provide different behavior.

Therefore, ABCs are commonly used when we want:

    common interface
        +
    enforced implementation


===============================================================================
30. IMPORTANT: ABC IS NOT JUST A NORMAL PARENT CLASS
===============================================================================

Consider:

    class Animal:
        def make_sound(self):
            pass

This does NOT enforce that child classes implement make_sound().

A child could simply inherit the method.

But:

    class Animal(ABC):

        @abstractmethod
        def make_sound(self):
            pass

does enforce the requirement.

If a child does not implement make_sound(), Python will not allow an
instance of that child to be created.


===============================================================================
31. COMPLETE EXAMPLE
===============================================================================

The following example combines:

    - ABC
    - abstractmethod
    - constructor
    - concrete method
    - abstract method
    - inheritance
    - polymorphism
    - abstraction


class Employee(ABC):

    def __init__(self, name):
        self.name = name

    def display_name(self):
        print("Employee:", self.name)

    @abstractmethod
    def calculate_salary(self):
        pass


class FullTimeEmployee(Employee):

    def __init__(self, name, monthly_salary):
        super().__init__(name)
        self.monthly_salary = monthly_salary

    def calculate_salary(self):
        return self.monthly_salary


class PartTimeEmployee(Employee):

    def __init__(self, name, hours, rate):
        super().__init__(name)
        self.hours = hours
        self.rate = rate

    def calculate_salary(self):
        return self.hours * self.rate


full_time = FullTimeEmployee("Alice", 50000)
part_time = PartTimeEmployee("Bob", 100, 500)

full_time.display_name()
# Output: Employee: Alice

print("Salary:", full_time.calculate_salary())
# Output: Salary: 50000

part_time.display_name()
# Output: Employee: Bob

print("Salary:", part_time.calculate_salary())
# Output: Salary: 50000

Here:

    Employee
        -> abstract class

    display_name()
        -> concrete method

    calculate_salary()
        -> abstract method

    FullTimeEmployee
        -> concrete class

    PartTimeEmployee
        -> concrete class

Both child classes must implement:

    calculate_salary()

But they calculate the salary differently.

This is abstraction combined with polymorphism.


===============================================================================
32. IMPORTANT TERMINOLOGY
===============================================================================

ABSTRACT CLASS
    A class containing one or more abstract methods, or a class designed
    around the ABC mechanism.

ABSTRACT METHOD
    A method declared using @abstractmethod that must be implemented by
    concrete subclasses.

CONCRETE CLASS
    A class that has implemented all inherited abstract methods and can
    therefore be instantiated.

ABC
    Abstract Base Class.

ABSTRACT BASE CLASS
    A class created using the ABC mechanism to define a common contract.

ABSTRACT INTERFACE
    The collection of operations that concrete subclasses are expected
    to provide.


===============================================================================
33. COMMON MISTAKES
===============================================================================

MISTAKE 1:

    class Animal:

        @abstractmethod
        def sound(self):
            pass


This is incomplete because the class should normally inherit from ABC:

    class Animal(ABC):


MISTAKE 2:

    class Animal(ABC):

        @abstractmethod
        def sound(self):
            pass

    animal = Animal()


This produces a TypeError because Animal is abstract.


MISTAKE 3:

    class Dog(Animal):
        pass

    dog = Dog()


This also produces a TypeError because Dog has not implemented the abstract
sound() method.


MISTAKE 4:

    @abstractmethod
    def sound():
        pass


The method declaration is missing the usual instance parameter.

Normally:

    @abstractmethod
    def sound(self):
        pass


===============================================================================
34. ABSTRACTION IN ONE VIEW
===============================================================================

                    ABSTRACT CLASS
                          |
                          |
                  defines a contract
                          |
             +------------+------------+
             |                         |
             ↓                         ↓
          Child 1                   Child 2
             |                         |
             ↓                         ↓
       Implementation 1         Implementation 2


Example:

                    Payment
                       |
                    pay()
                       |
          +------------+------------+
          |            |            |
          ↓            ↓            ↓
      CreditCard      UPI      BankTransfer
          |            |            |
          ↓            ↓            ↓
       pay()          pay()        pay()


The caller only needs to know:

    payment.pay(amount)

The internal implementation can remain different.


===============================================================================
35. KEY DIFFERENCE: WHAT vs HOW
===============================================================================

This is the easiest way to remember abstraction.

                    ABSTRACTION
                         |
               +---------+---------+
               |                   |
              WHAT                HOW
               |                   |
               ↓                   ↓
        What operation?      How is it implemented?
               |                   |
               ↓                   ↓
             pay()          payment processing
             start()        engine mechanism
             area()         mathematical formula


Abstraction mainly exposes:

    WHAT

while hiding:

    HOW


===============================================================================
36. FINAL SUMMARY
===============================================================================

1. Abstraction is an OOP principle.

2. Abstraction hides unnecessary implementation details.

3. It exposes only the essential functionality.

4. Python provides the abc module for implementing abstraction.

5. ABC means Abstract Base Class.

6. Use:

       from abc import ABC, abstractmethod

7. An abstract class normally inherits from ABC.

8. An abstract method is declared using:

       @abstractmethod

9. An abstract class containing abstract methods cannot be instantiated.

10. A concrete subclass must implement all inherited abstract methods.

11. If even one abstract method remains unimplemented, the subclass remains
    abstract and cannot normally be instantiated.

12. Abstract classes can contain both:
        - abstract methods
        - concrete methods

13. Abstract classes can also have:
        - constructors
        - attributes
        - properties
        - class methods
        - static methods
        - normal methods

14. Abstraction commonly works together with inheritance.

15. Abstraction commonly works together with polymorphism.

16. Abstract classes can be used to create interface-like contracts.

17. The parent class defines WHAT must be provided.

18. The child class defines HOW it is implemented.

19. A useful real-world example is a payment system:
        Payment
            -> pay()
        CreditCardPayment
            -> pay()
        UpiPayment
            -> pay()
        BankTransfer
            -> pay()

20. The main idea to remember:

        ABSTRACTION = HIDE COMPLEXITY + EXPOSE ESSENTIAL BEHAVIOR


===============================================================================
                         QUICK MEMORY TRICK
===============================================================================

    ABC
     ↓
    Abstract Base Class

    @abstractmethod
     ↓
    "Child class must implement this method."

    Abstract class
     ↓
    Blueprint / Contract

    Concrete class
     ↓
    Complete implementation

    Abstraction
     ↓
    WHAT is required

    Implementation
     ↓
    HOW it works

===============================================================================
"""