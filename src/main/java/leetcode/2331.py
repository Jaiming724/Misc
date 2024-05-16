# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        
        def visit(node):
            if node.left is None and node.right is None:
                return True if node.val==1 else False

            if node.val==2:
                return visit(node.left) or visit(node.right)
            else:
                return visit(node.left) and visit(node.right)

              
        return visit(root)
