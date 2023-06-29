class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        res = []

        nums.sort()
        if len(nums)<=1:
            return []
        for i in range(len(nums)):
            current = nums[i]
            l = i+1
            r = len(nums)-1
            while l<r:
                if current+nums[l]+nums[r]==0:
                    temp = [ current,nums[l],nums[r]]
                    temp.sort()
                    if temp not in res:
                        res.append(temp)
                    r-=1
                    l+=1
                else:
                    if current+nums[l]+nums[r]<0:
                        l+=1
                    else:
                        r-=1
        return res
