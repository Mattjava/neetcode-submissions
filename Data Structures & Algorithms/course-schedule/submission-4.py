class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Create Adjancey Matrix
        adj = [[] for _ in range(numCourses)]
        # Create array to track indegrees, which represent the number of courses needed to take this class
        indegrees = [0] * numCourses
        
        for edge in prerequisites:
            # Fills in the adjancey matrix and the indegree array
            adj[edge[0]].append(edge[1])
            indegrees[edge[1]] += 1

        # Initialize queue
        queue = []

        # Fills the queue with numbers that we can start from
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)

        # Create processed array
        processed = []

        while queue:
            # Pops first element in queue
            first = queue.pop(0)
            # Runs a for-loop decrementing the indegrees of the adjacent nodes
            for node in adj[first]:
                indegrees[node] -= 1
                # If an indegree of a node is equal to 0, this means we can add it to the queue and process it
                if indegrees[node] == 0:
                    queue.append(node)
            # Adds processed node to the queue
            processed.append(first)
        # Returns true is the length of the processed nodes meets the number of courses
        return len(processed) == numCourses