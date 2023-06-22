# 첫 수를 입력하세요 1 
firstNo = int(input("첫번째 숫자를 입력하세요: "))
# 끝 수를 입력하세요 10 
lastNo = int(input("두번재 숫자를 입력하세요: "))
# 배수를 입력하세요 5 
multipleNo = int(input("배수를 입력하세요: "))
# 1에서 10까지 5의 배수의 합은 15입니다. #
arr = range(firstNo, lastNo+1)
result = 0;
for i in arr:
    if (i % multipleNo == 0):
        result += i
print(result)
    
