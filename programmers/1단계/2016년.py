def solution(a, b):
    days = 0
    dayType = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    if a == 1:
        days = b - 1
        return dayType[days%7]
    for i in range(2,a+1):
        if i == 3:
            days += 29
        elif i == 4 or i == 6 or i == 8 or i == 9 or i == 11:
            days += 31
        else:
            days += 30
        
    days += b
    return dayType[days%7]

print(solution(10,26))

