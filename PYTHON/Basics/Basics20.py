# ============================================================
#                    FUNCTIONS IN PYTHON
# ============================================================
"""
A FUNCTION is a reusable block of code designed to perform
a specific task.

Instead of writing the same code multiple times, we can
define a function once and call it whenever required.

Example:

    def greet():
        print("Hello")

    greet()

Output:
    Hello


------------------------------------------------------------
WHY USE FUNCTIONS?
------------------------------------------------------------

1. Code reusability
2. Avoids code repetition
3. Makes programs easier to understand
4. Makes debugging easier
5. Makes large programs easier to maintain
6. Breaks a large problem into smaller tasks
7. Makes testing easier


------------------------------------------------------------
BASIC STRUCTURE
------------------------------------------------------------

    def function_name():
        statements

    function_name()


Important terms:

    def
        -> Keyword used to define a function.

    function_name
        -> Name given to the function.

    ()
        -> Parentheses used for parameters.

    :
        -> Marks the beginning of the function body.

    indentation
        -> Defines the function body.

    function call
        -> Executes the function.
"""


# ============================================================
# 1. DEFINING A FUNCTION
# ============================================================
"""
A function is defined using the 'def' keyword.
"""

def greet():
    print("Hello World")


# ============================================================
# 2. CALLING A FUNCTION
# ============================================================
"""
Defining a function does NOT execute it.

The function executes only when we CALL it.
"""

def greet():
    print("Hello World")


greet()

# Output:
# Hello World


# ============================================================
# 3. FUNCTION DEFINITION
# ============================================================
"""
The following part is called the FUNCTION DEFINITION:

    def greet():
        print("Hello World")

A function definition tells Python:

    - the function name
    - what the function does
    - what inputs it can accept
    - what output it can return
"""


# ============================================================
# 4. FUNCTION CALL
# ============================================================
"""
The following is a FUNCTION CALL:

    greet()

It tells Python to execute the function body.
"""

def greet():
    print("Hello")

greet()

# Output:
# Hello


# ============================================================
# 5. FUNCTION NAME
# ============================================================
"""
The name used to identify a function is called the
FUNCTION NAME.

Example:

    def calculate_sum():
        ...

Here:

    calculate_sum

is the function name.
"""

def calculate_sum():
    print(10 + 20)

calculate_sum()

# Output:
# 30


# ============================================================
# 6. PARAMETERS
# ============================================================
"""
PARAMETERS are variables written inside the parentheses
of a function definition.

Example:

    def greet(name):
        print(name)

Here:

    name

is a parameter.
"""

def greet(name):
    print("Hello", name)


greet("Rahul")

# Output:
# Hello Rahul


# ============================================================
# 7. ARGUMENTS
# ============================================================
"""
ARGUMENTS are the actual values supplied when calling
a function.

Example:

    greet("Rahul")

Here:

    "Rahul"

is an argument.

Comparison:

    def greet(name):
        ...
             ↑
          parameter

    greet("Rahul")
          ↑
       argument
"""


# ============================================================
# 8. PARAMETER VS ARGUMENT
# ============================================================
"""
PARAMETER:

    Variable defined in the function definition.

ARGUMENT:

    Actual value passed during the function call.

Example:

    def add(a, b):
        return a + b

    add(10, 20)

Here:

    a, b
        -> parameters

    10, 20
        -> arguments
"""


# ============================================================
# 9. FUNCTION WITH MULTIPLE PARAMETERS
# ============================================================

def add(a, b):
    print(a + b)


add(10, 20)

# Output:
# 30


# ============================================================
# 10. RETURN STATEMENT
# ============================================================
"""
The return statement sends a value back to the place
where the function was called.

Syntax:

    return value

Example:
"""

def add(a, b):
    return a + b


result = add(10, 20)

print(result)

# Output:
# 30


# ============================================================
# 11. RETURN VALUE
# ============================================================
"""
The value sent back by a function using return is called
the RETURN VALUE.

Example:

    def add(a, b):
        return a + b

    result = add(10, 20)

Here:

    30

is the return value.
"""


# ============================================================
# 12. PRINT VS RETURN
# ============================================================
"""
print():

    Displays something on the screen.

return:

    Sends a value back to the caller.

These are NOT the same thing.
"""

