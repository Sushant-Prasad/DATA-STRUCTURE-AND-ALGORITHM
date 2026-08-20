# ============================================================
#                         TUPLES IN PYTHON
# ============================================================
"""
A tuple is a built-in Python data type used to store an
ordered collection of values.

A tuple is:

    - Ordered
    - Immutable
    - Indexed
    - Sliceable
    - Allows duplicate values
    - Can contain different data types

Tuples are generally written using parentheses ().

Syntax:

    tuple_name = (value1, value2, value3)

Example:

    numbers = (10, 20, 30, 40)

The elements of a tuple can be accessed using indexes,
just like strings and lists.
"""


# ============================================================
# 1. CREATING A TUPLE
# ============================================================

numbers = (10, 20, 30, 40)

print(numbers)
print(type(numbers))


# Tuple containing different data types

data = (10, 3.14, "Python", True)

print(data)


# A tuple can contain duplicate values

numbers = (10, 20, 10, 30, 10)

print(numbers)


# ============================================================
# 2. TUPLE WITHOUT PARENTHESES
# ============================================================
"""
Parentheses are not strictly required when creating a tuple.

The comma is what makes the collection a tuple.

Example:

    numbers = 10, 20, 30

Python automatically creates a tuple.
"""

numbers = 10, 20, 30

print(numbers)
print(type(numbers))


# ============================================================
# 3. SINGLE-VALUE TUPLE
# ============================================================
"""
A single-value tuple requires a trailing comma.

Correct:

    tup = (10,)

The comma is important.

Without the comma:

    tup = (10)

Python treats it as an integer, not a tuple.
"""

tup1 = (10,)

print(tup1)
print(type(tup1))


# Without comma

tup2 = (10)

print(tup2)
print(type(tup2))


# Another example

tup3 = ("Python",)

print(tup3)
print(type(tup3))


# ============================================================
# 4. EMPTY TUPLE
# ============================================================
"""
An empty tuple can be created using:

    ()

"""

empty_tuple = ()

print(empty_tuple)
print(type(empty_tuple))


# ============================================================
# 5. TUPLE INDEXING
# ============================================================
"""
Tuples use zero-based indexing.

Example:

    numbers = (10, 20, 30, 40, 50)

    Index:    0   1   2   3   4
    Value:   10  20  30  40  50
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[0])
print(numbers[2])
print(numbers[4])


# Negative indexing

"""
Negative indexes start from the end.

    Value:       10   20   30   40   50
    Index:        0    1    2    3    4
    Negative:    -5   -4   -3   -2   -1
"""

print(numbers[-1])
print(numbers[-2])


# ============================================================
# 6. TUPLE IS IMMUTABLE
# ============================================================
"""
The most important characteristic of a tuple is that it is
immutable.

Immutable means that once a tuple is created, its elements
cannot be changed, added, or removed.

For example:

    numbers[0] = 100

is NOT allowed.

It produces a TypeError.
"""

numbers = (10, 20, 30)

# This is NOT allowed:
#
# numbers[0] = 100


# ============================================================
# 7. TUPLE VS LIST
# ============================================================
"""
Both lists and tuples are ordered collections.

The major difference is mutability.

LIST:
    Mutable
    Can be changed after creation

TUPLE:
    Immutable
    Cannot be changed after creation
"""

# List

numbers_list = [10, 20, 30]

numbers_list[0] = 100

print(numbers_list)
# [100, 20, 30]


# Tuple

numbers_tuple = (10, 20, 30)

# This is NOT allowed:
#
# numbers_tuple[0] = 100


# ============================================================
# 8. LIST VS TUPLE
# ============================================================
"""
+----------------------+----------------------+----------------------+
| Feature              | List                 | Tuple                |
+----------------------+----------------------+----------------------+
| Syntax               | [1, 2, 3]            | (1, 2, 3)            |
| Ordered              | Yes                  | Yes                  |
| Indexed              | Yes                  | Yes                  |
| Sliceable            | Yes                  | Yes                  |
| Mutable              | Yes                  | No                   |
| Duplicate values     | Allowed              | Allowed              |
| Different data types | Allowed              | Allowed              |
| append()             | Available            | Not available        |
| remove()             | Available            | Not available        |
| sort()               | Available            | Not available        |
| index()              | Available            | Available            |
| count()              | Available            | Available            |
+----------------------+----------------------+----------------------+

