totalPrice = []
failNum = 0 

price = [5000, 10000, 15000, 20000, 30000, 50000]
for i in range(6):
    N = int(input())
    if (N < 10):
        priceAmount = int((N * price[i])*1.05)
    elif (N < 20):
        priceAmount = int((N * price[i])*1.1)
    elif (N < 50):
        priceAmount = int((N * price[i])*1.2)
    elif (N < 100):
        priceAmount = int((N * price[i])*1.3)
    else:
        priceAmount = int((N * price[i])*1.5)
    failNum += N
    totalPrice.append(priceAmount)
maxPrice = max(totalPrice)
print(sum(totalPrice))
print(totalPrice.index(maxPrice) + 1)
print(maxPrice)
print(int(sum(totalPrice)/(456-failNum)))


