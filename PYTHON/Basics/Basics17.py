# ============================================================
#                    FOR LOOP IN PYTHON
# ============================================================
"""
A for loop is used to repeatedly execute a block of code
for each item in an iterable.

An iterable is an object whose elements can be accessed
one by one.

Common iterables:
    - list
    - tuple
    - string
    - set
    - dictionary
    - range()

General syntax:

    for variable in iterable:
        statements

Example:

    for i in range(5):
        print(i)

Output:
    0
    1
    2
    3
    4

Important:
range(5) generates numbers from 0 to 4.
The ending value 5 is NOT included.
"""


# ============================================================
# 1. BASIC FOR LOOP
# ============================================================

for i in range(5):
    print(i)

# Output:
# 0
# 1
# 2
# 3
# 4


# ============================================================
# 2. FOR LOOP WITH RANGE(start, stop)
# ============================================================
"""
range(start, stop)

start -> included
stop  -> excluded
"""

for i in range(1, 6):
    print(i)

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 3. FOR LOOP WITH RANGE(start, stop, step)
# ============================================================
"""
range(start, stop, step)

step determines how much the value changes after every
iteration.
"""

for i in range(1, 11, 2):
    print(i)

# Output:
# 1
# 3
# 5
# 7
# 9


# ============================================================
# 4. COUNTING BACKWARD
# ============================================================
"""
A negative step can be used to count backward.
"""

for i in range(10, 0, -1):
    print(i)

# Output:
# 10
# 9
# 8
# 7
# 6
# 5
# 4
# 3
# 2
# 1


# ============================================================
# 5. ITERATING THROUGH A LIST
# ============================================================
"""
A for loop can directly iterate over the elements of a list.
"""

numbers = [10, 20, 30, 40, 50]

for number in numbers:
    print(number)

# Output:
# 10
# 20
# 30
# 40
# 50


# ============================================================
# 6. ITERATING THROUGH A TUPLE
# ============================================================

numbers = (10, 20, 30)

for number in numbers:
    print(number)

# Output:
# 10
# 20
# 30


# ============================================================
# 7. ITERATING THROUGH A STRING
# ============================================================
"""
A string is a sequence of characters, so we can process
one character at a time.
"""

text = "Python"

for character in text:
    print(character)

# Output:
# P
# y
# t
# h
# o
# n


# ============================================================
# 8. USING INDEX WITH A FOR LOOP
# ============================================================
"""
If we need the index as well as the value, range(len(list))
can be used.
"""

numbers = [10, 20, 30, 40]

for i in range(len(numbers)):
    print(i, numbers[i])

# Output:
# 0 10
# 1 20
# 2 30
# 3 40


# ============================================================
# 9. ENUMERATE()
# ============================================================
"""
enumerate() is generally cleaner when both index and value
are required.
"""

numbers = [10, 20, 30, 40]

for index, value in enumerate(numbers):
    print(index, value)

# Output:
# 0 10
# 1 20
# 2 30
# 3 40


# ============================================================
# 10. ENUMERATE() WITH CUSTOM START
# ============================================================

names = ["Alice", "Bob", "Charlie"]

for index, name in enumerate(names, start=1):
    print(index, name)

# Output:
# 1 Alice
# 2 Bob
# 3 Charlie


# ============================================================
# 11. NESTED FOR LOOP
# ============================================================
"""
A loop inside another loop is called a nested loop.

For every iteration of the outer loop, the complete inner
loop executes.
"""

for i in range(1, 4):

    for j in range(1, 4):
        print(i, j)

# Output:
# 1 1
# 1 2
# 1 3
# 2 1
# 2 2
# 2 3
# 3 1
# 3 2
# 3 3


# ============================================================
# 12. NESTED LOOP - MULTIPLICATION TABLE
# ============================================================

for i in range(1, 4):

    for j in range(1, 11):
        print(i, "x", j, "=", i * j)

# Output:
# 1 x 1 = 1
# 1 x 2 = 2
# ...
# 3 x 10 = 30


# ============================================================
#                  FOR-ELSE
# ============================================================
"""
Python allows an else block with a for loop.

The else block executes when the for loop finishes
NORMALLY.

If the loop terminates using break, the else block does
NOT execute.

Syntax:

    for variable in iterable:
        statements

    else:
        statements

The else is associated with the loop, NOT with an if
statement inside the loop.
"""


# ============================================================
# 13. SIMPLE FOR-ELSE
# ============================================================

for i in range(5):
    print(i)

else:
    print("Loop completed")

# Output:
# 0
# 1
# 2
# 3
# 4
# Loop completed


# ============================================================
# 14. FOR-ELSE WITH BREAK
# ============================================================
"""
If break executes, the loop does not finish normally.

Therefore, the else block is skipped.
"""

for i in range(1, 6):

    if i == 3:
        break

    print(i)

else:
    print("Loop completed")

# Output:
# 1
# 2


# ============================================================
# 15. FOR-ELSE FOR SEARCHING
# ============================================================
"""
This is one of the most useful applications of for-else.

If the element is found:
    break executes
    else does not execute

If the element is not found:
    loop finishes normally
    else executes
"""

