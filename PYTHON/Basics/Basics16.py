# ============================================================
#                  BREAK AND CONTINUE
# ============================================================
"""
break and continue are loop-control statements.

They change the normal flow of execution inside a loop.

There are two important statements:

1. break
2. continue

------------------------------------------------------------
break
------------------------------------------------------------

The break statement immediately terminates the nearest loop.

Once break is executed, Python comes completely out of
that loop and continues executing the code after the loop.

Syntax:

    for/while condition:
        if condition:
            break

------------------------------------------------------------
continue
------------------------------------------------------------

The continue statement skips the CURRENT iteration and
moves to the NEXT iteration of the loop.

The loop itself does NOT terminate.

Syntax:

    for/while condition:
        if condition:
            continue
"""


# ============================================================
# 1. BREAK WITH FOR LOOP
# ============================================================
"""
Suppose we want to print numbers from 1 to 10, but stop
when we reach 5.
"""

for i in range(1, 11):

    if i == 5:
        break

    print(i)

# Output:
# 1
# 2
# 3
# 4


# ============================================================
# 2. HOW BREAK WORKS
# ============================================================
"""
Execution:

i = 1 -> condition False -> print 1
i = 2 -> condition False -> print 2
i = 3 -> condition False -> print 3
i = 4 -> condition False -> print 4
i = 5 -> condition True  -> break

After break, the loop terminates.

The values 5, 6, 7, 8, 9 and 10 are NOT processed.
"""


# ============================================================
# 3. CODE AFTER BREAK
# ============================================================
"""
break only terminates the loop.

It does NOT terminate the entire program.
"""

for i in range(1, 11):

    if i == 5:
        break

    print(i)

print("Loop ended")

# Output:
# 1
# 2
# 3
# 4
# Loop ended


# ============================================================
# 4. BREAK WITH WHILE LOOP
# ============================================================

i = 1

while i <= 10:

    if i == 5:
        break

    print(i)

    i += 1

# Output:
# 1
# 2
# 3
# 4


# ============================================================
# 5. BREAK FOR SEARCHING
# ============================================================
"""
A common use of break is searching for an element.

Once the element is found, there is no need to continue
searching, so we use break.
"""

numbers = [10, 20, 30, 40, 50]

target = 30

for number in numbers:

    if number == target:
        print("Element found")
        break

# Output:
# Element found


# ============================================================
# 6. BREAK WITH INDEX
# ============================================================

numbers = [10, 20, 30, 40, 50]

target = 40

for i in range(len(numbers)):

    if numbers[i] == target:
        print("Element found at index:", i)
        break

# Output:
# Element found at index: 3


# ============================================================
# 7. BREAK WITH USER INPUT
# ============================================================
"""
break is useful when we want to stop taking input after
a particular condition is satisfied.

Here, entering 0 stops the loop.
"""

while True:

    number = int(input("Enter number: "))

    if number == 0:
        break

    print("You entered:", number)

"""
Example Input:
5
10
20
0

Output:
You entered: 5
You entered: 10
You entered: 20
"""


# ============================================================
# 8. INFINITE LOOP + BREAK
# ============================================================
"""
while True creates a loop that is intentionally infinite.

break is then used to decide when the loop should stop.

This pattern is very common in menu-driven programs.
"""

while True:

    number = int(input("Enter a number (0 to stop): "))

    if number == 0:
        break

    print("Number:", number)

"""
Example Input:
10
20
0

Output:
Number: 10
Number: 20
"""


# ============================================================
# 9. CONTINUE WITH FOR LOOP
# ============================================================
"""
continue skips the current iteration.

Here, when i becomes 3, print(i) is skipped.
"""

for i in range(1, 6):

    if i == 3:
        continue

    print(i)

# Output:
# 1
# 2
# 4
# 5


# ============================================================
# 10. HOW CONTINUE WORKS
# ============================================================
"""
Execution:

i = 1 -> print 1
i = 2 -> print 2
i = 3 -> continue -> skip print
i = 4 -> print 4
i = 5 -> print 5

The loop continues after skipping the iteration for 3.
"""


