# ============================================================
#                  DICTIONARY IN PYTHON
# ============================================================
"""
A dictionary is a built-in Python data type used to store
data in the form of KEY : VALUE pairs.

Syntax:

    dictionary_name = {
        key1: value1,
        key2: value2,
        key3: value3
    }

Example:

    student = {
        "name": "Rahul",
        "age": 21,
        "marks": 85
    }

Here:

    "name"  -> key
    "Rahul" -> value

    "age"   -> key
    21      -> value

    "marks" -> key
    85      -> value


IMPORTANT PROPERTIES OF DICTIONARY:

1. Dictionary stores data in KEY : VALUE pairs.

2. Dictionary is MUTABLE.
   We can add, remove, or modify elements.

3. Keys must be UNIQUE.

4. Values can be duplicated.

5. Keys must be HASHABLE.

6. Values can be of different data types.

7. Dictionaries preserve insertion order in modern Python.

8. Dictionaries are accessed using KEYS, not numerical indexes.

9. A dictionary can contain lists, tuples, sets and other
   dictionaries as values.

10. Dictionaries are very important in DSA because they are
    commonly used for hashing, frequency counting, searching,
    duplicate detection, etc.
"""


# ============================================================
# 1. CREATING A DICTIONARY
# ============================================================
"""
A dictionary is generally created using curly braces {}.

Each key and value are separated using a colon (:).

Different key-value pairs are separated using commas.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 85}

print(type(student))
# Output: <class 'dict'>


# ============================================================
# 2. ACCESSING DICTIONARY VALUES
# ============================================================
"""
Dictionary values are accessed using their keys.

Syntax:

    dictionary[key]

Unlike lists, dictionaries do not normally use numerical
indexes to access their values.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(student["name"])
# Output: Rahul

print(student["age"])
# Output: 21

print(student["marks"])
# Output: 85


# ============================================================
# 3. DICTIONARY VS LIST ACCESS
# ============================================================
"""
LIST:

    numbers = [10, 20, 30]

    numbers[0]

Here 0 represents the index.

DICTIONARY:

    student = {"name": "Rahul"}

    student["name"]

Here "name" represents the key.
"""

numbers = [10, 20, 30]

print(numbers[0])
# Output: 10

student = {
    "name": "Rahul"
}

print(student["name"])
# Output: Rahul


# ============================================================
# 4. DICTIONARY KEYS MUST BE UNIQUE
# ============================================================
"""
A dictionary cannot contain two separate values for the same
key.

If the same key appears multiple times, the LAST value
associated with that key is retained.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "name": "Amit"
}

print(student)
# Output: {'name': 'Amit', 'age': 21}


# ============================================================
# 5. VALUES CAN BE DUPLICATED
# ============================================================
"""
Unlike keys, dictionary values do not need to be unique.

Multiple keys can have the same value.
"""

students = {
    "student1": "Rahul",
    "student2": "Rahul",
    "student3": "Amit"
}

print(students)
# Output: {'student1': 'Rahul', 'student2': 'Rahul', 'student3': 'Amit'}


# ============================================================
# 6. DIFFERENT DATA TYPES AS VALUES
# ============================================================
"""
Dictionary values can have different data types.

For example:

    String
    Integer
    Float
    Boolean
    List
    Tuple
    Dictionary
"""

student = {
    "name": "Rahul",
    "age": 21,
    "cgpa": 8.5,
    "passed": True,
    "marks": [85, 90, 88],
    "address": ("Kolkata", "West Bengal")
}

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'cgpa': 8.5, 'passed': True, 'marks': [85, 90, 88], 'address': ('Kolkata', 'West Bengal')}


# ============================================================
# 7. DICTIONARY IS MUTABLE
# ============================================================
"""
Mutable means that the dictionary can be changed after it
has been created.

We can:

    - Modify existing values
    - Add new key-value pairs
    - Remove key-value pairs
"""

student = {
    "name": "Rahul",
    "age": 21
}

student["age"] = 22

print(student)
# Output: {'name': 'Rahul', 'age': 22}


# ============================================================
# 8. ADDING A NEW KEY-VALUE PAIR
# ============================================================
"""
If the key does not already exist, assigning a value to it
creates a new key-value pair.
"""

student = {
    "name": "Rahul",
    "age": 21
}

student["marks"] = 85

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 85}


# ============================================================
# 9. MODIFYING AN EXISTING VALUE
# ============================================================
"""
If the key already exists, assigning a new value changes
the existing value.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

student["marks"] = 95

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 95}


# ============================================================
# 10. EMPTY DICTIONARY
# ============================================================
"""
An empty dictionary does not contain any key-value pairs.

Syntax:

    {}

or:

    dict()
"""

