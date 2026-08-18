# ============================================================
#                         INPUT IN PYTHON
# ============================================================
"""
The input() function is used to accept values from the user
through the keyboard.

Syntax:
    variable = input("prompt")

By default, input() always returns the user's input as a
STRING, even if the user enters a number.

To accept numeric values, we need to convert the input
using int() or float().
"""

# ============================================================
# 1. STRING INPUT
# ============================================================
"""
input() is commonly used to accept text/string values.

Syntax:
    name = input("name : ")

The value entered by the user is stored in the variable name.
The return type of input() is always str.
"""

name = input("Name : ")

print("Hello", name)
print(type(name))


# ============================================================
# 2. INTEGER INPUT
# ============================================================
"""
Since input() returns a string, we use int() to convert
the entered value into an integer.

Syntax:
    variable = int(input("prompt"))

Example:
    age = int(input("Age : "))

If the user enters 24:
    input()  -> "24"      (string)
    int()    -> 24        (integer)
"""

age = int(input("Age : "))

print("Age =", age)
print(type(age))


# ============================================================
# 3. FLOAT INPUT
# ============================================================
"""
To accept decimal/numerical values, use float().

Syntax:
    variable = float(input("prompt"))

Example:
    price = float(input("Price : "))

If the user enters 99.50:
    input()   -> "99.50"      (string)
    float()   -> 99.50        (float)
"""

price = float(input("Price : "))

print("Price =", price)
print(type(price))


# ============================================================
# 4. INPUT AND ARITHMETIC OPERATIONS
# ============================================================
"""
After converting input into an integer or float, we can
perform arithmetic operations on the values.
"""

A = int(input("Enter A : "))
B = int(input("Enter B : "))

print("Sum =", A + B)
print("Difference =", A - B)
print("Product =", A * B)
print("Division =", A / B)


# ============================================================
# 5. INPUT WITH MULTIPLE VALUES
# ============================================================
"""
Multiple values can be accepted in a single line using
split().

Example:
    A, B = input().split()

If the user enters:
    10 20

Then:
    A = "10"
    B = "20"

Remember that the values are still strings.

To convert them into integers, use map():

    A, B = map(int, input().split())
"""

A, B = map(int, input("Enter two numbers : ").split())

print("A =", A)
print("B =", B)
print("Sum =", A + B)


# ============================================================
# 6. MULTIPLE FLOAT VALUES
# ============================================================
"""
The same approach can be used for multiple float values.

Syntax:
    A, B = map(float, input().split())
"""

A, B = map(float, input("Enter two decimal numbers : ").split())

print("Sum =", A + B)


# ============================================================
# 7. STRING INPUT WITH MULTIPLE WORDS
# ============================================================
"""
When we use split() without specifying a separator,
Python separates the input using whitespace.

Example:
    first_name, last_name = input().split()

Input:
    Sushant Prasad

Output:
    first_name = "Sushant"
    last_name = "Prasad"
"""

first_name, last_name = input("Enter your full name : ").split()

print("First Name :", first_name)
print("Last Name :", last_name)


# ============================================================
# 8. TYPE CONVERSION WITH INPUT
# ============================================================
"""
Common type conversions used with input():

    int()    -> converts input to integer
    float()  -> converts input to float
    str()    -> converts a value to string

Examples:
"""

age = int(input("Enter age : "))
height = float(input("Enter height : "))
name = input("Enter name : ")

print(name)
print(age)
print(height)


# ============================================================
# 9. IMPORTANT DIFFERENCE
# ============================================================
"""
input() always returns a string.

Example:

    A = input("A : ")
    B = input("B : ")

If the user enters:
    10
    20

Then:

    A = "10"
    B = "20"

Therefore:

    A + B

will produce:

    "1020"

It will NOT produce:

    30

To perform numerical addition, convert the values to int.
"""

A = input("Enter A : ")
B = input("Enter B : ")

print(A + B)                 # String concatenation

A = int(A)
B = int(B)

print(A + B)                 # Numerical addition


# ============================================================
# 10. PRACTICAL EXAMPLE
# ============================================================
"""
Calculate the total price of two products.
"""

price1 = float(input("Enter price of product 1 : "))
price2 = float(input("Enter price of product 2 : "))

total = price1 + price2

print("Total price =", total)


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. input() is used to accept data from the user.

2. input() always returns the entered value as a string.

3. For integer input:
       int(input())

4. For decimal input:
       float(input())

5. Multiple values can be accepted using:
       input().split()

6. Multiple integer values can be accepted using:
       map(int, input().split())

7. Multiple float values can be accepted using:
       map(float, input().split())

8. input() + input() performs string concatenation.

9. For numerical calculations, convert the input into
   int or float before performing arithmetic operations.

10. split() separates input based on whitespace by default.

11. Type conversion is important when working with numeric
    user input.

12. Always remember:

       input() -> str
       int(input()) -> int
       float(input()) -> float
"""