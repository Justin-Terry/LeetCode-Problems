/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] end = new int[2];
        Map<Integer, Integer> map = new HashMap();
		// Put elements of the array into a HashMap with the contents being the key and the index being the value
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
		// Find the number needed to make the sum equal the target, check if map contains that number.
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                end[0] = i;
                end[1] = map.get(complement);
            }
        }
        return end;
    }
}