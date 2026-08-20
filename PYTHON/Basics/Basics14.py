# ============================================================
#                     SET IN PYTHON
# ============================================================
"""
A SET is a built-in Python data type used to store a collection
of UNIQUE and UNORDERED elements.

Syntax:

    set_name = {element1, element2, element3}

Example:

    numbers = {10, 20, 30, 40}


IMPORTANT PROPERTIES OF SET:

1. A set stores UNIQUE elements.
   Duplicate elements are automatically removed.

2. A set is UNORDERED.
   Therefore, we should not depend on the order in which
   elements are displayed.

3. A set is MUTABLE.
   We can add or remove elements from a set.

4. Elements INSIDE a set must be HASHABLE.
   Therefore, immutable types such as int, float, str and
   tuple can generally be stored in a set.

5. Mutable objects such as list, dictionary and set cannot
   be elements of another set.

6. A set does NOT support indexing.

7. A set does NOT support slicing.

8. Sets are very useful for:
       - Removing duplicates
       - Membership testing
       - Union
       - Intersection
       - Difference
       - Finding common elements
       - Finding unique elements

9. Sets are commonly used in DSA when we need fast
   membership checking and duplicate removal.
"""


# ============================================================
# 1. CREATING A SET
# ============================================================
"""
A set is normally created using curly braces {}.

Example:
"""

numbers = {10, 20, 30, 40}

print(numbers)
# Output: {10, 20, 30, 40}


print(type(numbers))
# Output: <class 'set'>


# ============================================================
# 2. DUPLICATE ELEMENTS IN A SET
# ============================================================
"""
A set stores each element only once.

If duplicate elements are provided, Python automatically
removes the duplicates.
"""

numbers = {10, 20, 10, 30, 20, 10}

print(numbers)
# Output: {10, 20, 30}

"""
The exact display order of a set should NOT be relied upon
because sets are unordered.
"""


# ============================================================
# 3. SET CAN CONTAIN DIFFERENT DATA TYPES
# ============================================================
"""
A set can contain elements of different hashable data types.
"""

data = {
    10,
    3.14,
    "Python",
    True,
    (1, 2, 3)
}

print(data)
# Output: Order may vary


# ============================================================
# 4. EMPTY SET
# ============================================================
"""
IMPORTANT:

    {} creates an EMPTY DICTIONARY, NOT an empty set.

To create an empty set, use:

    set()
"""

data = {}

print(type(data))
# Output: <class 'dict'>


data = set()

print(data)
# Output: set()

print(type(data))
# Output: <class 'set'>


# ============================================================
# 5. SET DOES NOT SUPPORT INDEXING
# ============================================================
"""
Lists support indexing:

    numbers[0]

Sets do NOT support indexing because they are unordered.

The following code produces a TypeError:

    numbers[0]
"""

numbers = {10, 20, 30, 40}

# print(numbers[0])
# Output: TypeError: 'set' object is not subscriptable


# ============================================================
# 6. SET DOES NOT SUPPORT SLICING
# ============================================================
"""
Since sets do not have indexes, slicing is also not supported.

Example:

    numbers[1:3]

This will produce a TypeError.
"""

numbers = {10, 20, 30, 40}

# print(numbers[1:3])
# Output: TypeError: 'set' object is not subscriptable


# ============================================================
# 7. SET IS MUTABLE
# ============================================================
"""
A set itself is mutable.

We can add and remove elements after creating the set.
"""

numbers = {10, 20, 30}

numbers.add(40)

print(numbers)
# Output: {10, 20, 30, 40}


# ============================================================
# 8. SET ELEMENTS MUST BE HASHABLE
# ============================================================
"""
The elements stored inside a set must be hashable.

Common valid elements:

    int
    float
    str
    tuple

Mutable objects such as:

    list
    dictionary
    set

cannot normally be stored directly inside a set.
"""

data = {
    10,
    3.14,
    "Python",
    (1, 2)
}

print(data)
# Output: Order may vary


# ============================================================
# 9. INVALID SET ELEMENT
# ============================================================
"""
A list is mutable, so it cannot be used as an element of
a set.

The following code produces:

    TypeError: unhashable type: 'list'
"""

