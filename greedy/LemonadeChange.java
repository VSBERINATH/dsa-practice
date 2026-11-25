/*
LeetCode 860 - Lemonade Change (Easy)
Topic: Greedy
Solved: 25 Nov 2026 | Java | 2 ms (beats 99.21%)

Problem:
Each lemonade costs $5. Customers come in order and pay with a $5, $10 or $20 bill.
You start with no money. Give every customer the correct change.
Return true if you can give change to everyone, else false.

Idea (greedy):
Only count the bills that can be used as change:
- f = number of $5 bills, t = number of $10 bills. ($20 is never given back, so no need to count it.)
- Pay $5  -> no change needed, f++.
- Pay $10 -> need $5 back. If f >= 1: f--, t++. Else return false.
- Pay $20 -> need $15 back. Two ways:
    1) one $10 + one $5   (try this FIRST)
    2) three $5
  If neither is possible, return false.

Why give $10 + $5 first (the greedy choice)?
A $5 bill is more useful than a $10 bill: $5 can help with change for both $10 and $20,
but $10 only helps with $20. So we spend the $10 when we can and save the $5 bills.

Complexity: Time O(n) (one pass), Space O(1) (two counters).
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0, t = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) { f++; }
            else if (bills[i] == 10) {
                if (f >= 1) {
                    f--; t++;
                } else return false;

            }
            else {
                if (f >= 1 && t >= 1) {
                    f--;
                    t--;
                } else if (f >= 3) {
                    f = f - 3;
                } else return false;
            }
        }
        return true;
    }
}
