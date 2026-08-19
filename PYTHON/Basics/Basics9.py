# ============================================================
#                  CONDITIONAL STATEMENTS
# ============================================================
"""
Conditional statements are used to make decisions in a Python
program.

They allow the program to execute different blocks of code
depending on whether a condition is True or False.

Basic structure:

    if condition:
        statement

The condition produces a Boolean result:

    True
    False

If the condition is True, the indented block is executed.
If the condition is False, the block is skipped.

Main conditional statements in Python:

    1. if
    2. if-else
    3. if-elif-else
    4. Nested if
    5. Nested if-else
"""


# ============================================================
# 1. if STATEMENT
# ============================================================
"""
The if statement executes a block of code only when its
condition is True.

Syntax:

    if condition:
        statement

The colon (:) marks the beginning of the if block.
"""

age = 20

if age >= 18:
    print("Eligible to vote")


# If the condition is False, the block is skipped.

age = 15

if age >= 18:
    print("Eligible to vote")

print("Program continues...")


# ============================================================
# 2. INDENTATION
# ============================================================
"""
Indentation means adding spaces at the beginning of a line.

Python uses indentation to define blocks of code.

Example:

    if age >= 18:
        print("Eligible")

The print() statement belongs to the if block because it is
indented.

Python convention:
    Use 4 spaces for one indentation level.

IMPORTANT:

    if age >= 18:
        print("Eligible")

    print("Program continues")

The first print() belongs to the if block.
The second print() does not.
"""

age = 20

if age >= 18:
    print("Inside if block")

print("Outside if block")


# ============================================================
# 3. MULTIPLE STATEMENTS INSIDE IF
# ============================================================
"""
Multiple statements can belong to the same if block.

All statements at the same indentation level belong to
the same block.
"""

age = 20

if age >= 18:
    print("Age is", age)
    print("Eligible to vote")
    print("Condition is True")

print("Program continues")


# ============================================================
# 4. if-else STATEMENT
# ============================================================
"""
The if-else statement provides two possible paths.

If the condition is True:
    if block executes.

If the condition is False:
    else block executes.

Syntax:

    if condition:
        statement
    else:
        statement
"""

age = 16

if age >= 18:
    print("Eligible to vote")
else:
    print("Not eligible to vote")


# ============================================================
# 5. if-else WITH COMPARISON
# ============================================================

A = 10
B = 20

if A > B:
    print("A is greater")
else:
    print("B is greater")


# ============================================================
# 6. if-else WITH EQUALITY
# ============================================================

password = "python123"

if password == "python123":
    print("Correct password")
else:
    print("Incorrect password")


# ============================================================
# 7. if-elif-else STATEMENT
# ============================================================
"""
When there are multiple conditions, we can use elif.

elif means "else if".

Structure:

    if condition1:
        statement
    elif condition2:
        statement
    elif condition3:
        statement
    else:
        statement

Python checks conditions from top to bottom.

As soon as one condition is True, its block executes and
the remaining conditions are skipped.
"""

marks = 75

if marks >= 90:
    print("Grade A+")
elif marks >= 80:
    print("Grade A")
elif marks >= 70:
    print("Grade B")
elif marks >= 60:
    print("Grade C")
else:
    print("Grade D")


# ============================================================
# 8. IMPORTANT: ORDER OF CONDITIONS
# ============================================================
"""
The order of conditions is important.

Python checks an if-elif-else chain from top to bottom.

Example:

    marks = 95

If we check:

    if marks >= 70:
        ...

first, the condition is already True, so Python will not
check the later conditions.

Therefore, more specific/higher conditions should generally
come first when using ranges.
"""

marks = 95

if marks >= 90:
    print("A+")
elif marks >= 80:
    print("A")
elif marks >= 70:
    print("B")
else:
    print("C")


# ============================================================
# 9. NESTED if
# ============================================================
"""
A nested if means an if statement inside another if statement.

Syntax:

    if condition1:
        if condition2:
            statement

The inner if is checked only when the outer if condition
is True.
"""

age = 20
has_id = True

if age >= 18:
    if has_id:
        print("Entry allowed")


# Execution:

"""
First:

    age >= 18

If True, Python enters the outer if.

Then:

    has_id

If True, Python executes:

    print("Entry allowed")
"""


# ============================================================
# 10. NESTED if-else
# ============================================================
"""
An inner if can also have an else block.

Example:

    if condition1:
        if condition2:
            statement
        else:
            statement
    else:
        statement
"""

age = 20
has_id = False

if age >= 18:
    if has_id:
        print("Entry allowed")
    else:
        print("ID is required")
else:
    print("Age requirement not satisfied")


# ============================================================
# 11. NESTED if WITH MULTIPLE LEVELS
# ============================================================
"""
An if statement can be nested inside another if statement,
which can itself contain another if statement.

However, excessive nesting can make code difficult to read.
"""

age = 25
has_id = True
has_ticket = True

if age >= 18:
    if has_id:
        if has_ticket:
            print("Entry allowed")
        else:
            print("Ticket required")
    else:
        print("ID required")
else:
    print("Age requirement not satisfied")


# ============================================================
# 12. NESTED if vs LOGICAL OPERATORS
# ============================================================
"""
Sometimes nested if statements can be simplified using
logical operators.

Nested version:

    if age >= 18:
        if has_id:
            print("Allowed")

Equivalent logical condition:

    if age >= 18 and has_id:
        print("Allowed")

Both can produce the same result.

Use logical operators when the conditions naturally belong
together.
"""

age = 20
has_id = True

if age >= 18 and has_id:
    print("Allowed")