# data = {[1, 2, 3]}


# ============================================================
# 10. ADDING AN ELEMENT - add()
# ============================================================
"""
Syntax:

    set_name.add(element)

add() inserts one element into the set.

If the element already exists, the set remains unchanged.
"""

numbers = {10, 20, 30}

numbers.add(40)

print(numbers)
# Output: {10, 20, 30, 40}


numbers.add(20)

print(numbers)
# Output: {10, 20, 30, 40}


# ============================================================
# 11. ADDING MULTIPLE ELEMENTS - update()
# ============================================================
"""
Although add() adds ONE element, update() can add multiple
elements.

Syntax:

    set_name.update(iterable)

The iterable can be a list, tuple, another set, etc.
"""

numbers = {10, 20, 30}

numbers.update([40, 50, 60])

print(numbers)
# Output: {10, 20, 30, 40, 50, 60}


# ============================================================
# 12. update() WITH ANOTHER SET
# ============================================================

set1 = {10, 20, 30}
set2 = {30, 40, 50}

set1.update(set2)

print(set1)
# Output: {10, 20, 30, 40, 50}


# ============================================================
# 13. REMOVE AN ELEMENT - remove()
# ============================================================
"""
Syntax:

    set_name.remove(element)

remove() removes the specified element.

IMPORTANT:

If the element does not exist, remove() raises:

    KeyError
"""

numbers = {10, 20, 30, 40}

numbers.remove(30)

print(numbers)
# Output: {10, 20, 40}


# ============================================================
# 14. remove() WITH A MISSING ELEMENT
# ============================================================
"""
The following code raises KeyError because 50 is not present.
"""

numbers = {10, 20, 30}

# numbers.remove(50)
# Output: KeyError: 50


# ============================================================
# 15. discard() METHOD
# ============================================================
"""
discard() also removes an element.

The major difference between remove() and discard():

    remove():
        Raises KeyError if element is absent.

    discard():
        Does NOT raise an error if element is absent.
"""

numbers = {10, 20, 30}

numbers.discard(20)

print(numbers)
# Output: {10, 30}


numbers.discard(50)

print(numbers)
# Output: {10, 30}


# ============================================================
# 16. remove() VS discard()
# ============================================================
"""
remove(element)
    -> removes element
    -> KeyError if element does not exist

discard(element)
    -> removes element
    -> does nothing if element does not exist
"""


# ============================================================
# 17. pop() METHOD
# ============================================================
"""
pop() removes and returns an arbitrary element from a set.

IMPORTANT:

Since sets are unordered, we should NOT assume which element
will be removed.

Syntax:

    set_name.pop()
"""

numbers = {10, 20, 30, 40}

removed = numbers.pop()

print(removed)
# Output: An arbitrary element from the set

print(numbers)
# Output: Remaining elements


# ============================================================
# 18. clear() METHOD
# ============================================================
"""
clear() removes all elements from the set.

The set itself still exists.
"""

numbers = {10, 20, 30, 40}

numbers.clear()

print(numbers)
# Output: set()


# ============================================================
# 19. len() WITH SET
# ============================================================
"""
len() returns the number of UNIQUE elements in a set.
"""

numbers = {10, 20, 20, 30, 30, 30}

print(len(numbers))
# Output: 3


# ============================================================
# 20. MEMBERSHIP OPERATOR - in
# ============================================================
"""
The 'in' operator checks whether an element exists in the set.

The result is True or False.

Set membership checking is one of the most important uses
of sets.
"""

numbers = {10, 20, 30, 40}

print(20 in numbers)
# Output: True

print(50 in numbers)
# Output: False


# ============================================================
# 21. not in
# ============================================================

numbers = {10, 20, 30, 40}

print(50 not in numbers)
# Output: True

print(20 not in numbers)
# Output: False


# ============================================================
# 22. LOOPING THROUGH A SET
# ============================================================
"""
We can use a for loop to visit every element.

The order of traversal should not be assumed.
"""

numbers = {10, 20, 30, 40}

for number in numbers:
    print(number)

# Output:
# Order may vary


