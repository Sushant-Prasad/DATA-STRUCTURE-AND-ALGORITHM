"""
===============================================================================
                         ENCAPSULATION IN PYTHON
===============================================================================

Encapsulation is one of the four major principles of Object-Oriented
Programming (OOP).

The four major OOP principles are:

    1. Encapsulation
    2. Abstraction
    3. Inheritance
    4. Polymorphism


===============================================================================
1. WHAT IS ENCAPSULATION?
===============================================================================

Encapsulation means:

    "Bundling data and the methods that operate on that data inside a class,
     while controlling how the data can be accessed or modified."

In simple words:

    Encapsulation = DATA + METHODS + CONTROLLED ACCESS

For example, consider a BankAccount.

An account contains:

    balance
    account_number
    owner_name

and operations such as:

    deposit()
    withdraw()
    check_balance()

Instead of allowing outside code to freely modify the balance, we can
control how the balance is changed.

For example:

    account.deposit(5000)
    account.withdraw(1000)

rather than directly doing:

    account.balance = -50000

This allows the class to protect its internal data.


===============================================================================
2. REAL-WORLD EXAMPLE
===============================================================================

Consider an ATM.

The ATM internally manages:

    account balance
    transaction information
    PIN verification
    withdrawal rules

A user does not directly manipulate the internal balance.

Instead, the user interacts through operations such as:

    withdraw()
    deposit()
    check_balance()

The ATM controls how these operations are performed.

Therefore:

    Internal data
        +
    Methods that operate on that data
        +
    Access control

represent the idea of encapsulation.


===============================================================================
3. ENCAPSULATION IN PYTHON
===============================================================================

Python does not have strict access modifiers like some languages.

Instead, Python mainly uses naming conventions:

    public
    _protected
    __private

These are used to communicate the intended level of access.

Example:

    class Student:

        def __init__(self):
            self.name = "Alice"       # public
            self._age = 20            # protected
            self.__marks = 90          # private


The three naming styles have different meanings.


===============================================================================
4. PUBLIC MEMBERS
===============================================================================

A public attribute can be accessed directly from outside the class.

Example:
"""


class Student:

    def __init__(self, name, age):
        self.name = name
        self.age = age


student = Student("Alice", 20)

print(student.name)
# Output: Alice

print(student.age)
# Output: 20


"""
Here:

    name
    age

are public attributes.

They can be accessed directly:

    student.name
    student.age

They can also be modified directly:
"""


student.name = "Bob"
student.age = 21

print(student.name)
# Output: Bob

print(student.age)
# Output: 21


"""
There is no restriction on direct access to these attributes.

Therefore:

    public member
        ->
    accessible directly from outside the class


===============================================================================
5. PROTECTED MEMBERS
===============================================================================

A single underscore is used to indicate a protected member:

    _variable

Example:
"""


class Employee:

    def __init__(self, name, salary):
        self.name = name
        self._salary = salary


employee = Employee("Alice", 50000)

print(employee.name)
# Output: Alice

print(employee._salary)
# Output: 50000


"""
Important:

Python does NOT strictly prevent:

    employee._salary

from being accessed.

The underscore is mainly a convention that means:

    "This member is intended for internal use or use by subclasses."

Therefore:

    _salary

is not truly private.

It is better described as:

    protected by convention


===============================================================================
6. PRIVATE MEMBERS
===============================================================================

Python uses double underscores to indicate a private attribute:

    __variable

Example:
"""


class BankAccount:

    def __init__(self, balance):
        self.__balance = balance


account = BankAccount(10000)

# print(account.__balance)
# AttributeError:
# 'BankAccount' object has no attribute '__balance'


"""
The direct access:

    account.__balance

does not work normally from outside the class.

This is because Python performs a mechanism called:

    NAME MANGLING

The attribute name is internally changed.

For example:

    __balance

inside:

    BankAccount

is transformed roughly into:

    _BankAccount__balance


===============================================================================
7. NAME MANGLING
===============================================================================

Python's private attributes use name mangling.

Example:
"""


