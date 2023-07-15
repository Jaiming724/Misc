# loop through the grid, for each one, increment island count and run bfs on the position to mark it
class Solution:
    def bsf(self, grid, p):
        queue = [p]
        visited = set()
        while len(queue) > 0:
            nextQueue = []
            while len(queue) > 0:
                pos = queue.pop(0)
                if pos not in visited:
                    visited.add(pos)
                    i = pos[0]
                    j = pos[1]
                    if grid[i][j] == "1":
                        grid[i][j] = '2'
                        print()
                        # self.printGrid(grid)
                        print()
                        if i - 1 >= 0 and grid[i - 1][j] == '1':
                            nextQueue.append((i - 1, j))
                        if i + 1 < len(grid) and grid[i + 1][j] == '1':
                            nextQueue.append((i + 1, j))
                        if j - 1 >= 0 and grid[i][j - 1] == '1':
                            nextQueue.append((i, j - 1))
                        if j + 1 < len(grid[0]) and grid[i][j + 1] == '1':
                            nextQueue.append((i, j + 1))
            for i in nextQueue:
                queue.append(i)
            nextQueue = []

    def printGrid(self, grid):
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                print(grid[i][j], end=" ")
            print()

    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        if len(grid) == 0:
            return 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    print("before")
                    # self.printGrid(grid)
                    res += 1
                    self.bsf(grid, (i, j))
                    print("after")
                    # self.printGrid(grid)
        return res
