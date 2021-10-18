def solution(E, S, M):
    answer = 0
    _E, _S, _M = 0, 0, 0
    while 1:
        _E += 1
        if _E > 15:
            _E = 1
        _S += 1
        if _S > 28:
            _S = 1
        _M += 1
        if _M > 19:
            _M = 1
        answer += 1
        if _E == E and _S == S and _M == M:
            return answer
E, S, M = map(int, input().split())
print(solution(E,S,M))