"""
============================================================
                    OOP IN PYTHON
============================================================

OOP = Object-Oriented Programming

Object-Oriented Programming is a programming paradigm in
which programs are designed around OBJECTS.

An object represents a real-world or logical entity and
contains:

    1. DATA       -> Attributes / Properties
    2. BEHAVIOR   -> Methods / Functions

Example real-world entity:

    Student
        Data:
            name
            age
            marks

        Behavior:
            study()
            attend_class()
            display_details()

Instead of keeping data and functions completely separate,
OOP allows us to organize related data and behavior together.

------------------------------------------------------------
WHY DO WE USE OOP?
------------------------------------------------------------

OOP is useful because it helps us:

    - Organize large programs
    - Represent real-world entities
    - Reuse code
    - Reduce code duplication
    - Make code easier to maintain
    - Protect/control data
    - Build large software systems

------------------------------------------------------------
FOUR MAJOR PRINCIPLES OF OOP
------------------------------------------------------------

1. Encapsulation
   -> Combining data and methods into a single unit.

2. Abstraction
   -> Hiding unnecessary implementation details.

3. Inheritance
   -> Creating a new class from an existing class.

4. Polymorphism
   -> One interface/name behaving differently in
      different situations.

We will study these concepts separately.
"""


# ============================================================
#                    CLASS AND OBJECT
# ============================================================

"""
------------------------------------------------------------
CLASS
------------------------------------------------------------

A class is a BLUEPRINT or TEMPLATE used to create objects.

A class describes:

    - What data an object can have
    - What operations an object can perform

For example:

    Class -> Student

The class can define:

    name
    age
    marks

and methods such as:

    study()
    display_details()

A class itself is a definition/template.

------------------------------------------------------------
OBJECT
------------------------------------------------------------

An object is an INSTANCE of a class.

If Student is the class:

    student1 = Student()
    student2 = Student()

Then:

    Student  -> Class / Blueprint
    student1 -> Object
    student2 -> Object

Multiple objects can be created from the same class.

Each object can have its own data.
"""


# ============================================================
#              CREATING A SIMPLE CLASS
# ============================================================

class Student:
    """
    This is a class named Student.

    The class defines the structure and behavior that
    Student objects can have.
    """

    # Class attribute
    school = "ABC School"


# ============================================================
#                 CREATING OBJECTS
# ============================================================

"""
The following statements create objects of Student.

Syntax:

    object_name = ClassName()

Here:

    Student()  -> creates a Student object
    student1   -> refers to that object
"""

student1 = Student()
student2 = Student()

print(student1)        # Output: <__main__.Student object at ...>
print(type(student1))  # Output: <class '__main__.Student'>


# ============================================================
#                    CLASS ATTRIBUTE
# ============================================================

"""
A class attribute is a variable defined inside a class
and outside the methods.

It is generally shared by all objects of that class.

Example:

    school = "ABC School"

Both student1 and student2 can access it.
"""

print(student1.school)  # Output: ABC School
print(student2.school)  # Output: ABC School


# ============================================================
#                 OBJECT / INSTANCE ATTRIBUTE
# ============================================================

"""
An instance attribute belongs to a particular object.

Different objects can have different values.

We can assign attributes directly to an object:

    object.attribute = value
"""

student1.name = "Rahul"
student1.age = 20

student2.name = "Aman"
student2.age = 21

print(student1.name)  # Output: Rahul
print(student1.age)   # Output: 20

print(student2.name)  # Output: Aman
print(student2.age)   # Output: 21


"""
Notice:

    student1.name -> Rahul
    student2.name -> Aman

Both objects were created from the same Student class,
but their instance data is different.

This is one of the important reasons why objects are useful.
"""


# ============================================================
#              CLASS ATTRIBUTE VS INSTANCE ATTRIBUTE
# ============================================================

"""
CLASS ATTRIBUTE
---------------

    - Defined inside the class.
    - Shared by objects unless overridden.
    - Represents data common to objects.

INSTANCE ATTRIBUTE
------------------

    - Belongs to a particular object.
    - Different objects can have different values.
    - Usually created using self inside __init__().

Example:

    school -> class attribute
    name   -> instance attribute
    age    -> instance attribute
"""


