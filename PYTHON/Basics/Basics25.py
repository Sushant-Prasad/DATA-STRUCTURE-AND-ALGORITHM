"""
===============================================================================
                         METHODS IN PYTHON
===============================================================================

A METHOD is a function that is defined inside a class and is used to describe
the behavior of an object or the class itself.

In simple terms:

    Function
        -> generally defined independently

    Method
        -> function defined inside a class

Example:

    class Student:

        def hello(self):
            print("Hello")

    s1 = Student()
    s1.hello()

Here:

    hello() -> method
    s1      -> object
    s1.hello() -> method call


===============================================================================
1. TYPES OF METHODS IN PYTHON
===============================================================================

The commonly used method types are:

    1. Instance Method
    2. Class Method
    3. Static Method

This topic mainly focuses on:

    - Instance methods
    - Static methods
    - Decorators

A useful way to remember them:

    Instance Method
        -> works with an object
        -> receives self

    Class Method
        -> works with the class
        -> receives cls

    Static Method
        -> does not automatically receive self or cls
        -> behaves like a utility function placed inside the class


===============================================================================
2. INSTANCE METHOD
===============================================================================

An instance method is a method that works with a particular object.

It normally has:

    self

as its first parameter.

Example:

    def hello(self):
        ...

When we call:

    s1.hello()

Python automatically passes s1 as self.

Conceptually:

    s1.hello()

is similar to:

    Student.hello(s1)

Therefore, self gives the method access to the object's instance
attributes.

"""


class Student:

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def hello(self):
        print("Hello", self.name)

    def display_age(self):
        print("Age:", self.age)


student1 = Student("Alice", 20)

student1.hello()
# Output: Hello Alice

student1.display_age()
# Output: Age: 20


"""
The methods hello() and display_age() are INSTANCE METHODS.

They use self to access:

    self.name
    self.age

Different objects can therefore produce different results.
"""


student2 = Student("Bob", 25)

student2.hello()
# Output: Hello Bob

student2.display_age()
# Output: Age: 25


"""
Same method:

    hello()

Different object:

    student1 -> Alice
    student2 -> Bob

The value of self changes depending on which object calls the method.


===============================================================================
3. INSTANCE METHOD CAN MODIFY OBJECT STATE
===============================================================================

An instance method can read and modify instance attributes.

Example:
"""


class BankAccount:

    def __init__(self, owner, balance):
        self.owner = owner
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        self.balance -= amount

    def display(self):
        print("Owner:", self.owner)
        print("Balance:", self.balance)


account = BankAccount("Alice", 5000)

account.display()
# Output:
# Owner: Alice
# Balance: 5000

account.deposit(2000)

account.display()
# Output:
# Owner: Alice
# Balance: 7000

account.withdraw(1500)

account.display()
# Output:
# Owner: Alice
# Balance: 5500


"""
Here:

    deposit()
    withdraw()
    display()

are instance methods.

They operate on the particular object:

    account

The methods use:

    self.balance

to access and modify that object's balance.


===============================================================================
4. METHOD WITH ADDITIONAL PARAMETERS
===============================================================================

self is only the reference to the current object.

A method can receive additional parameters after self.

Syntax:

    def method_name(self, parameter1, parameter2):
        ...


Example:
"""


class Calculator:

    def add(self, a, b):
        return a + b

    def multiply(self, a, b):
        return a * b


calculator = Calculator()

print(calculator.add(10, 20))
# Output: 30

print(calculator.multiply(5, 4))
# Output: 20


"""
When we write:

    calculator.add(10, 20)

Python automatically supplies:

    self = calculator

and we explicitly supply:

    a = 10
    b = 20


Conceptually:

    Calculator.add(calculator, 10, 20)


===============================================================================
5. WHY self IS REQUIRED
===============================================================================

Suppose an object contains:

    name
    age

The method needs to know which object's data it should use.

Example:

    student1.name -> Alice
    student2.name -> Bob

When student1 calls:

    student1.hello()

self refers to student1.

When student2 calls:

    student2.hello()

self refers to student2.

Therefore:

    self.name

means:

    "name belonging to the current object."


===============================================================================
6. STATIC METHOD
===============================================================================

A static method is a method that does NOT automatically receive:

    self

or:

    cls

It is generally used when the operation is related to the class conceptually
but does not need any object-specific or class-specific data.

A static method is created using the:

    @staticmethod

decorator.

Syntax:

    class ClassName:

        @staticmethod
        def method_name(parameters):
            ...


Example:
"""


