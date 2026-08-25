"""
===============================================================================
                    __init__(), CONSTRUCTORS & ATTRIBUTES
===============================================================================

The __init__() method is a special method in Python that is automatically
called after an object has been created.

It is commonly called the "constructor" in Python because it is normally used
to initialize the object's attributes.

Important technical distinction:

    object creation      -> __new__()
    object initialization -> __init__()

For beginners, __init__() is generally referred to as the constructor because
it is the method we normally write to initialize an object's state.

Syntax:

    class ClassName:

        def __init__(self, parameters):
            self.attribute = value


===============================================================================
1. WHAT IS self?
===============================================================================

self represents the CURRENT OBJECT / CURRENT INSTANCE.

Suppose:

    s1 = Student("Alice")
    s2 = Student("Bob")

When Python executes:

    s1 = Student("Alice")

inside __init__():

    self -> s1

When Python executes:

    s2 = Student("Bob")

inside __init__():

    self -> s2

Therefore:

    self.name = name

means:

    Store the value of name inside the current object's name attribute.

The name "self" is a convention. Python automatically passes the current
object as the first argument to an instance method.

For example:

    s1.display()

is conceptually similar to:

    Student.display(s1)

Therefore, self allows the method to know WHICH object it is working with.


===============================================================================
2. DEFAULT CONSTRUCTOR
===============================================================================

A default constructor is a constructor that does not require any arguments
from the caller.

There are two common situations:

1. We do not define __init__() at all.
2. We explicitly define an __init__() that requires no additional arguments.

Python automatically provides a default __init__() when a class does not
define one.

Example:
"""

class EmptyStudent:
    pass


student1 = EmptyStudent()

print(type(student1))
# Output: <class '__main__.EmptyStudent'>


"""
The class above does not define __init__().

Python still allows us to create an object:

    student1 = EmptyStudent()

However, the class currently has no instance attributes.

This is useful when we want a simple empty object or when initialization
will happen later.

We can also explicitly define a no-argument __init__().
"""


class DefaultStudent:

    def __init__(self):
        self.name = "Unknown"
        self.age = 0
        self.course = "Not Assigned"


student2 = DefaultStudent()

print(student2.name)
# Output: Unknown

print(student2.age)
# Output: 0

print(student2.course)
# Output: Not Assigned


"""
Here __init__() is automatically executed when:

    DefaultStudent()

creates the object.

The following sequence occurs conceptually:

    1. Object is created.
    2. __init__() is called automatically.
    3. self refers to the newly created object.
    4. Instance attributes are initialized.
"""


"""
===============================================================================
3. PARAMETERIZED CONSTRUCTOR
===============================================================================

A parameterized constructor accepts values from the caller and uses those
values to initialize the object's attributes.

Example:

    class Student:

        def __init__(self, name, age):
            self.name = name
            self.age = age

    s1 = Student("Alice", 20)

Here:

    name = "Alice"
    age  = 20

and:

    self -> s1

Therefore:

    s1.name = "Alice"
    s1.age  = 20
"""


class Student:

    def __init__(self, name, age):
        self.name = name
        self.age = age


student3 = Student("Alice", 20)

print(student3.name)
# Output: Alice

print(student3.age)
# Output: 20


"""
We can create another object with completely different values.
"""

student4 = Student("Bob", 22)

print(student4.name)
# Output: Bob

print(student4.age)
# Output: 22


"""
Notice that both objects use the SAME class but have DIFFERENT instance data.

Conceptually:

    Student
       |
       +---- student3
       |       name -> "Alice"
       |       age  -> 20
       |
       +---- student4
               name -> "Bob"
               age  -> 22


===============================================================================
4. WHY DO WE NEED self.attribute?
===============================================================================

Consider:

    def __init__(self, name):
        self.name = name

There are two different things here:

    name
        -> local parameter

    self.name
        -> attribute belonging to the current object

Example:

    student = Student("Alice")

During execution:

    name = "Alice"

Then:

    self.name = name

stores "Alice" inside the object.

If we only wrote:

    name = name

we would only be assigning the local variable to itself. We would NOT create
an instance attribute.


===============================================================================
5. MULTIPLE INSTANCE ATTRIBUTES
===============================================================================

A constructor can initialize any number of attributes.

The attributes can have different data types.
"""


