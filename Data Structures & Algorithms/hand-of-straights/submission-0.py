class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        cardCount = {}

        for card in hand:
            cardCount[card] = cardCount.get(card, 0) + 1
        
        hand.sort()

        for x in hand:
            if x not in cardCount:
                continue
            
            for i in range(x, x + groupSize):
                if i not in cardCount:
                    return False
                
                cardCount[i] -= 1

                if cardCount[i] == 0:
                    cardCount.pop(i)

        return True