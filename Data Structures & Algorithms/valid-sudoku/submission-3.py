class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = {x: set() for x in range(9)}
        col = {x: set() for x in range(9)}
        squ = {x: set() for x in range(9)}

        for i in range(9):
            for j in range(9):
                num = board[i][j]

                if num == '.':
                    continue

                square = (i // 3) * 3 + (j // 3)

                if num in row[i] or num in col[j] or num in squ[square]:
                    return False

                row[i].add(num)
                col[j].add(num)
                squ[square].add(num)

        return True
        