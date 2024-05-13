# Product of Array Except Self
# Input: nums = [1,2,3,4]
# Output: [24,12,8,6]
# for every position i in array, prefix[i] is the product of all elements before i
# suffix[i] is the product of all elements after i
# answer[i] = prefix[i-1] * suffix[i+1]
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1] * len(nums)
        suffix = [1] * len(nums)
        answer = [0] * len(nums)
        prefix[0] = nums[0]
        suffix[len(nums) - 1] = nums[len(nums) - 1]
        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i]
        for i in range(len(nums) - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]

        for i in range(0, len(nums)):
            if i == 0:
                answer[i] = suffix[i + 1]
            elif i == len(nums) - 1:
                answer[i] = prefix[i - 1]
            else:
                answer[i] = prefix[i - 1] * suffix[i + 1]
        return answer
