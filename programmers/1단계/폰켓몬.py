def Boj_Solution(nums):
    k = len(nums)//2
    nums = list(set(nums))
    if len(nums) >= k:
        return k
    return len(nums)