class MathOperations:

    @staticmethod
    def add(a, b):
        return a + b

    @staticmethod
    def square(number):
        return number * number


print(MathOperations.add(10, 20))
# Output: 30

print(MathOperations.square(5))
# Output: 25


"""
Notice that we did NOT create an object.

We directly called:

    MathOperations.add()

and:

    MathOperations.square()

There is no self parameter because these methods do not need object state.


===============================================================================
7. STATIC METHOD CAN ALSO BE CALLED THROUGH AN OBJECT
===============================================================================

A static method can technically also be accessed through an instance.

"""


math = MathOperations()

print(math.add(3, 4))
# Output: 7


"""
However, if the method does not depend on object state, calling it through
the class is generally clearer:

    MathOperations.add(3, 4)

instead of:

    math.add(3, 4)


===============================================================================
8. INSTANCE METHOD VS STATIC METHOD
===============================================================================

INSTANCE METHOD:

    class Student:

        def display(self):
            ...

Characteristics:

    - Usually receives self.
    - Works with a particular object.
    - Can access instance attributes.
    - Can modify instance state.
    - Called using an object.

Example:

    student.display()


STATIC METHOD:

    class Student:

        @staticmethod
        def school_info():
            ...

Characteristics:

    - Does not receive self automatically.
    - Does not receive cls automatically.
    - Does not depend on instance state.
    - Generally does not need an object.
    - Can be called using the class.

Example:

    Student.school_info()


===============================================================================
9. PRACTICAL EXAMPLE: INSTANCE + STATIC METHOD
===============================================================================

"""


class Employee:

    company = "ABC Technologies"

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    # Instance method
    def display(self):
        print("Name:", self.name)
        print("Salary:", self.salary)

    # Static method
    @staticmethod
    def calculate_bonus(salary):
        return salary * 0.10


employee1 = Employee("Alice", 50000)

employee1.display()
# Output:
# Name: Alice
# Salary: 50000

print(Employee.calculate_bonus(50000))
# Output: 5000.0


"""
display():

    -> needs self.name and self.salary
    -> therefore it is an instance method.

calculate_bonus():

    -> only needs the salary value supplied to it
    -> does not need employee1
    -> therefore it can be a static method.


===============================================================================
10. WHAT IS A DECORATOR?
===============================================================================

A decorator is a mechanism that modifies or extends the behavior of a
function or class without changing the original function's core code.

Python uses the @ syntax for decorators.

General syntax:

    @decorator
    def function():
        ...


The following:

    @staticmethod
    def add(a, b):
        return a + b

means that the staticmethod decorator is applied to add().

The decorator changes how the function behaves when it is accessed through
the class.


===============================================================================
11. @staticmethod IS A DECORATOR
===============================================================================

Consider:

    @staticmethod
    def add(a, b):
        return a + b

Here:

    @staticmethod
        -> decorator

    add
        -> method

    a, b
        -> parameters

The decorator tells Python that add() should behave as a static method.


===============================================================================
12. DECORATOR CONCEPT WITH A SIMPLE EXAMPLE
===============================================================================

Python functions are objects.

Therefore, a function can be passed to another function.

A decorator can receive a function, wrap it, and return a new function.

Example:
"""


def my_decorator(function):

    def wrapper():
        print("Before function execution")
        function()
        print("After function execution")

    return wrapper


@my_decorator
def greet():
    print("Hello")


greet()
# Output:
# Before function execution
# Hello
# After function execution


