class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n <= 1:
            return nums
        mid = int(n / 2)
        first = self.sortArray(nums[:mid])
        second = self.sortArray(nums[mid:])
        result = self.merge(first, second)
        return result

    
    def merge(self, arr1, arr2):
        sizeOne = len(arr1)
        sizeTwo = len(arr2)
        sizeThree = sizeOne + sizeTwo

        res = [0] * sizeThree

        point1 = 0
        point2 = 0
        point3 = 0

        while point1 < sizeOne and point2 < sizeTwo:
            min_num = min(arr1[point1], arr2[point2])

            if min_num == arr1[point1]:
                point1 += 1
            else:
                point2 += 1

            res[point3] = min_num
            point3 += 1

        
        while point1 < sizeOne:
            res[point3] = arr1[point1]
            point3 += 1
            point1 += 1

        while point2 < sizeTwo:
            res[point3] = arr2[point2]
            point3 += 1
            point2 += 1

        return res


        