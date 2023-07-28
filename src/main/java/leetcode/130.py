# https://youtu.be/9z2BunfoZ5Y
from typing import List


class Solution:
    def dfs(self, i, j, board):
        board[i][j] = "T"
        if i - 1 >= 0 and board[i - 1][j] == "O":
            self.dfs(i - 1, j, board)
        if i + 1 <= len(board) - 1 and board[i + 1][j] == "O":
            self.dfs(i + 1, j, board)
        if j - 1 >= 0 and board[i][j - 1] == "O":
            self.dfs(i, j - 1, board)
        if j + 1 <= len(board[i]) - 1 and board[i][j + 1] == "O":
            self.dfs(i, j + 1, board)

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) <= 0:
            return
        marked = set()
        for i in range(len(board)):
            if board[i][0] == "O":
                self.dfs(i, 0, board)
        for i in range(len(board[0])):
            if board[0][i] == "O":
                self.dfs(0, i, board)

        for i in range(len(board)):
            if board[i][len(board[i]) - 1] == "O":
                self.dfs(i, len(board[i]) - 1, board)
        for i in range(len(board[0])):
            if board[len(board) - 1][i] == "O":
                self.dfs(len(board) - 1, i, board)

        # print(board)
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == "O":
                    board[i][j] = "X"
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == "T":
                    board[i][j] = "O"
