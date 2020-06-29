
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbersInLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode temp = head; 
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            l1 = l1.next;
            l2 = l2.next;
                
        }
        while(l1 != null)
        {
            int sum = l1.val + carry;
            carry = sum/10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
          temp.next = node;
            temp = node;
            l1 = l1.next;
        }
        
           while(l2 != null)
        {
            int sum = l2.val + carry;
            carry = sum/10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
           temp.next = node;
            temp = node;
            l2 = l2.next;
        }
        
        if(carry != 0)
        {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        
        return head.next;
        
    }
}
