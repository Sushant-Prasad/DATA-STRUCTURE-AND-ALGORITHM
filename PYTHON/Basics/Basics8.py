# ============================================================
#                    STRING FUNCTIONS / METHODS
# ============================================================
"""
Python provides many built-in methods for working with strings.

A string method is a function that is called using the string
object.

Syntax:

    string.method()

Example:

    text = "hello"
    text.upper()

String methods generally return a NEW string because strings
are immutable in Python.

Important:
    String methods do not modify the original string directly.

Example:

    text = "hello"
    result = text.upper()

    text   -> "hello"
    result -> "HELLO"
"""


# ============================================================
# 1. upper()
# ============================================================
"""
upper() converts all alphabetic characters to uppercase.

Syntax:
    string.upper()
"""

text = "hello world"

print(text.upper())
# Output: HELLO WORLD


# ============================================================
# 2. lower()
# ============================================================
"""
lower() converts all alphabetic characters to lowercase.

Syntax:
    string.lower()
"""

text = "HELLO WORLD"

print(text.lower())
# Output: hello world


# ============================================================
# 3. capitalize()
# ============================================================
"""
capitalize() converts the first character of the string
to uppercase and the remaining characters to lowercase.

Example:
    "hello world" -> "Hello world"
"""

text = "hello world"

print(text.capitalize())
# Output: Hello world


text = "pYTHON PROGRAMMING"

print(text.capitalize())
# Output: Python programming


# ============================================================
# 4. title()
# ============================================================
"""
title() converts the first character of each word to uppercase.

Example:
    "hello world" -> "Hello World"
"""

text = "hello world"

print(text.title())
# Output: Hello World


# ============================================================
# 5. swapcase()
# ============================================================
"""
swapcase() changes uppercase characters to lowercase and
lowercase characters to uppercase.
"""

text = "Hello World"

print(text.swapcase())
# Output: hELLO wORLD


# ============================================================
# 6. startswith()
# ============================================================
"""
startswith() checks whether a string starts with a specified
substring.

Returns:
    True  -> if the string starts with the given substring
    False -> otherwise

Syntax:
    string.startswith(substring)
"""

text = "Python Programming"

print(text.startswith("Python"))
# Output: True

print(text.startswith("Java"))
# Output: False


# ============================================================
# 7. endswith()
# ============================================================
"""
endswith() checks whether a string ends with a specified
substring.

Returns:
    True or False

Syntax:
    string.endswith(substring)
"""

text = "I am a coder."

print(text.endswith("coder."))
# Output: True

print(text.endswith("Python"))
# Output: False


# ============================================================
# 8. replace()
# ============================================================
"""
replace() replaces occurrences of one substring with another.

Syntax:
    string.replace(old, new)

It returns a new string.
"""

text = "I like Java"

result = text.replace("Java", "Python")

print(result)
# Output: I like Python


# By default, replace() replaces all matching occurrences.

text = "cat dog cat"

print(text.replace("cat", "fox"))
# Output: fox dog fox


# ============================================================
# 9. find()
# ============================================================
"""
find() returns the index of the FIRST occurrence of a substring.

Syntax:
    string.find(substring)

If the substring is not found, find() returns:

    -1
"""

text = "Python Programming"

print(text.find("Program"))
# Output: 7

print(text.find("Java"))
# Output: -1


# ============================================================
# 10. index()
# ============================================================
"""
index() is similar to find().

It returns the index of the first occurrence of a substring.

The important difference:

    find()  -> returns -1 if not found
    index() -> raises ValueError if not found
"""

text = "Python Programming"

print(text.index("Program"))
# Output: 7

# This would raise ValueError:
#
# print(text.index("Java"))


# ============================================================
# 11. count()
# ============================================================
"""
count() returns the number of non-overlapping occurrences of
a substring.

Syntax:
    string.count(substring)
"""

text = "banana"

print(text.count("a"))
# Output: 3

print(text.count("an"))
# Output: 2

print(text.count("x"))
# Output: 0


# ============================================================
# 12. strip()
# ============================================================
"""
strip() removes whitespace from both the beginning and end
of a string.

Whitespace can include:
    spaces
    tabs
    newlines
"""

