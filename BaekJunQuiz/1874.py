import sys

def checkList(data,n):   #check data is available
    maxNumIndex = data.index(n)  #get index of max number
    for i in range(maxNumIndex):    #until max number
        if data[i] < data[i+1] or data[i] - 1 == data[i+1]:   
        #list should be ascending before max number
        #or descending with 1 gap
            continue
        else: 
            return False

    for i in range(maxNumIndex,len(data) - 1): #after max number, list should be descending
        if data[i] < data[i+1]:
            return False

    return True

n = int(sys.stdin.readline())
data = [int(sys.stdin.readline().strip()) for i in range(n)]
availableData = checkList(data,n)

if availableData: #if data True
    stack = [] 
    cursor = 0
    i = 1
    while i < n+1: #push until max number
        if len(stack) != 0 and stack[-1] == data[cursor]:  #last index of stack == data[cursor], pop()
            cursor += 1
            stack.pop()
            print("-")
        else:
            stack.append(i) 
            i += 1
            print("+")
    for i in range(len(stack)): #after pushing all numbers, pop indexes of stack
        print("-")
else:
    print("NO")
