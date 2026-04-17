class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key= lambda i: i[0])
        n = len(intervals)
        
        res = [intervals[0]]
        index = 0

        for i in range(1, n):
            if intervals[i][0] > res[index][1]:
                res.append(intervals[i])
                index += 1
                continue

            res[index][1] = max(res[index][1], intervals[i][1])
        
        return res