# ============================================================
#                         LISTS IN PYTHON
# ============================================================
"""
A list is a built-in data type in Python used to store multiple
values in a single variable.

A list is:
    - Ordered
    - Mutable
    - Allows duplicate values
    - Allows elements of different data types
    - Indexed
    - Sliceable

Lists are created using square brackets [].

Syntax:

    list_name = [element1, element2, element3]

Example:

    numbers = [10, 20, 30, 40]

A list can contain different types of values:

    data = [10, 3.14, "Python", True]

Each element has an index starting from 0.
"""


# ============================================================
# 1. CREATING A LIST
# ============================================================

numbers = [10, 20, 30, 40, 50]

print(numbers)
print(type(numbers))


# Empty list

empty_list = []

print(empty_list)


# List with different data types

data = [10, 3.14, "Python", True]

print(data)


# ============================================================
# 2. LIST INDEXING
# ============================================================
"""
Lists use zero-based indexing.

Example:

    numbers = [10, 20, 30, 40, 50]

    Index:       0   1   2   3   4
    Value:      10  20  30  40  50

Therefore:

    numbers[0] -> 10
    numbers[2] -> 30
"""

numbers = [10, 20, 30, 40, 50]

print(numbers[0])
print(numbers[2])
print(numbers[4])


# Negative indexing

"""
Negative indexing starts from the end.

    Value:       10   20   30   40   50
    Index:        0    1    2    3    4
    Negative:    -5   -4   -3   -2   -1
"""

print(numbers[-1])       # 50
print(numbers[-2])       # 40


# ============================================================
# 3. LIST VS STRING
# ============================================================
"""
Lists and strings have some similarities.

Both:
    - Are ordered
    - Support indexing
    - Support negative indexing
    - Support slicing
    - Support len()
    - Support membership operators (in / not in)

But there is an important difference:

    STRING -> Immutable
    LIST   -> Mutable

Immutable means that an existing string cannot be changed
character by character.

Mutable means that a list can be changed after creation.
"""

# String

text = "Python"

# This is NOT allowed:
#
# text[0] = "J"


# List

numbers = [10, 20, 30]

numbers[0] = 100

print(numbers)
# [100, 20, 30]


# ============================================================
# 4. LIST CAN STORE DIFFERENT DATA TYPES
# ============================================================
"""
Unlike many programming languages, Python lists can contain
different types of elements in the same list.
"""

data = [
    10,
    3.14,
    "Python",
    True
]

print(data)


# ============================================================
# 5. LIST ALLOWS DUPLICATE VALUES
# ============================================================
"""
A list can contain the same value multiple times.
"""

numbers = [10, 20, 10, 30, 10]

print(numbers)


# ============================================================
# 6. LENGTH OF A LIST
# ============================================================
"""
The len() function returns the number of elements in a list.

Syntax:

    len(list)
"""

numbers = [10, 20, 30, 40, 50]

print(len(numbers))
# 5


# ============================================================
# 7. ACCESSING LIST ELEMENTS
# ============================================================

items = ["Python", "Java", "C++", "JavaScript"]

print(items[0])          # Python
print(items[1])          # Java
print(items[2])          # C++
print(items[-1])         # JavaScript


# ============================================================
# 8. MODIFYING LIST ELEMENTS
# ============================================================
"""
Lists are mutable.

Therefore, individual elements can be changed using indexing.
"""

numbers = [10, 20, 30, 40]

numbers[1] = 200

print(numbers)
# [10, 200, 30, 40]


# ============================================================
# 9. ADDING MULTIPLE ELEMENTS USING INDEXING
# ============================================================
"""
A list element can be replaced with another value.
"""

numbers = [10, 20, 30]

numbers[1] = 25

print(numbers)
# [10, 25, 30]


# ============================================================
# 10. LIST SLICING
# ============================================================
"""
List slicing works similarly to string slicing.

Syntax:

    list[start : stop]

The start index is included.
The stop index is excluded.

Example:

    numbers = [10, 20, 30, 40, 50]

    numbers[1:4]

Result:

    [20, 30, 40]
"""

numbers = [10, 20, 30, 40, 50]

print(numbers[1:4])
# [20, 30, 40]


# ============================================================
# 11. OMITTING START INDEX
# ============================================================
"""
If the start index is omitted, slicing starts from index 0.

    numbers[:4]

is equivalent to:

    numbers[0:4]
"""

