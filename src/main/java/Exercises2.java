import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i - 1))) {
                num += romanMap.get(s.charAt(i)) - 2 * romanMap.get(s.charAt(i - 1));
            } else {
                num += romanMap.get(s.charAt(i));
            }
        }
        return num;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){ 
                if(tempList.contains(nums[i])) continue; 
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Exercises2 exercises2 = new Exercises2();
        int[] nums1 = {2, 7, 11, 15};
        int target = 9;
        int[] result = exercises2.twoSum(nums1, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);

        String roman = "MCMXCIV";
        int num = exercises2.romanToInt(roman);
        System.out.println("Integer: " + num);

        int[] nums2 = {1, 2, 3};
        List<List<Integer>> permute = exercises2.permute(nums2);
        System.out.println("Permutations: " + permute);
    }
}
