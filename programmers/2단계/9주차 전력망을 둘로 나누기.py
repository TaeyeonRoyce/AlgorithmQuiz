def Boj_Solution(n, wires):
    memo = [1]*(len(wires))
    for i in range(len(wires)-1,0,-1):
        prenode = wires[i][0] - 1
        memo[prenode-1] = memo[prenode-1] + memo[i]
    newMemo = list(map(lambda x : abs((n - x) - x),memo))
    answer = min(newMemo)
    return answer

print(Boj_Solution(6,[[1, 4], [6, 3], [2, 5], [5, 1], [5, 3]]))