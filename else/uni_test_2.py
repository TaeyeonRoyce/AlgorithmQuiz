totalPrice = 0
failNum = 0 

price = [5000, 10000, 15000, 20000, 30000, 50000]
for i in range(6):
    N = int(input())
    if (N >= 20):
        totalPrice += int((N * price[i])*1.1)
    else:
        totalPrice += N * price[i]
    failNum += N
print(totalPrice)
print(int(totalPrice/(456-failNum)))


