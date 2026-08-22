# ============================================================
#                  DEFAULT PARAMETERS
# ============================================================
"""
A DEFAULT PARAMETER is a parameter that already has a value
assigned to it in the function definition.

If the caller does not provide a value for that parameter,
Python uses the default value.

Syntax:

    def function_name(parameter=default_value):
        statements


Example:

    def greet(name="User"):
        print("Hello", name)


    greet()

Output:
    Hello User


    greet("Rahul")

Output:
    Hello Rahul


IMPORTANT:
If an argument is provided, the provided value replaces the
default value.
"""


# ============================================================
# 1. BASIC EXAMPLE
# ============================================================

def greet(name="User"):
    print("Hello", name)


greet()

# Output:
# Hello User


greet("Rahul")

# Output:
# Hello Rahul


# ============================================================
# 2. HOW DEFAULT PARAMETERS WORK
# ============================================================
"""
When we call:

    greet()

Python uses:

    name = "User"

When we call:

    greet("Rahul")

Python uses:

    name = "Rahul"

So:

    No argument  -> Default value is used
    Argument     -> Given value is used
"""


# ============================================================
# 3. DEFAULT PARAMETER WITH INTEGER
# ============================================================

def power(number, exponent=2):
    return number ** exponent


print(power(5))

# Output:
# 25


print(power(5, 3))

# Output:
# 125


# ============================================================
# 4. DEFAULT PARAMETER WITH FLOAT
# ============================================================

def calculate_price(price, tax=0.18):
    return price + (price * tax)


print(calculate_price(1000))

# Output:
# 1180.0


print(calculate_price(1000, 0.10))

# Output:
# 1100.0


# ============================================================
# 5. MULTIPLE DEFAULT PARAMETERS
# ============================================================
"""
A function can have multiple default parameters.
"""

def student(name="Unknown", age=0, city="Unknown"):
    print("Name:", name)
    print("Age:", age)
    print("City:", city)


student()

# Output:
# Name: Unknown
# Age: 0
# City: Unknown


student("Rahul", 22, "Kolkata")

# Output:
# Name: Rahul
# Age: 22
# City: Kolkata


# ============================================================
# 6. SOME PARAMETERS WITH DEFAULT VALUES
# ============================================================
"""
A function can have both:

    - Required parameters
    - Default parameters

Example:

    name -> required
    age  -> default
"""

def student(name, age=18):
    print("Name:", name)
    print("Age:", age)


student("Rahul")

# Output:
# Name: Rahul
# Age: 18


student("Rahul", 22)

# Output:
# Name: Rahul
# Age: 22


# ============================================================
# 7. IMPORTANT RULE
# ============================================================
"""
A NON-DEFAULT parameter cannot come after a DEFAULT parameter.

WRONG:

    def student(age=18, name):
        ...

This causes:

    SyntaxError: non-default argument follows default argument


Correct:

    def student(name, age=18):
        ...
"""

def student(name, age=18):
    print(name, age)


student("Rahul")

# Output:
# Rahul 18


# ============================================================
# 8. DEFAULT PARAMETERS WITH KEYWORD ARGUMENTS
# ============================================================

def student(name, age=18, city="Kolkata"):
    print(name, age, city)


student(name="Rahul")

# Output:
# Rahul 18 Kolkata


student(name="Rahul", age=22)

# Output:
# Rahul 22 Kolkata


student(name="Rahul", city="Delhi")

# Output:
# Rahul 18 Delhi


# ============================================================
# 9. PRACTICAL EXAMPLE - CALCULATOR
# ============================================================
"""
Suppose we want to calculate power.

If the user does not specify the exponent, we assume
the exponent is 2.
"""

def calculate_power(number, exponent=2):
    return number ** exponent


print(calculate_power(4))

# Output:
# 16


print(calculate_power(4, 3))

# Output:
# 64


# ============================================================
# 10. PRACTICAL EXAMPLE - GREETING
# ============================================================

def greet(name="User"):
    print("Welcome,", name)


greet()

# Output:
# Welcome, User


greet("Rahul")

# Output:
# Welcome, Rahul


# ============================================================
# 11. PRACTICAL EXAMPLE - DISCOUNT
# ============================================================
"""
Assume the default discount is 10%.

The caller can provide another discount if required.
"""

