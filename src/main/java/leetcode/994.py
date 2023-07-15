# Find every rotten orange to start
# run bfs on them
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        total = 0
        marked = set()
        rottenQueue = []
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                total += grid[i][j]

                if grid[i][j] == 2:
                    rottenQueue.append((i, j))
                # print(grid[i][j], end='')
            # print()
        if total == 0:
            return 0
        time = 0
        while len(rottenQueue) > 0:
            nextQueue = []
            while len(rottenQueue) > 0:
                pos = rottenQueue.pop(0)
                if pos not in marked:
                    print(pos)
                    marked.add(pos)
                    i = pos[0]
                    j = pos[1]
                    if i - 1 >= 0 and grid[i - 1][j] == 1:
                        grid[i - 1][j] = 2
                        nextQueue.append((i - 1, j))
                    if i + 1 < len(grid) and grid[i + 1][j] == 1:
                        grid[i + 1][j] = 2
                        nextQueue.append((i + 1, j))
                    if j - 1 >= 0 and grid[i][j - 1] == 1:
                        grid[i][j - 1] = 2
                        nextQueue.append((i, j - 1))
                    if j + 1 < len(grid[0]) and grid[i][j + 1] == 1:
                        grid[i][j + 1] = 2
                        nextQueue.append((i, j + 1))
            time += 1
            print("---------------")
            for i in nextQueue:
                rottenQueue.append(i)
            nextQueue = []
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                print(grid[i][j])

                if grid[i][j] == 1:
                    return -1
            print()
        return time - 1
