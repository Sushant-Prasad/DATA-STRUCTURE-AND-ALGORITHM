# ============================================================
#                     TYPES OF OPERATORS
# ============================================================
"""
An operator is a symbol or keyword that performs an operation
on one or more operands.

Example:
    A + B

Here:
    A and B -> Operands
    +      -> Operator

Python provides the following major types of operators:

1. Arithmetic Operators
2. Relational / Comparison Operators
3. Assignment Operators
4. Logical Operators
5. Membership Operators
6. Identity Operators
7. Bitwise Operators
"""

# ============================================================
# 1. ARITHMETIC OPERATORS
# ============================================================
"""
Arithmetic operators are used to perform mathematical
operations on numeric values.

Operators:
    +   Addition
    -   Subtraction
    *   Multiplication
    /   Division
    //  Floor Division
    %   Modulus
    **  Exponentiation
"""

A = 10
B = 3

print(A + B)       # 13
print(A - B)       # 7
print(A * B)       # 30
print(A / B)       # 3.3333333333333335
print(A // B)      # 3
print(A % B)       # 1
print(A ** B)      # 1000


# ============================================================
# 2. RELATIONAL / COMPARISON OPERATORS
# ============================================================
"""
Comparison operators are used to compare two values.

The result of a comparison is always a Boolean value:
    True
    False

Operators:
    ==   Equal to
    !=   Not equal to
    >    Greater than
    <    Less than
    >=   Greater than or equal to
    <=   Less than or equal to
"""

A = 10
B = 5

print(A == B)      # False
print(A != B)      # True
print(A > B)       # True
print(A < B)       # False
print(A >= B)      # True
print(A <= B)      # False


# Example with strings

name1 = "Python"
name2 = "Python"

print(name1 == name2)     # True


# ============================================================
# 3. ASSIGNMENT OPERATORS
# ============================================================
"""
Assignment operators are used to assign a value to a variable
or update the value of an existing variable.

Operators:
    =    Assignment
    +=   Add and assign
    -=   Subtract and assign
    *=   Multiply and assign
    /=   Divide and assign
    %=   Modulus and assign
    //=  Floor divide and assign
    **=  Exponentiate and assign
"""

A = 10

A += 5
print(A)          # 15

A -= 3
print(A)          # 12

A *= 2
print(A)          # 24

A /= 4
print(A)          # 6.0

A %= 4
print(A)          # 2.0


# ============================================================
# 4. LOGICAL OPERATORS
# ============================================================
"""
Logical operators are used to combine or modify conditions.

Operators:
    and
    or
    not

and:
    Returns True only when BOTH conditions are True.

or:
    Returns True when AT LEAST ONE condition is True.

not:
    Reverses the Boolean result.
"""

A = 10
B = 20

print(A > 5 and B > 15)      # True
print(A > 15 and B > 15)     # False

print(A > 15 or B > 15)      # True
print(A > 15 or B > 25)      # False

print(not(A > 5))            # False


# Practical example

age = 24
has_id = True

print(age >= 18 and has_id)  # True


# ============================================================
# 5. MEMBERSHIP OPERATORS
# ============================================================
"""
Membership operators are used to check whether a value exists
inside a sequence or collection.

Operators:
    in
    not in

in:
    Returns True if the value is present.

not in:
    Returns True if the value is NOT present.

Membership operators are commonly used with:
    strings
    lists
    tuples
    sets
    dictionaries
"""

name = "Sushant"

print("S" in name)            # True
print("z" in name)            # False
print("S" not in name)        # False
print("z" not in name)        # True


# Example with a list

numbers = [10, 20, 30, 40]

print(20 in numbers)          # True
print(50 in numbers)          # False
print(50 not in numbers)      # True


# ============================================================
# 6. IDENTITY OPERATORS
# ============================================================
"""
Identity operators are used to check whether two variables
refer to the SAME OBJECT in memory.

Operators:
    is
    is not

is:
    Returns True if both variables refer to the same object.

is not:
    Returns True if both variables do not refer to the
    same object.

IMPORTANT:
    == checks whether two values are equal.
    is checks whether two variables refer to the same object.
"""

A = [10, 20, 30]
B = A
C = [10, 20, 30]

print(A == B)        # True
print(A is B)        # True

print(A == C)        # True
print(A is C)        # False


# ============================================================
# 7. BITWISE OPERATORS
# ============================================================
"""
Bitwise operators work on the individual bits of integers.

Operators:

    &    Bitwise AND
    |    Bitwise OR
    ^    Bitwise XOR
    ~    Bitwise NOT
    <<   Left Shift
    >>   Right Shift
"""

# ------------------------------------------------------------
# Bitwise AND (&)
# ------------------------------------------------------------
"""
AND rule:

    0 & 0 = 0
    0 & 1 = 0
    1 & 0 = 0
    1 & 1 = 1

Example:

    5 = 0101
    3 = 0011

    5 & 3
      0101
      0011
      ----
      0001

Result = 1
"""

A = 5
B = 3

print(A & B)          # 1


# ------------------------------------------------------------
# Bitwise OR (|)
# ------------------------------------------------------------
"""
OR rule:

    0 | 0 = 0
    0 | 1 = 1
    1 | 0 = 1
    1 | 1 = 1

Example:

    5 = 0101
    3 = 0011

    5 | 3
      0101
      0011
      ----
      0111

Result = 7
"""

print(A | B)          # 7


# ------------------------------------------------------------
# Bitwise XOR (^)
# ------------------------------------------------------------
"""
XOR rule:

    0 ^ 0 = 0
    0 ^ 1 = 1
    1 ^ 0 = 1
    1 ^ 1 = 0

XOR produces 1 when the two bits are different.

Example:

    5 = 0101
    3 = 0011

    5 ^ 3
      0101
      0011
      ----
      0110

Result = 6
"""

print(A ^ B)          # 6


# ------------------------------------------------------------
# Bitwise NOT (~)
# ------------------------------------------------------------
"""
The ~ operator flips every bit of an integer.

In Python:

    ~A = -(A + 1)

Example:

    ~5 = -(5 + 1)
       = -6
"""

print(~5)             # -6


# ------------------------------------------------------------
# Left Shift (<<)
# ------------------------------------------------------------
"""
The << operator shifts the bits towards the left.

Each left shift by one position is equivalent to
multiplication by 2.

Example:

    5 << 1

    5 = 0101
    Shift left:
         1010

    1010 = 10

Therefore:
    5 << 1 = 10
"""

print(5 << 1)         # 10
print(5 << 2)         # 20


# ------------------------------------------------------------
# Right Shift (>>)
# ------------------------------------------------------------
"""
The >> operator shifts the bits towards the right.

For positive integers, each right shift by one position
is equivalent to integer division by 2.

Example:

    10 >> 1

    10 = 1010
    Shift right:
         0101

    0101 = 5

Therefore:
    10 >> 1 = 5
"""

print(10 >> 1)        # 5
print(10 >> 2)        # 2


# ============================================================
#                 OPERATOR SUMMARY
# ============================================================
"""
+------------------------------------------------------------+
| Type             | Operators                               |
+------------------------------------------------------------+
| Arithmetic       | +  -  *  /  //  %  **                   |
| Comparison       | ==  !=  >  <  >=  <=                    |
| Assignment       | =  +=  -=  *=  /=  %=  //=  **=         |
| Logical          | and  or  not                            |
| Membership       | in  not in                              |
| Identity         | is  is not                              |
| Bitwise          | &  |  ^  ~  <<  >>                      |
+------------------------------------------------------------+
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. Operators perform operations on operands.

2. Arithmetic operators are mainly used for mathematical
   calculations.

3. Comparison operators always return True or False.

4. Assignment operators modify or assign values to variables.

5. Logical operators are mainly used to combine conditions.

6. Membership operators check whether a value exists inside
   a collection.

7. Identity operators check whether two variables refer to
   the same object.

8. == and is are NOT the same:
       ==  -> compares values
       is  -> compares object identity

9. Bitwise operators work at the binary/bit level.

10. The main bitwise operators are:
       &   -> AND
       |   -> OR
       ^   -> XOR
       ~   -> NOT
       <<  -> Left Shift
       >>  -> Right Shift

11. String values can also work with some operators:
       +   -> Concatenation
       *   -> Repetition

12. The result of a comparison operation is a Boolean:
       True
       False

13. Logical operators:
       and -> both conditions must be True
       or  -> at least one condition must be True
       not -> reverses the Boolean result
"""