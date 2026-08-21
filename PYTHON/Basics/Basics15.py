# ============================================================
#                       LOOPS IN PYTHON
# ============================================================
"""
A LOOP is a programming construct used to execute a block of
code repeatedly.

Instead of writing the same code multiple times, we can use
a loop to execute it automatically.

Example WITHOUT a loop:

    print(1)
    print(2)
    print(3)
    print(4)
    print(5)

Using a loop:

    for i in range(1, 6):
        print(i)

Loops are mainly used when we need to perform a task
repeatedly.

------------------------------------------------------------
TYPES OF LOOPS IN PYTHON
------------------------------------------------------------

1. for loop
2. while loop

Python also provides loop-control statements:

3. break
4. continue
5. pass

A loop can also contain another loop. This is called:

6. Nested loop
"""


# ============================================================
# 1. FOR LOOP
# ============================================================
"""
A for loop is used to iterate over the elements of an
iterable.

An iterable can be:

    - String
    - List
    - Tuple
    - Set
    - Dictionary
    - range()
    - etc.

Basic syntax:

    for variable in iterable:
        # code to execute

The loop takes one element at a time from the iterable
and executes the loop body.
"""

numbers = [10, 20, 30, 40]

for number in numbers:
    print(number)

# Output:
# 10
# 20
# 30
# 40


# ============================================================
# 2. FOR LOOP WITH STRING
# ============================================================
"""
A string is an iterable.

Therefore, a for loop can visit each character of a string.
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
# 3. FOR LOOP WITH TUPLE
# ============================================================

numbers = (10, 20, 30, 40)

for number in numbers:
    print(number)

# Output:
# 10
# 20
# 30
# 40


# ============================================================
# 4. FOR LOOP WITH SET
# ============================================================
"""
A set is unordered, so the order of output should not be
assumed.
"""

numbers = {10, 20, 30, 40}

for number in numbers:
    print(number)

# Output:
# Order may vary


# ============================================================
# 5. FOR LOOP WITH DICTIONARY
# ============================================================
"""
By default, iterating over a dictionary gives its KEYS.
"""

student = {
    "name": "Rahul",
    "age": 22,
    "marks": 85
}

for key in student:
    print(key)

# Output:
# name
# age
# marks


# ============================================================
# 6. ITERATING OVER DICTIONARY VALUES
# ============================================================
"""
Use values() when we want to iterate over values.
"""

student = {
    "name": "Rahul",
    "age": 22,
    "marks": 85
}

for value in student.values():
    print(value)

# Output:
# Rahul
# 22
# 85


# ============================================================
# 7. ITERATING OVER KEY-VALUE PAIRS
# ============================================================
"""
Use items() when we need both key and value.
"""

student = {
    "name": "Rahul",
    "age": 22,
    "marks": 85
}

for key, value in student.items():
    print(key, value)

# Output:
# name Rahul
# age 22
# marks 85


# ============================================================
# 8. range()
# ============================================================
"""
range() is commonly used with a for loop.

Basic forms:

    range(stop)

    range(start, stop)

    range(start, stop, step)

IMPORTANT:

The stop value is NOT included.
"""

for i in range(5):
    print(i)

# Output:
# 0
# 1
# 2
# 3
# 4


# ============================================================
# 9. range(start, stop)
# ============================================================

for i in range(1, 6):
    print(i)

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 10. range(start, stop, step)
# ============================================================

for i in range(1, 11, 2):
    print(i)

# Output:
# 1
# 3
# 5
# 7
# 9


# ============================================================
# 11. REVERSE LOOP USING range()
# ============================================================
"""
A negative step can be used to move backwards.
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
# 12. PRINT EVEN NUMBERS
# ============================================================

for i in range(2, 11, 2):
    print(i)

# Output:
# 2
# 4
# 6
# 8
# 10


# ============================================================
# 13. PRINT ODD NUMBERS
# ============================================================

for i in range(1, 11, 2):
    print(i)

# Output:
# 1
# 3
# 5
# 7
# 9


# ============================================================
# 14. FOR LOOP WITH CONDITION
# ============================================================
"""
A loop can contain an if statement.
"""