class Student:

    def __init__(self):
        self.__marks = 90


student = Student()

# Direct access:
# print(student.__marks)
# AttributeError


# Name-mangled access:
print(student._Student__marks)
# Output: 90


"""
Although the name-mangled version can technically be accessed, this should
generally NOT be used to bypass the intended encapsulation.

The important idea is:

    __marks

signals:

    "This attribute is intended to be private to this class."


===============================================================================
8. WHY DO WE NEED ENCAPSULATION?
===============================================================================

Suppose we create a bank account without encapsulation:

"""


class BankAccount:

    def __init__(self, balance):
        self.balance = balance


account = BankAccount(10000)

account.balance = -50000

print(account.balance)
# Output: -50000


"""
This is a problem.

A bank account should not normally allow an invalid balance through arbitrary
direct modification.

We can solve this by controlling access to the balance.


===============================================================================
9. ENCAPSULATION USING PRIVATE ATTRIBUTE
===============================================================================

Example:
"""


class BankAccount:

    def __init__(self, balance):
        self.__balance = balance

    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount

    def withdraw(self, amount):
        if 0 < amount <= self.__balance:
            self.__balance -= amount

    def get_balance(self):
        return self.__balance


account = BankAccount(10000)

account.deposit(5000)
print(account.get_balance())
# Output: 15000

account.withdraw(3000)
print(account.get_balance())
# Output: 12000


"""
The important part is:

    __balance

The balance is kept private.

Outside code does not directly modify:

    account.__balance

Instead, it uses:

    deposit()
    withdraw()
    get_balance()

The class controls how the data is accessed and modified.

This is a practical example of encapsulation.


===============================================================================
10. ENCAPSULATION = DATA + METHODS
===============================================================================

A class groups related data and behavior together.

Example:

    BankAccount

    Data:
        __balance

    Methods:
        deposit()
        withdraw()
        get_balance()


Instead of having separate unrelated variables and functions, the class
contains both the state and the operations that work on that state.


===============================================================================
11. DATA HIDING
===============================================================================

Encapsulation is closely related to:

    Data Hiding

Data hiding means preventing or discouraging direct access to internal
implementation details.

Example:

"""


class User:

    def __init__(self, password):
        self.__password = password

    def change_password(self, old_password, new_password):

        if old_password == self.__password:
            self.__password = new_password
            print("Password changed successfully")
        else:
            print("Incorrect old password")

    def check_password(self, password):

        return password == self.__password


user = User("abc123")

print(user.check_password("abc123"))
# Output: True

user.change_password("abc123", "xyz789")
# Output: Password changed successfully

print(user.check_password("xyz789"))
# Output: True


"""
The password is not intended to be modified directly.

Instead:

    change_password()

controls how it is changed.

This prevents arbitrary modifications and allows validation.


===============================================================================
12. GETTER AND SETTER
===============================================================================

A common technique for encapsulation is using:

    Getter
        -> reads data

    Setter
        -> modifies data

Example:
"""


class Student:

    def __init__(self, name, marks):
        self.__name = name
        self.__marks = marks

    # Getter
    def get_name(self):
        return self.__name

    # Setter
    def set_name(self, name):
        self.__name = name

    # Getter
    def get_marks(self):
        return self.__marks

    # Setter
    def set_marks(self, marks):
        if 0 <= marks <= 100:
            self.__marks = marks
        else:
            print("Invalid marks")


student = Student("Alice", 85)

print(student.get_name())
# Output: Alice

print(student.get_marks())
# Output: 85

student.set_marks(95)

print(student.get_marks())
# Output: 95

student.set_marks(150)
# Output: Invalid marks

print(student.get_marks())
# Output: 95