def add_print(a, b):
    print(a + b)


def add_return(a, b):
    return a + b


add_print(10, 20)
# Output: 30

result = add_return(10, 20)

print(result)
# Output: 30


# ============================================================
# 13. RETURN ALLOWS FURTHER CALCULATION
# ============================================================
"""
A returned value can be stored and used in another
calculation.
"""

def square(number):
    return number * number


result = square(5)

print(result + 10)

# Output:
# 35


# ============================================================
# 14. FUNCTION WITHOUT RETURN
# ============================================================
"""
If a function does not explicitly return a value,
Python automatically returns None.
"""

def greet():
    print("Hello")


result = greet()

print(result)

# Output:
# Hello
# None


# ============================================================
# 15. FUNCTION WITH NO PARAMETERS
# ============================================================
"""
A function does not necessarily need parameters.
"""

def welcome():
    print("Welcome to Python")


welcome()

# Output:
# Welcome to Python


# ============================================================
# 16. FUNCTION WITH PARAMETERS BUT NO RETURN
# ============================================================

def greet(name):
    print("Hello", name)


greet("Sushant")

# Output:
# Hello Sushant


# ============================================================
# 17. FUNCTION WITH PARAMETERS AND RETURN
# ============================================================
"""
This is one of the most commonly used forms.
"""

def multiply(a, b):
    return a * b


result = multiply(5, 4)

print(result)

# Output:
# 20


# ============================================================
# 18. DEFAULT PARAMETERS
# ============================================================
"""
A DEFAULT PARAMETER has a default value.

If the caller does not provide a value, the default value
is used.
"""

def greet(name="User"):
    print("Hello", name)


greet()

# Output:
# Hello User

greet("Rahul")

# Output:
# Hello Rahul


# ============================================================
# 19. POSITIONAL ARGUMENTS
# ============================================================
"""
Arguments passed according to their position are called
POSITIONAL ARGUMENTS.

Example:

    def student(name, age):
        ...

    student("Rahul", 22)

"Rahul" goes to name.
22 goes to age.
"""

def student(name, age):
    print("Name:", name)
    print("Age:", age)


student("Rahul", 22)

# Output:
# Name: Rahul
# Age: 22


# ============================================================
# 20. KEYWORD ARGUMENTS
# ============================================================
"""
Arguments can also be passed using parameter names.

These are called KEYWORD ARGUMENTS.
"""

def student(name, age):
    print("Name:", name)
    print("Age:", age)


student(age=22, name="Rahul")

# Output:
# Name: Rahul
# Age: 22


# ============================================================
# 21. POSITIONAL VS KEYWORD ARGUMENT
# ============================================================
"""
POSITIONAL:

    student("Rahul", 22)

KEYWORD:

    student(name="Rahul", age=22)

Keyword arguments allow us to specify which parameter
receives which value.
"""


# ============================================================
# 22. MIXING POSITIONAL AND KEYWORD ARGUMENTS
# ============================================================
"""
Positional arguments can be combined with keyword arguments.

However, positional arguments must come BEFORE keyword
arguments.
"""

def student(name, age, city):
    print(name, age, city)


student("Rahul", age=22, city="Kolkata")

# Output:
# Rahul 22 Kolkata


# ============================================================
# 23. *args
# ============================================================
"""
*args allows a function to accept a variable number of
POSITIONAL arguments.

The arguments are received inside a tuple.

Example:
"""

def add(*numbers):

    total = 0

    for number in numbers:
        total += number

    return total


print(add(10, 20))
# Output: 30

print(add(10, 20, 30))
# Output: 60

print(add(1, 2, 3, 4, 5))
# Output: 15


# ============================================================
# 24. **kwargs
# ============================================================
"""
**kwargs allows a function to accept a variable number of
KEYWORD arguments.

The arguments are received inside a dictionary.
"""

def student_info(**details):

    print(details)


student_info(
    name="Rahul",
    age=22,
    city="Kolkata"
)

# Output:
# {'name': 'Rahul', 'age': 22, 'city': 'Kolkata'}