numbers = [10, 15, 20, 25, 30]

for number in numbers:

    if number % 2 == 0:
        print(number)

# Output:
# 10
# 20
# 30


# ============================================================
# 15. SUM OF NUMBERS USING FOR LOOP
# ============================================================

numbers = [10, 20, 30, 40, 50]

total = 0

for number in numbers:
    total = total + number

print(total)
# Output: 150


# ============================================================
# 16. FIND MAXIMUM USING FOR LOOP
# ============================================================

numbers = [10, 45, 23, 89, 12]

maximum = numbers[0]

for number in numbers:

    if number > maximum:
        maximum = number

print(maximum)
# Output: 89


# ============================================================
# 17. FIND MINIMUM USING FOR LOOP
# ============================================================

numbers = [10, 45, 23, 89, 12]

minimum = numbers[0]

for number in numbers:

    if number < minimum:
        minimum = number

print(minimum)
# Output: 10


# ============================================================
# 18. COUNT ELEMENTS USING FOR LOOP
# ============================================================

numbers = [10, 20, 30, 40, 50]

count = 0

for number in numbers:
    count = count + 1

print(count)
# Output: 5


# ============================================================
# 19. WHILE LOOP
# ============================================================
"""
A while loop repeatedly executes a block of code as long as
a given condition is True.

Syntax:

    while condition:
        # code

The condition is checked before every iteration.
"""

i = 1

while i <= 5:
    print(i)
    i = i + 1

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 20. HOW A WHILE LOOP WORKS
# ============================================================
"""
Suppose:

    i = 1

    while i <= 3:
        print(i)
        i = i + 1

Execution:

    i = 1
    1 <= 3 -> True  -> print 1
    i = 2

    2 <= 3 -> True  -> print 2
    i = 3

    3 <= 3 -> True  -> print 3
    i = 4

    4 <= 3 -> False -> loop stops
"""

i = 1

while i <= 3:
    print(i)
    i += 1

# Output:
# 1
# 2
# 3


# ============================================================
# 21. IMPORTANT PARTS OF A WHILE LOOP
# ============================================================
"""
A while loop generally has three important parts:

1. Initialization
2. Condition
3. Update

Example:

    i = 1              -> Initialization

    while i <= 5:      -> Condition
        print(i)
        i += 1         -> Update

If the update is missing, the loop may become infinite.
"""


# ============================================================
# 22. INFINITE LOOP
# ============================================================
"""
An infinite loop occurs when the loop condition never becomes
False.

Example:

    i = 1

    while i <= 5:
        print(i)

There is no update to i, so i always remains 1.

DO NOT run the following code normally.
"""

# i = 1
#
# while i <= 5:
#     print(i)

"""
To stop a running program in VS Code terminal, you can usually
press:

    Ctrl + C
"""


# ============================================================
# 23. WHILE LOOP WITH USER INPUT
# ============================================================
"""
while loops are useful when we do not know beforehand how many
times the loop should execute.

Example:

Keep asking for a password until the correct password is
entered.
"""

password = ""

while password != "python123":
    password = input("Enter password: ")

print("Access granted")
# Example Output:
# Enter password: abc
# Enter password: python123
# Access granted


# ============================================================
# 24. FOR LOOP VS WHILE LOOP
# ============================================================
"""
FOR LOOP:

    Best when the number of iterations or iterable is known.

Example:

    for i in range(10):
        print(i)


WHILE LOOP:

    Best when execution depends on a condition.

Example:

    while password != "python123":
        password = input("Enter password: ")


Simple rule:

    FOR    -> iterate over a sequence / known repetitions

    WHILE  -> repeat while a condition is True
"""


# ============================================================
# 25. BREAK STATEMENT
# ============================================================
"""
break immediately terminates the loop.

It does NOT just skip the current iteration.

It completely exits the nearest loop.
"""

for i in range(1, 11):

    if i == 5:
        break

    print(i)

# Output:
# 1
# 2
# 3
# 4


# ============================================================
# 26. BREAK IN WHILE LOOP
# ============================================================

i = 1

