#Do Preorder Traversal (visit-Left-Right), find the max at each node and compare

class Solution:
    def visit(self,root, maxNum, res):
        if root is None:
            return
        maxNum = max(maxNum,root.val)
        print("{} {}".format(root.val,maxNum))
        if root.val>=maxNum:
            res[0]+=1
        self.visit(root.left, maxNum,res)
        self.visit(root.right,maxNum,res)
    def goodNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0
        res = [0]
        self.visit(root,root.val,res), 
        return res[0]