numbers = [10, 20, 30, 40, 50]

print(numbers[:4])
# [10, 20, 30, 40]


# ============================================================
# 12. OMITTING END INDEX
# ============================================================
"""
If the end index is omitted, slicing continues until the end.
"""

numbers = [10, 20, 30, 40, 50]

print(numbers[2:])
# [30, 40, 50]


# ============================================================
# 13. COPYING THE COMPLETE LIST USING SLICING
# ============================================================

numbers = [10, 20, 30, 40]

copy_list = numbers[:]

print(copy_list)


# ============================================================
# 14. NEGATIVE INDEX SLICING
# ============================================================
"""
Negative indexes can also be used while slicing.

Example:

    numbers = [10, 20, 30, 40, 50]

    numbers[-3:-1]

Negative indexes:

    10   20   30   40   50
    -5   -4   -3   -2   -1

Result:

    [30, 40]
"""

numbers = [10, 20, 30, 40, 50]

print(numbers[-3:-1])
# [30, 40]


# ============================================================
# 15. LIST SLICING WITH STEP
# ============================================================
"""
Complete slicing syntax:

    list[start : stop : step]

Example:

    numbers[::2]

This takes every second element.
"""

numbers = [10, 20, 30, 40, 50, 60]

print(numbers[::2])
# [10, 30, 50]


# Reverse a list using slicing

print(numbers[::-1])
# [60, 50, 40, 30, 20, 10]


# ============================================================
#                    LIST METHODS
# ============================================================
"""
List methods are functions provided by Python to perform
operations on lists.

Common list methods:

    append()
    extend()
    insert()
    remove()
    pop()
    clear()
    index()
    count()
    sort()
    reverse()
    copy()
"""


# ============================================================
# 16. append()
# ============================================================
"""
append() adds ONE element to the end of a list.

Syntax:

    list.append(element)
"""

numbers = [10, 20, 30]

numbers.append(40)

print(numbers)
# [10, 20, 30, 40]


# append() can add any type of object.

numbers = [10, 20, 30]

numbers.append([40, 50])

print(numbers)
# [10, 20, 30, [40, 50]]


# ============================================================
# 17. extend()
# ============================================================
"""
extend() adds multiple elements to the end of a list.

It takes an iterable as an argument.

Syntax:

    list.extend(iterable)
"""

numbers = [10, 20, 30]

numbers.extend([40, 50, 60])

print(numbers)
# [10, 20, 30, 40, 50, 60]


# ============================================================
# append() VS extend()
# ============================================================
"""
append() adds the entire object as ONE element.

extend() adds the elements individually.

Example:
"""

numbers = [1, 2]

numbers.append([3, 4])

print(numbers)
# [1, 2, [3, 4]]


numbers = [1, 2]

numbers.extend([3, 4])

print(numbers)
# [1, 2, 3, 4]


# ============================================================
# 18. insert()
# ============================================================
"""
insert() adds an element at a specific index.

Syntax:

    list.insert(index, element)
"""

numbers = [10, 20, 40]

numbers.insert(2, 30)

print(numbers)
# [10, 20, 30, 40]


# Insert at beginning

numbers.insert(0, 5)

print(numbers)
# [5, 10, 20, 30, 40]


# ============================================================
# 19. remove()
# ============================================================
"""
remove() removes the FIRST occurrence of a specified value.

Syntax:

    list.remove(value)

If the value does not exist, Python raises ValueError.
"""

numbers = [10, 20, 30, 20, 40]

numbers.remove(20)

print(numbers)
# [10, 30, 20, 40]


# Notice:
# Only the first occurrence of 20 was removed.


# ============================================================
# 20. pop()
# ============================================================
"""
pop() removes and RETURNS an element from the list.

Syntax:

    list.pop(index)

If index is not specified, pop() removes the last element.
"""

numbers = [10, 20, 30, 40]

removed = numbers.pop(2)

print(removed)
# 30

print(numbers)
# [10, 20, 40]


# pop() without an index

numbers = [10, 20, 30]

removed = numbers.pop()

print(removed)
# 30

print(numbers)
# [10, 20]


# ============================================================
# 21. remove() VS pop()
# ============================================================
"""
remove():

    - Removes by VALUE
    - Does not return the removed element

pop():

    - Removes by INDEX
    - Returns the removed element

Example:
"""

numbers = [10, 20, 30, 40]

numbers.remove(20)

