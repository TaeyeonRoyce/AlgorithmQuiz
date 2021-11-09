T = int(input())
for _ in range(T):
    
    N = int(input())
    if N == 0:
        print(1,0)
    else:
        memoZero = [0]*N
        memoOne = [0]*N
        memoZero[0] = 0
        memoOne[0] = 1
        for i in range(1,N):
            memoZero[i] = memoOne[i-1]
            memoOne[i] = memoOne[i-1] + memoZero[i-1]
        print(memoZero[-1], memoOne[-1])