class Employee:

    def __init__(self, name, age, salary, is_active):
        self.name = name
        self.age = age
        self.salary = salary
        self.is_active = is_active


employee1 = Employee("John", 25, 50000.0, True)

print(employee1.name)
# Output: John

print(employee1.age)
# Output: 25

print(employee1.salary)
# Output: 50000.0

print(employee1.is_active)
# Output: True


"""
Each attribute belongs to employee1.

The object can therefore store its own state:

    employee1.name
    employee1.age
    employee1.salary
    employee1.is_active


===============================================================================
6. DEFAULT VALUES IN __init__()
===============================================================================

Python does not support traditional constructor overloading like Java.

Instead, we can use default parameter values.

Example:

    def __init__(self, name="Unknown", age=0):

This allows us to create objects with:

    Employee()
    Employee("Alice")
    Employee("Alice", 25)

depending on which arguments we provide.
"""


class Person:

    def __init__(self, name="Unknown", age=0):
        self.name = name
        self.age = age


person1 = Person()

print(person1.name, person1.age)
# Output: Unknown 0

person2 = Person("Alice")

print(person2.name, person2.age)
# Output: Alice 0

person3 = Person("Bob", 25)

print(person3.name, person3.age)
# Output: Bob 25


"""
This is one of the most useful ways to achieve flexible object
initialization in Python.

There is still only ONE __init__() method.

Python chooses the default values for arguments that were not supplied.


===============================================================================
7. PYTHON DOES NOT SUPPORT CONSTRUCTOR OVERLOADING
===============================================================================

In languages such as Java, we can define multiple constructors:

    Student()
    Student(String name)
    Student(String name, int age)

Python does NOT allow multiple __init__() definitions in the same class
with different parameter lists.

For example, this does NOT work as constructor overloading:

    def __init__(self):
        ...

    def __init__(self, name):
        ...

The second definition replaces the first one.

Instead, Python commonly uses:

    1. Default arguments
    2. *args / **kwargs
    3. Class methods
    4. Other design patterns

For normal beginner-level object initialization, default arguments are
usually the simplest solution.


===============================================================================
8. CLASS ATTRIBUTE
===============================================================================

A class attribute is an attribute defined directly inside the class body,
outside instance methods.

Example:

    class Student:

        school = "ABC School"

        def __init__(self, name):
            self.name = name

Here:

    school
        -> class attribute

    name
        -> instance attribute

A class attribute is associated with the CLASS and can be accessed through
the class itself or normally through an instance.
"""


class SchoolStudent:

    school = "ABC School"

    def __init__(self, name):
        self.name = name


student5 = SchoolStudent("Alice")
student6 = SchoolStudent("Bob")

print(SchoolStudent.school)
# Output: ABC School

print(student5.school)
# Output: ABC School

print(student6.school)
# Output: ABC School


"""
There is one class attribute:

    SchoolStudent.school

Both objects can access it.

Conceptually:

                 SchoolStudent
                      |
                 school = "ABC School"
                    /       \
                   /         \
              student5     student6
              name=Alice   name=Bob


===============================================================================
9. INSTANCE ATTRIBUTE
===============================================================================

An instance attribute belongs to a PARTICULAR OBJECT.

Instance attributes are normally created using:

    self.attribute = value

inside __init__() or another instance method.

Example:

    self.name = name

If we create:

    student5 = SchoolStudent("Alice")
    student6 = SchoolStudent("Bob")

then:

    student5.name -> "Alice"
    student6.name -> "Bob"

Each object has its own name.

Changing one object's instance attribute does not normally change the
other object's instance attribute.
"""


student5.name = "Charlie"

print(student5.name)
# Output: Charlie

print(student6.name)
# Output: Bob


"""
Only student5.name changed.

student6.name remains unchanged because name is an instance attribute.


===============================================================================
10. CLASS ATTRIBUTE VS INSTANCE ATTRIBUTE
===============================================================================

Class attribute:

    class Student:
        school = "ABC"

Instance attribute:

    class Student:

        def __init__(self, name):
            self.name = name

The major difference:

    Class attribute
        -> shared class-level value

    Instance attribute
        -> belongs to an individual object

Example:
"""