print(numbers)
# [10, 30, 40]


numbers = [10, 20, 30, 40]

value = numbers.pop(1)

print(value)
# 20

print(numbers)
# [10, 30, 40]


# ============================================================
# 22. clear()
# ============================================================
"""
clear() removes all elements from the list.

Syntax:

    list.clear()
"""

numbers = [10, 20, 30]

numbers.clear()

print(numbers)
# []


# ============================================================
# 23. index()
# ============================================================
"""
index() returns the index of the FIRST occurrence of a value.

Syntax:

    list.index(value)
"""

numbers = [10, 20, 30, 20, 40]

print(numbers.index(20))
# 1


# ============================================================
# 24. count()
# ============================================================
"""
count() returns the number of times a value occurs in a list.

Syntax:

    list.count(value)
"""

numbers = [10, 20, 10, 30, 10]

print(numbers.count(10))
# 3

print(numbers.count(50))
# 0


# ============================================================
# 25. sort()
# ============================================================
"""
sort() sorts the original list in ascending order by default.

Syntax:

    list.sort()
"""

numbers = [40, 10, 30, 20]

numbers.sort()

print(numbers)
# [10, 20, 30, 40]


# ============================================================
# 26. SORT IN DESCENDING ORDER
# ============================================================
"""
Use reverse=True to sort in descending order.
"""

numbers = [40, 10, 30, 20]

numbers.sort(reverse=True)

print(numbers)
# [40, 30, 20, 10]


# ============================================================
# 27. reverse()
# ============================================================
"""
reverse() reverses the order of elements in the original list.

It does NOT sort the list.

"""

numbers = [10, 20, 30, 40]

numbers.reverse()

print(numbers)
# [40, 30, 20, 10]


# ============================================================
# sort() VS reverse()
# ============================================================
"""
sort():

    Arranges elements according to their values.

reverse():

    Simply reverses the current order.

Example:
"""

numbers = [30, 10, 20]

numbers.sort()

print(numbers)
# [10, 20, 30]


numbers = [30, 10, 20]

numbers.reverse()

print(numbers)
# [20, 10, 30]


# ============================================================
# 28. copy()
# ============================================================
"""
copy() creates a shallow copy of a list.

Syntax:

    new_list = old_list.copy()
"""

numbers = [10, 20, 30]

new_numbers = numbers.copy()

print(new_numbers)


# Changes to the copied list do not change the original
# list for these top-level elements.

new_numbers.append(40)

print(numbers)
# [10, 20, 30]

print(new_numbers)
# [10, 20, 30, 40]


# ============================================================
# 29. LIST ALIASING
# ============================================================
"""
Be careful when using:

    list2 = list1

This does NOT create an independent copy.

Both variables refer to the same list.
"""

list1 = [10, 20, 30]

list2 = list1

list2.append(40)

print(list1)
# [10, 20, 30, 40]

print(list2)
# [10, 20, 30, 40]


# Use copy() when an independent shallow copy is required.

list1 = [10, 20, 30]

list2 = list1.copy()

list2.append(40)

print(list1)
# [10, 20, 30]

print(list2)
# [10, 20, 30, 40]


# ============================================================
# 30. MEMBERSHIP OPERATORS WITH LISTS
# ============================================================
"""
'in' checks whether an element exists in a list.

'not in' checks whether an element does not exist.
"""

numbers = [10, 20, 30, 40]

print(20 in numbers)
# True

print(50 in numbers)
# False

print(50 not in numbers)
# True


# ============================================================
# 31. CONCATENATION OF LISTS
# ============================================================
"""
The + operator can combine two lists.

Both operands must be lists.
"""

list1 = [10, 20, 30]
list2 = [40, 50, 60]

result = list1 + list2

print(result)
# [10, 20, 30, 40, 50, 60]


# ============================================================
# 32. REPETITION OF LIST
# ============================================================
"""
The * operator can repeat a list.
"""

numbers = [1, 2, 3]

print(numbers * 3)
# [1, 2, 3, 1, 2, 3, 1, 2, 3]


# ============================================================
# 33. NESTED LIST
# ============================================================
"""
A list can contain other lists.

This is called a nested list.

Example:

    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
"""

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print(matrix)

print(matrix[0])
# [1, 2, 3]

print(matrix[0][1])
# 2

print(matrix[2][2])
# 9