"""
The setter provides validation.

Without encapsulation:

    student.marks = 150

could create an invalid state.

With a setter:

    set_marks(150)

the class can reject the invalid value.


===============================================================================
13. PROPERTY DECORATOR
===============================================================================

Python provides a more Pythonic way of creating getters and setters:

    @property

Instead of writing:

    get_marks()
    set_marks()

we can make the attribute behave like a normal attribute while still
controlling access.

Example:
"""


class Student:

    def __init__(self, marks):
        self.__marks = marks

    @property
    def marks(self):
        return self.__marks

    @marks.setter
    def marks(self, value):
        if 0 <= value <= 100:
            self.__marks = value
        else:
            print("Invalid marks")


student = Student(80)

print(student.marks)
# Output: 80

student.marks = 95

print(student.marks)
# Output: 95

student.marks = 150
# Output: Invalid marks

print(student.marks)
# Output: 95


"""
Notice the syntax:

    student.marks

instead of:

    student.get_marks()

and:

    student.marks = 95

instead of:

    student.set_marks(95)

The property still allows the class to control access internally.


===============================================================================
14. READ-ONLY PROPERTY
===============================================================================

A property can be made read-only by providing only the getter.

Example:
"""


class Employee:

    def __init__(self, name, salary):
        self.name = name
        self.__salary = salary

    @property
    def salary(self):
        return self.__salary


employee = Employee("Alice", 50000)

print(employee.salary)
# Output: 50000

# employee.salary = 70000
# AttributeError:
# property 'salary' of 'Employee' object has no setter


"""
The user can read:

    employee.salary

but cannot directly assign:

    employee.salary = 70000

because no setter was defined.

This is useful when a value should be controlled internally.


===============================================================================
15. WRITE VALIDATION USING SETTER
===============================================================================

One of the biggest advantages of encapsulation is validation.

Example:
"""


class Product:

    def __init__(self, price):
        self.price = price

    @property
    def price(self):
        return self.__price

    @price.setter
    def price(self, value):

        if value >= 0:
            self.__price = value
        else:
            print("Price cannot be negative")


product = Product(1000)

print(product.price)
# Output: 1000

product.price = 1500

print(product.price)
# Output: 1500

product.price = -500
# Output: Price cannot be negative

print(product.price)
# Output: 1500


"""
The setter acts as a validation layer.

Therefore:

    Data
      ↓
    Validation
      ↓
    Stored value


===============================================================================
16. ENCAPSULATION WITH METHODS
===============================================================================

Encapsulation does not mean that every attribute must be private.

The important idea is:

    Control how the object's state is accessed and changed.

Example:
"""


class Temperature:

    def __init__(self, celsius):
        self.__celsius = celsius

    def get_celsius(self):
        return self.__celsius

    def set_celsius(self, value):

        if value >= -273.15:
            self.__celsius = value
        else:
            print("Temperature cannot be below absolute zero")


temperature = Temperature(25)

print(temperature.get_celsius())
# Output: 25

temperature.set_celsius(30)

print(temperature.get_celsius())
# Output: 30

temperature.set_celsius(-300)
# Output: Temperature cannot be below absolute zero


"""
The class protects the object from entering an invalid state.


===============================================================================
17. ENCAPSULATION AND OBJECT STATE
===============================================================================

An object's state means the current values stored in its attributes.

Example:

    BankAccount

State:

    balance = 10000

Operations:

    deposit()
    withdraw()

Encapsulation helps ensure that the state remains valid.

For example:

    balance should not become invalid because of an arbitrary operation.


===============================================================================
18. WITHOUT ENCAPSULATION VS WITH ENCAPSULATION
===============================================================================

WITHOUT ENCAPSULATION
---------------------

"""


class AccountWithoutEncapsulation:

    def __init__(self, balance):
        self.balance = balance


account = AccountWithoutEncapsulation(10000)

account.balance = -5000

print(account.balance)
# Output: -5000


