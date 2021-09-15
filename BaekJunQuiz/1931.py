def countingRooms(cursor, ls):
    cnt = 1
    next = ls[cursor][1] + 1
    while cursor < len(ls):
        if ls[cursor][0] == next:
            cnt += 1
            next = ls[cursor][1] + 1
        cursor += 1
    return cnt


    
    
roomCount = int(input())
rooms = []
# for i in range(roomCount):
#     rooms.append(list(map(int,input().split())))
rooms.sort()




print(countingRooms(4,[[1, 2], [2, 3], [3, 4], [4, 7], [5, 6], [5, 9], [6, 12], [7, 9], [10, 13]]))


