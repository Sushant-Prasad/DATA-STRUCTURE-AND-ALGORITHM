# ============================================================
#                         STRINGS
# ============================================================
"""
A string is a sequence of characters enclosed inside quotes.

Characters can include:
    - Letters
    - Numbers
    - Spaces
    - Special characters
    - Symbols

Examples:
    "Hello"
    'Python'
    "12345"
    "Hello World!"

In Python, strings are represented by the str data type.

Example:
    name = "Sushant"
"""

name = "Sushant"

print(name)
print(type(name))       # <class 'str'>


# ============================================================
# 1. SINGLE, DOUBLE AND TRIPLE QUOTES
# ============================================================
"""
Python supports three common ways of creating strings:

1. Single quotes:
       'Hello'

2. Double quotes:
       "Hello"

3. Triple quotes:
       '''Hello'''
       or
       \"\"\"Hello\"\"\"

Single and double quotes are generally used for normal
single-line strings.

Triple quotes are mainly useful for:
    - Multi-line strings
    - Documentation strings (docstrings)
"""

single_quote = 'Hello Python'
double_quote = "Hello Python"

print(single_quote)
print(double_quote)


# Triple single quotes

multi_line_1 = '''
This is a
multi-line
string.
'''

print(multi_line_1)


# Triple double quotes

multi_line_2 = """
This is another
multi-line
string.
"""

print(multi_line_2)


# ============================================================
# 2. WHEN TO USE SINGLE OR DOUBLE QUOTES
# ============================================================
"""
Single and double quotes have the same basic purpose.

The choice is mostly based on readability and avoiding
unnecessary escaping.

For example, if the string contains an apostrophe, double
quotes can be convenient.
"""

message = "It's a beautiful day."

print(message)


# If double quotes are inside the string, single quotes
# can be convenient.

message = 'He said "Hello".'

print(message)


# ============================================================
# 3. ESCAPE SEQUENCES
# ============================================================
"""
An escape sequence is a special sequence of characters
starting with a backslash (\\).

Escape sequences are used to represent special characters
inside strings.

Common escape sequences:

    \\n   -> New line
    \\t   -> Tab
    \\\\   -> Backslash
    \\'   -> Single quote
    \\"   -> Double quote
    \\b   -> Backspace
"""

# New line

print("Hello\nWorld")


# Tab

print("Hello\tWorld")


# Single quote inside a single-quoted string

print('It\'s Python')


# Double quote inside a double-quoted string

print("He said \"Hello\".")


# Backslash

print("C:\\Users\\Sushant\\Python")


# ============================================================
# 4. BASIC STRING OPERATIONS
# ============================================================
"""
Some common operations that can be performed on strings are:

    1. Concatenation
    2. Repetition
    3. Finding length
    4. Indexing
    5. Membership checking
"""

# ------------------------------------------------------------
# Concatenation (+)
# ------------------------------------------------------------
"""
The + operator joins two or more strings.

Example:

    "Hello" + "World"
    -> "HelloWorld"
"""

A = "Hello"
B = "World"

print(A + B)             # HelloWorld

print(A + " " + B)       # Hello World


# ------------------------------------------------------------
# Repetition (*)
# ------------------------------------------------------------
"""
The * operator can repeat a string a specified number of times.

Example:

    "Hi" * 3
    -> "HiHiHi"
"""

text = "Hi"

print(text * 3)          # HiHiHi
print("@ " * 3)          # @ @ @


# ------------------------------------------------------------
# Length of a string
# ------------------------------------------------------------
"""
The len() function returns the number of characters in a string.

Syntax:

    len(string)

Spaces are also counted as characters.
"""

text = "Python"

print(len(text))         # 6

text = "Hello World"

print(len(text))         # 11


# ============================================================
# 5. STRING INDEXING
# ============================================================
"""
Indexing means accessing an individual character from a string
using its position.

Python uses ZERO-BASED INDEXING.

That means the first character has index 0.

Example:

    text = "Python"

    Character:  P  y  t  h  o  n
    Index:      0  1  2  3  4  5

Syntax:

    string[index]
"""

