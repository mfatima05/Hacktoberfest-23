package com.Mann;

public class Leectcode21 {

    public static void main(String[] args){
        var list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4,null);

        var list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4,null);

        var sol = new Solution();
        var ans = sol.mergeTwoLists(list1,list2);
        System.out.println("Done");
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode res = new ListNode();
            if (list1 == null && list2 == null)
                return list1;
            else if (list1 == null)
                return list2;
            else if (list2 == null)
                return list1;
            else {
//                if (list1.val <= list2.val) {
//                    res = new ListNode(list1.val);
//                    list1=list1.next;
//                }else {
//                    res = new ListNode(list2.val);
//                    list2=list2.next;
//                }
                var curr = res;
                while (list1 != null && list2 != null) {
                    if (list1.val <= list2.val) {
                        curr.next = new ListNode(list1.val);
                        list1 = list1.next;
                    } else {
                        curr.next = new ListNode(list2.val);
                        list2 = list2.next;
                    }
                    curr=curr.next;
                }
                if (list1 == null)
                    curr = list2;
                else if (list2 == null)
                    curr = list1;
            }
            return res.next;
        }
    }
}
