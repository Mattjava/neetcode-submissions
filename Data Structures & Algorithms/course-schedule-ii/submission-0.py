class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegrees = [0] * numCourses
        
        for edge in prerequisites:
            adj[edge[1]].append(edge[0])
            indegrees[edge[0]] += 1

        queue = []
        start = 0

        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)

        processed = []

        if not queue:
            return []
        while queue:
            first = queue.pop(0)
            for node in adj[first]:
                indegrees[node] -= 1
                if indegrees[node] == 0:
                    queue.append(node)
            processed.append(first)

        return processed if len(processed) == numCourses else []