text = "   Hello World   "

print(text.strip())
# Output: Hello World


# ============================================================
# 13. lstrip()
# ============================================================
"""
lstrip() removes whitespace from the LEFT side of a string.
"""

text = "   Hello World   "

print(text.lstrip())
# Output: Hello World


# ============================================================
# 14. rstrip()
# ============================================================
"""
rstrip() removes whitespace from the RIGHT side of a string.
"""

text = "   Hello World   "

print(text.rstrip())
# Output:    Hello World


# ============================================================
# 15. split()
# ============================================================
"""
split() divides a string into a list of substrings.

By default, whitespace is used as the separator.

Syntax:
    string.split()
"""

text = "Python is easy"

words = text.split()

print(words)
# Output:
# ['Python', 'is', 'easy']


# split() can also use a specific separator.

text = "apple,banana,orange"

fruits = text.split(",")

print(fruits)
# Output:
# ['apple', 'banana', 'orange']


# ============================================================
# 16. join()
# ============================================================
"""
join() joins elements of an iterable using the given string
as a separator.

Syntax:
    separator.join(iterable)
"""

words = ["Python", "is", "easy"]

result = " ".join(words)

print(result)
# Output:
# Python is easy


# Another example:

words = ["apple", "banana", "orange"]

result = ", ".join(words)

print(result)
# Output:
# apple, banana, orange


# ============================================================
# 17. isalpha()
# ============================================================
"""
isalpha() returns True if all characters in the string are
alphabetic and the string is not empty.

Spaces, numbers and special characters cause False.
"""

print("Python".isalpha())
# Output: True

print("Python123".isalpha())
# Output: False

print("Hello World".isalpha())
# Output: False


# ============================================================
# 18. isdigit()
# ============================================================
"""
isdigit() returns True if all characters are digits and the
string is not empty.
"""

print("12345".isdigit())
# Output: True

print("123abc".isdigit())
# Output: False

print("12.5".isdigit())
# Output: False


# ============================================================
# 19. isalnum()
# ============================================================
"""
isalnum() returns True if all characters are alphabetic
characters or digits.

Spaces and special characters are not allowed.
"""

print("Python123".isalnum())
# Output: True

print("Python 123".isalnum())
# Output: False

print("Python@123".isalnum())
# Output: False


# ============================================================
# 20. isspace()
# ============================================================
"""
isspace() returns True if all characters in the string are
whitespace characters and the string is not empty.
"""

print("   ".isspace())
# Output: True

print("Hello".isspace())
# Output: False


# ============================================================
# 21. islower()
# ============================================================
"""
islower() returns True if all cased alphabetic characters
are lowercase and there is at least one cased character.
"""

print("hello".islower())
# Output: True

print("Hello".islower())
# Output: False


# ============================================================
# 22. isupper()
# ============================================================
"""
isupper() returns True if all cased alphabetic characters
are uppercase and there is at least one cased character.
"""

print("HELLO".isupper())
# Output: True

print("Hello".isupper())
# Output: False


# ============================================================
# 23. zfill()
# ============================================================
"""
zfill() pads a numeric string with zeros on the LEFT until
the string reaches the specified width.
"""

number = "42"

print(number.zfill(5))
# Output: 00042


# ============================================================
# 24. center()
# ============================================================
"""
center() returns a centered string padded with spaces by
default.

Syntax:
    string.center(width)
"""

text = "Python"

print(text.center(12))
# Output:
#    Python


# A custom fill character can also be used.

print(text.center(12, "-"))
# Output:
# ---Python---


# ============================================================
# 25. ljust()
# ============================================================
"""
ljust() left-aligns the string within the specified width.
"""

text = "Python"

print(text.ljust(10, "-"))
# Output:
# Python----


# ============================================================
# 26. rjust()
# ============================================================
"""
rjust() right-aligns the string within the specified width.
"""

text = "Python"

print(text.rjust(10, "-"))
# Output:
# ----Python


