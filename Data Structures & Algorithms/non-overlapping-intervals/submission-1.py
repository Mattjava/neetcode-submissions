class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        
        intervals.sort(key=lambda i: i[0])

        steps = 0

        mostRecent = intervals[0]

        for i in range(1, n):
            if intervals[i][0] < mostRecent[1]:
                mostRecent = min(intervals[i], mostRecent, key=lambda i: i[1])
                steps += 1
                continue
            
            mostRecent = intervals[i]
        return steps
        