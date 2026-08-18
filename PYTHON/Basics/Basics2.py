# ============================================================
#                  EXPRESSION EXECUTION IN PYTHON
# ============================================================
#
# An expression is a combination of values, variables, operators,
# and function calls that Python evaluates to produce a result.
#
# Example:
#
#     A + B * C
#
# Python evaluates the expression according to operator precedence.
#
#
# IMPORTANT RULES:
#
# 1. Numeric values can be used with arithmetic operators.
# 2. String + String performs concatenation.
# 3. String * Integer repeats the string.
# 4. Integer / Integer always produces a float.
# 5. Integer // Integer performs floor division.
# 6. Floor division gives the largest integer <= the result.
# 7. % gives the remainder.
# 8. The sign of the remainder follows the divisor.
# 9. An expression containing int and float generally produces
#    a float for arithmetic operations.
# 10. Operator precedence determines the order of evaluation.
#
# ============================================================
#                    KEY POINTS
# ============================================================
#
# +   -> Addition / String Concatenation
# -   -> Subtraction
# *   -> Multiplication / String Repetition
# /   -> True Division (always returns float)
# //  -> Floor Division
# %   -> Modulus / Remainder
# **  -> Exponentiation
#
# Operator precedence (important):
#
#     ()
#     **
#     *, /, //, %
#     +, -
#
# ============================================================


# ============================================================
# 1. NUMERIC VALUES WITH ARITHMETIC OPERATORS
# ============================================================

A = 2
B = 3
C = 4

# Multiplication has higher precedence than addition.
# Therefore:
#
#     A + B * C
#     = 2 + (3 * 4)
#     = 2 + 12
#     = 14

result = A + B * C

print(result)       # Output: 14


# ============================================================
# 2. STRING + STRING -> CONCATENATION
# ============================================================

# The + operator joins two strings together.

first_name = "Sushant"
last_name = "Prasad"

full_name = first_name + " " + last_name

print(full_name)    # Output: Sushant Prasad


# Another example:

A = "Hello"
B = "World"

print(A + " " + B)  # Output: Hello World


# IMPORTANT:
# String + Integer is NOT allowed directly.
#
# print("Age: " + 24)
#
# This produces a TypeError.
#
# Convert the integer into a string first:

age = 24

print("Age: " + str(age))     # Output: Age: 24


# ============================================================
# 3. STRING * INTEGER -> STRING REPETITION
# ============================================================

# A string can be multiplied by an integer.
# It repeats the string that many times.

txt = "@"

print(txt * 2)       # Output: @@
print(txt * 3)       # Output: @@@
print(2 * txt * 3)   # Output: @@@@@@
#
# Explanation:
#
# 2 * txt
# = @@
#
# @@ * 3
# = @@@@@@


# Another example:

word = "Hi"

print(word * 3)      # Output: HiHiHi


# ============================================================
# 4. INTEGER AND FLOAT IN AN EXPRESSION
# ============================================================

# When an arithmetic expression involves an integer and a float,
# the result is generally a float.

A = 10
B = 5.0

C = A * B

print(C)             # Output: 50.0

print(type(C))       # Output: <class 'float'>


# Another example:

A = 5
B = 2.5

print(A + B)         # Output: 7.5
print(A - B)         # Output: 2.5
print(A * B)         # Output: 12.5


# ============================================================
# 5. DIVISION (/) WITH TWO INTEGERS
# ============================================================

# The / operator performs true division.
#
# Even if both operands are integers,
# the result of / is always a float.

A = 1
B = 2

C = A / B

print(C)             # Output: 0.5
print(type(C))       # Output: <class 'float'>


# Another example:

print(10 / 2)        # Output: 5.0
print(7 / 2)         # Output: 3.5


# ============================================================
# 6. FLOOR DIVISION (//)
# ============================================================

# The // operator performs floor division.
#
# Floor division returns the largest integer that is
# LESS THAN OR EQUAL TO the actual division result.
#
# A // B is conceptually equivalent to:
#
#     floor(A / B)
#
# Example:

A = 12
B = 5

C = A // B

print(C)             # Output: 2
#
# 12 / 5 = 2.4
#
# Floor of 2.4 = 2


# ============================================================
# 7. FLOOR DIVISION WITH NEGATIVE VALUES
# ============================================================

# IMPORTANT:
# Floor division does NOT simply remove the decimal part.
#
# It moves towards negative infinity.

A = -12
B = 5