text = "Python"

print(text[0])            # P
print(text[1])            # y
print(text[2])            # t
print(text[3])            # h
print(text[4])            # o
print(text[5])            # n


# ============================================================
# 6. NEGATIVE INDEXING
# ============================================================
"""
Python also supports negative indexing.

Negative indexing starts from the end of the string.

Example:

    text = "Python"

    Character:   P   y   t   h   o   n
    Positive:    0   1   2   3   4   5
    Negative:   -6  -5  -4  -3  -2  -1

Therefore:

    text[-1] -> n
    text[-2] -> o
"""

text = "Python"

print(text[-1])           # n
print(text[-2])           # o
print(text[-3])           # h


# ============================================================
# 7. STRING INDEXING EXAMPLE
# ============================================================
"""
Consider:

    text = "Apna_College"

Index positions:

    A  p  n  a  _  C  o  l  l  e  g  e
    0  1  2  3  4  5  6  7  8  9 10 11

Therefore:

    text[0]  -> A
    text[1]  -> p
    text[2]  -> n
    text[5]  -> C
    text[-1] -> e
"""

text = "Apna_College"

print(text[0])            # A
print(text[2])            # n
print(text[5])            # C
print(text[-1])           # e


# ============================================================
# 8. STRINGS ARE IMMUTABLE
# ============================================================
"""
Strings in Python are immutable.

Immutable means that once a string is created, its individual
characters cannot be changed.

For example:

    text = "Python"
    text[0] = "J"

This is NOT allowed and produces a TypeError.

You cannot modify a character directly using indexing.
"""

text = "Python"

# This is NOT allowed:
#
# text[0] = "J"


# Instead, create a new string:

text = "J" + text[1:]

print(text)              # Jython


# ============================================================
# 9. MEMBERSHIP OPERATORS WITH STRINGS
# ============================================================
"""
The 'in' and 'not in' operators can be used to check whether
a character or substring exists inside a string.
"""

text = "Python Programming"

print("Python" in text)           # True
print("Java" in text)             # False

print("Java" not in text)         # True
print("Program" in text)          # True


# ============================================================
# 10. STRING COMPARISON
# ============================================================
"""
Strings can be compared using comparison operators.

Python compares strings lexicographically, based on the
Unicode values of their characters.
"""

A = "apple"
B = "banana"

print(A == B)             # False
print(A != B)             # True
print(A < B)              # True


# ============================================================
# 11. IMPORTANT STRING EXAMPLES
# ============================================================

first_name = "Sushant"
last_name = "Prasad"

# Concatenation

full_name = first_name + " " + last_name

print(full_name)


# Length

print(len(full_name))


# Indexing

print(full_name[0])
print(full_name[-1])


# Repetition

print("Python " * 3)


# Membership

print("Sushant" in full_name)


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. A string is a sequence of characters.

2. Strings are represented by the str data type.

3. Strings can be created using:
       'single quotes'
       "double quotes"
       '''triple single quotes'''
       \"\"\"triple double quotes\"\"\"

4. Triple quotes are useful for multi-line strings and
   docstrings.

5. Common escape sequences:
       \\n  -> New line
       \\t  -> Tab
       \\\\  -> Backslash
       \\'  -> Single quote
       \\"  -> Double quote

6. The + operator performs string concatenation.

       "Hello" + "World"
       -> "HelloWorld"

7. The * operator repeats a string.

       "Hi" * 3
       -> "HiHiHi"

8. len() returns the number of characters in a string.

       len("Python")
       -> 6

9. Python uses zero-based indexing.

       text[0] -> first character

10. Negative indexing starts from -1 at the last character.

       text[-1] -> last character

11. Strings are immutable.
    Individual characters cannot be changed directly.

12. The 'in' and 'not in' operators can be used to search
    for characters or substrings.

13. Spaces are also counted when calculating string length.

14. A string can contain letters, numbers, spaces and
    special characters.

15. input() returns a string by default.

       name = input("Name: ")

       type(name)
       -> <class 'str'>
"""