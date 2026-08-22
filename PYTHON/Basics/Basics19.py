# ============================================================
#                     PASS STATEMENT
# ============================================================
"""
The pass statement is a NULL statement in Python.

It does NOTHING when executed.

It is mainly used as a placeholder when Python requires
a statement, but we do not want to write the actual code yet.

Syntax:

    pass

Unlike:

    break
        -> terminates the loop

    continue
        -> skips the current iteration

    pass
        -> does nothing and continues normal execution


IMPORTANT:

pass is NOT used to skip an iteration.

It simply tells Python:

    "Do nothing here for now."
"""


# ============================================================
# 1. BASIC EXAMPLE
# ============================================================
"""
Python does not allow an empty code block.

For example, this is invalid:

    if condition:
        # nothing

Python expects an indented statement.

We can use pass as a placeholder.
"""

if True:
    pass

print("Program continues")

# Output:
# Program continues


# ============================================================
# 2. pass IN IF STATEMENT
# ============================================================
"""
Suppose we have a condition, but we do not want to perform
any action when the condition is True.

We can use pass.
"""

age = 20

if age >= 18:
    pass

print("Program continues")

# Output:
# Program continues


# ============================================================
# 3. pass WITH if-else
# ============================================================
"""
pass can be used when one branch is intentionally left empty.
"""

number = 10

if number > 0:
    print("Positive")

else:
    pass

# Output:
# Positive


# ============================================================
# 4. pass IN A FOR LOOP
# ============================================================
"""
pass can be used when we want the loop to execute but
currently do not want to perform any operation.
"""

for i in range(5):
    pass

print("Loop completed")

# Output:
# Loop completed


# ============================================================
# 5. pass VS continue
# ============================================================
"""
These two statements are different.

pass:
    Does nothing and continues normally.

continue:
    Immediately skips the remaining statements of the
    current iteration and moves to the next iteration.
"""

for i in range(1, 6):

    if i == 3:
        pass

    print(i)

# Output:
# 1
# 2
# 3
# 4
# 5


for i in range(1, 6):

    if i == 3:
        continue

    print(i)

# Output:
# 1
# 2
# 4
# 5


# ============================================================
# 6. pass VS break
# ============================================================
"""
pass:
    Does NOT stop the loop.

break:
    Completely terminates the loop.
"""

for i in range(1, 6):

    if i == 3:
        pass

    print(i)

# Output:
# 1
# 2
# 3
# 4
# 5


for i in range(1, 6):

    if i == 3:
        break

    print(i)

# Output:
# 1
# 2


# ============================================================
# 7. pass AS A PLACEHOLDER
# ============================================================
"""
One of the most common uses of pass is to temporarily leave
a block empty while developing a program.

Suppose we know that we will implement this condition later.
"""

marks = 85

if marks >= 90:
    pass

elif marks >= 80:
    print("Grade A")

else:
    print("Grade B")

# Output:
# Grade A


# ============================================================
# 8. pass FOR FUTURE IMPLEMENTATION
# ============================================================
"""
While developing a program, we may know that a function or
class is required, but we have not implemented its logic yet.

pass allows us to create the structure without getting a
syntax error.
"""

def calculate_salary():
    pass

print("Function created")

# Output:
# Function created


# ============================================================
# 9. FUNCTION WITH pass
# ============================================================
"""
A function body cannot be completely empty.

This is invalid:

    def hello():
        # nothing

Using pass makes it valid.
"""

def hello():
    pass

hello()

print("Function executed")

# Output:
# Function executed


# ============================================================
# 10. FUNCTION PLACEHOLDER
# ============================================================
"""
This is useful during the early stage of development.

We can first create the required functions and implement
their logic later.
"""

def login():
    pass


def logout():
    pass


def register():
    pass


print("Functions are defined")

# Output:
# Functions are defined


# ============================================================
# 11. CLASS WITH pass
# ============================================================
"""
A class also requires an indented body.

If we have not yet decided what the class should contain,
pass can be used.
"""

class Student:
    pass


student = Student()

print(student)

# Output:
# <__main__.Student object at ...>


# ============================================================
# 12. EMPTY CLASS AS A PLACEHOLDER
# ============================================================
"""
During software development, we may define the structure
of a class first and implement its methods later.
"""

class Employee:
    pass

print("Employee class created")

# Output:
# Employee class created


# ============================================================
# 13. pass IN NESTED LOOPS
# ============================================================
"""
pass can also be used inside nested loops.
"""

for i in range(3):

    for j in range(3):

        if i == j:
            pass

        print(i, j)

# Output:
# 0 0
# 0 1
# 0 2
# 1 0
# 1 1
# 1 2
# 2 0
# 2 1
# 2 2


# ============================================================
# 14. pass IN EXCEPTION HANDLING
# ============================================================
"""
pass can be used when we intentionally want to ignore a
particular exception.

However, this should be used carefully because silently
ignoring errors can make debugging difficult.
"""

try:
    number = int("Python")

except ValueError:
    pass

print("Program continues")

# Output:
# Program continues


# ============================================================
# 15. pass WITH try-except
# ============================================================
"""
Sometimes an exception is expected and no action is required.

pass allows the program to continue.
"""