# ============================================================
# 27. REMOVEPREFIX()
# ============================================================
"""
removeprefix() removes a specified prefix if the string
starts with that prefix.

If the prefix is not present, the original string is returned.
"""

text = "https://example.com"

print(text.removeprefix("https://"))
# Output:
# example.com


# ============================================================
# 28. REMOVESUFFIX()
# ============================================================
"""
removesuffix() removes a specified suffix if the string
ends with that suffix.

If the suffix is not present, the original string is returned.
"""

filename = "data.txt"

print(filename.removesuffix(".txt"))
# Output:
# data


# ============================================================
# 29. CASEFOLD()
# ============================================================
"""
casefold() performs a stronger form of lowercase conversion
and is useful for case-insensitive string comparisons.
"""

A = "PYTHON"
B = "python"

print(A.casefold() == B.casefold())
# Output:
# True


# ============================================================
# 30. PARTITION()
# ============================================================
"""
partition() divides a string into three parts:

    1. Part before the separator
    2. Separator
    3. Part after the separator

It returns a tuple.
"""

text = "name:Alex"

result = text.partition(":")

print(result)
# Output:
# ('name', ':', 'Alex')


# ============================================================
# 31. STRING METHODS WITH METHOD CHAINING
# ============================================================
"""
String methods can be chained together.

Example:

    strip()
    lower()
    replace()

The result of one method becomes the input for the next.
"""

text = "   HELLO WORLD   "

result = text.strip().lower().replace("world", "python")

print(result)
# Output:
# hello python


# ============================================================
#              IMPORTANT STRING METHODS SUMMARY
# ============================================================
"""
+------------------+-----------------------------------------+
| Method           | Purpose                                 |
+------------------+-----------------------------------------+
| upper()          | Converts to uppercase                   |
| lower()          | Converts to lowercase                   |
| capitalize()     | Capitalizes first character             |
| title()          | Capitalizes each word                   |
| swapcase()       | Swaps uppercase and lowercase           |
| startswith()     | Checks starting substring               |
| endswith()       | Checks ending substring                 |
| replace()        | Replaces substring                      |
| find()           | Finds first occurrence, returns -1      |
| index()          | Finds first occurrence, raises error    |
| count()          | Counts occurrences                      |
| strip()          | Removes whitespace from both sides      |
| lstrip()         | Removes left-side whitespace             |
| rstrip()         | Removes right-side whitespace            |
| split()          | Converts string into a list             |
| join()           | Joins iterable elements into a string   |
| isalpha()        | Checks alphabetic characters            |
| isdigit()        | Checks digits                           |
| isalnum()        | Checks letters and digits               |
| isspace()        | Checks whitespace                       |
| islower()        | Checks lowercase                        |
| isupper()        | Checks uppercase                        |
| zfill()          | Adds zeros to the left                  |
| center()         | Centers the string                      |
| ljust()          | Left-aligns the string                  |
| rjust()          | Right-aligns the string                 |
| removeprefix()   | Removes specified prefix                |
| removesuffix()   | Removes specified suffix                |
| casefold()       | Strong lowercase conversion             |
| partition()      | Splits around first separator           |
+------------------+-----------------------------------------+
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. String methods are called using dot notation:

       string.method()

2. Most string methods return a new string because strings
   are immutable.

3. upper(), lower(), capitalize(), title() and swapcase()
   are used for changing letter case.

4. find() returns -1 when the substring is not found.

5. index() raises ValueError when the substring is not found.

6. replace() returns a new string and does not modify the
   original string.

7. split() converts a string into a list.

8. join() converts an iterable of strings into a single string.

9. strip(), lstrip() and rstrip() are useful for removing
   unwanted whitespace.

10. isalpha(), isdigit(), isalnum() and isspace() return
    Boolean values.

11. startswith() and endswith() return True or False.

12. String methods can be chained:

       text.strip().lower().replace("old", "new")

13. String methods are different from built-in functions.

       len(text)       -> built-in function
       text.upper()    -> string method

14. String methods do not change the original string unless
    you assign the returned value back to a variable.

Example:

    text = "hello"
    text.upper()

    print(text)
    -> hello

    text = text.upper()

    print(text)
    -> HELLO
"""