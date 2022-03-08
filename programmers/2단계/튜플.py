def Boj_Solution(s):
    answer = []
    types = []
    a = {}
    s = s.replace("{" , "")
    s = s.replace("}", "")
    s = s.split(",")
    types = list(set(s))
    for i in range(len(types)):
        a[s.count(types[i])] = types[i]
    for i in range(len(types),0,-1):
        answer.append(int(a[i]))
    return answer

# def Boj_Solution(s):
#     # {{, }}를 제거 후 },{ 으로 나누기
#     data = s[2:-2].split("},{")
#     # 길이 별로 오름차순 정렬
#     data = sorted(data, key=lambda x: len(x))
#     print(data)



print(Boj_Solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))