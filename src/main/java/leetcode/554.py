# count the occurrence of the sum of each width
# Example row: [1,2,2,1], you would end up with {1:1,3:1,5:1,6:1}
# Go through every row and find the largest value in the map that isnt equal to width
# This value is where most rows align, height of the wall-value = answers since it gives you how many dont align
class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        if len(wall) == 0:
            return 0
        if len(wall) == 1 and len(wall[0]) > 1:
            return 0
        count = {}
        width = 0
        for i in range(len(wall)):
            temp_sum = 0
            for j in range(len(wall[i])):
                temp_sum += wall[i][j]
                if temp_sum not in count:
                    count[temp_sum] = 1
                else:
                    count[temp_sum] += 1
            width = temp_sum
        del count[width]
        if count == {}:
            return len(wall)

        return len(wall) - max(count.values())