# ============================================================
#                  __init__() METHOD
# ============================================================

"""
When creating objects, we normally want to initialize their
data automatically.

Python provides a special method called:

    __init__()

It is commonly called the constructor in beginner-level
Python explanations.

It runs automatically when an object is created.

Syntax:

    def __init__(self, parameters):
        ...

Example:

    student1 = Student("Rahul", 20)

During object creation, Python automatically calls:

    __init__(student1, "Rahul", 20)

The first parameter is conventionally called 'self'.
"""


class Student:

    def __init__(self, name, age):
        """
        self refers to the current object.

        self.name means:
            Store 'name' as an attribute of the current object.

        self.age means:
            Store 'age' as an attribute of the current object.
        """

        self.name = name
        self.age = age


student1 = Student("Rahul", 20)
student2 = Student("Aman", 21)

print(student1.name)  # Output: Rahul
print(student1.age)   # Output: 20

print(student2.name)  # Output: Aman
print(student2.age)   # Output: 21


# ============================================================
#                         SELF
# ============================================================

"""
self is one of the most important concepts in Python OOP.

self refers to the CURRENT OBJECT.

Suppose:

    student1 = Student("Rahul", 20)
    student2 = Student("Aman", 21)

When __init__() is called for student1:

    self -> student1

Therefore:

    self.name = name

means:

    student1.name = "Rahul"

When __init__() is called for student2:

    self -> student2

Therefore:

    self.name = name

means:

    student2.name = "Aman"

So self allows each object to maintain its own data.
"""


# ============================================================
#                       INSTANCE METHODS
# ============================================================

"""
A function defined inside a class is called a METHOD.

An instance method operates on an object.

The first parameter of an instance method is conventionally
named self.

Syntax:

    class ClassName:

        def method_name(self):
            ...


Example:
"""


class Student:

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def introduce(self):
        """
        Instance method.

        self gives access to the current object's attributes.
        """

        print("Name:", self.name)
        print("Age:", self.age)


student1 = Student("Rahul", 20)

student1.introduce()
# Output:
# Name: Rahul
# Age: 20


# ============================================================
#               METHOD WITH PARAMETERS
# ============================================================

class Calculator:

    def add(self, a, b):
        result = a + b
        print(result)  # Output: 30


calculator = Calculator()

calculator.add(10, 20)
# Output: 30


"""
Here:

    calculator
        ↓
    Calculator object

    calculator.add(10, 20)

Python internally passes the object as the first argument:

    Calculator.add(calculator, 10, 20)

Therefore:

    self -> calculator
    a    -> 10
    b    -> 20
"""


# ============================================================
#              OBJECTS HAVE THEIR OWN STATE
# ============================================================

"""
The collection of values stored inside an object represents
its STATE.

For example:

    student1:
        name = Rahul
        age  = 20

    student2:
        name = Aman
        age  = 21

Both objects belong to the same class but have different
states.
"""


class Student:

    def __init__(self, name, marks):
        self.name = name
        self.marks = marks

    def display(self):
        print(self.name, self.marks)


student1 = Student("Rahul", 85)
student2 = Student("Aman", 92)

student1.display()
# Output: Rahul 85

student2.display()
# Output: Aman 92


# ============================================================
#              MODIFYING OBJECT ATTRIBUTES
# ============================================================

"""
Objects are mutable by default.

Therefore, their instance attributes can generally be
changed after object creation.
"""

student1.marks = 95

print(student1.marks)  # Output: 95


# ============================================================
#              ADDING A NEW ATTRIBUTE
# ============================================================

"""
Python also allows us to add an attribute directly to an
object.

However, that attribute will belong only to that particular
object.
"""

student1.city = "Delhi"

print(student1.city)  # Output: Delhi

"""
student2 does NOT automatically have the city attribute
because city was added only to student1.
"""


# ============================================================
#          CLASS ATTRIBUTE VS INSTANCE ATTRIBUTE
# ============================================================

class Student:

    school = "ABC School"       # Class attribute

    def __init__(self, name):
        self.name = name        # Instance attribute


