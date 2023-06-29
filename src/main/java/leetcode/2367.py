class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        used = []
        res = 0
        for i in nums:
            temp = [i,i+diff,i+diff+diff]
            s = set(temp)
            if temp[1] in nums and temp[2] in nums and s not in used:
                res+=1
                used.append(s)
        return res