def final_price(price, discount=10):

    discount_amount = price * discount / 100

    return price - discount_amount


print(final_price(1000))

# Output:
# 900.0


print(final_price(1000, 20))

# Output:
# 800.0


# ============================================================
# 12. PRACTICAL EXAMPLE - LIST FUNCTION
# ============================================================
"""
The default parameter can also be a list.

However, using mutable objects such as lists as default
parameters requires extra care.

For beginners, prefer immutable defaults such as:

    None
    int
    float
    string
    tuple
"""

def display_items(items=None):

    if items is None:
        items = []

    print(items)


display_items()

# Output:
# []


display_items([10, 20, 30])

# Output:
# [10, 20, 30]


# ============================================================
# 13. DEFAULT PARAMETER WITH LIST - IMPORTANT
# ============================================================
"""
Avoid writing:

    def add_item(item, items=[]):

because the same list can be reused across function calls.

A safer pattern is:

    def add_item(item, items=None):

        if items is None:
            items = []

        items.append(item)

        return items
"""

def add_item(item, items=None):

    if items is None:
        items = []

    items.append(item)

    return items


print(add_item(10))

# Output:
# [10]


print(add_item(20))

# Output:
# [20]


# ============================================================
# 14. DEFAULT PARAMETER VS ARGUMENT
# ============================================================
"""
PARAMETER:

    Variable written in the function definition.

ARGUMENT:

    Actual value passed during the function call.

Example:

    def greet(name="User"):
        ...

Here:

    name = parameter
    "User" = default value


    greet("Rahul")

Here:

    "Rahul" = argument
"""


# ============================================================
# 15. DEFAULT VALUE IS USED ONLY WHEN ARGUMENT IS MISSING
# ============================================================

def show_value(value=100):
    print(value)


show_value()

# Output:
# 100


show_value(500)

# Output:
# 500


# ============================================================
# 16. DEFAULT VALUE CAN BE OVERRIDDEN
# ============================================================
"""
The default value is not permanent.

It can be overridden by passing another value.
"""

def calculate_bill(amount, tax=5):

    return amount + amount * tax / 100


print(calculate_bill(1000))

# Output:
# 1050.0


print(calculate_bill(1000, 18))

# Output:
# 1180.0


# ============================================================
# 17. PRACTICE QUESTION 1
# ============================================================
"""
QUESTION:

Write a function that calculates the area of a rectangle.

Requirements:

    length -> required parameter
    width  -> default value = 10
"""

def rectangle_area(length, width=10):

    return length * width


print(rectangle_area(5))

# Output:
# 50


print(rectangle_area(5, 20))

# Output:
# 100


"""
EXPLANATION:

    rectangle_area(5)

means:

    length = 5
    width = 10

Therefore:

    5 * 10 = 50


    rectangle_area(5, 20)

means:

    length = 5
    width = 20

Therefore:

    5 * 20 = 100
"""


# ============================================================
# 18. PRACTICE QUESTION 2
# ============================================================
"""
QUESTION:

Write a function that calculates the final price of
a product.

Use:

    discount = 10%

as the default discount.
"""

def final_price(price, discount=10):

    discount_amount = price * discount / 100

    return price - discount_amount


print(final_price(2000))

# Output:
# 1800.0


print(final_price(2000, 25))

# Output:
# 1500.0


"""
EXPLANATION:

First call:

    final_price(2000)

Default discount:

    10%

Discount:

    2000 * 10 / 100
    = 200

Final price:

    2000 - 200
    = 1800


Second call:

    final_price(2000, 25)

The default value is replaced.

Discount:

    2000 * 25 / 100
    = 500

Final price:

    2000 - 500
    = 1500
"""


# ============================================================
# 19. PRACTICE QUESTION 3
# ============================================================
"""
QUESTION:

Write a function that prints student information.

Use:

    city = "Kolkata"

as the default value.
"""

def student_info(name, age, city="Kolkata"):

    print("Name:", name)
    print("Age:", age)
    print("City:", city)


student_info("Rahul", 22)

# Output:
# Name: Rahul
# Age: 22
# City: Kolkata


student_info("Rahul", 22, "Delhi")

# Output:
# Name: Rahul
# Age: 22
# City: Delhi


