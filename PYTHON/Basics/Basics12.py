# ============================================================
#                 TAKING LIST INPUT IN PYTHON
# ============================================================
"""
There is no direct input() function that automatically returns
a list.

The input() function ALWAYS returns a string.

Therefore, to take a list as input, we usually:

    1. Take input using input()
    2. Split the input into separate values
    3. Convert the values to the required data type
    4. Store them in a list

The most common approach is:

    list(map(int, input().split()))

For example, if the user enters:

    10 20 30 40 50

Then:

    input()
        ↓
    "10 20 30 40 50"

    split()
        ↓
    ["10", "20", "30", "40", "50"]

    map(int, ...)
        ↓
    10, 20, 30, 40, 50

    list(...)
        ↓
    [10, 20, 30, 40, 50]
"""


# ============================================================
# 1. TAKING A LIST OF STRINGS
# ============================================================
"""
If we want to take strings as input, we can use split().

Example input:

    apple banana orange

Code:

    fruits = input().split()

Result:

    ["apple", "banana", "orange"]
"""

fruits = input("Enter fruits: ").split()

print(fruits)


# ============================================================
# 2. WHY split() IS REQUIRED
# ============================================================
"""
Suppose the user enters:

    apple banana orange

Using only input():

    fruits = input()

The result is ONE string:

    "apple banana orange"

Python does not automatically know that we want three
separate elements.

split() separates the string based on whitespace.

"""

fruits = input("Enter fruits: ")

print(fruits)
print(type(fruits))
# <class 'str'>


# If we use split():

fruits = input("Enter fruits: ").split()

print(fruits)
print(type(fruits))
# <class 'list'>


# ============================================================
# 3. TAKING A LIST OF INTEGERS
# ============================================================
"""
The input obtained using input() is always a string.

Therefore:

    input().split()

produces strings.

Example:

    Input:
        10 20 30

    input().split()
        -> ["10", "20", "30"]

These are strings, not integers.

We use map(int, ...) to convert them to integers.

    map(int, input().split())

Then list() converts the result into a list.
"""

numbers = list(map(int, input("Enter numbers: ").split()))

print(numbers)
print(type(numbers))


# Example input:
# 10 20 30 40 50

# Output:
# [10, 20, 30, 40, 50]


# ============================================================
# 4. UNDERSTANDING THE COMPLETE EXPRESSION
# ============================================================
"""
Consider:

    numbers = list(map(int, input().split()))

Let's understand it from inside to outside.

Step 1:

    input()

User enters:

    10 20 30

Result:

    "10 20 30"


Step 2:

    input().split()

Result:

    ["10", "20", "30"]


Step 3:

    map(int, input().split())

Converts each string into an integer:

    10
    20
    30


Step 4:

    list(map(int, input().split()))

Creates:

    [10, 20, 30]
"""


# ============================================================
# 5. TAKING FLOAT VALUES
# ============================================================
"""
For floating-point numbers, use float instead of int.

Example input:

    10.5 20.2 30.7

Code:

    numbers = list(map(float, input().split()))
"""

numbers = list(map(float, input("Enter decimal numbers: ").split()))

print(numbers)


# ============================================================
# 6. TAKING A LIST OF WORDS
# ============================================================
"""
For strings, int() or float() is not required.

Example:

    Input:
        Python Java C++

    Result:
        ["Python", "Java", "C++"]
"""

languages = input("Enter languages: ").split()

print(languages)


# ============================================================
# 7. CUSTOM SEPARATOR
# ============================================================
"""
split() can accept a separator.

Example input:

    10,20,30,40

Here values are separated by commas.

Use:

    split(",")

instead of:

    split()
"""

numbers = list(map(int, input("Enter numbers: ").split(",")))

print(numbers)

# Input:
# 10,20,30,40

# Output:
# [10, 20, 30, 40]


# ============================================================
# 8. INPUT SEPARATED BY COMMAS
# ============================================================
"""
Example:

    Input:
        apple,banana,orange

Code:

    fruits = input().split(",")
"""

fruits = input("Enter fruits: ").split(",")

print(fruits)