student = {}

print(student)
# Output: {}

print(type(student))
# Output: <class 'dict'>


student = dict()

print(student)
# Output: {}


# ============================================================
# 11. IMPORTANT: {} IS A DICTIONARY
# ============================================================
"""
An empty pair of curly braces creates an empty dictionary.

It does NOT create an empty set.

Empty dictionary:

    {}

Empty set:

    set()
"""

data = {}

print(type(data))
# Output: <class 'dict'>

data = set()

print(type(data))
# Output: <class 'set'>


# ============================================================
# 12. DICTIONARY KEYS MUST BE HASHABLE
# ============================================================
"""
Dictionary keys must be hashable.

Common valid key types:

    - int
    - float
    - string
    - tuple

Mutable objects such as lists, dictionaries and sets cannot
normally be used as dictionary keys.
"""

data = {
    1: "One",
    3.14: "Pi",
    "name": "Rahul",
    (10, 20): "Coordinate"
}

print(data)
# Output: {1: 'One', 3.14: 'Pi', 'name': 'Rahul', (10, 20): 'Coordinate'}


# ============================================================
# 13. INVALID DICTIONARY KEY
# ============================================================
"""
A list cannot be used as a dictionary key because a list is
mutable and therefore unhashable.

The following code would produce:

    TypeError: unhashable type: 'list'
"""

# data = {
#     [1, 2, 3]: "Numbers"
# }


# ============================================================
# 14. TUPLE AS A DICTIONARY KEY
# ============================================================
"""
A tuple can be used as a dictionary key if all of its elements
are hashable.
"""

coordinates = {
    (10, 20): "Point A",
    (30, 40): "Point B"
}

print(coordinates[(10, 20)])
# Output: Point A


# ============================================================
# 15. KEYERROR
# ============================================================
"""
If we try to access a key that does not exist using:

    dictionary[key]

Python raises a KeyError.
"""

student = {
    "name": "Rahul",
    "age": 21
}

# print(student["marks"])
# Output: KeyError: 'marks'


# ============================================================
# 16. get() METHOD
# ============================================================
"""
The get() method is used to safely access a value.

Syntax:

    dictionary.get(key)

If the key exists:
    -> returns its value

If the key does not exist:
    -> returns None

Unlike [] access, get() does not raise KeyError for a
missing key.
"""

student = {
    "name": "Rahul",
    "age": 21
}

print(student.get("name"))
# Output: Rahul

print(student.get("marks"))
# Output: None


# ============================================================
# 17. get() WITH DEFAULT VALUE
# ============================================================
"""
We can provide a default value to get().

Syntax:

    dictionary.get(key, default_value)

If the key does not exist, the default value is returned.
"""

student = {
    "name": "Rahul",
    "age": 21
}

print(student.get("marks", 0))
# Output: 0

print(student.get("city", "Not Available"))
# Output: Not Available


# ============================================================
# 18. [] VS get()
# ============================================================
"""
Using []:

    student["marks"]

If "marks" does not exist:
    -> KeyError

Using get():

    student.get("marks")

If "marks" does not exist:
    -> None
"""

student = {
    "name": "Rahul",
    "age": 21
}

# print(student["marks"])
# Output: KeyError: 'marks'

print(student.get("marks"))
# Output: None


# ============================================================
# 19. CHECKING WHETHER A KEY EXISTS
# ============================================================
"""
The 'in' operator can be used to check whether a key exists.

Syntax:

    key in dictionary

The result is True or False.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print("name" in student)
# Output: True

print("marks" in student)
# Output: True

print("city" in student)
# Output: False


# ============================================================
# 20. not in
# ============================================================
"""
The 'not in' operator checks whether a key does NOT exist.
"""

student = {
    "name": "Rahul",
    "age": 21
}

print("marks" not in student)
# Output: True

print("name" not in student)
# Output: False


# ============================================================
# 21. MEMBERSHIP CHECKS KEYS
# ============================================================
"""
When we use:

    value in dictionary

Python checks the KEYS, not the values.
"""

student = {
    "name": "Rahul",
    "age": 21
}

print("Rahul" in student)
# Output: False

print("name" in student)
# Output: True


# ============================================================
# 22. CHECKING VALUES USING values()
# ============================================================
"""
To check whether a particular value exists, use values().
"""

student = {
    "name": "Rahul",
    "age": 21
}

print("Rahul" in student.values())
# Output: True

print(21 in student.values())
# Output: True

print(25 in student.values())
# Output: False


# ============================================================
# 23. DICTIONARY LENGTH
# ============================================================
"""
len() returns the number of key-value pairs in the dictionary.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(len(student))
# Output: 3


