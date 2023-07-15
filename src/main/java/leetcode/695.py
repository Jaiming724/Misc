# basically leetcode #200 but also calculate area
class Solution:
    def bsf(self, grid, p):
        queue = [p]
        visited = set()
        res = 0
        while len(queue) > 0:
            nextQueue = []
            while len(queue) > 0:
                pos = queue.pop(0)
                if pos not in visited:
                    visited.add(pos)
                    i = pos[0]
                    j = pos[1]
                    if grid[i][j] == 1:
                        grid[i][j] = 2
                        res += 1
                        if i - 1 >= 0 and grid[i - 1][j] == 1:
                            nextQueue.append((i - 1, j))
                        if i + 1 < len(grid) and grid[i + 1][j] == 1:
                            nextQueue.append((i + 1, j))
                        if j - 1 >= 0 and grid[i][j - 1] == 1:
                            nextQueue.append((i, j - 1))
                        if j + 1 < len(grid[0]) and grid[i][j + 1] == 1:
                            nextQueue.append((i, j + 1))
            for i in nextQueue:
                queue.append(i)
            nextQueue = []
        print(res)
        return res

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    print("{} {}".format(i, j))
                    res = max(res, self.bsf(grid, (i, j)))
        return res