"""
The outside code can directly put the object into an invalid state.


WITH ENCAPSULATION
------------------
"""


class AccountWithEncapsulation:

    def __init__(self, balance):
        self.__balance = balance

    def deposit(self, amount):

        if amount > 0:
            self.__balance += amount

    def withdraw(self, amount):

        if 0 < amount <= self.__balance:
            self.__balance -= amount

    def get_balance(self):

        return self.__balance


account = AccountWithEncapsulation(10000)

account.deposit(5000)
account.withdraw(2000)

print(account.get_balance())
# Output: 13000


"""
The class controls the state transitions.

This is the key benefit of encapsulation.


===============================================================================
19. CLASS ATTRIBUTE AND ENCAPSULATION
===============================================================================

Encapsulation can also be applied to class-level data.

Example:
"""


class Employee:

    __company = "TechCorp"

    def __init__(self, name):
        self.name = name

    @classmethod
    def get_company(cls):
        return cls.__company


employee = Employee("Alice")

print(employee.get_company())
# Output: TechCorp


"""
The class attribute:

    __company

is private to the class through name mangling.

Access is provided through:

    get_company()


===============================================================================
20. PRIVATE METHOD
===============================================================================

Encapsulation can also be applied to methods.

A method beginning with double underscores is name-mangled.

Example:
"""


class Calculator:

    def __validate(self, number):
        return number >= 0

    def square_root_input(self, number):

        if self.__validate(number):
            print("Valid input")
        else:
            print("Invalid input")


calculator = Calculator()

calculator.square_root_input(25)
# Output: Valid input


"""
The helper method:

    __validate()

is intended for internal use.

The public method:

    square_root_input()

provides the external interface.


===============================================================================
21. PUBLIC METHOD + PRIVATE METHOD
===============================================================================

A useful design is:

    Public methods
        -> interface for outside code

    Private methods
        -> internal implementation details


Example:
"""


class Order:

    def place_order(self):
        if self.__validate_order():
            self.__process_payment()
            print("Order placed")

    def __validate_order(self):
        return True

    def __process_payment(self):
        print("Payment processed")


order = Order()

order.place_order()
# Output:
# Payment processed
# Order placed


"""
The user only needs:

    place_order()

The internal methods:

    __validate_order()
    __process_payment()

are implementation details.


===============================================================================
22. NAME MANGLING IN PRIVATE METHODS
===============================================================================

Just like private attributes, private methods are name-mangled.

Example:
"""


class Test:

    def __display(self):
        print("Private method")


test = Test()

# test.__display()
# AttributeError

test._Test__display()
# Output: Private method


"""
Again, this technical access should not normally be used.

Name mangling is mainly designed to avoid accidental access/name conflicts,
not to provide absolute security.


===============================================================================
23. ENCAPSULATION DOES NOT MEAN "MAKE EVERYTHING PRIVATE"
===============================================================================

A common misunderstanding is:

    Encapsulation = Make all variables private.

That is NOT correct.

Encapsulation means:

    "Design the class so that its internal state and behavior are controlled
     through an appropriate interface."

Some data may be public.

Some data may be protected by convention.

Some data may be private.

Some operations may be public.

Some helper operations may be private.


===============================================================================
24. PUBLIC, PROTECTED AND PRIVATE
===============================================================================

Python naming convention:

    name
        -> public

    _name
        -> protected by convention

    __name
        -> private/name-mangled


Example:
"""


class Example:

    def __init__(self):
        self.public_data = 10
        self._protected_data = 20
        self.__private_data = 30


example = Example()

print(example.public_data)
# Output: 10

print(example._protected_data)
# Output: 20

# print(example.__private_data)
# AttributeError


"""
Remember:

    public
        -> direct access is intended

    _protected
        -> access is discouraged outside the class/subclass

    __private
        -> name mangling is applied


===============================================================================
25. ENCAPSULATION WITH INHERITANCE
===============================================================================

Encapsulation is also important when inheritance is involved.

Example:
"""


