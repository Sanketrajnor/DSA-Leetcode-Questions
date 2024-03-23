/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast  = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode Prev=null;
        ListNode Curr=slow.next;
        slow.next = null;
        while(Curr!=null){
        ListNode Currp1 = Curr.next;
        Curr.next = Prev;
        Prev = Curr;
        Curr = Currp1;
        }
        ListNode left=head;
        ListNode right=Prev;
        while(right != null){
            ListNode leftp1 = left.next;
            ListNode rightp1 = right.next;
            left.next = right;
            right.next = leftp1;
            left = leftp1;
            right = rightp1;
        }

    }
}
