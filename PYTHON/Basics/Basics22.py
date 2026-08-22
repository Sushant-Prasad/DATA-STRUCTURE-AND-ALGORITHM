# ============================================================
#                    RECURSION IN PYTHON
# ============================================================
"""
RECURSION is a technique in which a function calls itself
to solve a problem.

A recursive function generally has two important parts:

    1. BASE CASE
    2. RECURSIVE CASE


------------------------------------------------------------
1. BASE CASE
------------------------------------------------------------

The condition that stops the recursion.

Without a proper base case, the function keeps calling itself
and eventually Python raises:

    RecursionError


------------------------------------------------------------
2. RECURSIVE CASE
------------------------------------------------------------

The part where the function calls itself with a smaller,
simpler, or closer-to-base-case input.


------------------------------------------------------------
GENERAL STRUCTURE
------------------------------------------------------------

def function(parameter):

    if base_condition:
        return result

    return function(smaller_parameter)


------------------------------------------------------------
IMPORTANT IDEA
------------------------------------------------------------

Recursion has two phases:

    CALLING PHASE
        ↓
    Functions keep getting added to the call stack

        ↓

    BASE CASE
        ↓

    RETURNING PHASE
        ↓
    Functions are removed from the call stack one by one


------------------------------------------------------------
RECURSION EXAMPLE
------------------------------------------------------------

def countdown(n):

    if n == 0:
        return

    print(n)

    countdown(n - 1)


countdown(3)

Output:
3
2
1
"""


# ============================================================
# 1. SIMPLE RECURSION
# ============================================================

def countdown(n):

    # Base case:
    # Stop when n becomes 0.
    if n == 0:
        return

    print(n)

    # Recursive call:
    # Call the same function with a smaller value.
    countdown(n - 1)


countdown(5)

# Output:
# 5
# 4
# 3
# 2
# 1


# ============================================================
# 2. HOW THE RECURSIVE CALLS WORK
# ============================================================
"""
For:

    countdown(3)

Execution happens like this:

    countdown(3)
        |
        -> print(3)
        |
        -> countdown(2)
                |
                -> print(2)
                |
                -> countdown(1)
                        |
                        -> print(1)
                        |
                        -> countdown(0)
                                |
                                -> return


The base case is reached at:

    countdown(0)

Then the function calls start returning.


------------------------------------------------------------
CALL STACK
------------------------------------------------------------

The CALL STACK is a memory structure used by Python to keep
track of active function calls.

When a function is called:

    A STACK FRAME is created.

When the function returns:

    Its stack frame is removed.


For:

    countdown(3)

The stack grows approximately like:

        countdown(3)
        countdown(2)
        countdown(1)
        countdown(0)

Then it starts shrinking:

        countdown(0) -> return
        countdown(1) -> return
        countdown(2) -> return
        countdown(3) -> return
"""


# ============================================================
# 3. CALL STACK - SIMPLE EXAMPLE
# ============================================================

def first():

    print("First")

    second()


def second():

    print("Second")

    third()


def third():

    print("Third")


first()

# Output:
# First
# Second
# Third


"""
CALL STACK:

Initially:

    first()
        ↓

    first()
    second()
        ↓

    first()
    second()
    third()
        ↓

    third() finishes
        ↓

    second() finishes
        ↓

    first() finishes


The last function added to the stack is the first one to
finish.

This follows:

    LIFO

    Last In, First Out
"""


# ============================================================
# 4. RECURSION WITH CALL STACK
# ============================================================

def print_numbers(n):

    if n == 0:
        return

    print_numbers(n - 1)

    print(n)


print_numbers(5)

# Output:
# 1
# 2
# 3
# 4
# 5


"""
Notice the difference.

The recursive call happens BEFORE print(n).

Therefore:

    print_numbers(5)
        ↓
    print_numbers(4)
        ↓
    print_numbers(3)
        ↓
    print_numbers(2)
        ↓
    print_numbers(1)
        ↓
    print_numbers(0)
        ↓
    return
        ↓
    print(1)
        ↓
    print(2)
        ↓
    print(3)
        ↓
    print(4)
        ↓
    print(5)

This demonstrates the importance of the RETURNING PHASE.
"""


