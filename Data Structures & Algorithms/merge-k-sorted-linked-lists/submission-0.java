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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> tempstore=new ArrayList<>();
        // if(lists.size()==0) return new ListNode();

        for(ListNode i : lists){
           while(i!=null){
            tempstore.add(i.val);
            i=i.next;
           }
        }

        Collections.sort(tempstore);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        for(int i:tempstore){
            curr.next=new ListNode(i);
            curr=curr.next;
        }

        return dummy.next;


    }
}
