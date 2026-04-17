class Solution:
    def customSortString(self, order: str, s: str) -> str:
        char_map = {}

        for i, char in enumerate(order):
            char_map[char] = i

        print(char_map)

        result = sorted(list(s), key=lambda letter: char_map.get(letter, 0))

        return "".join(result)
        