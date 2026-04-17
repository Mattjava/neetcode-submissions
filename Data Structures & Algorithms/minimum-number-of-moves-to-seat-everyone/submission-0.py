class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        n = len(seats)
        seats.sort()
        students.sort()
        res = 0
        for i in range(n):
            res += abs(seats[i] - students[i])
        return res
        
        