# ============================================================
# 34. TAKING LIST INPUT
# ============================================================
"""
input() always returns a string.

Therefore, if we want to create a list of integers from
space-separated input, we can use split() and map().

Example input:

    10 20 30 40

Code:

    numbers = list(map(int, input().split()))
"""

numbers = list(map(int, input("Enter numbers: ").split()))

print(numbers)


# ============================================================
# 35. LIST WITH LOOP
# ============================================================
"""
Lists are commonly used with loops to process each element.
"""

numbers = [10, 20, 30, 40]

for number in numbers:
    print(number)


# ============================================================
# 36. USEFUL BUILT-IN FUNCTIONS WITH LISTS
# ============================================================
"""
Some useful built-in functions are:

    len() -> number of elements
    max() -> largest element
    min() -> smallest element
    sum() -> sum of elements
    sorted() -> returns a new sorted list
"""

numbers = [40, 10, 30, 20]

print(len(numbers))
# 4

print(max(numbers))
# 40

print(min(numbers))
# 10

print(sum(numbers))
# 100

print(sorted(numbers))
# [10, 20, 30, 40]


# ============================================================
# 37. sort() VS sorted()
# ============================================================
"""
sort():

    - List method
    - Changes the original list
    - Returns None

sorted():

    - Built-in function
    - Does NOT change the original list
    - Returns a new sorted list
"""

numbers = [30, 10, 20]

result = sorted(numbers)

print(numbers)
# [30, 10, 20]

print(result)
# [10, 20, 30]


numbers = [30, 10, 20]

result = numbers.sort()

print(numbers)
# [10, 20, 30]

print(result)
# None


# ============================================================
#                 LIST METHODS SUMMARY
# ============================================================
"""
+----------------+--------------------------------------------+
| Method         | Purpose                                    |
+----------------+--------------------------------------------+
| append(x)      | Adds x at the end                          |
| extend(x)      | Adds multiple elements                     |
| insert(i, x)   | Inserts x at index i                       |
| remove(x)      | Removes first occurrence of x              |
| pop(i)         | Removes and returns element at index i     |
| pop()          | Removes and returns last element           |
| clear()        | Removes all elements                      |
| index(x)       | Returns first index of x                   |
| count(x)       | Counts occurrences of x                   |
| sort()         | Sorts the list                             |
| reverse()      | Reverses the current order                |
| copy()         | Creates a shallow copy                    |
+----------------+--------------------------------------------+
"""


# ============================================================
#              LIST VS STRING - KEY DIFFERENCES
# ============================================================
"""
+----------------------+----------------------+----------------------+
| Feature              | String               | List                |
+----------------------+----------------------+----------------------+
| Data                 | Characters           | Any Python objects  |
| Syntax               | "Hello"              | [1, 2, 3]           |
| Ordered              | Yes                  | Yes                 |
| Indexed              | Yes                  | Yes                 |
| Sliceable            | Yes                  | Yes                 |
| Mutable              | No                   | Yes                 |
| Duplicates           | Allowed              | Allowed             |
| append()             | No                   | Yes                 |
| remove()             | No                   | Yes                 |
| sort()               | No                   | Yes                 |
+----------------------+----------------------+----------------------+
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. A list is an ordered and mutable collection of elements.

2. Lists are created using square brackets:

       numbers = [10, 20, 30]

3. A list can contain different data types.

4. Lists can contain duplicate values.

5. Python uses zero-based indexing for lists.

6. Negative indexing starts from -1.

7. Lists support slicing:

       list[start:stop]

8. The start index is included and the stop index is excluded.

9. Lists are mutable, so their elements can be changed.

10. append() adds one element to the end.

11. extend() adds multiple elements.

12. insert() adds an element at a specified index.

13. remove() removes the first occurrence of a value.

14. pop() removes an element using its index and returns
    the removed element.

15. clear() removes all elements.

16. index() returns the first index of a value.

17. count() returns the number of occurrences of a value.

18. sort() sorts the original list.

19. reverse() reverses the current order of the list.

20. copy() creates a shallow copy.

21. list1 = list2 creates an alias, not an independent copy.

22. Lists support:
       +  -> concatenation
       *  -> repetition
       in -> membership
       not in -> membership negation

23. Lists can contain other lists, creating nested lists.

24. len(), max(), min(), sum() and sorted() are useful
    built-in functions for working with lists.

25. A major difference between strings and lists is:

       String -> Immutable
       List   -> Mutable
"""