# ============================================================
# 24. keys() METHOD
# ============================================================
"""
keys() returns a view containing all dictionary keys.

Syntax:

    dictionary.keys()
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(student.keys())
# Output: dict_keys(['name', 'age', 'marks'])


# We can convert the result into a list.

print(list(student.keys()))
# Output: ['name', 'age', 'marks']


# ============================================================
# 25. values() METHOD
# ============================================================
"""
values() returns a view containing all dictionary values.

Syntax:

    dictionary.values()
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(student.values())
# Output: dict_values(['Rahul', 21, 85])

print(list(student.values()))
# Output: ['Rahul', 21, 85]


# ============================================================
# 26. items() METHOD
# ============================================================
"""
items() returns all key-value pairs.

Each key-value pair is represented as a tuple.

Syntax:

    dictionary.items()
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(student.items())
# Output: dict_items([('name', 'Rahul'), ('age', 21), ('marks', 85)])


# ============================================================
# 27. LOOPING THROUGH KEYS
# ============================================================
"""
When we directly iterate over a dictionary, we get its keys.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

for key in student:
    print(key)

# Output:
# name
# age
# marks


# ============================================================
# 28. LOOPING THROUGH VALUES
# ============================================================
"""
Use values() when we want to iterate through values.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

for value in student.values():
    print(value)

# Output:
# Rahul
# 21
# 85


# ============================================================
# 29. LOOPING THROUGH KEY-VALUE PAIRS
# ============================================================
"""
Use items() when both the key and value are required.

This is one of the most commonly used dictionary patterns.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

for key, value in student.items():
    print(key, ":", value)

# Output:
# name : Rahul
# age : 21
# marks : 85


# ============================================================
# 30. update() METHOD
# ============================================================
"""
update() is used to add multiple key-value pairs or update
existing keys.

Syntax:

    dictionary.update(other_dictionary)
"""

student = {
    "name": "Rahul",
    "age": 21
}

student.update({
    "marks": 85,
    "city": "Kolkata"
})

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 85, 'city': 'Kolkata'}


# ============================================================
# 31. update() CAN MODIFY EXISTING KEYS
# ============================================================

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

student.update({
    "age": 22,
    "marks": 95
})

print(student)
# Output: {'name': 'Rahul', 'age': 22, 'marks': 95}


# ============================================================
# 32. pop() METHOD
# ============================================================
"""
pop(key) removes the specified key-value pair.

It also RETURNS the value that was removed.

Syntax:

    dictionary.pop(key)
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

removed_value = student.pop("age")

print(removed_value)
# Output: 21

print(student)
# Output: {'name': 'Rahul', 'marks': 85}


# ============================================================
# 33. popitem() METHOD
# ============================================================
"""
popitem() removes and returns the LAST inserted key-value pair.

The returned result is a tuple:

    (key, value)
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

item = student.popitem()

print(item)
# Output: ('marks', 85)

print(student)
# Output: {'name': 'Rahul', 'age': 21}


# ============================================================
# 34. del STATEMENT
# ============================================================
"""
del can be used to remove a particular key-value pair.
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

del student["age"]

print(student)
# Output: {'name': 'Rahul', 'marks': 85}


# ============================================================
# 35. clear() METHOD
# ============================================================
"""
clear() removes ALL key-value pairs from the dictionary.

The dictionary itself still exists after clear().
"""

student = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

student.clear()

print(student)
# Output: {}


# ============================================================
# 36. del DICTIONARY
# ============================================================
"""
If we use:

    del dictionary

the dictionary variable itself is deleted.

Trying to access it afterwards results in NameError.
"""

student = {
    "name": "Rahul",
    "age": 21
}

del student

# print(student)
# Output: NameError: name 'student' is not defined


# ============================================================
# 37. setdefault() METHOD
# ============================================================
"""
setdefault() works as follows:

1. If the key exists:
       -> returns its existing value

2. If the key does not exist:
       -> creates the key with the specified value
       -> returns that value
"""

student = {
    "name": "Rahul",
    "age": 21
}

result = student.setdefault("marks", 85)

print(result)
# Output: 85

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 85}


# ============================================================
# 38. setdefault() WITH EXISTING KEY
# ============================================================
"""
If the key already exists, setdefault() does NOT replace
its existing value.
"""

student = {
    "name": "Rahul",
    "age": 21
}

result = student.setdefault("age", 25)

print(result)
# Output: 21

print(student)
# Output: {'name': 'Rahul', 'age': 21}


# ============================================================
# 39. copy() METHOD
# ============================================================
"""
copy() creates a shallow copy of the dictionary.

