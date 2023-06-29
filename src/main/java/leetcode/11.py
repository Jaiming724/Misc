class Solution:
    def maxArea(self, height: List[int]) -> int:
        if len(height)<2:
            return 0
        if len(height)==2:
            return min(height[0],height[1])
        l = 0
        r = len(height)-1
        maxWater = 0
        while l<r:
            minHeight = min(height[l],height[r])
            water = minHeight *(r-l)

            if(water>maxWater):

                maxWater = water
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1

        return maxWater

