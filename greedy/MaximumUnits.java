import java.util.Arrays;

// LeetCode 1710 - Maximum Units on a Truck
// Greedy: sort by units per box (high to low), take best boxes first
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int total = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int count = boxTypes[i][0];
            int units = boxTypes[i][1];

            if (truckSize >= count) {
                total += count * units;
                truckSize -= count;
            } else {
                total += truckSize * units;
                break;
            }
        }
        return total;
    }
}