"""
The syntax:

    @my_decorator
    def greet():

is approximately equivalent to:

    def greet():
        print("Hello")

    greet = my_decorator(greet)

So the original greet function is passed to my_decorator().

The decorator returns wrapper().

After decoration, calling:

    greet()

actually executes the wrapper function.


===============================================================================
13. DECORATOR EXECUTION FLOW
===============================================================================

For:

    @my_decorator
    def greet():
        print("Hello")

The conceptual process is:

    1. greet() function is created.
    2. my_decorator(greet) is called.
    3. The decorator creates wrapper().
    4. wrapper is returned.
    5. greet now refers to the decorated function.
    6. Calling greet() executes wrapper().
    7. wrapper executes code before the original function.
    8. wrapper calls the original greet().
    9. Original greet() executes.
    10. wrapper executes code after the original function.


===============================================================================
14. DECORATOR WITH PARAMETERS
===============================================================================

Real functions commonly receive parameters.

Therefore, decorators often use:

    *args
    **kwargs

to accept arbitrary positional and keyword arguments.

"""


def logging_decorator(function):

    def wrapper(*args, **kwargs):
        print("Function execution started")
        result = function(*args, **kwargs)
        print("Function execution finished")
        return result

    return wrapper


@logging_decorator
def add(a, b):
    return a + b


result = add(10, 20)

print(result)
# Output:
# Function execution started
# Function execution finished
# 30


"""
Here:

    *args
        -> captures positional arguments

    **kwargs
        -> captures keyword arguments

The wrapper passes them to the original function:

    function(*args, **kwargs)


===============================================================================
15. WHY return result IS IMPORTANT
===============================================================================

Suppose the original function returns a value:

    def add(a, b):
        return a + b

The decorator should generally preserve that return value.

Therefore:

    result = function(*args, **kwargs)
    return result

Without:

    return result

the decorated function would return None even though the original function
returned a value.


===============================================================================
16. DECORATORS AND @staticmethod
===============================================================================

The @staticmethod used earlier is itself a built-in Python decorator.

Example:

    class Math:

        @staticmethod
        def square(n):
            return n * n

The decorator tells Python:

    "Treat this function as a static method when it is accessed through
     the class or an instance."


===============================================================================
17. CLASS METHOD
===============================================================================

Although the main focus here is static methods, it is important to know the
third major method type: CLASS METHOD.

A class method uses:

    @classmethod

and receives:

    cls

as its first parameter.

Example:
"""


class Company:

    company_name = "ABC Technologies"

    @classmethod
    def display_company(cls):
        print("Company:", cls.company_name)


Company.display_company()
# Output: Company: ABC Technologies


"""
Here:

    cls

refers to the CLASS itself.

So:

    cls.company_name

accesses a class attribute.

Compare:

    self -> current object
    cls  -> current class


===============================================================================
18. THREE MAIN METHOD TYPES
===============================================================================

INSTANCE METHOD

    def method(self):
        ...

    First parameter:
        self

    Works with:
        Object / instance

    Can access:
        Instance attributes
        Class attributes

    Typical call:
        object.method()


CLASS METHOD

    @classmethod
    def method(cls):
        ...

    First parameter:
        cls

    Works with:
        Class

    Can access:
        Class attributes

    Typical call:
        Class.method()


STATIC METHOD

    @staticmethod
    def method():
        ...

    First parameter:
        None automatically

    Works with:
        Neither object state nor class state automatically

    Typical call:
        Class.method()


===============================================================================
19. COMPLETE COMPARISON EXAMPLE
===============================================================================
"""


class Student:

    school = "ABC School"

    def __init__(self, name, age):
        self.name = name
        self.age = age

    # Instance method
    def display(self):
        print("Name:", self.name)
        print("Age:", self.age)
        print("School:", self.school)

    # Class method
    @classmethod
    def change_school(cls, new_school):
        cls.school = new_school

    # Static method
    @staticmethod
    def is_adult(age):
        return age >= 18


student = Student("Alice", 20)

student.display()
# Output:
# Name: Alice
# Age: 20
# School: ABC School