# ============================================================
# 20. PRACTICE QUESTION 4
# ============================================================
"""
QUESTION:

Write a function to calculate simple interest.

Formula:

    SI = (P * R * T) / 100

Use:

    rate = 5
    time = 1

as default values.
"""

def simple_interest(principal, rate=5, time=1):

    return (principal * rate * time) / 100


print(simple_interest(10000))

# Output:
# 500.0


print(simple_interest(10000, 8, 2))

# Output:
# 1600.0


# ============================================================
# 21. PRACTICE QUESTION 5
# ============================================================
"""
QUESTION:

Write a function that calculates the total amount.

Use:

    tax = 18%

as the default tax.
"""

def total_amount(price, tax=18):

    tax_amount = price * tax / 100

    return price + tax_amount


print(total_amount(1000))

# Output:
# 1180.0


print(total_amount(1000, 5))

# Output:
# 1050.0


# ============================================================
# 22. PRACTICE QUESTION 6 - LIST
# ============================================================
"""
QUESTION:

Write a function that accepts a list and prints its length.

The list should be the parameter.

Example:

    [10, 20, 30, 40]

Expected output:

    4
"""

def list_length(numbers):

    return len(numbers)


numbers = [10, 20, 30, 40]

print(list_length(numbers))

# Output:
# 4


# ============================================================
# 23. PRACTICE QUESTION 7 - LIST ELEMENTS
# ============================================================
"""
QUESTION:

Write a function that prints all elements of a list
in a single line.
"""

def print_list(numbers):

    for number in numbers:
        print(number, end=" ")


numbers = [10, 20, 30, 40, 50]

print_list(numbers)

# Output:
# 10 20 30 40 50


# ============================================================
# 24. PRACTICE QUESTION 8 - FACTORIAL
# ============================================================
"""
QUESTION:

Write a function to calculate the factorial of n.

n should be the parameter.
"""

def factorial(n):

    result = 1

    for i in range(1, n + 1):
        result *= i

    return result


print(factorial(5))

# Output:
# 120


# ============================================================
# 25. PRACTICE QUESTION 9 - USD TO INR
# ============================================================
"""
QUESTION:

Write a function to convert USD to INR.

Use a default conversion rate.

For practice, assume:

    1 USD = 85 INR

The rate should be changeable by the caller.
"""

def usd_to_inr(usd, rate=85):

    return usd * rate


print(usd_to_inr(10))

# Output:
# 850


print(usd_to_inr(10, 90))

# Output:
# 900


# ============================================================
# 26. PRACTICE QUESTION 10 - EVEN/ODD
# ============================================================
"""
QUESTION:

Write a function to check whether a number is even or odd.

Use a default number of 0.
"""

def check_even_odd(number=0):

    if number % 2 == 0:
        return "Even"

    return "Odd"


print(check_even_odd())

# Output:
# Even


print(check_even_odd(7))

# Output:
# Odd


# ============================================================
#                    KEY POINTS
# ============================================================
"""
1. A default parameter has a predefined value.

2. Default parameters are written in the function definition.

3. Example:

       def greet(name="User"):
           ...

4. If the argument is missing, the default value is used.

5. If an argument is supplied, it overrides the default value.

6. Example:

       greet()
       -> User

       greet("Rahul")
       -> Rahul

7. Required parameters should come before default parameters.

   Correct:

       def student(name, age=18):
           ...

   Incorrect:

       def student(age=18, name):
           ...

8. A function can have multiple default parameters.

9. Default parameters work with positional and keyword
   arguments.

10. Be careful when using mutable objects such as lists and
    dictionaries as default parameters.

11. A safer approach for mutable defaults is:

       def function(data=None):

           if data is None:
               data = []

12. Default parameters are useful when a value is commonly
    used but the programmer still wants the option to change it.

13. Common practical uses:

       - Tax rate
       - Discount rate
       - Conversion rate
       - City
       - Age
       - Quantity
       - Configuration values
       - Optional settings


------------------------------------------------------------
QUICK MEMORY TRICK
------------------------------------------------------------

Default parameter:

    "If you don't give me a value,
     I will use this value."

Example:

    def greet(name="User"):
        ...

    greet()
        ↓
    "User"

    greet("Rahul")
        ↓
    "Rahul"
------------------------------------------------------------
"""