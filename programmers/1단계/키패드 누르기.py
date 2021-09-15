

def solution(numbers, hand):
    leftThumb = 10
    rightThumb = 12
    answer = ''
    for i in numbers:
        if i == "*":
            i = 10
        if i == "#":
            i == 12
        if i == 0:
            i = 11
        if i == 1 or i == 4 or i == 7:
            answer += 'L'
            leftThumb = i
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            rightThumb = i
        else:
            position = i
            if hand == "right":
                while 1:
                    if position == rightThumb or position - 3 == rightThumb or position + 3 == rightThumb:
                        rightThumb = i
                        answer += 'R'
                        break
                    elif position + 1 == rightThumb:
                        rightThumb = i
                        answer += 'R'
                        break
                    elif position - 3 == leftThumb or position + 3 == leftThumb:
                        leftThumb = i
                        answer += 'L'
                        break
                    elif position - 1 == leftThumb:
                        leftThumb = i
                        answer += 'L'
                        break
                    if position >= 10:
                        position -= 3
                    else:
                        position += 3
            elif hand == "left":
                while 1:
                    if position == leftThumb or position - 3 == leftThumb or position + 3 == leftThumb:
                        leftThumb = i
                        answer += 'L'
                        break
                    elif position - 1 == leftThumb:
                        leftThumb = i
                        answer += 'L'
                        break
                    elif position - 3 == rightThumb or position + 3 == rightThumb:
                        rightThumb = i
                        answer += 'R'
                        break
                    elif position + 1 == rightThumb:
                        rightThumb = i
                        answer += 'R'
                        break
                    if position >= 10:
                        position -= 9
                    else:
                        position += 3
    return answer

print(solution([2,5,8,0],"right"))