Student.change_school("XYZ School")

student.display()
# Output:
# Name: Alice
# Age: 20
# School: XYZ School


print(Student.is_adult(20))
# Output: True

print(Student.is_adult(15))
# Output: False


"""
Notice the difference:

    display(self)
        -> needs the student object.

    change_school(cls, new_school)
        -> needs the class.

    is_adult(age)
        -> needs neither the object nor the class.


===============================================================================
20. WHEN SHOULD WE USE EACH METHOD?
===============================================================================

USE AN INSTANCE METHOD WHEN:

    The operation needs information belonging to a particular object.

Example:

    account.deposit(500)

The deposit operation needs that account's balance.

Therefore:

    self.balance

is required.


USE A CLASS METHOD WHEN:

    The operation needs to work with class-level data or modify class-level
    state.

Example:

    Student.change_school("XYZ School")

The operation changes the class-level school attribute.


USE A STATIC METHOD WHEN:

    The operation is logically related to the class but does not need
    instance-specific or class-specific information.

Example:

    Student.is_adult(20)

The calculation only needs the age provided as an argument.


===============================================================================
21. IMPORTANT DIFFERENCE BETWEEN A FUNCTION AND A METHOD
===============================================================================

Function:

    def add(a, b):
        return a + b

Method:

    class Calculator:

        def add(self, a, b):
            return a + b

The method is defined inside a class.

A method can receive an implicit reference such as:

    self
    cls

depending on its type.

A static method does not automatically receive either.


===============================================================================
22. IMPORTANT POINTS ABOUT self
===============================================================================

self is NOT a Python keyword.

It is a naming convention.

Technically, we could write:

    class Student:

        def display(current_object):
            print(current_object.name)

But this is strongly discouraged.

The standard and universally accepted convention is:

    self


===============================================================================
23. IMPORTANT POINTS ABOUT DECORATORS
===============================================================================

1. Decorators modify or extend the behavior of functions or classes.

2. They use the @ syntax.

3. A decorator receives a function/class and usually returns a modified
   function/class.

4. @staticmethod is a built-in decorator.

5. @classmethod is also a built-in decorator.

6. Custom decorators can be created using functions.

7. Decorators are widely used in Python frameworks and libraries.

Common examples include:

    @staticmethod
    @classmethod
    @property

Frameworks also commonly use decorators for:

    routing
    authentication
    authorization
    caching
    logging
    validation


===============================================================================
24. KEY POINTS
===============================================================================

1. A method is a function defined inside a class.

2. Instance methods normally receive self.

3. self represents the current object.

4. Instance methods can access and modify instance attributes.

5. Static methods are created using @staticmethod.

6. Static methods do not automatically receive self.

7. Static methods are useful for utility operations related to a class.

8. Class methods are created using @classmethod.

9. Class methods receive cls as their first parameter.

10. self refers to the current object.

11. cls refers to the current class.

12. @staticmethod and @classmethod are decorators.

13. A decorator can modify or extend the behavior of a function or class.

14. @decorator syntax is essentially syntactic sugar for passing a function
    through a decorator.

15. Use an instance method when object state is required.

16. Use a class method when class state is required.

17. Use a static method when neither object state nor class state is required.

18. A static method can be called directly using the class:

        ClassName.method()

19. A method can have additional parameters after self or cls.

20. Decorators are an important part of Python's object-oriented and
    framework-based programming style.


===============================================================================
                    QUICK MEMORY TRICK
===============================================================================

                    METHOD TYPES

             ┌──────────────┬──────────────┬──────────────┐
             │   INSTANCE   │    CLASS     │    STATIC    │
             ├──────────────┼──────────────┼──────────────┤
             │ self         │ cls          │ none         │
             │ object       │ class        │ utility      │
             │ @none        │ @classmethod │ @staticmethod│
             │ object state │ class state  │ independent  │
             └──────────────┴──────────────┴──────────────┘


Remember:

    self -> object
    cls  -> class
    static -> neither automatically


===============================================================================
"""