# ============================================================
# 11. CONTINUE WITH WHILE LOOP
# ============================================================
"""
IMPORTANT:

When using continue in a while loop, make sure the loop
variable is updated before continue.

Otherwise, the loop can become infinite.
"""

i = 1

while i <= 5:

    if i == 3:
        i += 1
        continue

    print(i)

    i += 1

# Output:
# 1
# 2
# 4
# 5


# ============================================================
# 12. CONTINUE TO SKIP EVEN NUMBERS
# ============================================================
"""
We can use continue to skip unwanted values.
"""

for i in range(1, 11):

    if i % 2 == 0:
        continue

    print(i)

# Output:
# 1
# 3
# 5
# 7
# 9


# ============================================================
# 13. CONTINUE TO PRINT ONLY EVEN NUMBERS
# ============================================================

for i in range(1, 11):

    if i % 2 != 0:
        continue

    print(i)

# Output:
# 2
# 4
# 6
# 8
# 10


# ============================================================
# 14. CONTINUE WITH LIST
# ============================================================
"""
Suppose we want to print only positive numbers and skip
negative numbers.
"""

numbers = [10, -5, 20, -8, 30, -2]

for number in numbers:

    if number < 0:
        continue

    print(number)

# Output:
# 10
# 20
# 30


# ============================================================
# 15. CONTINUE WITH STRING
# ============================================================
"""
Skip spaces and print the remaining characters.
"""

text = "Hello World"

for character in text:

    if character == " ":
        continue

    print(character, end="")

print()

# Output:
# HelloWorld


# ============================================================
# 16. BREAK VS CONTINUE
# ============================================================
"""
BREAK
------------------------------------------------------------
break completely terminates the loop.

Example:

    for i in range(1, 6):

        if i == 3:
            break

        print(i)

Output:
    1
    2

The loop stops when i becomes 3.


CONTINUE
------------------------------------------------------------
continue skips only the current iteration.

Example:

    for i in range(1, 6):

        if i == 3:
            continue

        print(i)

Output:
    1
    2
    4
    5

The loop continues after skipping 3.
"""


# ============================================================
# 17. BREAK AND CONTINUE TOGETHER
# ============================================================
"""
We can use both statements in the same loop.

Here:

    - continue skips even numbers
    - break stops the loop when number becomes greater than 7
"""

for i in range(1, 11):

    if i % 2 == 0:
        continue

    if i > 7:
        break

    print(i)

# Output:
# 1
# 3
# 5
# 7


# ============================================================
# 18. BREAK IN NESTED LOOPS
# ============================================================
"""
break terminates only the NEAREST loop in which it appears.

It does not automatically terminate all outer loops.
"""

for i in range(1, 4):

    for j in range(1, 4):

        if j == 2:
            break

        print(i, j)

# Output:
# 1 1
# 2 1
# 3 1


# ============================================================
# 19. CONTINUE IN NESTED LOOPS
# ============================================================
"""
continue affects only the nearest loop in which it appears.
"""

for i in range(1, 4):

    for j in range(1, 4):

        if j == 2:
            continue

        print(i, j)

# Output:
# 1 1
# 1 3
# 2 1
# 2 3
# 3 1
# 3 3


# ============================================================
# 20. BREAK WITH FOR-ELSE
# ============================================================
"""
Python allows an else block with a loop.

The else block executes only if the loop finishes normally.

If break occurs, the else block is skipped.
"""

numbers = [10, 20, 30, 40, 50]

target = 30

for number in numbers:

    if number == target:
        print("Element found")
        break

else:
    print("Element not found")

# Output:
# Element found


# ============================================================
# 21. FOR-ELSE WHEN ELEMENT IS NOT FOUND
# ============================================================

numbers = [10, 20, 30, 40, 50]

target = 70