Use a list when the collection needs to change.

Use a tuple when the collection should remain unchanged.
"""


# ============================================================
# 9. TUPLE SLICING
# ============================================================
"""
Tuple slicing works similarly to string and list slicing.

Syntax:

    tuple[start : stop]

The start index is included.
The stop index is excluded.
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[1:4])
# (20, 30, 40)


# ============================================================
# 10. OMITTING START INDEX
# ============================================================
"""
If the start index is omitted, slicing starts from index 0.

    numbers[:4]

is equivalent to:

    numbers[0:4]
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[:4])
# (10, 20, 30, 40)


# ============================================================
# 11. OMITTING END INDEX
# ============================================================
"""
If the end index is omitted, slicing continues until the
end of the tuple.
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[2:])
# (30, 40, 50)


# ============================================================
# 12. COMPLETE TUPLE USING SLICING
# ============================================================

numbers = (10, 20, 30, 40, 50)

print(numbers[:])
# (10, 20, 30, 40, 50)


# ============================================================
# 13. NEGATIVE INDEX SLICING
# ============================================================
"""
Negative indexes can also be used for tuple slicing.

Example:

    numbers = (10, 20, 30, 40, 50)

    numbers[-3:-1]

Negative indexes:

    10   20   30   40   50
    -5   -4   -3   -2   -1

Result:

    (30, 40)
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[-3:-1])
# (30, 40)


# ============================================================
# 14. TUPLE SLICING WITH STEP
# ============================================================
"""
Complete slicing syntax:

    tuple[start : stop : step]

Example:

    numbers[::2]

This selects every second element.
"""

numbers = (10, 20, 30, 40, 50, 60)

print(numbers[::2])
# (10, 30, 50)


# ============================================================
# 15. REVERSE A TUPLE USING SLICING
# ============================================================
"""
A tuple can be reversed using:

    tuple[::-1]
"""

numbers = (10, 20, 30, 40, 50)

print(numbers[::-1])
# (50, 40, 30, 20, 10)


# ============================================================
# 16. TUPLE LENGTH
# ============================================================
"""
len() returns the number of elements in a tuple.
"""

numbers = (10, 20, 30, 40)

print(len(numbers))
# 4


# ============================================================
# 17. MEMBERSHIP OPERATORS
# ============================================================
"""
The 'in' and 'not in' operators can be used with tuples.
"""

numbers = (10, 20, 30, 40)

print(20 in numbers)
# True

print(50 in numbers)
# False

print(50 not in numbers)
# True


# ============================================================
# 18. TUPLE CONCATENATION
# ============================================================
"""
The + operator combines two tuples.

The result is a NEW tuple.
"""

tuple1 = (10, 20, 30)
tuple2 = (40, 50, 60)

result = tuple1 + tuple2

print(result)
# (10, 20, 30, 40, 50, 60)


# ============================================================
# 19. TUPLE REPETITION
# ============================================================
"""
The * operator repeats a tuple.
"""

numbers = (1, 2, 3)

print(numbers * 3)
# (1, 2, 3, 1, 2, 3, 1, 2, 3)


# ============================================================
# 20. TUPLE UNPACKING
# ============================================================
"""
Tuple unpacking allows us to assign tuple elements to
multiple variables.

The number of variables must normally match the number
of values.
"""

numbers = (10, 20, 30)

a, b, c = numbers

print(a)
print(b)
print(c)


# ============================================================
# 21. EXTENDED UNPACKING
# ============================================================
"""
The * operator can be used during unpacking to collect
multiple remaining elements into a list.
"""

numbers = (10, 20, 30, 40, 50)

a, *b, c = numbers

print(a)
# 10

print(b)
# [20, 30, 40]

print(c)
# 50


# ============================================================
# 22. NESTED TUPLES
# ============================================================
"""
A tuple can contain other tuples.

