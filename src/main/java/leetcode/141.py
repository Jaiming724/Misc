class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:

        if head is None or head.next is None:
            return False
        ptr1 = head
        ptr2 = head
        while ptr1 is not None and ptr2 is not None:
            ptr1 = ptr1.next
            if ptr2.next is None:
                ptr2 = None
            else:
                ptr2 = ptr2.next.next
            if ptr1==ptr2:
                print(ptr1.val)
                print(ptr2.val)
                return True

        return False