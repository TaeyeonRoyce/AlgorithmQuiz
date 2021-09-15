def solution(absolutes, signs):
    ans = 0
    for i in range(len(absolutes)):
        if signs[i]:
            ans += absolutes[i]
        else:
            ans -= absolutes[i]

    return ans




absolutes = [1,2,3]
signs =[False,False,True]
print(solution(absolutes,signs))