# ============================================================
# 23. UNION
# ============================================================
"""
UNION combines ALL UNIQUE elements from two or more sets.

Example:

    A = {1, 2, 3}
    B = {3, 4, 5}

Union:

    {1, 2, 3, 4, 5}

Syntax:

    A.union(B)

Operator:

    A | B
"""

A = {1, 2, 3}
B = {3, 4, 5}

result = A.union(B)

print(result)
# Output: {1, 2, 3, 4, 5}


# ============================================================
# 24. UNION USING | OPERATOR
# ============================================================

A = {1, 2, 3}
B = {3, 4, 5}

result = A | B

print(result)
# Output: {1, 2, 3, 4, 5}


# ============================================================
# 25. UNION DOES NOT MODIFY ORIGINAL SETS
# ============================================================
"""
union() returns a NEW set.

The original sets remain unchanged.
"""

A = {1, 2, 3}
B = {3, 4, 5}

C = A.union(B)

print(A)
# Output: {1, 2, 3}

print(B)
# Output: {3, 4, 5}

print(C)
# Output: {1, 2, 3, 4, 5}


# ============================================================
# 26. update() VS union()
# ============================================================
"""
union():

    A.union(B)

    -> returns a NEW set
    -> A remains unchanged

update():

    A.update(B)

    -> modifies A
    -> no new set is required
"""

A = {1, 2, 3}
B = {3, 4, 5}

C = A.union(B)

print(A)
# Output: {1, 2, 3}

print(C)
# Output: {1, 2, 3, 4, 5}


A = {1, 2, 3}
A.update(B)

print(A)
# Output: {1, 2, 3, 4, 5}


# ============================================================
# 27. INTERSECTION
# ============================================================
"""
INTERSECTION returns elements that are COMMON to both sets.

Example:

    A = {1, 2, 3}
    B = {3, 4, 5}

Common element:

    {3}

Syntax:

    A.intersection(B)

Operator:

    A & B
"""

A = {1, 2, 3}
B = {3, 4, 5}

result = A.intersection(B)

print(result)
# Output: {3}


# ============================================================
# 28. INTERSECTION USING & OPERATOR
# ============================================================

A = {1, 2, 3}
B = {3, 4, 5}

result = A & B

print(result)
# Output: {3}


# ============================================================
# 29. DIFFERENCE
# ============================================================
"""
A.difference(B) returns elements that are present in A
but NOT present in B.

Example:

    A = {1, 2, 3}
    B = {3, 4, 5}

A - B:

    {1, 2}

Syntax:

    A.difference(B)

Operator:

    A - B
"""

A = {1, 2, 3}
B = {3, 4, 5}

print(A.difference(B))
# Output: {1, 2}


print(A - B)
# Output: {1, 2}


# ============================================================
# 30. REVERSE DIFFERENCE
# ============================================================
"""
B.difference(A) gives elements present in B but not in A.
"""

A = {1, 2, 3}
B = {3, 4, 5}

print(B - A)
# Output: {4, 5}


# ============================================================
# 31. SYMMETRIC DIFFERENCE
# ============================================================
"""
Symmetric difference returns elements that are present in
exactly ONE of the two sets.

It removes the common elements.

Example:

    A = {1, 2, 3}
    B = {3, 4, 5}

Result:

    {1, 2, 4, 5}

Syntax:

    A.symmetric_difference(B)

Operator:

    A ^ B
"""

A = {1, 2, 3}
B = {3, 4, 5}

print(A.symmetric_difference(B))
# Output: {1, 2, 4, 5}


print(A ^ B)
# Output: {1, 2, 4, 5}


# ============================================================
# 32. issubset()
# ============================================================
"""
A set A is a SUBSET of B if every element of A is also
present in B.

Example:

    A = {1, 2}
    B = {1, 2, 3, 4}

Therefore:

    A is a subset of B.
"""

A = {1, 2}
B = {1, 2, 3, 4}

print(A.issubset(B))
# Output: True

print(A <= B)
# Output: True


# ============================================================
# 33. issuperset()
# ============================================================
"""
A set A is a SUPERSET of B if A contains every element
of B.
"""

