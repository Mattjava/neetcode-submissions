class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = {c: set() for w in words for c in w}
        indegree = {c: 0 for c in adj}

        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            minLen = min(len(w1), len(w2))
            if len(w1) > len(w2) and w1[:minLen] == w2[:minLen]:
                return ""
            for j in range(minLen):
                if w1[j] != w2[j]:
                    if w2[j] not in adj[w1[j]]:
                        adj[w1[j]].add(w2[j])
                        indegree[w2[j]] += 1
                    break
        
        queue = [letter for letter in indegree if indegree[letter] == 0]

        print(queue)

        result = ""
        while queue:
            top = queue.pop(0)
            result += top
            for letter in adj[top]:
                indegree[letter] -= 1
                if indegree[letter] == 0:
                    queue.append(letter)


        return result if len(result) == len(indegree) else ""

