def convertWeird(s):
    cnt = 0
    converted = ''
    for i in s:
        # if i.isalpha():
        if cnt % 2 == 0:
            converted += i.upper()
        else :
            converted += i.lower()
        cnt += 1
        # else:
        #     converted += i
    return converted


# def Boj_Solution(s):
#     answer = ''
#     wordList = s.split(' ')
#     for i in wordList:
#         answer = answer + convertWeird(i) + ' '
#     if s[-1] == ' ':
#         return answer 
        
#     else:
#         return answer.rstrip()

def Boj_Solution(s):
    answer = ''
    c = 0
    for i in s:
        if i!=' ':
            if c%2==0:
                answer += i.upper()
            else:
                answer += i.lower()
            c += 1
        else:
            answer += i
            c = 0

    return answer


print(Boj_Solution("""try  asdf
tasd tiq tQWER RQts"""))