A = {1, 2, 3, 4}
B = {1, 2}

print(A.issuperset(B))
# Output: True

print(A >= B)
# Output: True


# ============================================================
# 34. isdisjoint()
# ============================================================
"""
Two sets are DISJOINT if they have NO common elements.

Example:

    A = {1, 2}
    B = {3, 4}

There is no common element.

Therefore, they are disjoint.
"""

A = {1, 2}
B = {3, 4}

print(A.isdisjoint(B))
# Output: True


A = {1, 2}
B = {2, 3}

print(A.isdisjoint(B))
# Output: False


# ============================================================
# 35. SET DIFFERENCE UPDATE
# ============================================================
"""
difference_update() removes all elements from A that are
also present in B.

It modifies the original set.

Example:

    A = {1, 2, 3}
    B = {2, 3, 4}

After:

    A.difference_update(B)

A becomes:

    {1}
"""

A = {1, 2, 3}
B = {2, 3, 4}

A.difference_update(B)

print(A)
# Output: {1}


# ============================================================
# 36. INTERSECTION UPDATE
# ============================================================
"""
intersection_update() keeps only the elements that are
common between the two sets.

It modifies the original set.
"""

A = {1, 2, 3}
B = {2, 3, 4}

A.intersection_update(B)

print(A)
# Output: {2, 3}


# ============================================================
# 37. SYMMETRIC DIFFERENCE UPDATE
# ============================================================
"""
symmetric_difference_update() replaces the original set
with its symmetric difference with another set.
"""

A = {1, 2, 3}
B = {3, 4, 5}

A.symmetric_difference_update(B)

print(A)
# Output: {1, 2, 4, 5}


# ============================================================
# 38. COPY OF A SET
# ============================================================
"""
copy() creates a shallow copy of a set.
"""

A = {10, 20, 30}

B = A.copy()

B.add(40)

print(A)
# Output: {10, 20, 30}

print(B)
# Output: {10, 20, 30, 40}


# ============================================================
# 39. REMOVE DUPLICATES FROM A LIST
# ============================================================
"""
One of the most common practical uses of a set is removing
duplicates from a list.

Example:

    [10, 20, 10, 30, 20]

Convert it to a set:

    {10, 20, 30}
"""

numbers = [10, 20, 10, 30, 20, 40]

unique_numbers = set(numbers)

print(unique_numbers)
# Output: {10, 20, 30, 40}


# ============================================================
# 40. CONVERT SET BACK TO LIST
# ============================================================
"""
If we need a list after removing duplicates, we can convert
the set back into a list.
"""

numbers = [10, 20, 10, 30, 20, 40]

unique_numbers = list(set(numbers))

print(unique_numbers)
# Output: [10, 20, 30, 40] (order may vary)


# ============================================================
# 41. SET FROM STRING
# ============================================================
"""
When a string is converted into a set, each unique character
becomes an element.
"""

text = "banana"

characters = set(text)

print(characters)
# Output: {'b', 'a', 'n'} (order may vary)


# ============================================================
# 42. COMMON ELEMENTS BETWEEN TWO LISTS
# ============================================================
"""
Sets make it easy to find common elements between two lists.
"""

list1 = [10, 20, 30, 40]
list2 = [30, 40, 50, 60]

set1 = set(list1)
set2 = set(list2)

common = set1.intersection(set2)

print(common)
# Output: {30, 40}


# ============================================================
# 43. UNIQUE ELEMENTS FROM TWO LISTS
# ============================================================
"""
Union can be used to combine elements from two lists while
removing duplicates.
"""

list1 = [10, 20, 30]
list2 = [30, 40, 50]

unique = set(list1).union(set(list2))

print(unique)
# Output: {10, 20, 30, 40, 50}


# ============================================================
# 44. SET INPUT FROM USER
# ============================================================
"""
A common way to take multiple values from the user is:

    input()
        -> receives a string

    split()
        -> separates the input into multiple strings

    set()
        -> converts them into a set
"""

numbers = set(input("Enter numbers separated by spaces: ").split())

print(numbers)

# Example Input:
# 10 20 30 20 10

# Example Output:
# {'10', '20', '30'}