This is called a nested tuple.
"""

data = (
    (10, 20),
    (30, 40),
    (50, 60)
)

print(data)

print(data[0])
# (10, 20)

print(data[0][1])
# 20


# ============================================================
#                    TUPLE METHODS
# ============================================================
"""
Tuples have only two main built-in methods:

    1. count()
    2. index()

Because tuples are immutable, methods such as append(),
remove(), pop(), sort(), and reverse() are not available.
"""


# ============================================================
# 23. count()
# ============================================================
"""
count() returns the number of times a specified value occurs
in the tuple.

Syntax:

    tuple.count(value)
"""

numbers = (10, 20, 10, 30, 10)

print(numbers.count(10))
# 3

print(numbers.count(20))
# 1

print(numbers.count(50))
# 0


# ============================================================
# 24. index()
# ============================================================
"""
index() returns the index of the FIRST occurrence of a value.

Syntax:

    tuple.index(value)
"""

numbers = (10, 20, 30, 20, 40)

print(numbers.index(20))
# 1


# ============================================================
# 25. index() WITH DUPLICATE VALUES
# ============================================================
"""
If a value occurs multiple times, index() returns the position
of the FIRST occurrence.
"""

numbers = (10, 20, 30, 20, 40, 20)

print(numbers.index(20))
# 1


# ============================================================
# 26. index() WITH START POSITION
# ============================================================
"""
index() can optionally accept a start position.

Syntax:

    tuple.index(value, start)

This searches for the value starting from the given index.
"""

numbers = (10, 20, 30, 20, 40)

print(numbers.index(20, 2))
# 3


# ============================================================
# 27. index() WITH START AND END
# ============================================================
"""
Syntax:

    tuple.index(value, start, end)

The search is performed from start up to, but not including,
end.
"""

numbers = (10, 20, 30, 20, 40)

print(numbers.index(20, 2, 5))
# 3


# ============================================================
# 28. count() AND index() TOGETHER
# ============================================================

numbers = (10, 20, 10, 30, 10, 40)

print(numbers.count(10))
# 3

print(numbers.index(10))
# 0


# ============================================================
# 29. BUILT-IN FUNCTIONS WITH TUPLES
# ============================================================
"""
Although tuples have only two methods, many built-in Python
functions can be used with them.
"""

numbers = (10, 20, 30, 40, 50)

print(len(numbers))
# 5

print(max(numbers))
# 50

print(min(numbers))
# 10

print(sum(numbers))
# 150


# ============================================================
# 30. sorted() WITH TUPLES
# ============================================================
"""
sorted() can be used with a tuple.

IMPORTANT:

    sorted() returns a LIST, not a tuple.
"""

numbers = (40, 10, 30, 20)

result = sorted(numbers)

print(result)
# [10, 20, 30, 40]

print(type(result))
# <class 'list'>


# ============================================================
# 31. CONVERTING LIST TO TUPLE
# ============================================================
"""
The tuple() function can convert an iterable into a tuple.
"""

numbers = [10, 20, 30, 40]

numbers_tuple = tuple(numbers)

print(numbers_tuple)
# (10, 20, 30, 40)


# ============================================================
# 32. CONVERTING TUPLE TO LIST
# ============================================================
"""
The list() function can convert a tuple into a list.

This is useful when we need to modify the data.
"""

numbers = (10, 20, 30, 40)

numbers_list = list(numbers)

numbers_list.append(50)

print(numbers_list)
# [10, 20, 30, 40, 50]


# ============================================================
# 33. MODIFYING A TUPLE INDIRECTLY
# ============================================================
"""
A tuple itself cannot be modified.

However, we can:

    1. Convert the tuple to a list.
    2. Modify the list.
    3. Convert it back to a tuple.
