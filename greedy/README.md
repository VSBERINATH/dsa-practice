# Greedy

## What is a greedy algorithm?

At each step, pick the choice that looks best **right now**, and never go back to change it.
It works only when a good local choice also leads to the best final answer.

Common signs a problem is greedy:
- You can sort the input and handle items one by one.
- There is a clear "safest" or "cheapest" choice at each step.
- Keeping a resource (like a small cookie or a $5 bill) for later is never worse.

---

## 455. Assign Cookies (Easy)

Link: https://leetcode.com/problems/assign-cookies/

### Question

You are giving cookies to children. Each child has a greed factor (the smallest cookie size that makes them happy). Each cookie has a size. A child gets at most one cookie, and a cookie goes to at most one child. A child is happy only if the cookie size is greater than or equal to their greed factor.

Return the maximum number of happy children.

### Example (my own)

Greed = [1, 2, 3], cookies = [1, 1]
Only the child with greed 1 can be made happy, so the answer is 1.

### Approach

Greedy + two pointers: sort both arrays, then give each cookie to the least greedy child it can satisfy. See [AssignCookies.java](AssignCookies.java) for the code and explanation.

Complexity: O(n log n + m log m) time, O(1) extra space.

---

## 860. Lemonade Change (Easy)

Link: https://leetcode.com/problems/lemonade-change/

### Question

Each lemonade costs $5. Customers stand in a line and each pays with a $5, $10 or $20 bill. You start with no change. Return true if you can give every customer the correct change, otherwise false.

### Example (my own)

Bills = [5, 5, 10, 20]
- $5, $5 -> keep two $5
- $10 -> give one $5 back (now one $5, one $10)
- $20 -> give $10 + $5 back -> works, answer is true.

Bills = [5, 10, 10]
- The second $10 needs a $5, but we have none -> answer is false.

### Approach

Count only $5 and $10 bills ($20 is never given as change).
For a $20, give **$10 + $5 first**, and only use three $5 if there is no $10.
This is the greedy choice: a $5 bill is more flexible (it helps with both $10 and $20 change), so we save it.

See [LemonadeChange.java](LemonadeChange.java) for the code and explanation.

Complexity: O(n) time, O(1) space.