# ============================================================
# 45. SET INPUT AS INTEGERS
# ============================================================
"""
The previous example creates a set of STRINGS.

If we want integers, use map(int, ...).
"""

numbers = set(map(int, input("Enter numbers: ").split()))

print(numbers)

# Example Input:
# 10 20 30 20 10

# Example Output:
# {10, 20, 30}


# ============================================================
# 46. IMPORTANT SET OPERATIONS
# ============================================================
"""
Let:

    A = {1, 2, 3}
    B = {3, 4, 5}

Then:

    Union:
        A | B
        {1, 2, 3, 4, 5}

    Intersection:
        A & B
        {3}

    Difference:
        A - B
        {1, 2}

    Reverse Difference:
        B - A
        {4, 5}

    Symmetric Difference:
        A ^ B
        {1, 2, 4, 5}
"""

A = {1, 2, 3}
B = {3, 4, 5}

print(A | B)
# Output: {1, 2, 3, 4, 5}

print(A & B)
# Output: {3}

print(A - B)
# Output: {1, 2}

print(B - A)
# Output: {4, 5}

print(A ^ B)
# Output: {1, 2, 4, 5}


# ============================================================
#                  SET METHODS SUMMARY
# ============================================================
"""
+--------------------------------+--------------------------------------+
| Method                         | Purpose                              |
+--------------------------------+--------------------------------------+
| add(x)                         | Adds one element                    |
| update(iterable)               | Adds multiple elements              |
| remove(x)                      | Removes x; KeyError if absent       |
| discard(x)                     | Removes x; no error if absent       |
| pop()                          | Removes arbitrary element           |
| clear()                        | Removes all elements                |
| union(B)                       | All unique elements                 |
| intersection(B)                | Common elements                     |
| difference(B)                  | Elements in A but not B             |
| symmetric_difference(B)        | Elements in exactly one set         |
| difference_update(B)           | Updates A with A - B                |
| intersection_update(B)        | Keeps only common elements          |
| symmetric_difference_update()  | Updates A with symmetric difference |
| issubset(B)                    | Checks whether A is subset of B     |
| issuperset(B)                 | Checks whether A is superset of B   |
| isdisjoint(B)                 | Checks whether no elements overlap  |
| copy()                         | Creates a shallow copy               |
+--------------------------------+--------------------------------------+
"""


# ============================================================
#                    KEY POINTS
# ============================================================
"""
1. A set is a collection of UNIQUE elements.

2. A set is UNORDERED.

3. A set is MUTABLE.

4. Elements of a set must be HASHABLE.

5. Duplicate elements are automatically removed.

6. Empty set:

       set()

   NOT:

       {}

   because {} creates an empty dictionary.

7. Sets do NOT support indexing.

       numbers[0]       -> ERROR

8. Sets do NOT support slicing.

       numbers[1:3]     -> ERROR

9. Add one element:

       set.add(element)

10. Add multiple elements:

       set.update(iterable)

11. remove() raises KeyError if the element does not exist.

12. discard() does not raise an error if the element does
    not exist.

13. pop() removes an arbitrary element.

14. clear() removes all elements.

15. union combines elements from sets.

16. intersection finds common elements.

17. difference finds elements present in one set but not
    the other.

18. symmetric_difference finds elements that belong to
    exactly one of the sets.

19. Important operators:

       |  -> Union
       &  -> Intersection
       -  -> Difference
       ^  -> Symmetric Difference

20. Subset:

       A.issubset(B)

21. Superset:

       A.issuperset(B)

22. Disjoint:

       A.isdisjoint(B)

23. Sets are very useful for removing duplicates.

24. Sets are very useful for membership testing.

25. Sets are frequently used in DSA for:
       - Duplicate detection
       - Unique elements
       - Common elements
       - Set operations
       - Fast membership checking
       - Visited elements
       - Finding repeated values

26. Remember the key distinction:

       List  -> Ordered, mutable, duplicates allowed
       Tuple -> Ordered, immutable, duplicates allowed
       Set   -> Unordered, mutable, unique elements
       Dict  -> Key-value pairs, mutable, keys unique
"""