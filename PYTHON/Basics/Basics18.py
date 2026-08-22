# ============================================================
#                         range()
# ============================================================
"""
range() is a built-in Python function used to generate a
sequence of integers.

It is commonly used with for loops.

Basic syntax:

    range(stop)

    range(start, stop)

    range(start, stop, step)

IMPORTANT:
The stop value is ALWAYS excluded.

For example:

    range(5)

generates:

    0, 1, 2, 3, 4

It does NOT generate 5.
"""


# ============================================================
# 1. range(stop)
# ============================================================
"""
When only one argument is provided, it is treated as stop.

Syntax:

    range(stop)

The sequence starts from 0 and goes up to stop - 1.
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
# 2. range(1)
# ============================================================

for i in range(1):
    print(i)

# Output:
# 0


# ============================================================
# 3. range(0)
# ============================================================
"""
range(0) contains no numbers.
Therefore, the loop does not execute.
"""

for i in range(0):
    print(i)

# Output:
# No output


# ============================================================
# 4. range(start, stop)
# ============================================================
"""
When two arguments are provided:

    range(start, stop)

start -> included
stop  -> excluded

Example:

    range(2, 7)

generates:

    2, 3, 4, 5, 6
"""

for i in range(2, 7):
    print(i)

# Output:
# 2
# 3
# 4
# 5
# 6


# ============================================================
# 5. range(5, 10)
# ============================================================

for i in range(5, 10):
    print(i)

# Output:
# 5
# 6
# 7
# 8
# 9


# ============================================================
# 6. range(start, stop, step)
# ============================================================
"""
Three arguments:

    range(start, stop, step)

start -> starting value
stop  -> ending boundary (excluded)
step  -> amount by which the value changes
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
# 7. STEP = 1
# ============================================================
"""
If step is 1, the numbers increase by 1.
"""

for i in range(1, 6, 1):
    print(i)

# Output:
# 1
# 2
# 3
# 4
# 5

"""
This is equivalent to:

    range(1, 6)

"""


# ============================================================
# 8. STEP = 2
# ============================================================

for i in range(0, 11, 2):
    print(i)

# Output:
# 0
# 2
# 4
# 6
# 8
# 10


# ============================================================
# 9. STEP = 3
# ============================================================

for i in range(0, 16, 3):
    print(i)

# Output:
# 0
# 3
# 6
# 9
# 12
# 15


# ============================================================
# 10. NEGATIVE STEP
# ============================================================
"""
A negative step allows us to move backward.

For example:

    range(10, 0, -1)

generates:

    10, 9, 8, ..., 1
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
# 11. COUNTDOWN
# ============================================================

for i in range(5, -1, -1):
    print(i)

# Output:
# 5
# 4
# 3
# 2
# 1
# 0


# ============================================================
# 12. NEGATIVE RANGE
# ============================================================
"""
range() can also generate negative numbers.
"""

for i in range(-5, 1):
    print(i)

# Output:
# -5
# -4
# -3
# -2
# -1
# 0


# ============================================================
# 13. NEGATIVE STEP WITH NEGATIVE NUMBERS
# ============================================================

for i in range(5, -6, -2):
    print(i)

# Output:
# 5
# 3
# 1
# -1
# -3
# -5


# ============================================================
# 14. IMPORTANT: STOP VALUE IS EXCLUDED
# ============================================================
"""
This is one of the most important rules of range().

range(1, 5)

contains:

    1, 2, 3, 4

NOT:

    1, 2, 3, 4, 5
"""

print(list(range(1, 5)))

# Output:
# [1, 2, 3, 4]


# ============================================================
# 15. CONVERT range() TO LIST
# ============================================================
"""
range() does not directly display all its values.

We can convert it into a list using list().
"""

numbers = list(range(5))

print(numbers)

# Output:
# [0, 1, 2, 3, 4]


# ============================================================
# 16. CONVERT range() TO TUPLE
# ============================================================

numbers = tuple(range(5))

print(numbers)

# Output:
# (0, 1, 2, 3, 4)


# ============================================================
# 17. CHECK TYPE OF range()
# ============================================================

numbers = range(5)

print(type(numbers))

# Output:
# <class 'range'>


# ============================================================
# 18. range() IS NOT A LIST
# ============================================================
"""
range() creates a range object.

It is different from a list.

"""

numbers = range(5)

print(numbers)

# Output:
# range(0, 5)

print(list(numbers))

# Output:
# [0, 1, 2, 3, 4]


# ============================================================
# 19. range() WITH len()
# ============================================================
"""
range(len(list)) is commonly used when we need indexes.
"""

numbers = [10, 20, 30, 40, 50]

for i in range(len(numbers)):
    print(i, numbers[i])

# Output:
# 0 10
# 1 20
# 2 30
# 3 40
# 4 50


# ============================================================
# 20. range() FOR INDEXING
# ============================================================

names = ["Alice", "Bob", "Charlie"]

for i in range(len(names)):
    print("Index:", i, "Value:", names[i])

# Output:
# Index: 0 Value: Alice
# Index: 1 Value: Bob
# Index: 2 Value: Charlie


# ============================================================
# 21. RANGE FOR EVEN NUMBERS
# ============================================================
"""
Starting from 2 and using step 2 gives even numbers.
"""

for i in range(2, 11, 2):
    print(i)

# Output:
# 2
# 4
# 6
# 8
# 10


# ============================================================
# 22. RANGE FOR ODD NUMBERS
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
# 23. RANGE FOR MULTIPLES
# ============================================================
"""
Multiples of 5:

5, 10, 15, 20, 25
"""

for i in range(5, 26, 5):
    print(i)

# Output:
# 5
# 10
# 15
# 20
# 25


# ============================================================
# 24. RANGE WITH A STEP GREATER THAN THE RANGE
# ============================================================

for i in range(1, 5, 10):
    print(i)

# Output:
# 1


# ============================================================
# 25. WHEN RANGE PRODUCES NOTHING
# ============================================================
"""
The direction of the step must match the direction from
start to stop.

Here:

    start = 1
    stop = 10
    step = -1

The loop wants to decrease, but stop is greater than start.

Therefore, no values are generated.
"""

print(list(range(1, 10, -1)))

# Output:
# []


# ============================================================
# 26. CORRECT BACKWARD RANGE
# ============================================================

print(list(range(10, 1, -1)))

# Output:
# [10, 9, 8, 7, 6, 5, 4, 3, 2]


# ============================================================
# 27. RANGE WITH VARIABLES
# ============================================================

start = 1
stop = 6
step = 2

for i in range(start, stop, step):
    print(i)

# Output:
# 1
# 3
# 5


# ============================================================
# 28. RANGE FOR SUM OF NUMBERS
# ====================================================

total = 0

for i in range(1, 11):
    total += i

print("Sum:", total)

# Output:
# Sum: 55


# ============================================================
# 29. RANGE FOR FACTORIAL
# ====================================================

number = 5
factorial = 1

for i in range(1, number + 1):
    factorial *= i

print("Factorial:", factorial)

# Output:
# Factorial: 120


# ============================================================
# 30. RANGE FOR MULTIPLICATION TABLE
# ====================================================

number = 7

for i in range(1, 11):
    print(number, "x", i, "=", number * i)

# Output:
# 7 x 1 = 7
# 7 x 2 = 14
# 7 x 3 = 21
# 7 x 4 = 28
# 7 x 5 = 35
# 7 x 6 = 42
# 7 x 7 = 49
# 7 x 8 = 56
# 7 x 9 = 63
# 7 x 10 = 70


# ============================================================
# 31. RANGE WITH A STRING
# ============================================================
"""
range() itself does not iterate directly over string values,
but it can be used to generate string indexes.
"""

text = "Python"

for i in range(len(text)):
    print(i, text[i])

# Output:
# 0 P
# 1 y
# 2 t
# 3 h
# 4 o
# 5 n


# ============================================================
# 32. REVERSE A STRING USING RANGE()
# ============================================================
"""
We can use a negative step to access indexes from the end.
"""

text = "Python"

for i in range(len(text) - 1, -1, -1):
    print(text[i], end="")

print()

# Output:
# nohtyP


# ============================================================
# 33. RANGE OBJECT SUPPORTS INDEXING
# ============================================================
"""
A range object can itself be indexed.
"""

numbers = range(10, 20)

print(numbers[0])

# Output:
# 10

print(numbers[3])

# Output:
# 13

print(numbers[-1])

# Output:
# 19


# ============================================================
# 34. RANGE OBJECT SUPPORTS SLICING
# ============================================================

numbers = range(10)

print(numbers[2:7])

# Output:
# range(2, 7)

print(list(numbers[2:7]))

# Output:
# [2, 3, 4, 5, 6]


# ============================================================
# 35. CHECK MEMBERSHIP IN RANGE
# ====================================================

numbers = range(1, 11)

print(5 in numbers)

# Output:
# True

print(15 in numbers)

# Output:
# False


# ============================================================
# 36. RANGE WITH STEP AND MEMBERSHIP
# ====================================================

numbers = range(2, 11, 2)

print(6 in numbers)

# Output:
# True

print(7 in numbers)

# Output:
# False


# ============================================================
# 37. RANGE LENGTH
# ============================================================
"""
len() can be used with a range object.
"""

numbers = range(1, 11)

print(len(numbers))

# Output:
# 10


# ============================================================
# 38. RANGE WITH ZERO STEP
# ============================================================
"""
step cannot be zero.

The following code produces an error:

    range(1, 10, 0)

Error:
    ValueError: range() arg 3 must not be zero
"""


# ============================================================
# 39. THREE FORMS OF range()
# ============================================================
"""
FORM 1:
    range(stop)

Example:
    range(5)

Generated values:
    0 1 2 3 4


FORM 2:
    range(start, stop)

Example:
    range(2, 6)

Generated values:
    2 3 4 5


FORM 3:
    range(start, stop, step)

Example:
    range(2, 10, 2)

Generated values:
    2 4 6 8
"""


# ============================================================
# 40. QUICK COMPARISON
# ============================================================
"""
range(5)
    -> 0 1 2 3 4

range(2, 5)
    -> 2 3 4

range(2, 10, 2)
    -> 2 4 6 8

range(10, 0, -2)
    -> 10 8 6 4 2

range(5, 0, -1)
    -> 5 4 3 2 1
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. range() is a built-in function used to generate a sequence
   of integers.

2. It is most commonly used with for loops.

3. There are three forms:

       range(stop)
       range(start, stop)
       range(start, stop, step)

4. The start value is included.

5. The stop value is excluded.

6. Default start is 0.

7. Default step is 1.

8. A negative step is used for backward iteration.

9. Step cannot be 0.

10. range() returns a range object, not a list.

11. Use list(range(...)) if you want to see/store the values
    as a list.

12. range() supports:
        - indexing
        - slicing
        - len()
        - membership testing using in

13. Common uses:
        - loops
        - counting
        - indexing
        - generating even/odd numbers
        - multiplication tables
        - factorial
        - reverse iteration

14. Most important rule:

       STOP VALUE IS NEVER INCLUDED.

15. Easy way to remember:

       range(start, stop, step)
          ↓       ↓      ↓
       where    where   how much
       start    to stop  to move
"""