# ============================================================
# 5. FACTORIAL USING RECURSION
# ============================================================
"""
FACTORIAL:

    n! = n × (n-1) × (n-2) × ... × 1

Example:

    5!

    = 5 × 4 × 3 × 2 × 1
    = 120


Recursive formula:

    n! = n × (n-1)!

Base case:

    0! = 1
"""

def factorial(n):

    # Base case
    if n == 0:
        return 1

    # Recursive case
    return n * factorial(n - 1)


print(factorial(5))

# Output:
# 120


"""
CALL STACK:

    factorial(5)
        ↓
    5 * factorial(4)
        ↓
    4 * factorial(3)
        ↓
    3 * factorial(2)
        ↓
    2 * factorial(1)
        ↓
    1 * factorial(0)
        ↓
    1

Returning:

    factorial(0) = 1
    factorial(1) = 1 × 1 = 1
    factorial(2) = 2 × 1 = 2
    factorial(3) = 3 × 2 = 6
    factorial(4) = 4 × 6 = 24
    factorial(5) = 5 × 24 = 120
"""


# ============================================================
# 6. SUM OF FIRST N NATURAL NUMBERS
# ============================================================
"""
Find:

    1 + 2 + 3 + ... + n

Recursive formula:

    sum(n) = n + sum(n - 1)

Base case:

    sum(0) = 0
"""

def sum_n(n):

    if n == 0:
        return 0

    return n + sum_n(n - 1)


print(sum_n(5))

# Output:
# 15


# ============================================================
# 7. POWER USING RECURSION
# ============================================================
"""
Calculate:

    base^exponent

Example:

    2^5
    = 2 × 2 × 2 × 2 × 2
    = 32

Recursive formula:

    power(a, b) = a × power(a, b-1)

Base case:

    power(a, 0) = 1
"""

def power(base, exponent):

    if exponent == 0:
        return 1

    return base * power(base, exponent - 1)


print(power(2, 5))

# Output:
# 32


# ============================================================
# 8. COUNTDOWN USING RECURSION
# ============================================================

def countdown(n):

    if n == 0:
        print("Done")
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
# Done


# ============================================================
# 9. COUNT UP USING RECURSION
# ============================================================

def count_up(n):

    if n == 0:
        return

    count_up(n - 1)

    print(n)


count_up(5)

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 10. PRINT ARRAY/LIST ELEMENTS USING RECURSION
# ============================================================
"""
We can recursively process one element at a time.
"""

def print_list(numbers, index):

    if index == len(numbers):
        return

    print(numbers[index])

    print_list(numbers, index + 1)


numbers = [10, 20, 30, 40, 50]

print_list(numbers, 0)

# Output:
# 10
# 20
# 30
# 40
# 50


# ============================================================
# 11. SUM OF LIST ELEMENTS
# ============================================================
"""
Example:

    [10, 20, 30, 40]

    = 10 + 20 + 30 + 40
    = 100
"""

def list_sum(numbers, index):

    if index == len(numbers):
        return 0

    return numbers[index] + list_sum(numbers, index + 1)


numbers = [10, 20, 30, 40]

print(list_sum(numbers, 0))

# Output:
# 100


# ============================================================
# 12. FIND MAXIMUM ELEMENT USING RECURSION
# ============================================================
"""
Find the maximum element of a list recursively.
"""

def find_max(numbers, index):

    # Base case:
    # If this is the last element, return it.
    if index == len(numbers) - 1:
        return numbers[index]

    # Find maximum in remaining elements.
    remaining_max = find_max(numbers, index + 1)

    # Compare current element with remaining maximum.
    return max(numbers[index], remaining_max)


numbers = [10, 45, 23, 78, 12]

print(find_max(numbers, 0))

# Output:
# 78


