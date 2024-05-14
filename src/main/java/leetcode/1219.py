#Path with Maximum Gold

class Solution:
    
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        rl = len(grid)
        cl = len(grid[0])
        marked = set()
        def dfs(grid,i,j,current):
            if i<0 or j<0 or i>=rl or j>=cl or grid[i][j]==0 or (i,j) in marked:
                return current
            org = grid[i][j]
            #grid[i][j]=0
            marked.add((i,j))
            a = dfs(grid,i+1,j,current+org)
            b = dfs(grid,i-1,j,current+org)
            c = dfs(grid,i,j+1,current+org)
            d = dfs(grid,i,j-1,current+org)
            #grid[i][j]=org
            marked.remove((i,j))
            return max(a,b,c,d)
        res = 0
        for i in range(0,rl):
            for j in range(0,cl):
                if grid[i][j]!=0:
                    res = max(res,dfs(grid,i,j,0))
        return res