while i <= 10:

    if i == 6:
        break

    print(i)
    i += 1

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 27. CONTINUE STATEMENT
# ============================================================
"""
continue skips the CURRENT iteration and moves to the next
iteration.

Unlike break, continue does NOT terminate the loop.
"""

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
# 28. BREAK VS CONTINUE
# ============================================================
"""
break:

    Stops the entire loop.

continue:

    Skips only the current iteration.

Example:

    for i in range(1, 6):

        if i == 3:
            break

    Output:
        1
        2


    for i in range(1, 6):

        if i == 3:
            continue

        print(i)

    Output:
        1
        2
        4
        5
"""


# ============================================================
# 29. PASS STATEMENT
# ============================================================
"""
pass does NOTHING.

It is used as a placeholder when Python requires a statement
but we do not want to execute any code yet.

Example:

    for i in range(5):
        pass

The loop executes, but nothing is displayed.
"""

for i in range(5):
    pass

print("Loop completed")
# Output: Loop completed


# ============================================================
# 30. BREAK, CONTINUE AND PASS
# ============================================================
"""
break:
    Terminates the loop.

continue:
    Skips the current iteration.

pass:
    Does nothing; acts as a placeholder.
"""


# ============================================================
# 31. NESTED LOOPS
# ============================================================
"""
A loop inside another loop is called a NESTED LOOP.

Syntax:

    for i in range(...):

        for j in range(...):
            # code

For every iteration of the outer loop, the inner loop
executes completely.
"""

for i in range(3):

    for j in range(3):
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
# 32. NESTED LOOP - MULTIPLICATION TABLES
# ============================================================

for i in range(1, 4):

    for j in range(1, 11):
        print(i * j, end=" ")

    print()

# Output:
# 1 2 3 4 5 6 7 8 9 10
# 2 4 6 8 10 12 14 16 18 20
# 3 6 9 12 15 18 21 24 27 30


# ============================================================
# 33. NESTED LOOP - PATTERN
# ============================================================
"""
Nested loops are frequently used for pattern problems.
"""

for i in range(1, 5):

    for j in range(i):
        print("*", end=" ")

    print()

# Output:
# *
# * *
# * * *
# * * * *


# ============================================================
# 34. NESTED WHILE LOOP
# ============================================================

i = 1

while i <= 3:

    j = 1

    while j <= 3:
        print(i, j)
        j += 1

    i += 1

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
# 35. ELSE WITH FOR LOOP
# ============================================================
"""
Python allows an else block with loops.

The else block executes when the loop finishes normally.

Example:
"""

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
# 36. ELSE WITH BREAK
# ============================================================
"""
Important:

If a loop terminates because of break, the else block
does NOT execute.
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

"""
"Loop completed" is NOT printed because break terminated
the loop.
"""


# ============================================================
# 37. ELSE WITH WHILE LOOP
# ============================================================

i = 1

while i <= 3:
    print(i)
    i += 1

else:
    print("Loop completed")

# Output:
# 1
# 2
# 3
# Loop completed


# ============================================================
# 38. SEARCHING USING A LOOP
# ============================================================

numbers = [10, 20, 30, 40, 50]

target = 30

for number in numbers:

    if number == target:
        print("Element found")
        break

# Output: Element found


# ============================================================
# 39. SEARCHING WITH FOR-ELSE
# ============================================================
"""
The combination of for + else is useful for searching.

If break occurs:
    -> element was found
    -> else does not execute

If loop finishes normally:
    -> element was not found
    -> else executes
"""

numbers = [10, 20, 30, 40, 50]

target = 70

for number in numbers:

    if number == target:
        print("Element found")
        break

else:
    print("Element not found")

# Output: Element not found


# ============================================================
# 40. COUNT EVEN AND ODD NUMBERS
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
# Output: Even: 3

print("Odd:", odd_count)
# Output: Odd: 3


# ============================================================
# 41. REVERSE A STRING USING A LOOP
# ============================================================

text = "Python"

reverse = ""

for character in text:
    reverse = character + reverse

print(reverse)
# Output: nohtyP


# ============================================================
# 42. FACTORIAL USING FOR LOOP
# ============================================================
"""
Factorial of n:

    n! = n × (n-1) × (n-2) × ... × 1