class CollegeStudent:

    college = "XYZ College"          # Class attribute

    def __init__(self, name, branch):
        self.name = name              # Instance attribute
        self.branch = branch          # Instance attribute


cs1 = CollegeStudent("Alice", "CSE")
cs2 = CollegeStudent("Bob", "ECE")

print(cs1.college)
# Output: XYZ College

print(cs2.college)
# Output: XYZ College

print(cs1.name)
# Output: Alice

print(cs2.name)
# Output: Bob

print(cs1.branch)
# Output: CSE

print(cs2.branch)
# Output: ECE


"""
The college value is common, while name and branch are different for each
object.


===============================================================================
11. MODIFYING AN INSTANCE ATTRIBUTE
===============================================================================

Instance attributes can be changed independently.
"""


cs1.branch = "IT"

print(cs1.branch)
# Output: IT

print(cs2.branch)
# Output: ECE


"""
Changing cs1.branch does not affect cs2.branch.


===============================================================================
12. MODIFYING A CLASS ATTRIBUTE
===============================================================================

We can modify a class attribute through the CLASS itself.

Example:

    CollegeStudent.college = "New College"

This changes the class-level value.

Objects that do not have their own college attribute will see the new
class-level value.
"""


CollegeStudent.college = "New College"

print(CollegeStudent.college)
# Output: New College

print(cs1.college)
# Output: New College

print(cs2.college)
# Output: New College


"""
Why?

Because neither cs1 nor cs2 has its own instance attribute named college.

Python therefore looks for college at the class level.


===============================================================================
13. IMPORTANT: INSTANCE ATTRIBUTE CAN SHADOW CLASS ATTRIBUTE
===============================================================================

Suppose the class contains:

    college = "New College"

and we execute:

    cs1.college = "Another College"

This creates an INSTANCE attribute named college for cs1.

It does not change the class attribute.

After this:

    cs1.college
        -> "Another College"

    cs2.college
        -> "New College"

    CollegeStudent.college
        -> "New College"
"""


cs1.college = "Another College"

print(cs1.college)
# Output: Another College

print(cs2.college)
# Output: New College

print(CollegeStudent.college)
# Output: New College


"""
This is called ATTRIBUTE SHADOWING.

The instance attribute named college hides/shadows the class attribute
when accessing college through cs1.


===============================================================================
14. ATTRIBUTE LOOKUP ORDER
===============================================================================

When we write:

    object.attribute

Python generally looks for the attribute through the object's attribute
lookup mechanism, with the instance dictionary considered before the
class and its inheritance hierarchy.

For a normal instance attribute:

    cs1.name

Python finds name in cs1's instance data.

For:

    cs1.college

if cs1 does not have its own college attribute, Python can find college
on the class.

Conceptually:

    cs1.college

        |
        v
    Does cs1 have "college"?
        |
        +-- YES -> use instance value
        |
        +-- NO
             |
             v
        Check class
             |
             v
        CollegeStudent.college


===============================================================================
15. __dict__ AND OBJECT DATA
===============================================================================

For normal Python classes, objects commonly have an instance __dict__
containing their instance attributes.

We can inspect it.

"""


print(cs1.__dict__)
# Output: {'name': 'Alice', 'branch': 'IT', 'college': 'Another College'}

print(cs2.__dict__)
# Output: {'name': 'Bob', 'branch': 'ECE'}


"""
Notice:

    cs1.__dict__
        contains name, branch and its own college.

    cs2.__dict__
        contains name and branch.

The class attribute college is not stored separately inside each object's
__dict__.

It belongs to the class.


===============================================================================
16. CLASS __dict__
===============================================================================

We can also inspect attributes belonging to the class.

"""


print(CollegeStudent.__dict__["college"])
# Output: New College


