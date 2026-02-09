import java.util.*;
public class Selection1 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 5, 2, 1 };
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minPos] > nums[j]) {
                    minPos = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }

        System.out.println(Arrays.toString(nums));

    }
}