# ============================================================
# 9. TAKING LIST INPUT USING A LOOP
# ============================================================
"""
Another method is to ask the user for the number of elements
and then take each element separately.

Example:

    Number of elements = 5

Then ask:

    Enter element 1:
    Enter element 2:
    ...

This approach is useful when each value needs to be entered
separately.
"""

n = int(input("Enter number of elements: "))

numbers = []

for i in range(n):
    value = int(input("Enter element: "))
    numbers.append(value)

print(numbers)


# ============================================================
# 10. LOOP METHOD WITH INDEX
# ============================================================
"""
We can also display the element number while taking input.
"""

n = int(input("Enter number of elements: "))

numbers = []

for i in range(n):
    value = int(input(f"Enter element {i + 1}: "))
    numbers.append(value)

print(numbers)


# ============================================================
# 11. LIST INPUT USING list() ONLY
# ============================================================
"""
Be careful:

    list(input())

does NOT take space-separated values as a normal list
of numbers.

Example:

    input:
        12345

    list(input())

gives:

    ['1', '2', '3', '4', '5']

Each character becomes an element.
"""

text = input("Enter a value: ")

characters = list(text)

print(characters)


# ============================================================
# 12. list(input().split())
# ============================================================
"""
For space-separated strings:

    list(input().split())

works, but list() is unnecessary because split() already
returns a list.

Therefore:

    input().split()

is enough.
"""

words = input("Enter words: ").split()

print(words)


# ============================================================
# 13. map() EXPLAINED
# ============================================================
"""
map() applies a function to every element of an iterable.

Syntax:

    map(function, iterable)

Example:

    values = ["10", "20", "30"]

    map(int, values)

converts:

    "10" -> 10
    "20" -> 20
    "30" -> 30

In Python 3, map() returns a map object.

Therefore, we usually convert it into a list:

    list(map(int, values))
"""

values = ["10", "20", "30"]

numbers = list(map(int, values))

print(numbers)
# [10, 20, 30]


# ============================================================
# 14. COMMON FORMULA FOR INTEGER LIST INPUT
# ============================================================
"""
The most important pattern to remember is:

    numbers = list(map(int, input().split()))

Use this when:

    - Input contains multiple integers
    - Values are separated by spaces
    - You want the values in a list

Example:

    Input:
        5 10 15 20

Result:

    [5, 10, 15, 20]
"""

numbers = list(map(int, input("Enter integers: ").split()))

print(numbers)


# ============================================================
# 15. COMMON FORMULA FOR FLOAT LIST INPUT
# ============================================================
"""
For floating-point values:

    numbers = list(map(float, input().split()))
"""

numbers = list(map(float, input("Enter decimal values: ").split()))

print(numbers)


# ============================================================
# 16. STRING LIST INPUT
# ============================================================
"""
For strings:

    words = input().split()

Example:

    Input:
        apple banana mango

Result:

    ["apple", "banana", "mango"]
"""

words = input("Enter words: ").split()

print(words)


# ============================================================
# 17. TAKING LIST INPUT WITH n ELEMENTS
# ============================================================
"""
Suppose the problem gives:

    First line:
        n

    Second line:
        n integers

Example:

    5
    10 20 30 40 50

Code:
"""

n = int(input("Enter number of elements: "))

numbers = list(map(int, input("Enter elements: ").split()))

print(numbers)


# ============================================================
# 18. VALIDATING THE NUMBER OF ELEMENTS
# ============================================================
"""
If the problem requires exactly n elements, we can check
whether the number of values entered is equal to n.
"""

n = int(input("Enter number of elements: "))

numbers = list(map(int, input("Enter elements: ").split()))

if len(numbers) == n:
    print("Valid input")
else:
    print("Invalid number of elements")


# ============================================================
# 19. TAKING TWO LISTS AS INPUT
# ============================================================
"""
We can take multiple lists independently.

Example:

    First list:
        10 20 30

    Second list:
        40 50 60
"""

list1 = list(map(int, input("Enter first list: ").split()))
list2 = list(map(int, input("Enter second list: ").split()))

print(list1)
print(list2)


# ============================================================
# 20. TAKING A LIST AND PROCESSING IT
# ============================================================
"""
Once the list is created, we can perform normal list
operations on it.
"""

numbers = list(map(int, input("Enter numbers: ").split()))

