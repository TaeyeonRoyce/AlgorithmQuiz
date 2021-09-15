
def checkHead(a,b):
    if len(b) <= len(a):
        if a.startswith(b):
            return False
    else:
        if b.startswith(a):
            return False
    return True



def solution(phone_book):
    phone_book.sort()
    answer = True
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    
    # for i in range(len(phone_book)-1):
    #     for j in range(i+1,len(phone_book)):
    #         if phone_book[i][0] != phone_book[j][0]:
    #             pass
    #         else : 
    #             answer = checkHead(phone_book[i],phone_book[j])
    #         if answer == False:
    #             return answer
    return answer

print(solution([["123","456","789"]]))
