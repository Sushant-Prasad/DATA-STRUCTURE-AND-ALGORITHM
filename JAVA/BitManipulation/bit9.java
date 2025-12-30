/*
===========================================================
TITLE
===========================================================
Fast Exponentiation using Bit Manipulation (Binary Exponentiation)

===========================================================
PROBLEM STATEMENT
===========================================================
Given two integers:
• `n` → base
• `p` → power (non-negative integer)

Compute nᵖ efficiently using **bit manipulation** instead of
naive repeated multiplication.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/exponential-squaring-fast-modular-exponentiation/

===========================================================
INTUITION
===========================================================
Instead of multiplying `n` exactly `p` times (O(p)),
we can use the binary representation of `p`.

Key idea:
• Any number `p` can be represented in binary
• If the current bit of `p` is 1 → multiply result by current `n`
• Square `n` at every step
• Right shift `p` to process the next bit

This reduces time complexity to O(log p).

===========================================================
APPROACH
===========================================================
1) Initialize `ans = 1` (stores final result).
2) While `p > 0`:
   - If the least significant bit of `p` is 1, multiply `ans` by `n`
   - Square `n`
   - Right shift `p` by 1 (divide by 2)
3) When `p` becomes 0, `ans` contains nᵖ.

===========================================================
EXAMPLE
===========================================================
Input:
n = 3, p = 5

Binary of p = 101

Process:
p = 5 (LSB=1) → ans = 1×3 = 3, n = 9
p = 2 (LSB=0) → ans = 3,   n = 81
p = 1 (LSB=1) → ans = 3×81 = 243

Output:
243

===========================================================
DRY RUN
===========================================================
n = 2, p = 10 (binary: 1010)

Step 1: p=10 → LSB=0 → ans=1, n=4
Step 2: p=5  → LSB=1 → ans=4, n=16
Step 3: p=2  → LSB=0 → ans=4, n=256
Step 4: p=1  → LSB=1 → ans=1024

===========================================================
KEY POINTS
===========================================================
• Uses bitwise operations for efficiency
• Right shift (`>>`) divides power by 2
• AND operation (`& 1`) checks if power is odd
• Much faster than naive exponentiation

===========================================================
TIME COMPLEXITY
===========================================================
O(log p)
- Power is halved at each iteration

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Constant extra space

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• This implementation works for positive powers only
• Can overflow for large values of `n` and `p` (no modulo used)
• Can be extended to modular exponentiation easily
===========================================================
*/

package BitManipulation;
import java.util.*;

public class bit9 {

    // Fast exponentiation method using bit manipulation
    public static int fastExpo(int n, int p) {

        int ans = 1; // Stores the final result

        // Loop until power becomes 0
        while (p > 0) {

            // If LSB of p is 1, multiply current n with answer
            if ((p & 1) != 0) {   // Checking if p is odd
                ans = ans * n;
            }

            // Square the base for next bit
            n = n * n;

            // Right shift power to process next bit
            p = p >> 1;
        }

        return ans; // Final result n^p
    }

    public static void main(String args[]) {

        int n, p;

        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("enter power ");
        p = sc.nextInt();

        // Print the result of fast exponentiation
        System.out.println("result is " + fastExpo(n, p));
    }
}
