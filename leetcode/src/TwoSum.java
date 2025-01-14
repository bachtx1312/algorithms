import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer missingPartIndex = map.get(nums[i]);
            if(missingPartIndex != null){
                return new int[]{missingPartIndex, i};
            }
            map.put(target-nums[i], i);
        }

        return null;
    }
}
