# ============================================================
#                      TYPE CONVERSION
# ============================================================
"""
Type conversion means converting a value from one data type
to another data type.

Python provides several built-in functions for type conversion.

Common type conversion functions:

    int()       -> converts a value to integer
    float()     -> converts a value to float
    str()       -> converts a value to string
    bool()      -> converts a value to Boolean
    list()      -> converts a value to list
    tuple()     -> converts a value to tuple
    set()       -> converts a value to set

Type conversion is especially important when working with
user input because input() always returns a string.
"""

# ============================================================
# 1. INTEGER CONVERSION - int()
# ============================================================
"""
int() converts a compatible value into an integer.

Examples:
    int("10")     -> 10
    int(10.8)     -> 10
    int(True)     -> 1
    int(False)    -> 0

When converting a float to int, the decimal part is removed.
It does NOT round the number.
"""

A = int("10")
B = int(10.8)
C = int(True)
D = int(False)

print(A)                 # 10
print(B)                 # 10
print(C)                 # 1
print(D)                 # 0

print(type(A))           # <class 'int'>


# ============================================================
# 2. FLOAT CONVERSION - float()
# ============================================================
"""
float() converts a compatible value into a floating-point
number.

Examples:
    float("10")       -> 10.0
    float("10.5")     -> 10.5
    float(10)         -> 10.0
    float(True)       -> 1.0
"""

A = float("10")
B = float("10.5")
C = float(10)
D = float(True)

print(A)                 # 10.0
print(B)                 # 10.5
print(C)                 # 10.0
print(D)                 # 1.0


# ============================================================
# 3. STRING CONVERSION - str()
# ============================================================
"""
str() converts a value into a string.

It is useful when we want to combine a number with a string.

Example:

    age = 24
    print("Age: " + str(age))
"""

age = 24

print("Age: " + str(age))
print(type(str(age)))    # <class 'str'>


# ============================================================
# 4. BOOLEAN CONVERSION - bool()
# ============================================================
"""
bool() converts a value into True or False.

Important rule:

Falsy values:
    0
    0.0
    ""
    None
    False
    empty collections such as [], (), {}, set()

Most other values are considered Truthy.
"""

print(bool(1))            # True
print(bool(0))            # False

print(bool("Hello"))      # True
print(bool(""))           # False

print(bool(10.5))         # True
print(bool(None))         # False


# ============================================================
# 5. TYPE CONVERSION WITH USER INPUT
# ============================================================
"""
input() always returns a string.

Example:

    age = input("Age: ")

Even if the user enters 24, Python receives:

    "24"

To perform mathematical operations, convert it to int.
"""

age = input("Enter your age: ")

print(type(age))          # <class 'str'>

age = int(age)

print(type(age))          # <class 'int'>


# ============================================================
# 6. DIRECT TYPE CONVERSION WITH INPUT
# ============================================================
"""
Instead of converting the input in a separate statement,
we can directly convert it.

Integer input:

    age = int(input("Age: "))

Float input:

    price = float(input("Price: "))
"""

age = int(input("Enter age: "))
price = float(input("Enter price: "))

print(age)
print(price)


# ============================================================
# 7. STRING TO INTEGER
# ============================================================
"""
A numeric string can be converted into an integer.

    "100" -> 100

But the string must contain a valid integer.
"""

A = "100"

B = int(A)

print(B)                  # 100
print(type(B))            # <class 'int'>


# ============================================================
# 8. STRING TO FLOAT
# ============================================================
"""
A numeric string containing a decimal value can be converted
into a float.

    "10.5" -> 10.5
"""

A = "10.5"

B = float(A)

print(B)                  # 10.5
print(type(B))            # <class 'float'>


# ============================================================
# 9. INTEGER TO FLOAT
# ============================================================
"""
An integer can be converted into a float.

    10 -> 10.0
"""

A = 10

B = float(A)

print(B)                  # 10.0


