/* Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0;
        int j = 0;
        int answer = 0;
        Set<Character> mySet = new HashSet();
        
        while((i<len) && (j<len)){
            if(!mySet.contains(s.charAt(j))){
                mySet.add(s.charAt(j));
                j++;
                answer = Math.max(answer, j-i);
            }else{
                mySet.remove(s.charAt(i));
                i++;
            }
        }
        
        return answer;
    }
}