# ============================================================
# 25. *args VS **kwargs
# ============================================================
"""
*args:

    Variable number of positional arguments.

    Stored as:
        tuple


**kwargs:

    Variable number of keyword arguments.

    Stored as:
        dictionary


Example:

    def function(*args, **kwargs):
        ...
"""


# ============================================================
# 26. LOCAL VARIABLE
# ============================================================
"""
A variable created inside a function is generally a
LOCAL VARIABLE.

It can normally be accessed only inside that function.
"""

def calculate():

    x = 10

    print(x)


calculate()

# Output:
# 10


# ============================================================
# 27. GLOBAL VARIABLE
# ============================================================
"""
A variable created outside a function is a GLOBAL VARIABLE.

It can be accessed from functions, provided it is in scope.
"""

x = 100


def display():
    print(x)


display()

# Output:
# 100


# ============================================================
# 28. LOCAL VS GLOBAL VARIABLE
# ============================================================
"""
LOCAL:

    Created inside a function.

GLOBAL:

    Created outside a function.
"""

x = 100


def test():

    x = 50

    print("Inside:", x)


test()

print("Outside:", x)

# Output:
# Inside: 50
# Outside: 100


# ============================================================
# 29. DOCSTRING
# ============================================================
"""
A DOCSTRING is a string written inside a function to
describe what the function does.

It is usually written immediately after the function
definition.
"""

def square(number):
    """
    Returns the square of a number.
    """
    return number * number


print(square(5))

# Output:
# 25


# ============================================================
# 30. ACCESSING A DOCSTRING
# ============================================================
"""
The __doc__ attribute can be used to access a function's
docstring.
"""

def greet():
    """
    Displays a greeting message.
    """
    print("Hello")


print(greet.__doc__)

# Output:
#
#     Displays a greeting message.


# ============================================================
# 31. FUNCTION SCOPE
# ============================================================
"""
SCOPE determines where a variable can be accessed.

A variable created inside a function generally belongs
to that function's local scope.
"""

def test():

    message = "Hello"

    print(message)


test()

# Output:
# Hello

# print(message)
# Output:
# NameError: name 'message' is not defined


# ============================================================
# 32. FUNCTION CALL STACK - BASIC IDEA
# ============================================================
"""
When a function is called, Python creates an execution
context for that function.

Example:

    add(10, 20)

Python executes the function and then returns to the
place where the function was called.

This mechanism is closely related to the CALL STACK.

Understanding function calls is very important for DSA,
recursion and debugging.
"""


# ============================================================
# 33. FUNCTION CALLING ANOTHER FUNCTION
# ============================================================

def square(number):
    return number * number


def calculate(number):
    result = square(number)
    return result + 10


print(calculate(5))

# Output:
# 35


# ============================================================
# 34. FUNCTION CAN RETURN MULTIPLE VALUES
# ============================================================
"""
Python can return multiple values.

Internally, Python packages them into a tuple.
"""

def calculate(a, b):
    return a + b, a - b, a * b


result = calculate(10, 5)

print(result)

# Output:
# (15, 5, 50)


# ============================================================
# 35. UNPACKING MULTIPLE RETURN VALUES
# ============================================================

def calculate(a, b):
    return a + b, a - b


addition, subtraction = calculate(10, 5)

print(addition)
# Output: 15

print(subtraction)
# Output: 5


# ============================================================
# 36. NESTED FUNCTION
# ============================================================
"""
A function defined inside another function is called a
NESTED FUNCTION.
"""

def outer():

    def inner():
        print("Inside inner function")

    inner()


outer()

# Output:
# Inside inner function


# ============================================================
# 37. LAMBDA FUNCTION
# ============================================================
"""
A lambda is a small anonymous function.

Syntax:

    lambda arguments: expression

Example:
"""

square = lambda x: x * x

print(square(5))

# Output:
# 25

"""
Lambda functions are useful for short, simple operations.
"""


# ============================================================
# 38. RECURSIVE FUNCTION
# ============================================================
"""
A function that calls itself is called a RECURSIVE FUNCTION.

Example:

    factorial(5)

The function keeps calling itself until a BASE CASE
is reached.

Recursion is an important topic in DSA.
"""

def countdown(n):

    if n == 0:
        return

    print(n)

    countdown(n - 1)


