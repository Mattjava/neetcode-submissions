class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegrees = [0] * numCourses
        
        for edge in prerequisites:
            if edge[1] == edge[0]:
                return False
            adj[edge[0]].append(edge[1])
            indegrees[edge[1]] += 1

        queue = []
        start = 0

        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)

        processed = []

        if not queue:
            return False
        while queue:
            first = queue.pop(0)
            if first in processed:
                return False
            for node in adj[first]:
                indegrees[node] -= 1
                if indegrees[node] < 0:
                    return False
                elif indegrees[node] == 0:
                    queue.append(node)
            processed.append(first)

        return len(processed) == numCourses