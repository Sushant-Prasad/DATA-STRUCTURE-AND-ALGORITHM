# ============================================================
# PYTHON TOKENS
# ============================================================
# Tokens are the smallest individual units of a Python program.
#
# There are 5 main types of tokens:
#
# 1. Keywords
#    Reserved words with special meaning.
#    Examples: if, else, for, while, def, class, return
#
# 2. Identifiers
#    Names given to variables, functions, classes, etc.
#    Examples: name, age, student_name, calculate_sum
#
# 3. Literals
#    Fixed values used directly in a program.
#    Examples: 10, 3.14, "Hello", True, False, None
#
# 4. Operators
#    Symbols/keywords used to perform operations.
#    Examples: +, -, *, /, ==, !=, >, <, =, and, or
#
# 5. Delimiters / Punctuators
#    Symbols used to structure Python code.
#    Examples: (), [], {}, ,, :, .
# ============================================================


# ------------------------------------------------------------
# BASIC EXAMPLE
# ------------------------------------------------------------

print("Hello World")


# ------------------------------------------------------------
# 1. KEYWORDS
# ------------------------------------------------------------

age = 20

if age >= 18:
    print("You are an adult")


# ------------------------------------------------------------
# 2. IDENTIFIERS
# ------------------------------------------------------------

name = "Sushant"
age = 24

print(name)
print(age)


# ------------------------------------------------------------
# 3. LITERALS
# ------------------------------------------------------------

integer_value = 100
float_value = 3.14
string_value = "Python"
boolean_value = True
empty_value = None

print(integer_value)
print(float_value)
print(string_value)
print(boolean_value)
print(empty_value)


# ------------------------------------------------------------
# 4. OPERATORS
# ------------------------------------------------------------

a = 10
b = 5

print(a + b)    # Addition
print(a - b)    # Subtraction
print(a * b)    # Multiplication
print(a / b)    # Division
print(a % b)    # Modulus
print(a ** b)   # Exponent


# ------------------------------------------------------------
# 5. DELIMITERS / PUNCTUATORS
# ------------------------------------------------------------

numbers = [10, 20, 30]

print(numbers)

# () -> Parentheses
# [] -> Square brackets
# {} -> Curly brackets
# ,  -> Comma
# :  -> Colon
# .  -> Dot