from itertools import combinations

N, M = map(int, input().split())
storeLocation = []
houseLocation = []
for i in range(N):
    K = []
    K = list(map(int, input().split()))
    for j in range(len(K)):
        if K[j] == 2:
            storeLocation.append([i,j])
        elif K[j] == 1:
            houseLocation.append([i,j])

def calcDis(houseLocation, storeLocation):
    totalDis = 0
    for i in range(len(houseLocation)):
        currentHouse = houseLocation[i]
        dis = []
        for j in storeLocation:
            dis.append(abs(currentHouse[0]-j[0]) + abs(currentHouse[1]-j[1]))
        shortDis = int(min(dis))
        for j in dis:
            if j == shortDis:
                totalDis += j
    return totalDis

sortedStores = list(combinations(storeLocation,M))
answer = []
for i in sortedStores:
    answer.append(calcDis(houseLocation, i))
print(min(answer))

