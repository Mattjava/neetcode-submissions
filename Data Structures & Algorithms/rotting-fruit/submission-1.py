class Solution:
    def print(self, grid):
        for row in grid:
            print(row)
        print()
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = []

        total = 0
        rotten = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] != 0:
                    total += 1
                if grid[i][j] == 2:
                    queue.append([i, j, 0])

        time = 0

        while queue:
            top = queue.pop(0)
            x = top[0]
            y = top[1]
            if x == len(grid) or y == len(grid[x]):
                continue
            if x < 0 or y < 0:
                continue
            if grid[x][y] == 0 or grid[x][y] == 3:
                continue
            time = top[2]

            nextTime = top[2] + 1
            queue.append([x+1, y, nextTime])
            queue.append([x-1, y, nextTime])
            queue.append([x, y+1, nextTime])
            queue.append([x, y-1, nextTime])
            grid[x][y] = 3
            rotten += 1
            
        return time if rotten == total else -1
        