The copied dictionary is a separate dictionary object.
"""

student = {
    "name": "Rahul",
    "age": 21
}

student2 = student.copy()

student2["age"] = 22

print(student)
# Output: {'name': 'Rahul', 'age': 21}

print(student2)
# Output: {'name': 'Rahul', 'age': 22}


# ============================================================
# 40. NESTED DICTIONARY
# ============================================================
"""
A dictionary can contain another dictionary as a value.

Such a structure is called a NESTED DICTIONARY.
"""

students = {
    "student1": {
        "name": "Rahul",
        "age": 21
    },

    "student2": {
        "name": "Amit",
        "age": 22
    }
}

print(students)
# Output: {'student1': {'name': 'Rahul', 'age': 21}, 'student2': {'name': 'Amit', 'age': 22}}


# ============================================================
# 41. ACCESSING A NESTED DICTIONARY
# ============================================================
"""
To access nested data, use multiple keys.
"""

print(students["student1"])
# Output: {'name': 'Rahul', 'age': 21}

print(students["student1"]["name"])
# Output: Rahul

print(students["student2"]["age"])
# Output: 22


# ============================================================
# 42. DICTIONARY CONTAINING A LIST
# ============================================================
"""
A dictionary value can be a list.
"""

student = {
    "name": "Rahul",
    "marks": [85, 90, 88]
}

print(student["marks"])
# Output: [85, 90, 88]

print(student["marks"][0])
# Output: 85

print(student["marks"][1])
# Output: 90


# ============================================================
# 43. DICTIONARY CONTAINING A TUPLE
# ============================================================

student = {
    "name": "Rahul",
    "location": ("Kolkata", "West Bengal")
}

print(student["location"])
# Output: ('Kolkata', 'West Bengal')

print(student["location"][0])
# Output: Kolkata


# ============================================================
# 44. DICTIONARY CONTAINING ANOTHER DICTIONARY AND LIST
# ============================================================
"""
Dictionary values can contain complex structures.

Here:

    marks   -> list
    address -> dictionary
"""

student = {
    "name": "Rahul",
    "age": 21,

    "marks": [85, 90, 88],

    "address": {
        "city": "Kolkata",
        "state": "West Bengal"
    }
}

print(student["marks"][1])
# Output: 90

print(student["address"]["city"])
# Output: Kolkata

print(student["address"]["state"])
# Output: West Bengal


# ============================================================
# 45. MODIFYING NESTED DATA
# ============================================================
"""
Nested values can also be modified if the object being modified
is mutable.
"""

student = {
    "name": "Rahul",
    "marks": [85, 90, 88],
    "address": {
        "city": "Kolkata"
    }
}

student["marks"][0] = 95

student["address"]["city"] = "Delhi"

print(student)
# Output: {'name': 'Rahul', 'marks': [95, 90, 88], 'address': {'city': 'Delhi'}}


# ============================================================
# 46. DICTIONARY INPUT
# ============================================================
"""
We can create an empty dictionary and take input from the user.

Example:

    name -> string
    age  -> integer
"""

student = {}

name = input("Enter name: ")
age = int(input("Enter age: "))

student["name"] = name
student["age"] = age

print(student)
# Example Output: {'name': 'Rahul', 'age': 21}


# ============================================================
# 47. dict() CONSTRUCTOR
# ============================================================
"""
A dictionary can also be created using dict().
"""

student = dict(
    name="Rahul",
    age=21,
    marks=85
)

print(student)
# Output: {'name': 'Rahul', 'age': 21, 'marks': 85}


# ============================================================
# 48. FREQUENCY COUNTING
# ============================================================
"""
One of the MOST IMPORTANT uses of dictionaries in DSA is
frequency counting.

Suppose we have:

    [10, 20, 10, 30, 20, 10]

We want to count how many times each number occurs.

Expected result:

    10 -> 3
    20 -> 2
    30 -> 1
"""

numbers = [10, 20, 10, 30, 20, 10]

frequency = {}

for number in numbers:

    frequency[number] = frequency.get(number, 0) + 1

print(frequency)
# Output: {10: 3, 20: 2, 30: 1}


# ============================================================
# 49. WHY get() IS USEFUL IN FREQUENCY COUNTING
# ============================================================
"""
Suppose the number does not exist in the dictionary.

For example:

    frequency = {}

For the first occurrence of 10:

    frequency.get(10, 0)

returns:

    0

Then:

    0 + 1

becomes:

    1

So:

    frequency[10] = 1

For the next occurrence:

    frequency.get(10, 0)