# ============================================================
# 13. REVERSE A STRING USING RECURSION
# ============================================================
"""
Example:

    "Python"

    -> "nohtyP"
"""

def reverse_string(text):

    if len(text) == 0:
        return ""

    return reverse_string(text[1:]) + text[0]


print(reverse_string("Python"))

# Output:
# nohtyP


# ============================================================
# 14. CHECK PALINDROME USING RECURSION
# ============================================================
"""
A palindrome reads the same from both directions.

Examples:

    madam
    level
    radar

Recursive idea:

    Compare first and last characters.

    If they are different:
        Not palindrome.

    If they are same:
        Check the remaining substring.
"""

def is_palindrome(text):

    # Base case:
    # Empty string or one character is a palindrome.
    if len(text) <= 1:
        return True

    # If first and last characters differ,
    # it cannot be a palindrome.
    if text[0] != text[-1]:
        return False

    return is_palindrome(text[1:-1])


print(is_palindrome("madam"))

# Output:
# True


print(is_palindrome("python"))

# Output:
# False


# ============================================================
# 15. COUNT DIGITS USING RECURSION
# ============================================================
"""
Example:

    12345

Number of digits = 5
"""

def count_digits(number):

    if number < 10:
        return 1

    return 1 + count_digits(number // 10)


print(count_digits(12345))

# Output:
# 5


# ============================================================
# 16. SUM OF DIGITS
# ============================================================
"""
Example:

    12345

    = 1 + 2 + 3 + 4 + 5
    = 15

We use:

    number % 10
        -> last digit

    number // 10
        -> removes last digit
"""

def digit_sum(number):

    if number == 0:
        return 0

    return (number % 10) + digit_sum(number // 10)


print(digit_sum(12345))

# Output:
# 15


# ============================================================
# 17. PRODUCT OF DIGITS
# ============================================================

def digit_product(number):

    if number < 10:
        return number

    return (number % 10) * digit_product(number // 10)


print(digit_product(1234))

# Output:
# 24


# ============================================================
# 18. GCD USING RECURSION
# ============================================================
"""
GCD = Greatest Common Divisor

Euclidean algorithm:

    gcd(a, b) = gcd(b, a % b)

Base case:

    gcd(a, 0) = a
"""

def gcd(a, b):

    if b == 0:
        return a

    return gcd(b, a % b)


print(gcd(48, 18))

# Output:
# 6


# ============================================================
# 19. FIBONACCI USING RECURSION
# ============================================================
"""
Fibonacci sequence:

    0, 1, 1, 2, 3, 5, 8, 13...

Formula:

    F(n) = F(n-1) + F(n-2)

Base cases:

    F(0) = 0
    F(1) = 1
"""

def fibonacci(n):

    if n == 0:
        return 0

    if n == 1:
        return 1

    return fibonacci(n - 1) + fibonacci(n - 2)


print(fibonacci(7))

# Output:
# 13


"""
IMPORTANT:

The simple recursive Fibonacci solution creates many
repeated function calls.

For example:

    fibonacci(5)

calls:

    fibonacci(4)
    fibonacci(3)

and those functions call fibonacci(3), fibonacci(2), etc.

Therefore, this basic recursive implementation is
inefficient for large n.
"""


# ============================================================
# 20. MULTIPLICATION USING RECURSION
# ============================================================
"""
Instead of using * directly:

    5 × 4

we can think:

    5 + 5 + 5 + 5
"""

def multiply(a, b):

    if b == 0:
        return 0

    return a + multiply(a, b - 1)


print(multiply(5, 4))

# Output:
# 20


# ============================================================
# 21. PRINT NUMBERS IN REVERSE
# ============================================================

def reverse_count(n):

    if n == 0:
        return

    print(n)

    reverse_count(n - 1)


reverse_count(5)

# Output:
# 5
# 4
# 3
# 2
# 1


# ============================================================
# 22. PRACTICE QUESTION
# ============================================================
"""
QUESTION 1:

Write a recursive function to print numbers from 1 to n.

Example:

    n = 5

Output:

    1
    2
    3
    4
    5
"""

def print_1_to_n(n):

    if n == 0:
        return

    print_1_to_n(n - 1)

    print(n)


print_1_to_n(5)

# Output:
# 1
# 2
# 3
# 4
# 5


# ============================================================
# 23. PRACTICE QUESTION
# ============================================================
"""
QUESTION 2:

Write a recursive function to print numbers from n to 1.

Example:

    n = 5

Output:

    5
    4
    3
    2
    1
"""

def print_n_to_1(n):

    if n == 0:
        return

    print(n)

    print_n_to_1(n - 1)


print_n_to_1(5)

# Output:
# 5
# 4
# 3
# 2
# 1


# ============================================================
# 24. PRACTICE QUESTION
# ============================================================
"""
QUESTION 3:

Find the factorial of a number using recursion.

Input:

    5

Output:

    120
"""

def factorial(n):

    if n == 0:
        return 1

    return n * factorial(n - 1)


print(factorial(5))

# Output:
# 120


# ============================================================
# 25. PRACTICE QUESTION
# ============================================================
"""
QUESTION 4:

Find the sum of digits recursively.

Input:

    1234

Output:

    10
"""

def sum_digits(n):

    if n == 0:
        return 0

    return n % 10 + sum_digits(n // 10)


print(sum_digits(1234))

# Output:
# 10


# ============================================================
# 26. PRACTICE QUESTION
# ============================================================
"""
QUESTION 5:

Count the number of digits recursively.

Input:

    98765

Output:

    5
"""

def count_digits(n):

    if n < 10:
        return 1

    return 1 + count_digits(n // 10)


print(count_digits(98765))

# Output:
# 5


# ============================================================
# 27. PRACTICE QUESTION
# ============================================================
"""
QUESTION 6:

Find the power of a number recursively.

Input:

    base = 2
    exponent = 4

Output:

    16
"""

def power(base, exponent):

    if exponent == 0:
        return 1

    return base * power(base, exponent - 1)


print(power(2, 4))

# Output:
# 16


# ============================================================
# 28. PRACTICE QUESTION
# ============================================================
"""
QUESTION 7:

Check whether a string is a palindrome.

Input:

    "level"

Output:

    True
"""

def palindrome(text):

    if len(text) <= 1:
        return True

    if text[0] != text[-1]:
        return False

    return palindrome(text[1:-1])


print(palindrome("level"))

# Output:
# True


# ============================================================
# 29. PRACTICE QUESTION
# ============================================================
"""
QUESTION 8:

Find the sum of all elements in a list recursively.

Input:

    [1, 2, 3, 4, 5]

Output:

    15
"""

def recursive_sum(numbers, index=0):

    if index == len(numbers):
        return 0

    return numbers[index] + recursive_sum(numbers, index + 1)


numbers = [1, 2, 3, 4, 5]

print(recursive_sum(numbers))

# Output:
# 15


# ============================================================
# 30. PRACTICE QUESTION
# ============================================================
"""
QUESTION 9:

Find the maximum element in a list using recursion.

Input:

    [12, 45, 7, 89, 23]

Output:

    89
"""

def recursive_max(numbers, index=0):

    if index == len(numbers) - 1:
        return numbers[index]

    return max(numbers[index], recursive_max(numbers, index + 1))


numbers = [12, 45, 7, 89, 23]

print(recursive_max(numbers))

# Output:
# 89


# ============================================================
# 31. RECURSION WITHOUT BASE CASE
# ============================================================
"""
Never write recursive functions without a proper stopping
condition.

Example:

    def infinite():
        infinite()

This function will continue calling itself.

Eventually Python raises:

    RecursionError

Python has a recursion depth limit to prevent unlimited
growth of the call stack.
"""

# DO NOT RUN:
#
# def infinite():
#     infinite()
#
# infinite()


# ============================================================
# 32. RECURSION VS ITERATION
# ============================================================
"""
The same problem can often be solved using:

    1. Recursion
    2. Loop / Iteration


Example: factorial
"""

# Iterative version

def factorial_loop(n):

    result = 1

    for i in range(1, n + 1):
        result *= i

    return result


print(factorial_loop(5))

# Output:
# 120


# Recursive version

def factorial_recursive(n):

    if n == 0:
        return 1

    return n * factorial_recursive(n - 1)


print(factorial_recursive(5))

# Output:
# 120


"""
Both produce the same result.

However, recursion uses additional call-stack space.

For many simple problems, an iterative solution can be
more memory-efficient.

Recursion becomes particularly useful when the problem
naturally has recursive structure, such as:

    - Tree traversal
    - Divide and conquer
    - Backtracking
    - Binary search
    - DFS
    - Many mathematical problems
"""


# ============================================================
# 33. IMPORTANT RECURSION TERMINOLOGIES
# ============================================================
"""
RECURSION
    A function calling itself.

RECURSIVE FUNCTION
    A function that calls itself.

BASE CASE
    Condition that stops recursion.

RECURSIVE CASE
    Part where the function calls itself.

RECURSIVE CALL
    The call made by a function to itself.

CALL STACK
    Memory structure that keeps track of active function calls.

STACK FRAME
    Information maintained for an individual function call.

CALLING PHASE
    Phase in which recursive calls are being added to the stack.

RETURNING PHASE
    Phase in which calls finish and are removed from the stack.

RECURSION DEPTH
    Number of active recursive calls at a particular point.

RecursionError
    Error raised when recursion exceeds Python's recursion
    depth limit.
"""


# ============================================================
#                       KEY POINTS
# ============================================================
"""
1. Recursion means a function calls itself.

2. Every recursive solution should normally have a BASE CASE.

3. The recursive case should move the problem toward the
   base case.

4. Example:

       def factorial(n):

           if n == 0:
               return 1

           return n * factorial(n - 1)


5. The CALL STACK stores information about active function
   calls.

6. Every function call creates a stack frame.

7. A recursive function creates multiple stack frames.

8. The stack follows LIFO:

       Last In -> First Out


9. Recursion has two important phases:

       CALLING PHASE
            ↓
       BASE CASE
            ↓
       RETURNING PHASE


10. Code written BEFORE the recursive call executes while
    going deeper into recursion.

11. Code written AFTER the recursive call executes while
    returning from recursion.

12. Example:

       def fun(n):

           if n == 0:
               return

           fun(n - 1)

           print(n)

    Output:

       1
       2
       3
       ...


13. Missing or incorrect base cases can cause RecursionError.

14. Recursion usually requires additional call-stack memory.

15. Recursion is heavily used in DSA.

16. Important recursive problems to practice:

       - Factorial
       - Sum of N numbers
       - Power
       - Fibonacci
       - Sum of digits
       - Count digits
       - Reverse string
       - Palindrome
       - GCD
       - List traversal
       - Maximum/minimum in a list
       - Binary search
       - Tree traversal


------------------------------------------------------------
                    QUICK MEMORY TRICK
------------------------------------------------------------

RECURSION =

    FUNCTION
       ↓
    CALL ITSELF
       ↓
    BASE CASE
       ↓
    RETURN
       ↓
    UNWIND CALL STACK


Think:

    "Break the big problem into a smaller version
     of the SAME problem."


Example:

    factorial(5)

        ↓

    5 × factorial(4)

        ↓

    5 × 4 × factorial(3)

        ↓

    5 × 4 × 3 × factorial(2)

        ↓

    5 × 4 × 3 × 2 × factorial(1)

        ↓

    BASE CASE

        ↓

    RETURN BACK


------------------------------------------------------------
MOST IMPORTANT RULE
------------------------------------------------------------

Every recursive function should answer two questions:

    1. When should I STOP?
       -> BASE CASE

    2. How do I make the problem SMALLER?
       -> RECURSIVE CALL
------------------------------------------------------------
"""