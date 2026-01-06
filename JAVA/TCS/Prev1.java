/*
===========================================================
TITLE
===========================================================
Two-Wheeler and Four-Wheeler Count Problem (TCS Previous Question)

===========================================================
PROBLEM STATEMENT
===========================================================
An automobile company manufactures:
• Two-wheelers (TW)
• Four-wheelers (FW)

You are given:
1) `V` → Total number of vehicles (TW + FW)
2) `W` → Total number of wheels

Your task is to determine:
• Number of two-wheelers (TW)
• Number of four-wheelers (FW)

===========================================================
PROBLEM RESOURCE (links)
===========================================================
TCS Previous Year Question (Aptitude / Coding Round)

===========================================================
INPUT CONDITIONS / CONSTRAINTS
===========================================================
• 2 ≤ W
• W must be even (W % 2 == 0)
• V < W

If any of the above conditions fail,
print:
INVALID INPUT

===========================================================
MATHEMATICAL FORMULATION
===========================================================
Let:
TW = number of two-wheelers
FW = number of four-wheelers

From the problem:
1) TW + FW = V
2) 2*TW + 4*FW = W

Solving the equations:
FW = (W - 2V) / 2
TW = V - FW

===========================================================
INTUITION
===========================================================
Each vehicle contributes at least 2 wheels.
Extra wheels beyond 2 per vehicle must come from four-wheelers.

By solving linear equations, we directly compute:
• Number of four-wheelers first
• Then derive two-wheelers

===========================================================
EXAMPLE
===========================================================
Input:
V = 200
W = 540

Calculation:
FW = (540 - 2*200) / 2 = 70
TW = 200 - 70 = 130

Output:
TW : 130 FW : 70

===========================================================
DRY RUN
===========================================================
Input:
V = 200, W = 540

Check constraints:
W >= 2 → true
W % 2 == 0 → true
V < W → true

Compute:
TW = (4*V - W) / 2 = (800 - 540)/2 = 130
FW = V - TW = 70

===========================================================
KEY POINTS
===========================================================
• Uses simple algebraic equations
• Constraint validation is mandatory
• Output format must be exact
• No extra text should be printed

===========================================================
TIME COMPLEXITY
===========================================================
O(1)
- Constant time computation

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- No extra space used

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Formula used: TW = (4V − W) / 2
• FW is derived as (V − TW)
• Output must strictly follow the required format
===========================================================
*/

package TCS;
import java.util.*;

public class Prev1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read total number of vehicles
        int v = sc.nextInt();

        // Read total number of wheels
        int w = sc.nextInt();

        // Calculate number of two-wheelers using derived formula
        float tw = (4 * v - w) / 2;

        // Validate constraints
        if (w >= 2 && w % 2 == 0 && v < w) {

            // Print result in required format
            System.out.println("TW : " + (int) tw + " FW : " + (int) (v - tw));

        } else {

            // Print invalid input message if constraints fail
            System.out.println("INVALID INPUT");
        }
    }
}