Example:

    5! = 5 × 4 × 3 × 2 × 1
       = 120
"""

n = 5

factorial = 1

for i in range(1, n + 1):
    factorial *= i

print(factorial)
# Output: 120


# ============================================================
# 43. FACTORIAL USING WHILE LOOP
# ============================================================

n = 5

factorial = 1
i = 1

while i <= n:
    factorial *= i
    i += 1

print(factorial)
# Output: 120


# ============================================================
# 44. LOOPING WITH INDEX - range(len())
# ============================================================
"""
If we need both the index and the element, we can use:

    range(len(list))
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
# 45. enumerate()
# ============================================================
"""
enumerate() is a cleaner way to get both index and value.
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
# 46. enumerate() WITH STARTING INDEX
# ============================================================

numbers = [10, 20, 30]

for index, value in enumerate(numbers, start=1):
    print(index, value)

# Output:
# 1 10
# 2 20
# 3 30


# ============================================================
# 47. LOOPING THROUGH TWO LISTS USING zip()
# ============================================================
"""
zip() allows us to iterate through multiple iterables
simultaneously.
"""

names = ["A", "B", "C"]
marks = [80, 90, 85]

for name, mark in zip(names, marks):
    print(name, mark)

# Output:
# A 80
# B 90
# C 85


# ============================================================
# 48. LOOP CONTROL SUMMARY
# ============================================================
"""
                    LOOP CONTROL STATEMENTS

    break
        -> Immediately terminates the loop.

    continue
        -> Skips the current iteration.

    pass
        -> Does nothing; placeholder statement.

Example:

    for i in range(10):

        if i == 3:
            continue

        if i == 7:
            break

        print(i)

Output:
    0
    1
    2
    4
    5
    6
"""


# ============================================================
# 49. FOR LOOP VS WHILE LOOP
# ============================================================
"""
+----------------------+-------------------------------+
| for loop             | while loop                    |
+----------------------+-------------------------------+
| Iterates over an     | Repeats while a condition     |
| iterable              | is True                        |
|                      |                               |
| Usually used when   | Useful when number of         |
| iterations are known | iterations is not known      |
|                      | beforehand                    |
|                      |                               |
| Often used with     | Often used with conditions   |
| range(), lists, etc. | and user input                |
+----------------------+-------------------------------+

Examples:

FOR:

    for i in range(5):
        print(i)


WHILE:

    i = 0

    while i < 5:
        print(i)
        i += 1
"""


# ============================================================
#                       KEY POINTS
# ============================================================
"""
1. A loop is used to execute a block of code repeatedly.

2. Python has two primary loop types:

       for
       while

3. A for loop is mainly used to iterate over an iterable.

4. Common iterables:

       string
       list
       tuple
       set
       dictionary
       range()

5. range() generates a sequence of numbers.

       range(stop)
       range(start, stop)
       range(start, stop, step)

6. The stop value in range() is EXCLUDED.

7. A while loop executes as long as its condition is True.

8. A while loop generally requires:

       initialization
       condition
       update

9. Forgetting the update in a while loop can cause an
   infinite loop.

10. break terminates the nearest loop immediately.

11. continue skips the current iteration.

12. pass does nothing and is used as a placeholder.

13. A loop inside another loop is called a nested loop.

14. Python supports an else block with for and while loops.

15. Loop else executes when the loop finishes normally.

16. If break terminates the loop, the else block does NOT
    execute.

17. enumerate() is useful when both index and value are needed.

18. zip() is useful when iterating over multiple sequences
    simultaneously.

19. Nested loops are commonly used in:

       - Pattern problems
       - Matrix problems
       - 2D arrays
       - Tables
       - DSA problems

20. In DSA, loops are fundamental for:

       - Traversing arrays
       - Searching
       - Counting
       - Finding maximum/minimum
       - Sorting
       - Matrix traversal
       - Pattern problems

21. Always pay attention to loop complexity.

Example:

    for i in range(n):
        print(i)

Time Complexity:
    O(n)

Nested loop:

    for i in range(n):
        for j in range(n):
            print(i, j)

Time Complexity:
    O(n²)
"""