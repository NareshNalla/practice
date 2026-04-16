class MergeSortedArray:
    def merge(self, nums1: List[int], m: int, nums2 : List[int], n : int) -> None:
        #last index num1
        last = m + n -1
        #merge in reverse order
        while m>0 and n>0:
            if num1[m -1] > num2[n-1 ]:
                num1[last] = num1 [m-1]
                m -= 1
        else:
            num1[last] = num2[n-1]
            n -= 1
        last -=1
    #fill num1 with leftover num2 elements
        while n>0:
            num1[last] = num2[n-1]
            n, last = n-1 , last -1
