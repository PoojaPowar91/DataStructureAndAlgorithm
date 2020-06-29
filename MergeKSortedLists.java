
   
public class MergeKSortedLists {
	   public ListNode mergeKLists(ListNode[] lists) {
	        //corner case
	        int L = lists.length;
	        if (L == 0) return null;
	        if (L == 1) return lists[0];
	        if (L == 2) return mergeTwoSortedLists(lists[0], lists[1]);
	        int i = 1;
	        ListNode res = lists[0];
	        while (i < L) {
	            res = mergeTwoSortedLists(res, lists[i++]);
	        }
	        return res;
	        
	    }
	    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(-1);
	        ListNode head = dummy;
	        while(l1 != null & l2 != null) {
	            if (l1.val < l2.val) {
	                head.next = l1;
	                l1 = l1.next;
	            } else {
	                head.next = l2;
	                l2 = l2.next;
	            }
	            head = head.next;
	        }
	        if (l1 != null) head.next = l1;
	        else if  (l2 != null) head.next = l2;
	        return dummy.next;
	    }

}
