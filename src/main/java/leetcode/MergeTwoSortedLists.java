package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode node1 = new ListNode();
        node1.val = 1;

        ListNode node2 = new
                ListNode();
        node2.val = 2;

        ListNode node3 = new
                ListNode();
        node3.val = 4;
        node1.next = node2;
        node2.next = node3;


        ListNode node4 = new
                ListNode();
        node4.val = 1;

        ListNode node5 = new
                ListNode();
        node5.val = 3;

        ListNode node6 = new
                ListNode();
        node6.val = 4;
        node4.next = node5;
        node5.next = node6;

        ListNode temp = (mergeTwoLists(node1, node4));
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new
                ListNode();

        ListNode current = head;

        boolean isOnhead = true;
        while (list1 != null && list2 != null) {

            ListNode smallerNode;
            if (list1.val <= list2.val) {
                smallerNode = list1;
                list1 = list1.next;
            } else {
                smallerNode = list2;
                list2 = list2.next;
            }
            if (isOnhead) {
                current.val = smallerNode.val;
                isOnhead = false;
            } else {

                ListNode temp = new
                        ListNode();
                temp.val = smallerNode.val;
                current.next = temp;
                current = current.next;
            }


        }
        while (list1 != null) {

            ListNode temp = new
                    ListNode();
            temp.val = list1.val;
            current.next = temp;
            current = current.next;
            list1 = list1.next;
        }
        while (list2 != null) {

            ListNode temp = new
                    ListNode();
            temp.val = list2.val;
            current.next = temp;
            current = current.next;
            list2 = list2.next;
        }
        return head;
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,
                 ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
