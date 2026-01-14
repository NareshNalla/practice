'''
A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1", 'B' -> "2", ... 'Z' -> "26"

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
'''

class DecodWays:
    def numDecodings(self, s: str) -> int:
        # Memoization dictionary
        # Base case: if we reach the end of the string, we found 1 valid path
        dp = {len(s): 1}

        def dfs(i):
            # If already computed or base case, return it
            if i in dp:
                return dp[i]
            
            # If the current digit is '0', it's invalid (cannot start a mapping)
            if s[i] == "0":
                return 0

            # Option 1: Take 1 digit
            res = dfs(i + 1)
            
            # Option 2: Take 2 digits (if valid)
            # Must be between 10 and 26
            if (i + 1 < len(s) and (s[i] == "1" or (s[i] == "2" and s[i+1] in "0123456"))):
                res += dfs(i + 2)
                
            dp[i] = res
            return res

        return dfs(0)

    def numDecodeingsDp(self, s:str) -> int:
        dp = { len(s):1}

        for i in range(len(s) -1 , -1, -1):
            if s[i] == "0":
                dp[i] = 0
            else:
                dp[i] = dp[i+1]

            if (i + 1 < len(s) and (s[i] == "1" or (s[i] == "2" and s[i+1] in "0123456"))):
                dp[i] += dp[i+2]
        return dp[0]



if __name__ == "__main__":
    solution = DecodWays()
    
    # Test Case 1
    s1 = "12"
    print(f"Decodings for '{s1}': {solution.numDecodeingsDp(s1)}") # Expected: 2

    # Test Case 2
    s2 = "226"
    print(f"Decodings for '{s2}': {solution.numDecodeingsDp(s2)}") # Expected: 3
    
    # Test Case 3
    s3 = "06"
    print(f"Decodings for '{s3}': {solution.numDecodeingsDp(s3)}") # Expected: 0
    
    # Test Case 4
    s4 = "11106"
    print(f"Decodings for '{s4}': {solution.numDecodings(s4)}") # Expected: 2 ("AAJF", "KJF")