print(A / B)         # Output: -2.4
print(A // B)        # Output: -3
#
# Why?
#
# floor(-2.4) = -3
#
# Therefore:
#
#     -12 // 5 = -3


# Another example:

A = 12
B = -5

print(A / B)         # Output: -2.4
print(A // B)        # Output: -3
#
# floor(-2.4) = -3


# ============================================================
# 8. MODULUS (%) -> REMAINDER
# ============================================================

# The % operator returns the remainder after division.

A = 5
B = 2

C = A % B

print(C)             # Output: 1


# Because:
#
#     5 = (2 * 2) + 1
#
# Therefore:
#
#     5 % 2 = 1


# Another example:

print(10 % 3)        # Output: 1
print(15 % 4)        # Output: 3
print(20 % 5)        # Output: 0


# ============================================================
# 9. MODULUS WITH NEGATIVE VALUES
# ============================================================

# In Python, the remainder has the SAME SIGN as the divisor.
#
# This is an important rule to remember.

print(-5 % 2)        # Output: 1
print(5 % -2)        # Output: -1
#
# Explanation:
#
# -5 // 2 = -3
#
# Therefore:
#
# -5 % 2 = -5 - (2 * -3)
#         = -5 + 6
#         = 1
#
#
# And:
#
# 5 // -2 = -3
#
# Therefore:
#
# 5 % -2 = 5 - (-2 * -3)
#        = 5 - 6
#        = -1


# ============================================================
# 10. RELATIONSHIP BETWEEN // AND %
# ============================================================

# Python follows this mathematical relationship:
#
#     A = (A // B) * B + (A % B)
#
# Example:

A = 12
B = 5

print(A // B)        # 2
print(A % B)         # 2

# Verification:
#
#     12 = (12 // 5) * 5 + (12 % 5)
#     12 = 2 * 5 + 2
#     12 = 12


# Negative example:

A = -12
B = 5

print(A // B)        # -3
print(A % B)         # 3

# Verification:
#
#     -12 = (-3 * 5) + 3
#     -12 = -15 + 3
#     -12 = -12


# ============================================================
# 11. OPERATOR PRECEDENCE
# ============================================================

# Python follows a specific order while evaluating expressions.
#
# Higher priority operators are evaluated first.
#
# Order:
#
#     1. ()
#     2. **
#     3. *, /, //, %
#     4. +, -
#
#
# Example:

A = 2
B = 3
C = 4

print(A + B * C)

# First:
#     B * C = 3 * 4 = 12
#
# Then:
#     A + 12 = 14
#
# Output:
#     14


# ============================================================
# 12. USING PARENTHESES
# ============================================================

# Parentheses can change the order of execution.

A = 2
B = 3
C = 4

print(A + B * C)       # Output: 14

print((A + B) * C)     # Output: 20
#
# First expression:
#     2 + (3 * 4) = 14
#
# Second expression:
#     (2 + 3) * 4 = 20


# ============================================================
# 13. COMBINING DIFFERENT OPERATORS
# ============================================================

A = 10
B = 3

result = A + B * 2

print(result)          # Output: 16

# Execution:
#
#     10 + (3 * 2)
#     10 + 6
#     16


# ============================================================
# 14. EXPONENTIATION (**)
# ============================================================

# ** is used for raising a number to a power.

A = 2
B = 3

result = A ** B

print(result)          # Output: 8

# Because:
#
#     2 ** 3 = 2 * 2 * 2 = 8


# ============================================================
# 15. MIXING STRING AND NUMERIC OPERATIONS
# ============================================================

# String * Integer is allowed.

txt = "@"

A = 2
B = 3

print(A * txt * B)

# Execution:
#
#     2 * "@"
#     = "@@"
#
#     "@@" * 3
#     = "@@@@@@"
#
# Output:
#     @@@@@@


# But String + Integer is NOT allowed directly.
#
# print("Age: " + 24)
#
# Instead:

age = 24

print("Age: " + str(age))
# Output: Age: 24


# ============================================================
#                    KEY POINTS TO REMEMBER
# ============================================================
#
# 1. An expression is evaluated by Python to produce a value.
#
# 2. Numeric values support arithmetic operations:
#       +, -, *, /, //, %, **
#
# 3. String + String performs concatenation.
#
#       "Hello" + "World"
#       -> "HelloWorld"
#
# 4. String * Integer repeats the string.
#
#       "Hi" * 3
#       -> "HiHiHi"
#
# 5. String + Integer is NOT allowed directly.
#
#       "Age: " + 24
#       -> TypeError
#
# 6. The / operator always returns a float.
#
#       10 / 2
#       -> 5.0
#
# 7. The // operator performs floor division.
#
#       12 // 5
#       -> 2
#
#       -12 // 5
#       -> -3
#
# 8. Floor division means the result is rounded DOWN towards
#    negative infinity, not simply truncated.
#
# 9. The % operator returns the remainder.
#
#       5 % 2
#       -> 1
#
# 10. In Python, the remainder has the same sign as the divisor.
#
#       -5 % 2
#       -> 1
#
#       5 % -2
#       -> -1
#
# 11. Integer + Float generally produces a float.
#
#       10 + 2.5
#       -> 12.5
#
# 12. Parentheses can change the order of evaluation.
#
#       2 + 3 * 4
#       -> 14
#
#       (2 + 3) * 4
#       -> 20
#
# 13. Important operator precedence:
#
#       ()
#       **
#       *, /, //, %
#       +, -
#
# ============================================================