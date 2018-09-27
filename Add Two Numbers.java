/* You are given two non-empty linked lists representing two non-negative integers. The 
 * digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.	
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1;
        int val2;
        int sum;
        int carry;
        ListNode ln;        

        val1 = l1.val;
        val2 = l2.val;        
        
        sum = (val1 + val2)%10;
        carry = (val1 + val2)/10;
        
        ln = new ListNode(sum);
        if(l1.next != null && l2.next != null){
            l2.next.val += carry;
            ln.next = addTwoNumbers(l1.next, (l2.next));
        }else if(l1.next != null && l2.next == null){
            ln.next = addTwoNumbers(l1.next, new ListNode(carry));
        }else if(l1.next == null && l2.next != null){
            ln.next = addTwoNumbers(new ListNode(carry), l2.next);
        }else if(l1.next == null && l2.next == null && carry > 0){
            ln.next = new ListNode(carry);
        }
        
        return ln;
    }
}