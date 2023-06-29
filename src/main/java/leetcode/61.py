# 1) Calculate the size of the list
# 2) Make the list circular
# 3) Set the (LEN - K)th node to have a NULL next reference
# 4) Return the node after the (LEN - K)th node, since it is the new start
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 0 or head is None:
            return head

        end = head
        size = 0
        while end.next is not None:
            end = end.next
            size += 1
        size += 1
        if k >= size:
            k = k % size
        if k == 0:
            return head
        print("size " + str(size))
        print("end is " + str(end.val))

        end.next = head
        temp = head
        for i in range(size - k):
            temp = temp.next
        print("return: " + str(temp.val))

        cutOff = head
        for i in range(size - k - 1):
            cutOff = cutOff.next
        print("cutoff: " + str(cutOff.val))
        cutOff.next = None
        return temp
