class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        countS, countT = {}, {}

        for row in range(len(s)):
            countS[s[row]] = 1 + countS.get(s[row], 0)
            countT[t[row]] = 1 + countT.get(t[row], 0)

        return countS == countT