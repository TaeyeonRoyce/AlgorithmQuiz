import sys
M = int(input())
arr = [False]*20
for _ in range(M):
    cmd = sys.stdin.readline().split()
    if cmd[0] == "all":
        for i in range(20):
            arr[i] = True
        continue
    elif cmd[0] == "empty":
        for i in range(20):
            arr[i] = False
        continue
    
    x = int(cmd[1])-1
    if cmd[0] == "add":
        if arr[x] == False:
            arr[x] = True
    elif cmd[0] == "remove":
        if arr[x] == True:
            arr[x] = False
    elif cmd[0] == "check":
        if arr[x] == True:
            print(1)
        elif arr[x] == False:
            print(0)
    elif cmd[0] == "toggle":
        if arr[x] == False:
            arr[x] = True
        elif arr[x] == True:
            arr[x] = False