# ============================================================
# 13. MULTIPLE CONDITIONS USING and
# ============================================================
"""
The 'and' operator requires ALL conditions to be True.
"""

age = 25
has_id = True

if age >= 18 and has_id:
    print("Allowed")


# ============================================================
# 14. MULTIPLE CONDITIONS USING or
# ============================================================
"""
The 'or' operator requires at least ONE condition to be True.
"""

day = "Saturday"

if day == "Saturday" or day == "Sunday":
    print("Weekend")


# ============================================================
# 15. NOT OPERATOR
# ============================================================
"""
The 'not' operator reverses a Boolean value.

    True  -> False
    False -> True
"""

is_raining = False

if not is_raining:
    print("You can go outside")


# ============================================================
# 16. CONDITIONAL STATEMENT WITH MEMBERSHIP
# ============================================================
"""
The 'in' operator can be used inside conditions.
"""

languages = ["Python", "Java", "C++"]

language = "Python"

if language in languages:
    print("Language found")
else:
    print("Language not found")


# ============================================================
# 17. CONDITIONAL STATEMENT WITH STRING
# ============================================================

text = "Python Programming"

if "Python" in text:
    print("Python is present")


# ============================================================
# 18. CONDITIONAL STATEMENT WITH USER INPUT
# ============================================================
"""
input() returns a string, so numeric input should be converted
before performing numerical comparisons.
"""

age = int(input("Enter your age: "))

if age >= 18:
    print("Adult")
else:
    print("Minor")


# ============================================================
# 19. EVEN OR ODD
# ============================================================
"""
The modulus operator (%) can be used to check whether a number
is even or odd.

For an even number:

    number % 2 == 0

For an odd number:

    number % 2 != 0
"""

number = int(input("Enter a number: "))

if number % 2 == 0:
    print("Even")
else:
    print("Odd")


# ============================================================
# 20. POSITIVE, NEGATIVE OR ZERO
# ============================================================

number = int(input("Enter a number: "))

if number > 0:
    print("Positive")
elif number < 0:
    print("Negative")
else:
    print("Zero")


# ============================================================
# 21. LARGEST OF TWO NUMBERS
# ============================================================

A = 25
B = 40

if A > B:
    print("A is greater")
elif B > A:
    print("B is greater")
else:
    print("Both are equal")


# ============================================================
# 22. LARGEST OF THREE NUMBERS
# ============================================================

A = 10
B = 25
C = 15

if A >= B and A >= C:
    print("A is largest")
elif B >= A and B >= C:
    print("B is largest")
else:
    print("C is largest")


# ============================================================
# 23. NESTED CONDITION EXAMPLE
# ============================================================
"""
Determine whether a person can access a system.

Requirements:
    1. Age must be at least 18.
    2. The user must have a valid ID.
    3. The user must have a valid password.
"""

age = 22
has_id = True
password_correct = True

if age >= 18:
    if has_id:
        if password_correct:
            print("Access granted")
        else:
            print("Incorrect password")
    else:
        print("Valid ID required")
else:
    print("Age requirement not satisfied")


# ============================================================
# 24. CONDITIONAL EXPRESSION (TERNARY OPERATOR)
# ============================================================
"""
Python also supports a one-line conditional expression.

Syntax:

    value_if_true if condition else value_if_false

Example:
"""

age = 20

result = "Adult" if age >= 18 else "Minor"

print(result)


# Another example:

number = 10

result = "Even" if number % 2 == 0 else "Odd"

print(result)


# ============================================================
# 25. PASS STATEMENT
# ============================================================
"""
pass is used when a block is required syntactically but
we do not want to execute any statement yet.

It acts as a placeholder.
"""

age = 20

if age >= 18:
    pass
else:
    print("Minor")


# ============================================================
#                     INDENTATION RULES
# ============================================================
"""
1. Python uses indentation to define code blocks.

2. The standard convention is 4 spaces per indentation level.

3. The statements inside an if block must have the same
   indentation.

Correct:

    if age >= 18:
        print("Adult")
        print("Eligible")


Incorrect:

    if age >= 18:
    print("Adult")

The incorrect version produces an IndentationError.

4. Do not randomly mix indentation levels.

5. Nested blocks require another level of indentation.

Example:

    if condition1:
        if condition2:
            print("Both conditions are True")

Here:
    if condition1 -> indentation level 0
    if condition2 -> indentation level 1
    print()       -> indentation level 2
"""


# ============================================================
#                    KEY POINTS
# ============================================================
"""
1. Conditional statements allow a program to make decisions.

2. The main conditional statements are:

       if
       if-else
       if-elif-else
       nested if

3. A condition normally produces True or False.

4. The colon (:) is required after the condition.

       if age >= 18:

5. Python uses indentation to identify blocks.

6. The standard indentation is 4 spaces.

7. An if block executes only when its condition is True.

8. An else block executes when the preceding if condition
   is False.

9. elif is used to check multiple conditions.

10. In an if-elif-else chain, Python executes the first
    matching True condition and skips the remaining conditions.

11. Nested if means placing one conditional statement inside
    another conditional statement.

12. Nested conditions can sometimes be simplified using
    logical operators such as:

       and
       or
       not

13. 'and' requires all conditions to be True.

14. 'or' requires at least one condition to be True.

15. 'not' reverses a Boolean value.

16. The 'in' and 'not in' operators can also be used in
    conditional statements.

17. Python supports a one-line conditional expression:

       value1 if condition else value2

18. Use indentation consistently. Incorrect indentation can
    result in IndentationError.

19. A colon (:) starts a new code block, and indentation
    determines which statements belong to that block.

20. Avoid unnecessary deep nesting because it makes code
    harder to read and maintain.
"""