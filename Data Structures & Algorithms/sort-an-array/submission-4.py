class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        max_num = 0
        min_num = 0

        for num in nums:
            max_num = max(max_num, num)
            min_num = min(min_num, num)
        
        total = max_num - min_num
        inter = total // 4

        buckets = {min_num + inter: [], min_num + inter * 2: [], min_num + inter * 3: [], max_num: []}

        for num in nums:
            chosen_bucket = 0
            for bucket in buckets:
                if bucket >= num:
                    chosen_bucket = bucket
                    break
            
            index = 0

            while index < len(buckets[chosen_bucket]) and num > buckets[chosen_bucket][index]:
                index += 1
            
            buckets[chosen_bucket].insert(index, num)

        result = []

        for bucket in buckets:
            for num in buckets[bucket]:
                result.append(num)

        return result



        