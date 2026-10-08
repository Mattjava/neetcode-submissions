class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)

        gCost = 0
        cCost = 0

        for i in range(n):
            gCost += gas[i]
            cCost += cost[i]

        if cCost > gCost:
            return -1

        
        fuel = 0
        res = 0

        for i in range(n):
            fuel += gas[i] - cost[i]

            if fuel < 0:
                fuel = 0
                res = i + 1

        return res
        