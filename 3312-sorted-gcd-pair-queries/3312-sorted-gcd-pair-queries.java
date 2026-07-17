import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];

        // cnt[g] = number of pairs where both numbers are divisible by g
        for (int g = 1; g <= max; g++) {
            long total = 0;
            for (int multiple = g; multiple <= max; multiple += g) {
                total += freq[multiple];
            }
            cnt[g] = total * (total - 1) / 2;
        }

        // Inclusion-Exclusion to get exact gcd count
        for (int g = max; g >= 1; g--) {
            for (int multiple = g * 2; multiple <= max; multiple += g) {
                cnt[g] -= cnt[multiple];
            }
        }

        // Prefix sum
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // convert 0-indexed to 1-indexed

            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}