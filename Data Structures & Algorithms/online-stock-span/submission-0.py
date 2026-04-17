class StockSpanner:

    def __init__(self):
        self.days = []

        

    def next(self, price: int) -> int:
        span = 1

        index = len(self.days) - 1

        while index > -1 and self.days[index] <= price:
            span += 1
            index -= 1
        
        self.days.append(price)
        return span
        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)