"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        n = len(intervals)
        if n == 0:
            return 0
        intervals.sort(key=lambda i: i.start)

        rooms = [intervals[0].end]

        for i in range(1, n):
            index = 0
            while index < len(rooms) and rooms[index] > intervals[i].start:
                index += 1

            if index == len(rooms):
                rooms.append(intervals[i].end)
            else:
                rooms[index] = max(rooms[index], intervals[i].end)

        return len(rooms)
        