class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_length = len(s1)
        if s1_length>len(s2):
            return False
        s1_freq  = [0] * 26
        for t in s1:
            s1_freq[ord(t) - ord('a')] += 1
        l = 0
        s2_freq  = [0] * 26
        found = False
        for r in range(len(s2)):

            s2_freq[ord(s2[r]) - ord('a')] += 1

            if r-l+1>s1_length:
                s2_freq[ord(s2[l]) - ord('a')] -= 1
                l+=1
            print(str(l)+" "+str(r))

            if s2_freq==s1_freq:
                found = True
        return found