numbers = [10, 20, 30, 40, 50]

target = 30

for number in numbers:

    if number == target:
        print("Element found")
        break

else:
    print("Element not found")

# Output:
# Element found


# ============================================================
# 16. FOR-ELSE WHEN ELEMENT IS NOT FOUND
# ============================================================

numbers = [10, 20, 30, 40, 50]

target = 100

for number in numbers:

    if number == target:
        print("Element found")
        break

else:
    print("Element not found")

# Output:
# Element not found


# ============================================================
# 17. PRACTICAL EXAMPLE - PRIME NUMBER
# ============================================================
"""
A number is prime if it has no divisor other than 1
and itself.

The for-else structure is very useful here.

If a divisor is found:
    break

If the loop finishes without break:
    number is prime
"""

number = 17

if number < 2:
    print("Not Prime")

else:

    for i in range(2, number):

        if number % i == 0:
            print("Not Prime")
            break

    else:
        print("Prime")

# Output:
# Prime


# ============================================================
# 18. PRACTICAL EXAMPLE - FIND FIRST EVEN NUMBER
# ============================================================

numbers = [11, 13, 15, 18, 21, 25]

for number in numbers:

    if number % 2 == 0:
        print("First even number:", number)
        break

else:
    print("No even number found")

# Output:
# First even number: 18


# ============================================================
# 19. PRACTICAL EXAMPLE - CHECK WHETHER ALL NUMBERS
#    ARE POSITIVE
# ============================================================

numbers = [10, 20, 30, -5, 40]

for number in numbers:

    if number < 0:
        print("Negative number found")
        break

else:
    print("All numbers are positive")

# Output:
# Negative number found


# ============================================================
# 20. FOR LOOP WITH IF-ELSE
# ============================================================
"""
Do not confuse:

    for ... else

with:

    for ... if ... else

The following else belongs to the if statement.
"""

numbers = [1, 2, 3, 4, 5]

for number in numbers:

    if number % 2 == 0:
        print(number, "is even")

    else:
        print(number, "is odd")

# Output:
# 1 is odd
# 2 is even
# 3 is odd
# 4 is even
# 5 is odd


# ============================================================
#            ACHIEVING DO-WHILE LOOP IN PYTHON
# ============================================================
"""
Python does NOT have a built-in do-while loop.

Languages such as C, C++ and Java provide:

    do {
        statements;
    } while (condition);

The important property of a do-while loop is:

    The body executes AT LEAST ONCE.

Python's while loop checks the condition BEFORE executing
the body.

Therefore, we can use:

    while True:
        statements

        if condition:
            break

This guarantees that the body executes at least once.
"""


# ============================================================
# 21. BASIC DO-WHILE EQUIVALENT
# ============================================================

while True:

    number = int(input("Enter a positive number: "))

    if number > 0:
        break

print("Valid number:", number)

"""
Example:

Input:
-5
0
10

Output:
Valid number: 10
"""


# ============================================================
# 22. DO-WHILE STYLE MENU
# ============================================================
"""
This is a common real-world use of the do-while pattern.

The menu is displayed at least once.
The loop continues until the user selects Exit.
"""

while True:

    print("\n1. Add")
    print("2. Subtract")
    print("3. Exit")

    choice = int(input("Enter choice: "))

    if choice == 1:
        print("Addition selected")

    elif choice == 2:
        print("Subtraction selected")

    elif choice == 3:
        print("Exiting...")
        break

    else:
        print("Invalid choice")

"""
Example:

1. Add
2. Subtract
3. Exit
Enter choice: 1
Addition selected

1. Add
2. Subtract
3. Exit
Enter choice: 3
Exiting...
"""


# ============================================================
# 23. DO-WHILE STYLE - ASK UNTIL VALID INPUT
# ============================================================

while True:

    age = int(input("Enter age between 1 and 100: "))

    if 1 <= age <= 100:
        break

    print("Invalid age")

print("Age:", age)

"""
Example:

Enter age between 1 and 100: 150
Invalid age
Enter age between 1 and 100: 25

Output:
Age: 25
"""


# ============================================================
# 24. DO-WHILE STYLE - PASSWORD
# ============================================================

correct_password = "python123"

while True:

    password = input("Enter password: ")

    if password == correct_password:
        break

    print("Incorrect password")

print("Login successful")

"""
The user is asked for the password at least once.

The loop continues until the correct password is entered.
"""


# ============================================================
# 25. DO-WHILE STYLE WITH COUNTER
# ============================================================
"""
Sometimes we want the operation to happen at least once,
but only allow a limited number of repetitions.
"""

attempts = 0

while True:

    attempts += 1

    password = input("Enter password: ")

    if password == "python123":
        print("Login successful")
        break

    if attempts == 3:
        print("Maximum attempts reached")
        break

    print("Incorrect password")

"""
The loop executes at least once and stops when either:

    1. Correct password is entered
    2. Three attempts are completed
"""


# ============================================================
#              PRACTICAL FOR LOOP EXAMPLES
# ============================================================


