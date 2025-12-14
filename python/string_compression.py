def compress_string_no_libs(s: str) -> str:
    """
    Compresses a string by manually counting consecutive characters without using any
    external libraries or tools like itertools.

    For example, "AABBCCCCDAA" becomes "A2B2C4D1A2".

    Args:
        s: The string to compress.

    Returns:
        The compressed string, or the original if compression doesn't make it smaller.
    """
    if not s:
        return ""

    compressed_parts = []
    i = 0
    while i < len(s):
        char = s[i]
        count = 1
        # Look ahead to count how many times the character repeats
        j = i + 1
        while j < len(s) and s[j] == char:
            count += 1
            j += 1
        
        # Append the character and its count to our list of parts
        compressed_parts.append(f"{char}{count}")
        
        # Move the main index to the start of the next new character
        i = j

    compressed_result = "".join(compressed_parts)

    # Return the original string if the compressed version is not smaller
    return compressed_result if len(compressed_result) < len(s) else s

# --- Main execution block to demonstrate usage ---
if __name__ == "__main__":
    # For clarity, we're renaming the function call in the demo
    compress_string = compress_string_no_libs

    str1 = "AABBCCCCDAA"
    compressed1 = compress_string(str1)
    print(f"Original: {str1}")
    print(f"Compressed: {compressed1}")  # Expected: A2B2C4D1A2
    print("-" * 20)

    str2 = "ABCDE"
    compressed2 = compress_string(str2)
    print(f"Original: {str2}")
    print(f"Compressed: {compressed2}")  # Expected: ABCDE
    print("-" * 20)

    str3 = "AAABBA"
    compressed3 = compress_string(str3)
    print(f"Original: {str3}")
    print(f"Compressed: {compressed3}")  # Expected: A3B2A1
    print("-" * 20)
