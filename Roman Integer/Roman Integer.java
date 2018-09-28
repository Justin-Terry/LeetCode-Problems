/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve 
 * is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, 
 * which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the 
 * numeral for four is not IIII. Instead, the number four is written as IV. Because the one 
 * is before the five we subtract it making four. The same principle applies to the number nine, 
 * which is written as IX. There are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
*/

class Solution {
    public int romanToInt(String s) {
        
		// Add character values to a HashMap for easy referencing later
        Map<Character, Integer> cases = new HashMap();
	    cases.put('I', 1);
	    cases.put('V', 5);
	    cases.put('X', 10);
	    cases.put('L', 50);
	    cases.put('C', 100);
	    cases.put('D', 500);
	    cases.put('M', 1000);
	    int total = 0;
	    
	    for(int i = 0; i < s.length(); i++){
            if(i < s.length()-1){
				if(s.charAt(i) == 'I' && s.charAt(i+1) != 'I'  ){
					if(s.charAt(i + 1) == 'V'){
						total += 4;
					}
					if(s.charAt(i+1) == 'X'){
						total += 9;
					}
					i++;
				}else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
					if(s.charAt(i+1) == 'L'){
						total+=40;
					}else{
						total+=90;
					}
					i++;
				}else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
					if(s.charAt(i+1) == 'D'){
						total += 400;
					}else{
						total += 900;
					}
					i++;
				}else{
					total += cases.get(s.charAt(i));
				}
			}else{
				total += cases.get(s.charAt(i));
			}
		}
		return total;
    }
}