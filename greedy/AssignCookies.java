/*
LeetCode 455 - Assign Cookies (Easy)
  Topic: Greedy + Two Pointers
  Solved: 18 Nov 2026 | Java | 15 ms

  Problem:
g[i] = greed of child i (minimum cookie size the child accepts).
  s[j] = size of cookie j.
  Each child gets at most one cookie. Maximise the number of content children.

  Idea (greedy):
Sort both arrays. Use the smallest cookie that can satisfy the least greedy child.
  - Pointer r = children, pointer l = cookies.
  - If cookie s[l] >= g[r], the child is happy, so move to the next child.
  - Always move to the next cookie (it was either used or too small).
A small cookie is never wasted on a greedy child, so a local choice gives the best total.

  Complexity: Time O(n log n + m log m) for sorting, Space O(1) extra.
  */
import java.util.Arrays;

class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int m = s.length;
    int n = g.length;
    int l = 0, r = 0;
    while (l < m && r < n) {
      if (g[r] <= s[l]) {
        r = r + 1;
      }
      l = l + 1;
    }
    return r;
  }
}
