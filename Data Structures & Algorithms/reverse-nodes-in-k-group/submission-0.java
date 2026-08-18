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
    public ListNode reverseKGroup(ListNode head, int k) {
     ListNode temp=head,nextnode=null;
        ListNode prev=null;

    if(head==null || k==1)  return head;
           
        while(temp!=null){

            ListNode kthnode=findk(temp,k);
            if(kthnode==null){
                if(prev!=null) prev.next=temp;
                break;
            }

            nextnode=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            
            if(temp==head){
                head=kthnode;
                prev=temp;
                temp=nextnode;
            }else{
                prev.next=kthnode;
                prev=temp;
                temp=nextnode;
            }

        }
                return head;
    }

    public ListNode findk(ListNode temp, int k){
        k--;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }

    public static void reverse(ListNode temp){

    ListNode prev=null;
    ListNode curr=temp;
    ListNode next;

    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    }

}
