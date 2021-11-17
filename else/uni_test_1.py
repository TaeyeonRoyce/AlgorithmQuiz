N = int(input())
M = int(input())
price = [5000, 10000, 15000, 20000, 30000, 50000]

totalPrice = price[N-1]*M

if (M > 20):
    print(int(totalPrice*1.1))
    print(int(totalPrice*0.1))
else:
    print(totalPrice)
    print(0)