print("List:", numbers)
print("Length:", len(numbers))
print("Maximum:", max(numbers))
print("Minimum:", min(numbers))
print("Sum:", sum(numbers))


# ============================================================
# 21. FIND EVEN NUMBERS FROM INPUT LIST
# ============================================================

numbers = list(map(int, input("Enter numbers: ").split()))

even_numbers = []

for number in numbers:
    if number % 2 == 0:
        even_numbers.append(number)

print(even_numbers)


# ============================================================
# 22. FIND ODD NUMBERS FROM INPUT LIST
# ============================================================

numbers = list(map(int, input("Enter numbers: ").split()))

odd_numbers = []

for number in numbers:
    if number % 2 != 0:
        odd_numbers.append(number)

print(odd_numbers)


# ============================================================
# 23. LIST INPUT WITH NEGATIVE NUMBERS
# ============================================================
"""
Negative numbers work normally with map(int, ...).

Example:

    Input:
        -10 20 -30 40
"""

numbers = list(map(int, input("Enter numbers: ").split()))

print(numbers)


# ============================================================
# 24. LIST INPUT WITH DUPLICATE VALUES
# ============================================================
"""
Lists allow duplicate values.
"""

numbers = list(map(int, input("Enter numbers: ").split()))

print(numbers)


# Example:
# Input:
# 10 20 10 30 10
#
# Output:
# [10, 20, 10, 30, 10]


# ============================================================
# 25. LIST INPUT WITH ZERO
# ============================================================

numbers = list(map(int, input("Enter numbers: ").split()))

print(numbers)


# ============================================================
# 26. INPUT USING COMMA SEPARATOR
# ============================================================
"""
For input:

    10,20,30,40

Use:

    split(",")

"""

numbers = list(map(int, input("Enter numbers: ").split(",")))

print(numbers)


# ============================================================
# 27. INPUT USING SEMICOLON SEPARATOR
# ============================================================

numbers = list(map(int, input("Enter numbers: ").split(";")))

print(numbers)


# ============================================================
# 28. LIST INPUT WITH A LOOP VS split()
# ============================================================
"""
Method 1: Space-separated input

    numbers = list(map(int, input().split()))

Best when all values are entered on one line.

Example:

    10 20 30 40 50


Method 2: Loop input

    n = int(input())

    numbers = []

    for i in range(n):
        numbers.append(int(input()))

Best when every value is entered separately.

Example:

    10
    20
    30
    40
    50
"""


# ============================================================
# 29. IMPORTANT DIFFERENCE
# ============================================================
"""
Consider:

    input()
    input().split()
    list(map(int, input().split()))

They produce different results.

Input:

    10 20 30

------------------------------------------------------------

input()

Result:

    "10 20 30"

Type:

    str

------------------------------------------------------------

input().split()

Result:

    ["10", "20", "30"]

Type:

    list[str]

------------------------------------------------------------

list(map(int, input().split()))

Result:

    [10, 20, 30]

Type:

    list[int]
"""


# ============================================================
# 30. MOST IMPORTANT PATTERNS TO REMEMBER
# ============================================================
"""
1. List of strings:

       words = input().split()


2. List of integers:

       numbers = list(map(int, input().split()))


3. List of floats:

       numbers = list(map(float, input().split()))


4. Comma-separated integers:

       numbers = list(map(int, input().split(",")))


5. Input one element at a time:

       n = int(input())

       numbers = []

       for i in range(n):
           numbers.append(int(input()))
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. input() ALWAYS returns a string.

2. input() does not automatically create a list.

3. split() separates a string into multiple parts and returns
   a list of strings.

4. For space-separated string input:

       words = input().split()

5. For space-separated integer input:

       numbers = list(map(int, input().split()))

6. For floating-point input:

       numbers = list(map(float, input().split()))

7. map() applies a conversion function to every element.

8. list() converts the map object into a list.

9. For comma-separated input:

       numbers = list(map(int, input().split(",")))

10. If each element is entered separately, use a loop with
    append().

11. The most commonly used competitive-programming pattern is:

       numbers = list(map(int, input().split()))

12. Remember the conversion flow:

       input()
          ↓
       string
          ↓
       split()
          ↓
       list of strings
          ↓
       map(int, ...)
          ↓
       integers
          ↓
       list(...)
          ↓
       list of integers
"""