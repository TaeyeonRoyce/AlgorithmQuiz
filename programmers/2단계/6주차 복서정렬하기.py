def Boj_Solution(weights, head2head):
    boxerData= []
    for i in range(len(weights)):
        boxerDataDummy= [0,0,weights[i],i+1]
        N = 0
        for j in range(len(head2head[i])):
            if head2head[i][j] == "N":
                N += 1
            elif head2head[i][j] == "W":
                boxerDataDummy[0] += 1
                if weights[i] < weights[j]:
                    boxerDataDummy[1] += 1
        if len(head2head[i])-N == 0 :
            boxerDataDummy[0] = 0
        else:
            boxerDataDummy[0] = (boxerDataDummy[0]/(len(head2head[i])-N))
        boxerData.append(boxerDataDummy)
    answer = sorted(boxerData, key = lambda x: (-x[0], -x[1],-x[2],x[3]))
    answer = list(map(lambda x: x[-1],answer))
    return answer


print(Boj_Solution([145,92,86], ["NLW","WNL","LWN"]))

