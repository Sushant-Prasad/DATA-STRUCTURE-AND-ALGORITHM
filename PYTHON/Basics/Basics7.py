# ============================================================
#                         STRING SLICING
# ============================================================
"""
String slicing is used to access a specific portion or
substring of a string.

Instead of accessing only one character using indexing,
slicing allows us to access multiple characters at once.

Syntax:

    string[start : stop]

where:

    start -> starting index (included)
    stop  -> ending index (NOT included)

Example:

    text = "Python"

    text[1:4]

Indexes:
    P  y  t  h  o  n
    0  1  2  3  4  5

    text[1:4]
    -> "yth"

Index 1 is included.
Index 4 is excluded.
"""


# ============================================================
# 1. BASIC SLICING
# ============================================================

text = "Python"

print(text[1:4])       # yth
print(text[0:3])       # Pyt
print(text[2:5])       # tho


# ============================================================
# 2. STARTING INDEX
# ============================================================
"""
The starting index is included in the slice.

Example:

    text[1:4]

starts from index 1 and continues up to index 3.
"""

text = "Python"

print(text[1:4])       # yth


# ============================================================
# 3. ENDING INDEX
# ============================================================
"""
The ending index is NOT included.

Example:

    text[1:4]

Indexes used:

    1 -> included
    2 -> included
    3 -> included
    4 -> excluded

Therefore:

    text[1:4] -> "yth"
"""


# ============================================================
# 4. OMITTING THE START INDEX
# ============================================================
"""
If the start index is omitted, Python starts from index 0.

Syntax:

    string[:stop]

Example:

    text[:4]

is equivalent to:

    text[0:4]
"""

text = "Python"

print(text[:4])        # Pyth
print(text[0:4])       # Pyth


# ============================================================
# 5. OMITTING THE END INDEX
# ============================================================
"""
If the end index is omitted, Python continues until the
end of the string.

Syntax:

    string[start:]

Example:

    text[2:]

is equivalent to:

    text[2:len(text)]
"""

text = "Python"

print(text[2:])        # thon
print(text[2:len(text)])  # thon


# ============================================================
# 6. OMITTING BOTH START AND END
# ============================================================
"""
If both start and end are omitted:

    string[:]

the entire string is returned.
"""

text = "Python"

print(text[:])          # Python


# ============================================================
# 7. NEGATIVE INDEXING WITH SLICING
# ============================================================
"""
Negative indexes allow us to count from the end of a string.

Example:

    text = "Apple"

Positive indexes:
    A  p  p  l  e
    0  1  2  3  4

Negative indexes:
    A   p   p   l   e
   -5  -4  -3  -2  -1

Example:

    text[-3:-1]

Index -3 is included.
Index -1 is excluded.

Result:

    "pl"
"""

text = "Apple"

print(text[-3:-1])     # pl


# ============================================================
# 8. NEGATIVE INDEX WITH OMITTED END
# ============================================================
"""
Example:

    text[:-2]

This means:

    Start from the beginning
    Stop before index -2

For "Python":

    P  y  t  h  o  n
    0  1  2  3  4  5
   -6 -5 -4 -3 -2 -1

text[:-2]
-> "Pyth"
"""

text = "Python"

print(text[:-2])       # Pyth


# ============================================================
# 9. NEGATIVE INDEX WITH OMITTED START
# ============================================================
"""
Example:

    text[-3:]

This starts from index -3 and continues to the end.
"""

text = "Python"

print(text[-3:])       # hon


# ============================================================
# 10. SLICING WITH STEP
# ============================================================
"""
Python slicing also supports a third value called step.

Syntax:

    string[start : stop : step]

start -> where slicing starts
stop  -> where slicing stops (excluded)
step  -> how many positions to move at a time

Example:

    text[0:6:2]

For "Python":

    P y t h o n
    0 1 2 3 4 5

Take every 2nd character:

    P -> index 0
    t -> index 2
    o -> index 4

Result:
    "Pto"
"""

text = "Python"

print(text[0:6:2])      # Pto


# ============================================================
# 11. STEP = 1
# ============================================================
"""
If step is not specified, the default step is 1.

Therefore:

    text[1:5]

is equivalent to:

    text[1:5:1]
"""

text = "Python"

print(text[1:5])        # ytho
print(text[1:5:1])      # ytho


# ============================================================
# 12. STEP = 2
# ============================================================
"""
A step of 2 selects every second character.
"""

