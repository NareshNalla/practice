def remove_spaces_optimal(input_str: str) -> str:
    """
    Removes all whitespace from a string using a generator expression.
    This is the most common and "Pythonic" way to solve this.

    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    if not input_str:
        return ""
    
    # This is a concise and memory-efficient generator expression.
    return "".join(char for char in input_str if not char.isspace())


def remove_spaces_basic(input_str: str) -> str:
    """
    Removes all whitespace using a basic for-loop and a list.
    This approach is more explicit and easier to understand for beginners.

    Time Complexity: O(n) - The code iterates through the string once.
    Space Complexity: O(n) - In the worst case, a new list is created holding all n characters.
    """
    if not input_str:
        return ""
    
    # 1. Declare: Create an empty list to hold the non-space characters.
    chars_list = []
    
    # 2. Iterate: Loop through each character in the input string.
    for char in input_str:
        # 3. Validate: Check if the character is not a whitespace.
        if not char.isspace():
            # 4. Assign/Accumulate: Add the valid character to our list.
            chars_list.append(char)
            
    # 5. Join the list of characters back into a final string.
    return "".join(chars_list)


if __name__ == "__main__":
    test_string = "g      eeks for     ge eeks "
    
    # Using the basic, explicit method
    result_basic = remove_spaces_basic(test_string)
    print(f"Basic method result:    {result_basic}")

    # Using the optimal, Pythonic method
    result_optimal = remove_spaces_optimal(test_string)
    print(f"Optimal method result:  {result_optimal}")