class Parent:

    def __init__(self):
        self.__private_data = 100
        self._protected_data = 200


class Child(Parent):

    def display(self):

        print(self._protected_data)
        # Output: 200

        # print(self.__private_data)
        # AttributeError


child = Child()

child.display()


"""
The child class can access:

    _protected_data

because it is intended for use by subclasses.

But:

    __private_data

is name-mangled and is not directly available using the same name inside
the child class.


===============================================================================
26. ENCAPSULATION AND INHERITANCE: NAME MANGLING
===============================================================================

Parent:

    self.__data

becomes approximately:

    self._Parent__data

The child class's:

    self.__data

would become:

    self._Child__data

Therefore, private members are associated with the class that defines them.

This also helps prevent accidental name conflicts between parent and child
classes.


===============================================================================
27. ENCAPSULATION + ABSTRACTION
===============================================================================

These two OOP concepts are often confused.

ENCAPSULATION
-------------

Focus:

    Bundling data and methods together and controlling access to the data.


ABSTRACTION
-----------

Focus:

    Hiding unnecessary implementation details and exposing essential
    functionality.


Example:

    BankAccount

Encapsulation:

    __balance
    deposit()
    withdraw()

controls access to the account state.


Abstraction:

    User simply calls:

        withdraw(500)

without needing to understand every internal step involved in processing
the withdrawal.


Easy memory trick:

    Encapsulation
        -> HOW data is accessed/protected.

    Abstraction
        -> WHAT functionality is exposed.


===============================================================================
28. ENCAPSULATION + POLYMORPHISM
===============================================================================

Encapsulation can also work together with polymorphism.

Example:
"""


class Payment:

    def pay(self, amount):
        print("Processing payment:", amount)


class CardPayment(Payment):

    def pay(self, amount):
        print("Processing card payment:", amount)


class UpiPayment(Payment):

    def pay(self, amount):
        print("Processing UPI payment:", amount)


payments = [
    CardPayment(),
    UpiPayment()
]

for payment in payments:
    payment.pay(1000)

# Output:
# Processing card payment: 1000
# Processing UPI payment: 1000


"""
Each object controls its own internal implementation while exposing the
same public method:

    pay()

This demonstrates how encapsulation and polymorphism can work together.


===============================================================================
29. PRACTICAL EXAMPLE: BANK ACCOUNT
===============================================================================

This is one of the most important examples to understand encapsulation.

Requirements:

    - balance should not be directly modified
    - deposit amount must be positive
    - withdrawal amount must be positive
    - withdrawal cannot exceed balance
    - balance should be readable


class BankAccount:

    def __init__(self, owner, initial_balance=0):

        self.owner = owner
        self.__balance = initial_balance

    def deposit(self, amount):

        if amount <= 0:
            print("Deposit amount must be positive")
            return

        self.__balance += amount

        print("Deposit successful")

    def withdraw(self, amount):

        if amount <= 0:
            print("Withdrawal amount must be positive")
            return

        if amount > self.__balance:
            print("Insufficient balance")
            return

        self.__balance -= amount

        print("Withdrawal successful")

    def get_balance(self):

        return self.__balance


account = BankAccount("Alice", 10000)

print(account.get_balance())
# Output: 10000

account.deposit(5000)
# Output: Deposit successful

print(account.get_balance())
# Output: 15000

account.withdraw(3000)
# Output: Withdrawal successful

print(account.get_balance())
# Output: 12000

account.withdraw(20000)
# Output: Insufficient balance

print(account.get_balance())
# Output: 12000

Notice that:

    __balance

is controlled by:

    deposit()
    withdraw()
    get_balance()

The class maintains the validity of its internal state.


===============================================================================
30. PRACTICAL EXAMPLE: STUDENT MARKS
===============================================================================

Suppose marks must always remain between:

    0 and 100


Encapsulation can enforce this rule.


class Student:

    def __init__(self, name, marks):

        self.name = name
        self.__marks = 0

        self.set_marks(marks)

    def get_marks(self):

        return self.__marks

    def set_marks(self, marks):

        if 0 <= marks <= 100:
            self.__marks = marks
        else:
            print("Marks must be between 0 and 100")


student = Student("Alice", 85)

print(student.get_marks())
# Output: 85

student.set_marks(95)

print(student.get_marks())
# Output: 95

student.set_marks(120)
# Output: Marks must be between 0 and 100

print(student.get_marks())
# Output: 95

The class guarantees:

    0 <= marks <= 100

This is called maintaining an object's valid state.


===============================================================================
31. PRACTICAL EXAMPLE: EMPLOYEE SALARY
===============================================================================

Suppose salary cannot be negative.

"""


