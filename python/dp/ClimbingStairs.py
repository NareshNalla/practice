'''
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
'''

class ClimbingStairs:
    """
    Time Complexity: O(N)
    Space Complexity: O(1)
    """
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        
        # Base cases:
        # one: ways to reach step n-1
        # two: ways to reach step n-2
        one, two = 1, 1
        
        for i in range(n - 1):
            temp = one
            one = one + two
            two = temp
            
        return one

if __name__ == "__main__":
    solution = ClimbingStairs()
    
    # Test Case 1
    n1 = 2
    print(f"Steps: {n1}, Ways: {solution.climbStairs(n1)}") # Expected: 2

    # Test Case 2
    n2 = 3
    print(f"Steps: {n2}, Ways: {solution.climbStairs(n2)}") # Expected: 3
    
    # Test Case 3
    n3 = 5
    print(f"Steps: {n3}, Ways: {solution.climbStairs(n3)}") # Expected: 8
