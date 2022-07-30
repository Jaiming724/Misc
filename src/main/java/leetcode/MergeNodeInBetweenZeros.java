package leetcode;

//https://leetcode.com/problems/merge-nodes-in-between-zeros/submissions/
public class MergeNodeInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode arr = null;
        ListNode newHead = null;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                System.out.println(sum);
                if (arr == null) {
                    ListNode temp = new ListNode(sum);
                    arr = temp;
                    newHead = temp;
                } else {
                    ListNode temp = new ListNode(sum);
                    arr.next = temp;
                    arr = arr.next;
                }
                sum = 0;

            }
            head = head.next;

        }
        return arr;
    }
}