class Employee:

    def __init__(self, name, salary):

        self.name = name
        self.__salary = 0

        self.set_salary(salary)

    def get_salary(self):

        return self.__salary

    def set_salary(self, salary):

        if salary >= 0:
            self.__salary = salary
        else:
            print("Salary cannot be negative")


employee = Employee("Bob", 50000)

print(employee.get_salary())
# Output: 50000

employee.set_salary(60000)

print(employee.get_salary())
# Output: 60000

employee.set_salary(-10000)
# Output: Salary cannot be negative

print(employee.get_salary())
# Output: 60000

"""
===============================================================================
32. PYTHON'S ENCAPSULATION IS NOT ABSOLUTE SECURITY
===============================================================================

This is an important Python-specific point.

Python does not provide absolute private access control in the same way
some languages do.

For example:

    __balance

is name-mangled to something similar to:

    _BankAccount__balance

Therefore, technically, it can still be accessed.

Example:
"""


class Account:

    def __init__(self):
        self.__balance = 10000


account = Account()

print(account._Account__balance)
# Output: 10000


"""
However, this is generally considered bypassing the intended interface.

Python follows the philosophy:

    "We are all consenting adults here."

In other words, Python relies heavily on conventions and programmer
responsibility rather than absolute access restrictions.


===============================================================================
33. ENCAPSULATION WITH @PROPERTY — RECOMMENDED PYTHON STYLE
===============================================================================

For simple controlled attributes, @property is often more Pythonic than
explicit get/set methods.

Instead of:

    get_salary()
    set_salary()

we can write:

    employee.salary
    employee.salary = value


Example:
"""


class Employee:

    def __init__(self, salary):
        self.salary = salary

    @property
    def salary(self):
        return self.__salary

    @salary.setter
    def salary(self, value):

        if value >= 0:
            self.__salary = value
        else:
            raise ValueError("Salary cannot be negative")


employee = Employee(50000)

print(employee.salary)
# Output: 50000

employee.salary = 60000

print(employee.salary)
# Output: 60000


# employee.salary = -5000
# ValueError: Salary cannot be negative


