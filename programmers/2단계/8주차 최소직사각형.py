def Boj_Solution(sizes):
    maxH = 0
    maxW = 0
    for i in sizes:
        w = i[0]
        h = i[1]
        if i[0] < i[1]:
            w = i[1]
            h = i[0]
        if maxW < w:
            maxW = w
        if maxH < h:
            maxH = h

    return maxH*maxW

print(Boj_Solution([[60, 50], [30, 70], [60, 30], [80, 40]]))