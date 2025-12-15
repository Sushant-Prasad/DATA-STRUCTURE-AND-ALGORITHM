package Arrays;

// ============================================================================
//  TITLE:
//  Best Time to Buy and Sell Stock (Single Transaction)
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array where each element represents the stock price on a given day,
//  find the maximum profit that can be achieved by buying on one day
//  and selling on a later day.
//  If no profit is possible, return 0.
//
// ============================================================================
//  INTUITION:
//  ----------
//  To maximize profit:
//    • Buy the stock at the lowest price so far
//    • Sell it when the price is higher than the buying price
//  Keep updating the minimum buying price and maximum profit.
//
// ============================================================================
//  APPROACH (ONE PASS OPTIMIZED):
//  ------------------------------
//  1. Initialize BuyingPrice to a very large value.
//  2. Traverse the price array:
//        • If current price is higher than BuyingPrice,
//          calculate profit and update MaxProfit.
//        • Else, update BuyingPrice to current price.
//  3. Return MaxProfit.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Prices: [7, 1, 5, 3, 6, 4]
//
//      Buy at 1, Sell at 6 → Profit = 5
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [7, 1, 5, 3, 6, 4]
//
//      Day 0 → BuyingPrice = 7
//      Day 1 → BuyingPrice = 1
//      Day 2 → profit = 5 - 1 = 4 → MaxProfit = 4
//      Day 4 → profit = 6 - 1 = 5 → MaxProfit = 5
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Only one buy and one sell allowed
//  ✔ Sell must happen after buy
//  ✔ If prices keep decreasing, profit remains 0
//  ✔ Uses greedy strategy
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • BuyingPrice stores minimum price seen so far
//  • MaxProfit never becomes negative
//  • This is a classic interview problem (LeetCode #121)
//
// ============================================================================
//  TIME COMPLEXITY:  O(n)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array13 {

    // ------------------------------------------------------------------------
    // METHOD NAME: BuyandSellStocks
    // PURPOSE    : Finds maximum profit from a single buy-sell transaction
    // ------------------------------------------------------------------------
    public static int BuyandSellStocks(int a[], int n) {

        int BuyingPrice = Integer.MAX_VALUE;  // Minimum price so far
        int MaxProfit = 0;                    // Maximum profit

        for (int i = 0; i < n; i++) {

            // If selling today gives profit
            if (BuyingPrice < a[i]) {

                int profit = a[i] - BuyingPrice;
                MaxProfit = Math.max(MaxProfit, profit);
            }
            // Update buying price if lower price is found
            else {
                BuyingPrice = a[i];
            }
        }

        return MaxProfit;
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        int i, n;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.println("Enter size of array:");
        n = sc.nextInt();

        // Input stock prices
        System.out.println("Enter the elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Print maximum profit
        System.out.println("Maximum profit is " + BuyandSellStocks(a, n));

        sc.close();
    }
}
