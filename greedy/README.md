# Greedy

## 455. Assign Cookies (Easy)

Link: https://leetcode.com/problems/assign-cookies/

### Question
You are giving cookies to children. Each child has a greed factor (the smallest cookie size that makes them happy). Each cookie has a size. A child gets at most one cookie, and a cookie goes to at most one child. A child is happy only if the cookie size is greater than or equal to their greed factor.

Return the maximum number of happy children.

### Example (my own)
Greed = [1, 2, 3], cookies = [1, 1]
Only the child with greed 1 can be made happy, so the answer is 1.

### Approach
Greedy + two pointers: sort both arrays, then give each cookie to the least greedy child it can satisfy. See AssignCookies.java for the code and explanation.

Complexity: O(n log n + m log m) time, O(1) extra space.
