class Solution {
    public List<Integer> findValidElements(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        boolean[] valid = new boolean[n];

        valid[0] = true;
        valid[n - 1] = true;

        int maxLeft = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > maxLeft) {
                valid[i] = true;
            }

            maxLeft = Math.max(maxLeft, nums[i]);
        }

        int maxRight = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxRight) {
                valid[i] = true;
            }

            maxRight = Math.max(maxRight, nums[i]);
        }


        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}