for number in numbers:

    if number == target:
        print("Element found")
        break

else:
    print("Element not found")

# Output:
# Element not found


# ============================================================
# 22. COMMON MISTAKE WITH CONTINUE IN WHILE LOOP
# ============================================================
"""
WRONG:

    i = 1

    while i <= 5:

        if i == 3:
            continue

        print(i)
        i += 1

Why is this dangerous?

When i becomes 3:

    if i == 3 -> True
    continue

The update:

    i += 1

is never reached.

Therefore i remains 3 forever.

This creates an INFINITE LOOP.

Correct approach:

    update the variable before continue
    or structure the loop so the update always happens.
"""

i = 1

while i <= 5:

    if i == 3:
        i += 1
        continue

    print(i)
    i += 1

# Output:
# 1
# 2
# 4
# 5


# ============================================================
# 23. PRACTICAL EXAMPLE - FIND FIRST EVEN NUMBER
# ============================================================
"""
We want to find the first even number.

Once we find it, there is no need to check the remaining
elements, so break is appropriate.
"""

numbers = [11, 13, 15, 18, 21, 24]

for number in numbers:

    if number % 2 == 0:
        print("First even number:", number)
        break

# Output:
# First even number: 18


# ============================================================
# 24. PRACTICAL EXAMPLE - SKIP INVALID VALUES
# ============================================================
"""
Suppose negative values are invalid and should be ignored.
"""

numbers = [10, -5, 20, -10, 30, 40]

total = 0

for number in numbers:

    if number < 0:
        continue

    total += number

print("Total:", total)
# Output: Total: 100


# ============================================================
# 25. PRACTICAL EXAMPLE - PASSWORD ATTEMPTS
# ============================================================
"""
break can be used to stop after the correct password is entered.
"""

correct_password = "python123"

for attempt in range(3):

    password = input("Enter password: ")

    if password == correct_password:
        print("Login successful")
        break

    print("Incorrect password")

else:
    print("Maximum attempts reached")

"""
Example:

Enter password: abc
Incorrect password
Enter password: xyz
Incorrect password
Enter password: python123
Login successful
"""


# ============================================================
# 26. PRACTICAL EXAMPLE - SKIP MULTIPLES OF 3
# ============================================================

for i in range(1, 16):

    if i % 3 == 0:
        continue

    print(i)

# Output:
# 1
# 2
# 4
# 5
# 7
# 8
# 10
# 11
# 13
# 14


# ============================================================
# 27. KEY DIFFERENCE
# ============================================================
"""
                    BREAK
                      |
                      v
                STOP THE LOOP
                      |
                      v
             Execute code after loop


                  CONTINUE
                      |
                      v
            SKIP CURRENT ITERATION
                      |
                      v
              Go to next iteration


Example:

    for i in range(1, 6):

        if i == 3:
            break

Result:
    1
    2


    for i in range(1, 6):

        if i == 3:
            continue

        print(i)

Result:
    1
    2
    4
    5
"""


# ============================================================
#                         KEY POINTS
# ============================================================
"""
1. break and continue are loop-control statements.

2. break completely terminates the nearest loop.

3. continue skips the current iteration.

4. break does NOT terminate the entire Python program.

5. continue does NOT terminate the loop.

6. break is commonly used when:
       - Searching for an element
       - Correct input is found
       - A stopping condition is reached
       - Further iterations are unnecessary

7. continue is commonly used when:
       - Some values should be skipped
       - Invalid values should be ignored
       - Only specific values should be processed

8. In nested loops, break and continue affect only the
   nearest loop containing them.

9. Be careful with continue inside a while loop.
   Make sure the loop variable can still be updated.

10. A loop's else block does NOT execute if the loop is
    terminated using break.

11. Quick memory trick:

       break    -> BREAK OUT of the loop

       continue -> CONTINUE to the next iteration

12. Difference:

       break:
           1 2 [STOP]

       continue:
           1 2 [SKIP] 4 5
"""