#https://www.youtube.com/watch?v=gqXU1UyA8pk
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freqs = [0] * 26
        l = 0
        greatest = 0
        for r in range(len(s)):
            freqs[ord(s[r]) - ord('A')] += 1
            max_value = max(freqs)


            while (r-l+1)-max_value>k:
                freqs[ord(s[l]) - ord('A')] -= 1
                l+=1
            greatest = max(greatest,r-l+1)
        return greatest