countdown(5)

# Output:
# 5
# 4
# 3
# 2
# 1


# ============================================================
# 39. BUILT-IN VS USER-DEFINED FUNCTIONS
# ============================================================
"""
BUILT-IN FUNCTIONS:

Functions already provided by Python.

Examples:

    print()
    len()
    type()
    range()
    input()
    max()
    min()
    sum()

USER-DEFINED FUNCTIONS:

Functions created by the programmer using def.
"""

print(len("Python"))
# Output: 6

print(max(10, 20, 30))
# Output: 30


def cube(number):
    return number ** 3


print(cube(3))
# Output: 27


# ============================================================
# 40. PRACTICAL EXAMPLE - CHECK EVEN OR ODD
# ============================================================

def check_even_odd(number):

    if number % 2 == 0:
        return "Even"

    return "Odd"


print(check_even_odd(10))
# Output: Even

print(check_even_odd(7))
# Output: Odd


# ============================================================
# 41. PRACTICAL EXAMPLE - FIND MAXIMUM
# ============================================================

def find_max(numbers):

    maximum = numbers[0]

    for number in numbers:

        if number > maximum:
            maximum = number

    return maximum


numbers = [10, 45, 23, 78, 12]

print(find_max(numbers))

# Output:
# 78


# ============================================================
# 42. PRACTICAL EXAMPLE - COUNT VOWELS
# ============================================================

def count_vowels(text):

    count = 0

    for character in text:

        if character in "aeiou":
            count += 1

    return count


print(count_vowels("programming"))

# Output:
# 3


# ============================================================
# 43. PRACTICAL EXAMPLE - FACTORIAL
# ============================================================

def factorial(number):

    result = 1

    for i in range(1, number + 1):
        result *= i

    return result


print(factorial(5))

# Output:
# 120


# ============================================================
# 44. PRACTICAL EXAMPLE - PRIME CHECK
# ============================================================

def is_prime(number):

    if number < 2:
        return False

    for i in range(2, number):

        if number % i == 0:
            return False

    return True


print(is_prime(17))
# Output: True

print(is_prime(20))
# Output: False


