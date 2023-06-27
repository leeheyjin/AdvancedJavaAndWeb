from random import random


def ranCom():
    arr = list(range(1, 9 + 1))
    for i in range(1000):
        r = int(random() * 9)
        temp = arr[0]
        arr[0] = arr[r]
        arr[r] = temp
    return str(arr[0]) + str(arr[1]) + str(arr[2])


com = ranCom()


def getS(com, mine):
    result = 0
    c1 = com[0:1]
    c2 = com[1:2]
    c3 = com[2:3]
    
    m1 = mine[0:1]
    m2 = mine[1:2]
    m3 = mine[2:3]
    
    if c1 == m1:
        result += 1
    if c2 == m2:
        result += 1
    if c3 == m3:
        result += 1
    return result


def getB(com, mine):
    result = 0
    c1 = com[0:1]
    c2 = com[1:2]
    c3 = com[2:3]
    
    m1 = mine[0:1]
    m2 = mine[1:2]
    m3 = mine[2:3]
    
    if c1 == m2 or c1 == m3:
        result += 1
    if c2 == m1 or c2 == m3:
        result += 1
    if c3 == m1 or c3 == m2:
        result += 1
    return  result


while True:
    mine = input("숫자 세개를 띄어쓰기 없이 입력하세요 ")
    s = getS(com, mine)
    b = getB(com, mine)
    if s == 3:
        print("정답입니다. 프로그램을 종료합니다.")
        break;
    print(mine + "의 결과는 " + str(s) + "s," + str(b) + "b입니다.")
    continue;

    
