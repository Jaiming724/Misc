# Have to check if right is equal to the flipped version of left, which is just if left=right for every subtree


class Solution:
    def helper(self, l, r):
        if l is None and r is None:
            return True
        if l is None and r is not None:
            return False
        if l is not None and r is None:
            return False
        if l.val == r.val:
            return self.helper(l.left, r.right) and self.helper(l.right, r.left)
        else:
            return False

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return self.helper(root.left, root.right)
