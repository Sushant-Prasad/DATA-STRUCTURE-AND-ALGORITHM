/*
===========================================================
TITLE
===========================================================
Indian Coin Change Problem using Greedy Algorithm

===========================================================
PROBLEM STATEMENT
===========================================================
You are given:
• An array `coins[]` representing Indian currency denominations
• An integer `amount` representing the total money

Your task is to determine:
• The **minimum number of coins/notes** required to make the given amount
• Also print the coins/notes used

Assumption:
• Indian currency system follows a **canonical coin system**,
  where greedy approach always gives the optimal solution.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

===========================================================
INTUITION
===========================================================
To minimize the number of coins/notes:
• Always use the **largest denomination possible first**
• This reduces the remaining amount as fast as possible

This greedy choice works for Indian coins because:
• The denominations are designed in such a way that
  local optimal choices lead to a global optimum.

===========================================================
APPROACH
===========================================================
1) Sort the coin denominations in ascending order.
2) Traverse the coins from **largest to smallest**.
3) For each coin:
   - While the coin value is less than or equal to the remaining amount:
     • Take the coin
     • Subtract its value from the amount
     • Increment the coin/note count
4) Store the selected coins in a list.
5) Return the total count.

===========================================================
EXAMPLE
===========================================================
Coins = [1, 2, 5, 10, 20, 50, 100, 500, 2000]
Amount = 590

Selected coins:
500, 50, 20, 20

Minimum number of notes = 4

===========================================================
DRY RUN
===========================================================
Amount = 590

Pick 500 → remaining = 90
Pick 50  → remaining = 40
Pick 20  → remaining = 20
Pick 20  → remaining = 0

Total notes = 4

===========================================================
KEY POINTS
===========================================================
• Works because Indian coins follow canonical property
• Always try largest denomination first
• Greedy may not work for arbitrary coin systems
• Coins can be reused unlimited times

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n + k)
- Sorting coins: O(n log n)
- k = number of coins selected (usually small)

===========================================================
SPACE COMPLEXITY
===========================================================
O(k)
- To store selected coins/notes

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Sorting is required to process from largest to smallest
• `while` loop allows using the same denomination multiple times
• List `ans` stores the actual coins used (for display/debug)
===========================================================
*/

package GreedyAlgo;
import java.util.*;

public class GreedyAlgo6 {

    // Function to calculate minimum number of coins/notes
    public static int minNote(int[] coins, int ammount) {

        int note = 0;                  // Counts total notes/coins used
        int n = coins.length;

        // Sort coin denominations in ascending order
        Arrays.sort(coins);

        ArrayList<Integer> ans = new ArrayList<>(); // Stores selected coins

        // Traverse from largest coin to smallest
        for (int i = n - 1; i >= 0; i--) {

            // If current coin can be used
            if (ammount >= coins[i]) {

                // Use the coin as many times as possible
                while (ammount >= coins[i]) {
                    note++;                    // Increment count
                    ans.add(coins[i]);         // Store selected coin
                    ammount = ammount - coins[i]; // Reduce amount
                }
            }
        }

        // Print coins/notes used
        System.out.println(ans);

        return note; // Return minimum number of coins/notes
    }

    public static void main(String[] args) {

        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 590;

        // Print minimum number of notes required
        System.out.println(minNote(coins, value));
    }
}
