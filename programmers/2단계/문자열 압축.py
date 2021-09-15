# def slicing(s,n):
#     newLs = []
#     s = list(s)
#     shrinked_list = []
#     cnt = 1
#     for i in range(0,len(s)-n+1,n):
#         k = (''.join(s[i:i+n]))
#         newLs.append(k)

#     for i in range(len(newLs)-1):
        
#         if newLs[i] != newLs[i+1] or i == len(newLs)-2:
#             while cnt >= 10:
#                 shrinked_list.append(cnt%10)
#                 cnt //= 10
#             shrinked_list.append(cnt)
#             shrinked_list.append(newLs[i])
#             cnt = 1
#         else:
#             cnt += 1
#             pass
#     return len(shrinked_list)
#     # removed += removed
#     # shrinked_len = removed*n
#     # return lenBefore - shrinked_len + len(shrinked_type)

# def solution(s):
#     lenghtLs = []
#     for i in range(1,int(len(s)/2)+1):
#         shrinkedLenght = slicing(s,i)
#         lenghtLs.append(shrinkedLenght)
#     return min(lenghtLs)



# def slicing(s,n):
#     newLs = []
#     s = list(s)
#     lenBefore = len(s)
#     shrinked_type = []
#     removed = 0
#     nums = 0
#     cnt = 1
#     if n == 1:
#         newLs = s
#     else:
#         for i in range(0,len(s)-n+1,n):
#             k = (''.join(s[i:i+n]))
#             newLs.append(k)
#     for i in range(len(newLs)-1):
#         if newLs[i] != newLs[i+1]:
#             cnt = 0
#             shrinked_type.append(newLs[i+1])
#         elif newLs[i] == newLs[i+1]:
#             cnt += 1
#             removed += 1
#             if newLs[i] in shrinked_type:
#                 pass
#             else :
#                 shrinked_type.append(newLs[i])
#         if cnt >= 10:
#                 while cnt >= 10:
#                     nums += 1
#                     cnt /= 10
#     shrinked_len = removed*n 
#     return lenBefore - shrinked_len + len(shrinked_type) + nums

# def solution(s):
#     if len(s) == 1:
#         return 1
#     lenghtLs = []
#     for i in range(1,int(len(s)/2)+1):
#         shrinkedLenght = slicing(s,i)
#         lenghtLs.append(shrinkedLenght)
#     return min(lenghtLs)

def slicing(s,n):
    newLs = []
    s = list(s)
    shrinked_type = []
    anslen = ''
    cnt = 1
    if n == 1:
        newLs = s
    else:
        for i in range(0,len(s),n):
            k = (''.join(s[i:i+n]))
            newLs.append(k)
    for i in range(len(newLs)-1):
        if i == len(newLs) - 2:
            if newLs[i] == newLs[i+1]:
                cnt += 1
                shrinked_type.append(str(cnt))
                shrinked_type.append(newLs[i])
            elif newLs[i] != newLs[i+1]:
                if cnt > 1:
                    shrinked_type.append(str(cnt))
                shrinked_type.append(newLs[i])
                shrinked_type.append(newLs[i+1])
        else:
            if newLs[i] == newLs[i+1]:
                cnt += 1
            elif newLs[i] != newLs[i+1]:
                if cnt > 1:
                    shrinked_type.append(str(cnt))
                shrinked_type.append(newLs[i])
                cnt = 1
    anslen = (''.join(shrinked_type))
    return len(anslen)

def solution(s):
    if len(s) == 1:
        return 1
    lenghtLs = []
    for i in range(1,int(len(s)/2)+1):
        shrinkedLenght = slicing(s,i)
        lenghtLs.append(shrinkedLenght)
    return min(lenghtLs)