"""
The class dictionary contains the class attribute.

This helps demonstrate the distinction between:

    object.__dict__
    class.__dict__


===============================================================================
17. DIFFERENT CONSTRUCTOR SCENARIOS
===============================================================================

SCENARIO 1:
No __init__() is written.

Python provides a basic initialization behavior automatically.

SCENARIO 2:
A default/no-argument __init__() is written.

The object can be created without passing additional values.

SCENARIO 3:
A parameterized __init__() is written.

The caller must provide the required values.

SCENARIO 4:
Default parameter values are used.

The caller may provide zero, one, or more values depending on the
parameters.

SCENARIO 5:
Different objects are created with different values.

Each object receives its own instance attributes.

SCENARIO 6:
Class attributes provide values common to objects.

SCENARIO 7:
An instance attribute with the same name as a class attribute shadows
the class attribute for that particular object.


===============================================================================
18. CONSTRUCTOR WITH BOTH CLASS AND INSTANCE ATTRIBUTES
===============================================================================
"""


class Product:

    category = "Electronics"       # Class attribute shared by all products

    def __init__(self, name, price):
        self.name = name            # Instance attribute
        self.price = price          # Instance attribute


product1 = Product("Laptop", 60000)
product2 = Product("Phone", 30000)

print(product1.name, product1.price, product1.category)
# Output: Laptop 60000 Electronics

print(product2.name, product2.price, product2.category)
# Output: Phone 30000 Electronics


"""
Here:

    Product.category
        -> shared class attribute

    product1.name
    product1.price
        -> product1's instance attributes

    product2.name
    product2.price
        -> product2's instance attributes


===============================================================================
19. SAME CLASS, DIFFERENT OBJECT STATE
===============================================================================

A major purpose of classes is that we can create many objects from the same
blueprint while each object maintains its own state.

"""


product3 = Product("Tablet", 25000)
product4 = Product("Monitor", 15000)

print(product3.name, product3.price)
# Output: Tablet 25000

print(product4.name, product4.price)
# Output: Monitor 15000


"""
All four objects are instances of Product, but their instance data is
different.

    product1 -> Laptop, 60000
    product2 -> Phone, 30000
    product3 -> Tablet, 25000
    product4 -> Monitor, 15000

The class attribute:

    Product.category

is common unless an object shadows it with its own attribute.


===============================================================================
20. CONSTRUCTOR WITH CALCULATED INSTANCE ATTRIBUTE
===============================================================================

The constructor does not have to simply copy parameters.

It can calculate values while initializing the object.
"""


class Rectangle:

    def __init__(self, length, width):
        self.length = length
        self.width = width
        self.area = length * width


rectangle1 = Rectangle(10, 5)

print(rectangle1.length)
# Output: 10

print(rectangle1.width)
# Output: 5

print(rectangle1.area)
# Output: 50


"""
The constructor received:

    length = 10
    width  = 5

and calculated:

    area = 10 * 5 = 50

Therefore, constructors are commonly used to put an object into a valid
initial state.


===============================================================================
21. CONSTRUCTOR WITH DEFAULT AND REQUIRED PARAMETERS
===============================================================================

Some parameters can be required while others can have default values.

"""


class User:

    def __init__(self, username, role="User", active=True):
        self.username = username
        self.role = role
        self.active = active


user1 = User("alice")

print(user1.username, user1.role, user1.active)
# Output: alice User True

user2 = User("bob", "Admin")

print(user2.username, user2.role, user2.active)
# Output: bob Admin True

user3 = User("charlie", "Manager", False)

print(user3.username, user3.role, user3.active)
# Output: charlie Manager False


"""
Here:

    username
        -> required parameter

    role
        -> default value = "User"

    active
        -> default value = True

This gives flexibility without creating multiple __init__() methods.


===============================================================================
22. IMPORTANT: __init__() MUST RETURN None
===============================================================================

The purpose of __init__() is initialization.

It should not return another value.

This is invalid:

    def __init__(self):
        return 10

Python raises a TypeError if __init__() returns a value other than None.

Normally:

    def __init__(self):
        self.name = "Alice"

is correct because it implicitly returns None.


===============================================================================
23. CONSTRUCTOR EXECUTION FLOW
===============================================================================

Consider:

    student = Student("Alice", 20)

The important conceptual flow is:

    1. Python evaluates Student.
    2. Python creates a new Student object.
    3. The object's initialization process calls __init__().
    4. self refers to that newly created object.
    5. "Alice" is assigned to the name parameter.
    6. 20 is assigned to the age parameter.
    7. self.name = name creates the object's name attribute.
    8. self.age = age creates the object's age attribute.
    9. Initialization finishes.
    10. The object reference is assigned to student.


===============================================================================
24. COMPLETE EXAMPLE
===============================================================================

The following class combines:

    - Class attribute
    - Instance attributes
    - Parameterized constructor
    - Default constructor values
    - self
    - Object-specific state
    - Shared class-level information
"""