numbers = ["10", "20", "Python", "30"]

for value in numbers:

    try:
        number = int(value)
        print(number)

    except ValueError:
        pass

# Output:
# 10
# 20
# 30


# ============================================================
# 16. pass IN A LOOP WHEN SOME VALUES NEED NO ACTION
# ============================================================
"""
Suppose we want to process only negative numbers.

For positive numbers, we currently do nothing.

pass can represent that intentional empty branch.
"""

numbers = [10, -5, 20, -10, 30]

for number in numbers:

    if number < 0:
        print("Negative:", number)

    else:
        pass

# Output:
# Negative: -5
# Negative: -10


# ============================================================
# 17. pass WITH WHILE LOOP
# ============================================================
"""
pass can also be used inside a while loop.
"""

i = 1

while i <= 5:

    if i == 3:
        pass

    print(i)

    i += 1

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 18. pass DOES NOT SKIP THE REST OF THE LOOP
# ============================================================
"""
This is extremely important.

pass does NOT mean:

    "skip the current iteration"

It only means:

    "do nothing at this particular point"

The statements after pass still execute.
"""

for i in range(1, 5):

    if i == 2:
        pass

    print("Value:", i)

# Output:
# Value: 1
# Value: 2
# Value: 3
# Value: 4


# ============================================================
# 19. continue ACTUALLY SKIPS THE ITERATION
# ============================================================

for i in range(1, 5):

    if i == 2:
        continue

    print("Value:", i)

# Output:
# Value: 1
# Value: 3
# Value: 4


# ============================================================
# 20. THREE LOOP CONTROL STATEMENTS
# ============================================================
"""
Python provides three commonly discussed statements for
controlling loop execution:

------------------------------------------------------------
pass
------------------------------------------------------------
Does nothing.

------------------------------------------------------------
continue
------------------------------------------------------------
Skips the current iteration.

------------------------------------------------------------
break
------------------------------------------------------------
Terminates the loop.
"""

for i in range(1, 6):

    if i == 2:
        pass

    if i == 3:
        continue

    if i == 5:
        break

    print(i)

# Output:
# 1
# 2
# 4


# ============================================================
# 21. PASS IN ABSTRACT/INCOMPLETE CODE
# ============================================================
"""
When learning or designing a program, we may first create
the structure and implement the logic later.
"""

def add_student():
    pass


def delete_student():
    pass


def update_student():
    pass


def display_student():
    pass


print("Student management structure created")

# Output:
# Student management structure created


# ============================================================
# 22. PRACTICAL USE CASE - DEVELOPMENT PLACEHOLDER
# ============================================================
"""
Suppose we are creating a calculator.

We have implemented addition and subtraction, but multiplication
and division will be implemented later.
"""

def add(a, b):
    return a + b


def subtract(a, b):
    return a - b


def multiply(a, b):
    pass


def divide(a, b):
    pass


print(add(10, 20))
# Output: 30

print(subtract(20, 10))
# Output: 10


# ============================================================
# 23. PRACTICAL USE CASE - CLASS DEVELOPMENT
# ============================================================
"""
We can define classes before implementing their complete
functionality.
"""

class BankAccount:

    pass


account = BankAccount()

print("BankAccount class created")

# Output:
# BankAccount class created


# ============================================================
# 24. PRACTICAL USE CASE - CONDITIONAL PLACEHOLDER
# ============================================================
"""
Suppose a condition is identified but no action is required
yet.

pass can make the intention explicit.
"""

temperature = 25

if temperature > 40:
    print("Very hot")

elif temperature < 10:
    pass

else:
    print("Normal temperature")

# Output:
# Normal temperature


# ============================================================
# 25. SHOULD WE ALWAYS USE pass?
# ============================================================
"""
No.

If a block genuinely requires no action and there is another
way to structure the code clearly, pass may not be necessary.

For example:

    if condition:
        pass

may simply mean that nothing needs to happen.

However, pass is useful when Python requires a syntactically
valid statement or when we intentionally want to leave a
section for future implementation.
"""


# ============================================================
#                       KEY POINTS
# ============================================================
"""
1. pass is a NULL statement.

2. pass does NOTHING when executed.

3. pass is mainly used as a placeholder.

4. pass is useful when Python requires an indented statement
   but we do not want to perform any operation.

5. pass can be used inside:

       - if
       - else
       - for
       - while
       - functions
       - classes
       - try/except
       - nested blocks

6. pass does NOT terminate a loop.

7. pass does NOT skip an iteration.

8. continue skips the current iteration.

9. break terminates the loop.

10. Important difference:

       pass
           -> Do nothing

       continue
           -> Skip current iteration

       break
           -> Stop the loop

11. Common use cases:

       - Placeholder during development
       - Empty function body
       - Empty class body
       - Future implementation
       - Intentionally empty condition
       - Ignoring a specific expected exception

12. pass is particularly useful when designing the structure
    of a program before implementing all of its logic.


------------------------------------------------------------
                QUICK MEMORY TRICK
------------------------------------------------------------

pass      -> "Do nothing here."

continue  -> "Skip this iteration."

break     -> "Stop the loop."
------------------------------------------------------------
"""