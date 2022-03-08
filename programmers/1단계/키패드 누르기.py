def calDistance(currentLocation, target):
    targetLocation = [(target-1) // 3, (target-1) % 3]
    if target == 0:
        targetLocation = [3,1]
    distance = abs(currentLocation[0] - targetLocation[0])+ abs( currentLocation[1] - targetLocation[1])
    return distance



def Boj_Solution(numbers, hand):
    currentLeft = [3,0]
    currentRight = [3,2]
    answer = ""
    for i in numbers:
        if i == 0:
            i = 11
        if i == 1 or i == 4 or i == 7:
            answer += "L"
        elif i == 3 or i == 6 or i == 9:
            answer += "R"
        elif i == 2 or i == 5 or i == 8 or i == 11:
            fromLeft = calDistance(currentLeft, i)
            fromRight = calDistance(currentRight, i)
            if fromLeft > fromRight:
                answer += "R"
            elif fromLeft < fromRight:
                answer += "L"
            elif fromLeft == fromRight:
                if hand == "right":
                    answer += "R"
                elif hand == "left":
                    answer += "L"
        usedHand = answer[-1]
        if usedHand == "L":
            currentLeft = [(i-1) // 3, (i-1) % 3]
        elif usedHand == "R":
            currentRight = [(i-1) // 3, (i-1) % 3]
    return answer

print(Boj_Solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))