"""

numbers = (10, 20, 30)

numbers_list = list(numbers)

numbers_list[1] = 200

numbers = tuple(numbers_list)

print(numbers)
# (10, 200, 30)


# ============================================================
# 34. IMPORTANT: TUPLE CAN CONTAIN MUTABLE OBJECTS
# ============================================================
"""
A tuple is immutable, but it can contain mutable objects such
as lists.

The tuple cannot replace the list object itself, but the
list inside the tuple can still be modified.
"""

data = ([10, 20], 30)

data[0].append(40)

print(data)
# ([10, 20, 40], 30)

"""
The tuple structure has not changed.

The first element is still the same list object, but the
contents of that list changed.
"""


# ============================================================
# 35. TUPLE VS STRING
# ============================================================
"""
Strings and tuples are both immutable and ordered sequences.

String:
    A sequence of characters.

Tuple:
    A sequence of arbitrary Python objects.

Example:

    text = "Python"

    numbers = (10, 20, 30)
"""

text = "Python"
numbers = (10, 20, 30)

print(text[0])
# P

print(numbers[0])
# 10


# ============================================================
# 36. TUPLE VS LIST VS STRING
# ============================================================
"""
+----------------------+------------------+------------------+------------------+
| Feature              | String           | List            | Tuple            |
+----------------------+------------------+------------------+------------------+
| Ordered              | Yes              | Yes             | Yes              |
| Indexed              | Yes              | Yes             | Yes              |
| Sliceable            | Yes              | Yes             | Yes              |
| Mutable              | No               | Yes             | No               |
| Duplicates           | Allowed          | Allowed         | Allowed          |
| Different data types | No*              | Yes             | Yes              |
| append()             | No               | Yes             | No               |
| remove()             | No               | Yes             | No               |
| sort()               | No               | Yes             | No               |
| count()              | Yes              | Yes             | Yes              |
| index()              | Yes              | Yes             | Yes              |
+----------------------+------------------+------------------+------------------+

* A string stores characters. Numeric values can appear as
  characters, but they are still characters.
"""


# ============================================================
# 37. WHEN TO USE A TUPLE
# ============================================================
"""
Tuples are useful when data should remain unchanged.

Examples:

    - Coordinates
    - RGB color values
    - Fixed configuration values
    - Database records
    - Returning multiple values from a function

Example:

    coordinates = (10, 20)

The coordinates should generally remain fixed.
"""

coordinates = (10, 20)

print(coordinates)


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. A tuple is an ordered collection of values.

2. Tuples are generally written using parentheses:

       numbers = (10, 20, 30)

3. Tuples are immutable.

4. Individual tuple elements cannot be changed.

5. Tuples support zero-based indexing.

6. Negative indexing is supported.

7. Tuples support slicing:

       tuple[start:stop]

8. The start index is included and the stop index is excluded.

9. Tuples support step:

       tuple[start:stop:step]

10. A tuple can be reversed using:

       tuple[::-1]

11. A single-value tuple requires a trailing comma:

       tup = (10,)

12. This is NOT a tuple:

       tup = (10)

    It is an integer.

13. An empty tuple is:

       ()

14. Tuples can contain duplicate values.

15. Tuples can contain different data types.

16. Tuples support:
       +       -> concatenation
       *       -> repetition
       in      -> membership
       not in  -> membership negation

17. Tuple unpacking allows multiple variables to receive
    tuple values.

18. A tuple can contain another tuple or a list.

19. Tuples have two main methods:

       count()
       index()

20. count() returns the number of occurrences of a value.

21. index() returns the index of the first occurrence.

22. index() can also accept start and end positions.

23. sorted(tuple) returns a LIST, not a tuple.

24. list(tuple) converts a tuple into a list.

25. tuple(list) converts a list into a tuple.

26. Use a list when data needs to be modified.

27. Use a tuple when data should remain unchanged.

28. The biggest difference between list and tuple is:

       List  -> Mutable
       Tuple -> Immutable
"""