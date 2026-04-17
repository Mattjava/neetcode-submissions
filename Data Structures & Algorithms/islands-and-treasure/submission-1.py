class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        queue = []

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 0:
                    queue.append([i, j, 0, []])

        while queue:
            top = queue.pop(0)
            x = top[0]
            y = top[1]

            pair = [x, y]

            if x == len(grid) or y == len(grid[x]):
                continue
            elif x <= -1 or y <= -1:
                continue
            elif pair in top[3]:
                continue
            elif grid[x][y] == -1:
                continue

            val = top[2]
            
            grid[x][y] = min(val, grid[x][y])

            val += 1

            visit = top[3]
            visited = [x, y]

            visit.append(visited)

            queue.append([x+1, y, val, visit])
            queue.append([x-1, y, val, visit])
            queue.append([x, y+1, val, visit])
            queue.append([x, y-1, val, visit])


        