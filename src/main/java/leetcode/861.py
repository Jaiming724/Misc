#Score After Flipping Matrix
#Go through every row, if row[0]==0, invert the row: 1000==8 but 0111=7
#Go through every column, if the number of 0 in the column is greater than (# row - number of 0), invert the column
class Solution:
    def invertRow(self,grid,row):
        for i in range(0,len(grid[row])):
            if grid[row][i]==0:
                grid[row][i]=1
            else:
                grid[row][i] = 0
    def invertCol(self,grid,col):
        for i in range(0,len(grid)):
            if grid[i][col]==0:
                grid[i][col]=1
            else:
                grid[i][col]=0
    def matrixScore(self, grid: List[List[int]]) -> int:
        l = len(grid)
        c = len(grid[0])
        for i in range(0,l):
            if grid[i][0] == 0:
                self.invertRow(grid,i)
        print("After row inversion: ")
        for i in grid:
            print(i)
        print()
        for y in range(0,c):
            count = 0
            for x in range(0,l):
                if grid[x][y]==0:
                    count+=1
            if count>(l-count):
                print("inverting col " +str(y))
                self.invertCol(grid,y)
        res = 0
        for i in grid:
            print(i)
        print()
        for i in range(0,l):
            s = ''.join(map(str, grid[i]))
            decimal_value = int(s, 2)
            res+=decimal_value
        return res

        