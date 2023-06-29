class Solution:
    # 1,2,3,4
    # 2,1,3,4 set prev to 1
    # 2,1,4,3 ensure 1 points to 4
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        temp = head
        head = head.next
        prev = None
        while temp is not None and temp.next is not None:
            nextNode = temp.next
            nextnextNode = temp.next.next
            nextNode.next = temp
            temp.next = nextnextNode

            if prev is not None:
                prev.next = nextNode

            prev = temp
            temp = nextnextNode

        return head
