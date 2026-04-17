class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n

        first = 1
        second = 2
        third = 0

        for i in range(2, n):
            third = first + second
            first = second
            second = third

        return third
        