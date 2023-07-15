# https://youtu.be/s6ATEkipzow
class Solution:
    def validate(self, root, minValue, maxValue):
        if root is None:
            return True

        if root.val < maxValue and root.val > minValue:
            return self.validate(root.left, minValue, root.val) and self.validate(root.right, root.val, maxValue)
            return False

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return self.validate(root, float('-inf'), float('inf'))