student1 = Student("Rahul")
student2 = Student("Aman")

print(student1.school)  # Output: ABC School
print(student2.school)  # Output: ABC School

print(student1.name)    # Output: Rahul
print(student2.name)    # Output: Aman


# ============================================================
#                 COMPLETE PRACTICAL EXAMPLE
# ============================================================

"""
Let's create a Student class representing a real-world
student.

The class contains:

    Class attribute:
        school

    Instance attributes:
        name
        age
        marks

    Instance methods:
        display()
        is_pass()
"""


class Student:

    school = "ABC School"

    def __init__(self, name, age, marks):
        self.name = name
        self.age = age
        self.marks = marks

    def display(self):
        print("Name:", self.name)
        print("Age:", self.age)
        print("Marks:", self.marks)
        print("School:", self.school)

    def is_pass(self):
        return self.marks >= 40


student1 = Student("Rahul", 20, 85)
student2 = Student("Aman", 21, 35)

student1.display()
# Output:
# Name: Rahul
# Age: 20
# Marks: 85
# School: ABC School

print(student1.is_pass())  # Output: True

student2.display()
# Output:
# Name: Aman
# Age: 21
# Marks: 35
# School: ABC School

print(student2.is_pass())  # Output: False


# ============================================================
#                  IMPORTANT TERMINOLOGIES
# ============================================================

"""
CLASS
-----
A blueprint/template used to create objects.

OBJECT
------
An instance of a class.

INSTANCE
--------
Another term for an object created from a class.

ATTRIBUTE
---------
A variable associated with an object or class.

INSTANCE ATTRIBUTE
------------------
An attribute belonging to a particular object.

CLASS ATTRIBUTE
---------------
An attribute defined at class level and generally shared
by objects.

METHOD
------
A function defined inside a class.

self
----
Reference to the current object.

__init__()
----------
A special initialization method that executes automatically
when an object is created.

STATE
-----
The current data/values stored in an object.

BEHAVIOR
--------
The operations that an object can perform through methods.
"""


# ============================================================
#                  EXECUTION FLOW
# ============================================================

"""
Consider:

    student1 = Student("Rahul", 20, 85)

Execution:

1. Python sees Student("Rahul", 20, 85).

2. A new Student object is created.

3. Python calls __init__() automatically.

4. The newly created object is passed as self.

5. Therefore:

       self -> student1

6. The assignments execute:

       self.name = name
       self.age = age
       self.marks = marks

7. The object now contains:

       student1.name  -> "Rahul"
       student1.age   -> 20
       student1.marks -> 85

8. student1 stores a reference to this object.

This is the basic object-creation flow in Python.
"""


# ============================================================
#                       KEY POINTS
# ============================================================

"""
KEY POINTS:

1. OOP stands for Object-Oriented Programming.

2. A class is a blueprint/template for creating objects.

3. An object is an instance of a class.

4. Multiple objects can be created from one class.

5. Objects can have their own instance attributes.

6. Class attributes are defined at class level.

7. Instance attributes commonly use self.

8. self refers to the current object.

9. __init__() is automatically called during object creation.

10. Functions defined inside a class are called methods.

11. Objects contain state (data) and behavior (methods).

12. Python allows objects to be modified after creation.

13. OOP helps organize and reuse code.

14. The four major OOP principles are:

        Encapsulation
        Abstraction
        Inheritance
        Polymorphism
"""


# ============================================================
#                   COMMON MISTAKES
# ============================================================

"""
1. Forgetting self:

       def display():
           print(self.name)

   This is incorrect because self was not declared.

   Correct:

       def display(self):
           print(self.name)


2. Forgetting to use self when creating instance attributes:

       name = name

   This does NOT create an instance attribute.

   Correct:

       self.name = name


3. Trying to access an instance attribute from the class:

       Student.name

   This will generally fail if name is created only inside
   __init__().


4. Confusing class attributes and instance attributes.

5. Forgetting parentheses while creating an object:

       student = Student

   This stores the class itself rather than creating an object.

   Correct:

       student = Student()


6. Calling an instance method without an object when the
   method requires self.
"""