package com.naresh.old.javapractice.hackerearth.amazon;

public class ThoughtWorks {

}
/*
 * Digits in a Number

Let's say
are the only digits which exists in a unique number system, so the numbers will be

in ascending order .

number is 1 and number of digits is 1

will be

and number of digits is 2

will be

and number of digits will be 3

will be

and number of digits will be 4

You have to find number of digits of

term in unique number system .

Input :

First line T contains number of testcases

Next T lines contains N

Output :

Number of digits in

number

Constraints

Sample Input

4
1
4
14
40

Sample Output

1
2
3
4

Explanation

number is 1 and number of digits is 1

will be

and number of digits is 2

will be

and number of digits will be 3

will be and number of digits will be 4
 
2. 
ompare Strings

You have been given two strings, A and B (of length N each) and Q queries.
The strings contain only 0s and/or 1s.

For every query, you are given an index i. You have to update the value at index i to 1 in string B and check if B is lexicographically equal to or larger than A or not.
If yes, then print "
" and if not, print "

" (without quotes).

Input format

    First line contains two space-separated integers N and Q.
    Next line contains the string A.
    Next line contains the string B.
    Next Q lines contains an integer i (1 - based indexing)

Output Format

For each query, print the desired output in a new line.

Input Constraints
 , 

Sample Input

5 5

11111

00010

1

2

3

4

5

Sample Output

NO

NO

NO

NO

YES

Explanation

After 1st query: B = 10010. B < A. (NO)
After 2nd query: B = 11010. B < A. (NO)
After 3rd query: B = 11110. B < A. (NO)
After 4th query: B = 11110. B < A. (NO)
After 5th query: B = 11111. B = A. (YES)
*/
