def Boj_Solution(s, n):
    s = list(s)
    answer = ''
    for i in s:
        charNum = ord(i)
        if i == " ":
            answer += i
        elif charNum < 91:
            charNum += n
            if charNum > 90:
                charNum -= 26
            answer += chr(charNum)
        elif charNum < 123:
            charNum += n
            if charNum > 122:
                charNum -= 26
            answer += chr(charNum)
    return answer