returns:

    1

Then:

    1 + 1

becomes:

    2
"""

frequency = {}

frequency[10] = frequency.get(10, 0) + 1
print(frequency)
# Output: {10: 1}

frequency[10] = frequency.get(10, 0) + 1
print(frequency)
# Output: {10: 2}


# ============================================================
# 50. FREQUENCY OF CHARACTERS IN A STRING
# ============================================================
"""
Dictionaries are also frequently used to count characters.

Example:

    "banana"

Expected:

    b -> 1
    a -> 3
    n -> 2
"""

text = "banana"

frequency = {}

for char in text:
    frequency[char] = frequency.get(char, 0) + 1

print(frequency)
# Output: {'b': 1, 'a': 3, 'n': 2}


# ============================================================
# 51. FIND DUPLICATES USING DICTIONARY
# ============================================================
"""
We can use a dictionary to count occurrences and then
identify elements whose frequency is greater than 1.
"""

numbers = [10, 20, 10, 30, 20, 40]

frequency = {}

for number in numbers:
    frequency[number] = frequency.get(number, 0) + 1

for number, count in frequency.items():

    if count > 1:
        print(number, "is duplicated")

# Output:
# 10 is duplicated
# 20 is duplicated


# ============================================================
# 52. DICTIONARY METHODS - QUICK DEMONSTRATION
# ============================================================

data = {
    "name": "Rahul",
    "age": 21,
    "marks": 85
}

print(data.keys())
# Output: dict_keys(['name', 'age', 'marks'])

print(data.values())
# Output: dict_values(['Rahul', 21, 85])

print(data.items())
# Output: dict_items([('name', 'Rahul'), ('age', 21), ('marks', 85)])

print(data.get("name"))
# Output: Rahul

data.update({"age": 22})

print(data)
# Output: {'name': 'Rahul', 'age': 22, 'marks': 85}


# ============================================================
#                DICTIONARY METHOD SUMMARY
# ============================================================
"""
+----------------+---------------------------------------------+
| Method         | Purpose                                     |
+----------------+---------------------------------------------+
| keys()         | Returns all keys                            |
| values()       | Returns all values                          |
| items()        | Returns all key-value pairs                |
| get()          | Safely accesses a value                    |
| update()       | Adds or updates key-value pairs            |
| pop()          | Removes specified key                      |
| popitem()      | Removes last inserted pair                 |
| clear()        | Removes all key-value pairs                |
| setdefault()   | Gets value / inserts if key is absent      |
| copy()         | Creates a shallow copy                     |
+----------------+---------------------------------------------+
"""


# ============================================================
#                    IMPORTANT KEY POINTS
# ============================================================
"""
1. Dictionary stores data in KEY : VALUE pairs.

2. Syntax:

       data = {
           "name": "Rahul",
           "age": 21
       }

3. Dictionaries are mutable.

4. Keys must be unique.

5. If a key is repeated, the last value is retained.

6. Values can be duplicated.

7. Values can contain different data types.

8. Keys must be hashable.

9. Common valid keys:

       int
       float
       string
       tuple

10. Lists and dictionaries cannot be used as dictionary keys.

11. Access values using:

       dictionary[key]

12. Accessing a missing key using [] causes:

       KeyError

13. Safer alternative:

       dictionary.get(key)

14. get() returns None if the key does not exist.

15. get() can also have a default value:

       dictionary.get(key, default)

16. Add a new element:

       dictionary[key] = value

17. Modify an existing element:

       dictionary[key] = new_value

18. Check whether a key exists:

       key in dictionary

19. Get all keys:

       dictionary.keys()

20. Get all values:

       dictionary.values()

21. Get key-value pairs:

       dictionary.items()

22. Loop through a dictionary:

       for key, value in dictionary.items():
           ...

23. Remove a specific key:

       dictionary.pop(key)

24. Remove the last inserted pair:

       dictionary.popitem()

25. Remove all elements:

       dictionary.clear()

26. Delete the dictionary itself:

       del dictionary

27. update() can add or modify multiple elements.

28. A dictionary can contain another dictionary.

29. A dictionary can contain a list.

30. Nested dictionary values can be accessed using:

       dictionary["key1"]["key2"]

31. Empty dictionary:

       {}

32. Empty set:

       set()

33. Dictionaries are heavily used in DSA.

34. One of the most important DSA patterns is:

       frequency[x] = frequency.get(x, 0) + 1

35. Dictionary is commonly used for:

       - Frequency counting
       - Hashing
       - Searching
       - Duplicate detection
       - Counting characters
       - Mapping values
       - Storing relationships
       - Memoization
"""