# https://youtu.be/mQeF6bN8hMk
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def dfs(self, node, graph):
        if node.val in graph:
            return graph[node.val]

        temp = Node(node.val)
        graph[node.val] = temp
        n = node.neighbors
        for i in n:
            temp.neighbors.append(self.dfs(i, graph))
        return temp

    def cloneGraph(self, node: 'Node') -> 'Node':
        graph = {}
        if node is None:
            return None
        self.dfs(node, graph)
        return graph[1]