# ============================================================
#                    FUNCTION TERMINOLOGIES
# ============================================================
"""
Here are the most important terms:

------------------------------------------------------------
1. FUNCTION
------------------------------------------------------------
A reusable block of code designed to perform a particular
task.


------------------------------------------------------------
2. FUNCTION DEFINITION
------------------------------------------------------------
The code used to create a function.

Example:

    def add(a, b):
        return a + b


------------------------------------------------------------
3. def
------------------------------------------------------------
Python keyword used to define a function.

Example:

    def greet():
        ...


------------------------------------------------------------
4. FUNCTION NAME
------------------------------------------------------------
The identifier used to call the function.

Example:

    def calculate():
        ...

    calculate()

Here:

    calculate

is the function name.


------------------------------------------------------------
5. PARAMETER
------------------------------------------------------------
A variable defined inside the function's parentheses.

Example:

    def add(a, b):
        ...

Here:

    a and b

are parameters.


------------------------------------------------------------
6. ARGUMENT
------------------------------------------------------------
The actual value passed to a function during the function
call.

Example:

    add(10, 20)

Here:

    10 and 20

are arguments.


------------------------------------------------------------
7. FUNCTION CALL
------------------------------------------------------------
The statement used to execute a function.

Example:

    add(10, 20)


------------------------------------------------------------
8. RETURN STATEMENT
------------------------------------------------------------
Used to send a value back to the caller.

Example:

    return a + b


------------------------------------------------------------
9. RETURN VALUE
------------------------------------------------------------
The value returned by a function.

Example:

    result = add(10, 20)

Here:

    30

is the return value.


------------------------------------------------------------
10. LOCAL VARIABLE
------------------------------------------------------------
A variable created inside a function.


------------------------------------------------------------
11. GLOBAL VARIABLE
------------------------------------------------------------
A variable created outside a function.


------------------------------------------------------------
12. DEFAULT PARAMETER
------------------------------------------------------------
A parameter with a predefined value.

Example:

    def greet(name="User"):
        ...


------------------------------------------------------------
13. POSITIONAL ARGUMENT
------------------------------------------------------------
An argument assigned to a parameter based on its position.

Example:

    student("Rahul", 22)


------------------------------------------------------------
14. KEYWORD ARGUMENT
------------------------------------------------------------
An argument passed using the parameter name.

Example:

    student(name="Rahul", age=22)


------------------------------------------------------------
15. *args
------------------------------------------------------------
Allows a function to accept a variable number of positional
arguments.

Stored as a tuple.


------------------------------------------------------------
16. **kwargs
------------------------------------------------------------
Allows a function to accept a variable number of keyword
arguments.

Stored as a dictionary.


------------------------------------------------------------
17. DOCSTRING
------------------------------------------------------------
Documentation written inside a function.

Example:

    def add(a, b):
        """
        Returns the sum of two numbers.
        """
        return a + b


------------------------------------------------------------
18. SCOPE
------------------------------------------------------------
Defines where a variable can be accessed.

Examples:

    Local scope
    Global scope


------------------------------------------------------------
19. NESTED FUNCTION
------------------------------------------------------------
A function defined inside another function.


------------------------------------------------------------
20. RECURSIVE FUNCTION
------------------------------------------------------------
A function that calls itself.


------------------------------------------------------------
21. LAMBDA FUNCTION
------------------------------------------------------------
A small anonymous function created using lambda.


------------------------------------------------------------
22. BUILT-IN FUNCTION
------------------------------------------------------------
A function already provided by Python.

Examples:

    print()
    len()
    type()
    sum()
    max()
    min()


------------------------------------------------------------
23. USER-DEFINED FUNCTION
------------------------------------------------------------
A function created by the programmer using def.


------------------------------------------------------------
24. CALLER
------------------------------------------------------------
The code or function that calls another function.

Example:

    result = add(10, 20)

The code executing add() is the caller.


------------------------------------------------------------
25. CALLEE
------------------------------------------------------------
The function that is being called.

Example:

    result = add(10, 20)

Here:

    add()

is the callee.


------------------------------------------------------------
26. FUNCTION BODY
------------------------------------------------------------
The indented block of code inside a function.

Example:

    def greet():
        print("Hello")

Here:

    print("Hello")

is the function body.
"""


# ============================================================
#                  COMPLETE TERMINOLOGY EXAMPLE
# ============================================================
"""
Consider:

    def calculate_sum(a, b=10):
        result = a + b
        return result


    answer = calculate_sum(20)

Terminology:

    def
        -> Function-definition keyword

    calculate_sum
        -> Function name

    a
        -> Parameter

    b
        -> Parameter with default value

    10
        -> Default argument/value

    result
        -> Local variable

    return result
        -> Return statement

    calculate_sum(20)
        -> Function call

    20
        -> Positional argument

    answer
        -> Variable receiving the return value

    30
        -> Return value
"""


def calculate_sum(a, b=10):

    result = a + b

    return result


answer = calculate_sum(20)

print(answer)

# Output:
# 30


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. Functions are reusable blocks of code.

2. Use 'def' to define a function.

3. A function definition does not execute the function.

4. A function call executes the function.

5. Parameters are variables in the function definition.

6. Arguments are actual values passed during the call.

7. return sends a value back to the caller.

8. A function without an explicit return statement returns
   None.

9. print() displays a value; return sends a value back.

10. Parameters can have default values.

11. Arguments can be:
        - Positional
        - Keyword

12. *args stores variable positional arguments in a tuple.

13. **kwargs stores variable keyword arguments in a dictionary.

14. Variables inside a function generally have local scope.

15. Variables outside functions generally have global scope.

16. A function can call another function.

17. A function can return multiple values.

18. A function inside another function is called a nested
    function.

19. A function that calls itself is called a recursive function.

20. lambda creates a small anonymous function.

21. Python provides built-in functions such as:
        print()
        len()
        type()
        range()
        sum()

22. Functions are extremely important in DSA because they
    allow us to divide large problems into smaller,
    reusable pieces.

23. A useful mental model:

       DEFINE
          ↓
       FUNCTION
          ↓
       CALL
          ↓
       EXECUTE
          ↓
       RETURN VALUE
"""