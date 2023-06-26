# 첫수를 입려하세요
num1 = int(input("첫번재 숫자를 입력하세요: "))
# 끝수를 입려하게요
num2 = int(input("두번째 숫자를 입력하세요: "))
# ex) 7은 9보다 2만큼 크다
if (num1 > num2):
    print("{}은 {}보다 {}만큼 큽니다".format(num1, num2, num1-num2))
    print("{}은 {}보다 {}만큼 작습니다".format(num2, num1, num1-num2))
elif (num1 < num2):
    print("{}은 {}보다 {}만큼 작습니다".format(num1, num2, num2-num1))
    print("{}은 {}보다 {}만큼 큽니다".format(num2, num1, num2-num1))
else:
    print("같은 숫자입니다")
