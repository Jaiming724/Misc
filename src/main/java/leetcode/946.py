# for each value in popped, if popped.top==stack.top, pop stack and move on
# if it isnt, add all values in push up to the top of popp value
# have a ptr for position in pushed, if the popped value index is behind the ptr, it is invalid

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        push_idx = 0
        for i in popped:
            if len(stack) > 0 and stack[-1] == i:
                stack.pop()
            else:
                idx = pushed.index(i)
                if idx < push_idx:
                    return False

                for i in range(push_idx, idx):
                    stack.append(pushed[i])
                push_idx = idx + 1

        return True
