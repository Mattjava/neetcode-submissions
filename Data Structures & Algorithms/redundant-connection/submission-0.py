class Solution:
    class Union:
        def __init__(self, n):
            self.arr = [i for i in range(n)]
        def __str__(self):
            return str(self.arr)
        def find(self, i):
            index = i

            while self.arr[index] != index:
                index = self.arr[index]
            return index

        def unite(self, i, j):
            irep = self.find(i)
            jrep = self.find(j)

            self.arr[irep] = jrep


        def count(self):
            uni = set()
            for i in range(len(self.arr)):
                uni.add(self.find(i))
            return len(uni)
        
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = 0
        for edge in edges:
            n = max(n, max(edge[0], edge[1]))
        uf = self.Union(n)

        for edge in edges:
            if uf.find(edge[0] - 1) == uf.find(edge[1] - 1):
                return edge
            uf.unite(uf.find(edge[0] - 1), uf.find(edge[1] - 1))

        return []

        
        