# ============================================================
# 10. FLOAT TO INTEGER
# ============================================================
"""
A float can be converted into an integer.

The decimal portion is removed.

    10.9 -> 10
    5.7  -> 5
    -5.7 -> -5

int() truncates towards zero; it does NOT perform floor
rounding.
"""

print(int(10.9))          # 10
print(int(5.7))           # 5
print(int(-5.7))          # -5


# ============================================================
# 11. INTEGER TO STRING
# ============================================================
"""
An integer can be converted into a string using str().
"""

age = 24

age_string = str(age)

print(age_string)
print(type(age_string))   # <class 'str'>


# ============================================================
# 12. LIST CONVERSION
# ============================================================
"""
list() converts an iterable into a list.

A string is iterable, so each character becomes an element.
"""

text = "Python"

characters = list(text)

print(characters)
# Output:
# ['P', 'y', 't', 'h', 'o', 'n']


# ============================================================
# 13. TUPLE CONVERSION
# ============================================================
"""
tuple() converts an iterable into a tuple.
"""

numbers = [10, 20, 30]

result = tuple(numbers)

print(result)
# Output:
# (10, 20, 30)


# ============================================================
# 14. SET CONVERSION
# ============================================================
"""
set() converts an iterable into a set.

A set stores unique values and does not preserve duplicates.
"""

numbers = [10, 20, 20, 30, 30]

result = set(numbers)

print(result)
# Output:
# {10, 20, 30}


# ============================================================
# 15. TYPE CONVERSION vs TYPE CASTING
# ============================================================
"""
In Python, the terms "type conversion" and "type casting"
are often used interchangeably.

However, conceptually:

Type Conversion:
    Changing one data type into another.

Example:
    int("10")

Explicit Type Conversion:
    The programmer explicitly converts the value.

Example:
    age = int(input("Age: "))

Python also performs some implicit type conversion
automatically during certain operations.
"""

# Example of implicit conversion:

A = 10       # int
B = 2.5      # float

C = A + B

print(C)                  # 12.5
print(type(C))            # <class 'float'>


# ============================================================
# 16. EXPLICIT TYPE CONVERSION
# ============================================================
"""
Explicit conversion means the programmer manually specifies
the desired data type.

Common functions:

    int()
    float()
    str()
    bool()
"""

A = "25"

B = int(A)

print(B + 5)              # 30


# ============================================================
# 17. IMPLICIT TYPE CONVERSION
# ============================================================
"""
Implicit conversion happens automatically when Python converts
a value to another compatible type during an operation.

Example:

    int + float -> float

Python automatically converts the integer into a float.
"""

A = 10
B = 2.5

C = A + B

print(C)                  # 12.5
print(type(C))            # <class 'float'>


# ============================================================
# 18. INVALID TYPE CONVERSION
# ============================================================
"""
Not every value can be converted into every data type.

For example:

    int("Hello")

is invalid because "Hello" is not a numeric string.

It produces:

    ValueError
"""

# This will cause ValueError:
#
# A = int("Hello")


# Another example:

# A = int("10.5")
#
# This also causes ValueError because "10.5" is not a valid
# integer representation.
#
# Correct approach:

A = int(float("10.5"))

print(A)                  # 10


# ============================================================
#                       KEY POINTS
# ============================================================
"""
1. Type conversion means changing a value from one data type
   to another.

2. Important conversion functions:
       int()
       float()
       str()
       bool()
       list()
       tuple()
       set()

3. input() always returns a string.

4. For integer input:
       int(input())

5. For floating-point input:
       float(input())

6. int(10.9) gives 10.
   It removes the decimal part; it does not round.

7. float(10) gives 10.0.

8. str(10) gives "10".

9. bool(0) gives False.

10. bool("") gives False.

11. bool("0") gives True because "0" is a non-empty string.

12. Explicit conversion is performed by the programmer.

13. Python can also perform implicit conversion in some
    arithmetic operations.

14. int + float generally results in float.

15. Invalid conversions can produce errors such as ValueError.

16. Remember:

       "25"      -> str
       int("25") -> int
       float("25") -> float
       str(25)   -> str
       bool(25)  -> True
"""