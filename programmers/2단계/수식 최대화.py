def sepNumAndOper(s):
    s = list(s)
    newLs = []
    cnt = -1
    num = 0
    for i in range(len(s)):
        cnt += 1
        if s[i] == '+' or s[i] == '-' or s[i] =='*':
            k = cnt
            for j in range(i-cnt,i):
                s[j] = int(s[j])
                num += s[j]*(10**(k-1))
                k -= 1
            newLs.append(num)
            newLs.append(s[i])
            num = 0
            cnt = -1
        if i == len(s)-1:
            k = cnt+1
            if k == 1:
                newLs.append(int(s[i]))
            else:
                for j in range(i-cnt,i+1):
                    s[j] = int(s[j])
                    num += s[j]*(10**(k-1))
                    k -= 1
                newLs.append(num)
    return newLs

def calMulti(expression):
    finalLs = expression
    i = 0
    while '*' in finalLs:
        i += 1
        if finalLs[i] == '*':
            k = finalLs[i-1]*finalLs[i+1]
            newLs = []
            newLs = finalLs[:i-1]
            newLs.append(k)
            newLs += finalLs[i+2:]
            finalLs = newLs
            i = 0
    return finalLs

def calMinus(expression):
    finalLs = expression
    i = 0
    while '-' in finalLs:
        i += 1
        if finalLs[i] == '-':
            k = finalLs[i-1]-finalLs[i+1]
            newLs = []
            newLs = finalLs[:i-1]
            newLs.append(k)
            newLs += finalLs[i+2:]
            finalLs = newLs
            i = 0
    return finalLs

def calPlus(expression):
    finalLs = expression
    i = 0
    while '+' in finalLs:
        i += 1
        if finalLs[i] == '+':
            k = finalLs[i-1]+finalLs[i+1]
            newLs = []
            newLs = finalLs[:i-1]
            newLs.append(k)
            newLs += finalLs[i+2:]
            finalLs = newLs
            i = 0
    return finalLs


def solution(expression):
    expression = sepNumAndOper(expression)
    newls = []
    answersheet = [['+','-','*'],['+','*','-'],['-','*','+'],['-','+','*'],['*','-','+'],['*','+','-']]
    for i in answersheet:
        init = expression
        for j in range(3):
            if i[j] == '+':
                init = calPlus(init)
            elif i[j] == '*':
                init = calMulti(init)
            else:
                init = calMinus(init)
        newls.append(init[0])
    
    print(newls)
    for i in range(len(newls)):
        if newls[i] < 0:
            newls[i] = (-1)*newls[i]
    return max(newls)

print(solution("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99"))

