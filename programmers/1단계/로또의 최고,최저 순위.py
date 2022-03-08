

def Boj_Solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    unknown = lottos.count(0)
    if unknown > 4:
        unknown -= 1
    sameNum = 0
    min_rank = 6
    for i in win_nums:
        k = lottos.count(i)
        if k == 1:
            sameNum += 1
    if sameNum < 2 :
        min_rank = 6
    else:
        min_rank =  7 - sameNum 
    answer.append(min_rank - unknown)
    answer.append(min_rank)
    return answer
    


lottos = [0,0,0,0,0,0]
win_nums = [31,10,45,1,6,19]
print(Boj_Solution(lottos,win_nums))

# def Boj_Solution(lottos, win_nums):

#     rank=[6,6,5,4,3,2,1]

#     cnt_0 = lottos.count(0)
#     ans = 0
#     for x in win_nums:
#         if x in lottos:
#             ans += 1
#     return rank[cnt_0 + ans],rank[ans]