class BankAccount:

    bank_name = "ABC Bank"          # Class attribute

    def __init__(self, holder, balance=0):
        self.holder = holder        # Instance attribute
        self.balance = balance      # Instance attribute

    def display(self):
        print("Bank:", self.bank_name)
        print("Holder:", self.holder)
        print("Balance:", self.balance)


account1 = BankAccount("Alice", 5000)

account1.display()
# Output:
# Bank: ABC Bank
# Holder: Alice
# Balance: 5000


account2 = BankAccount("Bob")

account2.display()
# Output:
# Bank: ABC Bank
# Holder: Bob
# Balance: 0


"""
account1 and account2 belong to the same class.

But:

    account1.holder -> Alice
    account2.holder -> Bob

and:

    account1.balance -> 5000
    account2.balance -> 0

These are instance attributes.

Meanwhile:

    BankAccount.bank_name -> ABC Bank

is a class attribute shared through the class.

===============================================================================
25. CLASS ATTRIBUTE VS INSTANCE ATTRIBUTE — SUMMARY
===============================================================================

CLASS ATTRIBUTE

    Defined:
        Directly inside the class body.

    Example:
        bank_name = "ABC Bank"

    Belongs primarily to:
        The class.

    Access:
        ClassName.attribute
        object.attribute

    Common use:
        Values shared by objects.


INSTANCE ATTRIBUTE

    Defined:
        Usually using self.attribute.

    Example:
        self.holder = holder

    Belongs to:
        A particular object.

    Access:
        object.attribute

    Common use:
        Object-specific state.


===============================================================================
26. QUICK COMPARISON
===============================================================================

    class Student:

        school = "ABC"              <- CLASS ATTRIBUTE

        def __init__(self, name, age):
            self.name = name        <- INSTANCE ATTRIBUTE
            self.age = age          <- INSTANCE ATTRIBUTE


    s1 = Student("Alice", 20)
    s2 = Student("Bob", 22)


    Student.school
        -> ABC

    s1.school
        -> ABC

    s2.school
        -> ABC


    s1.name
        -> Alice

    s2.name
        -> Bob


The class attribute can be common to all objects.

The instance attributes can be different for every object.


===============================================================================
27. MOST IMPORTANT POINTS TO REMEMBER
===============================================================================

1. __init__() is a special method used to initialize an object.

2. It is automatically called during normal object initialization.

3. self represents the current instance.

4. self.attribute creates or accesses an instance attribute.

5. A parameterized __init__() receives values while creating an object.

6. Default parameter values allow flexible initialization.

7. Python does not support traditional constructor overloading.

8. Multiple __init__() definitions do not create overloaded constructors;
   the later definition replaces the earlier definition.

9. A class attribute is defined directly inside the class body.

10. An instance attribute is normally defined using self.attribute.

11. Instance attributes belong to individual objects.

12. Class attributes are available at the class level and can be accessed
    by instances when an instance attribute of the same name does not
    shadow them.

13. Assigning object.attribute creates or changes an instance attribute.

14. Assigning ClassName.attribute changes the class attribute.

15. An instance attribute with the same name as a class attribute shadows
    the class attribute for that object.

16. __dict__ can be useful for seeing an object's instance attributes and
    a class's stored attributes.

17. Constructors are mainly used to establish the initial valid state of
    an object.

18. Python's technically precise distinction is:

        __new__()  -> creates/allocates the instance
        __init__() -> initializes the instance

    But __init__() is commonly called the constructor in introductory
    Python/OOP terminology.
===============================================================================
"""