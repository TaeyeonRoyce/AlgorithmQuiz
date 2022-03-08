def solution2(a,b):
    result = []
    if a[0]*b[1] - a[1]*b[0] == 0:
        return False
    result.append((a[1]*b[2] - a[2]*b[1])/(a[0]*b[1] - a[1]*b[0]))
    result.append((a[2]*b[0] - a[0]*b[2])/(a[0]*b[1] - a[1]*b[0]))
    if result[0] != int(result[0]) or result[1] != int(result[1]):
        return False
    else:
        result[0]=int(result[0])
        result[1]=int(result[1])
    return result

def Boj_Solution(line):
    xRange = []
    yRange = []
    answer = []
    maxRange = len(line)
    for i in range(maxRange-1):
        for j in range(i+1,maxRange):
            result = solution2(line[i],line[j])
            if result == False:
                continue
            else:
                answer.append(result)
                xRange.append(result[0])
                yRange.append(result[1])
    board = []
    yBoardRange = min(int(max(yRange)-min(yRange)+1),1000)
    xBoardRange = min(int(max(xRange)-min(xRange)+1),1000)
    for i in range(yBoardRange):
        board.append(["."]*(xBoardRange))
    for i in answer:
        x = i[0] + max(xRange) 
        y = max(yRange) - i[1]
        board[y][x] = "*"
    answerB = []
    for i in board:
        answerB.append("".join(i))
    return answerB

print(Boj_Solution([[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]))