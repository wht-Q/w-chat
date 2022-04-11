package com.example.chat.leetcode.lists.test_1;

public class ListTest {
    public static void main(String[] args) {
        ListNode pro = new ListNode(0);
        ListNode cur = pro;
        cur.next  = new ListNode(1);
        cur = cur.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}