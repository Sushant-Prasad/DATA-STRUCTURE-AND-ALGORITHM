package String;

public class string2 {

    // =========================================================================
    //  TITLE:
    //  Find the Shortest Path from a Given Direction String
    // =========================================================================
    //
    //  PROBLEM STATEMENT:
    //  ------------------
    //  You are given a string consisting of characters:
    //      'N' → North
    //      'S' → South
    //      'E' → East
    //      'W' → West
    //
    //  Each character represents a movement of 1 unit in that direction.
    //  Starting from the origin (0,0), find the shortest distance from
    //  the starting point to the final destination.
    //
    // =========================================================================
    //  INTUITION:
    //  ----------
    //  • Instead of tracking the entire path, we only need the final position.
    //  • Movements along the X-axis and Y-axis cancel each other.
    //  • Once we know the final (x, y) coordinates, the shortest path
    //    is simply the straight-line distance from the origin.
    //
    // =========================================================================
    //  APPROACH:
    //  ----------
    //  1. Initialize x = 0 and y = 0 (starting point).
    //  2. Traverse each character of the string:
    //      • 'E' → x++
    //      • 'W' → x--
    //      • 'N' → y++
    //      • 'S' → y--
    //  3. After processing all moves, compute distance using:
    //
    //          √(x² + y²)
    //
    // =========================================================================
    //  SPECIAL NOTES FOR LOGIC:
    //  ------------------------
    //  • X-axis represents East (+) and West (−).
    //  • Y-axis represents North (+) and South (−).
    //  • The formula √(x² + y²) comes from the distance formula
    //    between two points in coordinate geometry.
    //
    // =========================================================================
    //  EXAMPLE:
    //  --------
    //  Input:
    //      "WNEENESENNN"
    //
    // =========================================================================
    //  DRY RUN:
    //  --------
    //  Start at (0,0)
    //
    //  W → (-1,0)
    //  N → (-1,1)
    //  E → (0,1)
    //  E → (1,1)
    //  N → (1,2)
    //  E → (2,2)
    //  S → (2,1)
    //  E → (3,1)
    //  N → (3,2)
    //  N → (3,3)
    //  N → (3,4)
    //
    //  Final Position = (3,4)
    //
    //  Shortest Distance:
    //      √(3² + 4²) = √25 = 5
    //
    // =========================================================================
    //  KEY POINTS:
    //  ------------
    //  ✔ Only final position matters
    //  ✔ Straight-line distance is shortest path
    //  ✔ No need to store the entire path
    //  ✔ Uses basic coordinate geometry
    //
    // =========================================================================
    //  TIME COMPLEXITY:
    //      O(n)  → n is length of the string
    //
    //  SPACE COMPLEXITY:
    //      O(1)
    //
    // =========================================================================
    public static void shortestPath(String str) {

        int x = 0, y = 0;   // Coordinates of current position

        // Traverse the direction string
        for (int i = 0; i < str.length(); i++) {

            char dir = str.charAt(i);

            if (dir == 'E') {
                x++;        // Move east
            }
            else if (dir == 'W') {
                x--;        // Move west
            }
            else if (dir == 'N') {
                y++;        // Move north
            }
            else if (dir == 'S') {
                y--;        // Move south
            }
        }

        // Calculate shortest distance using distance formula
        float disp = (float) Math.sqrt(x * x + y * y);

        System.out.println("Shortest path is " + disp);
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    public static void main(String args[]) {

        String str = "WNEENESENNN";

        shortestPath(str);
    }
}