text = "Python"

print(text[::2])        # Pto


# ============================================================
# 13. STEP = 3
# ============================================================
"""
A step of 3 selects every third character.
"""

text = "Programming"

print(text[::3])


# ============================================================
# 14. NEGATIVE STEP
# ============================================================
"""
A negative step moves through the string from right to left.

Example:

    text[::-1]

This reverses the string.

For:

    "Python"

Result:

    "nohtyP"
"""

text = "Python"

print(text[::-1])       # nohtyP


# ============================================================
# 15. REVERSE USING SLICING
# ============================================================
"""
The most common way to reverse a string using slicing is:

    string[::-1]

The three parts are:

    start -> omitted
    stop  -> omitted
    step  -> -1
"""

text = "Hello World"

print(text[::-1])       # dlroW olleH


# ============================================================
# 16. NEGATIVE STEP WITH START AND STOP
# ============================================================
"""
When using a negative step, the slicing direction is
from right to left.

Example:

    text[5:1:-1]

For "Python":

    P  y  t  h  o  n
    0  1  2  3  4  5

Start at index 5 and move backwards.
Index 1 is excluded.

Result:

    "noht"
"""

text = "Python"

print(text[5:1:-1])     # noht


# ============================================================
# 17. COPYING A STRING USING SLICING
# ============================================================
"""
Using [:] creates a slice containing the complete string.

Example:

    text2 = text[:]
"""

text = "Python"

text2 = text[:]

print(text2)            # Python


# ============================================================
# 18. SLICING WITH DIFFERENT COMBINATIONS
# ============================================================

text = "Programming"

print(text[0:5])        # Progr
print(text[3:8])        # gramm
print(text[:5])         # Progr
print(text[5:])         # amming
print(text[:])          # Programming
print(text[::2])        # Pormig
print(text[1::2])       # rgamn
print(text[::-1])       # gnimmargorP


# ============================================================
# 19. STRING SLICING DOES NOT MODIFY THE ORIGINAL STRING
# ============================================================
"""
Strings are immutable.

Slicing creates and returns a new string; it does not modify
the original string.
"""

text = "Python"

part = text[1:4]

print(text)             # Python
print(part)             # yth


# ============================================================
# 20. COMMON SLICING PATTERNS
# ============================================================
"""
Some useful slicing patterns:

    text[:]       -> Complete string
    text[start:]  -> From start to end
    text[:stop]   -> Beginning to stop
    text[::2]     -> Every second character
    text[::3]     -> Every third character
    text[::-1]    -> Reverse string
    text[:-1]     -> Everything except last character
    text[1:-1]    -> Everything except first and last
"""

text = "Python"

print(text[:])          # Python
print(text[2:])         # thon
print(text[:4])         # Pyth
print(text[::2])        # Pto
print(text[::-1])       # nohtyP
print(text[:-1])        # Pytho
print(text[1:-1])       # ytho


# ============================================================
# 21. IMPORTANT DIFFERENCE: INDEXING VS SLICING
# ============================================================
"""
Indexing returns a SINGLE character.

    text[2]

Slicing returns a SUBSTRING.

    text[1:4]
"""

text = "Python"

print(text[2])          # t
print(text[1:4])        # yth


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. Slicing is used to access a portion of a string.

2. Basic syntax:

       string[start : stop]

3. The start index is INCLUDED.

4. The stop index is NOT INCLUDED.

5. If start is omitted, slicing starts from index 0.

       text[:4]
       -> text[0:4]

6. If stop is omitted, slicing continues until the end.

       text[2:]

7. If both are omitted:

       text[:]

   returns the complete string.

8. Negative indexes can be used in slicing.

9. The complete slicing syntax is:

       string[start : stop : step]

10. The default step is 1.

11. A positive step moves from left to right.

12. A negative step moves from right to left.

13. The most common way to reverse a string is:

       text[::-1]

14. Slicing does not modify the original string because
    strings are immutable.

15. Indexing returns one character:

       text[2]

16. Slicing returns multiple characters:

       text[1:4]

17. The stop index is always excluded.

18. Examples:

       "Python"[1:4]   -> "yth"
       "Python"[:4]    -> "Pyth"
       "Python"[2:]    -> "thon"
       "Python"[:]     -> "Python"
       "Python"[::2]   -> "Pto"
       "Python"[::-1]  -> "nohtyP"
"""