"""
@property allows us to provide controlled access while maintaining natural
attribute syntax.


===============================================================================
34. WHY ENCAPSULATION IS IMPORTANT
===============================================================================

Encapsulation provides several advantages.


1. DATA PROTECTION
------------------

Internal data can be protected from arbitrary modification.


2. VALIDATION
-------------

The class can validate values before storing them.


3. CONTROLLED ACCESS
--------------------

The class decides how data can be read or modified.


4. MAINTAINABILITY
------------------

Internal implementation can change without requiring changes to outside
code.


5. REDUCED COMPLEXITY
---------------------

Users interact with a clean public interface instead of internal details.


6. BETTER CODE ORGANIZATION
---------------------------

Related data and operations remain together inside the class.


7. PREVENTS INVALID OBJECT STATE
--------------------------------

The class can enforce rules such as:

    balance >= 0
    marks between 0 and 100
    salary >= 0


===============================================================================
35. ENCAPSULATION AND MAINTAINABILITY
===============================================================================

Consider:

    account.balance

being directly modified everywhere in a large program.

If the business rule changes later, we would need to find and modify many
places.

With encapsulation:

    account.deposit()
    account.withdraw()

the rules remain inside the class.

Therefore, if the implementation changes, outside code can remain unchanged.


===============================================================================
36. COMPLETE ENCAPSULATION EXAMPLE
===============================================================================

This example combines:

    - public attribute
    - protected attribute
    - private attribute
    - private method
    - getter
    - setter
    - property
    - validation
    - object state


class BankAccount:

    bank_name = "ABC Bank"

    def __init__(self, owner, balance):

        self.owner = owner
        self._account_type = "Savings"
        self.__balance = 0

        self.balance = balance

    @property
    def balance(self):
        return self.__balance

    @balance.setter
    def balance(self, amount):

        if amount >= 0:
            self.__balance = amount
        else:
            print("Balance cannot be negative")

    def deposit(self, amount):

        if self.__validate_amount(amount):
            self.__balance += amount

    def withdraw(self, amount):

        if self.__validate_amount(amount) and amount <= self.__balance:
            self.__balance -= amount
        else:
            print("Invalid withdrawal")

    def __validate_amount(self, amount):

        return amount > 0


account = BankAccount("Alice", 10000)

print(account.owner)
# Output: Alice

print(account._account_type)
# Output: Savings

print(account.balance)
# Output: 10000

account.deposit(5000)

print(account.balance)
# Output: 15000

account.withdraw(3000)

print(account.balance)
# Output: 12000

Here:

    bank_name
        -> class attribute

    owner
        -> public instance attribute

    _account_type
        -> protected-by-convention instance attribute

    __balance
        -> private instance attribute

    __validate_amount()
        -> private helper method

    balance property
        -> controlled access to private balance

    deposit()
    withdraw()
        -> public operations


This is a strong example of encapsulation.


===============================================================================
37. IMPORTANT TERMINOLOGIES
===============================================================================

ENCAPSULATION
    Bundling data and methods together and controlling access to the
    object's internal state.

DATA HIDING
    Restricting or discouraging direct access to internal implementation
    details.

PUBLIC MEMBER
    A member intended to be directly accessible from outside the class.

PROTECTED MEMBER
    A member beginning with one underscore. It is protected by convention.

PRIVATE MEMBER
    A member beginning with two underscores. Python applies name mangling.

NAME MANGLING
    Python's mechanism for changing the internal name of double-underscore
    attributes/methods to reduce accidental conflicts.

GETTER
    A method/property used to read an internal value.

SETTER
    A method/property used to modify an internal value, often with
    validation.

PROPERTY
    A Python mechanism that allows methods to be accessed using attribute
    syntax.

OBJECT STATE
    The current values stored in an object's attributes.

INTERFACE
    The public operations through which outside code interacts with an
    object.


===============================================================================
38. PUBLIC vs PROTECTED vs PRIVATE
===============================================================================

    ┌──────────────────────┬──────────────────────────────┐
    │ Syntax               │ Meaning                     │
    ├──────────────────────┼──────────────────────────────┤
    │ name                 │ Public                      │
    │ _name                │ Protected by convention     │
    │ __name               │ Private / name-mangled      │
    └──────────────────────┴──────────────────────────────┘


Example:

    self.name
        -> public

    self._name
        -> protected convention

    self.__name
        -> private/name-mangled


===============================================================================
39. ENCAPSULATION VS ABSTRACTION
===============================================================================

ENCAPSULATION
-------------

Main focus:

    Protecting and controlling object state.

Example:

    __balance

    deposit()
    withdraw()

Question:

    "How should the object's data be accessed or changed?"


ABSTRACTION
-----------

Main focus:

    Hiding implementation complexity.

Example:

    pay()
    start()
    area()

Question:

    "What functionality should be exposed to the user?"


Easy way to remember:

    ENCAPSULATION
        -> Protect the data.

    ABSTRACTION
        -> Hide the complexity.


===============================================================================
40. ENCAPSULATION VS DATA HIDING
===============================================================================

These terms are related but not exactly identical.

Encapsulation means:

    Combining data and methods into a single unit and controlling access.

Data hiding means:

    Preventing or discouraging direct access to certain internal details.

Therefore:

    Data hiding
        -> one important part of encapsulation.


===============================================================================
41. ENCAPSULATION VS INHERITANCE
===============================================================================

Inheritance answers:

    "Can one class acquire properties and behavior from another class?"

Example:

    class Dog(Animal):
        ...


Encapsulation answers:

    "How should the class organize and protect its internal state?"

They solve different problems.


===============================================================================
42. ENCAPSULATION VS POLYMORPHISM
===============================================================================

Polymorphism means:

    Same interface
    +
    different implementations/behaviors

Example:

    payment.pay()

Encapsulation means:

    Controlling the internal state and implementation of the object.

Both can be used together in large object-oriented systems.


===============================================================================
43. COMMON MISCONCEPTIONS
===============================================================================

MISCONCEPTION 1:

    "Double underscore makes a variable completely inaccessible."

Not exactly.

Python uses name mangling rather than absolute private access control.


MISCONCEPTION 2:

    "_variable is private."

Not exactly.

A single underscore indicates protected/internal use by convention.


MISCONCEPTION 3:

    "Encapsulation means all variables must be private."

Incorrect.

Encapsulation is about controlled access and proper class design.


MISCONCEPTION 4:

    "Getter and setter methods are mandatory."

No.

Python's @property can often provide a cleaner alternative.


MISCONCEPTION 5:

    "Encapsulation is only about variables."

No.

Methods can also be encapsulated using private naming conventions.


===============================================================================
44. KEY POINTS
===============================================================================

1. Encapsulation is one of the four major OOP principles.

2. It combines data and methods inside a class.

3. It controls how the object's internal state is accessed and modified.

4. Python supports three common naming conventions:

       public
       _protected
       __private

5. Public members can be accessed directly.

6. Protected members use a single underscore and are protected by convention.

7. Private members use double underscores and undergo name mangling.

8. Python's private members are not absolutely inaccessible.

9. Name mangling helps prevent accidental access and naming conflicts.

10. Getters are used to read internal data.

11. Setters are used to modify internal data.

12. Setters can perform validation.

13. @property provides a Pythonic way to implement controlled attributes.

14. Encapsulation helps maintain valid object state.

15. Encapsulation improves maintainability.

16. Encapsulation reduces accidental modification of internal data.

17. Private helper methods can hide internal implementation details.

18. Encapsulation and abstraction are related but different.

19. Encapsulation focuses on:

       DATA + CONTROLLED ACCESS

20. Abstraction focuses on:

       ESSENTIAL FUNCTIONALITY + HIDDEN COMPLEXITY


===============================================================================
45. FINAL MEMORY TRICK
===============================================================================

Think of a BANK ACCOUNT:

                BankAccount
                     |
          +----------+----------+
          |                     |
       DATA                    METHODS
          |                     |
    __balance              deposit()
                           withdraw()
                           get_balance()
                               |
                               ↓
                       CONTROLLED ACCESS


The outside world should interact with the object through its intended
interface instead of directly manipulating sensitive internal state.

Therefore:

                    ENCAPSULATION
                         |
          +--------------+--------------+
          |                             |
      Bundle data                  Control access
      + methods                         |
          |                             |
          +--------------+--------------+
                         ↓
                Protect object state
                + maintain valid data


===============================================================================
                         ONE-LINE DEFINITION
===============================================================================

ENCAPSULATION:

"Encapsulation is the OOP principle of bundling data and the methods that
operate on that data into a class while controlling access to the object's
internal state."


===============================================================================
"""