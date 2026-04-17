import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        point_list = []

        for point in points:
            distance = math.sqrt(math.pow((point[0] - 0), 2) + math.pow((point[1] - 0),2))

            point_list.append((distance, point))

        heapq.heapify(point_list)

        res = []

        for i in range(k):
            res.append(heapq.heappop(point_list)[1])
        
        return res