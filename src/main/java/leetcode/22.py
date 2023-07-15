# https://youtu.be/s9fokUqJ76A
class Solution:
    def generate(self, s, open, closed, n, res):
        if open == n and closed == n:
            res.append(s)
        if open < n:
            self.generate(s + "(", open + 1, closed, n, res)
        if closed < n and closed < open:
            self.generate(s + ")", open, closed + 1, n, res)

    def generateParenthesis(self, n: int) -> List[str]:
        if n < 1:
            return []
        res = []
        self.generate('(', 1, 0, n, res)
        return res
