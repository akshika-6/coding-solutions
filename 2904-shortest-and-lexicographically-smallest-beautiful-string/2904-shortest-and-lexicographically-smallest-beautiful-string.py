class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        ones = []

        # Store positions of all 1s
        for i, ch in enumerate(s):
            if ch == '1':
                ones.append(i)

        # Not enough 1s
        if len(ones) < k:
            return ""

        best = ""

        # Check every group of k consecutive 1s
        for i in range(len(ones) - k + 1):
            left = ones[i]
            right = ones[i + k - 1]

            candidate = s[left:right + 1]

            # First minimize length,
            # then choose lexicographically smallest
            if best == "" or len(candidate) < len(best):
                best = candidate
            elif len(candidate) == len(best) and candidate < best:
                best = candidate

        return best