# ============================================================
# 26. SUM OF NUMBERS
# ============================================================

numbers = [10, 20, 30, 40, 50]

total = 0

for number in numbers:
    total += number

print("Sum:", total)

# Output:
# Sum: 150


# ============================================================
# 27. FIND MAXIMUM NUMBER
# ============================================================

numbers = [10, 45, 23, 78, 12]

maximum = numbers[0]

for number in numbers:

    if number > maximum:
        maximum = number

print("Maximum:", maximum)

# Output:
# Maximum: 78


# ============================================================
# 28. FIND MINIMUM NUMBER
# ============================================================

numbers = [10, 45, 23, 78, 12]

minimum = numbers[0]

for number in numbers:

    if number < minimum:
        minimum = number

print("Minimum:", minimum)

# Output:
# Minimum: 10


# ============================================================
# 29. COUNT EVEN AND ODD NUMBERS
# ============================================================

numbers = [10, 15, 20, 25, 30, 35]

even_count = 0
odd_count = 0

for number in numbers:

    if number % 2 == 0:
        even_count += 1

    else:
        odd_count += 1

print("Even:", even_count)
print("Odd:", odd_count)

# Output:
# Even: 3
# Odd: 3


# ============================================================
# 30. REVERSE A STRING
# ============================================================

text = "Python"

reverse = ""

for character in text:
    reverse = character + reverse

print("Reverse:", reverse)

# Output:
# Reverse: nohtyP


# ============================================================
# 31. COUNT VOWELS
# ============================================================

text = "programming"

count = 0

for character in text:

    if character in "aeiou":
        count += 1

print("Vowels:", count)

# Output:
# Vowels: 3


# ============================================================
# 32. FACTORIAL
# ============================================================
"""
5! = 5 × 4 × 3 × 2 × 1
   = 120
"""

number = 5

factorial = 1

for i in range(1, number + 1):
    factorial *= i

print("Factorial:", factorial)

# Output:
# Factorial: 120


# ============================================================
# 33. MULTIPLICATION TABLE
# ============================================================

number = 7

for i in range(1, 11):
    print(number, "x", i, "=", number * i)

# Output:
# 7 x 1 = 7
# 7 x 2 = 14
# 7 x 3 = 21
# ...
# 7 x 10 = 70


# ============================================================
# 34. PRINT ONLY PRIME NUMBERS
# ============================================================

for number in range(2, 21):

    for i in range(2, number):

        if number % i == 0:
            break

    else:
        print(number, end=" ")

print()

# Output:
# 2 3 5 7 11 13 17 19


# ============================================================
# 35. FIBONACCI SERIES
# ============================================================
"""
Fibonacci sequence:

0 1 1 2 3 5 8 13 ...

Each number is the sum of the previous two numbers.
"""

a = 0
b = 1

for i in range(10):

    print(a, end=" ")

    a, b = b, a + b

print()

# Output:
# 0 1 1 2 3 5 8 13 21 34


# ============================================================
# 36. PATTERN USING NESTED FOR LOOP
# ============================================================

for i in range(1, 6):

    for j in range(i):
        print("*", end="")

    print()

# Output:
# *
# **
# ***
# ****
# *****


# ============================================================
# 37. SEARCH FOR A NUMBER
# ============================================================

numbers = [15, 25, 35, 45, 55]

target = 35

for index, number in enumerate(numbers):

    if number == target:
        print("Found at index:", index)
        break

else:
    print("Element not found")

# Output:
# Found at index: 2


# ============================================================
# 38. COUNT OCCURRENCES
# ============================================================

numbers = [10, 20, 10, 30, 10, 40]

target = 10
count = 0

for number in numbers:

    if number == target:
        count += 1

print("Occurrences:", count)

# Output:
# Occurrences: 3


# ============================================================
#                         KEY POINTS
# ============================================================
"""
FOR LOOP
------------------------------------------------------------

1. for loop is used to iterate over an iterable.

2. Common iterables:
       list
       tuple
       string
       set
       dictionary
       range()

3. range(stop):
       starts from 0
       stops before stop

4. range(start, stop):
       starts from start
       stops before stop

5. range(start, stop, step):
       allows custom increments/decrements.

6. enumerate() is useful when both index and value are needed.

7. A for loop can be nested inside another for loop.


FOR-ELSE
------------------------------------------------------------

8. The else block executes when the loop completes normally.

9. If break executes, the loop's else block is skipped.

10. for-else is particularly useful for:
        - searching
        - prime-number checking
        - checking whether a condition was never satisfied


DO-WHILE
------------------------------------------------------------

11. Python does not have a built-in do-while statement.

12. A do-while loop can be achieved using:

        while True:
            statements

            if condition:
                break

13. This pattern guarantees that the loop body executes
    at least once.


QUICK COMPARISON
------------------------------------------------------------

for loop:
    Best when the number of iterations or iterable is known.

while loop:
    Best when repetition depends on a condition.

for-else:
    Useful when we need to know whether a loop completed
    without encountering break.

do-while style:
    Useful when the code must execute at least once before
    checking whether it should continue.
"""